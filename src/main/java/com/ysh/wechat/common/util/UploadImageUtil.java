package com.ysh.wechat.common.util;

import com.ysh.wechat.wxsdk.token.TokenManager;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 描述: 图片素材上传工具类 .<br>
 *
 * @author YangShangHang
 * @date 2018/3/9
 */
public class UploadImageUtil {

    private static final Logger logger = LoggerFactory.getLogger(UploadImageUtil.class);

    /**
     * 调用微信接口上传永久图片素材
     *
     * @param accessToken 微信accessToken
     * @param filePath    图片文件地址
     * @return 结果（素材id media_id）
     * @throws IOException 异常
     */
    public static String postFile(String accessToken, String filePath) throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?type=image&access_token=" + accessToken;

        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("文件不存在");
        }
        String result = null;
        try {
            URL url1 = new URL(url);
            // 连接
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
            /**
             * 设置关键值
             */
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);  // post方式不能使用缓存
            conn.setRequestMethod("POST");  // 以Post方式提交表单，默认get方式
            // 设置请求头信息
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Cache-Control", "no-cache");
            // 设置边界
            String boundary = "-----------------------------" + System.currentTimeMillis();
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            // 请求正文信息
            OutputStream output = conn.getOutputStream();
            output.write(("--" + boundary + "\r\n").getBytes());
            output.write(
                    String.format("Content-Disposition: form-data; name=\"media\"; filename=\"%s\"\r\n", file.getName())
                            .getBytes());
            output.write("Content-Type: image/jpeg \r\n\r\n".getBytes());
            byte[] data = new byte[1024];
            int len = 0;
            FileInputStream input = new FileInputStream(file);
            while ((len = input.read(data)) > -1) {
                output.write(data, 0, len);
            }
            output.write(("\r\n--" + boundary + "\r\n\r\n").getBytes());
            output.flush();
            output.close();
            input.close();
            InputStream resp = conn.getInputStream();
            StringBuffer sb = new StringBuffer();
            while ((len = resp.read(data)) > -1)
                sb.append(new String(data, 0, len, "utf-8"));
            resp.close();
            result = sb.toString();
        } catch (ClientProtocolException e) {
            logger.error("postFile，不支持http协议", e);
        } catch (IOException e) {
            logger.error("postFile数据传输失败", e);
        }
        System.out.println(result);
        return result;
    }


    public static void main(String[] args) throws Exception {
        String accessToken = TokenManager.getToken("wxb30db395cd795bd5", "519770045855ca51b7d70314ba732dd0").getAccess_token();
        postFile(accessToken, "C:/Penguins.jpg");
    }
}
