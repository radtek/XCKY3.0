/**
 * SceneInvestigationService.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service.impl.sceneCollecting;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.esotericsoftware.minlog.Log;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigation;
import com.hisign.xcky.api.model.system.SysParameter;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.SceneInvestigationService;
import com.hisign.xcky.api.service.system.SysParameterService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.persist.mapper.sceneCollecting.SceneInvestigationMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.HttpFileUtil;
import com.hisign.xcky.util.JsonResultUtil;
import com.hisign.xcky.util.excel.ParseHtmlToXls;
import com.hisign.xcky.util.excel.TemplateUtil;

/**
 * 现场勘验信息Service实现
 *
 * @author ServiceGenerator
 */
@Path("/sceneInvestigation")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("sceneInvestigationService")
@Transactional
public class SceneInvestigationServiceImpl extends BaseServiceImpl<SceneInvestigation> implements SceneInvestigationService {
	
	@Resource
    private SceneInvestigationMapper sceneInvestigationMapper;
	
	@Resource
    private SysParameterService sysParameterService;
	
    @Override
	public Mapper<SceneInvestigation> getMapper() {
		return sceneInvestigationMapper;
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
     * 根据id删除(逻辑删除)
     * @param id
     */
    @Override
    @POST
	@Path("delLogic")
    @Consumes({MediaType.APPLICATION_JSON})
    public JsonResult deleteLogicById(@HeaderParam("token") String token, String id) {
    	SceneInvestigation t = new SceneInvestigation();
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
    public JsonResult updateById(@HeaderParam("token") String token, SceneInvestigation t) {
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
    public JsonResult add(@HeaderParam("token") String token, SceneInvestigation t) {
    	SysUser sysUser=super.getCurrentUser(token);
    	t.setIterationNo(0);
    	t.setOrganNo(sysUser.getOrganCode());
    	t.setOrganName(sysUser.getOrganName());
    	t.setSecrecy("1");
    	if(StringUtils.isNotEmpty(t.getInvestNoteId())){
    		t.setInvestNoteFlag("1");
    	}else{
    		t.setInvestNoteFlag("0");
    	}
    	if(t.getLostTotalValue()==null){
    		t.setLostTotalValue(0);
    	}
    	if(t.getVideoTime()==null){
    		t.setVideoTime(0);
    	}
    	if(t.getRecordTime()==null){
    		t.setRecordTime(0);
    	}
    	t.setHisignKey(Constants.SYSTEMID);
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
    public JsonResult addBatch(@HeaderParam("token") String token, List<SceneInvestigation> list) {
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
    public JsonResult queryPage(@HeaderParam("token") String token, SceneInvestigation t) {
    	SysUser sysUser=super.getCurrentUser(token);
    	if(t.getSceneArea()!=null&&!"".equals(t.getSceneArea())){
    		t.setCreateUserId(sysUser.getId());
    		t.setOrganNo(sysUser.getOrganCode());
    	}
    	
    	//截取最后一个非0的案件类别
    	if(t.getCaseType()!=null&&!"".equals(t.getCaseType())){
    		String caseType=t.getCaseType().replaceAll("0*$","");
    		t.setCaseType(caseType);
    	}
    	//截取最后一个非0的发案区划
    	if(t.getCaseRegionalism()!=null&&!"".equals(t.getCaseRegionalism())){
    		String caseRegionalism=t.getCaseRegionalism().replaceAll("0*$","");
    		t.setCaseRegionalism(caseRegionalism);
    	}
    	//设置警综关联类型
    	SysParameter sysParameter=sysParameterService.getByKey(Constants.SysParam.ALARM_RELATE_TYPE);
    	t.setRelateType(sysParameter.getValue());
    	return super.queryPage(t);
    }
    
    /**
     * 导出
     * @param t 查询条件
     */
    @Override
    @POST
	@Path("/export")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonResult expendAll(@HeaderParam("token") String token, SceneInvestigation t) {
    	SysUser sysUser=super.getCurrentUser(token);
    	if(t.getSceneArea()!=null&&!"".equals(t.getSceneArea())){
    		t.setCreateUserId(sysUser.getId());
    		t.setOrganNo(sysUser.getOrganCode());
     	}
    	 
    	//根据自定义显示列来控制要导出的列
        Map<String, Object> mapCol = new HashMap<String, Object>();
        String colname=t.getColName();
        Log.info("导出数据传过来的导出列名"+colname);
    	String [] str=t.getColName().split(",");//去掉【】符号
    	for(int i=0;i<str.length;i++){
    		mapCol.put(str[i], "1");
    	}
    	
		List<SceneInvestigation> list=sceneInvestigationMapper.query(t);
		if(list==null || list.size()==0){
			//查询数据为空的处理
	        return JsonResultUtil.error("导出数据为空");
		}
        String fileName = "excelTemplates/sceneInfo.vm";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        map.put("map", mapCol);
        String result = TemplateUtil.parseTemplate(map, fileName);//解析模板
        Log.info("导出结果根据模板解析后的信息"+result);
        
        Map<String,String> mapexcel=new HashMap<String,String>();
        try {        	
        	String htmlStr = result;
            String sheetName = "现场信息";
            //生成Excel工作薄对象
			HSSFWorkbook wb = ParseHtmlToXls.parseHtmlToXlsForMultiTitle(htmlStr, sheetName);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssSS");//16年12月30日11:53:28:12毫秒
			String excelName = dateFormat.format(new Date());
			String filePath=new File("").getAbsolutePath()+"/"+excelName+".xls";
			//输出excel到指定文件夹中
			FileOutputStream fileoutputstream = new FileOutputStream(filePath);
			wb.write(fileoutputstream);
			fileoutputstream.close();
			
			//调用接口上传至文件服务器
			SysParameter tempFilePath=sysParameterService.getByKey(Constants.SysParam.FILE_UPLOAD_PATH);
			if(tempFilePath==null){
		        return JsonResultUtil.error("文件服务器没有进行配置");
			}
			File file = new File(filePath);
		    String url = tempFilePath.getValue();
			String fileIdJson = HttpFileUtil.uploadFile(url, new File[] { file });
			
			JSONObject job= JSON.parseObject(fileIdJson);
			JSONObject fileInfo=(JSONObject) job.get("data");
			String fileNameRemote=fileInfo.getString("fileNameRemote");
	        mapexcel.put("filePath", fileNameRemote+"?attname="+excelName+".xls");
	        file.delete();//把生成的临时excel删掉
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        return JsonResultUtil.success(mapexcel);
    }


	/**
	 * 根据勘验ID查询勘验信息
	 * 方法功能说明：  
	 * 创建：2016-12-12 下午2:24:04 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public SceneInvestigation findById(String investigationId) {
		return sceneInvestigationMapper.getById(investigationId);
	}

    @Override
    @POST
	@Path("delAllLogic")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult delAllLogic(@HeaderParam("token") String token, List<Map<String,String>> list) {
    	if(list!=null&&list.size()>0){
    		for(Map<String,String> map:list){
    			deleteLogicById(token,map.get("id"));
    		}
    		return JsonResultUtil.success();
    	}else{
    		return JsonResultUtil.error("参数不能为空");
    	}
	}

    @Override
    @POST
	@Path("queryCount")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult queryCount(@HeaderParam("token") String token) {
		SysUser sysUser=super.getCurrentUser(token);
		SceneInvestigation sceneInvestigation=new SceneInvestigation();
		sceneInvestigation.setCreateUserId(sysUser.getId());
		sceneInvestigation.setOrganNo(sysUser.getOrganCode());
		
		SceneInvestigation allCount=sceneInvestigationMapper.queryCount(sceneInvestigation);
		
		sceneInvestigation.setSaveFlag("1");
		SceneInvestigation submitCount=sceneInvestigationMapper.queryCount(sceneInvestigation);
		
		sceneInvestigation.setSaveFlag("0");
		SceneInvestigation saveCount=sceneInvestigationMapper.queryCount(sceneInvestigation);
		
		sceneInvestigation.setQualityFlag("0");
		SceneInvestigation unQualityCount=sceneInvestigationMapper.queryCount(sceneInvestigation);
		
		SceneInvestigation followCount=sceneInvestigationMapper.followCount(sceneInvestigation);
		
		sceneInvestigation.setSaveFlag("");
		sceneInvestigation.setQualityFlag("");
		sceneInvestigation.setCaseNoFlag("0");
		SceneInvestigation unConnectCount=sceneInvestigationMapper.queryCount(sceneInvestigation);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("allCount", allCount);
		map.put("submitCount", submitCount);
		map.put("saveCount", saveCount);
		map.put("unQualityCount", unQualityCount);
		map.put("followCount", followCount);
		map.put("unConnectCount", unConnectCount);
		return JsonResultUtil.success(map);
	}

	/**
	 * 获取最大的复堪号
	 * 方法功能说明：  
	 * 创建：2016-12-27 下午3:21:37 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	public int findMaxIterationNoByInvestigationNo(String investigationNo) {
		
		return sceneInvestigationMapper.findMaxIterationNoByInvestigationNo(investigationNo);
	}

	public SysParameterService getSysParameterService() {
		return sysParameterService;
	}

	public void setSysParameterService(SysParameterService sysParameterService) {
		this.sysParameterService = sysParameterService;
	}
	
}
