package com.ysh.wechat.wxsdk.kf.bean;

/**
 * 描述: 客服消息-图片 .<br>
 *
 * @author YangShangHang
 * @date 2018/2/23
 */
public class KFImageMessage {
    private String touser;

    private String msgtype = "image";

    private Image image;

    public KFImageMessage(String touser, String media_id) {
        this.touser = touser;
        this.image = new Image(media_id);
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public class Image {
        private String media_id;

        public Image(String media_id) {
            this.media_id = media_id;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }
}
