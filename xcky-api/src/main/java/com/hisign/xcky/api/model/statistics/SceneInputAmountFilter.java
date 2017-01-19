package com.hisign.xcky.api.model.statistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 统计查询条件
 * 项目名称：xcky-api   
 * 类名称：SceneInputAmountFilter   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-26 上午11:27:31   
 * 修改人：hisign   
 * 修改时间：2016-12-26 上午11:27:31   
 * 修改备注：   
 * @version
 */
@JsonIgnoreProperties(ignoreUnknown=true)
//前台传json格式，忽略对不上的属性
public class SceneInputAmountFilter {
	
	/**
	 * 时间类型（1：勘验时间，2：录入时间，3：提交时间）
	 */
	private String dateType;
	/**
	 * 时间开始
	 */
	private String filterDateFrom;
	/**
	 * 时间截至
	 */
	private String filterDateTo;
	/**
	 * 查询单位
	 */
	private String unit=null;
	
	/**
	 * 是否当月勘察当月录入
	 */
	private String isSameMonInvAndInp;

	/**
	 * 当前用户单位单位代码  
	 */
	private String orgNo;
	
	/**
	 * 前端传入是否包含下级(0，不包含；1：包含)
	 */
	private String isIncludeLowerLevel;
	/**
	 * SQL查询应用
	 */
	private String isIncludeLowerLevelSQL;
	
	

	public String getIsIncludeLowerLevelSQL() {
		return isIncludeLowerLevelSQL;
	}

	public void setIsIncludeLowerLevelSQL(String isIncludeLowerLevelSQL) {
		this.isIncludeLowerLevelSQL = isIncludeLowerLevelSQL;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getFilterDateFrom() {
		return filterDateFrom;
	}

	public void setFilterDateFrom(String filterDateFrom) {
		this.filterDateFrom = filterDateFrom;
	}

	public String getFilterDateTo() {
		return filterDateTo;
	}

	public void setFilterDateTo(String filterDateTo) {
		this.filterDateTo = filterDateTo;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getIsSameMonInvAndInp() {
		return isSameMonInvAndInp;
	}

	public void setIsSameMonInvAndInp(String isSameMonInvAndInp) {
		this.isSameMonInvAndInp = isSameMonInvAndInp;
	}

	public String getOrgNo() {
		return orgNo;
	}

	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo;
	}

	public String getIsIncludeLowerLevel() {
		return isIncludeLowerLevel;
	}

	public void setIsIncludeLowerLevel(String isIncludeLowerLevel) {
		this.isIncludeLowerLevel = isIncludeLowerLevel;
	}
}
