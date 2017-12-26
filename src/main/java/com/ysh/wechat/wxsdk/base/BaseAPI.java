package com.ysh.wechat.wxsdk.base;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

/**
 * 基础API
 * Created by yangshanghang on 2017/12/21.
 */
public abstract class BaseAPI {

    /**
     * 微信接口地址
     */
    protected static final String BASE_URI = "https://api.weixin.qq.com";

    /**
     * 微信接口调用access_token参数名称
     */
    protected static final String PARAM_ACCESS_TOKEN = "access_token";

    /**
     * 微信接口调用openid参数名称
     */
    protected static final String PARAM_OPENID = "openid";

    /**
     * json请求头
     */
    protected static Header jsonHeader = new BasicHeader(
            HttpHeaders.CONTENT_TYPE,
            ContentType.APPLICATION_JSON.toString());

    /**
     * xml请求头
     */
    protected static Header xmlHeader = new BasicHeader(
            HttpHeaders.CONTENT_TYPE,
            ContentType.APPLICATION_XML.toString());


}
