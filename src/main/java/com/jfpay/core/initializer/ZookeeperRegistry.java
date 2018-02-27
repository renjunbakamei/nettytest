package com.jfpay.core.initializer;

import com.jfpay.core.setting.ZookeeperRegistryInfo;
import com.jfpay.core.util.MurMurHashUtil;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

@Service
public class ZookeeperRegistry {

    private static final Logger logger = LoggerFactory.getLogger(ZookeeperRegistry.class);

    private ZkClient zkClient;

    public void register(String protocolType, int port){
        String host=getAllHostAddress();
        String root=getPath(ZookeeperRegistryInfo.getRoot());
        String dirPath=getDirPath(protocolType,ZookeeperRegistryInfo.getNodeName());
        Long macHash=getMacHash(host,port,protocolType);
        String childNode=getPath(String.valueOf(macHash));
        logger.info("向zookeeper中心注册当前服务...");
        zkClient=new ZkClient(ZookeeperRegistryInfo.getUrl(),
                ZookeeperRegistryInfo.getSessionTimeout(),ZookeeperRegistryInfo.getConnectionTimeout());
        if(!zkClient.exists(root)){
            zkClient.createPersistent(root);
        }
        if(!zkClient.exists(root+dirPath)){
            zkClient.createPersistent(root+dirPath);
        }
        if(zkClient.exists(root+dirPath+childNode)){
            zkClient.delete(root+dirPath+childNode);
        }

        zkClient.createEphemeral(root+dirPath+childNode,host+":"+port);
        logger.info("向zookeeper中心注册当前服务完成...");
    }

    Long getMacHash(String host,int port,String protocolType){
        StringBuffer sb=new StringBuffer();
        sb.append(host).append("-").append(port).append(protocolType);
        return MurMurHashUtil.hash(sb.toString());
    }

    String getAllHostAddress() {

        Enumeration netInterfaces= null;
        try {
            String os = System.getProperty("os.name");
            if(os.toLowerCase().startsWith("win")){
                InetAddress addr = InetAddress.getLocalHost();
                return addr.getHostAddress();
            }else {
//                netInterfaces = NetworkInterface.getNetworkInterfaces();
//                InetAddress ip = null;
//                String Address = null;
//                while (netInterfaces.hasMoreElements()) {
//                    NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
//                    System.out.println(ni.getName());
//                    ip = (InetAddress) ni.getInetAddresses().nextElement();
//                    System.out.println("ip.isSiteLocalAddress():" + ip.isSiteLocalAddress());
//                    System.out.println("ip.isLoopbackAddress():" + ip.isLoopbackAddress());
//                    System.out.println("ip.getHostAddress():" + ip.getHostAddress());
//                    if (ip.isSiteLocalAddress()
//                            && !ip.isLoopbackAddress()) {
//                        Address = ip.getHostAddress();
//                        return Address;
//                    }
//                }
                getLinuxLocalIp();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    String getDirPath(String protocolType,String nodeName){
        StringBuffer sb=new StringBuffer("/");
        sb.append(nodeName).append(".").append(protocolType);
        return sb.toString();
    }

    String getPath(String path){
        StringBuffer sb=new StringBuffer("/");
        sb.append(path);
        return sb.toString();
    }

    private String getLinuxLocalIp() throws SocketException {
        String ip = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if (!name.contains("docker") && !name.contains("lo")) {
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            String ipaddress = inetAddress.getHostAddress().toString();
                            if (!ipaddress.contains("::") && !ipaddress.contains("0:0:") && !ipaddress.contains("fe80")) {
                                ip = ipaddress;
                                System.out.println(ipaddress);
                            }
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            System.out.println("获取ip地址异常");
            ip = "127.0.0.1";
            ex.printStackTrace();
        }
        System.out.println("IP:"+ip);
        return ip;
    }


}
