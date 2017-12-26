package com.ysh.wechat.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

/**
 * 自定义通用拦截器
 */
public class GenericInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(GenericInterceptor.class);
    private static final Pattern pattern = Pattern.compile("[%*]+");

    public GenericInterceptor() {
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        if (pattern.matcher(uri).find()) {
            logger.debug("No matching resource " + uri + " found - returning 404");
            response.sendError(404);
            return false;
        } else {
            return true;
        }
    }
}
