package com.hisign.xcky.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * excel工具类
 *
 * @author yinxiaoyong
 * @mailto yinxiaoyong@hisign.com
 * 2016年10月12日
 */
public class ExcelUtil {

    /**
     * 默认excel导出文件名-excelExport
     */
    private static final String DEFAULT_EXCEL_NAME = "excelExport";

    /**
     * xls文件类型
     */
    public static final String XLS_FILE = "xls";

    /**
     * xlsx文件类型
     */
    public static final String XLSX_FILE = "xlsx";

    /**
     * 导出excel
     *
     * @author yinxiaoyong
     * @mailto yinxiaoyong@hisign.com
     * 2016年10月12日
     */
    public static void exportFile(HttpServletRequest request, HttpServletResponse response, String htmlData,
                                  String sheetName, String fileName) {
        //生成Excel工作薄对象
        HSSFWorkbook wb = ParseHtmlToXls.parseHtmlToXlsForMultiTitle(htmlData, sheetName);
        String contentType = "application/vnd.ms-excel";
        response.setContentType(contentType);
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream sos = null;

        try {
            sos = response.getOutputStream();
            response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(((fileName != null ? fileName : DEFAULT_EXCEL_NAME) + ".xls").getBytes(), "ISO8859-1") + "\"");
            response.resetBuffer();
            sos.flush();
            wb.write(sos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != sos) {
                try {
                    sos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != wb) {
                try {
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static Response  exportFileStream(String htmlData, String sheetName, String fileName) {
    	Response response=null;
    	//生成Excel工作薄对象
    	String contentType = "application/vnd.ms-excel";
		ResponseBuilder responseBuilder = Response.ok(fileName);    	
    	try {
            responseBuilder.type(contentType);
            responseBuilder.header("Content-Disposition", "attachment; filename=" 
                    + new String(((fileName != null ? fileName : DEFAULT_EXCEL_NAME) + ".xls").getBytes(), "ISO8859-1"));
            response = responseBuilder.build();            
    	} catch (Exception e) {
    		e.printStackTrace();
    	} 
    	return response ;
	}
    
    public static ServletOutputStream exportFileStream(HttpServletRequest request, HttpServletResponse response,String htmlData, String sheetName, String fileName) {
    	//Response response=null;
    	//生成Excel工作薄对象
    	String contentType = "application/vnd.ms-excel";
        response.setContentType(contentType);
        response.setCharacterEncoding("UTF-8");
        ServletOutputStream sos = null;

        try {
            sos = response.getOutputStream();
            response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(((fileName != null ? fileName : DEFAULT_EXCEL_NAME) + ".xls").getBytes(), "ISO8859-1") + "\"");
            response.resetBuffer();
            sos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != sos) {
                try {
                    sos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    	return sos ;
	}
    /**
     * 导入excel生成对象
     *
     * @author yinxiaoyong
     * @mailto yinxiaoyong@hisign.com
     * 2016年10月12日
     */
    @SuppressWarnings({"resource", "rawtypes"})
    public static List<Object> importFile(File file, String fileName, int sheetIndex, Class clazz, String[] propertyNames) {
        List<Object> dataList = new ArrayList<Object>();
        InputStream inputStream = null;
        Workbook wb = null;

        try {
            inputStream = new FileInputStream(file);
            if (fileName.endsWith(".xlsx")) {
                wb = new XSSFWorkbook(inputStream);// Excel 2007
            } else {
                wb = new HSSFWorkbook(inputStream);// Excel 2003
            }

            Sheet sheet = (Sheet) wb.getSheetAt(sheetIndex);// 切换工作薄
            Row row = null;
            Cell cell = null;
            Field field = null;
            int totalRows = sheet.getPhysicalNumberOfRows();
            int totalCells = totalRows >= 1 && sheet.getRow(0) != null ? sheet.getRow(0).getPhysicalNumberOfCells() : 0;

            for (int i = 0; i < totalRows; i++) {
                row = sheet.getRow(i);
                Object object = (Object) clazz.newInstance();

                for (int j = 0; j < totalCells; j++) {
                    cell = row.getCell(j);
                    field = clazz.getDeclaredField(propertyNames[j]);
                    field.setAccessible(true);
                    field.set(object, cell.getStringCellValue());
                }
                dataList.add(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != wb) {
                try {
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dataList;
    }

    public static void main(String[] args) {
       /* File file = new File("D:\\案件勘验20161012142427.xls");
        String[] propertyNames = {"rownum", "ajbh", "jjbh", "investigationNo", "ajmc", "ajlb",
                "fasjczStr", "lasjStr", "ajssjq", "fadd", "evidenceAmount", "scenePhotoAmount",
                "scenePictureAmount", "investigationDateFrom", "investigator", "qualifiedFlag"};
        List<Object> dataList = importFile(file, "案件勘验20161012111112.xls", 0, Assign.class, propertyNames);
        System.out.println(dataList);*/
    }

}
