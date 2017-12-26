package com.ysh.wechat.wxsdk.material.enums;

/**
 * 描述：素材类型枚举
 */
public enum EMateriaType {
    /**
     * 素材类型：语音
     */
    MATERIAL_TYPE_VOICE("voice","语音"),
    /**
     * 素材类型：视频
     */
    MATERIAL_TYPE_VIDEO("video","视频"),
    /**
     * 素材类型：图片
     */
    MATERIAL_TYPE_IMAGE("image","图片"),
    /**
     * 素材类型：图文
     */
    MATERIAL_TYPE_NEWS("news","图文");

    private String value;

    private String desc;

    EMateriaType(String value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
