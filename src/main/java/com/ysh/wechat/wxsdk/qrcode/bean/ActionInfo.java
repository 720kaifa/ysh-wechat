package com.ysh.wechat.wxsdk.qrcode.bean;

import java.util.Map;

/**
 * 二维码详细信息
 *
 * Created by wangxiao on 2017/9/8.
 */
public class ActionInfo {

    /**
     * 场景
     */
    private Map<String, Object> scene;

    public Map<String, Object> getScene() {
        return scene;
    }

    public void setScene(Map<String, Object> scene) {
        this.scene = scene;
    }
}

