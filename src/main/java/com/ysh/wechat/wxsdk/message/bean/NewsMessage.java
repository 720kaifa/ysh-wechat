package com.ysh.wechat.wxsdk.message.bean;

import com.ysh.wechat.wxsdk.base.BaseMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * 图文消息
 * Created by yushunwei on 2017/3/7.
 */
@XStreamAlias("xml")
public class NewsMessage extends BaseMessage {
    /**
     * 图文消息个数，限制为8条以内
     */
    private Integer ArticleCount;

    /**
     * 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
     */
    private List<Item> Articles;

    public Integer getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(Integer articleCount) {
        ArticleCount = articleCount;
    }

    public List<Item> getArticles() {
        return Articles;
    }

    public void setArticles(List<Item> articles) {
        Articles = articles;
    }
}
