package com.ysh.wechat.base.resolver;

import com.ysh.wechat.common.constant.BizConstant;
import com.ysh.wechat.common.constant.ConfigConstant;
import com.ysh.wechat.wxsdk.common.utils.XMLUtils;
import com.ysh.wechat.wxsdk.message.bean.TextMessage;
import com.ysh.wechat.wxsdk.message.resolver.ClickEventResolver;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 描述: 点击事件解析器 .<br>
 *
 * @author YangShangHang
 * @date 2018/2/23
 */
@Component
public class YshClickEventResolver extends ClickEventResolver{

    /**
     * 点击事件处理
     *
     * @param message 需要处理的原始消息
     * @return 回复文本内容
     * @throws Exception 异常
     */
    @Override
    public String resolve(HashMap<String, Object> message) throws Exception {
        // 获取用户openId
        String openId = message.get("FromUserName").toString();

        String eventKey= this.getEventKey(message);
        TextMessage textMessage = new TextMessage();
        this.setBaseMessage(textMessage, message);
        textMessage.setMsgType(MESSAGE_TEXT);

        // 服务介绍按钮点击事件
        if (eventKey.equals(BizConstant.TEST_BUTTON_KEY)) {
            textMessage.setContent(BizConstant.TEST_TEXT_MSG);
            return XMLUtils.parseXml(textMessage);
        }

        // 客服图片按钮（测试）
        if (eventKey.equals(BizConstant.KF_IMAGE_BUTTON_KEY)) {

            StringBuffer sb = new StringBuffer();
            sb.append("Welcome to there~\n\n")
                    .append("<a href='")
                    .append(ConfigConstant.WECHAT_SERVER_URL)
                    .append("/send/kf/image?openId=")
                    .append(openId+"&media_id=UeqrQhpekqN6eZI94AIiB_Rmiz9EnEh_373JTZfyObQ")
                    .append("'>发送图片消息</a>");

            textMessage.setContent(sb.toString());
            return XMLUtils.parseXml(textMessage);
        }

        return "";
    }
}
