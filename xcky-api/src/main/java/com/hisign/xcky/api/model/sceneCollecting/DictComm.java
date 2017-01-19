/**
 * DictCommModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.alibaba.fastjson.annotation.JSONField;
import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 常用字典信息
 *
 * @author ModelGenerator
 */
public class DictComm extends BaseModel {


	/**
     * 字典ID
     */
    private String dictId;

    /**
     * 字典类型
     */
    private String dictType;
    /**
     * 字典值
     */
	private String dictKey;
	/**
	 * 中文显示值
	 */
	private String dictValue;
	
    /**
     * 案件类型(AJLXDM)
     */
    private String caseType;

    /**
     * 获得字典ID
     * 
     * @return 字典ID
     */
    public String getDictId() {
        return this.dictId;
    }

    /**
     * 获得字典类型
     * 
     * @return 字典类型
     */
    public String getDictType() {
        return this.dictType;
    }

    /**
     * 设置字典ID
     * 
     * @param dictId 字典ID
     */
    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    /**
     * 设置字典类型
     * 
     * @param dictType 字典类型
     */
    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

	public String getDictKey() {
		return dictKey;
	}

	public void setDictKey(String dictKey) {
		this.dictKey = dictKey;
	}

	public String getDictValue() {
		return dictValue;
	}

	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}

	public String getCaseType() {
		return caseType;
	}

	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	
}