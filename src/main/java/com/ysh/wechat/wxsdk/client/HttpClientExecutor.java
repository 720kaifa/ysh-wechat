package com.ysh.wechat.wxsdk.client;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;

/**
 * Http请求客户端
 * Created by yangshanghang on 2017/12/21.
 */
public class HttpClientExecutor {

    /**
     * 执行json格式返回类请求
     *
     * @param request 请求
     * @param clazz   返回对象类型
     * @param <T>     泛型
     * @return 泛型对象
     * @throws Exception
     */
    public static <T> T executeJsonResult(HttpUriRequest request, Class<T> clazz) throws Exception {
        return execute(request, JSONResponseHandler.createResponseHandler(clazz));
    }

    /**
     * 执行string格式返回类请求
     *
     * @param request 请求
     * @return 字符结果
     * @throws Exception 异常
     */
    public static String executeStringResult(HttpUriRequest request) throws Exception {
        return (String) execute(request, StringResponseHandler.createResponseHandler());
    }

    /**
     * 发送请求
     *
     * @param request         请求
     * @param responseHandler 响应处理器
     * @param <T>             泛型
     * @return 泛型对象
     * @throws Exception
     */
    private static <T> T execute(HttpUriRequest request, ResponseHandler<T> responseHandler) throws Exception {
        HttpClient httpClient = com.ysh.wechat.wxsdk.client.HttpClientFactory.createHttpClient(5 * 1000, 5 * 1000);
        return httpClient.execute(request, responseHandler);
    }

}
