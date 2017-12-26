package com.ysh.wechat.wxsdk.menu.bean;

/**
 * 二级菜单
 * Created by yushunwei on 2016/8/14.
 */
public class ComplexButton extends Button {
    // 二级菜单数组，个数应为1~5个
    private Button[] sub_button;

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }
}
