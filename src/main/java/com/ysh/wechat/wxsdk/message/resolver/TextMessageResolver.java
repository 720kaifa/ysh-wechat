package com.ysh.wechat.wxsdk.message.resolver;

import java.util.HashMap;

/**
 * 文本消息解析器
 * Created by yushunwei on 2016/8/14.
 */
public abstract class TextMessageResolver extends BaseResolver implements IResolver {

    /**
     * 获取用户发送的文本消息相关信息
     *
     * @param message 消息相关信息
     * @return 具体文本内容
     */
    protected String getContent(HashMap<String, Object> message) {
        return message.get("Content") == null ? "" : message.get("Content").toString().trim();
    }
}
