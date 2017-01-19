package com.hisign;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hisign.xcky.util.Base64Util;

public class TestAddress {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			URL url = new URL("http://172.16.0.108:9080/xcky/webi/getProvinceUrlDataJosn.action");
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
			String xml = new String(bytes, "Utf-8");
	        Document doc = DocumentHelper.parseText(xml);
	        Element root = doc.getRootElement();
	        List<Element> bsList=root.elements();
	        JSONArray jsonArr=new JSONArray();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
