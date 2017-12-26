package com.ysh.wechat.wxsdk.material.bean;

/**
 * 描述：其他消息（图片、视频、语音）素材
 *
 * @author zhangmengwen
 * @date 2016/8/26
 */
public class OtherItem {
    /**
     * 图片素材id
     */
    private String media_id;
    /**
     * 文件名称
     */
    private String name;
    /**
     * 最后更新时间
     */
    private String update_time;
    /**
     * 图文页的URL
     */
    private String url;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
