package com.hisign.xcky.service.impl.sceneCollecting.input;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.hisign.sdk.cache.redis.RedisClient;
import com.hisign.sso.api.rest.exception.RestBusinessException;
import com.hisign.xcky.api.model.sceneCollecting.BasestationInfo;
import com.hisign.xcky.api.model.sceneCollecting.CameraInfo;
import com.hisign.xcky.api.model.sceneCollecting.CommonAttachment;
import com.hisign.xcky.api.model.sceneCollecting.CommonBigtext;
import com.hisign.xcky.api.model.sceneCollecting.SceneAnalysisItem;
import com.hisign.xcky.api.model.sceneCollecting.SceneAnalysisSuggestion;
import com.hisign.xcky.api.model.sceneCollecting.SceneBodyBasic;
import com.hisign.xcky.api.model.sceneCollecting.SceneCollectedGoods;
import com.hisign.xcky.api.model.sceneCollecting.SceneCollectedPerson;
import com.hisign.xcky.api.model.sceneCollecting.SceneCondition;
import com.hisign.xcky.api.model.sceneCollecting.SceneCrimeTools;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigation;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigationDispatch;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigationStatus;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigator;
import com.hisign.xcky.api.model.sceneCollecting.SceneLostGoods;
import com.hisign.xcky.api.model.sceneCollecting.SceneMaterialEvidence;
import com.hisign.xcky.api.model.sceneCollecting.SceneOffender;
import com.hisign.xcky.api.model.sceneCollecting.ScenePicture;
import com.hisign.xcky.api.model.system.SysParameter;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.service.sceneCollecting.BasestationInfoService;
import com.hisign.xcky.api.service.sceneCollecting.CameraInfoService;
import com.hisign.xcky.api.service.sceneCollecting.CommonAttachmentService;
import com.hisign.xcky.api.service.sceneCollecting.CommonBigtextService;
import com.hisign.xcky.api.service.sceneCollecting.SceneAnalysisItemService;
import com.hisign.xcky.api.service.sceneCollecting.SceneAnalysisSuggestionService;
import com.hisign.xcky.api.service.sceneCollecting.SceneBodyBasicService;
import com.hisign.xcky.api.service.sceneCollecting.SceneCollectedGoodsService;
import com.hisign.xcky.api.service.sceneCollecting.SceneCollectedPersonService;
import com.hisign.xcky.api.service.sceneCollecting.SceneConditionService;
import com.hisign.xcky.api.service.sceneCollecting.SceneCrimeToolsService;
import com.hisign.xcky.api.service.sceneCollecting.SceneInvestigationDispatchService;
import com.hisign.xcky.api.service.sceneCollecting.SceneInvestigationService;
import com.hisign.xcky.api.service.sceneCollecting.SceneInvestigationStatusService;
import com.hisign.xcky.api.service.sceneCollecting.SceneInvestigatorService;
import com.hisign.xcky.api.service.sceneCollecting.SceneLostGoodsService;
import com.hisign.xcky.api.service.sceneCollecting.SceneMaterialEvidenceService;
import com.hisign.xcky.api.service.sceneCollecting.SceneOffenderService;
import com.hisign.xcky.api.service.sceneCollecting.ScenePicSummaryService;
import com.hisign.xcky.api.service.sceneCollecting.ScenePictureService;
import com.hisign.xcky.api.service.sceneCollecting.input.ReviewSceneInfoInputService;
import com.hisign.xcky.api.service.system.SysParameterService;
import com.hisign.xcky.api.service.system.SysSequenceService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.util.HttpFileUtil;
import com.hisign.xcky.util.JsonResultUtil;
import com.hisign.xcky.util.UUIDService;
/**
 * 复堪勘验信息录入接口
 * 项目名称：xcky-service-sceneCollecting   
 * 类名称：SceneInvestigationInputServiceImpl   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-12 上午10:52:52   
 * 修改人：hisign   
 * 修改时间：2016-12-12 上午10:52:52   
 * 修改备注：   
 * @version
 */
@Path("/reviewSceneInfo")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("reviewSceneInfoInputService")
@Transactional
public class ReviewSceneInfoInputServiceImpl  implements ReviewSceneInfoInputService{
	/**
	 * 日志输出
	 */
	private final static Logger logger = LoggerFactory.getLogger(ReviewSceneInfoInputServiceImpl.class);
	/**
	 * redis缓存接口
	 */
	@Autowired
	protected RedisClient  redisClient;
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
	 * 文本业务接口
	 */
	@Autowired
	private CommonBigtextService commonBigtextService;
	/**
	 * 现场条件接口
	 */
	@Autowired
	private SceneConditionService sceneConditionService;
	/**
	 * 损失物品接口
	 */
	@Autowired
	private SceneLostGoodsService sceneLostGoodsService;
	/**
	 * 涉案人员
	 */
	@Autowired
	private SceneOffenderService sceneOffenderService;
	/**
	 * 现场图接口
	 */
	@Autowired
	private ScenePictureService scenePictureService;
	/**
	 * 现场痕迹接口
	 */
	@Autowired
	private SceneMaterialEvidenceService sceneMaterialEvidenceService;
	/**
	 * 提取物接口
	 */
	@Autowired
	private SceneCollectedGoodsService sceneCollectedGoodsService;
	/**
	 * 勘验人接口
	 */
	@Autowired
	private SceneInvestigatorService sceneInvestigatorService;
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
	 * 流水业务接口
	 */
	@Autowired
	private SysSequenceService sysSequenceService;
	/**
	 * 尸体信息接口
	 */
	@Autowired
	private SceneBodyBasicService sceneBodyBasicService;
	/**
	 * 提取人接口
	 */
	@Autowired
	private SceneCollectedPersonService sceneCollectedPersonService;
	/**
	 * 摄像头接口
	 */
	@Autowired
	private CameraInfoService cameraInfoService;
	/**
	 * 现场勘验信息状态接口
	 */
	@Autowired
	private SceneInvestigationStatusService sceneInvestigationStatusService;
	/**
	 * 图片汇总接口
	 */
	@Autowired
	private ScenePicSummaryService scenePicSummaryService;
	
	/**
	 * 附件信息接口
	 */
	@Autowired
	private CommonAttachmentService commonAttachmentService;
	
	/**
	 * 基站信息接口
	 */
	@Autowired
	private BasestationInfoService basestationInfoService;
	
	@Autowired
	private SysParameterService sysParameterService;
	
	
    /**
	 * 保存
	 * 方法功能说明：  
	 * 创建：2016-12-13 上午9:25:14 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
    /* (non-Javadoc)
     * @see com.hisign.xcky.api.service.sceneCollecting.input.SceneInfoInputService#save(java.lang.String, java.util.Map)
     */
    @Override
    @POST
	@Path("save")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult save(@HeaderParam("token")String token, Map<String, Object> map) {
    	logger.info("----------------暂存勘验数据-----------");
    	SysUser sysUser=getCurrentUser(token);
		try{
			//初始化入库参数对象
			SceneInvestigation sceneInvestigation = new SceneInvestigation();
			SceneInvestigationDispatch sceneInvestigationDispatch = new SceneInvestigationDispatch();
			CommonBigtext commonBigtext = new CommonBigtext();
			SceneCondition sceneCondition = new SceneCondition();
			List<SceneLostGoods> sceneLostGoodsList  = new ArrayList<SceneLostGoods>();
			List<SceneOffender> sceneOffenderList = new ArrayList<SceneOffender>();
			List<ScenePicture> scenePictureList = new ArrayList<ScenePicture>();
			List<SceneMaterialEvidence> sceneMaterialEvidenceList = new ArrayList<SceneMaterialEvidence>();
			List<SceneCollectedGoods> sceneCollectedGoodsList = new ArrayList<SceneCollectedGoods>();
			List<SceneInvestigator> sceneInvestigatorList = new ArrayList<SceneInvestigator>();
			SceneAnalysisSuggestion sceneAnalysisSuggestion = new SceneAnalysisSuggestion();
			List<SceneAnalysisItem> sceneAnalysisItemList = new ArrayList<SceneAnalysisItem>();
			List<SceneCrimeTools> sceneCrimeToolsList = new ArrayList<SceneCrimeTools>();
			List<SceneBodyBasic> sceneBodyBasicsList  = new ArrayList<SceneBodyBasic>();
			List<SceneCollectedPerson> sceneCollectedPersonList  = new ArrayList<SceneCollectedPerson>();
			List<CameraInfo> cameraInfoList = new ArrayList<CameraInfo>();
			List<CommonAttachment> commonAttachmentList = new ArrayList<CommonAttachment>();
			
			/********解析案情模块报文*********/
			
			String completeFlag=(String) map.get("completeFlag");
			
			String sceneInvestigationDispatchJson = JSON.toJSONString(map.get("sceneInvestigationDispatch"));
			JSONObject sceneInvestigationDispatchJsonObj=JSON.parseObject(sceneInvestigationDispatchJson);
			String sceneOffenderJson=JSON.toJSONString(sceneInvestigationDispatchJsonObj.get("sceneOffender"));
			//受害人/报案人
			List<SceneOffender> sceneOffenderlistForBA =JSON.parseArray(sceneOffenderJson, SceneOffender.class);
			//接堪信息
			sceneInvestigationDispatch = JSON.parseObject(sceneInvestigationDispatchJson,SceneInvestigationDispatch.class);
			//涉案人员集合添加受害人报案人
			sceneOffenderList.addAll(sceneOffenderlistForBA);
			
			/********解析出堪信息报文*********/
			String sceneHandleInfoJson = JSON.toJSONString(map.get("sceneHandleInfo"));
			JSONObject sceneHandleInfoObj=JSON.parseObject(sceneHandleInfoJson);
			String sceneInvestigatorJson=JSON.toJSONString(sceneHandleInfoObj.get("sceneInvestigator"));
			//勘验人集合
			sceneInvestigatorList = JSON.parseArray(sceneInvestigatorJson, SceneInvestigator.class);
			//勘验情况
			sceneInvestigation = JSON.parseObject(sceneHandleInfoJson,SceneInvestigation.class);
			
			/********解析现场条件报文*********/
			String sceneConditionJson = JSON.toJSONString(map.get("sceneCondition"));
			sceneCondition = JSON.parseObject(sceneConditionJson,SceneCondition.class);
			
			/********解析现场照片*********/
			String scenePhotoJson = JSON.toJSONString(map.get("scenePhoto"));
			List<ScenePicture> scenePhotosList =JSON.parseArray(scenePhotoJson, ScenePicture.class);
			scenePictureList.addAll(scenePhotosList);
			
			/********解析现场图*********/
			String scenePictureJson = JSON.toJSONString(map.get("scenePicture"));
			List<ScenePicture> scenePicturesList =JSON.parseArray(scenePictureJson, ScenePicture.class);
			scenePictureList.addAll(scenePicturesList);
			
			/********解析痕迹*********/
			String materialEvidenceJson = JSON.toJSONString(map.get("materialEvidence"));
			JSONObject materialEvidenceObj=JSON.parseObject(materialEvidenceJson);
			//解析痕迹物证
			String sceneMaterialEvidenceJson = JSON.toJSONString(materialEvidenceObj.get("sceneMaterialEvidence"));
			JSONArray jsonArray=JSON.parseArray(sceneMaterialEvidenceJson);
			for(Object jOb:jsonArray){
				JSONObject jsonObj=(JSONObject) jOb;
				String materialEvidenceId= UUIDService.getInstance().simpleHex();
				SceneMaterialEvidence obj=JSON.parseObject(JSON.toJSONString(jsonObj), SceneMaterialEvidence.class);
				obj.setId(materialEvidenceId);
				sceneMaterialEvidenceList.add(obj);
				List<SceneCollectedPerson> list =JSON.parseArray(jsonObj.getString("sceneCollectedPerson"), SceneCollectedPerson.class);
				for(SceneCollectedPerson sceneCollectedPerson:list){
					sceneCollectedPerson.setMaterialEvidenceId(materialEvidenceId);
				}
				sceneCollectedPersonList.addAll(list);
			}
			//摄像头信息
			String cameraInfoJson=JSON.toJSONString(materialEvidenceObj.get("cameraInfo"));
			cameraInfoList =JSON.parseArray(cameraInfoJson, CameraInfo.class);
			/********解析提取物品*********/
			String sceneCollectedGoodsJson = JSON.toJSONString(map.get("sceneCollectedGoods"));
			JSONArray sceneCollectedGoodsjsonArray=JSON.parseArray(sceneCollectedGoodsJson);
			for(Object jOb:sceneCollectedGoodsjsonArray){
				JSONObject jsonObj=(JSONObject) jOb;
				String sceneCollectedGoodsId= UUIDService.getInstance().simpleHex();
				SceneCollectedGoods sceneCollectedGoods=JSON.parseObject(JSON.toJSONString(jsonObj), SceneCollectedGoods.class);
				sceneCollectedGoodsList.add(sceneCollectedGoods);
				List<SceneCollectedPerson> list =JSON.parseArray(jsonObj.getString("sceneCollectedPerson"), SceneCollectedPerson.class);
				for(SceneCollectedPerson sceneCollectedPerson:list){
					sceneCollectedPerson.setMaterialEvidenceId(sceneCollectedGoodsId);
				}
				sceneCollectedPersonList.addAll(list);
			}
			
			//基站信息
			String baseStationInfoJson=JSON.toJSONString(materialEvidenceObj.get("baseStationInfo"));
			commonAttachmentList =JSON.parseArray(baseStationInfoJson, CommonAttachment.class);
			//
			
			/********解析勘验情况*********/
			String sceneInvestigationJson = JSON.toJSONString(map.get("sceneInvestigation"));
			JSONObject sceneInvestigationObj=JSON.parseObject(sceneInvestigationJson);
			String sceneLostGoodsJson=JSON.toJSONString(sceneInvestigationObj.get("sceneLostGoods"));
			sceneLostGoodsList = JSON.parseArray(sceneLostGoodsJson, SceneLostGoods.class);
			String sceneOffenderJson2=JSON.toJSONString(sceneInvestigationObj.get("sceneOffender"));
			List<SceneOffender> sceneOffenderlistForJZ =JSON.parseArray(sceneOffenderJson2, SceneOffender.class);
			sceneOffenderList.addAll(sceneOffenderlistForJZ);
			SceneInvestigation sceneInvestigationRepeat = JSON.parseObject(sceneInvestigationJson,SceneInvestigation.class);
			sceneInvestigation.setTemplateId(sceneInvestigationRepeat.getTemplateId());//"现场录入模板ID"
			sceneInvestigation.setLostTotalValue(sceneInvestigationRepeat.getLostTotalValue());//"损失物品总价值",
			sceneInvestigation.setInvestNoteFlag(sceneInvestigationRepeat.getInvestNoteFlag());//"是否填写现场勘验情况(SFDM)",
			sceneInvestigation.setSceneDisposal(sceneInvestigationRepeat.getSceneDisposal());//"现场处置意见(XCCZYJDM)",
			sceneInvestigation.setSceneDisposalDesc(sceneInvestigationRepeat.getSceneDisposalDesc());//"现场处置意见描述",
			sceneInvestigation.setVideoTime(sceneInvestigationRepeat.getVideoTime());//"录像时间",
			sceneInvestigation.setRecordTime(sceneInvestigationRepeat.getRecordTime());// "录音时间",
			sceneInvestigation.setWitnessRemark(sceneInvestigationRepeat.getWitnessRemark());//见证人备注
			/********大文本*********/
			commonBigtext.setContent(sceneInvestigationRepeat.getContent());
			
			/********分析意见*********/
			String sceneAnalysisSuggestionJson = JSON.toJSONString(map.get("sceneAnalysisSuggestion"));
			JSONObject sceneAnalysisSuggestionObj=JSON.parseObject(sceneAnalysisSuggestionJson);
			String sceneAnalysisItemJson=JSON.toJSONString(sceneAnalysisSuggestionObj.get("sceneAnalysisItem"));
			String sceneCrimeToolsJson=JSON.toJSONString(sceneAnalysisSuggestionObj.get("sceneCrimeTools"));
			sceneAnalysisSuggestion = JSON.parseObject(sceneAnalysisSuggestionJson,SceneAnalysisSuggestion.class);
			sceneAnalysisItemList = JSON.parseArray(sceneAnalysisItemJson, SceneAnalysisItem.class);
			sceneCrimeToolsList = JSON.parseArray(sceneCrimeToolsJson, SceneCrimeTools.class);
			
			/********尸体信息*********/
			String sceneBodyBasicJson = JSON.toJSONString(map.get("sceneBodyBasic"));
			sceneBodyBasicsList = JSON.parseArray(sceneBodyBasicJson, SceneBodyBasic.class);
			String investigationNo = (String) map.get("investigationNo");
			String sceneInvestigationId =  insertInvestigationMessage(completeFlag,token,
					null, investigationNo,
					sceneInvestigation,
					sceneInvestigationDispatch,
					commonBigtext, sceneCondition,
					sceneLostGoodsList,
					sceneOffenderList,
					scenePictureList,
					sceneMaterialEvidenceList,
					sceneCollectedGoodsList,
					sceneInvestigatorList,
					sceneAnalysisSuggestion,
					sceneAnalysisItemList,
					sceneCrimeToolsList,
					sceneBodyBasicsList,
					sceneCollectedPersonList,
					cameraInfoList,
					commonAttachmentList
					);
			//更新图片汇总信息
			scenePicSummaryService.updateByInvestigationId(token, sceneInvestigationId);
    		logger.info("清除redis缓存");
    		redisClient.del(Constants.Redis.INPUT_PREFIX+sysUser.getUsername());
		}catch (com.alibaba.fastjson.JSONException e) {
			throw new RestBusinessException(Status.NOT_ACCEPTABLE, e.getMessage()+"  错误");
		}
		return JsonResultUtil.success();
	}
    
    /**
	 * 提交
	 * 方法功能说明：  
	 * 创建：2016-12-13 上午9:25:14 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
    @Override
    @POST
	@Path("summit")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult summit(@HeaderParam("token")String token, Map<String, Object> map) {
    	logger.info("----------------提交勘验数据-----------");
    	SysUser sysUser=getCurrentUser(token);
		try{
			//初始化入库参数对象
			SceneInvestigation sceneInvestigation = new SceneInvestigation();
			SceneInvestigationDispatch sceneInvestigationDispatch = new SceneInvestigationDispatch();
			CommonBigtext commonBigtext = new CommonBigtext();
			SceneCondition sceneCondition = new SceneCondition();
			List<SceneLostGoods> sceneLostGoodsList  = new ArrayList<SceneLostGoods>();
			List<SceneOffender> sceneOffenderList = new ArrayList<SceneOffender>();
			List<ScenePicture> scenePictureList = new ArrayList<ScenePicture>();
			List<SceneMaterialEvidence> sceneMaterialEvidenceList = new ArrayList<SceneMaterialEvidence>();
			List<SceneCollectedGoods> sceneCollectedGoodsList = new ArrayList<SceneCollectedGoods>();
			List<SceneInvestigator> sceneInvestigatorList = new ArrayList<SceneInvestigator>();
			SceneAnalysisSuggestion sceneAnalysisSuggestion = new SceneAnalysisSuggestion();
			List<SceneAnalysisItem> sceneAnalysisItemList = new ArrayList<SceneAnalysisItem>();
			List<SceneCrimeTools> sceneCrimeToolsList = new ArrayList<SceneCrimeTools>();
			List<SceneBodyBasic> sceneBodyBasicsList  = new ArrayList<SceneBodyBasic>();
			List<SceneCollectedPerson> sceneCollectedPersonList  = new ArrayList<SceneCollectedPerson>();
			List<CameraInfo> cameraInfoList = new ArrayList<CameraInfo>();
			List<CommonAttachment> commonAttachmentList = new ArrayList<CommonAttachment>();
			
			/********解析案情模块报文*********/
			String sceneInvestigationDispatchJson = JSON.toJSONString(map.get("sceneInvestigationDispatch"));
			JSONObject sceneInvestigationDispatchJsonObj=JSON.parseObject(sceneInvestigationDispatchJson);
			String sceneOffenderJson=JSON.toJSONString(sceneInvestigationDispatchJsonObj.get("sceneOffender"));
			//受害人/报案人
			List<SceneOffender> sceneOffenderlistForBA =JSON.parseArray(sceneOffenderJson, SceneOffender.class);
			//接堪信息
			sceneInvestigationDispatch = JSON.parseObject(sceneInvestigationDispatchJson,SceneInvestigationDispatch.class);
			//涉案人员集合添加受害人报案人
			sceneOffenderList.addAll(sceneOffenderlistForBA);
			
			/********解析出堪信息报文*********/
			String sceneHandleInfoJson = JSON.toJSONString(map.get("sceneHandleInfo"));
			JSONObject sceneHandleInfoObj=JSON.parseObject(sceneHandleInfoJson);
			String sceneInvestigatorJson=JSON.toJSONString(sceneHandleInfoObj.get("sceneInvestigator"));
			//勘验人集合
			sceneInvestigatorList = JSON.parseArray(sceneInvestigatorJson, SceneInvestigator.class);
			//勘验情况
			sceneInvestigation = JSON.parseObject(sceneHandleInfoJson,SceneInvestigation.class);
			
			/********解析现场条件报文*********/
			String sceneConditionJson = JSON.toJSONString(map.get("sceneCondition"));
			sceneCondition = JSON.parseObject(sceneConditionJson,SceneCondition.class);
			
			/********解析现场照片*********/
			String scenePhotoJson = JSON.toJSONString(map.get("scenePhoto"));
			List<ScenePicture> scenePhotosList =JSON.parseArray(scenePhotoJson, ScenePicture.class);
			scenePictureList.addAll(scenePhotosList);
			
			/********解析现场图*********/
			String scenePictureJson = JSON.toJSONString(map.get("scenePicture"));
			List<ScenePicture> scenePicturesList =JSON.parseArray(scenePictureJson, ScenePicture.class);
			scenePictureList.addAll(scenePicturesList);
			
			/********解析痕迹*********/
			String materialEvidenceJson = JSON.toJSONString(map.get("materialEvidence"));
			JSONObject materialEvidenceObj=JSON.parseObject(materialEvidenceJson);
			//解析痕迹物证
			String sceneMaterialEvidenceJson = JSON.toJSONString(materialEvidenceObj.get("sceneMaterialEvidence"));
			JSONArray jsonArray=JSON.parseArray(sceneMaterialEvidenceJson);
			for(Object jOb:jsonArray){
				JSONObject jsonObj=(JSONObject) jOb;
				String materialEvidenceId= null;
				SceneMaterialEvidence obj=JSON.parseObject(JSON.toJSONString(jsonObj), SceneMaterialEvidence.class);
				if(StringUtils.isNotEmpty(obj.getId())){
					materialEvidenceId= obj.getId();
				}else{
					materialEvidenceId= UUIDService.getInstance().simpleHex();
					obj.setId(materialEvidenceId);
				}
				sceneMaterialEvidenceList.add(obj);
				List<SceneCollectedPerson> list =JSON.parseArray(jsonObj.getString("sceneCollectedPerson"), SceneCollectedPerson.class);
				for(SceneCollectedPerson sceneCollectedPerson:list){
					sceneCollectedPerson.setMaterialEvidenceId(materialEvidenceId);
				}
				sceneCollectedPersonList.addAll(list);
			}
			//摄像头信息
			String cameraInfoJson=JSON.toJSONString(materialEvidenceObj.get("cameraInfo"));
			cameraInfoList =JSON.parseArray(cameraInfoJson, CameraInfo.class);
			/********解析提取物品*********/
			String sceneCollectedGoodsJson = JSON.toJSONString(map.get("sceneCollectedGoods"));
			JSONArray sceneCollectedGoodsjsonArray=JSON.parseArray(sceneCollectedGoodsJson);
			for(Object jOb:sceneCollectedGoodsjsonArray){
				JSONObject jsonObj=(JSONObject) jOb;
				String sceneCollectedGoodsId= null;
				SceneCollectedGoods sceneCollectedGoods=JSON.parseObject(JSON.toJSONString(jsonObj), SceneCollectedGoods.class);
				if(StringUtils.isNotEmpty(sceneCollectedGoods.getId())){
					sceneCollectedGoodsId= sceneCollectedGoods.getId();
				}else{
					sceneCollectedGoodsId= UUIDService.getInstance().simpleHex();
					sceneCollectedGoods.setId(sceneCollectedGoodsId);
				}
				sceneCollectedGoodsList.add(sceneCollectedGoods);
				List<SceneCollectedPerson> list =JSON.parseArray(jsonObj.getString("sceneCollectedPerson"), SceneCollectedPerson.class);
				for(SceneCollectedPerson sceneCollectedPerson:list){
					sceneCollectedPerson.setMaterialEvidenceId(sceneCollectedGoodsId);
				}
				sceneCollectedPersonList.addAll(list);
			}
			
			//基站信息
			String baseStationInfoJson=JSON.toJSONString(materialEvidenceObj.get("baseStationInfo"));
			commonAttachmentList =JSON.parseArray(baseStationInfoJson, CommonAttachment.class);
			
			/********解析勘验情况*********/
			String sceneInvestigationJson = JSON.toJSONString(map.get("sceneInvestigation"));
			JSONObject sceneInvestigationObj=JSON.parseObject(sceneInvestigationJson);
			String sceneLostGoodsJson=JSON.toJSONString(sceneInvestigationObj.get("sceneLostGoods"));
			sceneLostGoodsList = JSON.parseArray(sceneLostGoodsJson, SceneLostGoods.class);
			String sceneOffenderJson2=JSON.toJSONString(sceneInvestigationObj.get("sceneOffender"));
			List<SceneOffender> sceneOffenderlistForJZ =JSON.parseArray(sceneOffenderJson2, SceneOffender.class);
			sceneOffenderList.addAll(sceneOffenderlistForJZ);
			SceneInvestigation sceneInvestigationRepeat = JSON.parseObject(sceneInvestigationJson,SceneInvestigation.class);
			sceneInvestigation.setTemplateId(sceneInvestigationRepeat.getTemplateId());//"现场录入模板ID"
			sceneInvestigation.setLostTotalValue(sceneInvestigationRepeat.getLostTotalValue());//"损失物品总价值",
			sceneInvestigation.setInvestNoteFlag(sceneInvestigationRepeat.getInvestNoteFlag());//"是否填写现场勘验情况(SFDM)",
			sceneInvestigation.setSceneDisposal(sceneInvestigationRepeat.getSceneDisposal());//"现场处置意见(XCCZYJDM)",
			sceneInvestigation.setSceneDisposalDesc(sceneInvestigationRepeat.getSceneDisposalDesc());//"现场处置意见描述",
			sceneInvestigation.setVideoTime(sceneInvestigationRepeat.getVideoTime());//"录像时间",
			sceneInvestigation.setRecordTime(sceneInvestigationRepeat.getRecordTime());// "录音时间",
			sceneInvestigation.setInvestNoteId(sceneInvestigationRepeat.getInvestNoteId());//文本ID
			sceneInvestigation.setWitnessRemark(sceneInvestigationRepeat.getWitnessRemark());//见证人备注
			/********大文本*********/
			if(StringUtils.isNotEmpty(sceneInvestigation.getInvestNoteId())){
				commonBigtext.setId(sceneInvestigation.getInvestNoteId());
			}
			commonBigtext.setContent(sceneInvestigationRepeat.getContent());
			
			/********分析意见*********/
			String sceneAnalysisSuggestionJson = JSON.toJSONString(map.get("sceneAnalysisSuggestion"));
			JSONObject sceneAnalysisSuggestionObj=JSON.parseObject(sceneAnalysisSuggestionJson);
			String sceneAnalysisItemJson=JSON.toJSONString(sceneAnalysisSuggestionObj.get("sceneAnalysisItem"));
			String sceneCrimeToolsJson=JSON.toJSONString(sceneAnalysisSuggestionObj.get("sceneCrimeTools"));
			sceneAnalysisSuggestion = JSON.parseObject(sceneAnalysisSuggestionJson,SceneAnalysisSuggestion.class);
			sceneAnalysisItemList = JSON.parseArray(sceneAnalysisItemJson, SceneAnalysisItem.class);
			sceneCrimeToolsList = JSON.parseArray(sceneCrimeToolsJson, SceneCrimeTools.class);
			
			/********尸体信息*********/
			String sceneBodyBasicJson = JSON.toJSONString(map.get("sceneBodyBasic"));
			sceneBodyBasicsList = JSON.parseArray(sceneBodyBasicJson, SceneBodyBasic.class);
			
			/********************数据入库操作****************************/
			//获取报文中勘验ID勘验号
			String investigationId = (String) map.get("investigationId");
			String investigationNo = (String) map.get("investigationNo");
			investigationId = insertInvestigationMessage("2",token,
					investigationId, investigationNo,
					sceneInvestigation,
					sceneInvestigationDispatch,
					commonBigtext, sceneCondition,
					sceneLostGoodsList,
					sceneOffenderList,
					scenePictureList,
					sceneMaterialEvidenceList,
					sceneCollectedGoodsList,
					sceneInvestigatorList,
					sceneAnalysisSuggestion,
					sceneAnalysisItemList,
					sceneCrimeToolsList,
					sceneBodyBasicsList,
					sceneCollectedPersonList,
					cameraInfoList,
					commonAttachmentList
					);
    		logger.info("清除redis缓存");
    		//更新图片汇总信息
			scenePicSummaryService.updateByInvestigationId(token, investigationId);
    		redisClient.del(Constants.Redis.INPUT_PREFIX+sysUser.getUsername());
		}catch (com.alibaba.fastjson.JSONException e) {
			throw new RestBusinessException(Status.NOT_ACCEPTABLE, e.getMessage()+"  错误");
		}
		return JsonResultUtil.success();
	}
    /**
     * 勘验信息入库操作
     * 方法功能说明：  公用更新勘验信息方法用于现场暂存、提交
     * 创建：2016-12-14 下午5:35:38 by guochen
     * @参数： 用户Token
     * @参数： 勘验ID
     * @参数： 勘验号
     * @return  
     * @throws
     */
	public String insertInvestigationMessage(String completeFlag,String token,
			String investigationId, String investigationNo,
			SceneInvestigation sceneInvestigation,
			SceneInvestigationDispatch sceneInvestigationDispatch,
			CommonBigtext commonBigtext, SceneCondition sceneCondition,
			List<SceneLostGoods> sceneLostGoodsList,
			List<SceneOffender> sceneOffenderList,
			List<ScenePicture> scenePictureList,
			List<SceneMaterialEvidence> sceneMaterialEvidenceList,
			List<SceneCollectedGoods> sceneCollectedGoodsList,
			List<SceneInvestigator> sceneInvestigatorList,
			SceneAnalysisSuggestion sceneAnalysisSuggestion,
			List<SceneAnalysisItem> sceneAnalysisItemList,
			List<SceneCrimeTools> sceneCrimeToolsList,
			List<SceneBodyBasic> sceneBodyBasicsList,
			List<SceneCollectedPerson> sceneCollectedPersonList,
			List<CameraInfo> cameraInfoList,
			List<CommonAttachment> commonAttachmentList
			) {
		try {
			
			SysParameter sysParameter=sysParameterService.getByKey(Constants.SysParam.FILE_SERVER_PATH);
			String fileServerPath="";
			if(sysParameter!=null){
				fileServerPath=sysParameter.getValue();
			}else{
				return null;
			}
			if(StringUtils.isEmpty(investigationId)){
				//根据勘验号计算复堪值代码
				int iterationNo=0;
				int olditerationNo = sceneInvestigationService.findMaxIterationNoByInvestigationNo(investigationNo);
				iterationNo = olditerationNo+1;
				investigationId = UUIDService.getInstance().simpleHex();
				//大文本ID
				String investNoteId = null;
				if(StringUtils.isNotEmpty(commonBigtext.getContent())){
					logger.info("大文本入库");
					investNoteId =UUIDService.getInstance().simpleHex();
		    		commonBigtext.setId(investNoteId);
		    		commonBigtext.setInvestigationId(investigationId);
		    		commonBigtextService.add(token, commonBigtext);
				}
				logger.info("勘验对象入库");
	    		sceneInvestigation.setId(investigationId);
	    		sceneInvestigation.setInvestigationNo(investigationNo);
	    		sceneInvestigation.setIterationNo(iterationNo);
	    		sceneInvestigation.setInvestNoteId(investNoteId);
	    		sceneInvestigationService.add(token, sceneInvestigation);
	    		//现场接堪 sceneInvestigationDispatch（复用勘验ID）
	    		logger.info("现场接堪入库");
	    		sceneInvestigationDispatch.setInvestigationId(investigationId);
	    		sceneInvestigationDispatchService.add(token, sceneInvestigationDispatch);
	    		
	    		logger.info("现场条件入库");
	    		sceneCondition.setInvestigationId(investigationId);
	    		sceneConditionService.add(token, sceneCondition);
	    		//现场损失物品信息 sceneLostGoods集合 （复用勘验ID）
	    		logger.info("现场损失物品入库");
	    		if(sceneLostGoodsList!=null&&sceneLostGoodsList.size()>0){
	    			for(SceneLostGoods obj:sceneLostGoodsList){
	    				obj.setInvestigationId(investigationId);
	    			}
	    			sceneLostGoodsService.addBatch(token, sceneLostGoodsList);
	    		}
	    		logger.info("现场涉案人员入库");
	    		if (sceneOffenderList != null && sceneOffenderList.size() > 0) {
	    			for (SceneOffender obj : sceneOffenderList) {
	    				obj.setInvestigationId(investigationId);
	    			}
	    			sceneOffenderService.addBatch(token, sceneOffenderList);
	    		}
	    		logger.info("现场图、现场照片入库");
	    		if (scenePictureList != null && scenePictureList.size() > 0) {
	    			for (ScenePicture obj : scenePictureList) {
	    				obj.setInvestigationId(investigationId);
	    			}
	    			scenePictureService.addBatch(token, scenePictureList);
	    		}
	    		logger.info("现场痕迹入库");
	    		if (sceneMaterialEvidenceList != null && sceneMaterialEvidenceList.size() > 0) {
	    			for (SceneMaterialEvidence obj : sceneMaterialEvidenceList) {
	    				String no = sysSequenceService.getNextSerialNo(Constants.SerialNo.SCENEMATERIALEVIDENCE_NO, token);
	    				obj.setMaterialEvidenceNo(no);
	    				obj.setInvestigationId(investigationId);
	    			}
	    			sceneMaterialEvidenceService.addBatch(token, sceneMaterialEvidenceList);
	    		}
	    		logger.info("提取物品入库");
	    		if (sceneCollectedGoodsList != null && sceneCollectedGoodsList.size() > 0) {
	    			for (SceneCollectedGoods obj : sceneCollectedGoodsList) {
	    				String no = sysSequenceService.getNextSerialNo(Constants.SerialNo.SCENECOLLECTEDGOODS_NO, token);
	    				obj.setSerialNo(no);
	    				obj.setInvestigationId(investigationId);
	    			}
	    			sceneCollectedGoodsService.addBatch(token, sceneCollectedGoodsList);
	    		}
	    		logger.info("提取人入库");
	    		if (sceneCollectedPersonList != null && sceneCollectedPersonList.size() > 0) {
	    			for (SceneCollectedPerson obj : sceneCollectedPersonList) {
	    				obj.setInvestigationId(investigationId);
	    			}
	    			sceneCollectedPersonService.addBatch(token, sceneCollectedPersonList);
	    		}
	    		
	    		
	    		logger.info("勘验人入库");
	    		if (sceneInvestigatorList != null && sceneInvestigatorList.size() > 0) {
	    			for (SceneInvestigator obj : sceneInvestigatorList) {
	    				obj.setInvestigationId(investigationId);
	    			}
	    			sceneInvestigatorService.addBatch(token, sceneInvestigatorList);
	    		}
	    		logger.info("分析意见入库");
	    		String analysisId = UUIDService.getInstance().simpleHex();
	    		sceneAnalysisSuggestion.setId(analysisId);
	    		sceneAnalysisSuggestion.setInvestigationId(investigationId);
	    		sceneAnalysisSuggestionService.add(token, sceneAnalysisSuggestion);
	    		logger.info("分析意见项目入库");
	    		if (sceneAnalysisItemList != null && sceneAnalysisItemList.size() > 0) {
	    			for (SceneAnalysisItem obj : sceneAnalysisItemList) {
	    				obj.setInvestigationId(investigationId);
	    				obj.setAnalysisId(analysisId);
	    			}
	    			sceneAnalysisItemService.addBatch(token, sceneAnalysisItemList);
	    		}
	    		
	    		//作案工具  （复用勘验ID和分析意见ID）
	    		logger.info("作案工具 入库");
	    		if (sceneCrimeToolsList != null && sceneCrimeToolsList.size() > 0) {
	    			for (SceneCrimeTools obj : sceneCrimeToolsList) {
	    				obj.setInvestigationId(investigationId);
	    				obj.setAnalysisId(analysisId);
	    			}
	    			sceneCrimeToolsService.addBatch(token, sceneCrimeToolsList);
	    		}
	    		logger.info("尸体信息入库");
	    		if (sceneBodyBasicsList != null && sceneBodyBasicsList.size() > 0) {
	    			for (SceneBodyBasic obj : sceneBodyBasicsList) {
	    				String examinationNo = sysSequenceService.getNextSerialNo(Constants.SerialNo.SCENEBODYBASIC_NO, token);
	        			obj.setExaminationNo(examinationNo);
	    				obj.setInvestigationId(investigationId);
	    			}
	    			sceneBodyBasicService.addBatch(token, sceneBodyBasicsList);
	    		}
	    		
	    		logger.info("摄像头信息入库");
	    		if (cameraInfoList != null && cameraInfoList.size() > 0) {
	    			for (CameraInfo obj : cameraInfoList) {
	    				obj.setInvestigationId(investigationId);
	    			}
	    			cameraInfoService.addBatch(token, cameraInfoList);
	    		}
	    		logger.info("基站wifi信息入库");
	    		if (commonAttachmentList != null && commonAttachmentList.size() > 0) {
	    			for (CommonAttachment commonAttachment : commonAttachmentList) {
	    				String id=this.generateUUID();
	    				commonAttachment.setId(id);
	    				commonAttachment.setFileServerAddr(fileServerPath);
	    				commonAttachment.setInvestigationId(investigationId);
	    				List<BasestationInfo> stationList=getByPath(commonAttachment);
	    				basestationInfoService.addBatch(token, stationList);
	    			}
	    			commonAttachmentService.addBatch(token, commonAttachmentList);
	    			//更新是否采集基站状态
	    			SceneInvestigation sceneInvestigation1=new SceneInvestigation();
	    			sceneInvestigation1.setId(investigationId);
	    			sceneInvestigation1.setBsCollectFlag("1");
	    			sceneInvestigationService.updateById(token, sceneInvestigation1);
	    		}
	    		
	    		
			}else{
				//大文本ID
				String investNoteId =null;
        		if(StringUtils.isNotEmpty(sceneInvestigation.getInvestNoteId())){
        			logger.info("提交大文本数据");
        			commonBigtext.setId(sceneInvestigation.getInvestNoteId());
        			commonBigtextService.updateById(token, commonBigtext);
        		}else{
        			logger.info("提交大文本数据");
					investNoteId =UUIDService.getInstance().simpleHex();
		    		commonBigtext.setId(investNoteId);
		    		commonBigtext.setInvestigationId(investigationId);
		    		commonBigtextService.add(token, commonBigtext);
        			commonBigtextService.add(token, commonBigtext);
        			//勘验信息赋值文本ID
        			sceneInvestigation.setInvestNoteId(investNoteId);
        		}
				logger.info("提交堪验数据");
    			sceneInvestigationService.updateById(token, sceneInvestigation);
    			logger.info("提交现场接堪数据");
        		sceneInvestigationDispatch.setInvestigationId(investigationId);
        		if(StringUtils.isNotEmpty(sceneInvestigationDispatch.getId())){
        			sceneInvestigationDispatchService.updateById(token, sceneInvestigationDispatch);
        		}else{
            		sceneInvestigationDispatchService.add(token, sceneInvestigationDispatch);
        		}
        		logger.info("提交现场条件");
        		sceneCondition.setInvestigationId(investigationId);
        		if(StringUtils.isNotEmpty(sceneCondition.getId())){
        			sceneConditionService.updateById(token, sceneCondition);
        		}else{
        			sceneConditionService.add(token, sceneCondition);
        		}
        		logger.info("提交现场损失物品");
        		if(sceneLostGoodsList!=null&&sceneLostGoodsList.size()>0){
        			for(SceneLostGoods obj:sceneLostGoodsList){
        				obj.setInvestigationId(investigationId);
        				if(StringUtils.isNotEmpty(obj.getId())){
        					sceneLostGoodsService.updateById(token, obj);
                		}else{
                			sceneLostGoodsService.add(token, obj);
                		}
        			}
        		}
        		logger.info("提交现场涉案人员");
        		if (sceneOffenderList != null && sceneOffenderList.size() > 0) {
        			for (SceneOffender obj : sceneOffenderList) {
        				obj.setInvestigationId(investigationId);
        				if(StringUtils.isNotEmpty(obj.getId())){
        					sceneOffenderService.updateById(token, obj);
                		}else{
                			sceneOffenderService.add(token, obj);
                		}
        			}
        		}
        		
        		//现场图、现场照片信息 scenePicture集合 （复用勘验ID）
        		logger.info("提交现场图、现场照片");
        		if (scenePictureList != null && scenePictureList.size() > 0) {
        			for (ScenePicture obj : scenePictureList) {
        				obj.setInvestigationId(investigationId);
        				if(StringUtils.isNotEmpty(obj.getId())){
        					scenePictureService.updateById(token, obj);
                		}else{
                			scenePictureService.add(token, obj);
                		}
        			}
        		}
        		//现场痕迹物证信息 sceneMaterialEvidence集合 （复用勘验ID）
        		logger.info("提交现场痕迹");
        		if (sceneMaterialEvidenceList != null && sceneMaterialEvidenceList.size() > 0) {
        			for (SceneMaterialEvidence obj : sceneMaterialEvidenceList) {
        				obj.setInvestigationId(investigationId);
        			    sceneMaterialEvidenceService.updateByObj(token, obj);
        			}
        		}
        		logger.info("提取物品入库");
        		if (sceneCollectedGoodsList != null && sceneCollectedGoodsList.size() > 0) {
        			for (SceneCollectedGoods obj : sceneCollectedGoodsList) {
        				obj.setInvestigationId(investigationId);
        				sceneCollectedGoodsService.updateByObj(token, obj);
        			}
        		}
        		logger.info("提取人入库");
        		if (sceneCollectedPersonList != null && sceneCollectedPersonList.size() > 0) {
	    			for (SceneCollectedPerson obj : sceneCollectedPersonList) {
	    				obj.setInvestigationId(investigationId);
	    				if(StringUtils.isNotEmpty(obj.getId())){
	    					sceneCollectedPersonService.updateById(token, obj);
                		}else{
                			sceneCollectedPersonService.add(token, obj);
                		}
	    			}
	    		}
        		
        		logger.info("提交勘验人入库");
        		if (sceneInvestigatorList != null && sceneInvestigatorList.size() > 0) {
        			for (SceneInvestigator obj : sceneInvestigatorList) {
        				obj.setInvestigationId(investigationId);
        			}
        			sceneInvestigatorService.addBatch(token, sceneInvestigatorList);
        		}
        		//现场分析意见 （复用勘验ID）
        		logger.info("分析意见入库");
        		String analysisId = null;
        		sceneAnalysisSuggestion.setInvestigationId(investigationId);
        		if(StringUtils.isNotEmpty(sceneAnalysisSuggestion.getId())){
        			analysisId = sceneAnalysisSuggestion.getId();
        			sceneAnalysisSuggestionService.updateById(token, sceneAnalysisSuggestion);
        		}else{
        			analysisId = UUIDService.getInstance().simpleHex();
        			sceneAnalysisSuggestion.setId(analysisId);
        			sceneAnalysisSuggestionService.add(token, sceneAnalysisSuggestion);
        		}
        		//分析意见项目  （复用勘验ID和分析意见ID）
        		logger.info("分析意见项目入库");
        		if (sceneAnalysisItemList != null && sceneAnalysisItemList.size() > 0) {
        			for (SceneAnalysisItem obj : sceneAnalysisItemList) {
        				obj.setInvestigationId(investigationId);
        				obj.setAnalysisId(analysisId);
        				if(StringUtils.isNotEmpty(obj.getId())){
        					sceneAnalysisItemService.updateById(token, obj);
                		}else{
                			sceneAnalysisItemService.add(token, obj);
                		}
        			}
        		}
        		logger.info("作案工具 入库");
        		if (sceneCrimeToolsList != null && sceneCrimeToolsList.size() > 0) {
        			for (SceneCrimeTools obj : sceneCrimeToolsList) {
        				obj.setInvestigationId(investigationId);
        				obj.setAnalysisId(analysisId);
        				if(StringUtils.isNotEmpty(obj.getId())){
        					sceneCrimeToolsService.updateById(token, obj);
                		}else{
                			sceneCrimeToolsService.add(token, obj);
                		}
        			}
        		}
        		
        		logger.info("尸体信息入库");
        		if (sceneBodyBasicsList != null && sceneBodyBasicsList.size() > 0) {
        			for (SceneBodyBasic obj : sceneBodyBasicsList) {
        				obj.setInvestigationId(investigationId);
        				if(StringUtils.isNotEmpty(obj.getId())){
        					sceneBodyBasicService.updateById(token, obj);
                		}else{
                			String examinationNo = sysSequenceService.getNextSerialNo(Constants.SerialNo.SCENEBODYBASIC_NO, token);
                			obj.setExaminationNo(examinationNo);
                			sceneBodyBasicService.add(token, obj);
                		}
        			}
        		}
        		
        		logger.info("摄像头信息入库");
	    		if (cameraInfoList != null && cameraInfoList.size() > 0) {
	    			for (CameraInfo obj : cameraInfoList) {
        				obj.setInvestigationId(investigationId);
        				if(StringUtils.isNotEmpty(obj.getId())){
        					cameraInfoService.updateById(token, obj);
                		}else{
                			cameraInfoService.add(token, obj);
                		}
        			}
	    			
	    		}
	    		
	    		logger.info("基站wifi信息入库");
	    		if (commonAttachmentList != null && commonAttachmentList.size() > 0) {
	    			for (CommonAttachment commonAttachment : commonAttachmentList) {
	    				commonAttachment.setInvestigationId(investigationId);
	    				if(StringUtils.isNotEmpty(commonAttachment.getId())){
	    					commonAttachmentService.updateById(token, commonAttachment);
	    					//由于没有传基站信息id，所以要删除所有的基站信息
	    					basestationInfoService.deleteAllLogicById(token, investigationId);
	    				}else{
		    				String id=this.generateUUID();
		    				commonAttachment.setId(id);
		    				commonAttachment.setFileServerAddr(fileServerPath);
		    				commonAttachment.setInvestigationId(investigationId);
	    				}
	    				List<BasestationInfo> stationList=getByPath(commonAttachment);
	    				basestationInfoService.addBatch(token, stationList);
	    				commonAttachmentService.add(token, commonAttachment);
	    			}
	    			//更新是否采集基站状态
	    			SceneInvestigation sceneInvestigation1=new SceneInvestigation();
	    			sceneInvestigation1.setId(investigationId);
	    			sceneInvestigation1.setBsCollectFlag("1");
	    			sceneInvestigationService.updateById(token, sceneInvestigation1);
	    		}
	    		
			}
			
			//现勘保存或提交状态
    		SceneInvestigationStatus sceneInvestigationStatus=new SceneInvestigationStatus();
    		if(completeFlag!=null&&!"".equals(completeFlag)){
    			if("0".equals(completeFlag)){
    				//保存不合格
    				sceneInvestigationStatus.setSaveFlag("0");
    				sceneInvestigationStatus.setQualityFlag("0");
    			}else if("1".equals(completeFlag)){
    				//保存合格
    				sceneInvestigationStatus.setSaveFlag("0");
    				sceneInvestigationStatus.setQualityFlag("1");
    			}else if("2".equals(completeFlag)){
    				//提交合格
    				sceneInvestigationStatus.setSaveFlag("1");
    				sceneInvestigationStatus.setQualityFlag("1");
    			}
    			sceneInvestigationStatus.setInvestigationId(investigationId);
    			sceneInvestigationStatusService.addOrupdate(token, sceneInvestigationStatus);
    		}
		} catch (com.alibaba.fastjson.JSONException e) {
			throw new RestBusinessException(Status.NOT_ACCEPTABLE,e.getMessage() + "  错误");
		}
		return investigationId;
	}
   
    /**
     * 获取当前登录用户
     * 方法功能说明：  
     * 创建：2016-12-13 上午9:29:41 by guochen
     * @参数： 
     * @参数：    
     * @return  
     * @throws
     */
    public SysUser getCurrentUser(String token) {
		SysUser sysUser=redisClient.getObj(token, SysUser.class);
		if(sysUser!=null){
			return sysUser;
		}else{
			return null;
		}
	}
    
    @SuppressWarnings("unchecked")
	public List<BasestationInfo> getByPath(CommonAttachment commonAttachment){
    	List<BasestationInfo> list=new ArrayList<BasestationInfo>();
    	try {
    		InputStream is=HttpFileUtil.downloadFileStream(commonAttachment.getFileServerAddr()+commonAttachment.getFileServerPath());
    		SAXReader reader = new SAXReader();    
	        Document doc = reader.read(is);  
	        Element root = doc.getRootElement();
	        Element bs=root.element("BS");
	        List<Element> bsList=bs.elements();
	        for(Element parentEle:bsList){
	            List<Element> listElement=parentEle.elements();
	            String nodeName=parentEle.getName();
	            for(Element baseStation:listElement){
	            	String ifActive=baseStation.getName();
	            	XmlMapper xmlMapper = new XmlMapper();
	            	BasestationInfo basestationInfo=xmlMapper.readValue(baseStation.asXML(), BasestationInfo.class);
	            	Element gps=baseStation.element("GPS");
	            	if(gps!=null){
	            		basestationInfo.setLat(gps.elementText("LAT"));
	            		basestationInfo.setLon(gps.elementText("LON"));
	            	}
	            	basestationInfo.setBsType(nodeName);
	            	basestationInfo.setInvestigationId(commonAttachment.getInvestigationId());
	            	basestationInfo.setIfactive(ifActive);
	            	basestationInfo.setAttachmentId(commonAttachment.getId());
	            	list.add(basestationInfo);
	            }
	        }
		} catch (Exception e) {
			
		}
    	return list;
    }
    
    
	public String generateUUID() {
		return UUIDService.getInstance().simpleHex();
	}

}
