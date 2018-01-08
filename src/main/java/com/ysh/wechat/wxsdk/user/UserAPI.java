package com.ysh.wechat.wxsdk.user;

import com.ysh.wechat.wxsdk.base.BaseAPI;
import com.ysh.wechat.wxsdk.client.HttpClientExecutor;
import com.ysh.wechat.wxsdk.common.utils.JSONUtils;
import com.ysh.wechat.wxsdk.common.utils.StringUtils;
import com.ysh.wechat.wxsdk.user.bean.UserBatch;
import com.ysh.wechat.wxsdk.user.bean.UserBatchParam;
import com.ysh.wechat.wxsdk.user.bean.UserInfo;
import com.ysh.wechat.wxsdk.user.bean.Users;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * 用户管理APi
 */
public class UserAPI extends BaseAPI {


    /**
     * 获取用户列表
     *
     * @param access_token 接口调用access_token
     * @param next_openid  第一个拉取的OPENID，不填默认从头开始拉取
     * @return 接口调用结果
     * @throws Exception
     */
    public static Users getUserList(String access_token, String next_openid) throws Exception {
        RequestBuilder requestBuilder = RequestBuilder.get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/user/get")
                .addParameter(PARAM_ACCESS_TOKEN, access_token);
        if (StringUtils.isNotBlank(next_openid)) {
            requestBuilder.addParameter("next_openid", next_openid);
        }
        return HttpClientExecutor.executeJsonResult(requestBuilder.build(), Users.class);
    }

    /**
     * 批量获取用户信息。
     *
     * @param access_token
     * @param map
     * @return
     * @throws Exception
     */
    public static UserBatch getUserInfoBatch(String access_token, Map<String, List<UserBatchParam>> map) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/user/info/batchget")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, UserBatch.class);
    }

    /**
     * 获取单个用户信息。
     *
     * @param access_token
     * @param openid
     * @return
     * @throws Exception
     */
    public static UserInfo getUserInfo(String access_token, String openid) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/user/info")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .addParameter("openid", openid)
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, UserInfo.class);
    }
}
