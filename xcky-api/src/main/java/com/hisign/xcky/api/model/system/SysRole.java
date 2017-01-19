package com.hisign.xcky.api.model.system;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hisign.sso.api.entity.sys.Role;

/**  
 * @类功能说明：   系统角色类
 * @作者：hotdog  
 * @创建时间：2016-11-16 下午1:24:54  
 */ 
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_DEFAULT)
public class SysRole extends Role {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3907139998218769151L;
	
	/**
	 * 当前页数
	 */
	private int pageNum=1;
	
	/**
	 * 每页条数
	 */
	private int pageSize=15;
	
	/**
	 * 序号
	 */
	private int rowNum=0;
	
	/**
	 * 开始行数
	 */
	private int begin;
	
	/**
	 * 结束行数
	 */
	private int end;
	
	/**
	 * 排序字段
	 */
	private String orderBy;
	
	
	/**
	 * 排序方式
	 */
	private String sort;


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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
