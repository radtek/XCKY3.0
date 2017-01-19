/**
 * SysOnlineLogModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.system;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hisign.xcky.api.model.common.BaseModel;
import com.hisign.xcky.common.CustomDateSerializer;


/**
 * 系统登录日志信息
 *
 * @author ModelGenerator
 */
public class SysOnlineLog extends BaseModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2065946554656464991L;

	/**
     * 日志信息ID
     */
    private String id;

    /**
     * 登录令牌
     */
    private String loginToken;

    /**
     * 操作用户
     */
    private String loginUser;

    /**
     * 操作用户ID
     */
    private String loginUserId;

    /**
     * 操作用户IP
     */
    private String loginUserIp;

    /**
     * 登录时间
     */
    private java.util.Date loginTime;
    
    /**
     * 登录时间开始
     */
    private java.util.Date loginTimeBegin;
    
    /**
     * 登录时间结束
     */
    private java.util.Date loginTimeEnd;

    /**
     * 登出时间
     */
    private java.util.Date logoutTime;


    /**
     * 获得日志信息ID
     * 
     * @return 日志信息ID
     */
    public String getId() {
        return this.id;
    }

    /**
     * 获得登录令牌
     * 
     * @return 登录令牌
     */
    public String getLoginToken() {
        return this.loginToken;
    }

    /**
     * 获得操作用户
     * 
     * @return 操作用户
     */
    public String getLoginUser() {
        return this.loginUser;
    }

    /**
     * 获得操作用户ID
     * 
     * @return 操作用户ID
     */
    public String getLoginUserId() {
        return this.loginUserId;
    }

    /**
     * 获得操作用户IP
     * 
     * @return 操作用户IP
     */
    public String getLoginUserIp() {
        return this.loginUserIp;
    }

    /**
     * 获得登录时间
     * 
     * @return 登录时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public java.util.Date getLoginTime() {
        return this.loginTime;
    }

    /**
     * 获得登出时间
     * 
     * @return 登出时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    public java.util.Date getLogoutTime() {
        return this.logoutTime;
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
     * 设置登录令牌
     * 
     * @param loginToken 登录令牌
     */
    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    /**
     * 设置操作用户
     * 
     * @param loginUser 操作用户
     */
    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    /**
     * 设置操作用户ID
     * 
     * @param loginUserId 操作用户ID
     */
    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    /**
     * 设置操作用户IP
     * 
     * @param loginUserIp 操作用户IP
     */
    public void setLoginUserIp(String loginUserIp) {
        this.loginUserIp = loginUserIp;
    }

    /**
     * 设置登录时间
     * 
     * @param loginTime 登录时间
     */
    public void setLoginTime(java.util.Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 设置登出时间
     * 
     * @param logoutTime 登出时间
     */
    public void setLogoutTime(java.util.Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
	public java.util.Date getLoginTimeBegin() {
		return loginTimeBegin;
	}

	public void setLoginTimeBegin(java.util.Date loginTimeBegin) {
		this.loginTimeBegin = loginTimeBegin;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public java.util.Date getLoginTimeEnd() {
		return loginTimeEnd;
	}

	public void setLoginTimeEnd(java.util.Date loginTimeEnd) {
		this.loginTimeEnd = loginTimeEnd;
	}
    
    

}