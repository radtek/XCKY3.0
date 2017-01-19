package com.hisign.xcky.api.service.system;

import javax.servlet.http.HttpServletRequest;

import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.common.JsonResult;


/**
 * 登录注销service
 * @author yinxiaoyong
 * @mailto yinxiaoyong@hisign.com
 * 2016年11月5日
 */
public interface LoginService {

	/**
	 * REST登录接口
	 * @param msgReq
	 * @return
	 */
	public JsonResult login(HttpServletRequest request,SysUser sysUser);

	/**
	 * REST注销接口
	 * @param token
	 * @return
	 */
	public JsonResult logout(String token) throws Exception ;

}
