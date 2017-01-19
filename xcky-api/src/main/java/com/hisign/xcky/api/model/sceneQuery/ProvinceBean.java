package com.hisign.xcky.api.model.sceneQuery;

/**
 * 全国solr地址
 * */
public class ProvinceBean {

	private String id;//序列号
	private String sfdm;//省份代码
	private String sfmc;//省份名称
	private String xckyUrl;//Pic地址
	private String serviceUrl;//现勘服务接口地址
	private String vidocenterUrl;//视频管理中心地址
	private String solrAddress;//全文检索地址
	private String isSolr;//是否支持全文检索
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSfdm() {
		return sfdm;
	}
	public void setSfdm(String sfdm) {
		this.sfdm = sfdm;
	}
	public String getSfmc() {
		return sfmc;
	}
	public void setSfmc(String sfmc) {
		this.sfmc = sfmc;
	}
	public String getXckyUrl() {
		return xckyUrl;
	}
	public void setXckyUrl(String xckyUrl) {
		this.xckyUrl = xckyUrl;
	}
	public String getServiceUrl() {
		return serviceUrl;
	}
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	public String getVidocenterUrl() {
		return vidocenterUrl;
	}
	public void setVidocenterUrl(String vidocenterUrl) {
		this.vidocenterUrl = vidocenterUrl;
	}
	public String getSolrAddress() {
		return solrAddress;
	}
	public void setSolrAddress(String solrAddress) {
		this.solrAddress = solrAddress;
	}
	public String getIsSolr() {
		return isSolr;
	}
	public void setIsSolr(String isSolr) {
		this.isSolr = isSolr;
	}
	
}
