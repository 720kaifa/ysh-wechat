package com.ysh.wechat.common.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 可配置常量
 */
@Component
@Lazy(false)
public class ConfigConstant {
    /**
     * 服务号 appID
     */
    public static String APP_ID_WECHAT;

    /**
     * 服务号 appSecret
     */
    public static String APP_SECRET_WECHAT;

    /**
     * 服务号 token
     */
    public static String TOKEN_WECHAT;

    @Value("${appid.wechat}")
    public void setAppIdWechat(String appIdWechat) {
        APP_ID_WECHAT = appIdWechat;
    }

    @Value("${appsecret.wechat}")
    public void setAppSecretWechat(String appSecretWechat) {
        APP_SECRET_WECHAT = appSecretWechat;
    }

    @Value("${token.wechat}")
    public void setTokenWechat(String tokenWechat) {
        TOKEN_WECHAT = tokenWechat;
    }
}
