package com.ysh.wechat.wxsdk.kf.bean;

/**
 * 描述: 客服消息-文本 .<br>
 *
 * @author YangShangHang
 * @date 2018/1/29
 */
public class KFTextMessage {
    private String touser;

    private String msgtype = "text";

    private Text text;

    public KFTextMessage(String touser, String content) {
        this.touser = touser;
        this.text = new Text(content);
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

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public class Text{
        private String content;

        public Text(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
