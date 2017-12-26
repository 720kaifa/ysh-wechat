package com.ysh.wechat.wxsdk.common.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * xml工具类
 * Created by yangshanghang on 2017/12/21.
 */
public class XMLUtils {
    // 定义支持<![CDATA[的xStream
    private static XStream xStream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                boolean cdata = true;

                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    /**
     * xml消息解析
     *
     * @param request 请求
     * @return 解析后的结果 k-v形式
     * @throws Exception
     */
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<>();

        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        Element root = document.getRootElement();

        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // 释放资源
        inputStream.close();
        return map;
    }

    /**
     * 对象转换为XML
     *
     * @param t   对象
     * @param <T> 对象泛型
     * @return 转换后的xml
     * @throws Exception
     */
    public static <T> String parseXml(T t) throws Exception {
        xStream.processAnnotations(t.getClass());
        return xStream.toXML(t);
    }

    /**
     * XML转换为java对象
     *
     * @param xml   xml字符串内容
     * @param clazz 泛型
     * @param <T>   泛型对象
     * @return 泛型对象
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <T> T parseObject(String xml, Class<T> clazz) {
        xStream.processAnnotations(clazz);
        return (T) xStream.fromXML(xml);
    }
}
