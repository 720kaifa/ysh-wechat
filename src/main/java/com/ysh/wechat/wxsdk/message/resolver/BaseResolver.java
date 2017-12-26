package com.ysh.wechat.wxsdk.message.resolver;

import com.ysh.wechat.wxsdk.base.BaseMessage;
import com.ysh.wechat.wxsdk.common.utils.XMLUtils;
import com.ysh.wechat.wxsdk.message.bean.TextMessage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yushunwei on 2016/8/14.
 */
public abstract class BaseResolver {

    // 文本消息
    public static final String MESSAGE_TEXT = "text";

    // 图片消息
    public static final String MESSAGE_IMAGE = "image";

    // 图文消息
    public static final String MESSAGE_NEWS = "news";

    // 关注事件
    public static final String EVENT_SUBSCRIBE = "subscribe";

    // 转发给客服
    public static final String TRANSFER_CUSTOMER_SERVICE = "transfer_customer_service";

    /**
     * 产生基础消息
     *
     * @param messageMap 用户消息内容
     * @return 基础消息
     */
    protected BaseMessage createBaseMessage(Map<String, Object> messageMap) {
        BaseMessage message = new BaseMessage();
        setBaseMessage(message, messageMap);
        return message;
    }

    /**
     * 设置基础消息信息
     *
     * @param message    基础消息
     * @param messageMap 用户消息内容
     */
    protected void setBaseMessage(BaseMessage message, Map<String, Object> messageMap) {
        message.setToUserName(messageMap.get("FromUserName").toString());
        message.setFromUserName(messageMap.get("ToUserName").toString());
        message.setCreateTime(new Date().getTime());
    }

    /**
     * 产生文本消息
     *
     * @param message 接收到的文本消息
     * @param content 文本消息内容
     * @return 回复的文本消息
     * @throws Exception 异常信息
     */
    protected String createTextMessage(HashMap<String, Object> message, String content) throws Exception {
        TextMessage respMessage = new TextMessage();
        setBaseMessage(respMessage, message);
        respMessage.setMsgType(MESSAGE_TEXT);
        respMessage.setContent(content);
        return XMLUtils.parseXml(respMessage);
    }

    /**
     * 获取用户
     *
     * @param message
     * @return
     */
    protected String getOpenId(HashMap<String, Object> message) {
        return message.get("FromUserName") == null ? "" : message.get("FromUserName").toString().trim();
    }
}
