package com.ysh.wechat.message.controller;

import com.ysh.wechat.wxsdk.kf.KFAPI;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 描述: 发送客服消息控制器 .<br>
 *
 * @author YangShangHang
 * @date 2018/2/23
 */
@Controller
@RequestMapping("/send/kf")
public class KFMessageController {

    /**
     * 发送客服图片消息
     *
     * @param openId   微信openid
     * @param media_id 图片媒体id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public String sendKFImageMessage(@RequestParam(name = "openId", required = true) String openId,
                                     @RequestParam(name = "media_id", required = true) String media_id) throws Exception {
        KFAPI.sendKFImageMessage(openId, media_id);
        return "sendSuccess";
    }
}
