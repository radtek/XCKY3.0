package com.hisign.xcky.api.service.sceneQuery;

import javax.ws.rs.HeaderParam;

import com.hisign.xcky.api.model.sceneQuery.FulltextFilter;
import com.hisign.xcky.api.model.sceneQuery.FulltextHeadFilter;
import com.hisign.xcky.common.JsonResult;

/**
 * 全文搜索接口
 * @author wangk
 * @mailto wangk002@hisign.com.cn
 * 2017年1月5日09:33:29
 */
public interface QueryFullTextService {
	
	/**
     * @param filter 查询条件对象
	 * @throws Exception 
     */
    public JsonResult queryFullText(@HeaderParam("token") String token,FulltextFilter filter) throws Exception;

    public JsonResult queryHeadNum(@HeaderParam("token") String token, FulltextHeadFilter filter) throws Exception;

    public JsonResult queryHead(@HeaderParam("token") String token, String checkCode) throws Exception;
}
