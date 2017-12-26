package com.ysh.wechat.wxsdk.qrcode.enums;

/**
 * 二维码类型枚举类。
 *
 * Created by wangxiao on 2017/9/8.
 */
public enum EActionName {
    QR_SCENE("QR_SCENE", "临时的整型参数值"),
    QR_STR_SCENE("QR_STR_SCENE", "临时的字符串参数值"),
    QR_LIMIT_SCENE("QR_LIMIT_SCENE", "永久的整型参数值"),
    QR_LIMIT_STR_SCENE("QR_LIMIT_STR_SCENE", "永久的字符串参数值");

    private String value;
    private String desc;

    EActionName(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
