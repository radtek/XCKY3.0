package com.hisign.xcky.api.model.sceneQuery;

import java.util.List;

/**
 * solr查询返回的分组对象
 * add by wangk 2017年1月9日10:57:06
 * */
public class MyGroupFacetField {

	//分组名字
	private String name;
	
	//分组小类list
	private List<MyFacetField> list;
	
	public MyGroupFacetField(String name, List<MyFacetField> list) {
		super();
		this.name = name;
		this.list = list;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MyFacetField> getList() {
		return list;
	}
	public void setList(List<MyFacetField> list) {
		this.list = list;
	}
	
}