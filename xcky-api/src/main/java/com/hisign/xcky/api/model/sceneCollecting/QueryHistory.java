/**
 * QueryHistoryModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 历史查询条件
 *
 * @author ModelGenerator
 */
public class QueryHistory extends BaseModel {

    /**
     * 查询条件类型(CXTJLXDM)
     */
    private String queryType;

    /**
     * 查询条件内容
     */
    private String queryContent;
    
    /**
     * 名称
     */
    private String queryName;

    /**
     * 备注
     */
    private String remark;    

    /**
     * 数据来源(SJLYDM)
     */
    private String source;


    /**
     * 获得查询条件类型(CXTJLXDM)
     * 
     * @return 查询条件类型(CXTJLXDM)
     */
    public String getQueryType() {
        return this.queryType;
    }

    /**
     * 获得查询条件内容
     * 
     * @return 查询条件内容
     */
    public String getQueryContent() {
        return this.queryContent;
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
     * 设置查询条件类型(CXTJLXDM)
     * 
     * @param queryType 查询条件类型(CXTJLXDM)
     */
    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    /**
     * 设置查询条件内容
     * 
     * @param queryContent 查询条件内容
     */
    public void setQueryContent(String queryContent) {
        this.queryContent = queryContent;
    }

    /**
     * 设置数据来源(SJLYDM)
     * 
     * @param source 数据来源(SJLYDM)
     */
    public void setSource(String source) {
        this.source = source;
    }

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
    
    

}