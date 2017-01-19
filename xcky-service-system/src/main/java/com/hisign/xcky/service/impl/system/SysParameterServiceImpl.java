/**
 * SysParameterService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service.impl.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.hisign.xcky.api.model.system.SysDict;
import com.hisign.xcky.api.model.system.SysParameter;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.system.SysDictService;
import com.hisign.xcky.api.service.system.SysParameterService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.persist.mapper.system.SysParameterMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 系统参数配置Service实现
 *
 * @author ServiceGenerator
 */
@Path("/sysParameter")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("sysParameterService")
@Transactional
public class SysParameterServiceImpl extends BaseServiceImpl<SysParameter> implements SysParameterService {
	
	@Resource
    private SysParameterMapper sysParameterMapper;
	
	@Resource
	private SysDictService sysDictService;
    
    @Override
	public Mapper<SysParameter> getMapper() {
		return sysParameterMapper;
	}
    
	@Override
	@POST
	@Path("list")
	public JsonResult list(){
		List<SysDict> dictList=sysDictService.findByParentKey("XTCSLBDM");
		SysParameter sysParameter=new SysParameter();
		sysParameter.setDeleteFlag("0");
		List<SysParameter> paramList=sysParameterMapper.query(sysParameter);
		Map<String, List<SysParameter>> map = new HashMap<String, List<SysParameter>>();
		List<SysParameter> tempList=new ArrayList<SysParameter>();
		for(SysParameter sp:paramList){
            if (map.get(sp.getType()) == null) {
            	tempList = new ArrayList<SysParameter>();
            } else {
            	tempList = (List<SysParameter>) map.get(sp.getType());
            }
            tempList.add(sp);
            map.put(sp.getType(),tempList);
		}
		for(SysDict sysDict:dictList){
			if(map.get(sysDict.getDictKey())!=null){
				sysDict.setData(map.get(sysDict.getDictKey()));
			}
		}
		return JsonResultUtil.success(dictList.size(),dictList);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
    @GET
	@Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult getById(@PathParam("id")String id) {
		return super.getById(id);
    }

    /**
     * 根据id删除(物理删除)
     * @param id
     */
    @Override
    @POST
	@Path("del")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult deleteById(@HeaderParam("token") String token, String id) {
    	return super.deleteById(id);
    }

    /**
     * 根据id删除(逻辑删除)
     * @param id
     */
    @Override
    @POST
	@Path("delLogic")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult deleteLogicById(@HeaderParam("token") String token, String id) {
    	SysParameter t = new SysParameter();
    	t.setId(id);
    	return super.deleteLogicById(t, token);
    }

    /**
     * 根据id更新
     * @param t 更新对象
     */
    @Override
    @POST
	@Path("upd")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult updateById(@HeaderParam("token") String token, SysParameter t) {
    	JsonResult JsonResult=super.updateById(t, token);
    	String redisKey = Constants.Redis.RES_PARAMS_PREFIX+t.getKey();
    	redisClient.setObj(redisKey, t);
		redisClient.expire(redisKey,Constants.Redis.EXPIRE_TIME, TimeUnit.HOURS); //有效时间2小时
    	return JsonResult;
    }

    /**
     * 新增
     * @param t 新增对象
     */
    @Override
    @POST
	@Path("add")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult add(@HeaderParam("token") String token, SysParameter t) {
    	SysParameter sysParameter = sysParameterMapper.getByKey(t.getKey());
    	if(sysParameter!=null){
    		return JsonResultUtil.error("参数英文名重复!");
    	}
    	return super.add(t, token);
    }

    /**
     * 批量新增
     * @param list 对象列表
     */
    @Override
    @POST
	@Path("addBatch")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult addBatch(@HeaderParam("token") String token, List<SysParameter> list) {
    	return super.addBatch(list, token);
    }

    /**
     * 查询
     * @param t 查询条件
     */
    @Override
    @POST
	@Path("query")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult queryPage(SysParameter t) {
    	return super.queryPage(t);
    }

    @Override
    @POST
	@Path("getByKey")
    @Consumes({MediaType.APPLICATION_JSON})
	public SysParameter getByKey(String key) {
    	String redisKey = Constants.Redis.RES_PARAMS_PREFIX+key;
    	SysParameter sysParameter = redisClient.getObj(redisKey, SysParameter.class);
		if(sysParameter==null){
			sysParameter = sysParameterMapper.getByKey(key);
			if(sysParameter!=null){
				redisClient.setObj(redisKey, sysParameter);
				redisClient.expire(redisKey,Constants.Redis.EXPIRE_TIME, TimeUnit.HOURS); //有效时间2小时
			}
		}
    	return sysParameter;
	}

    @Override
    @POST
	@Path("edit")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult updateByKey(@HeaderParam("token") String token,String paramArray) {
    	if(paramArray!=null&&!"".equals(paramArray)){
    		List<SysParameter> list=JSON.parseArray(paramArray, SysParameter.class);
    		if(list!=null&&list.size()>0){
    			for(SysParameter sysParameter:list){
    				SysUser optUser = getCurrentUser(token);
    				sysParameter.setVersion(this.generateVersion());
    				sysParameter.setUpdateUserId(optUser.getId());
    				sysParameter.setUpdateTime(this.getSyetemTime());
    				sysParameterMapper.updateByKey(sysParameter);
    			}
    		}
    	}
    	return JsonResultUtil.success();
	}
    
}
