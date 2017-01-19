/**
 * SceneCollectedPersonModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 物品、物证提取人信息
 *
 * @author ModelGenerator
 */
public class SceneCollectedPerson extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 痕迹物证ID
     */
    private String materialEvidenceId;

    /**
     * 提取类别(1-痕迹物证,2-提取物品)
     */
    private String collectedType;

    /**
     * 提取人ID
     */
    private String collectedPersonId;

    /**
     * 提取人姓名
     */
    private String collectedPerson;

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
     * 获得痕迹物证ID
     * 
     * @return 痕迹物证ID
     */
    public String getMaterialEvidenceId() {
        return this.materialEvidenceId;
    }

    /**
     * 获得提取类别(1-痕迹物证,2-提取物品)
     * 
     * @return 提取类别(1-痕迹物证,2-提取物品)
     */
    public String getCollectedType() {
        return this.collectedType;
    }

    /**
     * 获得提取人ID
     * 
     * @return 提取人ID
     */
    public String getCollectedPersonId() {
        return this.collectedPersonId;
    }

    /**
     * 获得提取人姓名
     * 
     * @return 提取人姓名
     */
    public String getCollectedPerson() {
        return this.collectedPerson;
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
     * 设置痕迹物证ID
     * 
     * @param materialEvidenceId 痕迹物证ID
     */
    public void setMaterialEvidenceId(String materialEvidenceId) {
        this.materialEvidenceId = materialEvidenceId;
    }

    /**
     * 设置提取类别(1-痕迹物证,2-提取物品)
     * 
     * @param collectedType 提取类别(1-痕迹物证,2-提取物品)
     */
    public void setCollectedType(String collectedType) {
        this.collectedType = collectedType;
    }

    /**
     * 设置提取人ID
     * 
     * @param collectedPersonId 提取人ID
     */
    public void setCollectedPersonId(String collectedPersonId) {
        this.collectedPersonId = collectedPersonId;
    }

    /**
     * 设置提取人姓名
     * 
     * @param collectedPerson 提取人姓名
     */
    public void setCollectedPerson(String collectedPerson) {
        this.collectedPerson = collectedPerson;
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