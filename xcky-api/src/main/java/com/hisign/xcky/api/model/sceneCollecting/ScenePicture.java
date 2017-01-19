/**
 * ScenePictureModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 现场图、现场照片信息
 *
 * @author ModelGenerator
 */
public class ScenePicture extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 图片类别(1-现场图,2-现场照片)
     */
    private String category;

    /**
     * 图片ID
     */
    private String pictureId;

    /**
     * 图片类型字典
     */
    private String pictureTypeDict;

    /**
     * 图片类型代码
     */
    private String pictureType;

    /**
     * 原始文件附件ID
     */
    private String attachmentId;

    /**
     * 描述
     */
    private String description;

    /**
     * 数据来源(SJLYDM)
     */
    private String source;
    
    /**
     * 图片类型字典
     */
    private String pictureTypeCn;


    /**
     * 获得勘验信息ID
     * 
     * @return 勘验信息ID
     */
    public String getInvestigationId() {
        return this.investigationId;
    }

    /**
     * 获得图片类别(1-现场图,2-现场照片)
     * 
     * @return 图片类别(1-现场图,2-现场照片)
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
     * 获得图片类型字典
     * 
     * @return 图片类型字典
     */
    public String getPictureTypeDict() {
        return this.pictureTypeDict;
    }

    /**
     * 获得图片类型代码
     * 
     * @return 图片类型代码
     */
    public String getPictureType() {
        return this.pictureType;
    }

    /**
     * 获得原始文件附件ID
     * 
     * @return 原始文件附件ID
     */
    public String getAttachmentId() {
        return this.attachmentId;
    }

    /**
     * 获得描述
     * 
     * @return 描述
     */
    public String getDescription() {
        return this.description;
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
     * 设置勘验信息ID
     * 
     * @param investigationId 勘验信息ID
     */
    public void setInvestigationId(String investigationId) {
        this.investigationId = investigationId;
    }

    /**
     * 设置图片类别(1-现场图,2-现场照片)
     * 
     * @param category 图片类别(1-现场图,2-现场照片)
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
     * 设置图片类型字典
     * 
     * @param pictureTypeDict 图片类型字典
     */
    public void setPictureTypeDict(String pictureTypeDict) {
        this.pictureTypeDict = pictureTypeDict;
    }

    /**
     * 设置图片类型代码
     * 
     * @param pictureType 图片类型代码
     */
    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
    }

    /**
     * 设置原始文件附件ID
     * 
     * @param attachmentId 原始文件附件ID
     */
    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    /**
     * 设置描述
     * 
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 设置数据来源(SJLYDM)
     * 
     * @param source 数据来源(SJLYDM)
     */
    public void setSource(String source) {
        this.source = source;
    }

	public String getPictureTypeCn() {
		return pictureTypeCn;
	}

	public void setPictureTypeCn(String pictureTypeCn) {
		this.pictureTypeCn = pictureTypeCn;
	}

}