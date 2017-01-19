/**
 * TextTemplateService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.service.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.TextTemplate;
import com.hisign.xcky.common.JsonResult;

/**
 * 文本信息模板Service
 *
 * @author ServiceGenerator
 */
public interface TextTemplateService {
	
	/**
     * 根据id查询
     * @param id
     * @return
     */
    public JsonResult getById(String id);
    
    /**
     * 根据模板类型、案件类型查询所有
     * @author yinxiaoyong
     * @mailto yinxiaoyong@hisign.com.cn
     * 2016年12月8日
     */
    public JsonResult getAllByType(TextTemplate t);

    /**
     * 根据id删除(物理删除)
     * @param id
     */
    public JsonResult deleteById(String token, String id);

    /**
     * 根据id删除(逻辑删除)
     * @param id
     */
    public JsonResult deleteLogicById(String token, String id);

    /**
     * 根据id更新
     * @param t
     */
    public JsonResult updateById(String token, TextTemplate t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, TextTemplate t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<TextTemplate> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(TextTemplate filter);
    
    /**
     * 新增页面查找模板
     * @author yinxiaoyong
     * @mailto yinxiaoyong@hisign.com.cn
     * 2016年12月20日
     */
    public JsonResult queryListBy(TextTemplate t);
    
}
