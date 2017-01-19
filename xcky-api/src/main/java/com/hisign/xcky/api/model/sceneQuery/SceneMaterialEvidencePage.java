package com.hisign.xcky.api.model.sceneQuery;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 痕迹物证列表字段
 * 项目名称：xcky-api
 * 类名称：SceneMaterialEvidencePage
 * 类描述：
 * 创建人：郭辰
 * 创建时间：2017-1-5 下午1:38:49
 * 修改人：hisign
 * 修改时间：2017-1-5 下午1:38:49
 * 修改备注：
 * @version
 */
public class SceneMaterialEvidencePage extends BaseModel{
	//合并单元格数量
	private int rowSpan=1;
	//序号
	private int rowNum=1;
	//勘验号
	private String investigationNo = null;
	//勘验ID
	private String investigationId = null;
	//痕迹物证编号
	private String materialEvidenceNo = null;
	//痕迹物证名称
	private String materialEvidenceName = null;
	//痕迹物证类型root_key
	private String materialEvidenceTypeDict = null;
	//痕迹物证类型代码值
	private String materialEvidenceType = null;
	//遗留部位
	private String leftPosition = null;
	//提取方法root_key
	private String collectionModeDict = null;
	//提取方法代码值
	private String collectionMode = null;
	//案件类别
	private String caseType = null;
	//发案区划
	private String caseRegionalism = null;
	//勘验单位

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	private String organName = null;

	//现场痕迹物证类别(XCHJWZLBDM)

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	private String category;

	//勘验开始时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	@JSONField(format = "yyyy-MM-dd HH:mm")
	private Date investigationDateFrom;
	//勘验结束时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	@JSONField(format = "yyyy-MM-dd HH:mm")
	private Date investigationDateTo;
	//勘验地点
	private String investigationPlace;
	//勘验人ID
	private String sceneInvestigatorId;
	//勘验人姓名
	private String sceneInvestigator;
	//提取人id
	private String sceneCollectedPersonID;
	//提取人姓名
	private String sceneCollectedPerson;
	//送检状态
	private String storageFlag;

	public int getRowSpan() {
		return rowSpan;
	}
	public void setRowSpan(int rowSpan) {
		this.rowSpan = rowSpan;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public String getInvestigationNo() {
		return investigationNo;
	}
	public void setInvestigationNo(String investigationNo) {
		this.investigationNo = investigationNo;
	}
	public String getInvestigationId() {
		return investigationId;
	}
	public void setInvestigationId(String investigationId) {
		this.investigationId = investigationId;
	}
	public String getMaterialEvidenceNo() {
		return materialEvidenceNo;
	}
	public void setMaterialEvidenceNo(String materialEvidenceNo) {
		this.materialEvidenceNo = materialEvidenceNo;
	}
	public String getMaterialEvidenceName() {
		return materialEvidenceName;
	}
	public void setMaterialEvidenceName(String materialEvidenceName) {
		this.materialEvidenceName = materialEvidenceName;
	}
	public String getMaterialEvidenceTypeDict() {
		return materialEvidenceTypeDict;
	}
	public void setMaterialEvidenceTypeDict(String materialEvidenceTypeDict) {
		this.materialEvidenceTypeDict = materialEvidenceTypeDict;
	}
	public String getMaterialEvidenceType() {
		return materialEvidenceType;
	}
	public void setMaterialEvidenceType(String materialEvidenceType) {
		this.materialEvidenceType = materialEvidenceType;
	}
	public String getLeftPosition() {
		return leftPosition;
	}
	public void setLeftPosition(String leftPosition) {
		this.leftPosition = leftPosition;
	}
	public String getCollectionModeDict() {
		return collectionModeDict;
	}
	public void setCollectionModeDict(String collectionModeDict) {
		this.collectionModeDict = collectionModeDict;
	}
	public String getCollectionMode() {
		return collectionMode;
	}
	public void setCollectionMode(String collectionMode) {
		this.collectionMode = collectionMode;
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
	public Date getInvestigationDateFrom() {
		return investigationDateFrom;
	}
	public void setInvestigationDateFrom(Date investigationDateFrom) {
		this.investigationDateFrom = investigationDateFrom;
	}
	public Date getInvestigationDateTo() {
		return investigationDateTo;
	}
	public void setInvestigationDateTo(Date investigationDateTo) {
		this.investigationDateTo = investigationDateTo;
	}
	public String getInvestigationPlace() {
		return investigationPlace;
	}
	public void setInvestigationPlace(String investigationPlace) {
		this.investigationPlace = investigationPlace;
	}
	public String getSceneInvestigatorId() {
		return sceneInvestigatorId;
	}
	public void setSceneInvestigatorId(String sceneInvestigatorId) {
		this.sceneInvestigatorId = sceneInvestigatorId;
	}
	public String getSceneInvestigator() {
		return sceneInvestigator;
	}
	public void setSceneInvestigator(String sceneInvestigator) {
		this.sceneInvestigator = sceneInvestigator;
	}
	public String getSceneCollectedPersonID() {
		return sceneCollectedPersonID;
	}
	public void setSceneCollectedPersonID(String sceneCollectedPersonID) {
		this.sceneCollectedPersonID = sceneCollectedPersonID;
	}
	public String getSceneCollectedPerson() {
		return sceneCollectedPerson;
	}
	public void setSceneCollectedPerson(String sceneCollectedPerson) {
		this.sceneCollectedPerson = sceneCollectedPerson;
	}
	public String getStorageFlag() {
		return storageFlag;
	}
	public void setStorageFlag(String storageFlag) {
		this.storageFlag = storageFlag;
	}


}
