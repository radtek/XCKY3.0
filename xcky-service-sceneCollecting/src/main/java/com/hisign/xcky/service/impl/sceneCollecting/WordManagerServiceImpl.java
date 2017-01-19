package com.hisign.xcky.service.impl.sceneCollecting;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hisign.sdk.cache.redis.RedisClient;
import com.hisign.sso.api.rest.exception.RestBusinessException;
import com.hisign.xcky.api.model.sceneCollecting.CommonAttachment;
import com.hisign.xcky.api.model.sceneCollecting.CommonBigtext;
import com.hisign.xcky.api.model.sceneCollecting.SceneAnalysisItem;
import com.hisign.xcky.api.model.sceneCollecting.SceneAnalysisSuggestion;
import com.hisign.xcky.api.model.sceneCollecting.SceneCollectedGoods;
import com.hisign.xcky.api.model.sceneCollecting.SceneCollectedPerson;
import com.hisign.xcky.api.model.sceneCollecting.SceneCondition;
import com.hisign.xcky.api.model.sceneCollecting.SceneCrimeTools;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigation;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigationDispatch;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigationStatus;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigator;
import com.hisign.xcky.api.model.sceneCollecting.SceneLostGoods;
import com.hisign.xcky.api.model.sceneCollecting.SceneOffender;
import com.hisign.xcky.api.model.sceneCollecting.ScenePicSummary;
import com.hisign.xcky.api.model.sceneCollecting.ScenePicture;
import com.hisign.xcky.api.model.system.SysParameter;
import com.hisign.xcky.api.model.template.Bdyy;
import com.hisign.xcky.api.model.template.SceneInvestigationNoteWord;
import com.hisign.xcky.api.model.template.WordLighting;
import com.hisign.xcky.api.model.template.WordProtected;
import com.hisign.xcky.api.model.template.WordSceneCollectedMaterial;
import com.hisign.xcky.api.model.template.WordScenePicture;
import com.hisign.xcky.api.model.template.WordWeather;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.sceneCollecting.CommonAttachmentService;
import com.hisign.xcky.api.service.sceneCollecting.CommonBigtextService;
import com.hisign.xcky.api.service.sceneCollecting.SceneAnalysisItemService;
import com.hisign.xcky.api.service.sceneCollecting.SceneAnalysisSuggestionService;
import com.hisign.xcky.api.service.sceneCollecting.SceneCollectedGoodsService;
import com.hisign.xcky.api.service.sceneCollecting.SceneConditionService;
import com.hisign.xcky.api.service.sceneCollecting.SceneCrimeToolsService;
import com.hisign.xcky.api.service.sceneCollecting.SceneInvestigationDispatchService;
import com.hisign.xcky.api.service.sceneCollecting.SceneInvestigationService;
import com.hisign.xcky.api.service.sceneCollecting.SceneInvestigationStatusService;
import com.hisign.xcky.api.service.sceneCollecting.SceneInvestigatorService;
import com.hisign.xcky.api.service.sceneCollecting.SceneLostGoodsService;
import com.hisign.xcky.api.service.sceneCollecting.SceneOffenderService;
import com.hisign.xcky.api.service.sceneCollecting.ScenePicSummaryService;
import com.hisign.xcky.api.service.sceneCollecting.ScenePictureService;
import com.hisign.xcky.api.service.sceneCollecting.WordManagerService;
import com.hisign.xcky.api.service.system.SysDictService;
import com.hisign.xcky.api.service.system.SysParameterService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.Base64Util;
import com.hisign.xcky.util.ConfigUtil;
import com.hisign.xcky.util.DateUtil;
import com.hisign.xcky.util.HttpFileUtil;
import com.hisign.xcky.util.JsonResultUtil;
import com.hisign.xcky.wordUtil.TemplateWordCreator;
/**
 * 生成word文件接口
 * 项目名称：xcky-service-sceneCollecting   
 * 类名称：WordManagerServiceImpl   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-20 下午5:48:49   
 * 修改人：hisign   
 * 修改时间：2016-12-20 下午5:48:49   
 * 修改备注：   
 * @version
 */
@Path("/sceneInfoWord")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("wordManagerService")
@Transactional
public class WordManagerServiceImpl extends BaseServiceImpl implements WordManagerService{
	/**
	 * 日志输出
	 */
	private final static Logger logger = LoggerFactory.getLogger(WordManagerServiceImpl.class);
	/**
	 * redis缓存接口
	 */
	@Autowired
	protected RedisClient  redisClient;

	@Override
	public Mapper getMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 默认的编码格式
	 */
	protected final String DEFAULT_PAPER_ENCODING = "UTF-8";
	/**
	 * 文档输出路径
	 */
	private static final String OUTPUT_FILE_PATH = "conf//output//";
	/**
	 * 勘验信息业务接口
	 */
	@Autowired
	private SceneInvestigationService sceneInvestigationService;
	/**
	 * 接堪业务接口
	 */
	@Autowired
	private SceneInvestigationDispatchService sceneInvestigationDispatchService;
	/**
	 * 现场条件接口
	 */
	@Autowired
	private SceneConditionService sceneConditionService;
	/**
	 * 勘验人接口
	 */
	@Autowired
	private SceneInvestigatorService sceneInvestigatorService;
	/**
	 * 数据字典
	 */
	@Autowired
	private SysDictService sysDictService;
	/**
	 * 文本业务接口
	 */
	@Autowired
	private CommonBigtextService commonBigtextService;
	/**
	 * 现场图统计接口
	 */
	@Autowired
	private ScenePicSummaryService scenePicSummaryService;
	/**
	 * 涉案人员
	 */
	@Autowired
	private SceneOffenderService sceneOffenderService;
	/**
	 * 分析意见接口
	 */
	@Autowired
	private SceneAnalysisSuggestionService sceneAnalysisSuggestionService;
	/**
	 * 分析意见项目接口
	 */
	@Autowired
	private SceneAnalysisItemService sceneAnalysisItemService;
	/**
	 * 作案工具接口
	 */
	@Autowired
	private SceneCrimeToolsService sceneCrimeToolsService;
	/**
	 * 损失物品接口
	 */
	@Autowired
	private SceneLostGoodsService sceneLostGoodsService;
	/**
	 * 提取物接口
	 */
	@Autowired
	private SceneCollectedGoodsService sceneCollectedGoodsService;
	/**
	 * 系统参数接口
	 */
	@Autowired
	private SysParameterService sysParameterService;
	/**
	 * 现场图接口
	 */
	@Autowired
	private ScenePictureService scenePictureService;
	/**
	 * 现场勘验信息状态接口
	 */
	@Autowired
	private SceneInvestigationStatusService sceneInvestigationStatusService;
	/**
	 * 附件接口
	 */
	@Autowired
	private CommonAttachmentService commonAttachmentService;
	
	private static int firstPageline=14;//提取痕迹物品列表首页行数
    private static int otherPageline=17;//提取痕迹物品列表行数
	private static int materialNamelength=9;//提取痕迹物品列表名称长度
	private static int collectedPositionlength=8;//提取部位长度
	private static int collectedMethodlength=8;//提取方法长度
	private static int collectedBylength=7;//提取人姓名长度
	/**
	 * 勘验笔录下载地址
	 * 方法功能说明：  
	 * 创建：2017-1-4 下午1:18:56 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	@Override
	@GET
	@Path("investigationNoteDownLoad/{investigationId}")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult findInvestigationNoteDownLoad(@HeaderParam("token") String token, @PathParam("investigationId")String investigationId){
		CommonAttachment commonAttachment = commonAttachmentService.findInvestigationNoteDownLoad(investigationId);
		 Map<String,String> map=new HashMap<String,String>();
		if(commonAttachment!=null){
			String result = commonAttachment.getFileServerAddr()+commonAttachment.getFileServerPath()+commonAttachment.getFileName()+commonAttachment.getFileSuffix();
			map.put("file", result);
			return JsonResultUtil.success(map);
		}else{
			return JsonResultUtil.error("笔录文件不存在！");
		}
	}
	
	/**
	 * @throws Exception 
	 * 勘验笔录生成接口
	 * 方法功能说明：  
	 * 创建：2016-12-21 上午9:30:10 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	@Override
	@GET
	@Path("createInvestigationNote/{investigationId}")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult createInvestigationNoteByInvestigationId(@HeaderParam("token") String token, @PathParam("investigationId")String investigationId){
		//查询出堪
		SceneInvestigation investigation = sceneInvestigationService.findById(investigationId);
		//生成的文件名
		String newFilename =  getInvestigationFileName(investigation,"bl")+"-"+investigation.getIterationNo();
		//文档模板名称
		String templateFileName = "conf/template/SceneInvestigationNoteWordTemplate.flt";
		//文档导出完整路径
		String targetFileName = OUTPUT_FILE_PATH+newFilename+".doc";
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			SceneInvestigationNoteWord	noteWord = creatSceneInvestigationNoteWord(investigation);
			map.put("sceneInvestigationNoteWord", noteWord);
			//生成word
			TemplateWordCreator.generate(templateFileName, targetFileName, map, DEFAULT_PAPER_ENCODING);
			//上传文件（预留）
			SysParameter sysParams=sysParameterService.getByKey(Constants.SysParam.FILE_UPLOAD_PATH);
			SysParameter sysParams2=sysParameterService.getByKey(Constants.SysParam.FILE_SERVER_PATH);//下载地址
			if(sysParams==null){
				throw new RestBusinessException(Status.NOT_FOUND, "未配置文件服务器地址");
			}
			//校验文件夹是否存在
			File isFile=new File(new File("").getAbsolutePath()+"/"+OUTPUT_FILE_PATH);
			if  (!isFile .exists()  && !isFile .isDirectory())      
			{       
			    System.out.println("//不存在");  
			    isFile .mkdir();    
			}
			try{
				//调用接口上传至文件服务器
				targetFileName=new File("").getAbsolutePath()+"/"+targetFileName;
				//调用接口上传至文件服务器
				SysParameter tempFilePath=sysParameterService.getByKey(Constants.SysParam.FILE_UPLOAD_PATH);
				if(tempFilePath==null){
			        return JsonResultUtil.error("文件服务器没有进行配置");
				}
				File file = new File(targetFileName);
			    String url = tempFilePath.getValue();
				String fileIdJson = HttpFileUtil.uploadFileWord(url, new File[] { file });
				
				JSONObject job= JSON.parseObject(fileIdJson);
				String fileNameRemote= null;
				if(job!=null){
					JSONObject fileInfo=(JSONObject) job.get("data");
					fileNameRemote=fileInfo.getString("fileNameRemote");
				}
				//补充附件对象
				CommonAttachment commonAttachment = new CommonAttachment();
				commonAttachment.setInvestigationId(investigation.getId());
				commonAttachment.setCategory("02");
				commonAttachment.setFileName(newFilename);
				commonAttachment.setFileServerAddr(sysParams2.getValue());
				commonAttachment.setFileSuffix(".doc");
				Integer fileSize = getFileSize(file);
				commonAttachment.setFileSize(fileSize);
				commonAttachment.setFileServerPath(fileNameRemote);
				commonAttachmentService.saveOrUpdate(token,commonAttachment);
				//修改勘验对象状态
				SceneInvestigationStatus sceneInvestigationStatus = new SceneInvestigationStatus();
				sceneInvestigationStatus.setNoteMadeFlag("1");
				sceneInvestigationStatus.setNoteMadeTime(new Date());
				sceneInvestigationStatus.setInvestigationId(investigation.getId());
				sceneInvestigationStatusService.updateByInvestigationId(token, sceneInvestigationStatus);
			}catch (Exception e) {
				e.printStackTrace();
			}
				//删除临时笔录文件
			deleteFile(targetFileName);
		}catch (com.alibaba.fastjson.JSONException e) {
			throw new RestBusinessException(Status.NOT_ACCEPTABLE, e.getMessage()+"  错误");
		}				
		return JsonResultUtil.success();
	}
	/**
	 * @throws Exception 
	 * 生成笔录数据对象
	 * 方法功能说明：  
	 * 创建：2016-12-21 上午10:00:41 by guochen
	 * @return  
	 * @throws
	 */
	private SceneInvestigationNoteWord creatSceneInvestigationNoteWord(SceneInvestigation investigation)  {
		SceneInvestigationNoteWord noteWord = new SceneInvestigationNoteWord();
		try{
			//查询现场案件
			SceneInvestigationDispatch dispatch=sceneInvestigationDispatchService.getByInvestigationId(investigation.getId());
			//现场条件
			SceneCondition condition = sceneConditionService.getByInvestigationId(investigation.getId());
			/*******************文书按顺序赋值*************************/
			//勘验号
			String noteNo = investigation.getInvestigationNo();
			noteWord.setNoteNo(noteNo);
			// 现场勘验单位
			String madeByOrgName=investigation.getOrganName();
			if (StringUtils.isNotEmpty(madeByOrgName)) {
				String str = "";
				if (madeByOrgName.length() <= 28) {
					for (int i = 0; i < 28 - madeByOrgName.length(); i++) {
						//计算剩余占位空格
						str += "　";
					}
					madeByOrgName += str;
				}
			} else {
				//补齐占位空格
				madeByOrgName = "　　　　　　　　　　　　　　　　　　　　　　　　　　　　";
			}
			noteWord.setMadeByOrgName(madeByOrgName);
			//指派/报告单位
			noteWord.setAssignedBy(nvl(dispatch.getAssignPerson()));
			//勘验事由
			String assignReason=nvl(checkSign(dispatch.getAssignReason()));
			noteWord.setAssignedContent(assignReason);
			//接警时间
			if(dispatch.getAlarmTime()!=null){
				Date alarmTime = dispatch.getAlarmTime();
				noteWord.setReceivedDateYYYY(alarmTime.getYear()+1900+"");
				noteWord.setReceivedDateMM(alarmTime.getMonth()+1+"");
				noteWord.setReceivedDateDD(alarmTime.getDate()+"");
				noteWord.setReceivedDateHH(alarmTime.getHours()+"");
				noteWord.setReceivedDateMI(alarmTime.getMinutes()+"");
			}else{
				noteWord.setReceivedDateYYYY("");
				noteWord.setReceivedDateMM("");
				noteWord.setReceivedDateDD("");
				noteWord.setReceivedDateHH("");
				noteWord.setReceivedDateMI("");
			}
			
			
			//勘验开始时间
			if(investigation.getInvestigationDateFrom()!=null){
				Date investigationDateFrom = investigation.getInvestigationDateFrom();
				noteWord.setInvestigationDateFrom(nvl(DateUtil.convertDatetimeToChineseString(investigation.getInvestigationDateFrom())));
				noteWord.setInvestigationDateFromYYYY(investigationDateFrom.getYear()+1900+"");
				noteWord.setInvestigationDateFromMM(investigationDateFrom.getMonth()+1+"");
				noteWord.setInvestigationDateFromDD(investigationDateFrom.getDate()+"");
				noteWord.setInvestigationDateFromHH(investigationDateFrom.getHours()+"");
				noteWord.setInvestigationDateFromMI(investigationDateFrom.getMinutes()+"");
			}else{
				noteWord.setInvestigationDateFrom("");
				noteWord.setInvestigationDateFromYYYY("");
				noteWord.setInvestigationDateFromMM("");
				noteWord.setInvestigationDateFromDD("");
				noteWord.setInvestigationDateFromHH("");
				noteWord.setInvestigationDateFromMI("");
			}
			//勘验结束时间
			if(investigation.getInvestigationDateTo()!=null){
				Date investigationDateTo= investigation.getInvestigationDateTo();
				noteWord.setInvestigationDateTo(nvl(DateUtil.convertDatetimeToChineseString(investigation.getInvestigationDateTo())));
				noteWord.setInvestigationDateToYYYY(investigationDateTo.getYear()+1900+"");
				noteWord.setInvestigationDateToMM(investigationDateTo.getMonth()+1+"");
				noteWord.setInvestigationDateToDD(investigationDateTo.getDate()+"");
				noteWord.setInvestigationDateToHH(investigationDateTo.getHours()+"");
				noteWord.setInvestigationDateToMI(investigationDateTo.getMinutes()+"");
			}else{
				noteWord.setInvestigationDateTo("");
				noteWord.setInvestigationDateToYYYY("");
				noteWord.setInvestigationDateToMM("");
				noteWord.setInvestigationDateToDD("");
				noteWord.setInvestigationDateToHH("");
				noteWord.setInvestigationDateToMI("");
			}
			//现场地点
			String place=nvl(investigation.getInvestigationPlace());
			if(!"".equals(place)){
				place=checkSpecialCharactor(place);
			}
			noteWord.setInvestigationPlace(place);
			//现场保护人
			//现场保护人姓名
			String protector=nvl(condition.getProtector());
			if(!"".equals(protector)){
				protector=checkSpecialCharactor(protector);
			}
			noteWord.setProName(protector);
			//现场保护人单位
			String protectorOrgan=nvl(condition.getProtectorOrgan());
			if(!"".equals(protectorOrgan)){
				protectorOrgan=checkSpecialCharactor(protectorOrgan);
			}
			noteWord.setProUnit(protectorOrgan);
			//现场保护人职务
			String protectorDuty=nvl(condition.getProtectorDuty());
			if(!"".equals(protectorDuty)){
				protectorDuty=checkSpecialCharactor(protectorDuty);
			}
			noteWord.setProJob(protectorDuty);
			//保护措施
			//根据代码获取文书保护措施勾选内容
			List protectlist=getProtectList(condition.getProtectionMeasure());
			noteWord.setProtect(protectlist);
			//其他保护措施描述
			if(StringUtils.isNotEmpty(condition.getProtectionMeasureDesc())){
				noteWord.setProtectionDesc(condition.getProtectionMeasureDesc());
			}else{
				noteWord.setProtectionDesc("                    ");
			}
			//现场情况
			noteWord.setSceneCondition(nvl(condition.getSceneCondition()));
			//变动原因显示内容
			List<Bdyy> bdyylist=getBdyyList(condition);
			noteWord.setBDYYList(bdyylist);
			
			//天气内容
			List weatherlist = getWeatherList(condition.getWeather());
			noteWord.setWeatherList(weatherlist);
			
			//天气情况：温度
			noteWord.setEnvTemperature(nvl(condition.getEnvTemperature()));
			
			//天气情况：湿度
			noteWord.setEnvMoistness(nvl(condition.getEnvMoistness()));
			
			// 天气情况：风向
			String wind = "";
			if(StringUtils.isNotEmpty(condition.getWind())){
				wind=sysDictService.findSysDictValueByKeys(condition.getWind(), "XCFXDM");
			}
			noteWord.setWind(nvl(wind));
			
			//光线利用
			List lightings = getLightingList(condition.getLighting());
			noteWord.setWordLighting(lightings);
			
			//现场指挥人员
			List directors = getSceneDirectors(investigation.getId());
			noteWord.setDirectors(directors);
			
			//给notword对象赋值勘验情况
			setInvestigationDescList(noteWord,investigation.getInvestNoteId());
		
			//现场图现场照片数量
			ScenePicSummary scenePicSummary=scenePicSummaryService.findByInvestigationId(investigation.getId());
			if(scenePicSummary!=null){
				//设置现场勘验检查制图数
				noteWord.setScenePictureAmount(nv2(scenePicSummary.getScenePictureAmount()));
				//设置现场照相张数
				noteWord.setScenePhotoAmount(nv2(scenePicSummary.getScenePhotoAmount()));
			}
			
			//设置录象分钟数
			noteWord.setVideoTime(nv2(investigation.getVideoTime()));
			//设置录音分钟数
			noteWord.setRecordTime(nv2(investigation.getRecordTime()));
			
			//设置现场勘验记录人员
			setInvestigators(noteWord,investigation.getId());
			
			//现场勘验人员
			List investigatorList = getInvestigatorList(investigation.getId());
			noteWord.setInvestigatorList(directors);
			
			//查询见证人信息
			List witnessList = getWitnessList(investigation.getId());
			noteWord.setWitnessList(witnessList);
			//见证人备注
			if(StringUtils.isNotEmpty(investigation.getWitnessRemark())){
				noteWord.setRemark(investigation.getWitnessRemark());
			}else{
				noteWord.setRemark("                    ");
			}
			//提取痕迹物证列表
			setSceneCollectedMaterialWord(noteWord,investigation);
			//设置现场图
			setScenePictures(noteWord,investigation.getId());
			//设置现场照片
			setScenePhotos(noteWord,investigation.getId());
			//分析报告
			setAnalysisSuggestion(noteWord,investigation);
			//现在时间
			String rightNowTime=DateUtil.getDate(new Date());
			String year=dealDate(rightNowTime.substring(0,4),"1");
			String month=dealDate(rightNowTime.substring(5,7),"0");
			String day=dealDate(rightNowTime.substring(8,10),"0");
			rightNowTime=year+" 年 "+month+" 月 "+day+" 日 ";
			noteWord.setRightNowTime(rightNowTime);
		}catch (Exception e) {
			throw new RestBusinessException(Status.NOT_ACCEPTABLE, e.getMessage()+"  错误");
		}
		return noteWord;
	}
	/**
	 * 设置现场照片
	 * @throws Exception 
	 */
	private void setScenePhotos(SceneInvestigationNoteWord noteWord, String investigationId) throws Exception {
		// TODO Auto-generated method stub
		List<ScenePicture> list = scenePictureService.findListByInvestigationIdAndCategory(investigationId,"2");
		List<WordScenePicture> list2=new ArrayList();
		for(ScenePicture obj:list){
			String base64Str = getPicBsase64Str(obj.getAttachmentId());
			WordScenePicture wp =new WordScenePicture();
			wp.setName(obj.getId()+".jpg");
			wp.setPictureBase64str(base64Str);
			list2.add(wp);
		}
		if(list2!=null&&list2.size()>0){
			if(list2.size()%2!=0){
				noteWord.setiSscenePictureInfoAddRow("1");
			}
			noteWord.setiSscenePictureInfo("1");
			noteWord.setScenePictureList(list2);
		}else{
			noteWord.setiSscenePictureInfo("0");
			noteWord.setiSscenePictureInfoAddRow("0");
			noteWord.setScenePictureList(null);
		}
	}
	/**
	 * 设置现场图
	 * @throws IOException 
	 */
	private void setScenePictures(SceneInvestigationNoteWord noteWord, String investigationId) throws IOException {
		// TODO Auto-generated method stub
		List<ScenePicture> list = scenePictureService.findListByInvestigationIdAndCategory(investigationId,"1");
		List<WordScenePicture> list2=new ArrayList();
		for(ScenePicture obj:list){
			String base64Str = getPicBsase64Str(obj.getAttachmentId());
			WordScenePicture wp =new WordScenePicture();
			wp.setName(obj.getId()+".jpg");
			wp.setPictureBase64str(base64Str);
			list2.add(wp);
		}
		if(list2!=null&&list2.size()>0){
            if(list2.size()%2!=0){
            	
            	noteWord.setiSjuanZongPictureAddRow("1");
			}
            noteWord.setiSjuanZongPicture("1");
            noteWord.setJuanZongPictureList(list2);
		}else{
			noteWord.setiSjuanZongPicture("0");
			 noteWord.setJuanZongPictureList(null);
		}
	}
	
	/**
	 * 获取现场图现场照片的流文件
	 * @throws IOException 
	 */
	private String getPicBsase64Str(String pictureId) throws IOException{
		BufferedInputStream bin =null;
		String result="";
		try{
			SysParameter sysParams=sysParameterService.getByKey(Constants.SysParam.FILE_SERVER_PATH);
			if(sysParams==null){
				throw new RestBusinessException(Status.NOT_FOUND, "未配置文件服务器地址");
			}
			String urlPath = sysParams.getValue()  + pictureId;//图片下载路径
			// 统一资源
			URL url = new URL(urlPath);
			// 连接类的父类，抽象类
			URLConnection urlConnection = url.openConnection();
			// http的连接类
			HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
			// 设置字符编码
			httpURLConnection.setRequestProperty("Charset", "UTF-8");
			// 打开到此 URL 引用的资源的通信链接（如果尚未建立这样的连接）。
			httpURLConnection.connect();
			bin = new BufferedInputStream(httpURLConnection.getInputStream());
			result=Base64Util.getBase64Str(bin);
		}catch (Exception e) {
			throw new RestBusinessException(Status.NOT_ACCEPTABLE, e.getMessage()+"  错误");
		}finally{
			if(bin!=null){
				bin.close();
			}
		}
		return result;
	}
	
	
	/**
	 * 提取痕迹物证列表
	 * @throws UnsupportedEncodingException 
	 */
	private void setSceneCollectedMaterialWord(SceneInvestigationNoteWord noteWord,SceneInvestigation investigation) throws UnsupportedEncodingException {
		List tempList=new ArrayList();
		List addTableList =new ArrayList();
		List<SceneCollectedGoods> list = sceneCollectedGoodsService.findListByInvestigationId(investigation.getId());
		for(SceneCollectedGoods obj:list){
			WordSceneCollectedMaterial wcm = new WordSceneCollectedMaterial();
			String collectedBy="";
			wcm.setSerialNo(obj.getSerialNo());
			wcm.setMaterialName(obj.getName());
			wcm.setFeature(obj.getFeature());
			wcm.setCollectedPosition(obj.getCollectedPosition());
			wcm.setCollectedMethod(obj.getCollectedMethod());
			wcm.setAmount(obj.getAmount());
			List<SceneCollectedPerson> sceneCollectedPersonlist=obj.getSceneCollectedPerson();
			for(int i=0;i<sceneCollectedPersonlist.size();i++){
				if(i==sceneCollectedPersonlist.size()-1){
					collectedBy+=sceneCollectedPersonlist.get(i).getCollectedPerson();
				}else{
					collectedBy+=sceneCollectedPersonlist.get(i).getCollectedPerson()+",";
				}
			}
			wcm.setCollectedBy(collectedBy);
			tempList.add(wcm);
		}
		if(tempList!=null&&tempList.size()>0){
			int sumRows=0;
			for(int i=0;i<tempList.size();i++){
				WordSceneCollectedMaterial sml=(WordSceneCollectedMaterial) tempList.get(i);
				//初始化每个字段的所占行数
				int materialNameRow=1;
				int collectedPositionRow=1;
				int collectedMethodRow=1;
				int collectedByRow=1;
				if(!sml.getMaterialName().equals("")&&sml.getMaterialName()!=null){
					materialNameRow=fieldRowNum(materialNamelength,new String(sml.getMaterialName().getBytes("gb2312"),"iso-8859-1").length());
				}
				if(!sml.getCollectedPosition().equals("")&&sml.getCollectedPosition()!=null){
					collectedPositionRow=fieldRowNum(collectedPositionlength,new String(sml.getCollectedPosition().getBytes("gb2312"),"iso-8859-1").length());
				}
				if(!sml.getCollectedMethod().equals("")&&sml.getCollectedMethod()!=null){
					collectedMethodRow=fieldRowNum(collectedMethodlength,new String(sml.getCollectedMethod().getBytes("gb2312"),"iso-8859-1").length());
				}
				if(!sml.getCollectedBy().equals("")&&sml.getCollectedBy()!=null){
					collectedByRow=fieldRowNum(collectedBylength,new String(sml.getCollectedBy().getBytes("gb2312"),"iso-8859-1").length());
				}
				int[] rows={materialNameRow,collectedPositionRow,collectedMethodRow,collectedByRow};
				int maxRows=getMaxRow(rows);
				sumRows+=maxRows;
			}
			int row_residue=0;
			if(sumRows<=firstPageline){
				row_residue=firstPageline-sumRows;
			}else{
				if(sumRows-firstPageline<=otherPageline){
					row_residue=otherPageline-(sumRows-firstPageline);
				}else{
					row_residue=otherPageline-(sumRows-firstPageline)%otherPageline;
				}
			}
			if(row_residue!=0){
				for(int a=0;a<row_residue;a++){
					addTableList.add("1");
				}
			}
		}else{
			for(int a=0;a<firstPageline;a++){
				addTableList.add("1");
			}
		}
		noteWord.setTableList(tempList);
		noteWord.setAddTableList(addTableList);
	}
	/**
	 * 分析报告内容赋值
	 */
	private void setAnalysisSuggestion(SceneInvestigationNoteWord noteWord,	SceneInvestigation investigation) {
		//获取分析意见项目
		List<SceneAnalysisItem> list= sceneAnalysisItemService.findByInvestigationId(investigation.getId());
		SceneAnalysisSuggestion t=sceneAnalysisSuggestionService.findByInvestigationId(investigation.getId());
		//损失物品
		List<SceneLostGoods> sceneLostGoodsList = sceneLostGoodsService.findListByInvestigationId(investigation.getId());
		List<SceneCrimeTools> sceneCrimeToolsList=sceneCrimeToolsService.findByInvestigationId(investigation.getId());
		
		//现 场 分 析依据的资料
		String meterialsReliedOn = "";
		// 损失物品
		String intentionDesc = "";
		// 作案地点
		String commissionPlace = "";
		if(StringUtils.isNotEmpty(t.getCommissionPlace())){
			commissionPlace=t.getCommissionPlace();
		}
		noteWord.setCommissionPlace(commissionPlace);
		
		// 作案时段
		String periodDesc = "";
		// 作案出入口
		String entranceDesc = "";
		// 作案手段
		String commissionMeansDesp = "";
		// 侵入方式
		String intrudingWayDesc = "";
		//作案工具
		String toolsDescription = "";
		// 作案动机及目的
		String motiveDesc = "";
		// 案件性质
		String casePropertyDesc = "";
		// 作案人数
		String criminalAmountDesc = "";
		// 作案过程
		String commissionDesc = "";
		if(StringUtils.isNotEmpty(t.getCommissionPlace())){
			commissionDesc=t.getCommissionDesc();
		}
		noteWord.setCommissionDesc(commissionDesc);
		// 作案人特点
		String criminalPoints = "";
		if(StringUtils.isNotEmpty(t.getCriminalPoints())){
			criminalPoints=t.getCriminalPoints();
		}
		noteWord.setCriminalPoints(criminalPoints);
		
		// 并案意见与根据
		String bunchReason = "";
		if(StringUtils.isNotEmpty(t.getBunchReason())){
			bunchReason=t.getBunchReason();
		}
		noteWord.setBunchReason(bunchReason);
		
		// 工作建议
		String suggestion = "";
		// 现场分析人
		String analysedBy = "";
		if(StringUtils.isNotEmpty(t.getAnalysisPerson())){
			analysedBy=t.getAnalysisPerson();
		}
		noteWord.setAnalysedBy(analysedBy);
		
		//分析项目集合分析
		for(SceneAnalysisItem item:list){
			if(item.getItemDictType().equals("XCFXYJZLDM")){//现场分依据的资料
				meterialsReliedOn+=item.getItemType()+",";
			}
			if(item.getItemDictType().equals("ZACRKDM")){//作案出入口
				entranceDesc+=item.getItemType()+",";
			}
			if(item.getItemDictType().equals("ZASDFLDM")){//作案手段
				commissionMeansDesp+=item.getItemType()+",";
			}
			if(item.getItemDictType().equals("QRFSFLDM")){//侵入方式
				intrudingWayDesc+=item.getItemType()+",";
			}
			if(item.getItemDictType().equals("ZADJMDDM")){//作案动机
				motiveDesc+=item.getItemType()+",";
			}
			if(item.getItemDictType().equals("AJXZDM")){//案件性质
				casePropertyDesc+=item.getItemType()+",";
			}
			if(item.getItemDictType().equals("ZARSLDM")){//作案人数
				criminalAmountDesc+=item.getItemType()+",";
			}
			if(item.getItemDictType().equals("ZASJDFLDM")){//作案时段
				periodDesc+=item.getItemType()+",";
			}
		}
		if(StringUtils.isNotEmpty(meterialsReliedOn)){
			meterialsReliedOn=meterialsReliedOn.substring(0,meterialsReliedOn.length()-1);
		}
		noteWord.setMeterialsReliedOn(meterialsReliedOn);
		
		if(StringUtils.isNotEmpty(entranceDesc)){
			entranceDesc=entranceDesc.substring(0,entranceDesc.length()-1);
		}
		noteWord.setEntranceDesc(entranceDesc);
		
		if(StringUtils.isNotEmpty(commissionMeansDesp)){
			commissionMeansDesp=commissionMeansDesp.substring(0,commissionMeansDesp.length()-1);
		}
		noteWord.setCommissionMeansDesp(commissionMeansDesp);
		
		if(StringUtils.isNotEmpty(intrudingWayDesc)){
			intrudingWayDesc=intrudingWayDesc.substring(0,intrudingWayDesc.length()-1);
		}
		noteWord.setIntrudingWayDesc(intrudingWayDesc);
		
		if(StringUtils.isNotEmpty(motiveDesc)){
			motiveDesc=motiveDesc.substring(0,motiveDesc.length()-1);
		}
		noteWord.setMotiveDesc(motiveDesc);
		
		if(StringUtils.isNotEmpty(casePropertyDesc)){
			casePropertyDesc=casePropertyDesc.substring(0,casePropertyDesc.length()-1);
		}
		noteWord.setCasePropertyDesc(casePropertyDesc);
		
		if(StringUtils.isNotEmpty(criminalAmountDesc)){
			criminalAmountDesc=criminalAmountDesc.substring(0,criminalAmountDesc.length()-1);
		}
		noteWord.setCriminalAmountDesc(criminalAmountDesc);
		
		if(StringUtils.isNotEmpty(periodDesc)){
			periodDesc=periodDesc.substring(0,periodDesc.length()-1);
		}
		noteWord.setPeriodDesc(periodDesc);
		
		//侵害目标及损失
		if(sceneLostGoodsList!=null&&sceneLostGoodsList.size()>0){
			intentionDesc+="损失物品：";
			for(int i=0;i<sceneLostGoodsList.size();i++){
				String name = sceneLostGoodsList.get(i).getName();
				if(i==(sceneLostGoodsList.size()-1)){
					intentionDesc+=name+";";
				}else{
					intentionDesc+=name+"、";
				}
			}
			intentionDesc+="损失总价值："+investigation.getLostTotalValue();
		}
		noteWord.setIntentionDesc(intentionDesc);
		
		
		// 作案工具
		if (sceneCrimeToolsList != null && sceneCrimeToolsList.size() > 0) {
			for (int i = 0; i < sceneCrimeToolsList.size(); i++) {
				String name = sceneCrimeToolsList.get(i).getName();
				String description = sceneCrimeToolsList.get(i).getDescription();
				if (i == (sceneCrimeToolsList.size() - 1)) {
					toolsDescription +=name+":"+description;
				} else {
					toolsDescription +=name+":"+description+"\n";
				}
			}
		}
		noteWord.setToolsDescription(toolsDescription);
		
		if(StringUtils.isNotEmpty(t.getSuggestion1())){
			suggestion+="1.关于痕迹物证保管的工作意见：\n\r"+t.getSuggestion1()+"\n\r";
		}else{
			suggestion+="1.关于痕迹物证保管的工作意见：\n\r无\n\r";
		}
		if(StringUtils.isNotEmpty(t.getSuggestion2())){
			suggestion+="2.关于现场处置的工作意见：\n\r"+t.getSuggestion2()+"\n\r";
		}else{
			suggestion+="2.关于现场处置的工作意见：\n\r无\n\r";
		}
		if(StringUtils.isNotEmpty(t.getSuggestion3())){
			suggestion+="3.关于侦查方向与范围的工作意见：\n\r"+t.getSuggestion3()+"\n\r";
		}else{
			suggestion+="3.关于侦查方向与范围的工作意见：\n\r无\n\r";
		}
		if(StringUtils.isNotEmpty(t.getSuggestion4())){
			suggestion+="4.关于技术防范对策的工作意见：\n\r"+t.getSuggestion4()+"\n\r";
		}else{
			suggestion+="4.关于技术防范对策的工作意见：\n\r无\n\r";
		}
		if(StringUtils.isNotEmpty(t.getSuggestion6())){
			suggestion+="6.其他的工作意见：\n\r"+t.getSuggestion6()+"\n\r";
		}else{
			suggestion+="6.其他的工作意见：\n\r无\n\r";
		}
		if(StringUtils.isEmpty(suggestion)){
			noteWord.setSuggestion("");
		}else{
			noteWord.setSuggestion(suggestion);
		}
	}
	/**
	 * 见证人备注
	 */
	private List getWitnessList(String investigationId) {
		// TODO Auto-generated method stub
		//见证人
		List<SceneOffender> sceneOffenderList = sceneOffenderService.findByInvestigationId(investigationId,"3");
		return sceneOffenderList;
	}
	/**
	 * 设置勘验记录人员
	 */
	private void setInvestigators(SceneInvestigationNoteWord noteWord, String investigationId) {
		//查出全部非指挥人员
		List<SceneInvestigator> list =sceneInvestigatorService.findCommandListByInvestigationId(investigationId,null);
		// 笔录人
		String writer = "";
		// 制图人
		String drafter = "";
		// 照相人
		String camerist = "";
		// 录像人
		String videoer = "";
		// 录音人
		String recordist = "";
		for(SceneInvestigator obj:list){
			String duty = obj.getDuty();
			if(duty.indexOf("4")>-1){//笔录
				writer +=duty+","; 
			}
			if(duty.indexOf("5")>-1){//制图人
				drafter +=duty+","; 
			}
			if(duty.indexOf("6")>-1){//照相人
				camerist +=duty+","; 
			}
			if(duty.indexOf("7")>-1){//录像人
				videoer +=duty+","; 
			}
			if(duty.indexOf("10")>-1){//录音人
				recordist +=duty+","; 
			}
		}
		//设置笔录人
		noteWord.setWriter(underline(disposeRy(writer)));	
		//设置制图人
		noteWord.setDrafter(underline(disposeRy(drafter)));
		//设置照相人
		noteWord.setCamerist(underline(disposeRy(camerist)));
		//设置录像人
		noteWord.setVideoer(underline(disposeRy(videoer)));
		//设置录音人
		noteWord.setRecordist(underline(disposeRy(recordist)));
	}
	
	
	/**
	 * 勘验人员集合字符串处理
	 * 方法功能说明：  
	 */
	private String disposeRy(String str){
		if(StringUtils.isNotEmpty(str)){
			str = str.substring(0,str.length()-1);
			String nullStr="";
			int num=0;
			if(str.length()<=50){
				num=50-str.length();
			}
			for(int i=0;i<num;i++){
				nullStr+=" ";	
			}
			str=str+nullStr;
		}else{
			str="                                                  ";
		}
		return str;
	};
	
	/**
	 * 现场勘验人员列表
	 */
	private List getInvestigatorList(String investigationId) {
		List<SceneInvestigator> list =sceneInvestigatorService.findCommandListByInvestigationId(investigationId,null);
		return list;
	}
	
	/**
	 * 按要求格式给文本对象赋值
	 * @throws Exception 
	 */
	private void setInvestigationDescList(SceneInvestigationNoteWord noteWord,String investNoteId) throws Exception {
		if(StringUtils.isNotEmpty(investNoteId)){
			 CommonBigtext commonBigtext = commonBigtextService.findById(investNoteId);
				//过滤特殊字符
				String invDesc=commonBigtext.getContent();
				invDesc=checkSpecialCharactor(invDesc);
				String[] investigationDesc = invDesc.split("\r\n");
				List<String> investigationDescList = new ArrayList();
				if(investigationDesc.length==1)
				{
					String temp = (String)investigationDesc[0];
					if(investigationDesc[0].length()>51)
					{
						noteWord.setTemp(temp.substring(0,50));
						String valueLine2=temp.substring(50,temp.length());
						if(valueLine2!=null&&!"".equals(valueLine2)){
							if(!"。".equals(valueLine2.substring(valueLine2.length()-1))){
								investigationDescList.add(valueLine2+"。（完）                                                           ");
							}else{
								investigationDescList.add(valueLine2+"（完）                                                           ");	
							}
						}else{
						investigationDescList.add(valueLine2+"（完）                                                           ");
						}
						noteWord.setInvestigationDescList(investigationDescList);
					}
					else
					{
						if(temp!=null&&!"".equals(temp)){
							if(!"。".equals(temp.substring(temp.length()-1))){
								temp=temp+"。（完）                                                      ";
							}else{
								temp=temp+"（完）                                                      ";	
							}
						}else{
							temp=temp+"（完）                                                      ";
						}
						noteWord.setTemp(temp);
						noteWord.setInvestigationDescList(investigationDescList);
					}
				}
				else
				{
					for(int i = 0;i<investigationDesc.length;i++){
						
						if(i==investigationDesc.length-1){
							if(investigationDesc[i]!=null&&!"".equals(investigationDesc[i])){
								if(!"。".equals(investigationDesc[i].substring(investigationDesc[i].length()-1))){
									investigationDescList.add(investigationDesc[i]+"。（完）                                                      ");
								}else{
									investigationDescList.add(investigationDesc[i]+"（完）                                                      ");	
								}
							}else{
							investigationDescList.add(investigationDesc[i]+"（完）                                                      ");
							}
						}else{
						investigationDescList.add(investigationDesc[i]+"                                                               ");
						}
					}
					String temp = (String)investigationDescList.get(0);
					noteWord.setTemp(temp);
					investigationDescList.remove(0);
					noteWord.setInvestigationDescList(investigationDescList);
				}
		}else{
			noteWord.setInvestigationDescList(new ArrayList());
		}
		if (noteWord.getInvestigationDescList().size() == 0	&& noteWord.getTemp() == null) {
			noteWord.setIfinvestigationDescListIsNull("1");
		}
	}
	
	/**
	 * 根据勘验ID查询指挥人员详情(姓名、机构、职务详情)
	 */
	private List<SceneInvestigator> getSceneDirectors(String investigationId) {
		List<SceneInvestigator> list =sceneInvestigatorService.findCommandListByInvestigationId(investigationId,"1");
		return list;
	}
	
	/**
	 * 根据光照条件勾选
	 */
	private List getLightingList(String lighting) {
		List lightingList = new ArrayList();
		for (int i = 0; i < 3; i++) {
			WordLighting wordLighting = new WordLighting();
			if (lighting != null && lighting.indexOf(i + 1 + "") > -1) {
				wordLighting.setIfCheck("1");
			} else {
				wordLighting.setIfCheck("0");
			}
			if (i == 0) {
				wordLighting.setLighting("自然光/");
			} else if (i == 1) {
				wordLighting.setLighting("灯光/");
			} else if (i == 2) {
				wordLighting.setLighting("特种光");
			}
			lightingList.add(wordLighting);
		}
		return lightingList;
	}
	
	/**
	 * 根据天气代码获取文书天气勾选
	 */
	private List getWeatherList(String weather) {
		List weatherlist = new ArrayList();
		for (int i = 0; i < 5; i++) {
			WordWeather wordWeather = new WordWeather();
			if (weather != null && weather.indexOf(i + 1 + "") > -1) {
				wordWeather.setIfCheck("1");

			} else {
				wordWeather.setIfCheck("0");
			}
			if (i == 0) {
				wordWeather.setWeather("阴/");
			} else if (i == 1) {
				wordWeather.setWeather("晴/");
			} else if (i == 2) {
				wordWeather.setWeather("雨/");
			} else if (i == 3) {
				wordWeather.setWeather("雪/");
			} else if (i == 4) {
				wordWeather.setWeather("雾");
			}
			weatherlist.add(wordWeather);
		}
		return weatherlist;
	}
	
	/**
	 * 根据条件对象获取文书保护措施勾选
	 */
	private List<Bdyy> getBdyyList(SceneCondition condition) {
		//变动原因转list存入sceneInvestigationNoteWord 中
//		变动原因:其他
		String BDYYDESC=nvl(condition.getChangeReasonDesc());
		String BDYY = condition.getChangeReason();
		//事主进入
		Bdyy bdyy1=new Bdyy();
		bdyy1.setIfCheck("0");
		bdyy1.setBDYY("事主进入/");
		bdyy1.setBDYYDESC("");
		//报案人进入
		Bdyy bdyy2=new Bdyy();
		bdyy2.setIfCheck("0");
		bdyy2.setBDYY("报案人进入/");
		bdyy2.setBDYYDESC("");
		//其他原因
		Bdyy bdyy3=new Bdyy();
		bdyy3.setIfCheck("0");
		bdyy3.setBDYY("其他：");
		bdyy3.setBDYYDESC(BDYYDESC);
		//变动原因list
		List<Bdyy> BDYYList=new ArrayList<Bdyy>();
		//根据数据库所存处理变动原因list
		if(StringUtils.isNotBlank(BDYY))
		{
			//若变动原因中有1001，则事主进入为勾选
			if(BDYY.indexOf("1001")>-1)
			{
				bdyy1.setIfCheck("1");
			}
			//若变动原因中有1002，则报案人进入为勾选
			if(BDYY.indexOf("1002")>-1)
			{
				bdyy2.setIfCheck("1");
			}
//			若变动原因中有1002，则其他为勾选
			if(BDYY.indexOf("1009")>-1)
			{
				bdyy3.setIfCheck("1");
			}
		}
		BDYYList.add(bdyy1);
		BDYYList.add(bdyy2);
		BDYYList.add(bdyy3);
		return BDYYList;
	}
	
	/**
	 * 根据代码获取文书保护措施勾选
	 */
	private List getProtectList(String protectionMeasure) {
		List protectlist=new ArrayList();
		for(int i=0;i<4;i++){
				WordProtected wordprotected=new WordProtected();
				if(protectionMeasure.indexOf(i+1+"")>-1){
					wordprotected.setIfCheck("1");
				}else{
					wordprotected.setIfCheck("0");
				}
				if(i==0){
					wordprotected.setProtectWay("设立警戒带，划定禁行区域/");
				}else if(i==1){
					wordprotected.setProtectWay("专人看护现场，防止他人进入/");
				}
				else if(i==2){
					wordprotected.setProtectWay("被害人自行保护/");
				}
				else if(i==3){
					wordprotected.setProtectWay("其他措施");
				}
				protectlist.add(wordprotected);
			}
		return protectlist;
	}
	
	/**
	 * 根据勘验对象生成文件名称
	 * 方法功能说明：  
	 * 创建：2016-12-21 上午9:32:50 by guochen
	 * @return  
	 * @throws
	 */
	private String getInvestigationFileName(SceneInvestigation si,String type){
		//生成的文件名
		StringBuffer newFilename =  new StringBuffer(si.getInvestigationNo());
		if(si.getIterationNo().intValue()!=0){
			newFilename.append("_"+si.getIterationNo());
		}
		newFilename.append("_"+type);
		return newFilename.toString();
	}
	
	/**
	 * 判断字符串后标点符号
	 * @param content
	 * @return
	 */
	private String checkSign(String content){
		String returnStr="";
		if(content!=null&&!"".equals(content)){
			returnStr=content.substring(content.length()-1);
			if("。".equals(returnStr)){
				content=content.substring(0,content.length()-1);
			}
			return content;
		}else{
			return	"";
		}
	}
	
	/**
	 * 过滤特殊字符
	 * @throws Exception 
	 */
	public String checkSpecialCharactor(String content) throws Exception{
		if (StringUtils.isNotBlank(content)) {
			String escapeHtml = ConfigUtil.getConfig("escapeHtml");
			StringTokenizer ehs = new StringTokenizer(escapeHtml, "|");
			String[] token = null;
			while (ehs.hasMoreTokens()) {
				token = ehs.nextToken().split(",");
				content = content.replaceAll(token[0], token[1]);
			}
			return content;
		}
		return content;
	}
	
	/**
	 * 字符串变换：null-->"__________"
	 * @param s
	 * @return
	 */
	private String underline(String s){
		return (s==null)?"":s;
	}
	/**
	 * 字符串变换：null-->""
	 * @param s
	 * @return
	 */
	private String nvl(Object s){
		return (s==null)?"":s.toString();
	}
	/**
	 * 整型变字符串：Integer-->""
	 * @param s
	 * @return
	 */
	private String nv2(Integer s){
		if(s==null){
			return "0";
		}else{
			return String.valueOf(s);
		}
	}
	/**
	 * 时间转换，将数据库时间转换为中文文字的时间
	 * @param noteCreateDate
	 * @return 转换结果
	 */
	private String chaneDateToChinese(Date noteCreateDate){
		//定义一个String，作为返回结果
		String resultString="";
		//获得笔录创建时间
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(noteCreateDate);
		//分别获得年、月、日
		String year=String.valueOf(calendar.get(Calendar.YEAR));
		String month=String.valueOf(calendar.get(Calendar.MONTH)+1);
		String day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		resultString=resultString+chaneStringToChinese(year)+"年";
		String strMonth=chaneStringToChinese(month);
		if(strMonth.length()==2){
			if(!strMonth.substring(1,2).equals("〇")){
				strMonth="十"+strMonth.substring(1,2);
			}else{
				strMonth="十";
			}
			
		}
		resultString=resultString+strMonth+"月";
		String strDay=chaneStringToChinese(day);
		if(strDay.length()==2){
			if(strDay.substring(0,1).equals("一")){
				if(!strDay.substring(1,2).equals("〇")){
				strDay="十"+strDay.substring(1,2);
				}else{
				strDay="十";
				}
			}
			if(strDay.substring(0,1).equals("二")){
				if(!strDay.substring(1,2).equals("〇")){
					strDay="二十"+strDay.substring(1,2);
					}else{
					strDay="二十";
					}
			}
			if(strDay.substring(0,1).equals("三")){
				if(!strDay.substring(1,2).equals("〇")){
					strDay="三十"+strDay.substring(1,2);
					}else{
					strDay="三十";
					}
			}
		}
		resultString=resultString+strDay+"日";
		//返回转换结果
		return resultString;
	}
	
	/**
	 * 将字符串转换成对应的中文
	 * @param dateString
	 * @return 转换结果
	 */
	private String chaneStringToChinese(String dateString){
		String resultString="";
		//分别将年、月、日转换为中文
		//转换年
		int singleNumber;
		for(int i=0;i<dateString.length();i++){
			singleNumber=Integer.parseInt(dateString.substring(i,i+1));
			switch (singleNumber){
			case 0:
				resultString+="〇";
				break;
			case 1:
				resultString+="一";
				break;
			case 2:
				resultString+="二";
				break;
			case 3:
				resultString+="三";
				break;
			case 4:
				resultString+="四";
				break;
			case 5:
				resultString+="五";
				break;
			case 6:
				resultString+="六";
				break;
			case 7:
				resultString+="七";
				break;
			case 8:
				resultString+="八";
				break;
			case 9:
				resultString+="九";
				break;
				
			}
		}
		//返回转换结果
		return resultString;
	}

	// 处理年月日
	public String dealDate(String data, String type) {
		StringBuffer sb = new StringBuffer();
		if ("1".equals(type)) {// 年
			for (int i = 0; i < data.length(); i++) {
				sb.append(switchData(Integer.parseInt(data.charAt(i) + "")));
			}
		} else {// 月-日
			sb.append(switchData(Integer.parseInt(data)));
		}
		return sb.toString();
	}

	public String switchData(int d) {
		switch (d) {
		case 0:
			return "〇";
		case 1:
			return "一";
		case 2:
			return "二";
		case 3:
			return "三";
		case 4:
			return "四";
		case 5:
			return "五";
		case 6:
			return "六";
		case 7:
			return "七";
		case 8:
			return "八";
		case 9:
			return "九";
		case 10:
			return "十";
		case 11:
			return "十一";
		case 12:
			return "十二";
		case 13:
			return "十三";
		case 14:
			return "十四";
		case 15:
			return "十五";
		case 16:
			return "十六";
		case 17:
			return "十七";
		case 18:
			return "十八";
		case 19:
			return "十九";
		case 20:
			return "二十";
		case 21:
			return "二十一";
		case 22:
			return "二十二";
		case 23:
			return "二十三";
		case 24:
			return "二十四";
		case 25:
			return "二十五";
		case 26:
			return "二十六";
		case 27:
			return "二十七";
		case 28:
			return "二十八";
		case 29:
			return "二十九";
		case 30:
			return "三十";
		case 31:
			return "三十一";
		default:
			return "";
		}
	}
	
	 //一个字段站的行数
	 public int fieldRowNum(int full_length,int real_length){
		 int row=1;
		 if(real_length<=full_length){
			 row=1;
		 }else{
			 if(real_length%full_length==0){
				 row=real_length/full_length;
			 }else{
				 row=real_length/full_length+1; 
			 }
		 }
		return row;
	 }
	 
	 /**
	  * 获取一条数据站的最大行数
	  * @param rows
	  * @return
	  */
	 public int getMaxRow(int[] rows){
	      int max = 0;
	      max=rows[0];
	      for(int x =0;x<rows.length;x++){
	      if(rows[x]>max){
	         max = rows[x];
	        }
	      }
		return max;
	   }
	 //球文件路径大小
	 public Integer getFileSize(File f) throws Exception{//递归求取目录文件个数
	        int size = 0;
	        FileInputStream fis = new FileInputStream(f);
	        double resourcesize = (double)((double)fis.available()/1024);
	        size = (int) resourcesize;
	        return size;
	   }
	 /**
	    * 根据文件路径删除文件
	    * 方法功能说明：  
	    * 创建：2016-9-27 上午10:11:11 by guochen
	    * @参数： 
	    * @参数：    
	    * @return  
	    * @throws
	    */
		public void deleteFile(String sPath) {
			File file = new File(sPath);
			// 路径为文件且不为空则进行删除
			if (file.isFile() && file.exists()) {
				file.delete();
			}
		}
}
