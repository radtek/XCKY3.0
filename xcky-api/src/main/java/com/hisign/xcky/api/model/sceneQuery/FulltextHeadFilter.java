package com.hisign.xcky.api.model.sceneQuery;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * sorl获取全国地址
 * add by wangk 2017年1月9日10:59:27
 * */
public class FulltextHeadFilter extends BaseModel {

	private static final long serialVersionUID = 1L;
	
	//查询内容
	private String queryItem;
		
	//跨省标识
	private String isOtherProvinces;
	
	//选中的c
	private String checkCode;

	private String facetQuery;
	
	//选中省份的solr索引地址
	private String solrCheckAdress;
	
	public String getQueryItem() {
		return queryItem;
	}

	public void setQueryItem(String queryItem) {
		this.queryItem = queryItem;
	}

	public String getIsOtherProvinces() {
		return isOtherProvinces;
	}

	public void setIsOtherProvinces(String isOtherProvinces) {
		this.isOtherProvinces = isOtherProvinces;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public String getFacetQuery() {
		return facetQuery;
	}

	public void setFacetQuery(String facetQuery) {
		this.facetQuery = facetQuery;
	}

	public String getSolrCheckAdress() {
		return solrCheckAdress;
	}

	public void setSolrCheckAdress(String solrCheckAdress) {
		this.solrCheckAdress = solrCheckAdress;
	}
	
}
