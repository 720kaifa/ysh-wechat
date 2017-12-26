package com.ysh.wechat.wxsdk.menu.bean;

/**
 * 按钮
 * Created by yushunwei on 2016/8/14.
 */
public class Button {
    // 一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
