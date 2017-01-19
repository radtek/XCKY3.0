package com.hisign.xcky.api.model.sceneQuery;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * sorl查询的条件
 * add by wangk 2017年1月9日10:59:27
 * */
public class FulltextFilter extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	//查询内容
	private String queryItem;
	
	private String facetQuery;
	
	private String facetQueryItems;
	
	//是否单独查询
	private String ifSoloQuery;
	
	//跨省标识
	private String isOtherProvinces;
	
	//选中的c
	private String checkCode;
	
	//选中省份的solr索引地址
	private String solrCheckAdress;
	
	//勘验id
	private String investigationId;

	
	public String getIsOtherProvinces() {
		return isOtherProvinces;
	}

	public void setIsOtherProvinces(String isOtherProvinces) {
		this.isOtherProvinces = isOtherProvinces;
	}

	public String getIfSoloQuery() {
		return ifSoloQuery;
	}

	public void setIfSoloQuery(String ifSoloQuery) {
		this.ifSoloQuery = ifSoloQuery;
	}

	public String getQueryItem() {
		return queryItem;
	}

	public void setQueryItem(String queryItem) {
		this.queryItem = queryItem;
	}

	public String getFacetQuery() {
		return facetQuery;
	}

	public void setFacetQuery(String facetQuery) {
		this.facetQuery = facetQuery;
	}

	public String getFacetQueryItems() {
		return facetQueryItems;
	}

	public void setFacetQueryItems(String facetQueryItems) {
		this.facetQueryItems = facetQueryItems;
	}

	public String getInvestigationId() {
		return investigationId;
	}

	public void setInvestigationId(String investigationId) {
		this.investigationId = investigationId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getSolrCheckAdress() {
		return solrCheckAdress;
	}

	public void setSolrCheckAdress(String solrCheckAdress) {
		this.solrCheckAdress = solrCheckAdress;
	}
	
	
}
