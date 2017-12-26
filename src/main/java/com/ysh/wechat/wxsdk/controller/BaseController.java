package com.ysh.wechat.wxsdk.controller;

import com.ysh.wechat.wxsdk.common.utils.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 微信相关请求基本控制器
 * Created by yangshanghang on 2017/12/21.
 */
public class BaseController {

    /**
     * 判断请求是否来源于微信
     * @param request 微信请求
     * @return Boolean.TRUE表示请求来源于微信
     * @throws Exception
     */
    protected boolean isWeChatCall(HttpServletRequest request, String token) throws Exception{
        // 获取签名值
        String signature = request.getParameter("signature");
        // 获取时间戳
        String timestamp = request.getParameter("timestamp");
        // 获取随机数
        String nonce = request.getParameter("nonce");
        // 组装Hash参数
        String[] digestP = {token,timestamp,nonce};
        Arrays.sort(digestP);
        // 微信请求验证
        return DigestUtils.generate(digestP).equalsIgnoreCase(signature);
    }
}
