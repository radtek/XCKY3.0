/**
 * AlarmInfoService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service.impl.sceneCollecting;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.hisign.xcky.api.model.sceneCollecting.AlarmInfo;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigationStatus;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.AlarmInfoService;
import com.hisign.xcky.api.service.sceneCollecting.SceneInvestigationStatusService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.persist.mapper.sceneCollecting.AlarmInfoMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 警情信息Service实现
 *
 * @author ServiceGenerator
 */
@Path("/alarmInfo")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("alarmInfoService")
@Transactional
public class AlarmInfoServiceImpl extends BaseServiceImpl<AlarmInfo> implements AlarmInfoService {
	
	@Resource
    private AlarmInfoMapper alarmInfoMapper;
	
	@Resource
	private SceneInvestigationStatusService sceneInvestigationStatusService;
	
    @Override
	public Mapper<AlarmInfo> getMapper() {
		return alarmInfoMapper;
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
    	if(StringUtils.isNotEmpty(id)){
    		return super.deleteById(id);
    	}
    	return JsonResultUtil.success();
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
    	AlarmInfo t = new AlarmInfo();
    	t.setId(id);
    	if(StringUtils.isNotEmpty(id)){
    		return super.deleteLogicById(t, token);
    	}
    	return JsonResultUtil.success();
    	
    }

    /**
     * 根据id更新
     * @param t 更新对象
     */
    @Override
    @POST
	@Path("upd")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult updateById(@HeaderParam("token") String token, AlarmInfo t) {
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
    public JsonResult add(@HeaderParam("token") String token, AlarmInfo t) {
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
    public JsonResult addBatch(@HeaderParam("token") String token, List<AlarmInfo> list) {
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
    public JsonResult queryPage(AlarmInfo t) {
    	return super.queryPage(t);
    }

    @Override
    @POST
	@Path("connectAlarmScene")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult connectAlarmScene(@HeaderParam("token") String token, AlarmInfo alarmInfo) {
    	
    	Date date=super.getSyetemTime();
    	SysUser sysUser=super.getCurrentUser(token);
		AlarmInfo tempAlarmInfo=alarmInfoMapper.getById(alarmInfo.getId());
		tempAlarmInfo.setInvestigationId(alarmInfo.getInvestigationId());
		tempAlarmInfo.setUpdateUserId(sysUser.getId());
		tempAlarmInfo.setVersion(super.generateVersion());
		tempAlarmInfo.setUpdateTime(date);
		alarmInfoMapper.updateSceneInvestigationDispatch(tempAlarmInfo);
		
		SceneInvestigationStatus sceneInvestigationStatus=new SceneInvestigationStatus();
		if(tempAlarmInfo.getAlarmNo()!=null&&!"".equals(tempAlarmInfo.getAlarmNo())){
			sceneInvestigationStatus.setAlarmNoFlag("1");
		}
		if(tempAlarmInfo.getCaseNo()!=null&&!"".equals(tempAlarmInfo.getCaseNo())){
			sceneInvestigationStatus.setCaseNoFlag("1");
		}
		sceneInvestigationStatus.setInvestigationId(alarmInfo.getInvestigationId());
		sceneInvestigationStatus.setRelateTime(date);
		sceneInvestigationStatus.setUpdateTime(date);
		sceneInvestigationStatus.setVersion(super.generateVersion());
		sceneInvestigationStatus.setUpdateUserId(sysUser.getId());
		System.out.println(JSON.toJSONString(sceneInvestigationStatus));
		sceneInvestigationStatusService.updateByInvestigationId(token, sceneInvestigationStatus);
		
		
		return JsonResultUtil.success();
	}
    
}
