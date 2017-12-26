package com.ysh.wechat.wxsdk.message.bean;

/**
 * 描述：数据
 */
public class Data {
    /**
     * 值
     */
    private String value;
    /**
     * 颜色
     */
    private String color;

    public Data() {
    }

    public Data(String value) {
        this.value = value;
    }

    public Data(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
