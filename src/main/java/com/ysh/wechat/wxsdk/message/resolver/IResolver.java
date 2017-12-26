package com.ysh.wechat.wxsdk.message.resolver;

import java.util.HashMap;

/**
 * 消息解析器接口
 * Created by yushunwei on 2016/8/14.
 */
public interface IResolver {
    /**
     * 消息处理
     * @param message 需要处理的原始消息
     * @return 解析结果
     * @throws Exception
     */
    String resolve(HashMap<String, Object> message) throws Exception;
}
