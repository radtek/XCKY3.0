package com.hisign.xcky.api.service.system;

import com.hisign.sso.api.entity.sys.MenuResource;
import com.hisign.xcky.common.JsonResult;

/**
 * 系统参数管理接口
 * @author xiaohuiwen
 * @since 2016/06/01 14:51
 */
public interface SysModuleService {
	
	/**
     * 根据id查询
     * @param id
     * @return
     */
    public JsonResult getById(String id);
	
    /**
     * 查询所有模块信息
     * @Author xiaohuiwen
     * @throws Exception
     * @return
     */
    public JsonResult list(String token) throws Exception;
    
    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, MenuResource t);
    
    /**
     * 根据id删除(物理删除)
     * @param id
     */
    public JsonResult deleteById(String token, MenuResource id);

    /**
     * 根据id删除(逻辑删除)
     * @param id
     */
    public JsonResult deleteLogicById(String token, MenuResource id);

    /**
     * 根据id更新
     * @param t
     */
    public JsonResult updateById(String token, MenuResource t);
}
