/**
 * SceneBodyBasicModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 尸体基本信息
 *
 * @author ModelGenerator
 */
public class SceneBodyBasic extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 尸检编号
     */
    private String examinationNo;

    /**
     * 委托单位
     */
    private String consignedAgency;

    /**
     * 委托时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm")
    private java.util.Date consignedDate;

    /**
     * 委托人
     */
    private String consignedBy;

    /**
     * 联系电话
     */
    private String consignerPhone;

    /**
     * 检验单位
     */
    private String examinedAgency;

    /**
     * 检验日期
     */
    private java.util.Date examinedDate;

    /**
     * 检验人
     */
    private String examinedBy;

    /**
     * 检验地点
     */
    private String examinedPlace;

    /**
     * 姓名
     */
    private String name;

    /**
     * 是否确定身源(SFDM)
     */
    private String originStatus;

    /**
     * 性别(XBDM)
     */
    private String sex;

    /**
     * 出生日期
     */
    private java.util.Date birthDate;

    /**
     * 民族(MZDM)
     */
    private String folk;

    /**
     * 国籍(GJDM)
     */
    private String nationality;

    /**
     * 户籍地区划(XZQHDM)
     */
    private String nativePlaceRegionalism;

    /**
     * 户籍地详址
     */
    private String nativePlace;

    /**
     * 现住址区划(XZQHDM)
     */
    private String addressRegionalism;

    /**
     * 现住址详址
     */
    private String address;

    /**
     * 服务处所
     */
    private String organization;

    /**
     * 体表特殊标记
     */
    private String specialSign;

    /**
     * 死亡时间推断（起）
     */
    private java.util.Date deathDateFrom;

    /**
     * 死亡时间推断（止）
     */
    private java.util.Date deathDateTo;

    /**
     * 简要案情
     */
    private String caseSummary;

    /**
     * 尸体姿态
     */
    private String gesture;

    /**
     * 衣着情况
     */
    private String clothes;

    /**
     * 随身物品
     */
    private String takenWith;

    /**
     * 致死原因
     */
    private String deathReason;

    /**
     * 死亡性质
     */
    private String deathProperty;

    /**
     * 尸体加害形式
     */
    private String inflictManner;

    /**
     * 缢勒颈方式
     */
    private String strangleholdManner;

    /**
     * 人员窒息症像
     */
    private String chokeSymptom;

    /**
     * 盛装物名称
     */
    private String encasedBy;

    /**
     * 包裹物名称
     */
    private String packagedBy;

    /**
     * 尸表检验意见
     */
    private String surfaceExamOpinion;

    /**
     * 解剖检验意见
     */
    private String dissectionExamOpinion;

    /**
     * 备注
     */
    private String remark;

    /**
     * 检验开始日期
     */
    private java.util.Date examinedDateup;

    /**
     * 检验结束日期
     */
    private java.util.Date examinedDatedown;

    /**
     * 尸体发现地点情况
     */
    private String stfxddqk;

    /**
     * 尸体位置
     */
    private String stwz;

    /**
     * 现场血迹情况
     */
    private String xcxjqk;

    /**
     * 现场周围环境概况
     */
    private String xczwhjgk;

    /**
     * 家属是否同意解剖
     */
    private String familyComment;

    /**
     * 数据来源(SJLYDM)
     */
    private String source;

    /**
     * 尸体报告Id
     */
    private String reportid;
    
    /**
     * 尸体报告附件路径
     */
    private String reportAttachmentId;

    /**
     * 获得勘验信息ID
     * 
     * @return 勘验信息ID
     */
    public String getInvestigationId() {
        return this.investigationId;
    }

    /**
     * 获得尸检编号
     * 
     * @return 尸检编号
     */
    public String getExaminationNo() {
        return this.examinationNo;
    }

    /**
     * 获得委托单位
     * 
     * @return 委托单位
     */
    public String getConsignedAgency() {
        return this.consignedAgency;
    }

    /**
     * 获得委托时间
     * 
     * @return 委托时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public java.util.Date getConsignedDate() {
        return this.consignedDate;
    }

    /**
     * 获得委托人
     * 
     * @return 委托人
     */
    public String getConsignedBy() {
        return this.consignedBy;
    }

    /**
     * 获得联系电话
     * 
     * @return 联系电话
     */
    public String getConsignerPhone() {
        return this.consignerPhone;
    }

    /**
     * 获得检验单位
     * 
     * @return 检验单位
     */
    public String getExaminedAgency() {
        return this.examinedAgency;
    }

    /**
     * 获得检验日期
     * 
     * @return 检验日期
     */
    public java.util.Date getExaminedDate() {
        return this.examinedDate;
    }

    /**
     * 获得检验人
     * 
     * @return 检验人
     */
    public String getExaminedBy() {
        return this.examinedBy;
    }

    /**
     * 获得检验地点
     * 
     * @return 检验地点
     */
    public String getExaminedPlace() {
        return this.examinedPlace;
    }

    /**
     * 获得姓名
     * 
     * @return 姓名
     */
    public String getName() {
        return this.name;
    }

    /**
     * 获得是否确定身源(SFDM)
     * 
     * @return 是否确定身源(SFDM)
     */
    public String getOriginStatus() {
        return this.originStatus;
    }

    /**
     * 获得性别(XBDM)
     * 
     * @return 性别(XBDM)
     */
    public String getSex() {
        return this.sex;
    }

    /**
     * 获得出生日期
     * 
     * @return 出生日期
     */
    public java.util.Date getBirthDate() {
        return this.birthDate;
    }

    /**
     * 获得民族(MZDM)
     * 
     * @return 民族(MZDM)
     */
    public String getFolk() {
        return this.folk;
    }

    /**
     * 获得国籍(GJDM)
     * 
     * @return 国籍(GJDM)
     */
    public String getNationality() {
        return this.nationality;
    }

    /**
     * 获得户籍地区划(XZQHDM)
     * 
     * @return 户籍地区划(XZQHDM)
     */
    public String getNativePlaceRegionalism() {
        return this.nativePlaceRegionalism;
    }

    /**
     * 获得户籍地详址
     * 
     * @return 户籍地详址
     */
    public String getNativePlace() {
        return this.nativePlace;
    }

    /**
     * 获得现住址区划(XZQHDM)
     * 
     * @return 现住址区划(XZQHDM)
     */
    public String getAddressRegionalism() {
        return this.addressRegionalism;
    }

    /**
     * 获得现住址详址
     * 
     * @return 现住址详址
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * 获得服务处所
     * 
     * @return 服务处所
     */
    public String getOrganization() {
        return this.organization;
    }

    /**
     * 获得体表特殊标记
     * 
     * @return 体表特殊标记
     */
    public String getSpecialSign() {
        return this.specialSign;
    }

    /**
     * 获得死亡时间推断（起）
     * 
     * @return 死亡时间推断（起）
     */
    public java.util.Date getDeathDateFrom() {
        return this.deathDateFrom;
    }

    /**
     * 获得死亡时间推断（止）
     * 
     * @return 死亡时间推断（止）
     */
    public java.util.Date getDeathDateTo() {
        return this.deathDateTo;
    }

    /**
     * 获得简要案情
     * 
     * @return 简要案情
     */
    public String getCaseSummary() {
        return this.caseSummary;
    }

    /**
     * 获得尸体姿态
     * 
     * @return 尸体姿态
     */
    public String getGesture() {
        return this.gesture;
    }

    /**
     * 获得衣着情况
     * 
     * @return 衣着情况
     */
    public String getClothes() {
        return this.clothes;
    }

    /**
     * 获得随身物品
     * 
     * @return 随身物品
     */
    public String getTakenWith() {
        return this.takenWith;
    }

    /**
     * 获得致死原因
     * 
     * @return 致死原因
     */
    public String getDeathReason() {
        return this.deathReason;
    }

    /**
     * 获得死亡性质
     * 
     * @return 死亡性质
     */
    public String getDeathProperty() {
        return this.deathProperty;
    }

    /**
     * 获得尸体加害形式
     * 
     * @return 尸体加害形式
     */
    public String getInflictManner() {
        return this.inflictManner;
    }

    /**
     * 获得缢勒颈方式
     * 
     * @return 缢勒颈方式
     */
    public String getStrangleholdManner() {
        return this.strangleholdManner;
    }

    /**
     * 获得人员窒息症像
     * 
     * @return 人员窒息症像
     */
    public String getChokeSymptom() {
        return this.chokeSymptom;
    }

    /**
     * 获得盛装物名称
     * 
     * @return 盛装物名称
     */
    public String getEncasedBy() {
        return this.encasedBy;
    }

    /**
     * 获得包裹物名称
     * 
     * @return 包裹物名称
     */
    public String getPackagedBy() {
        return this.packagedBy;
    }

    /**
     * 获得尸表检验意见
     * 
     * @return 尸表检验意见
     */
    public String getSurfaceExamOpinion() {
        return this.surfaceExamOpinion;
    }

    /**
     * 获得解剖检验意见
     * 
     * @return 解剖检验意见
     */
    public String getDissectionExamOpinion() {
        return this.dissectionExamOpinion;
    }

    /**
     * 获得备注
     * 
     * @return 备注
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * 获得检验开始日期
     * 
     * @return 检验开始日期
     */
    public java.util.Date getExaminedDateup() {
        return this.examinedDateup;
    }

    /**
     * 获得检验结束日期
     * 
     * @return 检验结束日期
     */
    public java.util.Date getExaminedDatedown() {
        return this.examinedDatedown;
    }

    /**
     * 获得尸体发现地点情况
     * 
     * @return 尸体发现地点情况
     */
    public String getStfxddqk() {
        return this.stfxddqk;
    }

    /**
     * 获得尸体位置
     * 
     * @return 尸体位置
     */
    public String getStwz() {
        return this.stwz;
    }

    /**
     * 获得现场血迹情况
     * 
     * @return 现场血迹情况
     */
    public String getXcxjqk() {
        return this.xcxjqk;
    }

    /**
     * 获得现场周围环境概况
     * 
     * @return 现场周围环境概况
     */
    public String getXczwhjgk() {
        return this.xczwhjgk;
    }

    /**
     * 获得家属是否同意解剖
     * 
     * @return 家属是否同意解剖
     */
    public String getFamilyComment() {
        return this.familyComment;
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
     * 获得尸体报告Id
     * 
     * @return 尸体报告Id
     */
    public String getReportid() {
        return this.reportid;
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
     * 设置尸检编号
     * 
     * @param examinationNo 尸检编号
     */
    public void setExaminationNo(String examinationNo) {
        this.examinationNo = examinationNo;
    }

    /**
     * 设置委托单位
     * 
     * @param consignedAgency 委托单位
     */
    public void setConsignedAgency(String consignedAgency) {
        this.consignedAgency = consignedAgency;
    }

    /**
     * 设置委托时间
     * 
     * @param consignedDate 委托时间
     */
    public void setConsignedDate(java.util.Date consignedDate) {
        this.consignedDate = consignedDate;
    }

    /**
     * 设置委托人
     * 
     * @param consignedBy 委托人
     */
    public void setConsignedBy(String consignedBy) {
        this.consignedBy = consignedBy;
    }

    /**
     * 设置联系电话
     * 
     * @param consignerPhone 联系电话
     */
    public void setConsignerPhone(String consignerPhone) {
        this.consignerPhone = consignerPhone;
    }

    /**
     * 设置检验单位
     * 
     * @param examinedAgency 检验单位
     */
    public void setExaminedAgency(String examinedAgency) {
        this.examinedAgency = examinedAgency;
    }

    /**
     * 设置检验日期
     * 
     * @param examinedDate 检验日期
     */
    public void setExaminedDate(java.util.Date examinedDate) {
        this.examinedDate = examinedDate;
    }

    /**
     * 设置检验人
     * 
     * @param examinedBy 检验人
     */
    public void setExaminedBy(String examinedBy) {
        this.examinedBy = examinedBy;
    }

    /**
     * 设置检验地点
     * 
     * @param examinedPlace 检验地点
     */
    public void setExaminedPlace(String examinedPlace) {
        this.examinedPlace = examinedPlace;
    }

    /**
     * 设置姓名
     * 
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设置是否确定身源(SFDM)
     * 
     * @param originStatus 是否确定身源(SFDM)
     */
    public void setOriginStatus(String originStatus) {
        this.originStatus = originStatus;
    }

    /**
     * 设置性别(XBDM)
     * 
     * @param sex 性别(XBDM)
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 设置出生日期
     * 
     * @param birthDate 出生日期
     */
    public void setBirthDate(java.util.Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 设置民族(MZDM)
     * 
     * @param folk 民族(MZDM)
     */
    public void setFolk(String folk) {
        this.folk = folk;
    }

    /**
     * 设置国籍(GJDM)
     * 
     * @param nationality 国籍(GJDM)
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * 设置户籍地区划(XZQHDM)
     * 
     * @param nativePlaceRegionalism 户籍地区划(XZQHDM)
     */
    public void setNativePlaceRegionalism(String nativePlaceRegionalism) {
        this.nativePlaceRegionalism = nativePlaceRegionalism;
    }

    /**
     * 设置户籍地详址
     * 
     * @param nativePlace 户籍地详址
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    /**
     * 设置现住址区划(XZQHDM)
     * 
     * @param addressRegionalism 现住址区划(XZQHDM)
     */
    public void setAddressRegionalism(String addressRegionalism) {
        this.addressRegionalism = addressRegionalism;
    }

    /**
     * 设置现住址详址
     * 
     * @param address 现住址详址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 设置服务处所
     * 
     * @param organization 服务处所
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * 设置体表特殊标记
     * 
     * @param specialSign 体表特殊标记
     */
    public void setSpecialSign(String specialSign) {
        this.specialSign = specialSign;
    }

    /**
     * 设置死亡时间推断（起）
     * 
     * @param deathDateFrom 死亡时间推断（起）
     */
    public void setDeathDateFrom(java.util.Date deathDateFrom) {
        this.deathDateFrom = deathDateFrom;
    }

    /**
     * 设置死亡时间推断（止）
     * 
     * @param deathDateTo 死亡时间推断（止）
     */
    public void setDeathDateTo(java.util.Date deathDateTo) {
        this.deathDateTo = deathDateTo;
    }

    /**
     * 设置简要案情
     * 
     * @param caseSummary 简要案情
     */
    public void setCaseSummary(String caseSummary) {
        this.caseSummary = caseSummary;
    }

    /**
     * 设置尸体姿态
     * 
     * @param gesture 尸体姿态
     */
    public void setGesture(String gesture) {
        this.gesture = gesture;
    }

    /**
     * 设置衣着情况
     * 
     * @param clothes 衣着情况
     */
    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    /**
     * 设置随身物品
     * 
     * @param takenWith 随身物品
     */
    public void setTakenWith(String takenWith) {
        this.takenWith = takenWith;
    }

    /**
     * 设置致死原因
     * 
     * @param deathReason 致死原因
     */
    public void setDeathReason(String deathReason) {
        this.deathReason = deathReason;
    }

    /**
     * 设置死亡性质
     * 
     * @param deathProperty 死亡性质
     */
    public void setDeathProperty(String deathProperty) {
        this.deathProperty = deathProperty;
    }

    /**
     * 设置尸体加害形式
     * 
     * @param inflictManner 尸体加害形式
     */
    public void setInflictManner(String inflictManner) {
        this.inflictManner = inflictManner;
    }

    /**
     * 设置缢勒颈方式
     * 
     * @param strangleholdManner 缢勒颈方式
     */
    public void setStrangleholdManner(String strangleholdManner) {
        this.strangleholdManner = strangleholdManner;
    }

    /**
     * 设置人员窒息症像
     * 
     * @param chokeSymptom 人员窒息症像
     */
    public void setChokeSymptom(String chokeSymptom) {
        this.chokeSymptom = chokeSymptom;
    }

    /**
     * 设置盛装物名称
     * 
     * @param encasedBy 盛装物名称
     */
    public void setEncasedBy(String encasedBy) {
        this.encasedBy = encasedBy;
    }

    /**
     * 设置包裹物名称
     * 
     * @param packagedBy 包裹物名称
     */
    public void setPackagedBy(String packagedBy) {
        this.packagedBy = packagedBy;
    }

    /**
     * 设置尸表检验意见
     * 
     * @param surfaceExamOpinion 尸表检验意见
     */
    public void setSurfaceExamOpinion(String surfaceExamOpinion) {
        this.surfaceExamOpinion = surfaceExamOpinion;
    }

    /**
     * 设置解剖检验意见
     * 
     * @param dissectionExamOpinion 解剖检验意见
     */
    public void setDissectionExamOpinion(String dissectionExamOpinion) {
        this.dissectionExamOpinion = dissectionExamOpinion;
    }

    /**
     * 设置备注
     * 
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 设置检验开始日期
     * 
     * @param examinedDateup 检验开始日期
     */
    public void setExaminedDateup(java.util.Date examinedDateup) {
        this.examinedDateup = examinedDateup;
    }

    /**
     * 设置检验结束日期
     * 
     * @param examinedDatedown 检验结束日期
     */
    public void setExaminedDatedown(java.util.Date examinedDatedown) {
        this.examinedDatedown = examinedDatedown;
    }

    /**
     * 设置尸体发现地点情况
     * 
     * @param stfxddqk 尸体发现地点情况
     */
    public void setStfxddqk(String stfxddqk) {
        this.stfxddqk = stfxddqk;
    }

    /**
     * 设置尸体位置
     * 
     * @param stwz 尸体位置
     */
    public void setStwz(String stwz) {
        this.stwz = stwz;
    }

    /**
     * 设置现场血迹情况
     * 
     * @param xcxjqk 现场血迹情况
     */
    public void setXcxjqk(String xcxjqk) {
        this.xcxjqk = xcxjqk;
    }

    /**
     * 设置现场周围环境概况
     * 
     * @param xczwhjgk 现场周围环境概况
     */
    public void setXczwhjgk(String xczwhjgk) {
        this.xczwhjgk = xczwhjgk;
    }

    /**
     * 设置家属是否同意解剖
     * 
     * @param familyComment 家属是否同意解剖
     */
    public void setFamilyComment(String familyComment) {
        this.familyComment = familyComment;
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
     * 设置尸体报告Id
     * 
     * @param reportid 尸体报告Id
     */
    public void setReportid(String reportid) {
        this.reportid = reportid;
    }

	public String getReportAttachmentId() {
		return reportAttachmentId;
	}

	public void setReportAttachmentId(String reportAttachmentId) {
		this.reportAttachmentId = reportAttachmentId;
	}

    
}