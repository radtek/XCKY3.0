package com.hisign.xcky.wordUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;


import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * FreeMarker模版引擎的管理
 * 
 * @time: 11:19:55
 * @author lift
 */
public class FreeMarkerManager {

	/**
	 * 单例实例
	 */
	private static FreeMarkerManager instance = null;

	/**
	 * freemarker配置
	 */
	private Configuration cfg = null;

	/**
	 * 模板文件路径
	 */
	private static final String TEMPLATE_FILE_PATH = "D://template//";

	/**
	 * 构造函数,(单例)
	 * 
	 * @throws Exception 初始化异常
	 */
	protected FreeMarkerManager() throws Exception {
		cfg = new Configuration();
		//cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
	}

	/**
	 * retrieve an instance to the current VelocityManager
	 * 
	 * @throws Exception 初始化异常
	 */
	public synchronized static FreeMarkerManager getInstance() throws Exception {
		if (instance == null) {
			instance = new FreeMarkerManager();
		}

		return instance;
	}

	/**
	 * 根据模版文件和context生成输出文件
	 * 
	 * @param templateFileName 模版文件
	 * @param outputFileName 输出文件
	 * @param context 上下文
	 * @param encoding 编码
	 * @throws Exception 异常
	 */
	public void renderTemplate(String templateFileName, String outputFileName, Map context, String encoding)
			throws Exception {
		renderTemplate(templateFileName, outputFileName, context, encoding, TEMPLATE_FILE_PATH);
	}

	/**
	 * 根据模版文件和context生成输出文件
	 * 
	 * @param templateFileName 模版文件
	 * @param outputFileName 输出文件
	 * @param context 上下文
	 * @param encoding 编码
	 * @param directoryForTemplateLoading 模版文件所在目录
	 * @throws Exception 异常
	 */
	public void renderTemplate(String templateFileName, String outputFileName, Map context, String encoding,
			String directoryForTemplateLoading) throws Exception {
		//cfg.setDirectoryForTemplateLoading(new File(directoryForTemplateLoading));
		Template temp = cfg.getTemplate(templateFileName, Locale.getDefault(), encoding);

		FileOutputStream fos = new FileOutputStream(outputFileName);
		Writer writer = new OutputStreamWriter(fos, encoding);
		temp.process(context, writer);
		writer.flush();
		writer.close();
	}

}
