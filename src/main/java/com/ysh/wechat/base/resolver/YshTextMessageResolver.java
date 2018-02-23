package com.ysh.wechat.base.resolver;

import com.ysh.wechat.wxsdk.common.utils.XMLUtils;
import com.ysh.wechat.wxsdk.message.bean.TextMessage;
import com.ysh.wechat.wxsdk.message.resolver.TextMessageResolver;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 描述: 文本消息解析器 .<br>
 *
 * @author YangShangHang
 * @date 2018/2/23
 */
@Component
public class YshTextMessageResolver extends TextMessageResolver {

    /**
     * 文本消息处理，回复文本消息
     *
     * @param message 需要处理的原始消息
     * @return 回复的文本消息
     * @throws Exception 异常
     */
    @Override
    public String resolve(HashMap<String, Object> message) throws Exception {
        // 1.获取消息文本内容
        String content = this.getContent(message);
        // 2.消息处理
        return process(content, message);
    }

    /**
     * 消息处理
     *
     * @param content 用户发送内容
     * @param message 用户发送消息
     * @return 回复内容
     * @throws Exception 异常
     */
    public String process(String content, HashMap<String, Object> message) throws Exception {
        TextMessage textMessage = new TextMessage();
        this.setBaseMessage(textMessage, message);
        textMessage.setMsgType(MESSAGE_TEXT);
        if("1".equals(content)){
            textMessage.setContent("我是谁并不重要");
            return XMLUtils.parseXml(textMessage);
        }
        if("2".equals(content)){
            textMessage.setContent("我从梦中来");
            return XMLUtils.parseXml(textMessage);
        }
        if("3".equals(content)){
            textMessage.setContent("去往心的归处");
            return XMLUtils.parseXml(textMessage);
        }
        return "";
    }
}
