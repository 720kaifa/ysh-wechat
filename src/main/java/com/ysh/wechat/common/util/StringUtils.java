package com.ysh.wechat.common.util;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * <p>
 * Created by wangxiao on 2016/9/18.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 数组转成字符串
     *
     * @param arrObject 数组对象
     * @param separator 分隔符
     * @return
     */
    public static String arrayToString(Object[] arrObject, String separator) {
        // 默认为","号
        if (separator == null || separator.equals(""))
            separator = ",";

        String returnStrValue = "";

        if (arrObject != null) {
            for (Object object : arrObject) {
                if (returnStrValue.equals("")) {
                    returnStrValue = String.valueOf(object);
                } else {
                    returnStrValue = returnStrValue + separator
                            + String.valueOf(object);
                }
            }
        }
        return returnStrValue;
    }

    /**
     * 换行符删除处理
     *
     * @param s 原文
     * @return 处理结果
     */
    public static String escapeLineFlag(String s) {
        int i = 0;
        while ((i = s.indexOf("\r")) != -1) {
            s = s.substring(0, i) + s.substring(i + 1);
        }
        while ((i = s.indexOf("\n")) != -1) {
            s = s.substring(0, i) + s.substring(i + 1);
        }
        return s;
    }

    /**
     * 描述: 替换所有空格（包含换行）
     *
     * @param str
     * @return
     * @auther 胡义振
     * @date 2014-9-23
     */
    public static String replaceAllBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s|\u3000|\t|\r\n|\r|\n|\n\r");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 将转义的 html 实体转为字符串.
     *
     * @param str
     * @return
     */
    public static String unescapeHtml(String str) {
        return StringEscapeUtils.unescapeHtml4(str);
    }

    /**
     * 过滤 emoji 表情。
     *
     * @param source
     * @return
     */
    public static String filterEmoji(String source) {
        if (StringUtils.isBlank(source)) {
            return "";
        }

        if (!containsEmoji(source)) {
            return source;//如果不包含，直接返回
        }

        //该buf保存非emoji的字符
        StringBuilder buf = null;
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (notisEmojiCharacter(codePoint)) {
                if (buf == null) {
                    buf = new StringBuilder(source.length());
                }
                buf.append(codePoint);
            }
        }

        if (buf == null) {
            return "";//如果没有找到非emoji的字符，则返回无内容的字符串
        } else {
            if (buf.length() == len) {
                buf = null;
                return source;
            } else {
                return buf.toString();
            }
        }
    }

    /**
     * 检测是否有emoji字符
     *
     * @param source
     * @return
     */
    public static boolean containsEmoji(String source) {
        int len = source.length();
        for (int i = 0; i < len; i++) {
            char codePoint = source.charAt(i);
            if (!notisEmojiCharacter(codePoint)) {
                //判断确认有表情字符
                return true;
            }
        }
        return false;
    }

    /**
     * 非emoji表情字符判断
     *
     * @param codePoint
     * @return
     */
    private static boolean notisEmojiCharacter(char codePoint) {
        return (codePoint == 0x0) ||
                (codePoint == 0x9) ||
                (codePoint == 0xA) ||
                (codePoint == 0xD) ||
                ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }
}
