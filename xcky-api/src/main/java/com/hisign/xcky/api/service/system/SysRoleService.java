package com.hisign.xcky.api.service.system;

import java.util.Map;

import com.hisign.xcky.api.model.system.SysRole;
import com.hisign.xcky.common.JsonResult;


/**  
 * @类功能说明：   系统角色信息Service
 * @作者：hotdog  
 * @创建时间：2016-11-11 下午1:40:21  
 */ 
public interface SysRoleService {

	/**  
	 * 方法功能说明：  获得字典角色数据
	 * 创建：2016-11-11 by hotdog   
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult findAllRole() throws Exception;
	
	/**  
	 * 方法功能说明：  查看角色信息
	 * 创建：2016-11-16 by hotdog   
	 * @参数： @param roleId
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult view (String roleId) throws Exception;
	
	/**  
	 * 方法功能说明：  分页查询
	 * 创建：2016-11-16 by hotdog   
	 * @参数： @param t
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult pagequery (SysRole t) throws Exception;
	
	/**  
	 * 方法功能说明：  角色新增
	 * 创建：2016-11-16 by hotdog   
	 * @参数： @param t
	 * @参数： @param token
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult add(SysRole t, String token) throws Exception;
	
	/**  
	 * 方法功能说明：  角色修改
	 * 创建：2016-11-16 by hotdog   
	 * @参数： @param t
	 * @参数： @param token
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult update(SysRole t, String token) throws Exception;
	
	/**  
	 * 方法功能说明：  删除
	 * 创建：2016-11-16 by hotdog   
	 * @参数： @param id
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult delete (String id) throws Exception;
	
	/**  
	 * 方法功能说明：   查看权限
	 * 创建：2016-11-17 by hotdog   
	 * @参数： @return      
	 * @return JsonResult
	 */  
	public JsonResult viewPermission (Map<String, String> map) throws Exception;
	
	
	/**  
	 * 方法功能说明：  角色授权
	 * 创建：2016-11-17 by hotdog   
	 * @参数： @param map
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult grantAuthorization (Map<String, String> map) throws Exception;
	
	/**  
	 * 方法功能说明：  查看拥有此角色的用户
	 * 创建：2016-11-17 by hotdog   
	 * @参数： @param roleId
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult viewOwnedUser (String roleId) throws Exception;
	
	
	/**  
	 * 方法功能说明：    编辑用户角色关系
	 * 创建：2016-11-17 by hotdog   
	 * @参数： @param map
	 * @参数： @param option
	 * @参数： @return
	 * @参数： @throws Exception      
	 * @return JsonResult
	 */  
	public JsonResult roleuserHandle (Map<String, String> map, String option) throws Exception;
}
