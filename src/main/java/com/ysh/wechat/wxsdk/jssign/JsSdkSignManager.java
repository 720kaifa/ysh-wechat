package com.ysh.wechat.wxsdk.jssign;

import com.ysh.wechat.common.constant.ConfigConstant;
import com.ysh.wechat.wxsdk.jssign.bean.JSSign;
import com.ysh.wechat.wxsdk.ticket.TicketManager;
import com.ysh.wechat.wxsdk.ticket.bean.Ticket;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * JSSDK签名
 *
 * Created by yangshanghang on 2017/12/21.
 */
public class JsSdkSignManager {
    /**
     * 签名算法
     * @param url 当前网页的URL，不包含#及其后面部分
     * @return
     * @throws IOException
     */
    public static JSSign sign(String url) throws Exception {
        Ticket jsapiTicket = TicketManager.getTicket(ConfigConstant.APP_ID_WECHAT, ConfigConstant.APP_SECRET_WECHAT);
        Map<String, String> signMap = sign(jsapiTicket.getTicket(), url);
        JSSign model = new JSSign();
        model.setSignature(signMap.get("signature"));
        model.setAppId(ConfigConstant.APP_ID_WECHAT);
        model.setJsapiTicket(signMap.get("jsapi_ticket"));
        model.setTimestamp(signMap.get("timestamp"));
        model.setNonceStr(signMap.get("nonceStr"));
        return model;
    }

    /**
     * 签名
     *
     * @param jsapi_ticket ticket
     * @param url          当前页面url
     * @return 签名结果
     */
    public static Map<String, String> sign(String jsapi_ticket, String url) {
        Map<String, String> ret = new HashMap<String, String>();
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String string1;
        String signature = "";

        //注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;

        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapi_ticket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);

        return ret;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
