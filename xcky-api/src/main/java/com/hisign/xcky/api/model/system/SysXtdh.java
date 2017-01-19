/**
 * SysXtdhModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.system;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 系统导航信息表
 *
 * @author ModelGenerator
 */
public class SysXtdh extends BaseModel {

    /**
     * 系统名称
     */
    private String systemName;

    /**
     * 系统代号
     */
    private String systemCode;

    /**
     * 系统部署单位
     */
    private String systemUnit;

    /**
     * 系统部署单位中文
     */
    private String systemCunit;

    /**
     * 系统链接地址
     */
    private String systemAddr;

    /**
     * 排序
     */
    private String sort;

    /**
     * 照片
     */
    private byte[] photo;

    /**
     * 是否单点登录
     */
    private String ifLogin;

    /**
     * 是否警号
     */
    private String ifJh;

    /**
     * 警号参数
     */
    private String jhPara;

    /**
     * 是否身份证号
     */
    private String ifSfzh;

    /**
     * 身份证号参数
     */
    private String sfzhPara;

    /**
     * 获得系统名称
     * 
     * @return 系统名称
     */
    public String getSystemName() {
        return this.systemName;
    }

    /**
     * 获得系统代号
     * 
     * @return 系统代号
     */
    public String getSystemCode() {
        return this.systemCode;
    }

    /**
     * 获得系统部署单位
     * 
     * @return 系统部署单位
     */
    public String getSystemUnit() {
        return this.systemUnit;
    }

    /**
     * 获得系统部署单位中文
     * 
     * @return 系统部署单位中文
     */
    public String getSystemCunit() {
        return this.systemCunit;
    }

    /**
     * 获得系统链接地址
     * 
     * @return 系统链接地址
     */
    public String getSystemAddr() {
        return this.systemAddr;
    }

    /**
     * 获得排序
     * 
     * @return 排序
     */
    public String getSort() {
        return this.sort;
    }

    /**
     * 获得是否单点登录
     * 
     * @return 是否单点登录
     */
    public String getIfLogin() {
        return this.ifLogin;
    }

    /**
     * 获得是否警号
     * 
     * @return 是否警号
     */
    public String getIfJh() {
        return this.ifJh;
    }

    /**
     * 获得警号参数
     * 
     * @return 警号参数
     */
    public String getJhPara() {
        return this.jhPara;
    }

    /**
     * 获得是否身份证号
     * 
     * @return 是否身份证号
     */
    public String getIfSfzh() {
        return this.ifSfzh;
    }

    /**
     * 获得身份证号参数
     * 
     * @return 身份证号参数
     */
    public String getSfzhPara() {
        return this.sfzhPara;
    }

    /**
     * 设置系统名称
     * 
     * @param systemName 系统名称
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    /**
     * 设置系统代号
     * 
     * @param systemCode 系统代号
     */
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    /**
     * 设置系统部署单位
     * 
     * @param systemUnit 系统部署单位
     */
    public void setSystemUnit(String systemUnit) {
        this.systemUnit = systemUnit;
    }

    /**
     * 设置系统部署单位中文
     * 
     * @param systemCunit 系统部署单位中文
     */
    public void setSystemCunit(String systemCunit) {
        this.systemCunit = systemCunit;
    }

    /**
     * 设置系统链接地址
     * 
     * @param systemAddr 系统链接地址
     */
    public void setSystemAddr(String systemAddr) {
        this.systemAddr = systemAddr;
    }

    /**
     * 设置排序
     * 
     * @param sort 排序
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * 设置是否单点登录
     * 
     * @param ifLogin 是否单点登录
     */
    public void setIfLogin(String ifLogin) {
        this.ifLogin = ifLogin;
    }

    /**
     * 设置是否警号
     * 
     * @param ifJh 是否警号
     */
    public void setIfJh(String ifJh) {
        this.ifJh = ifJh;
    }

    /**
     * 设置警号参数
     * 
     * @param jhPara 警号参数
     */
    public void setJhPara(String jhPara) {
        this.jhPara = jhPara;
    }

    /**
     * 设置是否身份证号
     * 
     * @param ifSfzh 是否身份证号
     */
    public void setIfSfzh(String ifSfzh) {
        this.ifSfzh = ifSfzh;
    }

    /**
     * 设置身份证号参数
     * 
     * @param sfzhPara 身份证号参数
     */
    public void setSfzhPara(String sfzhPara) {
        this.sfzhPara = sfzhPara;
    }

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}