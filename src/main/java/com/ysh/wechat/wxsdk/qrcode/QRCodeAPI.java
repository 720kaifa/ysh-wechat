package com.ysh.wechat.wxsdk.qrcode;

import com.ysh.wechat.wxsdk.base.BaseAPI;
import com.ysh.wechat.wxsdk.client.HttpClientExecutor;
import com.ysh.wechat.wxsdk.common.utils.JSONUtils;
import com.ysh.wechat.wxsdk.qrcode.bean.QRParam;
import com.ysh.wechat.wxsdk.qrcode.bean.QRTicket;
import com.ysh.wechat.wxsdk.qrcode.bean.TempQRParam;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 * 二维码 API
 * <p>
 * Created by wangxiao on 2017/9/8.
 */
public class QRCodeAPI extends BaseAPI {

    /**
     * 获取二维码 Ticket。
     *
     * @param access_token token
     * @param param        参数
     * @return
     * @throws Exception
     */
    public static QRTicket getQRTicket(String access_token, QRParam param) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/qrcode/create")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(param), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, QRTicket.class);
    }

    /**
     * 获取临时二维码 Ticket。
     *
     * @param access_token token
     * @param param        参数
     * @return
     * @throws Exception
     */
    public static QRTicket getTempQRTicket(String access_token, TempQRParam param) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/qrcode/create")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(param), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, QRTicket.class);
    }
}
