package com.hisign.xcky.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hisign.sdk.cache.redis.RedisClient;
import com.hisign.xcky.api.model.common.BaseModel;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.util.DateUtil;
import com.hisign.xcky.util.JsonResultUtil;
import com.hisign.xcky.util.UUIDService;

/**
 * 接口实现基础类
 * 
 * @author Hong 
 */
public abstract class BaseServiceImpl<T extends BaseModel> {

	public abstract Mapper<T> getMapper();
	
	@Autowired
	protected RedisClient  redisClient;

	/**
	 * 根据id条件查询
	 * 
	 * @param id
	 * @throws Exception
	 * @return
	 */
	public JsonResult getById(String id) {
		return JsonResultUtil.success(getMapper().getById(id));
	}

	/**
	 * 返回分页后的数据
	 * 
	 * @param t
	 * @return
	 */
	public JsonResult query(T t) {
		t.setDeleteFlag(Constants.DELETE_FALSE);
		return JsonResultUtil.success(getMapper().query(t));
	}

	/**
	 * 根据id删除记录（物理删除）
	 * 
	 * @param id
	 */
	public JsonResult deleteById(String id) {
		getMapper().deleteById(id);
		return JsonResultUtil.success();
	}

	/**
	 * 根据id删除记录（逻辑删除）
	 * 
	 * @param t
	 * @param token
	 */
	public JsonResult deleteLogicById(T t, String token) {
		SysUser optUser = getCurrentUser(token);

		t.setVersion(this.generateVersion());
		t.setUpdateUserId(optUser.getId());
		t.setUpdateTime(this.getSyetemTime());
		t.setDeleteFlag(Constants.DELETE_TRUE);

		return JsonResultUtil.success(getMapper().deleteLogicById(t));
	}

	/**
	 * 根据id更新记录
	 * 
	 * @param t
	 * @param token
	 */
	public JsonResult updateById(T t, String token) {
		SysUser optUser = getCurrentUser(token);

		t.setVersion(this.generateVersion());
		t.setUpdateUserId(optUser.getId());
		t.setUpdateTime(this.getSyetemTime());

		return JsonResultUtil.success(getMapper().updateById(t));
	}

	/**
	 * 新增记录
	 * 
	 * @param t
	 * @param token
	 */
	public JsonResult add(T t, String token) {
		SysUser optUser = getCurrentUser(token);
		Date now = this.getSyetemTime();
		if(t.getId()==null||"".equals(t.getId())){
			t.setId(this.generateUUID());
		}
		t.setVersion(this.generateVersion());
		t.setCreateUserId(optUser.getId());
		t.setUpdateUserId(optUser.getId());
		t.setCreateTime(now);
		t.setUpdateTime(now);
		t.setDeleteFlag(Constants.DELETE_FALSE);
		// 数据来源，默认XCKY
		if (StringUtils.isBlank(t.getSource())) {
			t.setSource(Constants.SYSTEMID);
		}

		getMapper().add(t);

		return JsonResultUtil.success(t);
	}

	/**
	 * 批量新增
	 * 
	 * @param list
	 * @param token
	 */
	public JsonResult addBatch(List<T> list, String token) {
		if (null == list) {
			return JsonResultUtil.error("argument is null");
		}

		for (T t : list) {
			add(t, token);
		}
		return JsonResultUtil.success();
	}
	
	/**
     * 查询
     * @param t 查询条件
     */
    public JsonResult queryPage(T t) {
    	PageHelper.offsetPage(t.getBegin()-1, t.getEnd()-t.getBegin()+1);
		t.setDeleteFlag(Constants.DELETE_FALSE);
    	List<T> list = getMapper().query(t);
		PageInfo<T> pageInfo = new PageInfo<T>(list);
    	return JsonResultUtil.success(pageInfo.getTotal(), list);
    }

	/**
	 * 生成UUID
	 * 
	 * @return
	 */
	public String generateUUID() {
		return UUIDService.getInstance().simpleHex();
	}

	/**
	 * 生成版本号
	 * 
	 * @return
	 */
	public long generateVersion() {
		return System.currentTimeMillis();
	}

	/**
	 * 获取系统当前时间
	 * 
	 * @return
	 */
	public Date getSyetemTime() {
		return DateUtil.getSystemTime();
	}

	/**
	 * 根据token获取当前用户信息（Redis缓存获取）
	 * 
	 * @param token
	 * @return
	 */
	public SysUser getCurrentUser(String token) {
		SysUser sysUser=redisClient.getObj(token, SysUser.class);
		if(sysUser!=null){
			return sysUser;
		}else{
			return null;
		}
	}
	

}
