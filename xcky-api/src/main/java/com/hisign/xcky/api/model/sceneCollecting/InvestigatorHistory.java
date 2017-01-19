/**
 * InvestigatorHistoryModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 历史勘验人信息
 *
 * @author ModelGenerator
 */
public class InvestigatorHistory extends BaseModel {

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
     * 勘验组是否选中(SFDM)
     */
    private String isOpen;


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

	public String getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
    
    

}