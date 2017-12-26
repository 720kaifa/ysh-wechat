package com.ysh.wechat.wxsdk.message;

import com.ysh.wechat.wxsdk.base.BaseAPI;
import com.ysh.wechat.wxsdk.base.BaseResult;
import com.ysh.wechat.wxsdk.client.HttpClientExecutor;
import com.ysh.wechat.wxsdk.common.utils.JSONUtils;
import com.ysh.wechat.wxsdk.message.bean.CustomServiceTextMessage;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 * 消息API
 * Created by yushunwei on 2017-09-21.
 */
public class MessageAPI extends BaseAPI {

    /**
     * 发送客服文本消息
     *
     * @param access_token 接口调用access_token
     * @param message      问题消息
     * @return 发送结果
     * @throws Exception 异常信息
     */
    public static BaseResult sendCustomTextMessage(String access_token, CustomServiceTextMessage message) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/message/custom/send")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(message), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, BaseResult.class);
    }
}
