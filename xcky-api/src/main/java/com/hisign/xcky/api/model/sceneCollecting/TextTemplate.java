/**
 * TextTemplateModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 文本信息模板
 *
 * @author ModelGenerator
 */
public class TextTemplate extends BaseModel {

    /**
     * 现场文本模版类型(WBMBLXDM)
     */
    private String templateType;
    
    /**
     * 现场文本模版类型名称
     */
    private String templateTypeName;

    /**
     * 现场文本模版名称
     */
    private String templateName;
	
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
     * 是否所有人可用(SFDM)
     */
    private String allAvailable;

    /**
     * 是否所有案别通用(SFDM)
     */
    private String commonFlag;

    /**
     * 允许修改(SFDM)
     */
    private String allowModify;

    /**
     * 是否启用(SFDM)
     */
    private String openFlag;

    /**
     * 数据来源(SJLYDM)
     */
    private String source;

    /**
     * 获得现场文本模版类型(WBMBLXDM)
     * 
     * @return 现场文本模版类型(WBMBLXDM)
     */
    public String getTemplateType() {
        return this.templateType;
    }

    /**
     * 获得现场文本模版名称
     * 
     * @return 现场文本模版名称
     */
    public String getTemplateName() {
        return this.templateName;
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
     * 获得是否所有人可用(SFDM)
     * 
     * @return 是否所有人可用(SFDM)
     */
    public String getAllAvailable() {
        return this.allAvailable;
    }

    /**
     * 获得是否所有案别通用(SFDM)
     * 
     * @return 是否所有案别通用(SFDM)
     */
    public String getCommonFlag() {
        return this.commonFlag;
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
     * 设置现场文本模版类型(WBMBLXDM)
     * 
     * @param templateType 现场文本模版类型(WBMBLXDM)
     */
    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    /**
     * 设置现场文本模版名称
     * 
     * @param templateName 现场文本模版名称
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
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
     * 设置是否所有人可用(SFDM)
     * 
     * @param allAvailable 是否所有人可用(SFDM)
     */
    public void setAllAvailable(String allAvailable) {
        this.allAvailable = allAvailable;
    }

    /**
     * 设置是否所有案别通用(SFDM)
     * 
     * @param commonFlag 是否所有案别通用(SFDM)
     */
    public void setCommonFlag(String commonFlag) {
        this.commonFlag = commonFlag;
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

	public String getTemplateTypeName() {
		return templateTypeName;
	}

	public void setTemplateTypeName(String templateTypeName) {
		this.templateTypeName = templateTypeName;
	}

	public String getCaseTypeName() {
		return caseTypeName;
	}

	public void setCaseTypeName(String caseTypeName) {
		this.caseTypeName = caseTypeName;
	}

}