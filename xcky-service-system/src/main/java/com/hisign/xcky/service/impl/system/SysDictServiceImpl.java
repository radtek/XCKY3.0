/**
 * SysDictService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service.impl.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.hisign.sso.api.rest.exception.RestBusinessException;
import com.hisign.xcky.api.model.system.SysDict;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.system.SysDictService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.persist.mapper.system.SysDictMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 系统字典信息Service实现
 *
 * @author ServiceGenerator
 */
@Path("/sysDict")
@Consumes({ MediaType.APPLICATION_JSON})
@Produces({ ContentType.APPLICATION_JSON_UTF_8})
@Service("sysDictService")
@Transactional
public class SysDictServiceImpl extends BaseServiceImpl<SysDict> implements SysDictService {
	
	private final static Logger logger = LoggerFactory.getLogger(SysDictServiceImpl.class);
	
	@Resource
    private SysDictMapper sysDictMapper;

    @Override
	public Mapper<SysDict> getMapper() {
		return sysDictMapper;
	}

	@Override
	public List<SysDict> findByParentKey(String rootKey) {
		return sysDictMapper.findByParentKey(rootKey);
	}

	/* (non-Javadoc)
	 * @see com.hisign.xcky.api.service.system.SysDictService#findSingleDictByRootKey(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Path("single/{rootKey}")
	@GET
	public JsonResult findSingleDictByRootKey(@PathParam("rootKey") String root) throws Exception {
		if (StringUtils.isEmpty(root)) {
			throw new RestBusinessException(Status.NOT_FOUND, "参数为空");
		}
		logger.info("根据ROOT_KEY:[{}]查询单级字典",root);
		String key = Constants.Redis.RES_DICT_PREFIX+root;
		//先从缓存中读取
		List<SysDict> list =redisClient.lrangeObj(key, 0, -1, SysDict.class);
		if (list!=null&&list.size()>0) {
			return JsonResultUtil.success(list);
		} else {
			list = sysDictMapper.findSingleDictByRootKey(root);
			//放入缓存中
			if (!list.isEmpty()) {
				redisClient.rpushAllObj(key, list);
				redisClient.expire(key,Constants.Redis.EXPIRE_TIME, TimeUnit.HOURS); //有效时间2小时
			}
			return JsonResultUtil.success(list);
		}
	}

	@Override
	@Path("{root}/{keys}")
	@GET
	public JsonResult findDictByRootAndKey(@PathParam("root")String root, @PathParam("keys")String keys) throws Exception {
		if (StringUtils.isEmpty(root) || StringUtils.isEmpty(keys)) {
			throw new RestBusinessException(Status.NOT_FOUND, "参数为空");
		}
		logger.info("根据ROOT_KEY:[{}],DICT_KEY:[{}]查询单级字典",root,keys);
		JSONArray resList = new JSONArray();
		Map<String,String> map = null;
		String _value = null;
		String[] _key = keys.split("&");
		SysDict dict = new SysDict();
		dict.setRootKey(root);
		for (int i = 0, l = _key.length; i < l; i++) {
			dict.setDictKey(_key[i]);
			_value = sysDictMapper.findDictByobj(dict);
			map = new HashMap<String, String>();
			map.put("key",_key[i]);
			map.put("value",_value);
			resList.add(map);
		}
		return JsonResultUtil.success(resList);
	}

	@Override
	@Path("tree/{rootKey}")
	@GET
	public JsonResult findTreeListByKey(@PathParam("rootKey") String rootKey) {
		List<SysDict> list = sysDictMapper.findTreeListByKey(rootKey);
		return JsonResultUtil.success(list);
	}

	@Override
	public List<SysDict> findParentByKey(String dictKey) {
		return sysDictMapper.findParentByKey(dictKey);
	}

	@Override
	public String findSysDictValueByKeys(String dictKey, String rootKey) {
		// TODO Auto-generated method stub
		SysDict dict = new SysDict();
		dict.setDictKey(dictKey);
		dict.setRootKey(rootKey);
		return sysDictMapper.findDictByobj(dict);
	}
    
}
