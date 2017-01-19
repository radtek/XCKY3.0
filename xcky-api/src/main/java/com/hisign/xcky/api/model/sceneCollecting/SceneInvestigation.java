/**
 * SceneInvestigationModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.alibaba.fastjson.annotation.JSONField;
import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 现场勘验信息
 *
 * @author ModelGenerator
 */
public class SceneInvestigation extends BaseModel {

    /**
     * 勘验号
     */
    private String investigationNo;

    /**
     * 复勘号
     */
    private Integer iterationNo;

    /**
     * 勘验开始时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm")
    private java.util.Date investigationDateFrom;

    /**
     * 勘验结束时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm")
    private java.util.Date investigationDateTo;

    /**
     * 勘验地点
     */
    private String investigationPlace;

    /**
     * 经度
     */
    private Double caseLon;

    /**
     * 纬度
     */
    private Double caseLat;

    /**
     * 现场勘验情况文本ID
     */
    private String investNoteId;

    /**
     * 是否填写现场勘验情况(SFDM)
     */
    private String investNoteFlag;

    /**
     * 损失物品总价值
     */
    private Integer lostTotalValue;

    /**
     * 现场遗留物描述
     */
    private String remnantDesc;

    /**
     * 现场处置意见(XCCZYJDM)
     */
    private String sceneDisposal;

    /**
     * 现场处置意见描述
     */
    private String sceneDisposalDesc;

    /**
     * 录像时间
     */
    private Integer videoTime;

    /**
     * 录音时间
     */
    private Integer recordTime;

    /**
     * 勘验单位代码(关联单位表)
     */
    private String organNo;

    /**
     * 勘验单位名称
     */
    private String organName;

    /**
     * 其他到达现场人员
     */
    private String otherPersons;

    /**
     * 现场变动原因(BDYYDM)
     */
    private String changeReason;

    /**
     * 现场变动原因描述
     */
    private String changeReasonDesc;

    /**
     * 见证人备注(见证人为空的时候修改)
     */
    private String witnessRemark;

    /**
     * 现场录入模板ID
     */
    private String templateId;

    /**
     * 密级(QXJBDM)
     */
    private String secrecy;

    /**
     * HISIGN_KEY
     */
    private String hisignKey;

    /**
     * 数据来源(SJLYDM)
     */
    private String source;


    //页面展示字段
    
    /**
     * 现场范围
     */
    private String sceneArea;
    
    /**
     * 现场状态
     */
    private String sceneStatus;
    
    /**
     * 案件类别
     */
    private String caseType;
    
    /**
     * 案件性质
     */
    private String caseNature;
    
    /**
     * 发案区划(关联单位表)
     */
    private String caseRegionalism;
    
    /**
     * 勘验人
     */
    private String sceneInvestigator;
    
    /**
     * 勘验人ID
     */
    private String sceneInvestigatorId;
    
    /**
     * 案件编号
     */
    private String caseNo;
    
    /**
     * 接警编号
     */
    private String alarmNo;
    
    /**
     * 是否制作笔录
     */
    private String noteMadeFlag;
    
    /**
     * 是否已采基站
     */
    private String bsCollectFlag;
    
    /**
     * 发案开始时间
     */
    private java.util.Date crimeTimeBegin;
    
    /**
     * 发案结束时间
     */
    private java.util.Date crimeTimeEnd;
    
    /**
     * 现场图
     */
    private String scenePicture;
    
    /**
     * 现场照片
     */
    private String scenePhoto;
    
    /**
     * 痕迹物证
     */
    private String sceneMaterialEvidence;
    
    /**
     * 视频
     */
    private String sceneVideo;
    
    /**
     * 提取物品数量
     */
    private String collectGoodsAmount;
    
    /**
     * 提交时间
     */
    private String submitDate;
    
    /**
     * 死亡人数
     */
    private String deadAmount;
    
    /**
     * 发案地点
     */
    private String caseLocation;
    
    /**
     * 1(提交)0(暂存)
     */
    private String saveFlag;
    
    /**
     * 是否可修改(1是0否)
     */
    private String allowModify;
    
    /**
     * 关注id（空表示未关注）
     */
    private String followId;
    
    /**
     * 自定义显示列名称
     * */
    private String colName;
    
    /**
     * 全部数量
     */
    private Integer allCount;
    
    /**
     * 个人数量
     */
    private Integer allPersonCount;
    
    /**
     * 本单位数量
     */
    private Integer allOrganCount;
    
    /**
     * 是否合格
     */
    private String qualityFlag;

    /**
     * 是否关键接警号(SFDM)
     */
    private String alarmNoFlag;

    /**
     * 是否关键案件号(SFDM)
     */
    private String caseNoFlag;
    
    /**
     * 是否关联
     */
    private String relateFlag;
    
    /**
     * 警综关联类型(JZGLLXDM)
     */
    private String relateType;

    /**
     * 处理状态，用于提取物品列表现场查询
     */
    private String storageStatus;

    public String getStorageStatus() {
        return storageStatus;
    }

    public void setStorageStatus(String storageStatus) {
        this.storageStatus = storageStatus;
    }

    /**
     * 文件服务器地址
     */
    private String fileServicePath;
    
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

	public String getSceneInvestigator() {
		return sceneInvestigator;
	}

	public void setSceneInvestigator(String sceneInvestigator) {
		this.sceneInvestigator = sceneInvestigator;
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

	/**
     * 大文本字段
     */
    private String content;
    
	/**
     * 获得勘验号
     * 
     * @return 勘验号
     */
    public String getInvestigationNo() {
        return this.investigationNo;
    }

    /**
     * 获得复勘号
     * 
     * @return 复勘号
     */
    public Integer getIterationNo() {
        return this.iterationNo;
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
     * 获得经度
     * 
     * @return 经度
     */
    public Double getCaseLon() {
        return this.caseLon;
    }

    /**
     * 获得纬度
     * 
     * @return 纬度
     */
    public Double getCaseLat() {
        return this.caseLat;
    }

    /**
     * 获得现场勘验情况文本ID
     * 
     * @return 现场勘验情况文本ID
     */
    public String getInvestNoteId() {
        return this.investNoteId;
    }

    /**
     * 获得是否填写现场勘验情况(SFDM)
     * 
     * @return 是否填写现场勘验情况(SFDM)
     */
    public String getInvestNoteFlag() {
        return this.investNoteFlag;
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
     * 获得现场遗留物描述
     * 
     * @return 现场遗留物描述
     */
    public String getRemnantDesc() {
        return this.remnantDesc;
    }

    /**
     * 获得现场处置意见(XCCZYJDM)
     * 
     * @return 现场处置意见(XCCZYJDM)
     */
    public String getSceneDisposal() {
        return this.sceneDisposal;
    }

    /**
     * 获得现场处置意见描述
     * 
     * @return 现场处置意见描述
     */
    public String getSceneDisposalDesc() {
        return this.sceneDisposalDesc;
    }

    /**
     * 获得录像时间
     * 
     * @return 录像时间
     */
    public Integer getVideoTime() {
        return this.videoTime;
    }

    /**
     * 获得录音时间
     * 
     * @return 录音时间
     */
    public Integer getRecordTime() {
        return this.recordTime;
    }

    /**
     * 获得勘验单位代码(关联单位表)
     * 
     * @return 勘验单位代码(关联单位表)
     */
    public String getOrganNo() {
        return this.organNo;
    }

    /**
     * 获得勘验单位名称
     * 
     * @return 勘验单位名称
     */
    public String getOrganName() {
        return this.organName;
    }

    /**
     * 获得其他到达现场人员
     * 
     * @return 其他到达现场人员
     */
    public String getOtherPersons() {
        return this.otherPersons;
    }

    /**
     * 获得现场变动原因(BDYYDM)
     * 
     * @return 现场变动原因(BDYYDM)
     */
    public String getChangeReason() {
        return this.changeReason;
    }

    /**
     * 获得现场变动原因描述
     * 
     * @return 现场变动原因描述
     */
    public String getChangeReasonDesc() {
        return this.changeReasonDesc;
    }

    /**
     * 获得见证人备注(见证人为空的时候修改)
     * 
     * @return 见证人备注(见证人为空的时候修改)
     */
    public String getWitnessRemark() {
        return this.witnessRemark;
    }

    /**
     * 获得现场录入模板ID
     * 
     * @return 现场录入模板ID
     */
    public String getTemplateId() {
        return this.templateId;
    }

    /**
     * 获得密级(QXJBDM)
     * 
     * @return 密级(QXJBDM)
     */
    public String getSecrecy() {
        return this.secrecy;
    }

    /**
     * 获得HISIGN_KEY
     * 
     * @return HISIGN_KEY
     */
    public String getHisignKey() {
        return this.hisignKey;
    }

    /**
     * 获得数据来源(SJLYDM)
     * 
     * @return 数据来源(SJLYDM)
     */
    public String getSource() {
        return this.source;
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
     * 设置复勘号
     * 
     * @param iterationNo 复勘号
     */
    public void setIterationNo(Integer iterationNo) {
        this.iterationNo = iterationNo;
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
     * 设置经度
     * 
     * @param caseLon 经度
     */
    public void setCaseLon(Double caseLon) {
        this.caseLon = caseLon;
    }

    /**
     * 设置纬度
     * 
     * @param caseLat 纬度
     */
    public void setCaseLat(Double caseLat) {
        this.caseLat = caseLat;
    }

    /**
     * 设置现场勘验情况文本ID
     * 
     * @param investNoteId 现场勘验情况文本ID
     */
    public void setInvestNoteId(String investNoteId) {
        this.investNoteId = investNoteId;
    }

    /**
     * 设置是否填写现场勘验情况(SFDM)
     * 
     * @param investNoteFlag 是否填写现场勘验情况(SFDM)
     */
    public void setInvestNoteFlag(String investNoteFlag) {
        this.investNoteFlag = investNoteFlag;
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
     * 设置现场遗留物描述
     * 
     * @param remnantDesc 现场遗留物描述
     */
    public void setRemnantDesc(String remnantDesc) {
        this.remnantDesc = remnantDesc;
    }

    /**
     * 设置现场处置意见(XCCZYJDM)
     * 
     * @param sceneDisposal 现场处置意见(XCCZYJDM)
     */
    public void setSceneDisposal(String sceneDisposal) {
        this.sceneDisposal = sceneDisposal;
    }

    /**
     * 设置现场处置意见描述
     * 
     * @param sceneDisposalDesc 现场处置意见描述
     */
    public void setSceneDisposalDesc(String sceneDisposalDesc) {
        this.sceneDisposalDesc = sceneDisposalDesc;
    }

    /**
     * 设置录像时间
     * 
     * @param videoTime 录像时间
     */
    public void setVideoTime(Integer videoTime) {
        this.videoTime = videoTime;
    }

    /**
     * 设置录音时间
     * 
     * @param recordTime 录音时间
     */
    public void setRecordTime(Integer recordTime) {
        this.recordTime = recordTime;
    }

    /**
     * 设置勘验单位代码(关联单位表)
     * 
     * @param mainOrganNo 勘验单位代码(关联单位表)
     */
    public void setOrganNo(String organNo) {
        this.organNo = organNo;
    }

    /**
     * 设置勘验单位名称
     * 
     * @param mainOrganName 勘验单位名称
     */
    public void setOrganName(String organName) {
        this.organName = organName;
    }

    /**
     * 设置其他到达现场人员
     * 
     * @param otherPersons 其他到达现场人员
     */
    public void setOtherPersons(String otherPersons) {
        this.otherPersons = otherPersons;
    }

    /**
     * 设置现场变动原因(BDYYDM)
     * 
     * @param changeReason 现场变动原因(BDYYDM)
     */
    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    /**
     * 设置现场变动原因描述
     * 
     * @param changeReasonDesc 现场变动原因描述
     */
    public void setChangeReasonDesc(String changeReasonDesc) {
        this.changeReasonDesc = changeReasonDesc;
    }

    /**
     * 设置见证人备注(见证人为空的时候修改)
     * 
     * @param witnessRemark 见证人备注(见证人为空的时候修改)
     */
    public void setWitnessRemark(String witnessRemark) {
        this.witnessRemark = witnessRemark;
    }

    /**
     * 设置现场录入模板ID
     * 
     * @param templateId 现场录入模板ID
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * 设置密级(QXJBDM)
     * 
     * @param secrecy 密级(QXJBDM)
     */
    public void setSecrecy(String secrecy) {
        this.secrecy = secrecy;
    }

    /**
     * 设置HISIGN_KEY
     * 
     * @param hisignKey HISIGN_KEY
     */
    public void setHisignKey(String hisignKey) {
        this.hisignKey = hisignKey;
    }

    /**
     * 设置数据来源(SJLYDM)
     * 
     * @param source 数据来源(SJLYDM)
     */
    public void setSource(String source) {
        this.source = source;
    }
    public String getContent() {
  		return content;
  	}
    
  	public void setContent(String content) {
  		this.content = content;
  	}
	public String getCaseLocation() {
		return caseLocation;
	}

	public void setCaseLocation(String caseLocation) {
		this.caseLocation = caseLocation;
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

	public String getScenePicture() {
		return scenePicture;
	}

	public void setScenePicture(String scenePicture) {
		this.scenePicture = scenePicture;
	}

	public String getScenePhoto() {
		return scenePhoto;
	}

	public void setScenePhoto(String scenePhoto) {
		this.scenePhoto = scenePhoto;
	}

	public String getSceneMaterialEvidence() {
		return sceneMaterialEvidence;
	}

	public void setSceneMaterialEvidence(String sceneMaterialEvidence) {
		this.sceneMaterialEvidence = sceneMaterialEvidence;
	}

	public String getSceneVideo() {
		return sceneVideo;
	}

	public void setSceneVideo(String sceneVideo) {
		this.sceneVideo = sceneVideo;
	}

	public String getCollectGoodsAmount() {
		return collectGoodsAmount;
	}

	public void setCollectGoodsAmount(String collectGoodsAmount) {
		this.collectGoodsAmount = collectGoodsAmount;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getDeadAmount() {
		return deadAmount;
	}

	public void setDeadAmount(String deadAmount) {
		this.deadAmount = deadAmount;
	}

	public String getSceneInvestigatorId() {
		return sceneInvestigatorId;
	}

	public void setSceneInvestigatorId(String sceneInvestigatorId) {
		this.sceneInvestigatorId = sceneInvestigatorId;
	}

	public String getSaveFlag() {
		return saveFlag;
	}

	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}

	public String getAllowModify() {
		return allowModify;
	}

	public void setAllowModify(String allowModify) {
		this.allowModify = allowModify;
	}

	public String getFollowId() {
		return followId;
	}

	public void setFollowId(String followId) {
		this.followId = followId;
	}

	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
	}

	public Integer getAllCount() {
		return allCount;
	}

	public void setAllCount(Integer allCount) {
		this.allCount = allCount;
	}

	public Integer getAllPersonCount() {
		return allPersonCount;
	}

	public void setAllPersonCount(Integer allPersonCount) {
		this.allPersonCount = allPersonCount;
	}

	public Integer getAllOrganCount() {
		return allOrganCount;
	}

	public void setAllOrganCount(Integer allOrganCount) {
		this.allOrganCount = allOrganCount;
	}

	public String getQualityFlag() {
		return qualityFlag;
	}

	public void setQualityFlag(String qualityFlag) {
		this.qualityFlag = qualityFlag;
	}

	public String getAlarmNoFlag() {
		return alarmNoFlag;
	}

	public void setAlarmNoFlag(String alarmNoFlag) {
		this.alarmNoFlag = alarmNoFlag;
	}

	public String getCaseNoFlag() {
		return caseNoFlag;
	}

	public void setCaseNoFlag(String caseNoFlag) {
		this.caseNoFlag = caseNoFlag;
	}

	public String getRelateFlag() {
		return relateFlag;
	}

	public void setRelateFlag(String relateFlag) {
		this.relateFlag = relateFlag;
	}

	public String getRelateType() {
		return relateType;
	}

	public void setRelateType(String relateType) {
		this.relateType = relateType;
	}

	public String getCaseNature() {
		return caseNature;
	}

	public void setCaseNature(String caseNature) {
		this.caseNature = caseNature;
	}

	public String getFileServicePath() {
		return fileServicePath;
	}

	public void setFileServicePath(String fileServicePath) {
		this.fileServicePath = fileServicePath;
	}
	
	
	

}