package com.ysh.wechat.wxsdk.template;

import com.ysh.wechat.wxsdk.base.BaseAPI;
import com.ysh.wechat.wxsdk.base.BaseResult;
import com.ysh.wechat.wxsdk.client.HttpClientExecutor;
import com.ysh.wechat.wxsdk.common.utils.JSONUtils;
import com.ysh.wechat.wxsdk.message.bean.TemplateMessage;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：模版消息API
 */
public class TemplateMessageAPI extends BaseAPI {

    /**
     * 描述：设置所属行业
     * @param access_token token
     * @param industry_id1 所属行业编号1
     * @param industry_id2 所属行业编号2
     * @return json字符串
     * @throws Exception
     */
    public static String setIndustry(String access_token,String industry_id1,String industry_id2)throws Exception{
        Map<String,String> map = new HashMap();
        map.put("industry_id1",industry_id1);
        map.put("industry_id2",industry_id2);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/template/api_set_industry")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map), Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest, String.class);
    }


    /**
     * 描述：获取设置的行业信息
     * @param access_token token
     * @return json字符串
     * @throws Exception
     */
    public static String getIndustry(String access_token)throws Exception{
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/template/get_industry")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest,String.class);
    }


    /**
     * 描述：获取模版id
     * @param access_token token
     * @param template_id_short 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
     * @return json字符串
     * @throws Exception
     */
    public static String getTemplateId(String access_token,String template_id_short)throws Exception{
        Map<String,String> map = new HashMap();
        map.put("template_id_short",template_id_short);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/template/api_add_template")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map),Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest,String.class);
    }


    /**
     * 描述：获取模版列表
     * @param access_token token
     * @return json字符串
     * @throws Exception
     */
    public static String getTemplateList(String access_token)throws Exception{
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/template/get_all_private_template")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest,String.class);
    }

    /**
     *描述：删除模版
     * @param access_token token
     * @param template_id 模板消息ID
     * @return json字符串
     * @throws Exception
     */
    public static BaseResult delTemplate(String access_token, String template_id)throws Exception{
        Map<String,String> map = new HashMap();
        map.put("template_id",template_id);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/template/del_private_template")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(map),Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest,BaseResult.class);
    }


    /**
     * 描述：发送模版
     * @param access_token token
     * @param templateMessage 模版类
     * @return
     * @throws Exception
     */
    public static BaseResult sendTemplate(String access_token, TemplateMessage templateMessage)throws Exception{
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/message/template/send")
                .addParameter(PARAM_ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(JSONUtils.toJSONString(templateMessage),Charset.forName("utf-8")))
                .build();
        return HttpClientExecutor.executeJsonResult(httpUriRequest,BaseResult.class);
    }
}
