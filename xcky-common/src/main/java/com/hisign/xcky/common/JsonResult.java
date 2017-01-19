package com.hisign.xcky.common;

import java.io.Serializable;

/**
 * action返回结果类
 *
 * @author jiangpeng
 * @since 2016/5/28 11:46
 */
public class JsonResult implements Serializable {

    /**
     * 返回信息标志
     */
    private int flag;

    /**
     * 返回总条数
     */
    private long totalCount;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    public int getFlag() {
        return flag;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }


}
