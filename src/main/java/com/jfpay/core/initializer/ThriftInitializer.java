package com.jfpay.core.initializer;

import com.jfpay.core.constant.ProtocolType;
import com.jfpay.core.setting.ServerList;
import com.jfpay.core.setting.ThriftRegistryInfo;
import com.jfpay.generated.CertifacationService;
import com.jfpay.service.impl.CertifacationServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThriftInitializer{

    private final static Logger logger= LoggerFactory.getLogger(ThriftInitializer.class);

    @Autowired
    private ZookeeperRegistry zookeeperRegistry;

    public  void startserver() throws TTransportException {

//        Class Processor=Class.forName()
        logger.info("thrift启动");
        TProcessor tprocessor = new CertifacationService.Processor<CertifacationService.Iface>((CertifacationServiceImpl)ServerList.getCtx().getBean("certifacationServiceImpl"));
//        TProcessor tprocessor = new CertifacationService.Processor<CertifacationService.Iface>(new CertifacationServiceImpl());
        // 传输通道 - 非阻塞方式
        TNonblockingServerSocket serverTransport = new TNonblockingServerSocket(ThriftRegistryInfo.getPort());
        //多线程半同步半异步
        TThreadedSelectorServer.Args tArgs = new TThreadedSelectorServer.Args(serverTransport);
        tArgs.processor(tprocessor);
        Long BufferBytesLength=1024 * 1024L;
        logger.info("thriftserver 最大缓存大小:{}",BufferBytesLength);
        tArgs.maxReadBufferBytes = BufferBytesLength;
        tArgs.transportFactory(new TFramedTransport.Factory());
        //二进制协议
        tArgs.protocolFactory(new TBinaryProtocol.Factory());
        // 多线程半同步半异步的服务模型
        TServer server = new TThreadedSelectorServer(tArgs);
        System.out.println("HelloTThreadedSelectorServer start....");

        zookeeperRegistry.register(ProtocolType.THRIFT,ThriftRegistryInfo.getPort());
        server.serve(); // 启动服务
        logger.info("thrift启动完成");


    }


}
