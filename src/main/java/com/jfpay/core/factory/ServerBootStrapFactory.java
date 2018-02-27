package com.jfpay.core.factory;


import com.jfpay.core.constant.ChannelType;
import com.jfpay.core.setting.ServerList;
import com.jfpay.core.setting.SystemInfo;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

public class ServerBootStrapFactory {
    private ServerBootStrapFactory(){}

    public static ServerBootstrap createServerBootstrap(int serverNo) throws UnsupportedOperationException{
        SystemInfo serverInfo = ServerList.getSystemInfo(serverNo);
        ServerBootstrap serverBootstrap=new ServerBootstrap();
        switch (serverInfo.getChannelType()){
            case ChannelType.NIO_SOCKET:
                EventLoopGroup bossGroup=new NioEventLoopGroup();
                EventLoopGroup workerGroup=new NioEventLoopGroup();
                serverBootstrap.group(bossGroup,workerGroup);
                serverInfo.setBossGroup(bossGroup);
                serverInfo.setWorkerGroup(workerGroup);
                serverBootstrap.channel(NioServerSocketChannel.class);
                return serverBootstrap;
            case ChannelType.OIO_SOCKET:
                serverBootstrap.group(new OioEventLoopGroup());
                serverBootstrap.channel(OioServerSocketChannel.class);
                return serverBootstrap;
            default:
                throw new UnsupportedOperationException(String.format("创建serverBootstrap失败,%s类型不支持",serverInfo.getChannelType()));
        }

    }
}
