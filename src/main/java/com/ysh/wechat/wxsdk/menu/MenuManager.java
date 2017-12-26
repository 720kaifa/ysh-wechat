package com.ysh.wechat.wxsdk.menu;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysh.wechat.wxsdk.base.BaseResult;
import com.ysh.wechat.wxsdk.common.utils.StringUtils;
import com.ysh.wechat.wxsdk.menu.bean.Menu;
import com.ysh.wechat.wxsdk.token.TokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 菜单管理器
 * Created by yushunwei on 2016/8/14.
 */
public class MenuManager {

    private static Logger logger = LoggerFactory.getLogger(MenuManager.class);

    /**
     * 菜单创建
     *
     * @param menu      菜单
     * @param appID     微信appId
     * @param appsecret 微信appsecret
     * @throws Exception
     */
    public static void initMenu(Menu menu, String appID, String appsecret) throws Exception {
        BaseResult result = MenuAPI.menuCreate(TokenManager.getToken(appID, appsecret).getAccess_token(), menu);
        if (result.isSuccess()) {
            logger.info("菜单创建成功！");
        } else {
            logger.error("菜单创建失败:{}", result.getErrcode() + "<->" + result.getErrmsg());
        }
    }

    /**
     * 通过 json 字符串创建菜单.
     *
     * @param jsonStr   json 字符串.
     * @param appID     微信 appId
     * @param appSecret 微信 appSecret
     * @return
     * @throws Exception
     */
    public static boolean initMenuByJson(String jsonStr, String appID, String appSecret) throws Exception {
        BaseResult result = MenuAPI.menuCreate(TokenManager.getToken(appID, appSecret).getAccess_token(), jsonStr);
        return result.isSuccess();
    }

    /**
     * 获取菜单列表
     *
     * @param appID     微信appId
     * @param appsecret 微信appsecret
     * @return
     * @throws Exception
     */
    public static String getMenus(String appID, String appsecret) throws Exception {
        String menus = MenuAPI.getMenus(TokenManager.getToken(appID, appsecret).getAccess_token());

        if (StringUtils.isEmpty(menus)) {
            logger.error("菜单列表获取失败!");
            return "error";
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(menus);

        // 微信返回错误处理。
        if(node.get("errcode") != null) {
            logger.error("菜单列表获取失败!");
            return "error";
        }

        // 获取 menu 节点。
        JsonNode menu = node.get("menu");
        // 格式化 json 字符串。
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(menu);
    }

}
