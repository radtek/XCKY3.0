package com.hisign.xcky.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 文件上传下载工具
 * @author yinxiaoyong
 * @mailto yinxiaoyong@hisign.com
 * 2016年10月13日
 */
public class FileUpDownLoadUtil {
 
	/**
	 * 文件上传到磁盘
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com
	 * 2016年10月13日
	 */
	public static void uploadToFile(HttpServletRequest request,HttpServletResponse response){
		try {
			//创建一个通用的多部分解析器
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			//判断 request 是否有文件上传,即多部分请求
			if(multipartResolver.isMultipart(request)){
				//转换成多部分request  
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
				//取得request中的所有文件名
				Iterator<String> iter = multiRequest.getFileNames();
				while(iter.hasNext()){
					//取得上传文件
					MultipartFile file = multiRequest.getFile(iter.next());
					if(file!=null){
						//将上传文件写到服务器上指定的文件
						File localFile = new File("D:/"+file.getOriginalFilename());
						file.transferTo(localFile); 
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 文件上传生成blob
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com
	 * 2016年10月13日
	 */
	public static byte[] uploadToBlob(HttpServletRequest request,HttpServletResponse response){
		InputStream fin = null;
		try {
			//创建一个通用的多部分解析器
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			//判断 request 是否有文件上传,即多部分请求
			if(multipartResolver.isMultipart(request)){
				//转换成多部分request  
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
				//取得request中的所有文件名
				Iterator<String> iter = multiRequest.getFileNames();
				while(iter.hasNext()){
					//取得上传文件
					MultipartFile file = multiRequest.getFile(iter.next());
					if(file!=null){
						fin = file.getInputStream();
						byte[] byteData = new byte[(int) fin.available()];
						fin.read(byteData);
						fin.close();
						return byteData;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 数据库Blob字段生成byte[]，再进行下载操作
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com
	 * 2016年10月13日
	 */
	public  static void downFromBlob(byte[] data,HttpServletResponse response,String fileName,String contentType){
		ServletOutputStream out;
		try{
			fileName=new String(fileName.getBytes("gbk"), "ISO8859-1");
			response.setHeader("Content-disposition", "attachment;filename="+fileName);
			response.setContentType(contentType);
			out = response.getOutputStream();
            out.write(data);
            out.close();
            out.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据磁盘路径下载文件
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com
	 * 2016年10月13日
	 */
	public  static void downFromFile(File file,HttpServletResponse response,String fileName,String contentType){
		ServletOutputStream out;
		try{
			fileName=new String(fileName.getBytes("gbk"), "ISO8859-1");
			response.setHeader("Content-disposition", "attachment;filename="+fileName);
			response.setContentType(contentType);
			
			out = response.getOutputStream();
			FileInputStream inputStream = new FileInputStream(file);
			int b = 0;  
			byte[] buffer = new byte[512];  
			while (b != -1){  
				b = inputStream.read(buffer);  
				out.write(buffer,0,b);  
			}  
			inputStream.close();  
			out.close();  
			out.flush();  
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
