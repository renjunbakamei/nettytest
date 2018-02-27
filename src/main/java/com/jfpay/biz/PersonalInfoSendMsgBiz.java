package com.jfpay.biz;

import com.jfpal.msg.entity.Message;
import com.jfpal.msg.entity.MsgHead;
import com.jfpay.core.util.JsonUtil;
import com.jfpay.utils.HttpURLRequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class PersonalInfoSendMsgBiz {
	
	final static Logger logger = LoggerFactory.getLogger(PersonalInfoSendMsgBiz.class);

	@Value("${remoteSmsContentUrl}")
	private String remoteSmsContentUrl;

	@Value("${sendContent}")
	private String sendContent;

	@Value("${msgServcode}")
	private String msgServcode;

	@Value("${msgProductId}")
	private String msgProductId;

	@Value("${msgAppuser}")
	private String msgAppuser;
	
	@Async
	public void sendMsg(String mobileNo) {
		logger.info("================实名认证短信通知:{}================",remoteSmsContentUrl+sendContent);

        Message msg = new Message();
        MsgHead msgHead = new MsgHead();
        msgHead.setLevel("0");
        msgHead.setMobile(mobileNo);
        msgHead.setServcode(msgServcode);
        msgHead.setProductId(msgProductId);
        msgHead.setAppuser(msgAppuser);
        msg.setMsgHead(msgHead);
        LinkedHashMap<String, String> msgMap = new LinkedHashMap<String, String>();
        msg.setMsg(msgMap);

        String json = JsonUtil.toJson(msg);
		logger.info("实名认证短信通知报文:{}",json);
        String returnMsg=null;
		try {
			returnMsg = HttpURLRequestUtil.sendMeCard(remoteSmsContentUrl, json.toString());
		} catch (Exception e1) {
			logger.error("调用实名认证短信通知异常 ");
			e1.printStackTrace();
		}
		logger.info("实名认证短信通知结果:{}"+returnMsg);
		logger.info("================实名认证短信通知完成================");
	}

}
