package com.hisign.xcky.service.impl.statistics;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.esotericsoftware.minlog.Log;
import com.hisign.sdk.cache.redis.RedisClient;
import com.hisign.xcky.api.model.statistics.SceneInputAmountFilter;
import com.hisign.xcky.api.model.statistics.TenSceneInputAmount;
import com.hisign.xcky.api.model.statistics.TenSceneInputTotal;
import com.hisign.xcky.api.model.system.Organization;
import com.hisign.xcky.api.model.system.SysParameter;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.service.statistics.TenSceneInputAmountService;
import com.hisign.xcky.api.service.system.OrganizationService;
import com.hisign.xcky.api.service.system.SysParameterService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.persist.mapper.statistics.TenSceneInputAmountMapper;
import com.hisign.xcky.util.HttpFileUtil;
import com.hisign.xcky.util.JsonResultUtil;
import com.hisign.xcky.util.excel.ParseHtmlToXls;
import com.hisign.xcky.util.excel.TemplateUtil;

/**
 * 十类案件统计接口
 * 项目名称：xcky-service-statistics   
 * 类名称：TenSceneInputAmountServiceImpl   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-26 下午1:24:38   
 * 修改人：hisign   
 * 修改时间：2016-12-26 下午1:24:38   
 * 修改备注：   
 * @version
 */
@Path("/tenSceneInputAmount")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("tenSceneInputAmountService")
@Transactional
public class TenSceneInputAmountServiceImpl  implements   TenSceneInputAmountService{
	/**
	 * 日志输出
	 */
	private final static Logger logger = LoggerFactory.getLogger(TenSceneInputAmountServiceImpl.class);
	/**
	 * redis缓存接口
	 */
	@Autowired
	protected RedisClient  redisClient;
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private TenSceneInputAmountMapper mapper;
	
	@Resource
    private SysParameterService sysParameterService;
    
	@Override
    @POST
	@Path("query")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult query(@HeaderParam("token") String token,SceneInputAmountFilter filter) {
    	Map<String,Object> result =new HashMap<String,Object> ();
    	SysUser sysUser=getCurrentUser(token);
    	List<TenSceneInputAmount> list =getTenSceneInputAmountList(sysUser,filter);
    	//计算合计内容
    	TenSceneInputTotal tenSceneInputTotal = getTenSceneInputTotal(list);
    	result.put("TenSceneInputAmount", list);
    	result.put("TenSceneInputTotal", tenSceneInputTotal);
    	long num = 0;
    	if(list!=null&&list.size()>0){
    		num = (long)list.size();
    	}
		return JsonResultUtil.success(num,result);
	}
	
	/**
     * 导出
     * @param t 查询条件
     */
    @Override
    @POST
	@Path("/export")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonResult expendAll(@HeaderParam("token") String token, SceneInputAmountFilter filter) {
    	SysUser sysUser=getCurrentUser(token);
    	List<TenSceneInputAmount> list =getTenSceneInputAmountList(sysUser,filter);
    	if(list==null || list.size()==0){
    		 return JsonResultUtil.error("导出数据为空");
		}
        String fileName = "excelTemplates/tenSceneInputAmount.vm";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        String result = TemplateUtil.parseTemplate(map, fileName);//解析模板
        Log.info("导出结果根据模板解析后的信息"+result);
        Map<String,String> mapexcel=new HashMap<String,String>();
        try {        	
        	String htmlStr = result;
            String sheetName = "十类案件统计";
            //生成Excel工作薄对象
			HSSFWorkbook wb = ParseHtmlToXls.parseHtmlToXlsForMultiTitle(htmlStr, sheetName);

			String filePath=new File("").getAbsolutePath()+"/"+new Date().getTime()+".xls";
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
	        mapexcel.put("filePath", fileNameRemote);
	        file.delete();//把生成的临时excel删掉
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return JsonResultUtil.success(mapexcel);
    }
    /**
     * 统计列表集合
     * 方法功能说明：  
     * 创建：2016-12-28 下午4:04:00 by guochen
     * @参数： 
     * @参数：    
     * @return  
     * @throws
     */
	public List<TenSceneInputAmount> getTenSceneInputAmountList(SysUser sysUser,SceneInputAmountFilter filter){
		List<TenSceneInputAmount> list = new ArrayList<TenSceneInputAmount>();//返回结果级List
    	if(filter.getIsIncludeLowerLevel().equals("0")){//不包含下级
    		//整理查询单位
    		if(filter.getUnit()!=null && !"".equals(filter.getUnit())){
    			String[] units = filter.getUnit().split(",");
    			if(units!=null&&units.length>0){
    				for(String regionalism:units){
    					TenSceneInputAmount t = getTenSceneInputAmount(null,regionalism,"0",filter);
    	    			list.add(t);
    				}
    			}
    		} else {
    			String regionalism = sysUser.getOrganCode();
    			TenSceneInputAmount t = getTenSceneInputAmount(null,regionalism,"0",filter);
    			list.add(t);
    		}
    	}else{//包含下级
    		//整理查询单位
    		if(filter.getUnit()!=null && !"".equals(filter.getUnit())){
    			String[] units = filter.getUnit().split(",");
    			if(units!=null&&units.length>0){
    				for(String regionalism:units){
    					Organization org = organizationService.getByRegionalism(regionalism);
    	    			String parentName = "";
    	    			if(StringUtils.isNotEmpty(org.getShortenedName())){
    	    				parentName = org.getShortenedName();
    	    			}else{
    	    				parentName = org.getOrganName();
    	    			}
    	    			TenSceneInputAmount t = getTenSceneInputAmount(parentName,regionalism,"0",filter);
    	    			List<Organization> orgList = organizationService.findListByParentRegionalism(regionalism);
    	    			int rowSpan = 1;
    	    			if(orgList!=null&&orgList.size()>0){
    	    				rowSpan=orgList.size()+1;
    	    			}
    	    			t.setRowSpan(rowSpan);
    	    			t.setSfhb(1);
    	    			list.add(t);
    	    			//查询下级机构
    	    			if(orgList!=null&&orgList.size()>0){
    	    				for(Organization org1:orgList){
    	    					TenSceneInputAmount t2 = getTenSceneInputAmount(parentName,org1.getRegionalism(),"1",filter);
    	    					t2.setSfhb(0);
    	    					list.add(t2);
    	        			}
    	    			}
    				}
    			}
    		} else {
    			String regionalism = sysUser.getOrganCode();
    			Organization orgbj = organizationService.getByRegionalism(regionalism);
    			String parentName = "";
    			if(StringUtils.isNotEmpty(orgbj.getShortenedName())){
    				parentName = orgbj.getShortenedName();
    			}else{
    				parentName = orgbj.getOrganName();
    			}
    			TenSceneInputAmount t = getTenSceneInputAmount(parentName,regionalism,"0",filter);
    			List<Organization> orgList = organizationService.findListByParentRegionalism(regionalism);
    			int rowSpan = 1;
    			if(orgList!=null&&orgList.size()>0){
    				rowSpan=orgList.size()+1;
    			}
    			t.setRowSpan(rowSpan);
    			t.setSfhb(1);
    			list.add(t);
    			//查询下级机构
    			if(orgList!=null&&orgList.size()>0){
    				for(Organization org:orgList){
    					TenSceneInputAmount t2 = getTenSceneInputAmount(parentName,org.getRegionalism(),"1",filter);
    					t2.setSfhb(0);
    					list.add(t2);
        			}
    			}
    		}
    	}
		return list;
	}
    
    
	/**
	 * 合计
	 * 方法功能说明：  
	 * 创建：2016-12-28 下午1:34:27 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	private TenSceneInputTotal getTenSceneInputTotal(List<TenSceneInputAmount> list) {
		TenSceneInputTotal total = new TenSceneInputTotal();
		if(list!=null&&list.size()>0){
			for(TenSceneInputAmount t:list){
				total.setKillTotal(total.getKillTotal()+t.getKillCount());
				total.setInjureTotal(total.getInjureTotal()+t.getInjureCount());
				total.setRapeTotal(total.getRapeTotal()+t.getRapeCount());
				total.setKidnapTotal(total.getKidnapTotal()+t.getKidnapCount());
				total.setRobTotal(total.getRobTotal()+t.getRobCount());
				total.setFireTotal(total.getFireTotal()+t.getFireCount());
				total.setBombTotal(total.getBombTotal()+t.getBombCount());
				total.setHijackTotal(total.getHijackTotal()+t.getHijackCount());
				total.setStealTotal(total.getStealTotal()+t.getStealCount());
				total.setDestroyTotal(total.getDestroyTotal()+t.getDestroyCount());
				total.setPoisoningTotal(total.getPoisoningTotal()+t.getPoisoningCount());
				total.setOtherTotal(total.getOtherTotal()+t.getOtherCount());
			}
		}
		return total;
	}

	public TenSceneInputAmount getTenSceneInputAmount(String parentName,String regionalism,String flag,SceneInputAmountFilter filter){
		TenSceneInputAmount t = null;
		//根据代码查询机构名称
		Organization org = organizationService.getByRegionalism(regionalism);
		if(org!=null){
			String orgName = "";
			if(StringUtils.isNotEmpty(org.getShortenedName())){
				orgName = org.getShortenedName();
			}else{
				orgName = org.getOrganName();
			}
			if(StringUtils.isEmpty(parentName)){
				parentName = orgName;
			}
			//查询本机构十类案件数量
			filter.setOrgNo(regionalism);
			//设定查询本级
			filter.setIsIncludeLowerLevelSQL(flag);
			//SQL中应用的机构代码赋值
			filter.setOrgNo(regionalism);
			t=mapper.getAountByRegionalism(filter);
			if(t==null){
				t=new TenSceneInputAmount();
			}
			t.setParentUnitName(parentName);
			t.setUnitName(orgName);
		}
		return t;
	}
	
	  public SysUser getCurrentUser(String token) {
			SysUser sysUser=redisClient.getObj(token, SysUser.class);
			if(sysUser!=null){
				return sysUser;
			}else{
				return null;
			}
		}
}
