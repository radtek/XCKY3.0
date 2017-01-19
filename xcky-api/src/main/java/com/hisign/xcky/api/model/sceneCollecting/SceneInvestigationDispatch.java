/**
 * SceneInvestigationDispatchModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 现场接勘信息
 *
 * @author ModelGenerator
 */
public class SceneInvestigationDispatch extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 接警编号
     */
    private String alarmNo;

    /**
     * 接警受理号
     */
    private String alarmAcceptNo;

    /**
     * 接警时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
    @JSONField (format="yyyy-MM-dd HH:mm")
    private java.util.Date alarmTime;

    /**
     * 接警人
     */
    private String alarmReceiver;

    /**
     * 指派/报告单位
     */
    private String assignPerson;

    /**
     * 指派方式(XCKYJJFSDM)
     */
    private String assignMethod;

    /**
     * 指派方式描述
     */
    private String assignMethodDesc;

    /**
     * 勘验事由
     */
    private String assignReason;

    /**
     * 出警时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
    @JSONField (format="yyyy-MM-dd HH:mm")
    private java.util.Date dispatchTime;

    /**
     * 案件编号
     */
    private String caseNo;

    /**
     * 案件类别(AJLBDM)
     */
    private String caseType;

    /**
     * 案件性质(AJXZDM)
     */
    private String caseNature;

    /**
     * 案件名称
     */
    private String caseName;

    /**
     * 简要案情(案件发现过程)
     */
    private String caseBrief;

    /**
     * 发案区划(关联单位表)
     */
    private String caseRegionalism;

    /**
     * 发案地点
     */
    private String caseLocation;

    /**
     * 经度
     */
    private Double caseLon;

    /**
     * 纬度
     */
    private Double caseLat;

    /**
     * 发案开始时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
    @JSONField (format="yyyy-MM-dd HH:mm") 
    private java.util.Date crimeTimeBegin;

    /**
     * 发案结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
    @JSONField (format="yyyy-MM-dd HH:mm")
    private java.util.Date crimeTimeEnd;

    /**
     * 是否命案
     */
    private String murderFlag;

    /**
     * 是否刑案
     */
    private String criminalFlag;

    /**
     * 受伤人数
     */
    private Integer woundedAmount;

    /**
     * 死亡人数
     */
    private Integer deadAmount;

    /**
     * 是否关联警综系统(SFDM)
     */
    private String alarmSystemRelateFlag;

    /**
     * 警综系统案件信息ID
     */
    private String alarmSystemId;

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
     * 获得接警编号
     * 
     * @return 接警编号
     */
    public String getAlarmNo() {
        return this.alarmNo;
    }

    /**
     * 获得接警受理号
     * 
     * @return 接警受理号
     */
    public String getAlarmAcceptNo() {
        return this.alarmAcceptNo;
    }

    /**
     * 获得接警时间
     * 
     * @return 接警时间
     */
    public java.util.Date getAlarmTime() {
        return this.alarmTime;
    }

    /**
     * 获得接警人
     * 
     * @return 接警人
     */
    public String getAlarmReceiver() {
        return this.alarmReceiver;
    }

    /**
     * 获得指派/报告单位
     * 
     * @return 指派/报告单位
     */
    public String getAssignPerson() {
        return this.assignPerson;
    }

    /**
     * 获得指派方式(XCKYJJFSDM)
     * 
     * @return 指派方式(XCKYJJFSDM)
     */
    public String getAssignMethod() {
        return this.assignMethod;
    }

    /**
     * 获得指派方式描述
     * 
     * @return 指派方式描述
     */
    public String getAssignMethodDesc() {
        return this.assignMethodDesc;
    }

    /**
     * 获得勘验事由
     * 
     * @return 勘验事由
     */
    public String getAssignReason() {
        return this.assignReason;
    }

    /**
     * 获得出警时间
     * 
     * @return 出警时间
     */
    public java.util.Date getDispatchTime() {
        return this.dispatchTime;
    }

    /**
     * 获得案件编号
     * 
     * @return 案件编号
     */
    public String getCaseNo() {
        return this.caseNo;
    }

    /**
     * 获得案件类别(AJLBDM)
     * 
     * @return 案件类别(AJLBDM)
     */
    public String getCaseType() {
        return this.caseType;
    }

    /**
     * 获得案件性质(AJXZDM)
     * 
     * @return 案件性质(AJXZDM)
     */
    public String getCaseNature() {
        return this.caseNature;
    }

    /**
     * 获得案件名称
     * 
     * @return 案件名称
     */
    public String getCaseName() {
        return this.caseName;
    }

    /**
     * 获得简要案情(案件发现过程)
     * 
     * @return 简要案情(案件发现过程)
     */
    public String getCaseBrief() {
        return this.caseBrief;
    }

    /**
     * 获得发案区划(关联单位表)
     * 
     * @return 发案区划(关联单位表)
     */
    public String getCaseRegionalism() {
        return this.caseRegionalism;
    }

    /**
     * 获得发案地点
     * 
     * @return 发案地点
     */
    public String getCaseLocation() {
        return this.caseLocation;
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
     * 获得发案开始时间
     * 
     * @return 发案开始时间
     */
    public java.util.Date getCrimeTimeBegin() {
        return this.crimeTimeBegin;
    }

    /**
     * 获得发案结束时间
     * 
     * @return 发案结束时间
     */
    public java.util.Date getCrimeTimeEnd() {
        return this.crimeTimeEnd;
    }

    /**
     * 获得是否命案
     * 
     * @return 是否命案
     */
    public String getMurderFlag() {
        return this.murderFlag;
    }

    /**
     * 获得是否刑案
     * 
     * @return 是否刑案
     */
    public String getCriminalFlag() {
        return this.criminalFlag;
    }

    /**
     * 获得受伤人数
     * 
     * @return 受伤人数
     */
    public Integer getWoundedAmount() {
        return this.woundedAmount;
    }

    /**
     * 获得死亡人数
     * 
     * @return 死亡人数
     */
    public Integer getDeadAmount() {
        return this.deadAmount;
    }

    /**
     * 获得是否关联警综系统(SFDM)
     * 
     * @return 是否关联警综系统(SFDM)
     */
    public String getAlarmSystemRelateFlag() {
        return this.alarmSystemRelateFlag;
    }

    /**
     * 获得警综系统案件信息ID
     * 
     * @return 警综系统案件信息ID
     */
    public String getAlarmSystemId() {
        return this.alarmSystemId;
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
     * 设置接警编号
     * 
     * @param alarmNo 接警编号
     */
    public void setAlarmNo(String alarmNo) {
        this.alarmNo = alarmNo;
    }

    /**
     * 设置接警受理号
     * 
     * @param alarmAcceptNo 接警受理号
     */
    public void setAlarmAcceptNo(String alarmAcceptNo) {
        this.alarmAcceptNo = alarmAcceptNo;
    }

    /**
     * 设置接警时间
     * 
     * @param alarmTime 接警时间
     */
    public void setAlarmTime(java.util.Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    /**
     * 设置接警人
     * 
     * @param alarmReceiver 接警人
     */
    public void setAlarmReceiver(String alarmReceiver) {
        this.alarmReceiver = alarmReceiver;
    }

    /**
     * 设置指派/报告单位
     * 
     * @param assignPerson 指派/报告单位
     */
    public void setAssignPerson(String assignPerson) {
        this.assignPerson = assignPerson;
    }

    /**
     * 设置指派方式(XCKYJJFSDM)
     * 
     * @param assignMethod 指派方式(XCKYJJFSDM)
     */
    public void setAssignMethod(String assignMethod) {
        this.assignMethod = assignMethod;
    }

    /**
     * 设置指派方式描述
     * 
     * @param assignMethodDesc 指派方式描述
     */
    public void setAssignMethodDesc(String assignMethodDesc) {
        this.assignMethodDesc = assignMethodDesc;
    }

    /**
     * 设置勘验事由
     * 
     * @param assignReason 勘验事由
     */
    public void setAssignReason(String assignReason) {
        this.assignReason = assignReason;
    }

    /**
     * 设置出警时间
     * 
     * @param dispatchTime 出警时间
     */
    public void setDispatchTime(java.util.Date dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    /**
     * 设置案件编号
     * 
     * @param caseNo 案件编号
     */
    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    /**
     * 设置案件类别(AJLBDM)
     * 
     * @param caseType 案件类别(AJLBDM)
     */
    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    /**
     * 设置案件性质(AJXZDM)
     * 
     * @param caseNature 案件性质(AJXZDM)
     */
    public void setCaseNature(String caseNature) {
        this.caseNature = caseNature;
    }

    /**
     * 设置案件名称
     * 
     * @param caseName 案件名称
     */
    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    /**
     * 设置简要案情(案件发现过程)
     * 
     * @param caseBrief 简要案情(案件发现过程)
     */
    public void setCaseBrief(String caseBrief) {
        this.caseBrief = caseBrief;
    }

    /**
     * 设置发案区划(关联单位表)
     * 
     * @param caseRegionalism 发案区划(关联单位表)
     */
    public void setCaseRegionalism(String caseRegionalism) {
        this.caseRegionalism = caseRegionalism;
    }

    /**
     * 设置发案地点
     * 
     * @param caseLocation 发案地点
     */
    public void setCaseLocation(String caseLocation) {
        this.caseLocation = caseLocation;
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
     * 设置发案开始时间
     * 
     * @param crimeTimeBegin 发案开始时间
     */
    public void setCrimeTimeBegin(java.util.Date crimeTimeBegin) {
        this.crimeTimeBegin = crimeTimeBegin;
    }

    /**
     * 设置发案结束时间
     * 
     * @param crimeTimeEnd 发案结束时间
     */
    public void setCrimeTimeEnd(java.util.Date crimeTimeEnd) {
        this.crimeTimeEnd = crimeTimeEnd;
    }

    /**
     * 设置是否命案
     * 
     * @param murderFlag 是否命案
     */
    public void setMurderFlag(String murderFlag) {
        this.murderFlag = murderFlag;
    }

    /**
     * 设置是否刑案
     * 
     * @param criminalFlag 是否刑案
     */
    public void setCriminalFlag(String criminalFlag) {
        this.criminalFlag = criminalFlag;
    }

    /**
     * 设置受伤人数
     * 
     * @param woundedAmount 受伤人数
     */
    public void setWoundedAmount(Integer woundedAmount) {
        this.woundedAmount = woundedAmount;
    }

    /**
     * 设置死亡人数
     * 
     * @param deadAmount 死亡人数
     */
    public void setDeadAmount(Integer deadAmount) {
        this.deadAmount = deadAmount;
    }

    /**
     * 设置是否关联警综系统(SFDM)
     * 
     * @param alarmSystemRelateFlag 是否关联警综系统(SFDM)
     */
    public void setAlarmSystemRelateFlag(String alarmSystemRelateFlag) {
        this.alarmSystemRelateFlag = alarmSystemRelateFlag;
    }

    /**
     * 设置警综系统案件信息ID
     * 
     * @param alarmSystemId 警综系统案件信息ID
     */
    public void setAlarmSystemId(String alarmSystemId) {
        this.alarmSystemId = alarmSystemId;
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