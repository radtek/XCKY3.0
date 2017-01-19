package com.hisign.xcky.api.model.template;

import java.util.List;

/**
 * 现场勘验笔录基础信息word 项目名称：xcky-api 类名称：sceneInvestigationNoteWord 类描述： 创建人：郭辰
 * 创建时间：2016-12-20 下午3:16:13 修改人：hisign 修改时间：2016-12-20 下午3:16:13 修改备注：
 * 
 * @version
 */
public class SceneInvestigationNoteWord {

	// 勘验号
	private String noteNo;

	// 现场勘验单位
	private String madeByOrgName;

	// 指派/报告单位
	private String assignedBy;

	// 接警时间
	private String receivedDate;
	
	// 接警时间年
	private String receivedDateYYYY;
	
	// 接警时间月
	private String receivedDateMM;
	
	// 接警时间日
	private String receivedDateDD;
	
	// 接警时间时
	private String receivedDateHH;
	
	// 接警时间分
	private String receivedDateMI;
	
	// 勘验事由
	private String assignedContent;

	// 勘验开始时间
	private String investigationDateFrom;

	// 勘验开始时间 年
	private String investigationDateFromYYYY;

	// 勘验开始时间 月
	private String investigationDateFromMM;

	// 勘验开始时间 日
	private String investigationDateFromDD;

	// 勘验开始时间 时
	private String investigationDateFromHH;

	// 勘验开始时间 分
	private String investigationDateFromMI;

	// 勘验结束时间
	private String investigationDateTo;

	// 勘验结束时间
	private String investigationDateToYYYY;

	// 勘验结束时间
	private String investigationDateToMM;

	// 勘验结束时间
	private String investigationDateToDD;

	// 勘验结束时间
	private String investigationDateToHH;

	// 勘验结束时间
	private String investigationDateToMI;

	// 勘验地点
	private String investigationPlace;

	// 保护人单位
	private String proUnit = null;

	// 保护人姓名
	private String proName = null;

	// 保护人职务
	private String proJob = null;

	// 现场保护措施勾选
	private List protect = null;

	// 现场保护措施描述
	private String protectionDesc;

	// 现场条件
	private String sceneCondition;

	// 变动原因
	private List<Bdyy> BDYYList;

	// 天气情况list
	private List weatherList;

	// 天气情况：温度
	private String envTemperature;
	
	// 天气情况：相对湿度
	private String envMoistness;
	
	// 天气情况：风向
	private String wind;

	// 光照条件List
	private List wordLighting;

	// 现场指挥人员
	private List directors;

	// 现场勘验情况
	private String temp = null;
	
	// 勘验检查情况 每一段为List的一项
	private List investigationDescList;
	/**
	 *验证investigationDescList是否为空字段，若为空勘验检查情况为两行空格
	 */
	private String ifinvestigationDescListIsNull="0";

	// 现场图总数
	private String scenePictureAmount;

	// 现场照片总数
	private String scenePhotoAmount;

	// 录像时间
	private String videoTime;

	// 录音时间
	private String recordTime;

	// 笔录人
	private String writer;

	// 制图人
	private String drafter;

	// 照相人
	private String camerist;

	// 录像人
	private String videoer;

	// 录音人
	private String recordist;

	// 勘验检查人员列表
	private List investigatorList;

	// 见证人列表
	private List witnessList;

	// 备注内容
	private String remark;

	// 制作时间
	private String rightNowTime;

	// 现场物证表列表
	private List tableList;
	/**
	 * 物证列表补充集合
	 */
	private List addTableList;

	// 现场图List
	private List scenePictureList;

	// 现场图补充行数
	private String iSscenePictureInfoAddRow = "0";
	
	private String iSscenePictureInfo="0";

	// 卷宗照片
	private List juanZongPictureList;

	// 现场照片补充行数
	private String iSjuanZongPictureAddRow = "0";
	private String iSjuanZongPicture = "0";
	

	public String getiSscenePictureInfo() {
		return iSscenePictureInfo;
	}

	public void setiSscenePictureInfo(String iSscenePictureInfo) {
		this.iSscenePictureInfo = iSscenePictureInfo;
	}

	public String getiSjuanZongPicture() {
		return iSjuanZongPicture;
	}

	public void setiSjuanZongPicture(String iSjuanZongPicture) {
		this.iSjuanZongPicture = iSjuanZongPicture;
	}

	// 现场分析所依据的资料
	private String meterialsReliedOn;

	// 侵害目标
	private String intentionDesc;

	// 作案地点
	private String commissionPlace;

	// 作案时段
	private String periodDesc;
	// 作案出入口
	private String entranceDesc;
	
	// 作案手段
	private String commissionMeansDesp;

	// 侵入方式
	private String intrudingWayDesc;

	// 作案工具
	private String toolsDescription;

	// 作案动机及目的
	private String motiveDesc;

	// 案件性质
	private String casePropertyDesc;

	// 作案人数
	private String criminalAmountDesc;

	// 作案过程
	private String commissionDesc;

	// 作案人特点
	private String criminalPoints;

	// 并案意见与根据
	private String bunchReason;

	// 工作建议
	private String suggestion;

	// 现场分析人
	private String analysedBy;

	public String getNoteNo() {
		return noteNo;
	}

	public void setNoteNo(String noteNo) {
		this.noteNo = noteNo;
	}

	public String getMadeByOrgName() {
		return madeByOrgName;
	}

	public void setMadeByOrgName(String madeByOrgName) {
		this.madeByOrgName = madeByOrgName;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	public String getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getReceivedDateYYYY() {
		return receivedDateYYYY;
	}

	public void setReceivedDateYYYY(String receivedDateYYYY) {
		this.receivedDateYYYY = receivedDateYYYY;
	}

	public String getReceivedDateMM() {
		return receivedDateMM;
	}

	public void setReceivedDateMM(String receivedDateMM) {
		this.receivedDateMM = receivedDateMM;
	}

	public String getReceivedDateDD() {
		return receivedDateDD;
	}

	public void setReceivedDateDD(String receivedDateDD) {
		this.receivedDateDD = receivedDateDD;
	}

	public String getReceivedDateHH() {
		return receivedDateHH;
	}

	public void setReceivedDateHH(String receivedDateHH) {
		this.receivedDateHH = receivedDateHH;
	}

	public String getReceivedDateMI() {
		return receivedDateMI;
	}

	public void setReceivedDateMI(String receivedDateMI) {
		this.receivedDateMI = receivedDateMI;
	}

	public String getAssignedContent() {
		return assignedContent;
	}

	public void setAssignedContent(String assignedContent) {
		this.assignedContent = assignedContent;
	}

	public String getInvestigationDateFrom() {
		return investigationDateFrom;
	}

	public void setInvestigationDateFrom(String investigationDateFrom) {
		this.investigationDateFrom = investigationDateFrom;
	}

	public String getInvestigationDateFromYYYY() {
		return investigationDateFromYYYY;
	}

	public void setInvestigationDateFromYYYY(String investigationDateFromYYYY) {
		this.investigationDateFromYYYY = investigationDateFromYYYY;
	}

	public String getInvestigationDateFromMM() {
		return investigationDateFromMM;
	}

	public void setInvestigationDateFromMM(String investigationDateFromMM) {
		this.investigationDateFromMM = investigationDateFromMM;
	}

	public String getInvestigationDateFromDD() {
		return investigationDateFromDD;
	}

	public void setInvestigationDateFromDD(String investigationDateFromDD) {
		this.investigationDateFromDD = investigationDateFromDD;
	}

	public String getInvestigationDateFromHH() {
		return investigationDateFromHH;
	}

	public void setInvestigationDateFromHH(String investigationDateFromHH) {
		this.investigationDateFromHH = investigationDateFromHH;
	}

	public String getInvestigationDateFromMI() {
		return investigationDateFromMI;
	}

	public void setInvestigationDateFromMI(String investigationDateFromMI) {
		this.investigationDateFromMI = investigationDateFromMI;
	}

	public String getInvestigationDateTo() {
		return investigationDateTo;
	}

	public void setInvestigationDateTo(String investigationDateTo) {
		this.investigationDateTo = investigationDateTo;
	}

	public String getInvestigationDateToYYYY() {
		return investigationDateToYYYY;
	}

	public void setInvestigationDateToYYYY(String investigationDateToYYYY) {
		this.investigationDateToYYYY = investigationDateToYYYY;
	}

	public String getInvestigationDateToMM() {
		return investigationDateToMM;
	}

	public void setInvestigationDateToMM(String investigationDateToMM) {
		this.investigationDateToMM = investigationDateToMM;
	}

	public String getInvestigationDateToDD() {
		return investigationDateToDD;
	}

	public void setInvestigationDateToDD(String investigationDateToDD) {
		this.investigationDateToDD = investigationDateToDD;
	}

	public String getInvestigationDateToHH() {
		return investigationDateToHH;
	}

	public void setInvestigationDateToHH(String investigationDateToHH) {
		this.investigationDateToHH = investigationDateToHH;
	}

	public String getInvestigationDateToMI() {
		return investigationDateToMI;
	}

	public void setInvestigationDateToMI(String investigationDateToMI) {
		this.investigationDateToMI = investigationDateToMI;
	}

	public String getInvestigationPlace() {
		return investigationPlace;
	}

	public void setInvestigationPlace(String investigationPlace) {
		this.investigationPlace = investigationPlace;
	}

	public String getProUnit() {
		return proUnit;
	}

	public void setProUnit(String proUnit) {
		this.proUnit = proUnit;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProJob() {
		return proJob;
	}

	public void setProJob(String proJob) {
		this.proJob = proJob;
	}

	public List getProtect() {
		return protect;
	}

	public void setProtect(List protect) {
		this.protect = protect;
	}

	public String getProtectionDesc() {
		return protectionDesc;
	}

	public void setProtectionDesc(String protectionDesc) {
		this.protectionDesc = protectionDesc;
	}

	public String getSceneCondition() {
		return sceneCondition;
	}

	public void setSceneCondition(String sceneCondition) {
		this.sceneCondition = sceneCondition;
	}

	public List<Bdyy> getBDYYList() {
		return BDYYList;
	}

	public void setBDYYList(List<Bdyy> bDYYList) {
		BDYYList = bDYYList;
	}

	public List getWeatherList() {
		return weatherList;
	}

	public void setWeatherList(List weatherList) {
		this.weatherList = weatherList;
	}

	public String getEnvTemperature() {
		return envTemperature;
	}

	public void setEnvTemperature(String envTemperature) {
		this.envTemperature = envTemperature;
	}

	public List getWordLighting() {
		return wordLighting;
	}

	public void setWordLighting(List wordLighting) {
		this.wordLighting = wordLighting;
	}

	public List getDirectors() {
		return directors;
	}

	public void setDirectors(List directors) {
		this.directors = directors;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getScenePictureAmount() {
		return scenePictureAmount;
	}

	public void setScenePictureAmount(String scenePictureAmount) {
		this.scenePictureAmount = scenePictureAmount;
	}

	public String getScenePhotoAmount() {
		return scenePhotoAmount;
	}

	public void setScenePhotoAmount(String scenePhotoAmount) {
		this.scenePhotoAmount = scenePhotoAmount;
	}

	public String getVideoTime() {
		return videoTime;
	}

	public void setVideoTime(String videoTime) {
		this.videoTime = videoTime;
	}

	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getDrafter() {
		return drafter;
	}

	public void setDrafter(String drafter) {
		this.drafter = drafter;
	}

	public String getCamerist() {
		return camerist;
	}

	public void setCamerist(String camerist) {
		this.camerist = camerist;
	}

	public String getVideoer() {
		return videoer;
	}

	public void setVideoer(String videoer) {
		this.videoer = videoer;
	}

	public String getRecordist() {
		return recordist;
	}

	public void setRecordist(String recordist) {
		this.recordist = recordist;
	}

	public List getInvestigatorList() {
		return investigatorList;
	}

	public void setInvestigatorList(List investigatorList) {
		this.investigatorList = investigatorList;
	}

	public List getWitnessList() {
		return witnessList;
	}

	public void setWitnessList(List witnessList) {
		this.witnessList = witnessList;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRightNowTime() {
		return rightNowTime;
	}

	public void setRightNowTime(String rightNowTime) {
		this.rightNowTime = rightNowTime;
	}

	public List getTableList() {
		return tableList;
	}

	public void setTableList(List tableList) {
		this.tableList = tableList;
	}

	public List getScenePictureList() {
		return scenePictureList;
	}

	public void setScenePictureList(List scenePictureList) {
		this.scenePictureList = scenePictureList;
	}

	public String getiSscenePictureInfoAddRow() {
		return iSscenePictureInfoAddRow;
	}

	public void setiSscenePictureInfoAddRow(String iSscenePictureInfoAddRow) {
		this.iSscenePictureInfoAddRow = iSscenePictureInfoAddRow;
	}

	public List getJuanZongPictureList() {
		return juanZongPictureList;
	}

	public void setJuanZongPictureList(List juanZongPictureList) {
		this.juanZongPictureList = juanZongPictureList;
	}

	public String getiSjuanZongPictureAddRow() {
		return iSjuanZongPictureAddRow;
	}

	public void setiSjuanZongPictureAddRow(String iSjuanZongPictureAddRow) {
		this.iSjuanZongPictureAddRow = iSjuanZongPictureAddRow;
	}

	public String getMeterialsReliedOn() {
		return meterialsReliedOn;
	}

	public void setMeterialsReliedOn(String meterialsReliedOn) {
		this.meterialsReliedOn = meterialsReliedOn;
	}

	public String getIntentionDesc() {
		return intentionDesc;
	}

	public void setIntentionDesc(String intentionDesc) {
		this.intentionDesc = intentionDesc;
	}

	public String getCommissionPlace() {
		return commissionPlace;
	}

	public void setCommissionPlace(String commissionPlace) {
		this.commissionPlace = commissionPlace;
	}

	public String getPeriodDesc() {
		return periodDesc;
	}

	public void setPeriodDesc(String periodDesc) {
		this.periodDesc = periodDesc;
	}

	public String getEntranceDesc() {
		return entranceDesc;
	}

	public void setEntranceDesc(String entranceDesc) {
		this.entranceDesc = entranceDesc;
	}

	public String getCommissionMeansDesp() {
		return commissionMeansDesp;
	}

	public void setCommissionMeansDesp(String commissionMeansDesp) {
		this.commissionMeansDesp = commissionMeansDesp;
	}

	public String getIntrudingWayDesc() {
		return intrudingWayDesc;
	}

	public void setIntrudingWayDesc(String intrudingWayDesc) {
		this.intrudingWayDesc = intrudingWayDesc;
	}

	public String getToolsDescription() {
		return toolsDescription;
	}

	public void setToolsDescription(String toolsDescription) {
		this.toolsDescription = toolsDescription;
	}

	public String getMotiveDesc() {
		return motiveDesc;
	}

	public void setMotiveDesc(String motiveDesc) {
		this.motiveDesc = motiveDesc;
	}

	public String getCasePropertyDesc() {
		return casePropertyDesc;
	}

	public void setCasePropertyDesc(String casePropertyDesc) {
		this.casePropertyDesc = casePropertyDesc;
	}

	public String getCriminalAmountDesc() {
		return criminalAmountDesc;
	}

	public void setCriminalAmountDesc(String criminalAmountDesc) {
		this.criminalAmountDesc = criminalAmountDesc;
	}

	public String getCommissionDesc() {
		return commissionDesc;
	}

	public void setCommissionDesc(String commissionDesc) {
		this.commissionDesc = commissionDesc;
	}

	public String getCriminalPoints() {
		return criminalPoints;
	}

	public void setCriminalPoints(String criminalPoints) {
		this.criminalPoints = criminalPoints;
	}

	public String getBunchReason() {
		return bunchReason;
	}

	public void setBunchReason(String bunchReason) {
		this.bunchReason = bunchReason;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getAnalysedBy() {
		return analysedBy;
	}

	public void setAnalysedBy(String analysedBy) {
		this.analysedBy = analysedBy;
	}

	public String getEnvMoistness() {
		return envMoistness;
	}

	public void setEnvMoistness(String envMoistness) {
		this.envMoistness = envMoistness;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}

	public List getInvestigationDescList() {
		return investigationDescList;
	}

	public void setInvestigationDescList(List investigationDescList) {
		this.investigationDescList = investigationDescList;
	}

	public String getIfinvestigationDescListIsNull() {
		return ifinvestigationDescListIsNull;
	}

	public void setIfinvestigationDescListIsNull(
			String ifinvestigationDescListIsNull) {
		this.ifinvestigationDescListIsNull = ifinvestigationDescListIsNull;
	}

	public List getAddTableList() {
		return addTableList;
	}

	public void setAddTableList(List addTableList) {
		this.addTableList = addTableList;
	}
	
	
}
