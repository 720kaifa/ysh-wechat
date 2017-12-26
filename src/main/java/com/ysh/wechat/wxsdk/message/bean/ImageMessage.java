package com.ysh.wechat.wxsdk.message.bean;

import com.ysh.wechat.wxsdk.base.BaseMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 图片消息
 * Created by yushunwei on 2017/3/7.
 */
@XStreamAlias("xml")
public class ImageMessage extends BaseMessage {

    // 图片对象
    @XStreamAlias("Image")
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
