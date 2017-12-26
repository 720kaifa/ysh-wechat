package com.ysh.wechat.wxsdk.message;

import org.springframework.context.ApplicationContext;
import org.springframework.util.MethodInvoker;

import java.util.Map;

/**
 * 消息路由处理
 * Created by yushunwei on 2016/8/14.
 */
public abstract class MessageRouter {
    /**
     * 获取消息转换器
     *
     * @param clazzKey
     * @return
     */
    protected abstract Class getResoler(String clazzKey);

    /**
     * 消息路由
     *
     * @param message 消息
     * @return 路由结果
     * @throws Exception
     */
    public String route(Map<String, String> message, ApplicationContext context) throws Exception {
        // 获取msgType 和 event 组合作为路由标识
        String msgType = message.get("MsgType");
        String event = message.get("Event");

        // 动态获取路由目标类
        Class clazz = getResoler((msgType + event).replace("null", "").toLowerCase());

        // 如果对应解析器还未实现，则返回空文本，微信服务器不会对此作任何处理，并且不会发起重试
        if (clazz == null) {
            return "";
        }

        MethodInvoker methodInvoker = new MethodInvoker();
        methodInvoker.setTargetObject(context.getBean(clazz));
        methodInvoker.setTargetMethod("resolve");
        methodInvoker.setArguments(new Object[]{message});
        methodInvoker.prepare();
        return (String)methodInvoker.invoke();
    }

}
