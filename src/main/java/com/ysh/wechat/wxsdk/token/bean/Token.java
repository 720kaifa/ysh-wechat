package com.ysh.wechat.wxsdk.token.bean;

import com.ysh.wechat.wxsdk.base.BaseResult;

/**
 * access_token
 * Created by yushunwei on 2016/8/7.
 */
public class Token extends BaseResult {
    /**
     *  接口调用凭证
     */
    private String access_token;

    /**
     * 接口调用凭证有效时间，单位：秒
     */
    private long expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }
}
