/**
 * WitnessHistoryModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 历史见证人信息
 *
 * @author ModelGenerator
 */
public class WitnessHistory extends BaseModel {

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别(XBDM)
     */
    private String gender;

    /**
     * 出生年月
     */
    
    private java.util.Date birthday;

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
    @JsonFormat(pattern="yyyy-MM-dd", timezone="GMT+8")
    public java.util.Date getBirthday() {
        return this.birthday;
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

}