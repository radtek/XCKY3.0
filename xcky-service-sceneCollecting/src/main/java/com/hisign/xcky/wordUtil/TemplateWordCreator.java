package com.hisign.xcky.wordUtil;

import java.util.Map;

/**
 * 通过模版生成word文件
 * 项目名称：xcky-common   
 * 类名称：TemplateWordCreator   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-20 下午5:21:55   
 * 修改人：hisign   
 * 修改时间：2016-12-20 下午5:21:55   
 * 修改备注：   
 * @version
 */
public class TemplateWordCreator {
	/**
	 * 根据模版文件和context生成输出文件
	 * 
	 * @param templateFileName   模版文件
	 * @param outputFileName  输出文件
	 * @param context  上下文
	 * @param encoding 编码
	 * @throws Exception 异常
	 */
	public static void generate(String templateFileName, String outputFileName, Map context, String encoding){
		System.out.println("生成word文件"+templateFileName);
		try {
			FreeMarkerManager.getInstance().renderTemplate(templateFileName, outputFileName, context, encoding);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("==========完成==========");
	}
}
