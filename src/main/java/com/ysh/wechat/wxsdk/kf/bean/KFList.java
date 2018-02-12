package com.ysh.wechat.wxsdk.kf.bean;

import com.ysh.wechat.wxsdk.base.BaseResult;

import java.util.List;

/**
 * 客服列表
 *
 * @author YangShangHang
 * @date 2018/1/29
 */
public class KFList extends BaseResult {
    // 客服列表
    private List<KF> kf_list;

    public List<KF> getKf_list() {
        return kf_list;
    }

    public void setKf_list(List<KF> kf_list) {
        this.kf_list = kf_list;
    }

    public class KF {
        // 客服帐号
        private String kf_account;
        // 客服昵称
        private String kf_nick;
        // 客服编号
        private String kf_id;
        // 客服头像
        private String kf_headimgurl;
        // 客服微信号
        private String kf_wx;
        // 邀请微信号
        private String invite_wx;
        // 邀请过期时间
        private Long invite_expire_time;
        // 邀请状态
        private String invite_status;

        public String getKf_account() {
            return kf_account;
        }

        public void setKf_account(String kf_account) {
            this.kf_account = kf_account;
        }

        public String getKf_nick() {
            return kf_nick;
        }

        public void setKf_nick(String kf_nick) {
            this.kf_nick = kf_nick;
        }

        public String getKf_id() {
            return kf_id;
        }

        public void setKf_id(String kf_id) {
            this.kf_id = kf_id;
        }

        public String getKf_headimgurl() {
            return kf_headimgurl;
        }

        public void setKf_headimgurl(String kf_headimgurl) {
            this.kf_headimgurl = kf_headimgurl;
        }

        public String getKf_wx() {
            return kf_wx;
        }

        public void setKf_wx(String kf_wx) {
            this.kf_wx = kf_wx;
        }

        public String getInvite_wx() {
            return invite_wx;
        }

        public void setInvite_wx(String invite_wx) {
            this.invite_wx = invite_wx;
        }

        public Long getInvite_expire_time() {
            return invite_expire_time;
        }

        public void setInvite_expire_time(Long invite_expire_time) {
            this.invite_expire_time = invite_expire_time;
        }

        public String getInvite_status() {
            return invite_status;
        }

        public void setInvite_status(String invite_status) {
            this.invite_status = invite_status;
        }
    }

}
