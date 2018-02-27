package com.jfpay.core.initializer;

import com.jfpay.core.Exception.SysErrException;
import com.jfpay.core.handler.TcpServerHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
@Scope("prototype")
public class TcpChannelInitializer extends ChannelInitializer<SocketChannel> {

    private final static Logger logger=LoggerFactory.getLogger(TcpChannelInitializer.class);

//    private LinkedHashMap<String,ChannelHandler> customPipelineMap;
//
    @Autowired
    private TcpServerHandler tcpServerHandler;

    @Override
    protected void initChannel(SocketChannel socketChannel) throws SysErrException {
        ChannelPipeline pipeline=socketChannel.pipeline();
        /**
         第一个参数为信息最大长度，超过这个长度回报异常，第二参数为长度属性的起始（偏移）位，我们的协议中长度是0到第3个字节，
         所以这里写0，第三个参数为“长度属性”的长度，我们是4个字节，所以写4，第四个参数为长度调节值，在总长被定义为包含包头长度时，
         修正信息长度，第五个参数为跳过的字节数，根据需要我们跳过前4个字节，以便接收端直接接受到不含“长度属性”的内容。
         长度字节高位在前，低位在后，如：0x000C
         */

        pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
        pipeline.addLast("frameEncoder", new LengthFieldPrepender(4,false));
        pipeline.addLast("tcpHandler",tcpServerHandler);
    }

//    public LinkedHashMap<String, ChannelHandler> getCustomPipelineMap() {
//        return customPipelineMap;
//    }
//
//    public void setCustomPipelineMap(LinkedHashMap<String, ChannelHandler> customPipelineMap) {
//        this.customPipelineMap = customPipelineMap;
//    }
}
