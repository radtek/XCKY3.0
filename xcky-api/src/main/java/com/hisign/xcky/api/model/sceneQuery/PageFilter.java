package com.hisign.xcky.api.model.sceneQuery;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 现场查询列表Filter 项目名称：xcky-api 类名称：SceneInvestigationFilter 类描述： 创建人：郭辰
 * 创建时间：2017-1-4 下午4:32:46 修改人：hisign 修改时间：2017-1-4 下午4:32:46 修改备注：
 * 
 * @version
 */
public class PageFilter extends BaseModel {
	//勘验ID
	private String investigationId;
	// 现场范围
	private String sceneArea = null;
	// 现场状态
	private String sceneStatus = null;
	// 是否关联
	private String relateFlag = null;
	// 案件编号
	private String caseNo = null;
	// 警情编号
	private String alarmNo = null;
	// 是否制作笔录
	private String noteMadeFlag = null;
	// 是否已采基站
	private String bsCollectFlag = null;
	// 案件类别
	private String caseType = null;
	// 发案区划
	private String caseRegionalism = null;
	// 勘验号
	private String investigationNo = null;
	// 勘验地点
	private String investigationPlace = null;
	// 勘验开始时间
	@JSONField(format = "yyyy-MM-dd HH:mm")
	private java.util.Date investigationDateFrom;
	// 勘验结束时间
	@JSONField(format = "yyyy-MM-dd HH:mm")
	private java.util.Date investigationDateTo;
	// 发案开始时间
	@JSONField(format = "yyyy-MM-dd HH:mm")
	private java.util.Date crimeTimeBegin;
	// 发案结束时间
	@JSONField(format = "yyyy-MM-dd HH:mm")
	private java.util.Date crimeTimeEnd;
	// 专业系统状态反馈(ZYXTZTFKDM)
	private String storageStatus;
	// 是否提交专业系统(SFDM)
	private String storageFlag;
	//提取人ID
	private String collectedPersonId;
	//勘验人ID
	private String investigatorId;

	public String getCollectedPersonId() {
		return collectedPersonId;
	}
	public void setCollectedPersonId(String collectedPersonId) {
		this.collectedPersonId = collectedPersonId;
	}
	public String getInvestigatorId() {
		return investigatorId;
	}
	public void setInvestigatorId(String investigatorId) {
		this.investigatorId = investigatorId;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getCaseRegionalism() {
		return caseRegionalism;
	}
	public void setCaseRegionalism(String caseRegionalism) {
		this.caseRegionalism = caseRegionalism;
	}
	public String getInvestigationNo() {
		return investigationNo;
	}
	public void setInvestigationNo(String investigationNo) {
		this.investigationNo = investigationNo;
	}

	public String getInvestigationPlace() {
		return investigationPlace;
	}

	public void setInvestigationPlace(String investigationPlace) {
		this.investigationPlace = investigationPlace;
	}

	public java.util.Date getInvestigationDateFrom() {
		return investigationDateFrom;
	}

	public void setInvestigationDateFrom(java.util.Date investigationDateFrom) {
		this.investigationDateFrom = investigationDateFrom;
	}

	public java.util.Date getInvestigationDateTo() {
		return investigationDateTo;
	}

	public void setInvestigationDateTo(java.util.Date investigationDateTo) {
		this.investigationDateTo = investigationDateTo;
	}

	public java.util.Date getCrimeTimeBegin() {
		return crimeTimeBegin;
	}

	public void setCrimeTimeBegin(java.util.Date crimeTimeBegin) {
		this.crimeTimeBegin = crimeTimeBegin;
	}

	public java.util.Date getCrimeTimeEnd() {
		return crimeTimeEnd;
	}

	public void setCrimeTimeEnd(java.util.Date crimeTimeEnd) {
		this.crimeTimeEnd = crimeTimeEnd;
	}

	public String getStorageStatus() {
		return storageStatus;
	}

	public void setStorageStatus(String storageStatus) {
		this.storageStatus = storageStatus;
	}

	public String getSceneArea() {
		return sceneArea;
	}

	public void setSceneArea(String sceneArea) {
		this.sceneArea = sceneArea;
	}

	public String getSceneStatus() {
		return sceneStatus;
	}

	public void setSceneStatus(String sceneStatus) {
		this.sceneStatus = sceneStatus;
	}

	public String getRelateFlag() {
		return relateFlag;
	}

	public void setRelateFlag(String relateFlag) {
		this.relateFlag = relateFlag;
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getAlarmNo() {
		return alarmNo;
	}

	public void setAlarmNo(String alarmNo) {
		this.alarmNo = alarmNo;
	}

	public String getNoteMadeFlag() {
		return noteMadeFlag;
	}

	public void setNoteMadeFlag(String noteMadeFlag) {
		this.noteMadeFlag = noteMadeFlag;
	}

	public String getBsCollectFlag() {
		return bsCollectFlag;
	}

	public void setBsCollectFlag(String bsCollectFlag) {
		this.bsCollectFlag = bsCollectFlag;
	}

	public String getStorageFlag() {
		return storageFlag;
	}

	public void setStorageFlag(String storageFlag) {
		this.storageFlag = storageFlag;
	}
	public String getInvestigationId() {
		return investigationId;
	}
	public void setInvestigationId(String investigationId) {
		this.investigationId = investigationId;
	}
}
