package com.ysh.wechat.wxsdk.ticket;

import com.ysh.wechat.wxsdk.ticket.bean.Ticket;
import com.ysh.wechat.wxsdk.token.TokenManager;
import com.ysh.wechat.wxsdk.token.bean.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 微信js-sdk调用临时凭证 中控服务器
 * Created by yushunwei on 2016/8/14.
 */
public class TicketManager {

    private static Logger logger = LoggerFactory.getLogger(TicketManager.class);

    // js-sdk调用临时凭证
    private static Ticket ticket;

    /**
     * 获取ticket
     *
     * @return 返回ticket
     * @throws Exception
     */
    public static Ticket getTicket(String appID, String appsecret) throws Exception {
        // 如果ticket 为空，则直接获取后返回
        if (ticket == null) {
            refreshTicket(appID, appsecret);
            return ticket;
        }

        // 如果ticket已经失效，则刷新ticket
        if (System.currentTimeMillis() >= ticket.getExpires_in()) {
            refreshTicket(appID, appsecret);
        }

        return ticket;
    }

    /**
     * 刷新ticket,默认保存7100秒
     *
     * @throws Exception
     */
    public static void refreshTicket(String appID, String appsecret) throws Exception {
        refreshTicket(appID, appsecret, null);
    }

    /**
     * 刷新ticket,自定义保存validSeconds秒
     *
     * @param appID
     * @param appsecret
     * @param validSeconds
     * @throws Exception
     */
    public static void refreshTicket(String appID, String appsecret, Long validSeconds) throws Exception {
        Token token = TokenManager.getToken(appID, appsecret);
        // token获取失败，直接返回
        if (token == null || !token.isSuccess()) {
            return;
        }
        ticket = TicketAPI.getTicket(token.getAccess_token());
        // ticket获取失败处理
        if (!ticket.isSuccess()) {
            logger.error("获取Ticket失败：{}", ticket.getErrcode() + ":" + ticket.getErrmsg());
            return;
        }

        if (validSeconds == null || validSeconds < 0) {
            // 直接计算超时时间并存储，提前100秒
            ticket.setExpires_in(System.currentTimeMillis() + 7100 * 1000);
        } else {
            ticket.setExpires_in(System.currentTimeMillis() + validSeconds * 1000);
        }
    }
}
