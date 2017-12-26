package com.ysh.wechat.wxsdk.client;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;

/**
 * HttpClient工厂
 * Created by yangshanghang on 2017/12/21.
 */
public class HttpClientFactory {

    /**
     * 生成HttpClient
     *
     * @param connectTimeout 连接超时时间
     * @param socketTimeout  读取超时时间
     * @return HttpClient
     * @throws Exception
     */
    public static HttpClient createHttpClient(int connectTimeout, int socketTimeout) throws Exception {
        // 生成SSL上下文
        SSLContext sslContext = SSLContexts.custom().build();

        // 生成SSL连接工厂
        SSLConnectionSocketFactory sf = new SSLConnectionSocketFactory(sslContext,
                new String[]{"TLSv1"},
                null,
                SSLConnectionSocketFactory.getDefaultHostnameVerifier());

        // 生成请求配置，设置超时
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeout).build();

        // 返回基于HTTPS的HttpClient
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setSSLSocketFactory(sf)
                .build();
    }

}
