package com.hisign.xcky.api.model.template;

/**
 * 提取痕迹物证
 * 项目名称：xcky-api   
 * 类名称：WordSceneCollectedMaterial   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-22 下午3:40:35   
 * 修改人：hisign   
 * 修改时间：2016-12-22 下午3:40:35   
 * 修改备注：   
 * @version
 */
public class WordSceneCollectedMaterial {
	/**
     * 序号
     */
    private String serialNo = null;
    /**
     * 名称
     */
    private String materialName = null;
    /**
     * 基本特征
     */
    private String feature = null;
    /**
     * 提取物品数量
     */
    private Integer amount;
    
    /**
     * 提取部位
     */
    private String collectedPosition;
    
    /**
     * 提取方法
     */
    private String collectedMethod;
    
    /**
     * 提取人
     */
    private String collectedBy;

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCollectedPosition() {
		return collectedPosition;
	}

	public void setCollectedPosition(String collectedPosition) {
		this.collectedPosition = collectedPosition;
	}

	public String getCollectedMethod() {
		return collectedMethod;
	}

	public void setCollectedMethod(String collectedMethod) {
		this.collectedMethod = collectedMethod;
	}

	public String getCollectedBy() {
		return collectedBy;
	}

	public void setCollectedBy(String collectedBy) {
		this.collectedBy = collectedBy;
	}
}
