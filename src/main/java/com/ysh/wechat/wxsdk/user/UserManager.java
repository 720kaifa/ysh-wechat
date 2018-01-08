package com.ysh.wechat.wxsdk.user;

import com.ysh.wechat.wxsdk.token.TokenManager;
import com.ysh.wechat.wxsdk.user.bean.UserBatch;
import com.ysh.wechat.wxsdk.user.bean.UserBatchParam;
import com.ysh.wechat.wxsdk.user.bean.UserInfo;
import com.ysh.wechat.wxsdk.user.bean.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 用户管理器
 */
public class UserManager {


    private static Logger logger = LoggerFactory.getLogger(UserManager.class);

    /**
     * 获取用户列表
     *
     * @param appID       微信appId
     * @param appsecret   微信appsecret
     * @param next_openid 第一个拉取的OPENID，不填默认从头开始拉取
     * @throws Exception
     */
    public static Users getUserList(String appID, String appsecret, String next_openid) throws Exception {
        Users users = UserAPI.getUserList(TokenManager.getToken(appID, appsecret).getAccess_token(), next_openid);
        return users;
    }

    /**
     * 批量获取用户信息，一次 100 条。
     *
     * @param appID       微信appId
     * @param appsecret   微信appsecret
     * @param map         参数
     * @return
     * @throws Exception
     */
    public static UserBatch getUserInfoBatch(String appID, String appsecret, Map<String, List<UserBatchParam>> map) throws Exception {
        return UserAPI.getUserInfoBatch(TokenManager.getToken(appID, appsecret).getAccess_token(), map);
    }

    /**
     * 获取单个用户信息。
     * @param appID
     * @param appsecret
     * @param openid
     * @return
     * @throws Exception
     */
    public static UserInfo getUserInfo(String appID, String appsecret, String openid) throws Exception {
        return UserAPI.getUserInfo(TokenManager.getToken(appID, appsecret).getAccess_token(), openid);
    }
}
