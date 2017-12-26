package com.ysh.wechat.wxsdk.menu.bean;

/**
 * click类型按钮
 * Created by yushunwei on 2016/8/14.
 */
public class ClickButton extends Button {
    // 菜单的响应动作类型
    private String type = "click";
    // 菜单KEY值
    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
