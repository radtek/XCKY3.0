package com.hisign.xcky.api.service.system;

import com.hisign.xcky.api.model.system.SysCustomCaseType;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.common.JsonResult;

/**
 * 自定义案件类别分组服务接口
 * @Author hotdog
 * @Mail zhaoqian@hisign.com.cn
 * @Date 2017/1/12 14:03
 */
public interface SysCustomCaseTypeService {
    /**
     * 方法功能说明： 案件类别分组新增
     * 创建：2017-1-12 by hotdog
     * @参数： @param t
     * @参数： @param token
     * @参数： @return
     * @参数： @throws Exception
     * @return JsonResult
     */
     JsonResult add(SysCustomCaseType t, String token) throws Exception;

    /**
     *
     * @param t
     */
     void addSub (SysCustomCaseType t);

    /**
     * 方法功能说明： 案件类别分组编辑
     * 创建：2017-1-12 by hotdog
     * @参数： @param t
     * @参数： @param token
     * @参数： @return
     * @参数： @throws Exception
     * @return JsonResult
     */
     JsonResult update(SysCustomCaseType t, String token) throws Exception;

    /**
     * 方法功能说明：分页查询
     * 创建：2017-1-12 by hotdog
     * @参数： @param t
     * @参数： @return
     * @参数： @throws Exception
     * @return JsonResult
     */
     JsonResult pagequery(SysCustomCaseType t) throws Exception;

    /**
     * 方法功能说明： 案件类别分组删除
     * @return
     * @throws Exception
     */
     JsonResult delete (String groupId) throws Exception;

}
