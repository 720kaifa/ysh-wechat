package com.ysh.wechat.wxsdk.token;

import com.ysh.wechat.wxsdk.token.bean.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * access_token 中控服务器
 * Created by yushunwei on 2016/8/14.
 */
public class TokenManager {

    private static Logger logger = LoggerFactory.getLogger(TokenManager.class);

    // access_token
    private static Token token;

    /**
     * 获取access_token
     *
     * @return 返回access_token
     * @throws Exception
     */
    public static Token getToken(String appID, String appsecret) throws Exception {
        // 如果access_token 为空，则直接获取后返回
        if (token == null) {
            refreshToken(appID, appsecret);
            return token;
        }

        // 如果access_token已经失效，则刷新access_token
        if (System.currentTimeMillis() >= token.getExpires_in()) {
            refreshToken(appID, appsecret);
        }

        return token;
    }

    /**
     * 刷新access_token,默认保存7100秒
     *
     * @throws Exception
     */
    public static void refreshToken(String appID, String appsecret) throws Exception {
        refreshToken(appID, appsecret, null);
    }

    /**
     * 刷新access_token,自定义保存validSeconds秒
     *
     * @param appID
     * @param appsecret
     * @param validSeconds
     * @throws Exception
     */
    public static void refreshToken(String appID, String appsecret, Long validSeconds) throws Exception {
        token = TokenAPI.getToken(appID, appsecret);
        // token获取失败处理
        if (!token.isSuccess()) {
            // 获取失败，置空token对象，并返回
            logger.error("获取Access_Token失败：{}", token.getErrcode() + ":" + token.getErrmsg());
            return;
        }
        if (validSeconds == null || validSeconds < 0) {
            // 直接计算超时时间并存储，提前100秒
            token.setExpires_in(System.currentTimeMillis() + 7100 * 1000);
        } else {
            token.setExpires_in(System.currentTimeMillis() + validSeconds * 1000);
        }

    }
}