/**
 * OrganizationModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.system;

import com.hisign.xcky.api.model.common.BaseModel;


/**
 * 单位信息
 *
 * @author ModelGenerator
 */
public class Organization extends BaseModel {

    /**
     * 单位信息ID
     */
    private String id;

    /**
     * 上级单位ID
     */
    private String parentId;

    /**
     * 单位名称
     */
    private String organName;

    /**
     * 单位简称
     */
    private String shortenedName;

    /**
     * 单位代码
     */
    private String regionalism;

    /**
     * 文书代号
     */
    private String paperPrefix;

    /**
     * 单位地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 单位类型(DWLXDM)
     */
    private String oType;

    /**
     * 是否科室(SFDM)
     */
    private String officeFlag;

    /**
     * 是否启用(SFDM)
     */
    private String openFlag;

    /**
     * 删除标识(SFDM)
     */
    private String deleteFlag;

    /**
     * 前端映射用 对应字段ID
     */
    private String key;
    
    /**
     * 前端映射用 对应字段ORGAN_NAME
     */
    private String value;
    
    /**
     * 前端映射用 对应字段PARENT_ID
     */
    private String parentKey;
    
    /**
     * 获得单位信息ID
     * 
     * @return 单位信息ID
     */
    public String getId() {
        return this.id;
    }

    /**
     * 获得上级单位ID
     * 
     * @return 上级单位ID
     */
    public String getParentId() {
        return this.parentId;
    }

    /**
     * 获得单位名称
     * 
     * @return 单位名称
     */
    public String getOrganName() {
        return this.organName;
    }

    /**
     * 获得单位简称
     * 
     * @return 单位简称
     */
    public String getShortenedName() {
        return this.shortenedName;
    }

    /**
     * 获得单位代码
     * 
     * @return 单位代码
     */
    public String getRegionalism() {
        return this.regionalism;
    }

    /**
     * 获得文书代号
     * 
     * @return 文书代号
     */
    public String getPaperPrefix() {
        return this.paperPrefix;
    }

    /**
     * 获得单位地址
     * 
     * @return 单位地址
     */
    public String getAddress() {
        return this.address;
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
     * 获得单位类型(DWLXDM)
     * 
     * @return 单位类型(DWLXDM)
     */
    public String getOType() {
        return this.oType;
    }

    /**
     * 获得是否科室(SFDM)
     * 
     * @return 是否科室(SFDM)
     */
    public String getOfficeFlag() {
        return this.officeFlag;
    }

    /**
     * 获得是否启用(SFDM)
     * 
     * @return 是否启用(SFDM)
     */
    public String getOpenFlag() {
        return this.openFlag;
    }

    /**
     * 获得删除标识(SFDM)
     * 
     * @return 删除标识(SFDM)
     */
    public String getDeleteFlag() {
        return this.deleteFlag;
    }

    /**
     * 设置单位信息ID
     * 
     * @param id 单位信息ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 设置上级单位ID
     * 
     * @param parentId 上级单位ID
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 设置单位名称
     * 
     * @param organName 单位名称
     */
    public void setOrganName(String organName) {
        this.organName = organName;
    }

    /**
     * 设置单位简称
     * 
     * @param shortenedName 单位简称
     */
    public void setShortenedName(String shortenedName) {
        this.shortenedName = shortenedName;
    }

    /**
     * 设置单位代码
     * 
     * @param regionalism 单位代码
     */
    public void setRegionalism(String regionalism) {
        this.regionalism = regionalism;
    }

    /**
     * 设置文书代号
     * 
     * @param paperPrefix 文书代号
     */
    public void setPaperPrefix(String paperPrefix) {
        this.paperPrefix = paperPrefix;
    }

    /**
     * 设置单位地址
     * 
     * @param address 单位地址
     */
    public void setAddress(String address) {
        this.address = address;
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
     * 设置单位类型(DWLXDM)
     * 
     * @param oType 单位类型(DWLXDM)
     */
    public void setOType(String oType) {
        this.oType = oType;
    }

    /**
     * 设置是否科室(SFDM)
     * 
     * @param officeFlag 是否科室(SFDM)
     */
    public void setOfficeFlag(String officeFlag) {
        this.officeFlag = officeFlag;
    }

    /**
     * 设置是否启用(SFDM)
     * 
     * @param openFlag 是否启用(SFDM)
     */
    public void setOpenFlag(String openFlag) {
        this.openFlag = openFlag;
    }

    /**
     * 设置删除标识(SFDM)
     * 
     * @param deleteFlag 删除标识(SFDM)
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

	public String getoType() {
		return oType;
	}

	public void setoType(String oType) {
		this.oType = oType;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getParentKey() {
		return parentKey;
	}

	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}

}