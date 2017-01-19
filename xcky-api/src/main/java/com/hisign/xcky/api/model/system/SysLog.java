/**
 * SysLogModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hisign.xcky.api.model.common.BaseModel;

import java.util.Date;

/**
 * 系统日志信息
 *
 * @author ModelGenerator
 */
public class SysLog extends BaseModel {

    /**
     * 日志信息ID
     */
    private String id;

    /**
     * 操作类型(CZLXDM)
     */
    private String optType;

    /**
     * 操作时间
     */
    private java.util.Date optTime;

    /**
     * 操作时间开始

     */
    private java.util.Date optTimeBegin;

    /**
     * 操作时间结束
     */
    private java.util.Date optTimeEnd;

    public Date getOptTimeEnd() {
        return optTimeEnd;
    }

    public void setOptTimeEnd(Date optTimeEnd) {
        this.optTimeEnd = optTimeEnd;
    }

    public Date getOptTimeBegin() {
        return optTimeBegin;
    }

    public void setOptTimeBegin(Date optTimeBegin) {
        this.optTimeBegin = optTimeBegin;
    }

    /**
     * 操作用户
     */
    private String optUser;

    /**
     * 操作用户ID
     */
    private String optUserId;

    /**
     * 操作用户IP
     */
    private String optUserIp;

    /**
     * 操作数据表
     */
    private String optTable;

    /**
     * 操作数据ID
     */
    private String optDataId;

    /**
     * 操作描述
     */
    private String optDesc;

    /**
     * rest请求地址
     */
    private String optUrl;

    /**
     * 获得日志信息ID
     * 
     * @return 日志信息ID
     */
    public String getId() {
        return this.id;
    }

    /**
     * 获得操作类型(CZLXDM)
     * 
     * @return 操作类型(CZLXDM)
     */
    public String getOptType() {
        return this.optType;
    }

    /**
     * 获得操作时间
     * 
     * @return 操作时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public java.util.Date getOptTime() {
        return this.optTime;
    }

    /**
     * 获得操作用户
     * 
     * @return 操作用户
     */
    public String getOptUser() {
        return this.optUser;
    }

    /**
     * 获得操作用户ID
     * 
     * @return 操作用户ID
     */
    public String getOptUserId() {
        return this.optUserId;
    }

    /**
     * 获得操作用户IP
     * 
     * @return 操作用户IP
     */
    public String getOptUserIp() {
        return this.optUserIp;
    }

    /**
     * 获得操作数据表
     * 
     * @return 操作数据表
     */
    public String getOptTable() {
        return this.optTable;
    }

    /**
     * 获得操作数据ID
     * 
     * @return 操作数据ID
     */
    public String getOptDataId() {
        return this.optDataId;
    }

    /**
     * 获得操作描述
     * 
     * @return 操作描述
     */
    public String getOptDesc() {
        return this.optDesc;
    }


    /**
     * 设置日志信息ID
     * 
     * @param id 日志信息ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 设置操作类型(CZLXDM)
     * 
     * @param optType 操作类型(CZLXDM)
     */
    public void setOptType(String optType) {
        this.optType = optType;
    }

    /**
     * 设置操作时间
     * 
     * @param optTime 操作时间
     */
    public void setOptTime(java.util.Date optTime) {
        this.optTime = optTime;
    }

    /**
     * 设置操作用户
     * 
     * @param optUser 操作用户
     */
    public void setOptUser(String optUser) {
        this.optUser = optUser;
    }

    /**
     * 设置操作用户ID
     * 
     * @param optUserId 操作用户ID
     */
    public void setOptUserId(String optUserId) {
        this.optUserId = optUserId;
    }

    /**
     * 设置操作用户IP
     * 
     * @param optUserIp 操作用户IP
     */
    public void setOptUserIp(String optUserIp) {
        this.optUserIp = optUserIp;
    }

    /**
     * 设置操作数据表
     * 
     * @param optTable 操作数据表
     */
    public void setOptTable(String optTable) {
        this.optTable = optTable;
    }

    /**
     * 设置操作数据ID
     * 
     * @param optDataId 操作数据ID
     */
    public void setOptDataId(String optDataId) {
        this.optDataId = optDataId;
    }

    /**
     * 设置操作描述
     * 
     * @param optDesc 操作描述
     */
    public void setOptDesc(String optDesc) {
        this.optDesc = optDesc;
    }

	public String getOptUrl() {
		return optUrl;
	}

	public void setOptUrl(String optUrl) {
		this.optUrl = optUrl;
	}
    

}