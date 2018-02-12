package com.ysh.wechat.wxsdk.kf.bean;

import com.ysh.wechat.wxsdk.base.BaseResult;

/**
 * 客服会话状态
 *
 * @author YangShangHang
 * @date 2018/1/29
 */
public class KFSessionStatus extends BaseResult {
    // 会话接入时间
    private Long createtime;

    // 正在接待的客服账号
    private String kf_account;

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public String getKf_account() {
        return kf_account;
    }

    public void setKf_account(String kf_account) {
        this.kf_account = kf_account;
    }
}
