/**
 * SceneInvestigationStatusModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 现场勘验信息状态
 *
 * @author ModelGenerator
 */
public class SceneInvestigationStatus extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 是否提交(SFDM)
     */
    private String saveFlag;

    /**
     * 现场第一次提交时间
     */
    private java.util.Date firstSubmitDatetime;

    /**
     * 现场最后一次提交时间
     */
    private java.util.Date lastSubmitDatetime;

    /**
     * 是否制作笔录(SFDM)
     */
    private String noteMadeFlag;

    /**
     * 笔录制作时间
     */
    private java.util.Date noteMadeTime;

    /**
     * 是否采集基站(SFDM)
     */
    private String bsCollectFlag;

    /**
     * 是否允许修改(SFDM)
     */
    private String allowModify;

    /**
     * 允许修改的时间
     */
    private java.util.Date allowModifyTime;

    /**
     * 现场修改的原因
     */
    private String modifyReason;

    /**
     * 现场删除的原因
     */
    private String deleteReason;

    /**
     * 数据来源(SJLYDM)
     */
    private String source;

    /**
     * 是否合格(SFDM)
     */
    private String qualityFlag;

    /**
     * 是否关键接警号(SFDM)
     */
    private String alarmNoFlag;

    /**
     * 是否关键案件号(SFDM)
     */
    private String caseNoFlag;

    /**
     * 接警号、案件号关联时间
     */
    private java.util.Date relateTime;


    /**
     * 获得勘验信息ID
     * 
     * @return 勘验信息ID
     */
    public String getInvestigationId() {
        return this.investigationId;
    }

    /**
     * 获得是否提交(SFDM)
     * 
     * @return 是否提交(SFDM)
     */
    public String getSaveFlag() {
        return this.saveFlag;
    }

    /**
     * 获得现场第一次提交时间
     * 
     * @return 现场第一次提交时间
     */
    public java.util.Date getFirstSubmitDatetime() {
        return this.firstSubmitDatetime;
    }

    /**
     * 获得现场最后一次提交时间
     * 
     * @return 现场最后一次提交时间
     */
    public java.util.Date getLastSubmitDatetime() {
        return this.lastSubmitDatetime;
    }

    /**
     * 获得是否制作笔录(SFDM)
     * 
     * @return 是否制作笔录(SFDM)
     */
    public String getNoteMadeFlag() {
        return this.noteMadeFlag;
    }

    /**
     * 获得笔录制作时间
     * 
     * @return 笔录制作时间
     */
    public java.util.Date getNoteMadeTime() {
        return this.noteMadeTime;
    }

    /**
     * 获得是否采集基站(SFDM)
     * 
     * @return 是否采集基站(SFDM)
     */
    public String getBsCollectFlag() {
        return this.bsCollectFlag;
    }

    /**
     * 获得是否允许修改(SFDM)
     * 
     * @return 是否允许修改(SFDM)
     */
    public String getAllowModify() {
        return this.allowModify;
    }

    /**
     * 获得允许修改的时间
     * 
     * @return 允许修改的时间
     */
    public java.util.Date getAllowModifyTime() {
        return this.allowModifyTime;
    }

    /**
     * 获得现场修改的原因
     * 
     * @return 现场修改的原因
     */
    public String getModifyReason() {
        return this.modifyReason;
    }

    /**
     * 获得现场删除的原因
     * 
     * @return 现场删除的原因
     */
    public String getDeleteReason() {
        return this.deleteReason;
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
     * 获得是否合格(SFDM)
     * 
     * @return 是否合格(SFDM)
     */
    public String getQualityFlag() {
        return this.qualityFlag;
    }

    /**
     * 获得是否关键接警号(SFDM)
     * 
     * @return 是否关键接警号(SFDM)
     */
    public String getAlarmNoFlag() {
        return this.alarmNoFlag;
    }

    /**
     * 获得是否关键案件号(SFDM)
     * 
     * @return 是否关键案件号(SFDM)
     */
    public String getCaseNoFlag() {
        return this.caseNoFlag;
    }

    /**
     * 获得接警号、案件号关联时间
     * 
     * @return 接警号、案件号关联时间
     */
    public java.util.Date getRelateTime() {
        return this.relateTime;
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
     * 设置是否提交(SFDM)
     * 
     * @param saveFlag 是否提交(SFDM)
     */
    public void setSaveFlag(String saveFlag) {
        this.saveFlag = saveFlag;
    }

    /**
     * 设置现场第一次提交时间
     * 
     * @param firstSubmitDatetime 现场第一次提交时间
     */
    public void setFirstSubmitDatetime(java.util.Date firstSubmitDatetime) {
        this.firstSubmitDatetime = firstSubmitDatetime;
    }

    /**
     * 设置现场最后一次提交时间
     * 
     * @param lastSubmitDatetime 现场最后一次提交时间
     */
    public void setLastSubmitDatetime(java.util.Date lastSubmitDatetime) {
        this.lastSubmitDatetime = lastSubmitDatetime;
    }

    /**
     * 设置是否制作笔录(SFDM)
     * 
     * @param noteMadeFlag 是否制作笔录(SFDM)
     */
    public void setNoteMadeFlag(String noteMadeFlag) {
        this.noteMadeFlag = noteMadeFlag;
    }

    /**
     * 设置笔录制作时间
     * 
     * @param noteMadeTime 笔录制作时间
     */
    public void setNoteMadeTime(java.util.Date noteMadeTime) {
        this.noteMadeTime = noteMadeTime;
    }

    /**
     * 设置是否采集基站(SFDM)
     * 
     * @param bsCollectFlag 是否采集基站(SFDM)
     */
    public void setBsCollectFlag(String bsCollectFlag) {
        this.bsCollectFlag = bsCollectFlag;
    }

    /**
     * 设置是否允许修改(SFDM)
     * 
     * @param allowModify 是否允许修改(SFDM)
     */
    public void setAllowModify(String allowModify) {
        this.allowModify = allowModify;
    }

    /**
     * 设置允许修改的时间
     * 
     * @param allowModifyTime 允许修改的时间
     */
    public void setAllowModifyTime(java.util.Date allowModifyTime) {
        this.allowModifyTime = allowModifyTime;
    }

    /**
     * 设置现场修改的原因
     * 
     * @param modifyReason 现场修改的原因
     */
    public void setModifyReason(String modifyReason) {
        this.modifyReason = modifyReason;
    }

    /**
     * 设置现场删除的原因
     * 
     * @param deleteReason 现场删除的原因
     */
    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
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
     * 设置是否合格(SFDM)
     * 
     * @param qualityFlag 是否合格(SFDM)
     */
    public void setQualityFlag(String qualityFlag) {
        this.qualityFlag = qualityFlag;
    }

    /**
     * 设置是否关键接警号(SFDM)
     * 
     * @param alarmNoFlag 是否关键接警号(SFDM)
     */
    public void setAlarmNoFlag(String alarmNoFlag) {
        this.alarmNoFlag = alarmNoFlag;
    }

    /**
     * 设置是否关键案件号(SFDM)
     * 
     * @param caseNoFlag 是否关键案件号(SFDM)
     */
    public void setCaseNoFlag(String caseNoFlag) {
        this.caseNoFlag = caseNoFlag;
    }

    /**
     * 设置接警号、案件号关联时间
     * 
     * @param relateTime 接警号、案件号关联时间
     */
    public void setRelateTime(java.util.Date relateTime) {
        this.relateTime = relateTime;
    }

}