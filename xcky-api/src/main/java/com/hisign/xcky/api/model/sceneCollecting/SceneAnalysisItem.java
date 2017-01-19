/**
 * SceneAnalysisItemModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 现场分析意见项目
 *
 * @author ModelGenerator
 */
public class SceneAnalysisItem extends BaseModel {

    /**
     * 分析意见ID
     */
    private String analysisId;

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 分析意见项目
     */
    private String itemType;

    /**
     * 分析意见项目字典名称
     */
    private String itemDictType;

    /**
     * 分析意见项目字典代码
     */
    private String itemKey;

    /**
     * 数据来源(SJLYDM)
     */
    private String source;


    /**
     * 获得分析意见ID
     * 
     * @return 分析意见ID
     */
    public String getAnalysisId() {
        return this.analysisId;
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
     * 获得分析意见项目
     * 
     * @return 分析意见项目
     */
    public String getItemType() {
        return this.itemType;
    }

    /**
     * 获得分析意见项目字典名称
     * 
     * @return 分析意见项目字典名称
     */
    public String getItemDictType() {
        return this.itemDictType;
    }

    /**
     * 获得分析意见项目字典代码
     * 
     * @return 分析意见项目字典代码
     */
    public String getItemKey() {
        return this.itemKey;
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
     * 设置分析意见ID
     * 
     * @param analysisId 分析意见ID
     */
    public void setAnalysisId(String analysisId) {
        this.analysisId = analysisId;
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
     * 设置分析意见项目
     * 
     * @param itemType 分析意见项目
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     * 设置分析意见项目字典名称
     * 
     * @param itemDictType 分析意见项目字典名称
     */
    public void setItemDictType(String itemDictType) {
        this.itemDictType = itemDictType;
    }

    /**
     * 设置分析意见项目字典代码
     * 
     * @param itemKey 分析意见项目字典代码
     */
    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
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