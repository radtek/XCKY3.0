/**
 * CommonPictureModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 通用图片信息
 *
 * @author ModelGenerator
 */
public class CommonPicture extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 图片类别(TPLBDM)
     */
    private String category;

    /**
     * 图片宽度
     */
    private Integer width;

    /**
     * 图片高度
     */
    private Integer height;

    /**
     * 图片名称
     */
    private String fileName;

    /**
     * 图片后缀名
     */
    private String fileSuffix;

    /**
     * 图片MD5
     */
    private String fileMd5;

    /**
     * 文件服务器地址
     */
    private String fileServerAddr;

    /**
     * 文件服务器存储路径
     */
    private String fileServerPath;

    /**
     * 数据来源(SJLYDM)
     */
    private String source;


    /**
     * 获得勘验信息ID
     * 
     * @return 勘验信息ID
     */
    public String getInvestigationId() {
        return this.investigationId;
    }

    /**
     * 获得图片类别(TPLBDM)
     * 
     * @return 图片类别(TPLBDM)
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * 获得图片宽度
     * 
     * @return 图片宽度
     */
    public Integer getWidth() {
        return this.width;
    }

    /**
     * 获得图片高度
     * 
     * @return 图片高度
     */
    public Integer getHeight() {
        return this.height;
    }

    /**
     * 获得图片名称
     * 
     * @return 图片名称
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * 获得图片后缀名
     * 
     * @return 图片后缀名
     */
    public String getFileSuffix() {
        return this.fileSuffix;
    }

    /**
     * 获得图片MD5
     * 
     * @return 图片MD5
     */
    public String getFileMd5() {
        return this.fileMd5;
    }

    /**
     * 获得文件服务器地址
     * 
     * @return 文件服务器地址
     */
    public String getFileServerAddr() {
        return this.fileServerAddr;
    }

    /**
     * 获得文件服务器存储路径
     * 
     * @return 文件服务器存储路径
     */
    public String getFileServerPath() {
        return this.fileServerPath;
    }

    /**
     * 获得数据来源(SJLYDM)
     * 
     * @return 数据来源(SJLYDM)
     */
    public String getSource() {
        return this.source;
    }


    /**
     * 设置勘验信息ID
     * 
     * @param investigationId 勘验信息ID
     */
    public void setInvestigationId(String investigationId) {
        this.investigationId = investigationId;
    }

    /**
     * 设置图片类别(TPLBDM)
     * 
     * @param category 图片类别(TPLBDM)
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 设置图片宽度
     * 
     * @param width 图片宽度
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 设置图片高度
     * 
     * @param height 图片高度
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 设置图片名称
     * 
     * @param fileName 图片名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 设置图片后缀名
     * 
     * @param fileSuffix 图片后缀名
     */
    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    /**
     * 设置图片MD5
     * 
     * @param fileMd5 图片MD5
     */
    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    /**
     * 设置文件服务器地址
     * 
     * @param fileServerAddr 文件服务器地址
     */
    public void setFileServerAddr(String fileServerAddr) {
        this.fileServerAddr = fileServerAddr;
    }

    /**
     * 设置文件服务器存储路径
     * 
     * @param fileServerPath 文件服务器存储路径
     */
    public void setFileServerPath(String fileServerPath) {
        this.fileServerPath = fileServerPath;
    }

    /**
     * 设置数据来源(SJLYDM)
     * 
     * @param source 数据来源(SJLYDM)
     */
    public void setSource(String source) {
        this.source = source;
    }

}