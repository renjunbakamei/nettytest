package com.jfpay.core.domain.to;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by renjun on 2017/8/27.
 */
public class ResultDataTO {

    /**
     *  返回结果结果码
     */
    @JsonProperty("CODE")
    private String code;

    /**
     * 返回结果结果描述
     */
    @JsonProperty("MSG")
    private String msg;

    /**
     * 返回结果结果集
     */
    @JsonProperty("DATA")
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
