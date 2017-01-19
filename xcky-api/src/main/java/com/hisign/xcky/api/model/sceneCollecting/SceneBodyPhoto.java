/**
 * SceneBodyPhotoModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 尸体照片信息
 *
 * @author ModelGenerator
 */
public class SceneBodyPhoto extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 尸体信息ID
     */
    private String bodyId;

    /**
     * 图片ID
     */
    private String pictureId;

    /**
     * 序号
     */
    private Integer serialNo;

    /**
     * 类型
     */
    private String type;

    /**
     * 名称
     */
    private String name;

    /**
     * 数据来源(SJLYDM)
     */
    private String source;


    /**
     * 获得勘验信息ID
     * 
     * @return 勘验信息ID
     */
    public String getInvestigationId() {
        return this.investigationId;
    }

    /**
     * 获得尸体信息ID
     * 
     * @return 尸体信息ID
     */
    public String getBodyId() {
        return this.bodyId;
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
     * 获得序号
     * 
     * @return 序号
     */
    public Integer getSerialNo() {
        return this.serialNo;
    }

    /**
     * 获得类型
     * 
     * @return 类型
     */
    public String getType() {
        return this.type;
    }

    /**
     * 获得名称
     * 
     * @return 名称
     */
    public String getName() {
        return this.name;
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
     * 设置尸体信息ID
     * 
     * @param bodyId 尸体信息ID
     */
    public void setBodyId(String bodyId) {
        this.bodyId = bodyId;
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
     * 设置序号
     * 
     * @param serialNo 序号
     */
    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 设置类型
     * 
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 设置名称
     * 
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设置数据来源(SJLYDM)
     * 
     * @param source 数据来源(SJLYDM)
     */
    public void setSource(String source) {
        this.source = source;
    }

}