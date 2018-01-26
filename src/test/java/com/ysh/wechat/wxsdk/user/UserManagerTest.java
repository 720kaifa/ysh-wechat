package com.ysh.wechat.wxsdk.user;

import com.ysh.wechat.wxsdk.user.bean.UserInfo;

/**
 * 描述: 用户管理测试类 .<br>
 *
 * @author YangShangHang
 * @date 2017/12/28
 */
public class UserManagerTest {

    public static void main(String[] args) throws Exception {
        String appid="wxb30db395cd795bd5";
        String appsecret="519770045855ca51b7d70314ba732dd0";
        String openId = "oOo03wmaeD16EPD_UmFJ3euaB--w";
        UserInfo userInfo = UserManager.getUserInfo(appid, appsecret, openId);
        System.out.println(userInfo);
    }
}
