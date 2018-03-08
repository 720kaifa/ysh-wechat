package com.ysh.wechat.base.message;

import com.ysh.wechat.base.resolver.YshClickEventResolver;
import com.ysh.wechat.base.resolver.YshSubscribeEventResolver;
import com.ysh.wechat.base.resolver.YshTextMessageResolver;
import com.ysh.wechat.wxsdk.message.MessageRouter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 联连服务号消息路由器
 *
 * Created by yangshanghang on 2017/12/21...
 */
@Component
public class YshMessageRouter extends MessageRouter {

    /**
     * 消息转换器
     */
    private static Map<String, Class> routerMap = new HashMap<String, Class>() {
        {
            put("eventsubscribe", YshSubscribeEventResolver.class);
            put("text", YshTextMessageResolver.class);
            put("eventclick", YshClickEventResolver.class);
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
