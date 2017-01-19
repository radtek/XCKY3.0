package com.hisign.xcky.api.service.sceneQuery;

import com.hisign.xcky.api.model.sceneCollecting.SceneCollectedGoods;
import com.hisign.xcky.common.JsonResult;

/**
 * 提取物品分页查询接口
 * @Author hotdog
 * @Mail zhaoqian@hisign.com.cn
 * @Date 2017/1/10 16:41
 */
public interface SceneCollectedGoodsPageService {

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(String token, SceneCollectedGoods filter);
}
