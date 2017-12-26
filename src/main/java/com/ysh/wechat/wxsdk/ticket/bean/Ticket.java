package com.ysh.wechat.wxsdk.ticket.bean;

import com.ysh.wechat.wxsdk.base.BaseResult;

/**
 * 微信js-sdk调用临时凭证
 * Created by yushunwei on 2016/8/7.
 */
public class Ticket extends BaseResult {
    /**
     *js_api 票据
     */
    private String ticket;
    /**
     *js_api 票据有效时间，单位：秒
     */
    private long expires_in;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }
}
