/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.ysh.wechat.wxsdk.user.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 关注用户信息
 */
public class UserInfo implements Serializable {
    /**
     * 是否订阅 0:未订阅  1:已订阅
     */
    private String subscribe;

    /**
     * 微信用户openid
     */
    private String openid;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户所在城市
     */
    private String city;

    /**
     * 用户所在国家
     */
    private String country;

    /**
     * 用户所在省份
     */
    private String province;

    /**
     * 用户语言
     */
    private String language;

    /**
     * 用户头像
     */
    private String headimgurl;

    /**
     * 用户关注时间
     */
    private Date subscribe_time;

    /**
     * 用户unionid
     */
    private String unionid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用户所在分组
     */
    private String groupid;

    /**
     * 用户标签ID列表
     */
    private long[] tagid_list;

    private static final long serialVersionUID = 1L;

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Date getSubscribe_time() {
        return subscribe_time;
    }

    public void setSubscribe_time(Date subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public long[] getTagid_list() {
        return tagid_list;
    }

    public void setTagid_list(long[] tagid_list) {
        this.tagid_list = tagid_list;
    }
}