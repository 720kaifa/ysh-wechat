package com.ysh.wechat.message;

import com.ysh.wechat.wxsdk.message.MessageRouter;
import com.ysh.wechat.wxsdk.message.resolver.ClickEventResolver;
import com.ysh.wechat.wxsdk.message.resolver.SubscribeEventResolver;
import com.ysh.wechat.wxsdk.message.resolver.TextMessageResolver;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 联连服务号消息路由器
 *
 * Created by yangshanghang on 2017/12/21.
 */
@Component
public class LpspMessageRouter extends MessageRouter {

    /**
     * 消息转换器
     */
    private static Map<String, Class> routerMap = new HashMap<String, Class>() {
        {
            put("eventsubscribe", SubscribeEventResolver.class);
            put("text", TextMessageResolver.class);
            put("eventclick",ClickEventResolver.class);
        }
    };

    /**
     * 获取消息转换器
     *
     * @param clazzKey 消息转换器key
     * @return 消息转换器
     */
    @Override
    protected Class getResoler(String clazzKey) {
        return routerMap.get(clazzKey);
    }
}
