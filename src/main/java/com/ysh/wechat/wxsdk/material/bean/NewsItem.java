package com.ysh.wechat.wxsdk.material.bean;

import java.util.List;

/**
 * 描述：图文消息素材列表item结构
 *
 * @author zhangmengwen
 * @date 2016/8/25
 */
public class NewsItem {
    /**
     * 素材id
     */
    private String media_id;
    /**
     * 图文内容
     */
    private NewsContent content;
    /**
     * 更新时间
     */
    private Long update_time;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public NewsContent getContent() {
        return content;
    }

    public void setContent(NewsContent content) {
        this.content = content;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }

    /**
     * 内部类, 图文内容
     */
    public class NewsContent {
        /**
         * 图文消息集合
         */
        private List<News> news_item;

        public List<News> getNews_item() {
            return news_item;
        }

        public void setNews_item(List<News> news_item) {
            this.news_item = news_item;
        }

        @Override
        public String toString() {
            return "NewsContent{" +
                    "news_item=" + news_item +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "media_id='" + media_id + '\'' +
                ", content=" + content +
                ", update_time=" + update_time +
                '}';
    }
}
