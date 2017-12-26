package com.ysh.wechat.wxsdk.qrcode.bean;

import com.ysh.wechat.wxsdk.qrcode.enums.EActionName;

import java.util.HashMap;
import java.util.Map;

/**
 * 永久带参二维码请求参数。
 *
 * Created by wangxiao on 2017/9/8.
 */
public class QRParam {

    /**
     * 二维码类型
     */
    protected String action_name;

    /**
     * 二维码详细信息
     */
    protected ActionInfo action_info;

    public QRParam () {}

    /**
     * 创建字符串形式的二维码参数
     *
     * @param scene_str      字符串形式的参数，长度限制为1到64
     */
    public QRParam(String scene_str) {
        this.action_name = EActionName.QR_LIMIT_STR_SCENE.getValue();

        Map<String, Object> map = new HashMap<>();
        map.put("scene_str", scene_str);

        ActionInfo actionInfo = new ActionInfo();
        actionInfo.setScene(map);
        this.action_info = actionInfo;
    }

    /**
     * 创建整数形式的二维码参数
     *
     * @param scene_id       整数形式的参数，长度限制为1到64，临时二维码时为32位非0整型
     */
    public QRParam(int scene_id) {
        this.action_name = EActionName.QR_LIMIT_SCENE.getValue();

        Map<String, Object> map = new HashMap<>();
        map.put("scene_id", scene_id);

        ActionInfo actionInfo = new ActionInfo();
        actionInfo.setScene(map);
        this.action_info = actionInfo;
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
