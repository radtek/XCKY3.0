package com.hisign.xcky.api.model.common;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 业务Model基类
 * 
 * @author Hong
 */
@JsonInclude(Include.NON_DEFAULT)
//上面参数是指该类下所有的属性在转化json时候都不参与序列化，除非该属性的值有改动。
@JsonIgnoreProperties(ignoreUnknown=true)
//前台传json格式，忽略对不上的属性
public class BaseModel implements Serializable {

	/**
	 * 主键ID
	 */
	private String id;

	/**
	 * 记录版本号
	 */
	private long version;

	/**
	 * 删除标识
	 */
	private String deleteFlag;

	/**
	 * 创建用户ID
	 */
	private String createUserId;
	
	/**
	 * 创建用户姓名
	 */
	private String createUser;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改用户ID
	 */
	private String updateUserId;
	
	/**
	 * 修改用户姓名
	 */
	private String updateUser;

	/**
	 * 修改时间
	 */
	private Date updateTime;
	
	/**
	 * 数据来源
	 */
	private String source;
	
	/**
	 * 开始行数
	 */
	private int begin;
	
	/**
	 * 结束行数
	 */
	private int end;
	
	/**
	 * 序号
	 */
	private int rowNum=0;
	
	/**
	 * 排序字段
	 */
	private String orderBy;
	
	/**
	 * 排序方式
	 */
	private String sort;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
}
