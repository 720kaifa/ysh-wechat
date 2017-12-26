package com.ysh.wechat.wxsdk.material.bean;

import com.ysh.wechat.wxsdk.base.BaseResult;

import java.util.List;

/**
 * 描述：图文消息素材列表
 *
 * @author zhangmengwen
 * @date 2016/8/25
 */
public class NewsMaterialList extends BaseResult{
    /**
     * 该类型的素材的总数
     */
    private String total_count;
    /**
     * 本次调用获取的素材的数量
     */
    private String item_count;
    /**
     * 图文素材列表
     */
    private List<NewsItem> item;

    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public String getItem_count() {
        return item_count;
    }

    public void setItem_count(String item_count) {
        this.item_count = item_count;
    }

    public List<NewsItem> getItem() {
        return item;
    }

    public void setItem(List<NewsItem> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "NewsMaterialList{" +
                "total_count='" + total_count + '\'' +
                ", item_count='" + item_count + '\'' +
                ", item=" + item +
                '}';
    }
}
