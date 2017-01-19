/**
 * SysParameterModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.system;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 系统参数配置
 *
 * @author ModelGenerator
 */
public class SysParameter extends BaseModel {

    /**
     * 参数名
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 键
     */
    private String key;

    /**
     * 值
     */
    private String value;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否显示(SFDM)
     */
    private String showFlag;

    /**
     * 允许修改(SFDM)
     */
    private String allowModify;

    /**
     * 参数类型
     */
    private String paramType;
    
    /**
     * 字典代码
     */
    private String dictType;

    /**
     * 获得参数名
     * 
     * @return 参数名
     */
    public String getName() {
        return this.name;
    }

    /**
     * 获得类型
     * 
     * @return 类型
     */
    public String getType() {
        return this.type;
    }

    /**
     * 获得键
     * 
     * @return 键
     */
    public String getKey() {
        return this.key;
    }

    /**
     * 获得值
     * 
     * @return 值
     */
    public String getValue() {
        return this.value;
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
     * 获得是否显示(SFDM)
     * 
     * @return 是否显示(SFDM)
     */
    public String getShowFlag() {
        return this.showFlag;
    }

    /**
     * 获得允许修改(SFDM)
     * 
     * @return 允许修改(SFDM)
     */
    public String getAllowModify() {
        return this.allowModify;
    }

    /**
     * 获得参数类型
     * 
     * @return 参数类型
     */
    public String getParamType() {
        return this.paramType;
    }


    /**
     * 设置参数名
     * 
     * @param name 参数名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设置类型
     * 
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 设置键
     * 
     * @param key 键
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 设置值
     * 
     * @param value 值
     */
    public void setValue(String value) {
        this.value = value;
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
     * 设置是否显示(SFDM)
     * 
     * @param showFlag 是否显示(SFDM)
     */
    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
    }

    /**
     * 设置允许修改(SFDM)
     * 
     * @param allowModify 允许修改(SFDM)
     */
    public void setAllowModify(String allowModify) {
        this.allowModify = allowModify;
    }

    /**
     * 设置参数类型
     * 
     * @param paramType 参数类型
     */
    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

    
    
}