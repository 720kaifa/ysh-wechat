package com.ysh.wechat.wxsdk.common.utils;

/**
 * 字符串工具类
 * Created by yangshanghang on 2017/12/21.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 任意字符串拼接
     *
     * @param strParam 任意字符串
     * @return 拼接结果
     */
    public static String assemblyString(Object... strParam) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0,length=strParam.length; i < length; i++) {
            String string = String.valueOf(strParam[i]);
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }
}
