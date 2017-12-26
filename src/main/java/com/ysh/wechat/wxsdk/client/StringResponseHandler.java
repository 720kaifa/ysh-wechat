package com.ysh.wechat.wxsdk.client;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * String结果返回处理器
 * Created by yangshanghang on 2017/12/21.
 */
public class StringResponseHandler {

    private static Logger logger = LoggerFactory.getLogger(StringResponseHandler.class);

    /**
     * 构造函数
     *
     * @return
     */
    public static ResponseHandler createResponseHandler() {
        return new StringResponseHandlerImpl();
    }

    /**
     * 内部类
     */
    public static class StringResponseHandlerImpl implements ResponseHandler {

        /**
         * 接口响应处理
         *
         * @param response 接口响应
         * @return String结果
         * @throws IOException
         */
        @Override
        public String handleResponse(HttpResponse response) throws IOException {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity, Consts.UTF_8);
            } else {
                logger.error("http请求错误状态码：{}", String.valueOf(status));
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        }
    }
}
