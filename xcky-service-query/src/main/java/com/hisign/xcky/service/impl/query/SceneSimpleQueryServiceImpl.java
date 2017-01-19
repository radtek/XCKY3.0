package com.hisign.xcky.service.impl.query;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.esotericsoftware.minlog.Log;
import com.hisign.sso.api.rest.exception.RestBusinessException;
import com.hisign.xcky.api.model.sceneQuery.SceneSimpleQuery;
import com.hisign.xcky.api.model.system.SysParameter;
import com.hisign.xcky.api.service.sceneQuery.SceneSimpleQueryService;
import com.hisign.xcky.api.service.system.SysParameterService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.persist.mapper.query.SceneSimpleQueryMapper;
import com.hisign.xcky.util.HttpFileUtil;
import com.hisign.xcky.util.JsonResultUtil;
import com.hisign.xcky.util.excel.ParseHtmlToXls;
import com.hisign.xcky.util.excel.TemplateUtil;

@Path("/sceneSimpleQuery")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("sceneSimpleQueryService")
@Transactional
public class SceneSimpleQueryServiceImpl implements SceneSimpleQueryService{

	@Resource
	private SceneSimpleQueryMapper sceneSimpleQueryMapper;
	
	@Resource
    private SysParameterService sysParameterService;
	
    @SuppressWarnings("unchecked")
	@Override
    @POST
	@Path("query")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult query(SceneSimpleQuery sceneSimpleQuery) {
    	try {
    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put("param", sceneSimpleQuery);
    		map.put("refcursorOut", new ArrayList<Map<String, Object>>());
    		sceneSimpleQueryMapper.queryAll(map);
    		Integer outRecordAmount=(Integer) map.get("outRecordAmount");
    		if(outRecordAmount>0){
    			List<SceneSimpleQuery> list=(List<SceneSimpleQuery>) map.get("refcursorOut");
    			return JsonResultUtil.success(list.size(),list);
    		}else if(outRecordAmount<0){
    			return JsonResultUtil.error("sql异常!");
    		}else{
    			return JsonResultUtil.success(null);
    		}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RestBusinessException(Status.NOT_ACCEPTABLE, "服务器异常");
		}
	}
    
    @SuppressWarnings("unchecked")
	@Override
    @POST
	@Path("export")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult export(SceneSimpleQuery sceneSimpleQuery) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("param", sceneSimpleQuery);
    	map.put("refcursorOut", new ArrayList<Map<String, Object>>());
		sceneSimpleQueryMapper.queryAll(map);
		String selectFlag=(String) map.get("selectFlag");
		if(selectFlag!=null&&"1".equals(selectFlag)){
	    	//根据自定义显示列来控制要导出的列
	        Map<String, Object> mapCol = new HashMap<String, Object>();
	        String colName=sceneSimpleQuery.getColName();
	    	String [] colNameArr=colName.split(",");
	    	for(int i=0;i<colNameArr.length;i++){
	    		mapCol.put(colNameArr[i], "1");
	    	}
			List<SceneSimpleQuery> list=(List<SceneSimpleQuery>) map.get("refcursorOut");
			if(list==null || list.size()==0){
				//查询数据为空的处理
		        return JsonResultUtil.error("导出数据为空");
			}
			
	        String fileName = "excelTemplates/simpleQuery.vm";
	        Map<String, Object> dataMap = new HashMap<String, Object>();
	        dataMap.put("list", list);
	        dataMap.put("map", mapCol);
	        String result = TemplateUtil.parseTemplate(dataMap, fileName);//解析模板
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
		        //file.delete();//把生成的临时excel删掉
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
			return JsonResultUtil.success(mapexcel);
		}else{
			return JsonResultUtil.error("服务器异常!");
		}
	}    

}
