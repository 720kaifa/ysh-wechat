package com.ysh.wechat.wxsdk.oauth;

import com.ysh.wechat.wxsdk.base.BaseAPI;
import com.ysh.wechat.wxsdk.client.HttpClientExecutor;
import com.ysh.wechat.wxsdk.oauth.bean.UserInfo;
import com.ysh.wechat.wxsdk.oauth.bean.WechatOauth2Token;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：网页授权
 */
public class OauthAPI extends BaseAPI {

    /**
     * 描述：获取网页授权信息
     *
     * @param appId     appID
     * @param appSecret appsecret
     * @param request   request请求
     * @return
     * @throws Exception
     */
    public static WechatOauth2Token getOauth2AccessToken(String appId, String appSecret, HttpServletRequest request) throws Exception {
        String code = request.getParameter("code");
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setHeader(xmlHeader)
                .setUri(BASE_URI + "/sns/oauth2/access_token")
                .addParameter("appid", appId)
                .addParameter("secret", appSecret)
                .addParameter("code", code)
                .addParameter("grant_type", "authorization_code")
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, WechatOauth2Token.class);
    }


    /**
     * 描述：获取用户信息
     *
     * @param access_token 网页授权接口调用凭证
     * @param openid       用户标识
     * @return
     * @throws Exception
     */
    public static UserInfo getUserInfo(String access_token, String openid) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/sns/userinfo")
                .addParameter("access_token", access_token)
                .addParameter("openid", openid)
                .addParameter("lang", "zh_CN")
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, UserInfo.class);
    }
}
