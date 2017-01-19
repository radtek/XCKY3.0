package com.hisign.xcky.util;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 常用工具类
 * @Author yejiansuo
 * @Date 2016/6/15 10:38
 */
public class CommonUtil {

    /**
     * 行政区划代码去0
     * @param unitIn 用户单位代码
     * @author jiangpeng
     * @return 行政单位代码
     */
    public static String getShortXzqhDm(String unitIn) {
        String result = "";
        if(StringUtil.isNotEmpty(unitIn)) {
            if(unitIn.endsWith("0000")) {
                result = unitIn.substring(0, 2);
            }else if(unitIn.endsWith("00")) {
                result = unitIn.substring(0, 4);
            }else{
                result = unitIn;
            }
        }
        return result;
    }

    /**
     * 行政区划代码查询条件装换
     * @author jiangpeng
     * @param unit 单位代码
     * @return 行政区划代码查询条件
     */
    public static String replaceUserUnit(String unit) {
        String unit_in="";
        if(unit == null || "".equals(unit)) return "";
        if(unit.substring(0, 2).equals("11")||
                unit.substring(0, 2).equals("12")||
                unit.substring(0, 2).equals("31")||
                unit.substring(0, 2).equals("50")){
            if(unit.length() >= 6){
                if(StringUtils.equals(unit.substring(3, 6), "000")){
                    unit_in = unit.substring(0, 3);
                }else{
                    unit_in = unit.substring(0, 6);
                }
            }
        }else{
            //判断该行政区划属于哪一级别(派出所,区县,市,省)
            if(unit.length() > 3 && StringUtils.equals(unit.substring(2, 4),"00")) {
                unit_in = unit.substring(0, 2);
            }
            else if(unit.length() > 5 && StringUtils.equals(unit.substring(4, 6),"00")) {
                unit_in = unit.substring(0, 4);
            }
            else if(unit.length() > 7 && !StringUtils.equals(unit.substring(6, 8),"00")){
                unit_in = unit.substring(0, 8);
            }else {
                if(unit.length() >= 7) {
                    unit_in = unit.substring(0, 6);
                }else{
                    unit_in=unit;
                }
            }
        }
        return unit_in;
    }

    /**
     * 封装list对象
     * @param listObj list对象
     * @param map 数据map，key为设置的字段(比如“id”)，value为需要设置的数据，逗号分隔(比如“aaa，bbb”)
     * @param clazz list元素的class
     * @author jiangpeng
     * @return 封装数据后的list对象
     */
    public static <T> List<T> getListObject(List<T> listObj, Map<String, String> map, Class<T> clazz) {
        if(clazz == null) return null;
        JSONArray jsonArr = listObj == null ? new JSONArray() : JSON.parseArray(JSON.toJSONString(listObj));
        JSONObject jsonObj;
        String[] strs;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            strs = entry.getValue().split(",");
            if(jsonArr.size() > 0) {
                for (int i = 0,length = jsonArr.size(); i < length; i++) {
                    jsonObj = (JSONObject) jsonArr.get(i);
                    if(i < strs.length) jsonObj.put(entry.getKey(), strs[i]);
                    jsonArr.set(i, jsonObj);
                }
            } else {
                for (String str : strs) {
                    jsonObj = new JSONObject();
                    jsonObj.put(entry.getKey(), str);
                    jsonArr.add(jsonObj);
                }
            }
        }
        return JSON.parseArray(JSON.toJSONString(jsonArr), clazz);
    }

    /**
     * 封装list对象
     * @param listObj list对象
     * @param map 数据map，key为设置的字段，value为需要设置的数据
     * @param clazz list元素的class
     * @param size 指定list的长度，listObj为空时使用
     * @author jiangpeng
     * @return 封装数据后的list对象
     */
    public static <T> List<T> getListObject2(List<T> listObj, Map<String, ?> map, Class<T> clazz, int size) {
        if(clazz == null || (listObj == null || listObj.size() == 0) && size == 0) return listObj;
        //list对象装换的json数组
        JSONArray jsonArr = listObj == null ? new JSONArray() : JSON.parseArray(JSON.toJSONString(listObj));
        JSONObject jsonObj;
        //map的value值
        Object obj;
        boolean ifJsonArray;
        //map的value值装换的json数组
        JSONArray jsonArray = new JSONArray();
        int objSize = -1;
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            if(entry.getValue() == null) continue;
            obj = JSON.parse(JSON.toJSONString(entry.getValue()));
            //map的value值如果为数组则分割写入list的每个对象，如果为单一值list的每个对象均封装该值
            ifJsonArray = obj instanceof JSONArray;
            if(ifJsonArray) {
                jsonArray = (JSONArray)obj;
                objSize = jsonArray.size();
            }
            if(jsonArr.size() > 0) {
                //list对象中已存放数据，则在此基础上填充数据
                for (int i = 0, length = jsonArr.size(); i < length; i++) {
                    jsonObj = (JSONObject) jsonArr.get(i);
                    if(jsonObj == null) jsonObj = new JSONObject();
                    if(!ifJsonArray || i < objSize)
                    jsonObj.put(entry.getKey(), ifJsonArray ? jsonArray.get(i) : obj);
                    jsonArr.set(i, jsonObj);
                }
            } else {
                //如果传过来的list对象为空或长度为0，则根据size创建相应长度的list并封装数据
                for (int i = 0; i < size; i++) {
                    jsonObj = new JSONObject();
                    if(!ifJsonArray || i < objSize)
                    jsonObj.put(entry.getKey(), ifJsonArray ? jsonArray.get(i) : obj);
                    jsonArr.add(jsonObj);
                }
            }
        }
        return JSON.parseArray(JSON.toJSONString(jsonArr), clazz);
    }

    /**
     * 通过二维数组封装list对象
     * @param listObj list对象
     * @param arrays 数据map，key为设置的字段，value为需要设置的数据
     * @param clazz list元素的class
     * @param size 指定list的长度，listObj为空时使用
     * @author jiangpeng
     * @return 封装数据后的list对象
     */
    public static <T> List<T> getListObjectByArray(List<T> listObj, Object[][] arrays, Class<T> clazz, int size) {
        Map<String, ?> map = ArrayUtils.toMap(arrays);
        return getListObject2(listObj, map, clazz, size);
    }

    /**
     * 构造器替代方法
     * @param obj 原对象
     * @param arrays 数据map，key为设置的字段，value为需要设置的数据
     * @param clazz list元素的class
     * @author jiangpeng
     * @return 封装数据后的对象
     */
    public static <T> T getObjectByArray(T obj, Object[][] arrays, Class<T> clazz) {
        List<T> list = new ArrayList<>();
        list.add(obj);
        Map<String, ?> map = ArrayUtils.toMap(arrays);
        return getListObject2(list, map, clazz, 1).get(0);
    }

}


