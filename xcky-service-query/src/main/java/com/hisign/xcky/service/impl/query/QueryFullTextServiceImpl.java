package com.hisign.xcky.service.impl.query;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.FacetParams;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hisign.sdk.cache.redis.RedisClient;
import com.hisign.xcky.api.model.sceneQuery.FulltextField;
import com.hisign.xcky.api.model.sceneQuery.FulltextFilter;
import com.hisign.xcky.api.model.sceneQuery.FulltextHeadFilter;
import com.hisign.xcky.api.model.sceneQuery.FulltextRetrievalResult;
import com.hisign.xcky.api.model.sceneQuery.MyFacetField;
import com.hisign.xcky.api.model.sceneQuery.MyGroupFacetField;
import com.hisign.xcky.api.model.sceneQuery.ProvinceBean;
import com.hisign.xcky.api.model.system.SysDict;
import com.hisign.xcky.api.model.system.SysParameter;
import com.hisign.xcky.api.service.sceneQuery.QueryFullTextService;
import com.hisign.xcky.api.service.system.SysDictService;
import com.hisign.xcky.api.service.system.SysParameterService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.util.Base64Util;
import com.hisign.xcky.util.JsonResultUtil;

@Path("/queryFullText")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("queryFullTextService")
@Transactional
public class QueryFullTextServiceImpl implements QueryFullTextService{

	private static Log log = LogFactory.getLog(FulltextRetrievalResult.class);
	
	@Resource
    private SysDictService sysDictService;
	
	@Resource
    private SysParameterService sysParameterService;
	
	private static String LOCAO_HOST_VIDEO_CENTER=null; 

	@Autowired
	protected RedisClient  redisClient;
	
	// 省份
    private List<ProvinceBean> xzqhList;
    
	// 全国地址缓存
	private static Map<String, List<ProvinceBean>> mapProvinceBean = new HashMap<String, List<ProvinceBean>>();
	    
	@Override
    @POST
	@Path("query")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult queryFullText(@HeaderParam("token") String token,FulltextFilter filter) throws Exception {
		FulltextRetrievalResult fulltextRetrievalResult=null;
		FulltextField fulltextField=null;
		
		String ifSoloQuery=filter.getIfSoloQuery();//是否单独查询
		String isOtherProvinces=filter.getIsOtherProvinces();//跨省
		String investigationId=filter.getInvestigationId();
		String solrCheckAdress=filter.getSolrCheckAdress();
		String checkCode=filter.getCheckCode();
		 
		//获取solr服务地址
		SysParameter sysParameter=sysParameterService.getByKey(Constants.SysParam.SOLR_ADDRESS_PATH);
		if(sysParameter==null){
			log.error("queryFullText方法中solr服务地址没有进行配置");
			return JsonResultUtil.error("solr服务地址没有进行配置");
		}
		String solrAddress = sysParameter.getValue();
		
		if("2".equals(isOtherProvinces)){
			if(StringUtils.isNotEmpty(solrCheckAdress)){
				solrAddress=solrCheckAdress;
			}else{
				return JsonResultUtil.error("选中的省份没有配置全国solr索引地址");
			}
		}
		
		if (ifSoloQuery != null && "1".equals(ifSoloQuery)) {
			log.info("单独查询");
			filter = new FulltextFilter();
			filter.setQueryItem("ID:" + investigationId);//勘验id
			fulltextRetrievalResult = queryFull(filter,"1",solrAddress,"");
			fulltextField = (FulltextField) fulltextRetrievalResult.getResults().get(0);
			if(fulltextField!=null && StringUtils.isNotBlank(fulltextField.getPROTECTOR())){
				String protector=fulltextField.getPROTECTOR();
				protector = protector.replace("&amp","^");
				fulltextField.setPROTECTOR(protector);
			}
		} else {
			log.info("全部查询");
		    if("2".equals(isOtherProvinces)&&StringUtils.isNotEmpty(filter.getQueryItem())){
		    	String s = new String(filter.getQueryItem().getBytes("ISO8859-1"), "UTF-8");
		    	filter.setQueryItem(s);
		    }
			fulltextRetrievalResult = queryFull(filter,null,solrAddress,checkCode);
		}
		
		String jsonStr=JSON.toJSONString(fulltextRetrievalResult);
		JSONObject job=JSON.parseObject(jsonStr);
		return JsonResultUtil.success(fulltextRetrievalResult.getTotalCount(),job);
	}
	
	/**
	 * ajax访问现勘获取全国地址
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Override
    @POST
	@Path("queryHead")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult queryHead(@HeaderParam("token") String token,String checkCode) throws Exception{
	    String xml="";
	    JSONArray jsonArr=new JSONArray();
		//获取全国solr服务索引地址
		SysParameter sysParameter=sysParameterService.getByKey(Constants.SysParam.SOLR_CHINA_ADDRESS_PATH);
		if(sysParameter==null){
			return JsonResultUtil.error("没有配置全国solr索引地址");
		}
		String solrGabAddress = sysParameter.getValue();
		String solrUrl="http://"+solrGabAddress+"/webi/getProvinceUrlDataJosn.action";
		try{
			URL url = new URL(solrUrl);
			InputStream is = url.openStream();
			ByteArrayOutputStream out=new ByteArrayOutputStream();
	        byte[] buffer=new byte[1024*4];
	        int n=0;
	        while ( (n=is.read(buffer)) !=-1) {
	            out.write(buffer,0,n);
	        }
	        byte[] byt= out.toByteArray();
			String result=new String(byt);
			byte[] bytes = (byte[]) Base64Util.getByteDataFromBase64Str(result);
			xml = new String(bytes, "Utf-8");
	        Document doc = DocumentHelper.parseText(xml);
	        Element root = doc.getRootElement();
	        List<Element> bsList=root.elements();
	        for(Element k:bsList){
	        	JSONObject jsonObj=new JSONObject();
	        	String unitName=k.elementText("UNITNAME");
	        	String unitCode=k.elementText("UNITCODE");
	        	String solrAddress=k.elementText("SOLR_ADDRESS");
	        	jsonObj.put("unitName", unitName);
	        	jsonObj.put("unitCode", unitCode);
	        	jsonObj.put("solrAddress", solrAddress);
	        	jsonArr.add(jsonObj);
	        }
	        System.out.println(JSON.toJSONString(jsonArr));
			is.close();
			out.close();
		}catch(Exception e){
			throw new Exception("获取地址异常");
		}
		return JsonResultUtil.success(jsonArr);
	}
	
	@Override
    @POST
	@Path("queryHeadNum")
    @Consumes({MediaType.APPLICATION_JSON})
	public JsonResult queryHeadNum(@HeaderParam("token") String token,FulltextHeadFilter filter) throws Exception {
		String solrElseAddress = filter.getSolrCheckAdress();//远程调用的solr的索引地址
		String checkCode=filter.getCheckCode();//选中的省份代码
		
		List<MyFacetField> facetList = queryHeadNumList(filter,solrElseAddress);
		List<SysDict> list =sysDictService.findByParentKey(checkCode);
		Map<String, Object> map=new HashMap<String,Object>();
		//将solr返回结果放到map中
		for(int j=0;j<facetList.size();j++){
			map.put(facetList.get(j).getFacet(), facetList.get(j).getValues());
		}
		//循环字典表中查询的结果并赋值，效率为i+j次
		for(SysDict sysDict:list){
			sysDict.setAmount((map.get(sysDict.getDictKey())==null?"0":String.valueOf(map.get(sysDict.getDictKey()))));
		}
		return JsonResultUtil.success(list);
	}
	
	/**
	 * ifSoloQuery=1时为单独查询，根据勘验id查询数据
	 * */
	@SuppressWarnings("unchecked")
	public FulltextRetrievalResult queryFull(FulltextFilter filter,
			String ifSoloQuery,String solrAddress,String checkCode) throws Exception {
		FulltextRetrievalResult fulltextRetrievalResult = new FulltextRetrievalResult();
		
		SolrServer solrServer = new HttpSolrServer("http://"+solrAddress+"/sceneInfo");

		SolrQuery query = new SolrQuery();
		//将省份地区条件拼入条件中
		if(StringUtils.isNotEmpty(checkCode) && "2".equals(filter.getIsOtherProvinces())){
			String str=filter.getQueryItem();
			//直辖市和省份地区查询字段不同
			if("110000".equals(checkCode) || "120000".equals(checkCode)){
				filter.setQueryItem(str+"");
			}else{
				filter.setQueryItem(str+"");
			}
		}
		query.setQuery((null != filter && StringUtils.isNotBlank(filter.getQueryItem())) ? filter.getQueryItem() : "*.*");
		if (StringUtils.isNotBlank(filter.getFacetQuery())) {
			String[] fqs = filter.getFacetQuery().split("&");
			for (String fq : fqs) {
				if (StringUtils.isNotBlank(fq) && !fq.endsWith(":all")) {
					query.addFilterQuery(fq);
				}
			}
		}
		
		if(ifSoloQuery==null){
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
	        String returnValue = df.format(new Date());
			query.setFacetPrefix("INVESTIGATION_DATE", returnValue);//查看当前月份

			// add facet 添加分组字段
			query.addFacetField("INVESTIGATION_DATE");
			query.addFacetField("CASE_TYPE_FACET");
			query.addFacetField("CASE_REGIONALISM_FACET");
			query.addFacetField("ORGAN_NAME_FACET");
			query.setFacetSort(FacetParams.FACET_SORT_INDEX_LEGACY);
			query.setFacetLimit(10);
			query.setRows(filter.getEnd() - filter.getBegin());
			query.setStart(filter.getBegin());
			
			// add hightlight 高亮度特殊显示
			query.setHighlight(true);
			query.addHighlightField("INVESTIGATION_PLACE");
			query.addHighlightField("INVESTIGATION_DATE_FROM");
			query.addHighlightField("CASE_TYPE");
			query.addHighlightField("INVESTIGATION_NO");
			query.addHighlightField("INVEST_NOTE");
			query.addHighlightField("DIRECTOR");
			query.addHighlightField("INVESTIGATOR_NAME");
			query.addHighlightField("COMMAND_NAME");
			query.addHighlightField("INVESTIGATOR");
			query.addHighlightField("text");
			query.setHighlightSimplePre("<font color=\"red\">");
			query.setHighlightSimplePost("</font>");
			query.setHighlightFragsize(800);
		}
		
		// query
		QueryResponse queryResponse = solrServer.query(query);
		SolrDocumentList docList = queryResponse.getResults();
		
		fulltextRetrievalResult.setSearched("1");
		
		// MyGroupFacetField 分组list
		List<MyGroupFacetField> facetGroupList = new ArrayList<MyGroupFacetField>();

		List<FacetField> facetFields = queryResponse.getFacetFields();
		for (int i = 0; null != facetFields && i < facetFields.size(); i++) {
			//分组下小类的统计list 小类名字（数量）
			List<MyFacetField> facetList = new ArrayList<MyFacetField>();

			FacetField facetField = facetFields.get(i);//从solr中取出的分组对象
			for(int j=0;j<facetField.getValues().size();j++){
				String facet= facetField.getValues().get(j).getName();
				long values= facetField.getValues().get(j).getCount();
				MyFacetField myFacetField = new MyFacetField(facet,values);
				facetList.add(myFacetField);
			}
			
			MyGroupFacetField MyGroupFacetField = new MyGroupFacetField(facetField.getName(),facetList);
			facetGroupList.add(MyGroupFacetField);
		}
		fulltextRetrievalResult.setMyGroupFacetField(facetGroupList);
		
		// Hightlights
		Map hlMap = queryResponse.getHighlighting();
		
//		// Results
		List list = FulltextRetrievalResult.solrDocument2Entity(docList, hlMap, FulltextField.class);
		if (null != list) {
			log.info("solr查询后数据条数为"+list.size());
			fulltextRetrievalResult.getResults().addAll(list);
		}
		
		// 分页
		long totalCount = null == queryResponse.getResults() ? 0 : queryResponse.getResults().getNumFound();
		fulltextRetrievalResult.setTotalCount(totalCount);
		
		return fulltextRetrievalResult;
	}

	@SuppressWarnings("unchecked")
	public List queryHeadNumList(FulltextHeadFilter filter,String solrAddress) throws Exception {		
		SolrServer solrServer = new HttpSolrServer("http://"+solrAddress+"/sceneInfo");
		SolrQuery query = new SolrQuery();
		query.setQuery((null != filter && StringUtils.isNotBlank(filter.getQueryItem())) ? filter.getQueryItem() : "*.*");
		if (StringUtils.isNotBlank(filter.getFacetQuery())) {
			String[] fqs = filter.getFacetQuery().split("&");
			for (String fq : fqs) {
				if (StringUtils.isNotBlank(fq) && !fq.endsWith(":all")) {
					query.addFilterQuery(fq);
				}
			}
		}
		// add facet 添加分组字段
		String checkCode=filter.getCheckCode();
		//北京和天津为直辖市用6位代码 省厅用4位
		if("110000".equals(checkCode) || "120000".equals(checkCode)){
			query.addFacetField("ORGAN_NO_HEADNEW_FACET");
		}else{
			query.addFacetField("ORGAN_NO_HEAD_FACET");
		}
		query.setFacetSort(FacetParams.FACET_SORT_INDEX_LEGACY);
		query.setFacetLimit(10);
		query.setRows(filter.getEnd() - filter.getBegin());
		query.setStart(filter.getBegin());			
		
		// query
		QueryResponse queryResponse = solrServer.query(query);
		SolrDocumentList docList = queryResponse.getResults();
		
		//分组下小类的统计list 小类名字（数量）
		List<MyFacetField> facetList=new ArrayList<MyFacetField>();;

		//从solr中取出的分组对象 只有一个分组
		FacetField facetField = queryResponse.getFacetFields().get(0);
		for(int j=0;j<facetField.getValues().size();j++){
			String facet= facetField.getValues().get(j).getName();
			long values= facetField.getValues().get(j).getCount();
			MyFacetField myFacetField = new MyFacetField(facet,values);
			facetList.add(myFacetField);
		}			
		return facetList;
	}
	
	
	public SysParameterService getSysParameterService() {
		return sysParameterService;
	}

	public void setSysParameterService(SysParameterService sysParameterService) {
		this.sysParameterService = sysParameterService;
	}

	public SysDictService getSysDictService() {
		return sysDictService;
	}

	public void setSysDictService(SysDictService sysDictService) {
		this.sysDictService = sysDictService;
	}

		
}
