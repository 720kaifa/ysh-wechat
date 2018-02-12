package com.ysh.wechat.base.processer;

import com.ysh.wechat.common.util.StringUtils;
import com.ysh.wechat.wxsdk.kf.KFAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 事件处理器
 *
 * @author YangShangHang
 * @date 2018/1/29
 */
@Component
public class EventProcesser {

    private static Logger logger = LoggerFactory.getLogger(EventProcesser.class);

    /**
     * 普通用户关注事件
     *
     * @param openId 微信openId
     * @return 操作结果
     * @throws Exception 异常
     */
    @Async
    public String commonUserSubscribe(String openId) throws Exception {
        try {
            // 2.推送关注文本
            String content = getCommonUserSubscribeText();
            if (StringUtils.isNotBlank(content)) {
                KFAPI.sendKFTextMessage("普通用户关注事件", openId, content);
            }
        } catch (Exception e) {
            logger.error("普通用户关注事件异常：{}", e.getMessage());
        }

        return "success";
    }

    /**
     * 获取普通用户关注文案
     *
     * @return 关注文案
     */
    private String getCommonUserSubscribeText() {
        // 1.返回文本
        StringBuffer sb = new StringBuffer();
        sb.append("欢迎关注~\n\n")
                .append("公众号将为你提供多种服务：\n")
                .append("• 自定义菜单服务\n")
                .append("• ")
                .append("点击<a href='")
                .append("http://www.baidu.com")
                .append("'>百度查询</a>服务");
        return sb.toString();
    }
}
