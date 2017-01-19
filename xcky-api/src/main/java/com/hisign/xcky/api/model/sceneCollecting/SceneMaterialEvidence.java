/**
 * SceneMaterialEvidenceModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 现场痕迹物证信息
 *
 * @author ModelGenerator
 */
public class SceneMaterialEvidence extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 现场痕迹物证类别(XCHJWZLBDM)
     */
    private String category;

    /**
     * 图片ID
     */
    private String pictureId;
    /**
     * 原始文件附件ID与传值
     */
    private String attachmentId;
    /**
     * 修改图片路径
     */
    private String modifyPictureId;
    /**
     * 原始文件附件ID与传值
     */
    private String modifyAttachmentId;
    /**
     * 痕迹物证编号
     */
    private String materialEvidenceNo;

    /**
     * 痕迹物证名称
     */
    private String materialEvidenceName;

    /**
     * 痕迹物证类型字典名称
     */
    private String materialEvidenceTypeDict;

    /**
     * 痕迹物证类型代码
     */
    private String materialEvidenceType;

    /**
     * 痕迹物证编码
     */
    private String materialEvidenceCode;

    /**
     * 痕迹物证推断
     */
    private String materialEvidenceJudgement;

    /**
     * 遗留部位
     */
    private String leftPosition;

    /**
     * 提取方法字典名称
     */
    private String collectionModeDict;

    /**
     * 提取方法代码
     */
    private String collectionMode;

    /**
     * 提取日期
     */
    @JSONField (format="yyyy-MM-dd HH:mm")
    private java.util.Date collectedTime;

    /**
     * 特征描述
     */
    private String feature;

    /**
     * 枪弹制式(QDZSDM)
     */
    private String bulletModel;

    /**
     * 是否提交专业系统(SFDM)
     */
    private String storageFlag;

    /**
     * 专业系统状态反馈(ZYXTZTFKDM)
     */
    private String storageStatus;

    /**
     * 是否列入提取物品登记(SFDM)
     */
    private String collectedFlag;

    /**
     * 数据来源(SJLYDM)
     */
    private String source;

    /**
     * 枪支弹药种类（QZDYZLDM）
     */
    private String bulletType;

    /**
     * 痕迹提取人集合用于查询报文展示
     */
    private List<SceneCollectedPerson> sceneCollectedPerson;
    
    
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
     * 获得现场痕迹物证类别(XCHJWZLBDM)
     * 
     * @return 现场痕迹物证类别(XCHJWZLBDM)
     */
    public String getCategory() {
        return this.category;
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
     * 获得痕迹物证编号
     * 
     * @return 痕迹物证编号
     */
    public String getMaterialEvidenceNo() {
        return this.materialEvidenceNo;
    }

    /**
     * 获得痕迹物证名称
     * 
     * @return 痕迹物证名称
     */
    public String getMaterialEvidenceName() {
        return this.materialEvidenceName;
    }

    /**
     * 获得痕迹物证类型字典名称
     * 
     * @return 痕迹物证类型字典名称
     */
    public String getMaterialEvidenceTypeDict() {
        return this.materialEvidenceTypeDict;
    }

    /**
     * 获得痕迹物证类型代码
     * 
     * @return 痕迹物证类型代码
     */
    public String getMaterialEvidenceType() {
        return this.materialEvidenceType;
    }

    /**
     * 获得痕迹物证编码
     * 
     * @return 痕迹物证编码
     */
    public String getMaterialEvidenceCode() {
        return this.materialEvidenceCode;
    }

    /**
     * 获得痕迹物证推断
     * 
     * @return 痕迹物证推断
     */
    public String getMaterialEvidenceJudgement() {
        return this.materialEvidenceJudgement;
    }

    /**
     * 获得遗留部位
     * 
     * @return 遗留部位
     */
    public String getLeftPosition() {
        return this.leftPosition;
    }

    /**
     * 获得提取方法字典名称
     * 
     * @return 提取方法字典名称
     */
    public String getCollectionModeDict() {
        return this.collectionModeDict;
    }

    /**
     * 获得提取方法代码
     * 
     * @return 提取方法代码
     */
    public String getCollectionMode() {
        return this.collectionMode;
    }

    /**
     * 获得提取日期
     * 
     * @return 提取日期
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
     * 获得枪弹制式(QDZSDM)
     * 
     * @return 枪弹制式(QDZSDM)
     */
    public String getBulletModel() {
        return this.bulletModel;
    }

    /**
     * 获得是否提交专业系统(SFDM)
     * 
     * @return 是否提交专业系统(SFDM)
     */
    public String getStorageFlag() {
        return this.storageFlag;
    }

    /**
     * 获得专业系统状态反馈(ZYXTZTFKDM)
     * 
     * @return 专业系统状态反馈(ZYXTZTFKDM)
     */
    public String getStorageStatus() {
        return this.storageStatus;
    }

    /**
     * 获得是否列入提取物品登记(SFDM)
     * 
     * @return 是否列入提取物品登记(SFDM)
     */
    public String getCollectedFlag() {
        return this.collectedFlag;
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
     * 获得枪支弹药种类（QZDYZLDM）
     * 
     * @return 枪支弹药种类（QZDYZLDM）
     */
    public String getBulletType() {
        return this.bulletType;
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
     * 设置现场痕迹物证类别(XCHJWZLBDM)
     * 
     * @param category 现场痕迹物证类别(XCHJWZLBDM)
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 设置图片ID
     * 
     * @param pictureId 图片ID
     */
    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    /**
     * 设置痕迹物证编号
     * 
     * @param materialEvidenceNo 痕迹物证编号
     */
    public void setMaterialEvidenceNo(String materialEvidenceNo) {
        this.materialEvidenceNo = materialEvidenceNo;
    }

    /**
     * 设置痕迹物证名称
     * 
     * @param materialEvidenceName 痕迹物证名称
     */
    public void setMaterialEvidenceName(String materialEvidenceName) {
        this.materialEvidenceName = materialEvidenceName;
    }

    /**
     * 设置痕迹物证类型字典名称
     * 
     * @param materialEvidenceTypeDict 痕迹物证类型字典名称
     */
    public void setMaterialEvidenceTypeDict(String materialEvidenceTypeDict) {
        this.materialEvidenceTypeDict = materialEvidenceTypeDict;
    }

    /**
     * 设置痕迹物证类型代码
     * 
     * @param materialEvidenceType 痕迹物证类型代码
     */
    public void setMaterialEvidenceType(String materialEvidenceType) {
        this.materialEvidenceType = materialEvidenceType;
    }

    /**
     * 设置痕迹物证编码
     * 
     * @param materialEvidenceCode 痕迹物证编码
     */
    public void setMaterialEvidenceCode(String materialEvidenceCode) {
        this.materialEvidenceCode = materialEvidenceCode;
    }

    /**
     * 设置痕迹物证推断
     * 
     * @param materialEvidenceJudgement 痕迹物证推断
     */
    public void setMaterialEvidenceJudgement(String materialEvidenceJudgement) {
        this.materialEvidenceJudgement = materialEvidenceJudgement;
    }

    /**
     * 设置遗留部位
     * 
     * @param leftPosition 遗留部位
     */
    public void setLeftPosition(String leftPosition) {
        this.leftPosition = leftPosition;
    }

    /**
     * 设置提取方法字典名称
     * 
     * @param collectionModeDict 提取方法字典名称
     */
    public void setCollectionModeDict(String collectionModeDict) {
        this.collectionModeDict = collectionModeDict;
    }

    /**
     * 设置提取方法代码
     * 
     * @param collectionMode 提取方法代码
     */
    public void setCollectionMode(String collectionMode) {
        this.collectionMode = collectionMode;
    }

    /**
     * 设置提取日期
     * 
     * @param collectedTime 提取日期
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
     * 设置枪弹制式(QDZSDM)
     * 
     * @param bulletModel 枪弹制式(QDZSDM)
     */
    public void setBulletModel(String bulletModel) {
        this.bulletModel = bulletModel;
    }

    /**
     * 设置是否提交专业系统(SFDM)
     * 
     * @param storageFlag 是否提交专业系统(SFDM)
     */
    public void setStorageFlag(String storageFlag) {
        this.storageFlag = storageFlag;
    }

    /**
     * 设置专业系统状态反馈(ZYXTZTFKDM)
     * 
     * @param storageStatus 专业系统状态反馈(ZYXTZTFKDM)
     */
    public void setStorageStatus(String storageStatus) {
        this.storageStatus = storageStatus;
    }

    /**
     * 设置是否列入提取物品登记(SFDM)
     * 
     * @param collectedFlag 是否列入提取物品登记(SFDM)
     */
    public void setCollectedFlag(String collectedFlag) {
        this.collectedFlag = collectedFlag;
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
     * 设置枪支弹药种类（QZDYZLDM）
     * 
     * @param bulletType 枪支弹药种类（QZDYZLDM）
     */
    public void setBulletType(String bulletType) {
        this.bulletType = bulletType;
    }

	public String getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getModifyPictureId() {
		return modifyPictureId;
	}

	public void setModifyPictureId(String modifyPictureId) {
		this.modifyPictureId = modifyPictureId;
	}

	public String getModifyAttachmentId() {
		return modifyAttachmentId;
	}

	public void setModifyAttachmentId(String modifyAttachmentId) {
		this.modifyAttachmentId = modifyAttachmentId;
	}


}