package com.jfpay.core.server;

import com.jfpay.core.factory.ServerChannelFactory;
import com.jfpay.core.setting.ServerList;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicServer implements IServer {

    private Channel acceptorChannel;

    @Autowired
    ServerChannelFactory serverChannelFactory;

    public void start(int serverno) throws Exception {

        try{
            acceptorChannel=serverChannelFactory.createAcceptorChannel(serverno);
            acceptorChannel.closeFuture().sync();
        }finally {
            //优雅退出，释放线程组资源
            ServerList.shutDownGraceFully(serverno);
        }

    }

    public void stop(int serverno) throws Exception {

        try{
            if(acceptorChannel!=null){
                acceptorChannel.close().addListener(ChannelFutureListener.CLOSE);
            }
        }finally {
            //优雅推出，释放线程组资源
            ServerList.shutDownGraceFully(serverno);
        }

    }

    public void restart(int serverno) throws Exception {
        stop(serverno);
        start(serverno);
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }

    @Override
    public void restart() throws Exception {

    }
}
