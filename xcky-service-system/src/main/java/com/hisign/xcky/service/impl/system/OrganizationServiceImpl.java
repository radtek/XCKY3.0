/**
 * OrganizationService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service.impl.system;

import java.util.List;
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
import com.hisign.xcky.api.model.system.Organization;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.system.OrganizationService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.persist.mapper.system.OrganizationMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 单位信息Service实现
 *
 * @author ServiceGenerator
 */
@Path("/sysOrganization")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("organizationService")
@Transactional
public class OrganizationServiceImpl extends BaseServiceImpl<Organization> implements OrganizationService {
	
	@Resource
    private OrganizationMapper organizationMapper;
    
    @Override
	public Mapper<Organization> getMapper() {
		return organizationMapper;
	}

	/* (non-Javadoc)
	 * @see com.hisign.xcky.api.service.system.OrganizationService#findDictUnit(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@GET
	@Path("dict_unit")
	public JsonResult findDictUnit(@HeaderParam("token")String token) throws Exception {
		List<Organization> list=redisClient.lrangeObj(Constants.Redis.ORGAN, 0, -1, Organization.class);
		if(list!=null&&list.size()>0){
			return JsonResultUtil.success(list);
		}else{
			list=organizationMapper.findAllDictUnit();
			if(list!=null&&list.size()>0){
				redisClient.lpushAllObj(Constants.Redis.ORGAN, list);
				redisClient.expire(Constants.Redis.ORGAN,Constants.Redis.EXPIRE_TIME, TimeUnit.HOURS); //有效时间2小时
			}
			return JsonResultUtil.success(list);
		}
		
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
    	Organization t = new Organization();
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
    public JsonResult updateById(@HeaderParam("token") String token, Organization t) {
    	return super.updateById(t, token);
    }

    /**
     * 新增
     * @param t 新增对象
     */
    @Override
    @POST
	@Path("add")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult add(@HeaderParam("token") String token, Organization t) {
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
    public JsonResult addBatch(@HeaderParam("token") String token, List<Organization> list) {
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
    public JsonResult queryPage(Organization t) {
    	return super.queryPage(t);
    }
	@Override
	public Organization getByRegionalism(String regionalism) {
		// TODO Auto-generated method stub
		return organizationMapper.getByRegionalism(regionalism);
	}
	public List<Organization> findListByParentRegionalism(String regionalism){
		return organizationMapper.findListByParentRegionalism(regionalism);
	}

}
