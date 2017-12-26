package com.ysh.wechat.core.controller;

import com.ysh.wechat.common.constant.ConfigConstant;
import com.ysh.wechat.core.service.IWechatService;
import com.ysh.wechat.wxsdk.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信核心控制类
 * <p>
 * Created by yangshanghang on 2017/12/21.
 */
@RestController
@RequestMapping("/core")
public class WechatController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(WechatController.class);

    /**
     * 微信Service
     */
    @Autowired
    private IWechatService wechatService;

    /**
     * 开发者接入
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/service", method = RequestMethod.GET, produces = "text/plain")
    public String validate(HttpServletRequest request) throws Exception {
        if (isWeChatCall(request, ConfigConstant.TOKEN_WECHAT)) {
            String echostr = request.getParameter("echostr");
            logger.info("接入成功！echostr:" + echostr);
            return echostr;
        }
        return "error";
    }

    /**
     * 处理消息
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/service", method = RequestMethod.POST, produces = "application/xml;charset=UTF-8")
    public String processMsg(HttpServletRequest request) throws Exception {
        if (!isWeChatCall(request, ConfigConstant.TOKEN_WECHAT)) {
            return "";
        }
        return wechatService.processRequest(request);
    }
}
