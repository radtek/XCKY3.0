package com.hisign.xcky.api.service.sceneQuery;

/**
 * 全文搜索接口
 * 定时增量导入数据
 * @author wangk
 * @mailto wangk002@hisign.com.cn
 * 2017年1月5日09:33:29
 */
public interface SolrIndexManagerService {

	void deltaImport();
	
	public void start_solr_update_index();
	
}
