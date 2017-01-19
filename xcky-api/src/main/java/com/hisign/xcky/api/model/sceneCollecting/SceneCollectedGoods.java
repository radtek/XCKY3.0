/**
 * SceneCollectedGoodsModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 现场提取物品信息
 *
 * @author ModelGenerator
 */
public class SceneCollectedGoods extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 提取物品编号
     */
    private String serialNo;

    /**
     * 提取物品名称
     */
    private String name;

    /**
     * 是否痕迹物证标识
     */
    private String materialEvidenceFlag;

    /**
     * 痕迹物证ID
     */
    private String materialEvidenceId;

    /**
     * 提取物品数量
     */
    private Integer amount;

    /**
     * 提取部位
     */
    private String collectedPosition;

    /**
     * 提取方法
     */
    private String collectedMethod;

    /**
     * 提取时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm")
    private java.util.Date collectedTime;

    /**
     * 特征描述
     */
    private String feature;

    /**
     * 数据来源(SJLYDM)
     */
    private String source;

    /**
     * 备注
     */
    private String remark;

    /**
     * 图片ID
     */
    private String pictureId;
    
    /**
     * 原始文件附件ID与传值
     */
    private String attachmentId;
    
    /**
     * 物证类别(XCHJWZLBDM)
     */
    private String category;

    /**
     * 物证类型字典名称
     */
    private String materialEvidenceTypeDict;

    /**
     * 物证类型代码
     */
    private String materialEvidenceType;
    
    /**
     * 痕迹提取人集合用于查询报文展示
     */
    private List<SceneCollectedPerson> sceneCollectedPerson;

    /**
     *痕迹提取人ID
     */
    private String collectedPersonID;

    public String getCollectedPersonID() {
        return collectedPersonID;
    }

    public void setCollectedPersonID(String collectedPersonID) {
        this.collectedPersonID = collectedPersonID;
    }

    public String getCollectedPerson() {
        return collectedPerson;
    }

    public void setCollectedPerson(String collectedPerson) {
        this.collectedPerson = collectedPerson;
    }

    /**
     *痕迹提取人

     */
    private String collectedPerson;

    /**
     * 是否提交专业系统（SFDM）
     */
    private String storageFlag;

    public String getStorageFlag() {
        return storageFlag;
    }

    public void setStorageFlag(String storageFlag) {
        this.storageFlag = storageFlag;
    }

    public String getStorageStatus() {
        return storageStatus;
    }

    public void setStorageStatus(String storageStatus) {
        this.storageStatus = storageStatus;
    }

    /**
     * 专业系统状态反馈 (ZYXTZTFKDM)
     */
    private String storageStatus;

    /*****************查询用 start*******************/

    public String getStorageStatusCN() {
        return storageStatusCN;
    }

    public void setStorageStatusCN(String storageStatusCN) {
        this.storageStatusCN = storageStatusCN;
    }

    /**
     * 专业系统状态反馈中文
     */

    private String storageStatusCN;

    /**
     * 案件类别
     */
    private String caseType;

    /**
     * 发案区划(关联单位表)
     */
    private String caseRegionalism;

    /**
     * 勘验地点
     */
    private String investigationPlace;

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
     * 勘验号
     */
    private String investigationNo;

    /**
     * 发案开始时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm")
    private String crimeTimeBegin;

    /**
     * 发案结束时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm")
    private String crimeTimeEnd;

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

    public String getInvestigationPlace() {
        return investigationPlace;
    }

    public void setInvestigationPlace(String investigationPlace) {
        this.investigationPlace = investigationPlace;
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

    public String getInvestigationNo() {
        return investigationNo;
    }

    public void setInvestigationNo(String investigationNo) {
        this.investigationNo = investigationNo;
    }

    public String getCrimeTimeBegin() {
        return crimeTimeBegin;
    }

    public void setCrimeTimeBegin(String crimeTimeBegin) {
        this.crimeTimeBegin = crimeTimeBegin;
    }

    public String getCrimeTimeEnd() {
        return crimeTimeEnd;
    }

    public void setCrimeTimeEnd(String crimeTimeEnd) {
        this.crimeTimeEnd = crimeTimeEnd;
    }

    /*****************查询用 end *******************/


    
    public List<SceneCollectedPerson> getSceneCollectedPerson() {
		return sceneCollectedPerson;
	}

	public void setSceneCollectedPerson(
			List<SceneCollectedPerson> sceneCollectedPerson) {
		this.sceneCollectedPerson = sceneCollectedPerson;
	}

    /**
     * 获得勘验信息ID
     * 
     * @return 勘验信息ID
     */
    public String getInvestigationId() {
        return this.investigationId;
    }

    /**
     * 获得提取物品编号
     * 
     * @return 提取物品编号
     */
    public String getSerialNo() {
        return this.serialNo;
    }

    /**
     * 获得提取物品名称
     * 
     * @return 提取物品名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 获得是否痕迹物证标识
     * 
     * @return 是否痕迹物证标识
     */
    public String getMaterialEvidenceFlag() {
        return this.materialEvidenceFlag;
    }

    /**
     * 获得痕迹物证ID
     * 
     * @return 痕迹物证ID
     */
    public String getMaterialEvidenceId() {
        return this.materialEvidenceId;
    }

    /**
     * 获得提取物品数量
     * 
     * @return 提取物品数量
     */
    public Integer getAmount() {
        return this.amount;
    }

    /**
     * 获得提取部位
     * 
     * @return 提取部位
     */
    public String getCollectedPosition() {
        return this.collectedPosition;
    }

    /**
     * 获得提取方法
     * 
     * @return 提取方法
     */
    public String getCollectedMethod() {
        return this.collectedMethod;
    }

    /**
     * 获得提取时间
     * 
     * @return 提取时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public java.util.Date getCollectedTime() {
        return this.collectedTime;
    }

    /**
     * 获得特征描述
     * 
     * @return 特征描述
     */
    public String getFeature() {
        return this.feature;
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
     * 获得备注
     * 
     * @return 备注
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * 获得图片ID
     * 
     * @return 图片ID
     */
    public String getPictureId() {
        return this.pictureId;
    }


    /**
     * 设置勘验信息ID
     * 
     * @param investigationId 勘验信息ID
     */
    public void setInvestigationId(String investigationId) {
        this.investigationId = investigationId;
    }

    /**
     * 设置提取物品编号
     * 
     * @param serialNo 提取物品编号
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 设置提取物品名称
     * 
     * @param name 提取物品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设置是否痕迹物证标识
     * 
     * @param materialEvidenceFlag 是否痕迹物证标识
     */
    public void setMaterialEvidenceFlag(String materialEvidenceFlag) {
        this.materialEvidenceFlag = materialEvidenceFlag;
    }

    /**
     * 设置痕迹物证ID
     * 
     * @param materialEvidenceId 痕迹物证ID
     */
    public void setMaterialEvidenceId(String materialEvidenceId) {
        this.materialEvidenceId = materialEvidenceId;
    }

    /**
     * 设置提取物品数量
     * 
     * @param amount 提取物品数量
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 设置提取部位
     * 
     * @param collectedPosition 提取部位
     */
    public void setCollectedPosition(String collectedPosition) {
        this.collectedPosition = collectedPosition;
    }

    /**
     * 设置提取方法
     * 
     * @param collectedMethod 提取方法
     */
    public void setCollectedMethod(String collectedMethod) {
        this.collectedMethod = collectedMethod;
    }

    /**
     * 设置提取时间
     * 
     * @param collectedTime 提取时间
     */
    public void setCollectedTime(java.util.Date collectedTime) {
        this.collectedTime = collectedTime;
    }

    /**
     * 设置特征描述
     * 
     * @param feature 特征描述
     */
    public void setFeature(String feature) {
        this.feature = feature;
    }

    /**
     * 设置数据来源(SJLYDM)
     * 
     * @param source 数据来源(SJLYDM)
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 设置备注
     * 
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 设置图片ID
     * 
     * @param pictureId 图片ID
     */
    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

    
    
}