package com.ysh.wechat.wxsdk.menu;

import com.ysh.wechat.wxsdk.base.BaseAPI;
import com.ysh.wechat.wxsdk.base.BaseResult;
import com.ysh.wechat.wxsdk.client.HttpClientExecutor;
import com.ysh.wechat.wxsdk.common.utils.JSONUtils;
import com.ysh.wechat.wxsdk.menu.bean.Menu;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 * 菜单API
 * Created by yushunwei on 2016/8/14.
 */
public class MenuAPI extends BaseAPI {

    /**
     * 菜单创建
     *
     * @param access_token 接口调用access_token
     * @param menu         菜单数据
     * @return 接口调用结果
     * @throws Exception
     */
    public static BaseResult menuCreate(String access_token, Menu menu) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/menu/create")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(menu), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 使用 json 字符串创建菜单.
     *
     * @param access_token 接口调用access_token
     * @param jsonStr      菜单数据
     * @return 接口调用结果
     * @throws Exception
     */
    public static BaseResult menuCreate(String access_token, String jsonStr) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/menu/create")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(jsonStr, Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 菜单删除
     *
     * @param access_token 接口调用access_token
     * @param menu         菜单数据
     * @return 结果
     * @throws Exception
     */
    public static BaseResult menuDelete(String access_token, Menu menu) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "cgi-bin/menu/delete")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(menu), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 获取菜单列表
     *
     * @param access_token 接口调用access_token
     * @return
     * @throws Exception
     */
    public static String getMenus(String access_token) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/menu/get")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, String.class);
    }
}
