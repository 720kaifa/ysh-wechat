package com.ysh.wechat.wxsdk.material.bean;

/**
 * 描述：素材图文信息
 */
public class News {

    /**
     * 图文消息的标题
     */
    private String title;

    /**
     * 图文消息的封面图片素材id
     */
    private String thumb_media_id;

    /**
     * 图文消息的封面图片的地址，第三方开发者也可以使用这个URL下载图片到自己服务器中，然后显示在自己网站上
     */
    private String thumb_url;

    /**
     * 是否显示封面，0为false，即不显示，1为true，即显示
     */
    private String show_cover_pic;

    /**
     * 作者
     */
    private String author;

    /**
     * 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空
     */
    private String digest;

    /**
     * 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS
     */
    private String content;

    /**
     * 图文页的URL
     */
    private String url;

    /**
     * 图文消息的原文地址，即点击“阅读原文”后的URL
     */
    private String content_source_url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb_media_id() {
        return thumb_media_id;
    }

    public void setThumb_media_id(String thumb_media_id) {
        this.thumb_media_id = thumb_media_id;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public String getShow_cover_pic() {
        return show_cover_pic;
    }

    public void setShow_cover_pic(String show_cover_pic) {
        this.show_cover_pic = show_cover_pic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent_source_url() {
        return content_source_url;
    }

    public void setContent_source_url(String content_source_url) {
        this.content_source_url = content_source_url;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", thumb_media_id='" + thumb_media_id + '\'' +
                ", thumb_url='" + thumb_url + '\'' +
                ", show_cover_pic='" + show_cover_pic + '\'' +
                ", author='" + author + '\'' +
                ", digest='" + digest + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", content_source_url='" + content_source_url + '\'' +
                '}';
    }
}
