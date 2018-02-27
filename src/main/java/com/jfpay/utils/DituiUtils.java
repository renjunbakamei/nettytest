package com.jfpay.utils;

import com.jfpay.core.constant.CoreConstants;
import com.jfpay.core.util.JsonUtil;
import com.jfpay.entity.DO.PrepPersonalinfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class DituiUtils {

    final static Logger LOG= LoggerFactory.getLogger(DituiUtils.class);

    @Value("${dituiUrl}")
    private String dituiUrl;

    /**
     * 回调地推接口
     * @param info
     * @param type
     * @return
     */
    public String directDiTui(PrepPersonalinfo info, String type, int num, String feeType){
        try{
            Map<String,Object> params=new HashMap<>();
            params.put("mobile",info.getMobileno());  //查看时间
            params.put("type",type);  //个人审件
            params.put("grade",info.getViplevel()==null?"":info.getViplevel());
            params.put("status",info.getAuditflag()==null? CoreConstants.AUDIT_FLAG_4:info.getAuditflag());  //通过
            params.put("error_msg", info.getRejectreason()==null?"":info.getRejectreason());  //驳回原因
            params.put("fee_type", feeType);  //驳回原因
            String json = JsonUtil.toJson(params);
            String sign = Md5Utils.onMD5PwdByMD5key(json);
            LOG.info("个人实名认证地推APP参数json="+json+"&sign="+sign);
            String callURL=dituiUrl;
            if("1".equals(info.getProductType())){
                callURL+="v1/jf/provider/personal_callback";
            }else{
                callURL+="v1/provider/personal_callback";
            }
            String send=String.format("req=%s&app_user=shenjian&sign=%s",json,sign);
            String result= HttpURLRequestUtil.sendNotJson(callURL,send);
            if(StringUtils.isBlank(result)){
                if(num > 1){
                    return result;
                }else{
                    num++;
                    directDiTui(info,type,num,feeType);
                }
            }
            LOG.info("个人实名认证地推返回:"+result);
            return result;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
