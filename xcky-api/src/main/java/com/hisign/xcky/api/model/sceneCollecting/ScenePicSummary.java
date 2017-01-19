/**
 * ScenePicSummaryModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 现场相关图片数量汇总
 *
 * @author ModelGenerator
 */
public class ScenePicSummary extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 指纹痕迹数量
     */
    private Integer handprintAmount;

    /**
     * 足迹痕迹数量
     */
    private Integer footprintAmount;

    /**
     * 工具痕迹数量
     */
    private Integer toolmarkAmount;

    /**
     * 枪弹痕迹数量
     */
    private Integer bulletprintAmount;

    /**
     * 特殊痕迹数量
     */
    private Integer specialprintAmount;

    /**
     * 生物物证数量
     */
    private Integer bioEvidenceAmount;

    /**
     * 毒化物证数量
     */
    private Integer toxicEvidenceAmount;

    /**
     * 理化物证数量
     */
    private Integer physicalEvidenceAmount;

    /**
     * 文检物证数量
     */
    private Integer fileEvidenceAmount;

    /**
     * 电子物证数量
     */
    private Integer electroEvidenceAmount;

    /**
     * 视听物证数量
     */
    private Integer videoEvidenceAmount;

    /**
     * 其他物证数量
     */
    private Integer otherEvidenceAmount;

    /**
     * 现场图数量
     */
    private Integer scenePictureAmount;

    /**
     * 平面图数量
     */
    private Integer planeGraphAmount;

    /**
     * 方位图数量
     */
    private Integer orientationMapAmount;
    
    /**
     * 现场照片数量
     */
    private Integer scenePhotoAmount;

    /**
     * 概貌图片数量
     */
    private Integer profilePictureAmount;

    /**
     * 细目图片数量
     */
    private Integer detailPictureAmount;

    /**
     * 重点部位图片数量
     */
    private Integer focusPartPicAmount;

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
     * 获得指纹痕迹数量
     * 
     * @return 指纹痕迹数量
     */
    public Integer getHandprintAmount() {
        return this.handprintAmount;
    }

    /**
     * 获得足迹痕迹数量
     * 
     * @return 足迹痕迹数量
     */
    public Integer getFootprintAmount() {
        return this.footprintAmount;
    }

    /**
     * 获得工具痕迹数量
     * 
     * @return 工具痕迹数量
     */
    public Integer getToolmarkAmount() {
        return this.toolmarkAmount;
    }

    /**
     * 获得枪弹痕迹数量
     * 
     * @return 枪弹痕迹数量
     */
    public Integer getBulletprintAmount() {
        return this.bulletprintAmount;
    }

    /**
     * 获得特殊痕迹数量
     * 
     * @return 特殊痕迹数量
     */
    public Integer getSpecialprintAmount() {
        return this.specialprintAmount;
    }

    /**
     * 获得生物物证数量
     * 
     * @return 生物物证数量
     */
    public Integer getBioEvidenceAmount() {
        return this.bioEvidenceAmount;
    }

    /**
     * 获得毒化物证数量
     * 
     * @return 毒化物证数量
     */
    public Integer getToxicEvidenceAmount() {
        return this.toxicEvidenceAmount;
    }

    /**
     * 获得理化物证数量
     * 
     * @return 理化物证数量
     */
    public Integer getPhysicalEvidenceAmount() {
        return this.physicalEvidenceAmount;
    }

    /**
     * 获得文检物证数量
     * 
     * @return 文检物证数量
     */
    public Integer getFileEvidenceAmount() {
        return this.fileEvidenceAmount;
    }

    /**
     * 获得电子物证数量
     * 
     * @return 电子物证数量
     */
    public Integer getElectroEvidenceAmount() {
        return this.electroEvidenceAmount;
    }

    /**
     * 获得视听物证数量
     * 
     * @return 视听物证数量
     */
    public Integer getVideoEvidenceAmount() {
        return this.videoEvidenceAmount;
    }

    /**
     * 获得其他物证数量
     * 
     * @return 其他物证数量
     */
    public Integer getOtherEvidenceAmount() {
        return this.otherEvidenceAmount;
    }

    /**
     * 获得现场照片数量
     * 
     * @return 现场照片数量
     */
    public Integer getScenePhotoAmount() {
        return this.scenePhotoAmount;
    }

    /**
     * 获得现场图数量
     * 
     * @return 现场图数量
     */
    public Integer getScenePictureAmount() {
        return this.scenePictureAmount;
    }

    /**
     * 获得平面图数量
     * 
     * @return 平面图数量
     */
    public Integer getPlaneGraphAmount() {
        return this.planeGraphAmount;
    }

    /**
     * 获得方位图数量
     * 
     * @return 方位图数量
     */
    public Integer getOrientationMapAmount() {
        return this.orientationMapAmount;
    }

    /**
     * 获得概貌图片数量
     * 
     * @return 概貌图片数量
     */
    public Integer getProfilePictureAmount() {
        return this.profilePictureAmount;
    }

    /**
     * 获得细目图片数量
     * 
     * @return 细目图片数量
     */
    public Integer getDetailPictureAmount() {
        return this.detailPictureAmount;
    }

    /**
     * 获得重点部位图片数量
     * 
     * @return 重点部位图片数量
     */
    public Integer getFocusPartPicAmount() {
        return this.focusPartPicAmount;
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
     * 设置指纹痕迹数量
     * 
     * @param handprintAmount 指纹痕迹数量
     */
    public void setHandprintAmount(Integer handprintAmount) {
        this.handprintAmount = handprintAmount;
    }

    /**
     * 设置足迹痕迹数量
     * 
     * @param footprintAmount 足迹痕迹数量
     */
    public void setFootprintAmount(Integer footprintAmount) {
        this.footprintAmount = footprintAmount;
    }

    /**
     * 设置工具痕迹数量
     * 
     * @param toolmarkAmount 工具痕迹数量
     */
    public void setToolmarkAmount(Integer toolmarkAmount) {
        this.toolmarkAmount = toolmarkAmount;
    }

    /**
     * 设置枪弹痕迹数量
     * 
     * @param bulletprintAmount 枪弹痕迹数量
     */
    public void setBulletprintAmount(Integer bulletprintAmount) {
        this.bulletprintAmount = bulletprintAmount;
    }

    /**
     * 设置特殊痕迹数量
     * 
     * @param specialprintAmount 特殊痕迹数量
     */
    public void setSpecialprintAmount(Integer specialprintAmount) {
        this.specialprintAmount = specialprintAmount;
    }

    /**
     * 设置生物物证数量
     * 
     * @param bioEvidenceAmount 生物物证数量
     */
    public void setBioEvidenceAmount(Integer bioEvidenceAmount) {
        this.bioEvidenceAmount = bioEvidenceAmount;
    }

    /**
     * 设置毒化物证数量
     * 
     * @param toxicEvidenceAmount 毒化物证数量
     */
    public void setToxicEvidenceAmount(Integer toxicEvidenceAmount) {
        this.toxicEvidenceAmount = toxicEvidenceAmount;
    }

    /**
     * 设置理化物证数量
     * 
     * @param physicalEvidenceAmount 理化物证数量
     */
    public void setPhysicalEvidenceAmount(Integer physicalEvidenceAmount) {
        this.physicalEvidenceAmount = physicalEvidenceAmount;
    }

    /**
     * 设置文检物证数量
     * 
     * @param fileEvidenceAmount 文检物证数量
     */
    public void setFileEvidenceAmount(Integer fileEvidenceAmount) {
        this.fileEvidenceAmount = fileEvidenceAmount;
    }

    /**
     * 设置电子物证数量
     * 
     * @param electroEvidenceAmount 电子物证数量
     */
    public void setElectroEvidenceAmount(Integer electroEvidenceAmount) {
        this.electroEvidenceAmount = electroEvidenceAmount;
    }

    /**
     * 设置视听物证数量
     * 
     * @param videoEvidenceAmount 视听物证数量
     */
    public void setVideoEvidenceAmount(Integer videoEvidenceAmount) {
        this.videoEvidenceAmount = videoEvidenceAmount;
    }

    /**
     * 设置其他物证数量
     * 
     * @param otherEvidenceAmount 其他物证数量
     */
    public void setOtherEvidenceAmount(Integer otherEvidenceAmount) {
        this.otherEvidenceAmount = otherEvidenceAmount;
    }

    /**
     * 设置现场照片数量
     * 
     * @param scenePhotoAmount 现场照片数量
     */
    public void setScenePhotoAmount(Integer scenePhotoAmount) {
        this.scenePhotoAmount = scenePhotoAmount;
    }

    /**
     * 设置现场图数量
     * 
     * @param scenePictureAmount 现场图数量
     */
    public void setScenePictureAmount(Integer scenePictureAmount) {
        this.scenePictureAmount = scenePictureAmount;
    }

    /**
     * 设置平面图数量
     * 
     * @param planeGraphAmount 平面图数量
     */
    public void setPlaneGraphAmount(Integer planeGraphAmount) {
        this.planeGraphAmount = planeGraphAmount;
    }

    /**
     * 设置方位图数量
     * 
     * @param orientationMapAmount 方位图数量
     */
    public void setOrientationMapAmount(Integer orientationMapAmount) {
        this.orientationMapAmount = orientationMapAmount;
    }

    /**
     * 设置概貌图片数量
     * 
     * @param profilePictureAmount 概貌图片数量
     */
    public void setProfilePictureAmount(Integer profilePictureAmount) {
        this.profilePictureAmount = profilePictureAmount;
    }

    /**
     * 设置细目图片数量
     * 
     * @param detailPictureAmount 细目图片数量
     */
    public void setDetailPictureAmount(Integer detailPictureAmount) {
        this.detailPictureAmount = detailPictureAmount;
    }

    /**
     * 设置重点部位图片数量
     * 
     * @param focusPartPicAmount 重点部位图片数量
     */
    public void setFocusPartPicAmount(Integer focusPartPicAmount) {
        this.focusPartPicAmount = focusPartPicAmount;
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