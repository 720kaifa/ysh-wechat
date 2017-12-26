package com.ysh.wechat.wxsdk.material.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ysh.wechat.wxsdk.base.BaseResult;

import java.util.List;

/**
 * 描述：图文model
 */
public class NewsMaterials extends BaseResult{
    /**
     * 消息列表
     */
    private List<News> news_item;

    /**
     * 有效时间，单位：秒
     */
    private long expires_in;

    public List<News> getNews_item() {
        return news_item;
    }

    public void setNews_item(List<News> news_item) {
        this.news_item = news_item;
    }

    @JsonIgnore
    public long getExpires_in() {
        return expires_in;
    }

    @JsonIgnore
    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }
}
