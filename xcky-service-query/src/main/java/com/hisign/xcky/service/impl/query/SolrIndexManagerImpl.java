package com.hisign.xcky.service.impl.query;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hisign.xcky.api.model.sceneQuery.FulltextRetrievalResult;
import com.hisign.xcky.api.model.system.SysParameter;
import com.hisign.xcky.api.service.sceneQuery.SolrIndexManagerService;
import com.hisign.xcky.api.service.system.SysParameterService;
import com.hisign.xcky.constant.Constants;

/**
 * 全文搜索定时导入数据
 * add by wangk on 2017年1月13日16:41:26
 * */
@Service("solrIndexManagerService")
@Transactional
public class SolrIndexManagerImpl implements SolrIndexManagerService{
	
	private static Log log = LogFactory.getLog(FulltextRetrievalResult.class);

	@Resource
    private SysParameterService sysParameterService;
	
	/**
	 * 重试休眠时间   10秒钟
	 */
	public static final int RETRY_TIME = 10*1000;
	
	private Thread thread_scene_update_index;
	
	private void stopThread_scene_update_index(){
		thread_scene_update_index=null;
	}
	
	public void start_solr_update_index(){
		if(thread_scene_update_index!=null && thread_scene_update_index.isAlive()){
			return;
		}
		thread_scene_update_index =new Thread(){public void run() {
			try {
				deltaImport();
				//整个任务做完之后休眠10秒
				Thread.sleep(RETRY_TIME);
				log.info("增量更新索引执行完成，休眠"+RETRY_TIME+"毫秒后再次执行");
				stopThread_scene_update_index();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				log.error("execute", e);
			} catch(Exception e){
				log.error("execute", e);
			}
		};};
		thread_scene_update_index.start();
	}

	public void deltaImport() {
		log.info("增量更新索引开始...");
		//获取solr服务地址
		SysParameter sysParameter=sysParameterService.getByKey(Constants.SysParam.SOLR_ADDRESS_PATH);
		if(sysParameter==null){
			log.error("queryFullText方法中solr服务地址没有进行配置");
			return ;
		}
		String solrAddress = sysParameter.getValue();
		String detlaUrl = "http://" + solrAddress + "/sceneInfo/dataimport?command=delta-import&clean=false";
//		SolrIndexQueue solrIndexQueue = (SolrIndexQueue) dao
//				.getSqlMapClientTemplate().queryForObject("findSolrIndexMaxCreateDatetime");
//		if (null==solrIndexQueue) return;
		
		// 创建HttpClientBuilder
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		// HttpClient
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

		HttpGet httpGet = new HttpGet(detlaUrl);
		System.out.println(httpGet.getRequestLine());

		try {
			// 执行get请求
			HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
			// 获取响应消息实体
			HttpEntity entity = httpResponse.getEntity();
			// 响应状态
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			System.out.println("statusCode:" + statusCode);
			// 判断响应实体是否为空
			if (entity != null) {
				System.out.println("contentEncoding:" + entity.getContentEncoding());
				System.out.println("response content:" + EntityUtils.toString(entity));
			}
			
			if (statusCode == HttpStatus.SC_OK) {
				try {
					Thread.sleep(100 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 更新索引队列
				//solrIndexQueue.setIfDeal("1");
				//dao.getSqlMapClientTemplate().update("updateIfDealByMaxCreateDatetime", solrIndexQueue);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				closeableHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
		log.info("增量更新索引结束！");
	}

	public SysParameterService getSysParameterService() {
		return sysParameterService;
	}

	public void setSysParameterService(SysParameterService sysParameterService) {
		this.sysParameterService = sysParameterService;
	}
	
	

}
