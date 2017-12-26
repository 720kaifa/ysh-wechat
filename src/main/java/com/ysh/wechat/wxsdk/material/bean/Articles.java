package com.ysh.wechat.wxsdk.material.bean;

import java.util.List;


/**
 * 描述: 素材articles .<br>
 *
 * @author YangShangHang
 * @date 2016/8/28
 */
public class Articles {
    private List<News> articles;

    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
    }
}
