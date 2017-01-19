package com.hisign;

import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.hisign.xcky.api.model.sceneCollecting.BasestationInfo;
import com.hisign.xcky.util.HttpFileUtil;

public class TestXml {

	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			//InputStream is=HttpFileUtil.downloadFileStream("http://172.16.0.112/M00/00/01/rBAAcFhgeSWAbii_AAAWBe7lS-Q282.xml");
			InputStream is=HttpFileUtil.downloadFileStream("http://172.16.0.112/M00/00/01/rBAAcFhgeWqAHPtZAAACTRPGLIs896.xml");
			SAXReader reader = new SAXReader();    
	        Document doc = reader.read(is);  
	        Element root = doc.getRootElement();
	        Element bs=root.element("BS");
	        
	        List<Element> bsList=bs.elements();
	        for(Element parentEle:bsList){
	            List<Element> listElement=parentEle.elements();
	            String nodeName=parentEle.getName();
	            for(Element baseStation:listElement){
	            	String ifActive=baseStation.getName();
	            	System.out.println(nodeName+"---"+ifActive+"---"+baseStation.asXML());
	            	XmlMapper xmlMapper = new XmlMapper();
	            	BasestationInfo basestationInfo=xmlMapper.readValue(baseStation.asXML(), BasestationInfo.class);
	            	Element gps=baseStation.element("GPS");
	            	if(gps!=null){
	            		basestationInfo.setLat(gps.elementText("LAT"));
	            		basestationInfo.setLon(gps.elementText("LON"));
	            	}
	            	System.out.println(nodeName+"---"+ifActive+"---"+JSON.toJSONString(basestationInfo));
	            }
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
