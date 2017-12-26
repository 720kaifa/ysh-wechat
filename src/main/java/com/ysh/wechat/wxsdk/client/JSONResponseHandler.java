package com.ysh.wechat.wxsdk.client;

import com.ysh.wechat.wxsdk.common.utils.JSONUtils;
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
 * json结果返回处理器
 * Created by yangshanghang on 2017/12/21.
 */
public class JSONResponseHandler {

    private static Logger logger = LoggerFactory.getLogger(JSONResponseHandler.class);

    /**
     * 构造函数
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> ResponseHandler<T> createResponseHandler(final Class<T> clazz) {
        return new JsonResponseHandlerImpl<>(clazz);
    }

    /**
     * 内部类
     *
     * @param <T>
     */
    public static class JsonResponseHandlerImpl<T> implements ResponseHandler<T> {

        /**
         * 类型自动转换
         */
        private Class<T> clazz;

        /**
         * 构造函数
         *
         * @param clazz 类型
         */
        public JsonResponseHandlerImpl(Class<T> clazz) {
            this.clazz = clazz;
        }

        /**
         * 接口响应处理
         *
         * @param response 接口响应
         * @return clazz类型对象
         * @throws IOException
         */
        @Override
        public T handleResponse(HttpResponse response) throws IOException {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity, Consts.UTF_8);
                return JSONUtils.parseObject(result, clazz);
            } else {
                logger.error("http请求错误状态码：{}",String.valueOf(status));
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
        }

    }
}
