package com.ysh.wechat.core.service.impl;

import com.ysh.wechat.message.LpspMessageRouter;
import com.ysh.wechat.common.constant.ConfigConstant;
import com.ysh.wechat.wxsdk.common.utils.XMLUtils;
import com.ysh.wechat.wxsdk.ticket.TicketManager;
import com.ysh.wechat.wxsdk.ticket.bean.Ticket;
import com.ysh.wechat.wxsdk.token.TokenManager;
import com.ysh.wechat.wxsdk.token.bean.Token;
import com.ysh.wechat.core.service.IWechatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 微信Service 实现类
 *
 * Creted by yangshanghang on 2017/12/21.
 */
@Service
@Lazy(false)
public class WechatServiceImpl implements IWechatService {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(WechatServiceImpl.class);

    /**
     * 消息转换器
     */
    @Autowired
    private LpspMessageRouter lpspMessageRouter;

    /**
     * 处理消息
     *
     * @param request 请求
     * @return 处理结果
     * @throws Exception
     */
    @Override
    public String processRequest(HttpServletRequest request) throws Exception {
        WebApplicationContext context = RequestContextUtils.findWebApplicationContext(request);
        // 调用parseXml方法解析请求消息
        Map<String, String> requestMap = XMLUtils.parseXml(request);

        String message = lpspMessageRouter.route(requestMap,context);

        return message;
    }

    /**
     * 定时刷新token和ticket
     * @throws Exception
     */
    @Override
    @Scheduled(fixedRate = 7_000_000)
    public void refreshScheduled() throws Exception {
        Token accessToken = TokenManager.getToken(ConfigConstant.APP_ID_WECHAT, ConfigConstant.APP_SECRET_WECHAT);
        Ticket ticket = TicketManager.getTicket(ConfigConstant.APP_ID_WECHAT, ConfigConstant.APP_SECRET_WECHAT);
        logger.info(">>>>>>>>>>>> 定时刷新token和ticket>>>>>>>>>>");
        logger.info(accessToken.getAccess_token());
        logger.info(ticket.getTicket());
    }
}
