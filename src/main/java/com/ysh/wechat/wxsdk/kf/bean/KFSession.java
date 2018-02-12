package com.ysh.wechat.wxsdk.kf.bean;

/**
 * 客服会话对象
 *
 * @author YangShangHang
 * @date 2018/1/29
 */
public class KFSession {
    // 客服账号
    private String kf_account;
    // 微信openid
    private String openid;

    public String getKf_account() {
        return kf_account;
    }

    public void setKf_account(String kf_account) {
        this.kf_account = kf_account;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
