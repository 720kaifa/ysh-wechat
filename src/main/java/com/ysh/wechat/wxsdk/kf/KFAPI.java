package com.ysh.wechat.wxsdk.kf;

import com.ysh.wechat.common.constant.ConfigConstant;
import com.ysh.wechat.wxsdk.base.BaseAPI;
import com.ysh.wechat.wxsdk.base.BaseResult;
import com.ysh.wechat.wxsdk.client.HttpClientExecutor;
import com.ysh.wechat.wxsdk.common.utils.JSONUtils;
import com.ysh.wechat.wxsdk.kf.bean.KFList;
import com.ysh.wechat.wxsdk.kf.bean.KFSession;
import com.ysh.wechat.wxsdk.kf.bean.KFSessionStatus;
import com.ysh.wechat.wxsdk.kf.bean.KFTextMessage;
import com.ysh.wechat.wxsdk.token.TokenManager;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * 描述: 客服相关API接口 .<br>
 *
 * @author YangShangHang
 * @date 2018/1/29
 */
public class KFAPI extends BaseAPI{

    private static Logger logger = LoggerFactory.getLogger(KFAPI.class);

    /**
     * 发送客服文本消息
     *
     * @param descr   描述
     * @param openId  微信用户openId
     * @param content 消息内容
     * @throws Exception 异常
     */
    public static void sendKFTextMessage(String descr, String openId, String content) throws Exception {
        // 1.生成客服文本消息
        KFTextMessage textMessage = new KFTextMessage(openId, content);

        // 2.执行发送
        try {
            BaseResult baseResult = sendKFTextMessage(TokenManager
                    .getToken(ConfigConstant.APP_ID_WECHAT, ConfigConstant.APP_SECRET_WECHAT)
                    .getAccess_token(), textMessage);
            if (!baseResult.isSuccess()) {
                logger.error("发送客服消息失败：{} - {} - {}", descr, baseResult.getErrcode(), baseResult.getErrmsg());
            }
        } catch (Exception e) {
            logger.error("发送客服消息异常：{} ", descr, e);
        }
    }

    /**
     * 发送客服文本消息
     *
     * @param access_token 接口调用access_token
     * @param message      消息
     * @return 调用结果
     * @throws Exception 异常
     */
    public static BaseResult sendKFTextMessage(String access_token, KFTextMessage message) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/message/custom/send")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(message), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 获取客服列表
     *
     * @param access_token 接口调用access_token
     * @return 客服列表
     * @throws Exception
     */
    public static KFList getKFList(String access_token) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/customservice/getkflist")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, KFList.class);
    }

    /**
     * 创建客服会话
     *
     * @param access_token 接口调用access_token
     * @param kfSession    客服会话
     * @return 接口调用结果
     * @throws Exception 异常
     */
    public static BaseResult createKFSession(String access_token, KFSession kfSession) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/customservice/kfsession/create")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(kfSession), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 获取客服会话状态
     *
     * @param access_token 接口调用access_token
     * @param openId       用户openId
     * @return 客服会话状态
     * @throws Exception 异常
     */
    public static KFSessionStatus getKFSessionStatus(String access_token, String openId) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/customservice/kfsession/getsession")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .addParameter(PARAM_OPENID, openId)
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, KFSessionStatus.class);
    }





}
