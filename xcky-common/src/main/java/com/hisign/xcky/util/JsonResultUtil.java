package com.hisign.xcky.util;

import com.hisign.xcky.common.JsonResult;


/**
 * Created by Hong on 2016/10/25.
 */
public class JsonResultUtil {

    private static JsonResult jsonResult;

    public static final int SUCCESS = 1;

    public static final int ERROR = 0;
    
    public static final int AUTHENTFAIL = -1;
    

    /**
     * 成功返回结果
     *
     * @param totalCount
     * @param data
     * @return
     */
    public static JsonResult success(long totalCount, Object data) {
        jsonResult = new JsonResult();
        jsonResult.setFlag(SUCCESS);
        jsonResult.setTotalCount(totalCount);
        jsonResult.setData(data);
        return jsonResult;
    }

    /**
     * 成功返回结果
     *
     * @param data
     * @return
     */
    public static JsonResult success(Object data) {
        jsonResult = new JsonResult();
        jsonResult.setFlag(SUCCESS);
        jsonResult.setData(data);
        return jsonResult;
    }

    /**
     * 成功返回结果
     *
     * @return
     */
    public static JsonResult success() {
        jsonResult = new JsonResult();
        jsonResult.setFlag(SUCCESS);
        return jsonResult;
    }

    /**
     * 失败返回结果
     *
     * @param msg
     * @return
     */
    public static JsonResult error(String msg) {
        jsonResult = new JsonResult();
        jsonResult.setFlag(ERROR);
        jsonResult.setMsg(msg);
        return jsonResult;
    }
    
    /**
     * 失败返回结果
     *
     * @param msg
     * @return
     */
    public static JsonResult authentFail(String msg) {
        jsonResult = new JsonResult();
        jsonResult.setFlag(AUTHENTFAIL);
        jsonResult.setMsg(msg);
        return jsonResult;
    }
    
}
