package com.ysh.wechat.wxsdk.qrcode.bean;

import com.ysh.wechat.wxsdk.common.utils.JSONUtils;
import com.ysh.wechat.wxsdk.qrcode.enums.EActionName;

import java.util.HashMap;
import java.util.Map;

/**
 * 临时带参二维码请求参数。
 *
 * Created by wangxiao on 2017/9/8.
 */
public class TempQRParam extends QRParam {

    /**
     * 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），
     * 此字段如果不填，则默认有效期为30秒。
     */
    private int expire_seconds;

    public TempQRParam() {}

    /**
     * 创建字符串形式的二维码参数
     *
     * @param expire_seconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
     * @param scene_str      字符串形式的参数，长度限制为1到64
     */
    public TempQRParam(int expire_seconds, String scene_str) {
        this.expire_seconds = expire_seconds;
        super.action_name = EActionName.QR_STR_SCENE.getValue();

        Map<String, Object> map = new HashMap<>();
        map.put("scene_str", scene_str);

        ActionInfo actionInfo = new ActionInfo();
        actionInfo.setScene(map);
        this.action_info = actionInfo;
    }

    /**
     * 创建整数形式的二维码参数
     *
     * @param expire_seconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
     * @param scene_id       整数形式的参数，长度限制为1到64，临时二维码时为32位非0整型
     */
    public TempQRParam(int expire_seconds, int scene_id) {
        this.expire_seconds = expire_seconds;
        super.action_name = EActionName.QR_SCENE.getValue();

        Map<String, Object> map = new HashMap<>();
        map.put("scene_id", scene_id);

        ActionInfo actionInfo = new ActionInfo();
        actionInfo.setScene(map);
        this.action_info = actionInfo;
    }

    public static void main(String[] args) {
        TempQRParam test = new TempQRParam(604800, "test");
        System.out.println(JSONUtils.toJSONString(test));
    }

    public int getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(int expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public ActionInfo getAction_info() {
        return action_info;
    }

    public void setAction_info(ActionInfo action_info) {
        this.action_info = action_info;
    }
}
