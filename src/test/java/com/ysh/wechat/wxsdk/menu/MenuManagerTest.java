package com.ysh.wechat.wxsdk.menu;


import com.ysh.wechat.common.constant.ConfigConstant;
import com.ysh.wechat.common.util.JSONUtils;
import com.ysh.wechat.wxsdk.menu.bean.Button;
import com.ysh.wechat.wxsdk.menu.bean.ComplexButton;
import com.ysh.wechat.wxsdk.menu.bean.Menu;
import com.ysh.wechat.wxsdk.menu.bean.ViewButton;


/**
 * 描述: 自定义菜单设置 测试类 .<br>
 *
 * @author YangShangHang
 * @date 2017/12/26
 */
public class MenuManagerTest {

    /**
     * 自定义菜单设置
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // 菜单一中的二级菜单
        ViewButton btn11 = new ViewButton();
        btn11.setName("内网穿透");
        btn11.setUrl("https://natapp.cn/");

        ComplexButton btn1 = new ComplexButton();
        btn1.setName("菜单一");
        btn1.setSub_button(new Button[]{btn11});


        // 菜单二中的二级菜单
        ViewButton btn21 = new ViewButton();
        btn11.setName("echarts");
        btn11.setUrl("http://echarts.baidu.com/");

        ComplexButton btn2 = new ComplexButton();
        btn2.setName("菜单二");
        btn2.setSub_button(new Button[]{btn21});


        // 一级菜单“百度查询”
        ViewButton btn3 = new ViewButton();
        btn3.setName("百度查询");
        btn3.setUrl("http://www.baidu.com");

        Menu menu = new Menu();
        menu.setButton(new Button[]{btn1, btn2, btn3});

        System.out.println(JSONUtils.parse(menu));
        MenuManager.initMenu(menu, ConfigConstant.APP_ID_WECHAT, ConfigConstant.APP_SECRET_WECHAT);
    }
}
