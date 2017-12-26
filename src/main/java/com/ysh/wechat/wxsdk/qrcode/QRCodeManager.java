package com.ysh.wechat.wxsdk.qrcode;

import com.ysh.wechat.wxsdk.qrcode.bean.QRParam;
import com.ysh.wechat.wxsdk.qrcode.bean.QRTicket;
import com.ysh.wechat.wxsdk.qrcode.bean.TempQRParam;
import com.ysh.wechat.wxsdk.token.TokenManager;

/**
 * Created by wangxiao on 2017/9/8.
 */
public class QRCodeManager {

    /**
     * 根据唯一标识生成永久二维码。
     *
     * @param identifier 唯一标识
     * @param appID      微信appId
     * @param appsecret  微信appsecret
     * @return
     * @throws Exception
     */
    public static QRTicket getQRTicket(String identifier, String appID, String appsecret) throws Exception {
        QRParam qrParam = new QRParam(identifier);
        return QRCodeAPI.getQRTicket(TokenManager.getToken(appID, appsecret).getAccess_token(), qrParam);
    }

    /**
     * 根据唯一标识生成临时二维码。
     *
     * @param expireTime 到期时间
     * @param identifier 唯一标识
     * @param appID      微信appId
     * @param appsecret  微信appsecret
     * @return
     * @throws Exception
     */
    public static QRTicket getTemporaryQRTicket(int expireTime, String identifier, String appID, String appsecret) throws Exception {
        TempQRParam tempQRParam = new TempQRParam(expireTime, identifier);
        return QRCodeAPI.getTempQRTicket(TokenManager.getToken(appID, appsecret).getAccess_token(), tempQRParam);
    }
}
