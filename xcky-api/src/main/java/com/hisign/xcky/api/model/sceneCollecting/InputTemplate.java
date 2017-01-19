/**
 * InputTemplateModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 信息录入模板
 *
 * @author ModelGenerator
 */
public class InputTemplate extends BaseModel {

    /**
     * 使用用户级别(YHJBDM)
     */
    private String useageUserLevel;

    /**
     * 案件类别(AJLBDM)
     */
    private String caseType;
    
    /**
     * 案件类别名称
     */
    private String caseTypeName;

    /**
     * 模版内容
     */
    private String content;

    /**
     * 允许修改(SFDM)
     */
    private String allowModify;

    /**
     * 是否有效(SFDM)
     */
    private String effectiveFlag;

    /**
     * 是否启用(SFDM)
     */
    private String openFlag;

    /**
     * 数据来源(SJLYDM)
     */
    private String source;


    /**
     * 获得使用用户级别(YHJBDM)
     * 
     * @return 使用用户级别(YHJBDM)
     */
    public String getUseageUserLevel() {
        return this.useageUserLevel;
    }

    /**
     * 获得案件类别(AJLBDM)
     * 
     * @return 案件类别(AJLBDM)
     */
    public String getCaseType() {
        return this.caseType;
    }

    /**
     * 获得模版内容
     * 
     * @return 模版内容
     */
    public String getContent() {
        return this.content;
    }

    /**
     * 获得允许修改(SFDM)
     * 
     * @return 允许修改(SFDM)
     */
    public String getAllowModify() {
        return this.allowModify;
    }

    /**
     * 获得是否有效(SFDM)
     * 
     * @return 是否有效(SFDM)
     */
    public String getEffectiveFlag() {
        return this.effectiveFlag;
    }

    /**
     * 获得是否启用(SFDM)
     * 
     * @return 是否启用(SFDM)
     */
    public String getOpenFlag() {
        return this.openFlag;
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
     * 设置使用用户级别(YHJBDM)
     * 
     * @param useageUserLevel 使用用户级别(YHJBDM)
     */
    public void setUseageUserLevel(String useageUserLevel) {
        this.useageUserLevel = useageUserLevel;
    }

    /**
     * 设置案件类别(AJLBDM)
     * 
     * @param caseType 案件类别(AJLBDM)
     */
    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    /**
     * 设置模版内容
     * 
     * @param content 模版内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 设置允许修改(SFDM)
     * 
     * @param allowModify 允许修改(SFDM)
     */
    public void setAllowModify(String allowModify) {
        this.allowModify = allowModify;
    }

    /**
     * 设置是否有效(SFDM)
     * 
     * @param effectiveFlag 是否有效(SFDM)
     */
    public void setEffectiveFlag(String effectiveFlag) {
        this.effectiveFlag = effectiveFlag;
    }

    /**
     * 设置是否启用(SFDM)
     * 
     * @param openFlag 是否启用(SFDM)
     */
    public void setOpenFlag(String openFlag) {
        this.openFlag = openFlag;
    }

    /**
     * 设置数据来源(SJLYDM)
     * 
     * @param source 数据来源(SJLYDM)
     */
    public void setSource(String source) {
        this.source = source;
    }

	public String getCaseTypeName() {
		return caseTypeName;
	}

	public void setCaseTypeName(String caseTypeName) {
		this.caseTypeName = caseTypeName;
	}
    
    

}