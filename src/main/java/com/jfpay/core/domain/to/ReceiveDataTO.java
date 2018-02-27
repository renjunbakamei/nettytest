package com.jfpay.core.domain.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by renjun on 2017/8/27.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceiveDataTO {

    /**
     * 接收到的报文头
     */
    @JsonProperty("REQ_TYPE")
    private String head;

    /**
     * 接收到的报文信息
     */
    @JsonProperty("BODY")
    private Map<String,Object> params;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
