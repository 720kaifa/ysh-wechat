package com.ysh.wechat.wxsdk.material.bean;

import com.ysh.wechat.wxsdk.base.BaseResult;

import java.util.List;

/**
 * 描述：其他消息（图片、视频、语音）素材列表
 *
 * @author zhangmengwen
 * @date 2016/8/26
 */
public class OtherMaterialList extends BaseResult{
    /**
     * 该类型的素材的总数
     */
    private String total_count;
    /**
     * 本次调用获取的素材的数量
     */
    private String item_count;
    /**
     * 其他类型（图片、语音、视频）素材列表
     */
    private List<OtherItem> item;

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

    public List<OtherItem> getItem() {
        return item;
    }

    public void setItem(List<OtherItem> item) {
        this.item = item;
    }
}
