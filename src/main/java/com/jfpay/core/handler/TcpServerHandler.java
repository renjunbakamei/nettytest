package com.jfpay.core.handler;

import com.jfpay.core.Exception.BizException;
import com.jfpay.core.constant.ImpRespCode;
import com.jfpay.core.domain.to.ResultDataTO;
import com.jfpay.core.util.JsonUtil;
import com.jfpay.core.util.MethodInvokeUtil;
import com.jfpay.test.SocketClient;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.Date;


@ChannelHandler.Sharable
@Service
@Scope("prototype")
public class TcpServerHandler extends ChannelInboundHandlerAdapter {

    private static Logger log = LoggerFactory.getLogger(TcpServerHandler.class);

    @Autowired
    private MethodInvokeUtil methodInvokeUtil;

//    @Autowired
//    private TcpSer

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Date start = new Date();
        log.info("接受到TCP请求，开始读取数组数据...");
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String msgstring= new String(req,"utf-8");
        log.info("读取数组数据完成，交付由业务处理...");
        log.info(msgstring);
        ResultDataTO resultDataTO=new ResultDataTO();
        String returnMsg="";
        try {
            returnMsg = methodInvokeUtil.invoke(msgstring);
            resultDataTO.setCode(ImpRespCode.RESULT_SUCCESS.getResultCode());
            resultDataTO.setMsg(ImpRespCode.RESULT_SUCCESS.getResultMsg());
            resultDataTO.setData(returnMsg);
        }
        catch (BizException be) {
            be.printStackTrace();
            resultDataTO.setCode(be.getErrorCode());
            resultDataTO.setMsg(be.getErrorMessage());
        }
        catch (Exception e){
            e.printStackTrace();
            resultDataTO.setCode(ImpRespCode.SYSTEM_ERRROR.getResultCode());
            resultDataTO.setMsg(ImpRespCode.SYSTEM_ERRROR.getResultMsg());
        }
        ReferenceCountUtil.release(msg);//释放byteBuf
        buf.clear();
//        byte[] returnMsg = "完成了哈哈".getBytes();
        String json= "jfpal-"+JsonUtil.toJson(resultDataTO);
        log.info("业务处理完成，返回结果...");
        log.info("返回结果"+json);
        if (returnMsg != null) {
            ByteBuf resp = Unpooled.copiedBuffer(json.getBytes());
            ctx.writeAndFlush(resp);
        }
        Date end = new Date();
        int seconds = SocketClient.getSeconds(start, end);
        log.info("-------耗时{}s",seconds);
        log.info("结果返回完成...");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (ctx != null) {
            log.error("Tcp 请求中发生异常", cause);
            try {
                log.info("关闭业务流程开始...");
                //TODO 关闭业务流程
            } catch (Exception e) {
                log.error("无法正常关闭业务流程", e);
            }
            log.info("开始检查channel是否存活...");
            if (ctx.channel().isActive()) {
                ctx.close();
                log.info("channel存活,开始关闭...");
            } else {
                log.info("channel已关闭，处理结束...");
            }
        }

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        // TODO Auto-generated method stub
        super.channelReadComplete(ctx);
        ctx.flush();

    }
}
