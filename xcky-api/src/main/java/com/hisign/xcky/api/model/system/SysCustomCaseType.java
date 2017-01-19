package com.hisign.xcky.api.model.system;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 自定义案件类别分组
 * @Author hotdog
 * @Mail zhaoqian@hisign.com.cn
 * @Date 2017/1/12 13:55
 */
public class SysCustomCaseType extends BaseModel{

    /**
     * 分组ID 主键
     */
    private String groupId;

    /**
     * 父分组ID
     */
    private String parentGroupId;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 分组说明
     */
    private String groupDesc;

    /**
     * 案件类别字典代码
     */
    private String caseType;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getParentGroupId() {
        return parentGroupId;
    }

    public void setParentGroupId(String parentGroupId) {
        this.parentGroupId = parentGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseTypeCN() {
        return caseTypeCN;
    }

    public void setCaseTypeCN(String caseTypeCN) {
        this.caseTypeCN = caseTypeCN;
    }

    /**
     * 案件类别中文

     */
    private String caseTypeCN;

    /**
     * 属于系统默认定义，不能删除，管理员可修改 （0非系统默认，1系统默认）
     */
    private String systemFlag;

    public String getSystemFlag() {
        return systemFlag;
    }

    public void setSystemFlag(String systemFlag) {
        this.systemFlag = systemFlag;
    }
}
