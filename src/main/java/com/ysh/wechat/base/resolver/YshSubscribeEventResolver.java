package com.ysh.wechat.base.resolver;

import com.ysh.wechat.base.processer.EventProcesser;
import com.ysh.wechat.common.util.StringUtils;
import com.ysh.wechat.wxsdk.message.resolver.SubscribeEventResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 描述: 关注事件解析器 .<br>
 *
 * @author YangShangHang
 * @date 2018/1/29
 */
@Component
public class YshSubscribeEventResolver extends SubscribeEventResolver{

    private static Logger logger = LoggerFactory.getLogger(YshSubscribeEventResolver.class);

    /**
     * 事件处理器
     */
    @Autowired
    private EventProcesser eventProcesser;

    /**
     * 关注事件回复，回复模板消息
     *
     * @param message 需要处理的原始事件
     * @return 回复模板消息结果
     * @throws Exception
     */
    @Override
    public String resolve(HashMap<String, Object> message) throws Exception {
        // 获取用户openId
        String openId = message.get("FromUserName").toString();

        String eventKey = String.valueOf(message.get("EventKey"));

        // 1.普通关注
        if (StringUtils.isBlank(eventKey) || !eventKey.startsWith("qrscene_")) {
            eventProcesser.commonUserSubscribe(openId);
        } else {
            return "error";
        }
        return "success";
    }
}
