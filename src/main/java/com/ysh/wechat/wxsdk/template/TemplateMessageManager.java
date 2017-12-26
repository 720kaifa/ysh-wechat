package com.ysh.wechat.wxsdk.template;

import com.ysh.wechat.wxsdk.base.BaseResult;
import com.ysh.wechat.wxsdk.message.bean.TemplateMessage;

/**
 * 描述：模版管理
 */
public class TemplateMessageManager {


    /**
     * 描述：获取模版列表
     *
     * @param access_token token
     * @return json字符串
     * @throws Exception
     */
    public static String getTemplateList(String access_token) throws Exception {
        return TemplateMessageAPI.getTemplateList(access_token);
    }


    /**
     * 描述：发送模板
     *
     * @param access_token    token
     * @param templateMessage 模板
     * @return
     * @throws Exception
     */
    public static BaseResult sendTemplate(String access_token, TemplateMessage templateMessage) throws Exception {
        return TemplateMessageAPI.sendTemplate(access_token, templateMessage);
    }

    /**
     * 描述：删除模板
     *
     * @param access_token token
     * @param template_id  模板id
     * @return
     * @throws Exception
     */
    public static BaseResult delTemplate(String access_token, String template_id) throws Exception {
        return TemplateMessageAPI.delTemplate(access_token, template_id);
    }

}
