package com.ysh.wechat.wxsdk.message.resolver;

import java.util.HashMap;

/**
 * 语音消息解析器
 * Created by yushunwei on 2017/3/27.
 */
public abstract class VoiceMessageResolver extends BaseResolver implements IResolver {
    /**
     * 获取用户发送的语音内容
     *
     * @param message 消息相关信息
     * @return 具体语音内容
     */
    protected String getRecognition(HashMap<String, Object> message) {
        return message.get("Recognition") == null ? "" : message.get("Recognition").toString().trim();
    }
}
