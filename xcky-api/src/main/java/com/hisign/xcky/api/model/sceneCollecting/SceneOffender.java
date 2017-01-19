/**
 * SceneOffenderModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 现场涉案人员信息
 *
 * @author ModelGenerator
 */
public class SceneOffender extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 人员类别(RYLBDM)
     */
    private String type;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别(XBDM)
     */
    private String gender;

    /**
     * 性别中文显示
     */
    private String sex;
    
    /**
     * 出生年月
     */
    @JSONField (format="yyyy-MM-dd HH:mm")
    private java.util.Date birthday;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 现住址详址
     */
    private String address;

    /**
     * 户籍地详址
     */
    private String nativePlace;

    /**
     * 身份证号
     */
    private String idCardNo;

    /**
     * 单位
     */
    private String organization;

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
     * 获得人员类别(RYLBDM)
     * 
     * @return 人员类别(RYLBDM)
     */
    public String getType() {
        return this.type;
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
     * 获得性别(XBDM)
     * 
     * @return 性别(XBDM)
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * 获得出生年月
     * 
     * @return 出生年月
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public java.util.Date getBirthday() {
        return this.birthday;
    }

    /**
     * 获得年龄
     * 
     * @return 年龄
     */
    public Integer getAge() {
        return this.age;
    }

    /**
     * 获得联系电话
     * 
     * @return 联系电话
     */
    public String getPhone() {
        return this.phone;
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
     * 获得户籍地详址
     * 
     * @return 户籍地详址
     */
    public String getNativePlace() {
        return this.nativePlace;
    }

    /**
     * 获得身份证号
     * 
     * @return 身份证号
     */
    public String getIdCardNo() {
        return this.idCardNo;
    }

    /**
     * 获得单位
     * 
     * @return 单位
     */
    public String getOrganization() {
        return this.organization;
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
     * 设置人员类别(RYLBDM)
     * 
     * @param type 人员类别(RYLBDM)
     */
    public void setType(String type) {
        this.type = type;
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
     * 设置性别(XBDM)
     * 
     * @param gender 性别(XBDM)
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 设置出生年月
     * 
     * @param birthday 出生年月
     */
    public void setBirthday(java.util.Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 设置年龄
     * 
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 设置联系电话
     * 
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
     * 设置户籍地详址
     * 
     * @param nativePlace 户籍地详址
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    /**
     * 设置身份证号
     * 
     * @param idCardNo 身份证号
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    /**
     * 设置单位
     * 
     * @param organization 单位
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * 设置数据来源(SJLYDM)
     * 
     * @param source 数据来源(SJLYDM)
     */
    public void setSource(String source) {
        this.source = source;
    }

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}