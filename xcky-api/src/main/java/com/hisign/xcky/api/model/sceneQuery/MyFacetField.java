package com.hisign.xcky.api.model.sceneQuery;

/**
 * solr查询返回的分组下小类别对象
 * add by wnagk 2017年1月9日10:56:00
 * */
public class MyFacetField {

	//分组小类名字
	private String facet;
	
	//统计数量
	private long values;
	
	public MyFacetField(String facet, long values) {
		super();
		this.facet = facet;
		this.values = values;
	}

	public String getFacet() {
		return facet;
	}

	public void setFacet(String facet) {
		this.facet = facet;
	}

	public long getValues() {
		return values;
	}

	public void setValues(long values) {
		this.values = values;
	}

}