package com.hisign.xcky.api.service.sceneCollecting;

import java.util.List;

import com.hisign.xcky.api.model.sceneCollecting.CameraInfo;
import com.hisign.xcky.common.JsonResult;

/**
 * 摄像头业务接口
 * 项目名称：xcky-api   
 * 类名称：CameraInfoService   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-19 上午10:48:25   
 * 修改人：hisign   
 * 修改时间：2016-12-19 上午10:48:25   
 * 修改备注：   
 * @version
 */
public interface CameraInfoService {
	/**
     * 根据id查询
     * @param id
     * @return
     */
    public JsonResult getById(String id);

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
    public JsonResult updateById(String token, CameraInfo t);

    /**
     * 新增
     * @param t 新增对象
     */
    public JsonResult add(String token, CameraInfo t);

    /**
     * 批量新增
     * @param list 对象列表
     */
    public JsonResult addBatch(String token, List<CameraInfo> list);

    /**
     * 分页查询
     * @param filter 查询条件对象
     */
    public JsonResult queryPage(CameraInfo filter);
    /**
     * 根据勘验ID查询
     * 方法功能说明：  
     * 创建：2016-12-19 下午2:10:21 by guochen
     * @参数： 
     * @参数：    
     * @return  
     * @throws
     */
	public List<CameraInfo> findListByInvestigationId(String investigationId);
}
