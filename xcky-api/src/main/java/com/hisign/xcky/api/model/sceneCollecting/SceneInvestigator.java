/**
 * SceneInvestigatorModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 现场勘验人信息
 *
 * @author ModelGenerator
 */
public class SceneInvestigator extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 勘验人用户ID
     */
    private String investigatorId;

    /**
     * 勘验人姓名
     */
    private String investigatorName;

    /**
     * 勘验人职责(KYZZDM)英文逗号分隔
     */
    private String duty;

    /**
     * 数据来源(SJLYDM)
     */
    private String source;
  
    /******************查询应用**************************/
    /**
     * 技术职务
     */
    private String technologyJob;
    
    /**
     * 单位名称
     */
    private String organName;

    

    public String getTechnologyJob() {
		return technologyJob;
	}

	public void setTechnologyJob(String technologyJob) {
		this.technologyJob = technologyJob;
	}

	public String getOrganName() {
		return organName;
	}

	public void setOrganName(String organName) {
		this.organName = organName;
	}

	/**
     * 获得勘验信息ID
     * 
     * @return 勘验信息ID
     */
    public String getInvestigationId() {
        return this.investigationId;
    }

    /**
     * 获得勘验人用户ID
     * 
     * @return 勘验人用户ID
     */
    public String getInvestigatorId() {
        return this.investigatorId;
    }

    /**
     * 获得勘验人姓名
     * 
     * @return 勘验人姓名
     */
    public String getInvestigatorName() {
        return this.investigatorName;
    }

    /**
     * 获得勘验人职责(KYZZDM)英文逗号分隔
     * 
     * @return 勘验人职责(KYZZDM)英文逗号分隔
     */
    public String getDuty() {
        return this.duty;
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
     * 设置勘验人用户ID
     * 
     * @param investigatorId 勘验人用户ID
     */
    public void setInvestigatorId(String investigatorId) {
        this.investigatorId = investigatorId;
    }

    /**
     * 设置勘验人姓名
     * 
     * @param investigatorName 勘验人姓名
     */
    public void setInvestigatorName(String investigatorName) {
        this.investigatorName = investigatorName;
    }

    /**
     * 设置勘验人职责(KYZZDM)英文逗号分隔
     * 
     * @param duty 勘验人职责(KYZZDM)英文逗号分隔
     */
    public void setDuty(String duty) {
        this.duty = duty;
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