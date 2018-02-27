package com.jfpay;

import com.jfpay.core.server.IServer;
import com.jfpay.core.server.ThriftServer;
import com.jfpay.core.setting.ServerList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class Main {

    private static Logger log= LoggerFactory.getLogger(Main.class);

    static{
        //加载spring
        log.info("--------载入spring配置文件---------");
        File directory = new File("");//设定为当前文件夹
        log.info("当前程序路径:{}",directory.getAbsolutePath());//获取绝对路径
        String filepath=directory.getAbsolutePath();
        ServerList.setCtx(new ClassPathXmlApplicationContext("spring/applicationContext*.xml"));
        log.info("--------载入spring配置文件完成---------");
    }

    public static void main(String[] args) throws Exception{

        Integer serverNum = ServerList.getServerNum();
//        IServer iServer=(IServer)SystemInfo.getCtx().getBean("basicServer");
//        iServer.start();
        for(int serverno=0;serverno<serverNum;serverno++){

            new Thread(new Main().new ServerThread(serverno)).start();
            log.info("单次启动server开始。。。");
        }
        new Thread(new ThriftServer()).start();
        log.info("thrift启动中..");
    }

    /**
     *
     * 类说明
     * @Description: 内部类，并发启动server用
     */
    class ServerThread implements Runnable{
        int serverNo=0;

        public ServerThread(int serverNo){
            this.serverNo = serverNo;
        }

        @Override
        public void run() {
            try {
                IServer iServer = (IServer) ServerList.getCtx().getBean("basicServer");
                iServer.start(serverNo);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                log.error("error when startup server thread to create new server["+ serverNo+"]", e);
            }
        }
    }


}
