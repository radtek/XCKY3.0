package com.hisign;


import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hisign.xcky.api.model.sceneCollecting.SceneInvestigationDispatch;
import com.hisign.xcky.api.model.system.SysOnlineLog;

public class TestJackson {  
    public static void main(String[] args) throws Exception {  
  
    	//SysUser sysUser=new SysUser();
		//sysUser.setId("111111111");
		
		SysOnlineLog sysOnlineLog=new SysOnlineLog();
		sysOnlineLog.setLoginTime(new Date());
		//sysOnlineLog.setRowNum(0);
		sysOnlineLog.setRowNum(1);
        ObjectMapper mapper = new ObjectMapper();
        try {	
        	String outJson = mapper.writeValueAsString(sysOnlineLog); 
        	System.out.println(outJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
  
    	String json="{\"begin\":0,\"end\":0,\"id\":\"111111111\",\"crimeTimeBegin\": \"2016-12-01 12:12\"}";
    	SceneInvestigationDispatch sceneInvestigationDispatch=mapper.readValue(json, SceneInvestigationDispatch.class);
    	System.out.println(sceneInvestigationDispatch.getCrimeTimeBegin());
    }  
}    
  