/**
 * InvestigatorHistoryService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service.impl.sceneCollecting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.hisign.xcky.api.model.sceneCollecting.InvestigatorHistory;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigator;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.InvestigatorHistoryService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.persist.mapper.sceneCollecting.InvestigatorHistoryMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;

/**
 * 历史勘验人信息Service实现
 *
 * @author ServiceGenerator
 */
@Path("/investigatorHistory")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("investigatorHistoryService")
@Transactional
public class InvestigatorHistoryServiceImpl extends BaseServiceImpl<InvestigatorHistory> implements InvestigatorHistoryService {
	
	@Resource
    private InvestigatorHistoryMapper investigatorHistoryMapper;
    
    @Override
	public Mapper<InvestigatorHistory> getMapper() {
		return investigatorHistoryMapper;
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
    	InvestigatorHistory t = new InvestigatorHistory();
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
    public JsonResult updateById(@HeaderParam("token") String token, InvestigatorHistory t) {
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
    public JsonResult add(@HeaderParam("token") String token, InvestigatorHistory t) {
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
    public JsonResult addBatch(@HeaderParam("token") String token, List<InvestigatorHistory> list) {
    	SysUser sysUser=this.getCurrentUser(token);
    	if(list!=null&&list.size()>0){
    		InvestigatorHistory investigatorHistory=list.get(0);
    		investigatorHistory.setCreateUserId(sysUser.getId());
    		investigatorHistoryMapper.deleteByCreateUserId(investigatorHistory);
    	}
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
    public JsonResult queryPage(InvestigatorHistory t) {
    	return super.queryPage(t);
    }
   
   /**
    * 查询全部
    * @param filter 查询条件对象
    */
	@Override
	@POST
	@Path("queryAll")
	@Consumes({ MediaType.APPLICATION_JSON })
	public JsonResult queryAll(@HeaderParam("token") String token, InvestigatorHistory filter) {
		//获取当前登录用户ID
		SysUser sysUser=this.getCurrentUser(token);
		filter.setCreateUserId(sysUser.getId());
		List<InvestigatorHistory> reslist = null;
		if(filter.getDuty().equals("1")){//查询指挥人员
			reslist = investigatorHistoryMapper.queryCommander(filter);
		}else{//查询勘验人员
			reslist = investigatorHistoryMapper.queryInquest(filter);
		}
		return JsonResultUtil.success(reslist);
	}
	
	/**
	 * 
	 * 方法功能说明：  
	 * 创建：2016-12-30 上午10:41:06 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public void addBySceneInvestigators(String token, List<SceneInvestigator> list) {
		SysUser sysUser=this.getCurrentUser(token);
		//更新当前用户下的数据全部为非勘验组
		investigatorHistoryMapper.updateIsOpenByUser(sysUser.getId());
		//物理删除
		Map<String,String> map = new HashMap<String,String>();
		String investigatorIds="";
		List<InvestigatorHistory> investigatorHistoryList=new ArrayList<InvestigatorHistory>();
		for(int i=0;i<list.size();i++){
			SceneInvestigator sceneInvestigator=list.get(i);
			if(sceneInvestigator.getDeleteFlag()!=null&&"1".equals(sceneInvestigator.getDeleteFlag())){
				continue;
			}
			
			if(i==0){
				investigatorIds = "'"+sceneInvestigator.getInvestigatorId()+"'";
			}else{
				investigatorIds+=",'"+sceneInvestigator.getInvestigatorId()+"'";
			}
			
			//创建历史勘验人数据
			InvestigatorHistory investigatorHistory=new InvestigatorHistory();
			investigatorHistory.setInvestigatorId(sceneInvestigator.getInvestigatorId());
			investigatorHistory.setInvestigatorName(sceneInvestigator.getInvestigatorName());
			if(sceneInvestigator.getDuty().equals("1")){//主堪
				investigatorHistory.setDuty(sceneInvestigator.getDuty());
				investigatorHistory.setIsOpen("0");
			}else{
				investigatorHistory.setDuty(sceneInvestigator.getDuty());
				investigatorHistory.setIsOpen("1");
			}
			investigatorHistoryList.add(investigatorHistory);
		}
		map.put("investigatorIds", investigatorIds);
		map.put("createUserId", sysUser.getId());
		investigatorHistoryMapper.deleteByMap(map);
		//保存新的勘验人
		super.addBatch(investigatorHistoryList, token);
	}
}
