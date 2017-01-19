package com.hisign.xcky.util.excel;

import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.generic.DateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 模板解析工具
 * @author <a href="">wangping</a>
 * @version 1.0
 * @since 2016/3/3 9:01
 */
public class TemplateUtil {

    private TemplateUtil() {}

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static void init(VelocityEngine ve) {
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");//取得当前classpath，文件路径
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.setProperty("input.encoding", "UTF-8");
        ve.setProperty("output.encoding", "UTF-8");
        try {
            ve.init();
        } catch (Exception e) {
            LoggerFactory.getLogger(TemplateUtil.class).error("velocity init error!", e);
        }
    }

    /**
     * 解析模板文件，返回解析完之后的字符串
     * @param map
     * @param fileName
     */
    public static String parseTemplate(Map<String, Object> map, String fileName) {
        String str = "";
        VelocityEngine ve = new VelocityEngine();
        init(ve);
        try {
            Template template = ve.getTemplate(fileName);//取得模板文件
            VelocityContext ctx = new VelocityContext();
            //日期处理
            DateTool dateTool = new DateTool();  
            map.put("dateTool",dateTool);
            
            //建议以后map统一只用这种方式，效率比使用map.keySet()高很多***
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                ctx.put(entry.getKey(), entry.getValue());
            }
            StringWriter sw = new StringWriter();
            template.merge(ctx, sw);
            str = sw.toString();
        } catch (Exception e) {
            LoggerFactory.getLogger(TemplateUtil.class).error("velocity parse error!", e);
        } finally {
            ve = null;
            return str;
        }
    }

//    public static void main(String[] args) {
//        String fileName = "excelTemplates/sceneInfo.vm";
//        Map<String, Object> map = new HashMap<String, Object>();
//        //类Person必须是public的，也就是说必须是一个单独的类文件***
//        List<SceneInvestigation> temp = new ArrayList<SceneInvestigation>();
//        for (int i=1; i<=2100; i++) {
//            temp.add(new SceneInvestigation());
//        }
//        map.put("list", temp);
//
//        String result = TemplateUtil.parseTemplate(map, fileName);
//        System.out.println(result);
//        try {
//            String htmlStr = result;
//            String sheetName = "222";
//            //生成Excel工作薄对象
//            HSSFWorkbook wb = ParseHtmlToXls.parseHtmlToXlsForMultiTitle(htmlStr, sheetName);
//            OutputStream out = new FileOutputStream("C:\\Users\\wangping_x1\\Desktop\\test.xls");
//            wb.write(out);
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
