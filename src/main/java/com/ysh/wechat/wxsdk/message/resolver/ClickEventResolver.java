package com.ysh.wechat.wxsdk.message.resolver;

import java.util.HashMap;

/**
 * 消息-点击事件处理器
 * Created by wangxiao on 2016/11/29.
 */
public abstract class ClickEventResolver extends BaseResolver implements IResolver {

    /**
     * 获取事件Key
     *
     * @param message 事件相关信息
     * @return 事件Key
     */
    protected String getEventKey(HashMap<String, Object> message) {
        return message.get("EventKey") == null ? "" : message.get("EventKey").toString();
    }

}
