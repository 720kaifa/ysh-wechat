package com.ysh.wechat.wxsdk.user.bean;

import com.ysh.wechat.wxsdk.base.BaseResult;

import java.util.List;
import java.util.Map;

/**
 * 关注用户列表
 */
public class Users extends BaseResult {

    /**
     * 描述：关注该公众账号的总用户数
     */
    private int total;

    /**
     * 描述：拉取的OPENID个数，最大值为10000
     */
    private int count;

    /**
     * 描述：OPENID的列表
     *     key：openid value：openid列表
     */
    private Map<String, List<String>> data;

    /**
     * 描述：拉取列表的最后一个用户的OPENID
     */
    private String next_openid;

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }

    public Map<String, List<String>> getData() {
        return data;
    }

    public void setData(Map<String, List<String>> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
