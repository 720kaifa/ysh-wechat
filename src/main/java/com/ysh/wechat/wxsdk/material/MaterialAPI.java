package com.ysh.wechat.wxsdk.material;

import com.ysh.wechat.wxsdk.base.BaseAPI;
import com.ysh.wechat.wxsdk.client.HttpClientExecutor;
import com.ysh.wechat.wxsdk.common.utils.JSONUtils;
import com.ysh.wechat.wxsdk.material.bean.*;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：素材API
 *
 * @author zhangmengwen
 * @date 2016/8/26
 */
public class MaterialAPI extends BaseAPI {

    /**
     * 描述：获取永久图文素材列表
     *
     * @param access_token token
     * @param map          参数：type，offset，count
     * @return 永久图文素材列表
     * @throws Exception
     */
    public static NewsMaterialList getForeverNewsMaterialsList(String access_token, Map<String, String> map) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/material/batchget_material")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();

        return HttpClientExecutor.executeJsonResult(httpUriRequest, NewsMaterialList.class);
    }

    /**
     * 描述：获取永久其他素材（图片、语音、视频）列表
     *
     * @param access_token token
     * @param map          参数：type，offset，count
     * @return 永久其他素材（图片、语音、视频）列表
     * @throws Exception
     */
    public static OtherMaterialList getForeverOtherMaterialsList(String access_token, Map<String, String> map) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/material/batchget_material")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, OtherMaterialList.class);
    }

    /**
     * 描述：获取永久图文素材
     *
     * @param media_id     素材id
     * @param access_token token
     * @return 永久图文素材
     * @throws Exception
     */
    public static NewsMaterials getForeverNewsMaterial(String media_id, String access_token) throws Exception {
        Map<String, String> map = new HashMap();
        map.put("media_id", media_id);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/material/get_material")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, NewsMaterials.class);
    }

    /**
     * 描述：新增永久图文素材
     *
     * @param articles     素材article结构列表
     * @param access_token token
     * @return 新增的素材id
     * @throws Exception
     */
    public static String addForeverNewsMaterial(String access_token, Articles articles) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/material/add_news")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(articles), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, String.class);
    }

    /**
     * 描述：获取素材总数
     *
     * @param access_token token
     * @return 素材总数
     * @throws Exception
     */
    public static Map<String, Object> getMaterialCount(String access_token) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/material/get_materialcount")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, Map.class);
    }


    /**
     * 描述：修改图文素材
     *
     * @param access_token token
     * @param updateNews   更新素材对象
     * @return
     * @throws Exception
     */
    public static String updateNewsMaterial(String access_token, UpdataNews updateNews) throws Exception {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/material/update_news")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(updateNews), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, String.class);
    }
}
