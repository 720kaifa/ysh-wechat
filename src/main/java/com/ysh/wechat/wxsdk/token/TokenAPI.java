package com.ysh.wechat.wxsdk.token;

import com.ysh.wechat.wxsdk.base.BaseAPI;
import com.ysh.wechat.wxsdk.client.HttpClientExecutor;
import com.ysh.wechat.wxsdk.token.bean.Token;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

/**
 * Access_token API
 * Created by yushunwei on 2016/8/7.
 */
public class TokenAPI extends BaseAPI {

    /**
     * 获取接口调用access_token
     *
     * @param appID     公众号ID
     * @param appsecret 公众号秘钥
     * @return 获取的access_token
     * @throws Exception
     */
    public static Token getToken(String appID, String appsecret) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/token")
                .addParameter("grant_type", "client_credential")
                .addParameter("appid", appID)
                .addParameter("secret", appsecret)
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, Token.class);
    }
}
