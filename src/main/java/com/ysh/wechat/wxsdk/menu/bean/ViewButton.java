package com.ysh.wechat.wxsdk.menu.bean;

/**
 * view类型按钮
 * Created by yushunwei on 2016/8/14.
 */
public class ViewButton extends Button {
    // 菜单的响应动作类型
    private String type = "view";
    // 网页链接
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
