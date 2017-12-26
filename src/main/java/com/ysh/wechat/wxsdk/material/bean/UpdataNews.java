package com.ysh.wechat.wxsdk.material.bean;

/**
 * 描述：修改图文对象
 */
public class UpdataNews {
    /**
     * 素材ID
     */
    private String media_id;
    /**
     * 要更新的文章在图文消息中的位置
     */
    private String index;
    /**
     * 文章
     */
    private News articles;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public News getArticles() {
        return articles;
    }

    public void setArticles(News articles) {
        this.articles = articles;
    }


}
