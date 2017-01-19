/**
 * SysUserModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.system;

import com.alibaba.fastjson.annotation.JSONField;
import com.hisign.xcky.api.model.common.BaseModel;


/**
 * 系统用户信息
 *
 * @author ModelGenerator
 */
public class SysUser extends BaseModel {

    /**
     * 用户ID
     */
	@JSONField(name="userId")
    private String id;

    /**
     * 单位ID
     */
	@JSONField(name="orgId")
    private String organId;
	
	/**
	 * 前端映射用 用户单位名称
	 */
	@JSONField(name="orgName")
	private String organName;

    /**
     * 用户名
     */
    @JSONField(name="account")
    private String username;

    /**
     * 密码
     */
    @JSONField(name="pass")
    private String password;
    
    /**
     * 
     */
    private String newPassword;

    /**
     * 真实姓名
     */
    @JSONField(name="userName")
    private String trueName;

    /**
     * 性别(XBDM)
     */
    @JSONField(name="sex")
    private String gender;

    /**
     * 身份证号
     */
    @JSONField(name="cid")
    private String idCardNo;

    /**
     * 警号
     */
    @JSONField(name="policeId")
    private String policeNo;

    /**
     * 电话号码
     */
    @JSONField(name="contact")
    private String telNo;

    /**
     * 手机号码
     */
    @JSONField(name="phone")
    private String mobileNo;

    /**
     * 用户级别(YHJBDM)
     */
    private String userLevel;

    /**
     * 是否启用(SFDM)
     */
    @JSONField(name="activeStatus")
    private String openFlag;
    
    /**
     * 单位代码
     */
	@JSONField(name="orgCode")
    private String organCode;
	
    /**
     * 删除标识(SFDM)
     */
    private String deleteFlag;

    /**
     * 角色ID 多个逗号分隔
     */
    private String roleIds;
    
    /**
     * 角色
     */
    private String roleName;

  	/**
  	 * 创建账号
  	 */
  	private String createAccount;

  	/**
  	 * 创建时间
  	 */
  	@JSONField(name="createTime")
  	private long createTimeL;

  	/**
  	 * 最后修改时间
  	 */
  	@JSONField(name="lastModifyTime")
  	private long lastModifyTimeL;
  	
  	/**
  	 * 最后修改账户
  	 */
  	private String lastModifyAccount;
    
  	/**
	 * 备注
	 */
	private String remark;
	/**
     * 技术职务
     */
    private String technologyJob;
    
    /**
     * 人标识（1是0否）
     */
    private String personFlag;
    
	public String getTechnologyJob() {
		return technologyJob;
	}

	public void setTechnologyJob(String technologyJob) {
		this.technologyJob = technologyJob;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getParentKey() {
		return parentKey;
	}

	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 前台映射key
	 */
	private String key;
	
	/**
	 * 前台映射parentKey
	 */
	private String parentKey;
	
	/**
	 * 前台映射value
	 */
	private String value;
  	
    /**
     * 获得用户ID
     * 
     * @return 用户ID
     */
    public String getId() {
        return this.id;
    }

    /**
     * 获得单位ID
     * 
     * @return 单位ID
     */
    public String getOrganId() {
        return this.organId;
    }

    /**
     * 获得用户名
     * 
     * @return 用户名
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * 获得密码
     * 
     * @return 密码
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * 获得真实姓名
     * 
     * @return 真实姓名
     */
    public String getTrueName() {
        return this.trueName;
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
     * 获得身份证号
     * 
     * @return 身份证号
     */
    public String getIdCardNo() {
        return this.idCardNo;
    }

    /**
     * 获得警号
     * 
     * @return 警号
     */
    public String getPoliceNo() {
        return this.policeNo;
    }

    /**
     * 获得电话号码
     * 
     * @return 电话号码
     */
    public String getTelNo() {
        return this.telNo;
    }

    /**
     * 获得手机号码
     * 
     * @return 手机号码
     */
    public String getMobileNo() {
        return this.mobileNo;
    }

    /**
     * 获得用户级别(YHJBDM)
     * 
     * @return 用户级别(YHJBDM)
     */
    public String getUserLevel() {
        return this.userLevel;
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
     * 设置用户ID
     * 
     * @param id 用户ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 设置单位ID
     * 
     * @param organId 单位ID
     */
    public void setOrganId(String organId) {
        this.organId = organId;
    }

    /**
     * 设置用户名
     * 
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 设置密码
     * 
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 设置真实姓名
     * 
     * @param trueName 真实姓名
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName;
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
     * 设置身份证号
     * 
     * @param idCardNo 身份证号
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    /**
     * 设置警号
     * 
     * @param policeNo 警号
     */
    public void setPoliceNo(String policeNo) {
        this.policeNo = policeNo;
    }

    /**
     * 设置电话号码
     * 
     * @param telNo 电话号码
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    /**
     * 设置手机号码
     * 
     * @param mobileNo 手机号码
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * 设置用户级别(YHJBDM)
     * 
     * @param userLevel 用户级别(YHJBDM)
     */
    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreateAccount() {
		return createAccount;
	}

	public void setCreateAccount(String createAccount) {
		this.createAccount = createAccount;
	}

	public long getCreateTimeL() {
		return createTimeL;
	}

	public void setCreateTimeL(long createTimeL) {
		this.createTimeL = createTimeL;
	}

	public long getLastModifyTimeL() {
		return lastModifyTimeL;
	}

	public void setLastModifyTimeL(long lastModifyTimeL) {
		this.lastModifyTimeL = lastModifyTimeL;
	}

	public String getLastModifyAccount() {
		return lastModifyAccount;
	}

	public void setLastModifyAccount(String lastModifyAccount) {
		this.lastModifyAccount = lastModifyAccount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getPersonFlag() {
		return personFlag;
	}

	public void setPersonFlag(String personFlag) {
		this.personFlag = personFlag;
	}

	

}