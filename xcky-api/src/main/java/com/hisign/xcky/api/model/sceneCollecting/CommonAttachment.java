/**
 * CommonAttachmentModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 通用附件信息
 *
 * @author ModelGenerator
 */
public class CommonAttachment extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 附件类别(FJLBDM)
     */
    private String category;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件后缀名
     */
    private String fileSuffix;

    /**
     * 文件MD5
     */
    private String fileMd5;

    /**
     * 文件大小
     */
    private Integer fileSize;

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
     * 获得附件类别(FJLBDM)
     * 
     * @return 附件类别(FJLBDM)
     */
    public String getCategory() {
        return this.category;
    }

    /**
     * 获得文件名称
     * 
     * @return 文件名称
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * 获得文件后缀名
     * 
     * @return 文件后缀名
     */
    public String getFileSuffix() {
        return this.fileSuffix;
    }

    /**
     * 获得文件MD5
     * 
     * @return 文件MD5
     */
    public String getFileMd5() {
        return this.fileMd5;
    }

    /**
     * 获得文件大小
     * 
     * @return 文件大小
     */
    public Integer getFileSize() {
        return this.fileSize;
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
     * 设置附件类别(FJLBDM)
     * 
     * @param category 附件类别(FJLBDM)
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 设置文件名称
     * 
     * @param fileName 文件名称
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 设置文件后缀名
     * 
     * @param fileSuffix 文件后缀名
     */
    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    /**
     * 设置文件MD5
     * 
     * @param fileMd5 文件MD5
     */
    public void setFileMd5(String fileMd5) {
        this.fileMd5 = fileMd5;
    }

    /**
     * 设置文件大小
     * 
     * @param fileSize 文件大小
     */
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
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