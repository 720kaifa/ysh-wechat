package com.ysh.wechat.wxsdk.user.bean;

/**
 * 微信批量关注用户。
 *
 * Created by wangxiao on 2017/8/16.
 */
public class UserBatch {
    /**
     * 用户信息列表。
     */
    private String user_info_list;

    public String getUser_info_list() {
        return user_info_list;
    }

    public void setUser_info_list(String user_info_list) {
        this.user_info_list = user_info_list;
    }
}
