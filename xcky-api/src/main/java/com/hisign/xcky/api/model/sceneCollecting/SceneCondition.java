/**
 * SceneConditionModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 现场条件信息
 *
 * @author ModelGenerator
 */
public class SceneCondition extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 现场保护人_姓名
     */
    private String protector;

    /**
     * 现场保护人_单位
     */
    private String protectorOrgan;

    /**
     * 现场保护人_职务
     */
    private String protectorDuty;

    /**
     * 现场保护时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm")
    private java.util.Date protectionDate;

    /**
     * 现场物品翻动程度(FDWPCDDM)
     */
    private String overturnDegree;

    /**
     * 现场保护措施(BHCSDM)
     */
    private String protectionMeasure;

    /**
     * 现场保护措施描述
     */
    private String protectionMeasureDesc;

    /**
     * 温度
     */
    private Double envTemperature;

    /**
     * 湿度
     */
    private Double envMoistness;

    /**
     * 现场风向(XCFXDM)
     */
    private String wind;

    /**
     * 现场天气(XCKYTQQKDM)
     */
    private String weather;

    /**
     * 现场条件(XCTJDM)
     */
    private String sceneCondition;

    /**
     * 现场光照条件(XCKYGZTJDM)
     */
    private String lighting;

    /**
     * 数据来源(SJLYDM)
     */
    private String source;
    /**
     * 现场变动原因（BDYYDM）
     */
    private String changeReason;
    
    /**
     * 现场变动原因描述
     */
    private String changeReasonDesc;
    

    /**
     * 获得勘验信息ID
     * 
     * @return 勘验信息ID
     */
    public String getInvestigationId() {
        return this.investigationId;
    }

    /**
     * 获得现场保护人_姓名
     * 
     * @return 现场保护人_姓名
     */
    public String getProtector() {
        return this.protector;
    }

    /**
     * 获得现场保护人_单位
     * 
     * @return 现场保护人_单位
     */
    public String getProtectorOrgan() {
        return this.protectorOrgan;
    }

    /**
     * 获得现场保护人_职务
     * 
     * @return 现场保护人_职务
     */
    public String getProtectorDuty() {
        return this.protectorDuty;
    }

    /**
     * 获得现场保护时间
     * 
     * @return 现场保护时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public java.util.Date getProtectionDate() {
        return this.protectionDate;
    }

    /**
     * 获得现场物品翻动程度(FDWPCDDM)
     * 
     * @return 现场物品翻动程度(FDWPCDDM)
     */
    public String getOverturnDegree() {
        return this.overturnDegree;
    }

    /**
     * 获得现场保护措施(BHCSDM)
     * 
     * @return 现场保护措施(BHCSDM)
     */
    public String getProtectionMeasure() {
        return this.protectionMeasure;
    }

    /**
     * 获得现场保护措施描述
     * 
     * @return 现场保护措施描述
     */
    public String getProtectionMeasureDesc() {
        return this.protectionMeasureDesc;
    }

    /**
     * 获得温度
     * 
     * @return 温度
     */
    public Double getEnvTemperature() {
        return this.envTemperature;
    }

    /**
     * 获得湿度
     * 
     * @return 湿度
     */
    public Double getEnvMoistness() {
        return this.envMoistness;
    }

    /**
     * 获得现场风向(XCFXDM)
     * 
     * @return 现场风向(XCFXDM)
     */
    public String getWind() {
        return this.wind;
    }

    /**
     * 获得现场天气(XCKYTQQKDM)
     * 
     * @return 现场天气(XCKYTQQKDM)
     */
    public String getWeather() {
        return this.weather;
    }

    /**
     * 获得现场条件(XCTJDM)
     * 
     * @return 现场条件(XCTJDM)
     */
    public String getSceneCondition() {
        return this.sceneCondition;
    }

    /**
     * 获得现场光照条件(XCKYGZTJDM)
     * 
     * @return 现场光照条件(XCKYGZTJDM)
     */
    public String getLighting() {
        return this.lighting;
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
     * 设置现场保护人_姓名
     * 
     * @param protector 现场保护人_姓名
     */
    public void setProtector(String protector) {
        this.protector = protector;
    }

    /**
     * 设置现场保护人_单位
     * 
     * @param protectorOrgan 现场保护人_单位
     */
    public void setProtectorOrgan(String protectorOrgan) {
        this.protectorOrgan = protectorOrgan;
    }

    /**
     * 设置现场保护人_职务
     * 
     * @param protectorDuty 现场保护人_职务
     */
    public void setProtectorDuty(String protectorDuty) {
        this.protectorDuty = protectorDuty;
    }

    /**
     * 设置现场保护时间
     * 
     * @param protectionDate 现场保护时间
     */
    public void setProtectionDate(java.util.Date protectionDate) {
        this.protectionDate = protectionDate;
    }

    /**
     * 设置现场物品翻动程度(FDWPCDDM)
     * 
     * @param overturnDegree 现场物品翻动程度(FDWPCDDM)
     */
    public void setOverturnDegree(String overturnDegree) {
        this.overturnDegree = overturnDegree;
    }

    /**
     * 设置现场保护措施(BHCSDM)
     * 
     * @param protectionMeasure 现场保护措施(BHCSDM)
     */
    public void setProtectionMeasure(String protectionMeasure) {
        this.protectionMeasure = protectionMeasure;
    }

    /**
     * 设置现场保护措施描述
     * 
     * @param protectionMeasureDesc 现场保护措施描述
     */
    public void setProtectionMeasureDesc(String protectionMeasureDesc) {
        this.protectionMeasureDesc = protectionMeasureDesc;
    }

    /**
     * 设置温度
     * 
     * @param envTemperature 温度
     */
    public void setEnvTemperature(Double envTemperature) {
        this.envTemperature = envTemperature;
    }

    /**
     * 设置湿度
     * 
     * @param envMoistness 湿度
     */
    public void setEnvMoistness(Double envMoistness) {
        this.envMoistness = envMoistness;
    }

    /**
     * 设置现场风向(XCFXDM)
     * 
     * @param wind 现场风向(XCFXDM)
     */
    public void setWind(String wind) {
        this.wind = wind;
    }

    /**
     * 设置现场天气(XCKYTQQKDM)
     * 
     * @param weather 现场天气(XCKYTQQKDM)
     */
    public void setWeather(String weather) {
        this.weather = weather;
    }

    /**
     * 设置现场条件(XCTJDM)
     * 
     * @param sceneCondition 现场条件(XCTJDM)
     */
    public void setSceneCondition(String sceneCondition) {
        this.sceneCondition = sceneCondition;
    }

    /**
     * 设置现场光照条件(XCKYGZTJDM)
     * 
     * @param lighting 现场光照条件(XCKYGZTJDM)
     */
    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    /**
     * 设置数据来源(SJLYDM)
     * 
     * @param source 数据来源(SJLYDM)
     */
    public void setSource(String source) {
        this.source = source;
    }

	public String getChangeReason() {
		return changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

	public String getChangeReasonDesc() {
		return changeReasonDesc;
	}

	public void setChangeReasonDesc(String changeReasonDesc) {
		this.changeReasonDesc = changeReasonDesc;
	}
}