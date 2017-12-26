package com.ysh.wechat.wxsdk.material;

import com.ysh.wechat.wxsdk.material.bean.*;
import com.ysh.wechat.wxsdk.material.enums.EMateriaType;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：素材管理器
 *
 * @author zhangmengwen
 * @date 2016/8/26
 */
public class MaterialManager {

    /**
     * 描述：获取永久图文素材
     *
     * @param media_id     素材id
     * @param access_token token
     * @return 永久图文素材
     * @throws Exception
     */
    public static NewsMaterials getForeverNewsMaterial(String media_id, String access_token) throws Exception {
        //获取图文信息
        return MaterialAPI.getForeverNewsMaterial(media_id, access_token);
    }

    /**
     * 描述：获取素材总数
     *
     * @param type         素材类型
     * @param access_token token
     * @return 素材总数
     * @throws Exception
     */
    public static int getMaterialCount(String type, String access_token) throws Exception {
        Map<String, Object> materialCount = MaterialAPI.getMaterialCount(access_token);
        int result = 0;
        if (type.equals(EMateriaType.MATERIAL_TYPE_VOICE.getValue())) {
            result = (int) materialCount.get("voice_count");
        } else if (type.equals(EMateriaType.MATERIAL_TYPE_VIDEO.getValue())) {
            result = (int) materialCount.get("video_count");
        } else if (type.equals(EMateriaType.MATERIAL_TYPE_IMAGE.getValue())) {
            result = (int) materialCount.get("image_count");
        } else if (type.equals(EMateriaType.MATERIAL_TYPE_NEWS.getValue())) {
            result = (int) materialCount.get("news_count");
        }
        return result;
    }

    /**
     * 获取永久图文素材列表
     *
     * @param access_token access_token
     * @param type         素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
     * @param offset       返回素材的偏移位置
     * @param count        返回素材的数量
     * @return 永久图文素材列表
     * @throws Exception
     */
    public static NewsMaterialList getForeverNewsMaterialsList(String access_token, String type, String offset, String count) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("type", type);
        map.put("offset", offset);
        map.put("count", count);
        return MaterialAPI.getForeverNewsMaterialsList(access_token, map);
    }

    /**
     * 获取永久其他素材（图片、语音、视频）列表
     *
     * @param access_token access_token
     * @param type         素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
     * @param offset       返回素材的偏移位置
     * @param count        返回素材的数量
     * @return 永久其他素材（图片、语音、视频）列表
     * @throws Exception
     */
    public static OtherMaterialList getForeverOtherMaterialsList(String access_token, String type, String offset, String count) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("type", type);
        map.put("offset", offset);
        map.put("count", count);
        return MaterialAPI.getForeverOtherMaterialsList(access_token, map);
    }

    /**
     * 描述：新增永久图文素材
     *
     * @param access_token token
     * @param articles     素材article结构
     * @return 新增的素材id
     * @throws Exception
     */
    public static String addForeverNewsMaterial(String access_token, Articles articles) throws Exception {
        return MaterialAPI.addForeverNewsMaterial(access_token, articles);
    }


    /**
     * 描述：修改图文素材
     *
     * @param access_token token
     * @param updateNews   更新素材对象
     * @return
     * @throws Exception
     */
    public static String updateNewsMaterial(String access_token, UpdataNews updateNews) throws Exception {
        return MaterialAPI.updateNewsMaterial(access_token, updateNews);
    }
}
