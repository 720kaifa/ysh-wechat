package com.ysh.wechat.wxsdk.menu.bean;

/**
 * 素材菜单
 *
 * Created by wangxiao on 2016/11/29.
 */
public class MediaButton extends Button {

    /**
     * 菜单类型
     */
    private String type = "media_id";

    /**
     * 素材id
     */
    private String media_id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }
}
