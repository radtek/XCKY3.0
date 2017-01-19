/**
 * SceneLostGoodsModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 现场损失物品信息
 *
 * @author ModelGenerator
 */
public class SceneLostGoods extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 品名
     */
    private String name;

    /**
     * 厂牌型号
     */
    private String brand;

    /**
     * 特征描述
     */
    private String feature;

    /**
     * 数量
     */
    private Integer amount;

    /**
     * 价值
     */
    private Integer value;

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
     * 获得品名
     * 
     * @return 品名
     */
    public String getName() {
        return this.name;
    }

    /**
     * 获得厂牌型号
     * 
     * @return 厂牌型号
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * 获得特征描述
     * 
     * @return 特征描述
     */
    public String getFeature() {
        return this.feature;
    }

    /**
     * 获得数量
     * 
     * @return 数量
     */
    public Integer getAmount() {
        return this.amount;
    }

    /**
     * 获得价值
     * 
     * @return 价值
     */
    public Integer getValue() {
        return this.value;
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
     * 设置品名
     * 
     * @param name 品名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 设置厂牌型号
     * 
     * @param brand 厂牌型号
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 设置特征描述
     * 
     * @param feature 特征描述
     */
    public void setFeature(String feature) {
        this.feature = feature;
    }

    /**
     * 设置数量
     * 
     * @param amount 数量
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 设置价值
     * 
     * @param value 价值
     */
    public void setValue(Integer value) {
        this.value = value;
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