package com.ysh.wechat.wxsdk.jssign.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * js-sdk调用签名对象
 * Created by yangshanghang on 2017/12/21.
 */
public class JSSign {
    // 公众号的唯一标识
    private String appId;

    // 生成签名的时间戳
    private String timestamp;

    // 生成签名的随机串
    private String nonceStr;

    // 签名
    private String signature;

    /**
     * JS sdk Ticket
     */
    @JsonProperty("jsapi_ticket")
    private String jsapiTicket;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getJsapiTicket() {
        return jsapiTicket;
    }

    public void setJsapiTicket(String jsapiTicket) {
        this.jsapiTicket = jsapiTicket;
    }
}
