/**
 * TempSceneQueryModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneQuery;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 简单查询临时结果集表
 *
 * @author ModelGenerator
 */
@SuppressWarnings("serial")
public class SceneSimpleQuery extends BaseModel {

    /**
     * 勘验ID
     */
    private String investigationId;

    /**
     * 勘验号
     */
    private String investigationNo;

    /**
     * 案件号
     */
    private String caseNo;

    /**
     * 接警号
     */
    private String alarmNo;

    /**
     * 案件类型代码
     */
    private String caseType;

    /**
     * 案件类型中文
     */
    private String caseTypeCn;

    /**
     * 案件性质代码
     */
    private String caseNature;

    /**
     * 案件性质中文
     */
    private String caseNatureCn;

    /**
     * 勘验单位
     */
    private String organName;

    /**
     * 勘验开始时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private java.util.Date investigationDateFrom;

    /**
     * 勘验结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private java.util.Date investigationDateTo;

    /**
     * 勘验地点
     */
    private String investigationPlace;

    /**
     * 发案区划代码
     */
    private String caseRegionalism;

    /**
     * 发案地点
     */
    private String caseLocation;

    /**
     * 发案开始时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private java.util.Date crimeTimeBegin;

    /**
     * 发案结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private java.util.Date crimeTimeEnd;

    /**
     * 发案区划中文
     */
    private String caseRegionalismCn;

    /**
     * 现场图数量
     */
    private Integer scenePhotoAmount;

    /**
     * 现场照片数量
     */
    private Integer scenePictureAmount;

    /**
     * 痕迹物证数量
     */
    private Integer evidenceAmount;

    /**
     * 视频痕迹数量
     */
    private Integer videoEvidenceAmount;

    /**
     * 提取物品数量
     */
    private Integer collectedGoodsAmount;

    /**
     * 勘验人名称
     */
    private String investigatorName;

    /**
     * 指挥人名称
     */
    private String commandName;

    /**
     * 见证人名称
     */
    private String witnessName;

    /**
     * 保护人名称
     */
    private String protector;

    /**
     * 保护日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private java.util.Date protectionDate;

    /**
     * 保护措施中文
     */
    private String protectionMeasureCn;

    /**
     * 损失物品总价值
     */
    private Integer lostTotalValue;

    /**
     * 受伤人数
     */
    private Integer woundedAmount;

    /**
     * 死亡人数
     */
    private Integer deadAmount;

    /**
     * 选择对象
     */
    private String chooseObject;

    /**
     * 选择地点
     */
    private String choosePlace;

    /**
     * 作案时机
     */
    private String crimeTime;

    /**
     * 作案出入口
     */
    private String crimeInOut;

    /**
     * 作案特点
     */
    private String crimeFeature;

    /**
     * 侵入方式
     */
    private String invasionType;

    /**
     * 作案过程
     */
    private String commissionDesc;

    /**
     * 作案人特点
     */
    private String criminalPoints;

    /**
     * 作案工具
     */
    private String crimeTools;

    /**
     * 提交时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private java.util.Date lastSubmitDatetime;

    /**
     * 现场录入时间开始
     */
    private String createTimeStart;

    /**
     * 现场录入时间结束
     */
    private String createTimeEnd;

    /**
     * 勘验时间开始
     */
    private String investigationDateStart;

    /**
     * 勘验时间结束
     */
    private String investigationDateEnd;

    /**
     * 经度
     */
    private Integer caseLon;

    /**
     * 纬度
     */
    private Integer caseLat;

    /**
     * 案件编号
     */
    private String alarmAcceptNo;

    /**
     * 是否命案
     */
    private String murderFlag;

    /**
     * 是否刑案
     */
    private String criminalFlag;

    /**
     * 发案时间开始
     */
    private String crimeTimeBeginStr;

    /**
     * 发案时间结束	
     */
    private String crimeTimeEndStr;

    /**
     * 提交时间开始
     */
    private String lastSubmitDatetimeStart;

    /**
     * 提交时间结束
     */
    private String lastSubmitDatetimeEnd;

    /**
     * 是否已采集基站
     */
    private String bsCollectFlag;

    /**
     * 勘验人员
     */
    private String investigatorId;

    /**
     * 勘验职责
     */
    private String duty;

    /**
     * 被害人/报案人
     */
    private String offenderName;

    /**
     * 作案手段
     */
    private String crimeType;

    /**
     * 损失物品
     */
    private String lostGoodsName;

    /**
     * 痕迹类型
     */
    private String evidenceType;

    /**
     * 排序字段
     */
    private String sortField;
    
    /**
     * 自定义显示列名称
     * */
    private String colName;
    
    /**
     * 显示类型
     */
    private String catagory;
    
    /**
     * 文件路径
     */
    private String fileServerPath;

    /**
     * 痕迹物证编号
     */
    private String materialEvidenceNo;

    /**
     * 痕迹物证名称
     */
    private String materialEvidenceName;

    /**
     * 痕迹物证类别
     */
    private String materialEvidenceTypeCn;
    
    /**
     * 半径
     */
    private Integer radius;

    /**
     * 痕迹物证提取方法
     */
    private String collectionModeCn;    

    public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	/**
     * 获得勘验ID
     * 
     * @return 勘验ID
     */
    public String getInvestigationId() {
        return this.investigationId;
    }

    /**
     * 获得勘验号
     * 
     * @return 勘验号
     */
    public String getInvestigationNo() {
        return this.investigationNo;
    }

    /**
     * 获得案件号
     * 
     * @return 案件号
     */
    public String getCaseNo() {
        return this.caseNo;
    }

    /**
     * 获得接警号
     * 
     * @return 接警号
     */
    public String getAlarmNo() {
        return this.alarmNo;
    }

    /**
     * 获得案件类型代码
     * 
     * @return 案件类型代码
     */
    public String getCaseType() {
        return this.caseType;
    }

    /**
     * 获得案件类型中文
     * 
     * @return 案件类型中文
     */
    public String getCaseTypeCn() {
        return this.caseTypeCn;
    }

    /**
     * 获得案件性质代码
     * 
     * @return 案件性质代码
     */
    public String getCaseNature() {
        return this.caseNature;
    }

    /**
     * 获得案件性质中文
     * 
     * @return 案件性质中文
     */
    public String getCaseNatureCn() {
        return this.caseNatureCn;
    }

    /**
     * 获得勘验单位
     * 
     * @return 勘验单位
     */
    public String getOrganName() {
        return this.organName;
    }

    /**
     * 获得勘验开始时间
     * 
     * @return 勘验开始时间
     */
    public java.util.Date getInvestigationDateFrom() {
        return this.investigationDateFrom;
    }

    /**
     * 获得勘验结束时间
     * 
     * @return 勘验结束时间
     */
    public java.util.Date getInvestigationDateTo() {
        return this.investigationDateTo;
    }

    /**
     * 获得勘验地点
     * 
     * @return 勘验地点
     */
    public String getInvestigationPlace() {
        return this.investigationPlace;
    }

    /**
     * 获得发案区划代码
     * 
     * @return 发案区划代码
     */
    public String getCaseRegionalism() {
        return this.caseRegionalism;
    }

    /**
     * 获得发案地点
     * 
     * @return 发案地点
     */
    public String getCaseLocation() {
        return this.caseLocation;
    }

    /**
     * 获得发案开始时间
     * 
     * @return 发案开始时间
     */
    public java.util.Date getCrimeTimeBegin() {
        return this.crimeTimeBegin;
    }

    /**
     * 获得发案结束时间
     * 
     * @return 发案结束时间
     */
    public java.util.Date getCrimeTimeEnd() {
        return this.crimeTimeEnd;
    }

    /**
     * 获得发案区划中文
     * 
     * @return 发案区划中文
     */
    public String getCaseRegionalismCn() {
        return this.caseRegionalismCn;
    }

    /**
     * 获得现场图数量
     * 
     * @return 现场图数量
     */
    public Integer getScenePhotoAmount() {
        return this.scenePhotoAmount;
    }

    /**
     * 获得现场照片数量
     * 
     * @return 现场照片数量
     */
    public Integer getScenePictureAmount() {
        return this.scenePictureAmount;
    }

    /**
     * 获得痕迹物证数量
     * 
     * @return 痕迹物证数量
     */
    public Integer getEvidenceAmount() {
        return this.evidenceAmount;
    }

    /**
     * 获得视频痕迹数量
     * 
     * @return 视频痕迹数量
     */
    public Integer getVideoEvidenceAmount() {
        return this.videoEvidenceAmount;
    }

    /**
     * 获得提取物品数量
     * 
     * @return 提取物品数量
     */
    public Integer getCollectedGoodsAmount() {
        return this.collectedGoodsAmount;
    }

    /**
     * 获得勘验人名称
     * 
     * @return 勘验人名称
     */
    public String getInvestigatorName() {
        return this.investigatorName;
    }

    /**
     * 获得指挥人名称
     * 
     * @return 指挥人名称
     */
    public String getCommandName() {
        return this.commandName;
    }

    /**
     * 获得见证人名称
     * 
     * @return 见证人名称
     */
    public String getWitnessName() {
        return this.witnessName;
    }

    /**
     * 获得保护人名称
     * 
     * @return 保护人名称
     */
    public String getProtector() {
        return this.protector;
    }

    /**
     * 获得保护日期
     * 
     * @return 保护日期
     */
    public java.util.Date getProtectionDate() {
        return this.protectionDate;
    }

    /**
     * 获得保护措施中文
     * 
     * @return 保护措施中文
     */
    public String getProtectionMeasureCn() {
        return this.protectionMeasureCn;
    }

    /**
     * 获得损失物品总价值
     * 
     * @return 损失物品总价值
     */
    public Integer getLostTotalValue() {
        return this.lostTotalValue;
    }

    /**
     * 获得受伤人数
     * 
     * @return 受伤人数
     */
    public Integer getWoundedAmount() {
        return this.woundedAmount;
    }

    /**
     * 获得死亡人数
     * 
     * @return 死亡人数
     */
    public Integer getDeadAmount() {
        return this.deadAmount;
    }

    /**
     * 获得选择对象
     * 
     * @return 选择对象
     */
    public String getChooseObject() {
        return this.chooseObject;
    }

    /**
     * 获得选择地点
     * 
     * @return 选择地点
     */
    public String getChoosePlace() {
        return this.choosePlace;
    }

    /**
     * 获得作案时机
     * 
     * @return 作案时机
     */
    public String getCrimeTime() {
        return this.crimeTime;
    }

    /**
     * 获得作案出入口
     * 
     * @return 作案出入口
     */
    public String getCrimeInOut() {
        return this.crimeInOut;
    }

    /**
     * 获得作案特点
     * 
     * @return 作案特点
     */
    public String getCrimeFeature() {
        return this.crimeFeature;
    }

    /**
     * 获得侵入方式
     * 
     * @return 侵入方式
     */
    public String getInvasionType() {
        return this.invasionType;
    }

    /**
     * 获得作案过程
     * 
     * @return 作案过程
     */
    public String getCommissionDesc() {
        return this.commissionDesc;
    }

    /**
     * 获得作案人特点
     * 
     * @return 作案人特点
     */
    public String getCriminalPoints() {
        return this.criminalPoints;
    }

    /**
     * 获得作案工具
     * 
     * @return 作案工具
     */
    public String getCrimeTools() {
        return this.crimeTools;
    }

    /**
     * 获得提交时间
     * 
     * @return 提交时间
     */
    public java.util.Date getLastSubmitDatetime() {
        return this.lastSubmitDatetime;
    }

    /**
     * 设置勘验ID
     * 
     * @param investigationId 勘验ID
     */
    public void setInvestigationId(String investigationId) {
        this.investigationId = investigationId;
    }

    /**
     * 设置勘验号
     * 
     * @param investigationNo 勘验号
     */
    public void setInvestigationNo(String investigationNo) {
        this.investigationNo = investigationNo;
    }

    /**
     * 设置案件号
     * 
     * @param caseNo 案件号
     */
    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    /**
     * 设置接警号
     * 
     * @param alarmNo 接警号
     */
    public void setAlarmNo(String alarmNo) {
        this.alarmNo = alarmNo;
    }

    /**
     * 设置案件类型代码
     * 
     * @param caseType 案件类型代码
     */
    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    /**
     * 设置案件类型中文
     * 
     * @param caseTypeCn 案件类型中文
     */
    public void setCaseTypeCn(String caseTypeCn) {
        this.caseTypeCn = caseTypeCn;
    }

    /**
     * 设置案件性质代码
     * 
     * @param caseNature 案件性质代码
     */
    public void setCaseNature(String caseNature) {
        this.caseNature = caseNature;
    }

    /**
     * 设置案件性质中文
     * 
     * @param caseNatureCn 案件性质中文
     */
    public void setCaseNatureCn(String caseNatureCn) {
        this.caseNatureCn = caseNatureCn;
    }

    /**
     * 设置勘验单位
     * 
     * @param organName 勘验单位
     */
    public void setOrganName(String organName) {
        this.organName = organName;
    }

    /**
     * 设置勘验开始时间
     * 
     * @param investigationDateFrom 勘验开始时间
     */
    public void setInvestigationDateFrom(java.util.Date investigationDateFrom) {
        this.investigationDateFrom = investigationDateFrom;
    }

    /**
     * 设置勘验结束时间
     * 
     * @param investigationDateTo 勘验结束时间
     */
    public void setInvestigationDateTo(java.util.Date investigationDateTo) {
        this.investigationDateTo = investigationDateTo;
    }

    /**
     * 设置勘验地点
     * 
     * @param investigationPlace 勘验地点
     */
    public void setInvestigationPlace(String investigationPlace) {
        this.investigationPlace = investigationPlace;
    }

    /**
     * 设置发案区划代码
     * 
     * @param caseRegionalism 发案区划代码
     */
    public void setCaseRegionalism(String caseRegionalism) {
        this.caseRegionalism = caseRegionalism;
    }

    /**
     * 设置发案地点
     * 
     * @param caseLocation 发案地点
     */
    public void setCaseLocation(String caseLocation) {
        this.caseLocation = caseLocation;
    }

    /**
     * 设置发案开始时间
     * 
     * @param crimeTimeBegin 发案开始时间
     */
    public void setCrimeTimeBegin(java.util.Date crimeTimeBegin) {
        this.crimeTimeBegin = crimeTimeBegin;
    }

    /**
     * 设置发案结束时间
     * 
     * @param crimeTimeEnd 发案结束时间
     */
    public void setCrimeTimeEnd(java.util.Date crimeTimeEnd) {
        this.crimeTimeEnd = crimeTimeEnd;
    }

    /**
     * 设置发案区划中文
     * 
     * @param caseRegionalismCn 发案区划中文
     */
    public void setCaseRegionalismCn(String caseRegionalismCn) {
        this.caseRegionalismCn = caseRegionalismCn;
    }

    /**
     * 设置现场图数量
     * 
     * @param scenePhotoAmount 现场图数量
     */
    public void setScenePhotoAmount(Integer scenePhotoAmount) {
        this.scenePhotoAmount = scenePhotoAmount;
    }

    /**
     * 设置现场照片数量
     * 
     * @param scenePictureAmount 现场照片数量
     */
    public void setScenePictureAmount(Integer scenePictureAmount) {
        this.scenePictureAmount = scenePictureAmount;
    }

    /**
     * 设置痕迹物证数量
     * 
     * @param evidenceAmount 痕迹物证数量
     */
    public void setEvidenceAmount(Integer evidenceAmount) {
        this.evidenceAmount = evidenceAmount;
    }

    /**
     * 设置视频痕迹数量
     * 
     * @param videoEvidenceAmount 视频痕迹数量
     */
    public void setVideoEvidenceAmount(Integer videoEvidenceAmount) {
        this.videoEvidenceAmount = videoEvidenceAmount;
    }

    /**
     * 设置提取物品数量
     * 
     * @param collectedGoodsAmount 提取物品数量
     */
    public void setCollectedGoodsAmount(Integer collectedGoodsAmount) {
        this.collectedGoodsAmount = collectedGoodsAmount;
    }

    /**
     * 设置勘验人名称
     * 
     * @param investigatorName 勘验人名称
     */
    public void setInvestigatorName(String investigatorName) {
        this.investigatorName = investigatorName;
    }

    /**
     * 设置指挥人名称
     * 
     * @param commandName 指挥人名称
     */
    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    /**
     * 设置见证人名称
     * 
     * @param witnessName 见证人名称
     */
    public void setWitnessName(String witnessName) {
        this.witnessName = witnessName;
    }

    /**
     * 设置保护人名称
     * 
     * @param protector 保护人名称
     */
    public void setProtector(String protector) {
        this.protector = protector;
    }

    /**
     * 设置保护日期
     * 
     * @param protectionDate 保护日期
     */
    public void setProtectionDate(java.util.Date protectionDate) {
        this.protectionDate = protectionDate;
    }

    /**
     * 设置保护措施中文
     * 
     * @param protectionMeasureCn 保护措施中文
     */
    public void setProtectionMeasureCn(String protectionMeasureCn) {
        this.protectionMeasureCn = protectionMeasureCn;
    }

    /**
     * 设置损失物品总价值
     * 
     * @param lostTotalValue 损失物品总价值
     */
    public void setLostTotalValue(Integer lostTotalValue) {
        this.lostTotalValue = lostTotalValue;
    }

    /**
     * 设置受伤人数
     * 
     * @param woundedAmount 受伤人数
     */
    public void setWoundedAmount(Integer woundedAmount) {
        this.woundedAmount = woundedAmount;
    }

    /**
     * 设置死亡人数
     * 
     * @param deadAmount 死亡人数
     */
    public void setDeadAmount(Integer deadAmount) {
        this.deadAmount = deadAmount;
    }

    /**
     * 设置选择对象
     * 
     * @param chooseObject 选择对象
     */
    public void setChooseObject(String chooseObject) {
        this.chooseObject = chooseObject;
    }

    /**
     * 设置选择地点
     * 
     * @param choosePlace 选择地点
     */
    public void setChoosePlace(String choosePlace) {
        this.choosePlace = choosePlace;
    }

    /**
     * 设置作案时机
     * 
     * @param crimeTime 作案时机
     */
    public void setCrimeTime(String crimeTime) {
        this.crimeTime = crimeTime;
    }

    /**
     * 设置作案出入口
     * 
     * @param crimeInOut 作案出入口
     */
    public void setCrimeInOut(String crimeInOut) {
        this.crimeInOut = crimeInOut;
    }

    /**
     * 设置作案特点
     * 
     * @param crimeFeature 作案特点
     */
    public void setCrimeFeature(String crimeFeature) {
        this.crimeFeature = crimeFeature;
    }

    /**
     * 设置侵入方式
     * 
     * @param invasionType 侵入方式
     */
    public void setInvasionType(String invasionType) {
        this.invasionType = invasionType;
    }

    /**
     * 设置作案过程
     * 
     * @param commissionDesc 作案过程
     */
    public void setCommissionDesc(String commissionDesc) {
        this.commissionDesc = commissionDesc;
    }

    /**
     * 设置作案人特点
     * 
     * @param criminalPoints 作案人特点
     */
    public void setCriminalPoints(String criminalPoints) {
        this.criminalPoints = criminalPoints;
    }

    /**
     * 设置作案工具
     * 
     * @param crimeTools 作案工具
     */
    public void setCrimeTools(String crimeTools) {
        this.crimeTools = crimeTools;
    }

    /**
     * 设置提交时间
     * 
     * @param lastSubmitDatetime 提交时间
     */
    public void setLastSubmitDatetime(java.util.Date lastSubmitDatetime) {
        this.lastSubmitDatetime = lastSubmitDatetime;
    }

	public String getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getInvestigationDateStart() {
		return investigationDateStart;
	}

	public void setInvestigationDateStart(String investigationDateStart) {
		this.investigationDateStart = investigationDateStart;
	}

	public String getInvestigationDateEnd() {
		return investigationDateEnd;
	}

	public void setInvestigationDateEnd(String investigationDateEnd) {
		this.investigationDateEnd = investigationDateEnd;
	}

	public Integer getCaseLon() {
		return caseLon;
	}

	public void setCaseLon(Integer caseLon) {
		this.caseLon = caseLon;
	}

	public Integer getCaseLat() {
		return caseLat;
	}

	public void setCaseLat(Integer caseLat) {
		this.caseLat = caseLat;
	}

	public String getAlarmAcceptNo() {
		return alarmAcceptNo;
	}

	public void setAlarmAcceptNo(String alarmAcceptNo) {
		this.alarmAcceptNo = alarmAcceptNo;
	}

	public String getMurderFlag() {
		return murderFlag;
	}

	public void setMurderFlag(String murderFlag) {
		this.murderFlag = murderFlag;
	}

	public String getCriminalFlag() {
		return criminalFlag;
	}

	public void setCriminalFlag(String criminalFlag) {
		this.criminalFlag = criminalFlag;
	}

	public String getCrimeTimeBeginStr() {
		return crimeTimeBeginStr;
	}

	public void setCrimeTimeBeginStr(String crimeTimeBeginStr) {
		this.crimeTimeBeginStr = crimeTimeBeginStr;
	}

	public String getCrimeTimeEndStr() {
		return crimeTimeEndStr;
	}

	public void setCrimeTimeEndStr(String crimeTimeEndStr) {
		this.crimeTimeEndStr = crimeTimeEndStr;
	}

	public String getLastSubmitDatetimeStart() {
		return lastSubmitDatetimeStart;
	}

	public void setLastSubmitDatetimeStart(String lastSubmitDatetimeStart) {
		this.lastSubmitDatetimeStart = lastSubmitDatetimeStart;
	}

	public String getLastSubmitDatetimeEnd() {
		return lastSubmitDatetimeEnd;
	}

	public void setLastSubmitDatetimeEnd(String lastSubmitDatetimeEnd) {
		this.lastSubmitDatetimeEnd = lastSubmitDatetimeEnd;
	}

	public String getBsCollectFlag() {
		return bsCollectFlag;
	}

	public void setBsCollectFlag(String bsCollectFlag) {
		this.bsCollectFlag = bsCollectFlag;
	}

	public String getInvestigatorId() {
		return investigatorId;
	}

	public void setInvestigatorId(String investigatorId) {
		this.investigatorId = investigatorId;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getOffenderName() {
		return offenderName;
	}

	public void setOffenderName(String offenderName) {
		this.offenderName = offenderName;
	}

	public String getCrimeType() {
		return crimeType;
	}

	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}

	public String getLostGoodsName() {
		return lostGoodsName;
	}

	public void setLostGoodsName(String lostGoodsName) {
		this.lostGoodsName = lostGoodsName;
	}

	public String getEvidenceType() {
		return evidenceType;
	}

	public void setEvidenceType(String evidenceType) {
		this.evidenceType = evidenceType;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getFileServerPath() {
		return fileServerPath;
	}

	public void setFileServerPath(String fileServerPath) {
		this.fileServerPath = fileServerPath;
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

	public String getMaterialEvidenceTypeCn() {
		return materialEvidenceTypeCn;
	}

	public void setMaterialEvidenceTypeCn(String materialEvidenceTypeCn) {
		this.materialEvidenceTypeCn = materialEvidenceTypeCn;
	}

	public String getCollectionModeCn() {
		return collectionModeCn;
	}

	public void setCollectionModeCn(String collectionModeCn) {
		this.collectionModeCn = collectionModeCn;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public Integer getRadius() {
		return radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}
	
	
}