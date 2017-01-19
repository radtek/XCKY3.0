/**
 * SceneCrimeToolsModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 作案工具
 *
 * @author ModelGenerator
 */
public class SceneCrimeTools extends BaseModel {

    /**
     * 分析意见ID
     */
    private String analysisId;

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 作案工具类目(ZAGJLMDM)
     */
    private String species;

    /**
     * 作案工具名称
     */
    private String name;

    /**
     * 作案工具来源(ZAGJLYDM)
     */
    private String origin;

    /**
     * 作案工具描述
     */
    private String description;

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
     * 获得作案工具类目(ZAGJLMDM)
     * 
     * @return 作案工具类目(ZAGJLMDM)
     */
    public String getSpecies() {
        return this.species;
    }

    /**
     * 获得作案工具名称
     * 
     * @return 作案工具名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 获得作案工具来源(ZAGJLYDM)
     * 
     * @return 作案工具来源(ZAGJLYDM)
     */
    public String getOrigin() {
        return this.origin;
    }

    /**
     * 获得作案工具描述
     * 
     * @return 作案工具描述
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
     * 设置作案工具类目(ZAGJLMDM)
     * 
     * @param species 作案工具类目(ZAGJLMDM)
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * 设置作案工具名称
     * 
     * @param name 作案工具名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设置作案工具来源(ZAGJLYDM)
     * 
     * @param origin 作案工具来源(ZAGJLYDM)
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * 设置作案工具描述
     * 
     * @param description 作案工具描述
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

}