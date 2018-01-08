package com.ysh.wechat.wxsdk.user.bean;

/**
 * 用户信息批量获取参数类
 *
 * Created by wangxiao on 2017/8/16.
 */
public class UserBatchParam {
    private String openid;
    private String lang = "zh_CN";

    public UserBatchParam() {
    }

    public UserBatchParam(String openid) {
        this.openid = openid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
