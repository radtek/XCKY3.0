/**
 * SceneAnalysisSuggestionModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 现场分析意见
 *
 * @author ModelGenerator
 */
public class SceneAnalysisSuggestion extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 作案地点
     */
    private String commissionPlace;

    /**
     * 作案过程
     */
    private String commissionDesc;

    /**
     * 作案人特点
     */
    private String criminalPoints;

    /**
     * 串并意见与根据
     */
    private String bunchReason;

    /**
     * 工作建议之痕迹物证的保管
     */
    private String suggestion1;

    /**
     * 工作建议之现场处置意见
     */
    private String suggestion2;

    /**
     * 工作建议之侦查方向与范围
     */
    private String suggestion3;

    /**
     * 工作建议之技术防范对策
     */
    private String suggestion4;

    /**
     * 工作建议之其他
     */
    private String suggestion6;

    /**
     * 分析单位
     */
    private String analysisOrgan;

    /**
     * 分析人
     */
    private String analysisPerson;

    /**
     * 分析时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm")
    private java.util.Date analysisTime;

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
     * 获得作案地点
     * 
     * @return 作案地点
     */
    public String getCommissionPlace() {
        return this.commissionPlace;
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
     * 获得串并意见与根据
     * 
     * @return 串并意见与根据
     */
    public String getBunchReason() {
        return this.bunchReason;
    }

    /**
     * 获得工作建议之痕迹物证的保管
     * 
     * @return 工作建议之痕迹物证的保管
     */
    public String getSuggestion1() {
        return this.suggestion1;
    }

    /**
     * 获得工作建议之现场处置意见
     * 
     * @return 工作建议之现场处置意见
     */
    public String getSuggestion2() {
        return this.suggestion2;
    }

    /**
     * 获得工作建议之侦查方向与范围
     * 
     * @return 工作建议之侦查方向与范围
     */
    public String getSuggestion3() {
        return this.suggestion3;
    }

    /**
     * 获得工作建议之技术防范对策
     * 
     * @return 工作建议之技术防范对策
     */
    public String getSuggestion4() {
        return this.suggestion4;
    }

    /**
     * 获得工作建议之其他
     * 
     * @return 工作建议之其他
     */
    public String getSuggestion6() {
        return this.suggestion6;
    }

    /**
     * 获得分析单位
     * 
     * @return 分析单位
     */
    public String getAnalysisOrgan() {
        return this.analysisOrgan;
    }

    /**
     * 获得分析人
     * 
     * @return 分析人
     */
    public String getAnalysisPerson() {
        return this.analysisPerson;
    }

    /**
     * 获得分析时间
     * 
     * @return 分析时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public java.util.Date getAnalysisTime() {
        return this.analysisTime;
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
     * 设置作案地点
     * 
     * @param commissionPlace 作案地点
     */
    public void setCommissionPlace(String commissionPlace) {
        this.commissionPlace = commissionPlace;
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
     * 设置串并意见与根据
     * 
     * @param bunchReason 串并意见与根据
     */
    public void setBunchReason(String bunchReason) {
        this.bunchReason = bunchReason;
    }

    /**
     * 设置工作建议之痕迹物证的保管
     * 
     * @param suggestion1 工作建议之痕迹物证的保管
     */
    public void setSuggestion1(String suggestion1) {
        this.suggestion1 = suggestion1;
    }

    /**
     * 设置工作建议之现场处置意见
     * 
     * @param suggestion2 工作建议之现场处置意见
     */
    public void setSuggestion2(String suggestion2) {
        this.suggestion2 = suggestion2;
    }

    /**
     * 设置工作建议之侦查方向与范围
     * 
     * @param suggestion3 工作建议之侦查方向与范围
     */
    public void setSuggestion3(String suggestion3) {
        this.suggestion3 = suggestion3;
    }

    /**
     * 设置工作建议之技术防范对策
     * 
     * @param suggestion4 工作建议之技术防范对策
     */
    public void setSuggestion4(String suggestion4) {
        this.suggestion4 = suggestion4;
    }

    /**
     * 设置工作建议之其他
     * 
     * @param suggestion6 工作建议之其他
     */
    public void setSuggestion6(String suggestion6) {
        this.suggestion6 = suggestion6;
    }

    /**
     * 设置分析单位
     * 
     * @param analysisOrgan 分析单位
     */
    public void setAnalysisOrgan(String analysisOrgan) {
        this.analysisOrgan = analysisOrgan;
    }

    /**
     * 设置分析人
     * 
     * @param analysisPerson 分析人
     */
    public void setAnalysisPerson(String analysisPerson) {
        this.analysisPerson = analysisPerson;
    }

    /**
     * 设置分析时间
     * 
     * @param analysisTime 分析时间
     */
    public void setAnalysisTime(java.util.Date analysisTime) {
        this.analysisTime = analysisTime;
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