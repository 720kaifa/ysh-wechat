package com.ysh.wechat.wxsdk.message.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应客服文本消息
 */
public class CustomServiceTextMessage {

    /**
     * 接收方
     */
    private String touser;

    /**
     * 消息类型：text
     */
    private String msgtype;

    /**
     * 消息内容：content
     */
    private Map<String, String> text = new HashMap<>();

    public CustomServiceTextMessage() {

    }

    public CustomServiceTextMessage(String touser, String msgtype, String content) {
        this.touser = touser;
        this.msgtype = msgtype;
        this.text.put("content", content);
    }

    public Map<String, String> getText() {
        return text;
    }

    public void setText(Map<String, String> text) {
        this.text = text;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }
}
