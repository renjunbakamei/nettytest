package com.jfpay.core.factory;

import com.jfpay.core.Exception.SysErrException;
import com.jfpay.core.initializer.ZookeeperRegistry;
import com.jfpay.core.setting.MethodMap;
import com.jfpay.core.setting.ServerList;
import com.jfpay.core.setting.SystemInfo;
import com.jfpay.core.constant.ProtocolType;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ServerChannelFactory {

    private static Logger log= LoggerFactory.getLogger(ServerChannelFactory.class);

//    @Autowired
//    private TcpChannelInitializer tcpChannelInitializer;

    @Autowired
    private ZookeeperRegistry zookeeperRegistry;

    public Channel createAcceptorChannel(int serverNo) throws SysErrException{

        SystemInfo serverInfo = ServerList.getSystemInfo(serverNo);

        final ServerBootstrap serverBootstrap= ServerBootStrapFactory.createServerBootstrap(serverNo);
        serverBootstrap.childHandler(getChildHandler(serverInfo,ServerList.getCtx())).option(ChannelOption.SO_BACKLOG,128)
        .childOption(ChannelOption.SO_KEEPALIVE,true);
        log.info("创建server,类型{}...",serverInfo.getProtocolType());
        try{
            ChannelFuture channelFuture=serverBootstrap.bind(serverInfo.getPort()).sync();
            channelFuture.awaitUninterruptibly();
            if(channelFuture.isSuccess()){
                serverInfo.printSysInfo();
                MethodMap.pringMethodMap();
//                zookeeperRegistry.register(serverInfo.getProtocolType(),serverInfo.getPort());
                return channelFuture.channel();
            }else{
                String errMsg="建立socket失败！不能绑定端口:"+serverInfo.getPort();
                log.error(errMsg);
                throw new SysErrException(errMsg);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new SysErrException(e);
        }
    }

    //后期如果支持多协议可以修改这里
    private static ChannelInitializer<SocketChannel> getChildHandler(SystemInfo serverInfo, ApplicationContext ctx) throws SysErrException{
        if(ProtocolType.HTTP.equals(serverInfo.getProtocolType())
                ||ProtocolType.HTTPS.equals(serverInfo.getProtocolType().trim().toUpperCase())){
            return (ChannelInitializer<SocketChannel>)ctx.getBean("httpChannelInitializer");
        }

        else if(ProtocolType.TCP.equals(serverInfo.getProtocolType().trim().toUpperCase()))
            return (ChannelInitializer<SocketChannel>)ctx.getBean("tcpChannelInitializer");

//        else if(ProtocolType.CUSTOM.equals(serverInfo.getProtocolType()))
//            return (ChannelInitializer<SocketChannel>)SystemInfo.getCtx().getBean("customServerInitializer");

        else{
            String errMsg="undefined protocol:"+serverInfo.getProtocolType()+"!";
            throw new SysErrException(errMsg);
        }
    }

}
