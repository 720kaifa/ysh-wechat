package com.ysh.wechat.core.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信Service
 *
 * Created by yangshanghang on 2017/12/21.
 */
public interface IWechatService {

    /**
     * 处理消息
     *
     * @param request 请求
     * @return 处理结果
     * @throws Exception
     */
    String processRequest(HttpServletRequest request) throws Exception;

    /**
     * 定时刷新token和ticket
     * @throws Exception
     */
    void refreshScheduled() throws Exception;
}
