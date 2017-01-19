/**
 * SceneBodySurfaceModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 尸表检验信息
 *
 * @author ModelGenerator
 */
public class SceneBodySurface extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 尸体信息ID
     */
    private String bodyId;

    /**
     * 尸体概貌尸长
     */
    private Integer bodyLength;

    /**
     * 尸体概貌肤色
     */
    private String skinColor;

    /**
     * 尸体概貌发育
     */
    private String growth;

    /**
     * 尸体概貌营养
     */
    private String nutrition;

    /**
     * 尸斑
     */
    private String stain;

    /**
     * 尸僵
     */
    private String rigidity;

    /**
     * 尸温测量时间1
     */
    private String measuringTime1;

    /**
     * 尸温测量时间2
     */
    private String measuringTime2;

    /**
     * 测量环境温度1
     */
    private Integer envTemperature1;

    /**
     * 测量环境温度2
     */
    private Integer envTemperature2;

    /**
     * 尸温1
     */
    private Integer bodyTemerature1;

    /**
     * 尸温2
     */
    private Integer bodyTemerature2;

    /**
     * 尸体状况
     */
    private String bodyInfo;

    /**
     * 尸体昆虫情况
     */
    private String insectInfo;

    /**
     * 腐败程度
     */
    private String rottenDegree;

    /**
     * 头面部发色
     */
    private String hairColor;

    /**
     * 头面部发型
     */
    private String hairStyle;

    /**
     * 头面部发长
     */
    private Integer hairLength;

    /**
     * 头面部面色
     */
    private String faceColor;

    /**
     * 头面部眼角膜
     */
    private String cornea;

    /**
     * 头面部瞳孔
     */
    private String pupil;

    /**
     * 头面部眼球
     */
    private String eyeball;

    /**
     * 左球睑结合膜
     */
    private String leftBallLidFilm;

    /**
     * 右球睑结合膜
     */
    private String rightBallLidFilm;

    /**
     * 头面部耳廓
     */
    private String auricle;

    /**
     * 头面部外耳道
     */
    private String externalAuditoryCanal;

    /**
     * 头面部外鼻
     */
    private String externalNose;

    /**
     * 头面部鼻腔
     */
    private String nasalCavity;

    /**
     * 头面部口唇
     */
    private String lips;

    /**
     * 头面部口腔
     */
    private String mouthCavity;

    /**
     * 头面部舌
     */
    private String tongue;

    /**
     * 头面部牙齿
     */
    private String tooth;

    /**
     * 头面部齿龈
     */
    private String gingiva;

    /**
     * 头面部其它
     */
    private String headOther;

    /**
     * 颈项部
     */
    private String neck;

    /**
     * 胸部
     */
    private String chest;

    /**
     * 腹部
     */
    private String belly;

    /**
     * 背臀部
     */
    private String back;

    /**
     * 四肢部
     */
    private String limbs;

    /**
     * 生殖器
     */
    private String genitalOrgan;

    /**
     * 肛门
     */
    private String anus;

    /**
     * 其它
     */
    private String other;

    /**
     * 尸体颜色
     */
    private String stainColor;

    /**
     * 尸斑部位
     */
    private String stainBw;

    /**
     * 尸斑指压
     */
    private String stainZy;

    /**
     * 尸僵颌
     */
    private String rigidityHe;

    /**
     * 尸僵颈
     */
    private String rigidityJing;

    /**
     * 尸僵上肢
     */
    private String rigiditySz;

    /**
     * 尸僵下肢
     */
    private String rigidityXz;

    /**
     * 尸僵强度
     */
    private String rigidityQd;

    /**
     * 头面部瞳孔左
     */
    private String pupilLeft;

    /**
     * 头面部瞳孔右
     */
    private String pupilRight;

    /**
     * 头面部眼球
     */
    private String eyeIfclose;

    /**
     * 头面部外耳道左
     */
    private String canalLeft;

    /**
     * 头面部外耳道右
     */
    private String canalRight;

    /**
     * 测量环境湿度1
     */
    private Integer envSd1;

    /**
     * 测量环境湿度2
     */
    private Integer envSd2;

    /**
     * 尸体面部损伤情况
     */
    private String faceInjureCondition;

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
     * 获得尸体信息ID
     * 
     * @return 尸体信息ID
     */
    public String getBodyId() {
        return this.bodyId;
    }

    /**
     * 获得尸体概貌尸长
     * 
     * @return 尸体概貌尸长
     */
    public Integer getBodyLength() {
        return this.bodyLength;
    }

    /**
     * 获得尸体概貌肤色
     * 
     * @return 尸体概貌肤色
     */
    public String getSkinColor() {
        return this.skinColor;
    }

    /**
     * 获得尸体概貌发育
     * 
     * @return 尸体概貌发育
     */
    public String getGrowth() {
        return this.growth;
    }

    /**
     * 获得尸体概貌营养
     * 
     * @return 尸体概貌营养
     */
    public String getNutrition() {
        return this.nutrition;
    }

    /**
     * 获得尸斑
     * 
     * @return 尸斑
     */
    public String getStain() {
        return this.stain;
    }

    /**
     * 获得尸僵
     * 
     * @return 尸僵
     */
    public String getRigidity() {
        return this.rigidity;
    }

    /**
     * 获得尸温测量时间1
     * 
     * @return 尸温测量时间1
     */
    public String getMeasuringTime1() {
        return this.measuringTime1;
    }

    /**
     * 获得尸温测量时间2
     * 
     * @return 尸温测量时间2
     */
    public String getMeasuringTime2() {
        return this.measuringTime2;
    }

    /**
     * 获得测量环境温度1
     * 
     * @return 测量环境温度1
     */
    public Integer getEnvTemperature1() {
        return this.envTemperature1;
    }

    /**
     * 获得测量环境温度2
     * 
     * @return 测量环境温度2
     */
    public Integer getEnvTemperature2() {
        return this.envTemperature2;
    }

    /**
     * 获得尸温1
     * 
     * @return 尸温1
     */
    public Integer getBodyTemerature1() {
        return this.bodyTemerature1;
    }

    /**
     * 获得尸温2
     * 
     * @return 尸温2
     */
    public Integer getBodyTemerature2() {
        return this.bodyTemerature2;
    }

    /**
     * 获得尸体状况
     * 
     * @return 尸体状况
     */
    public String getBodyInfo() {
        return this.bodyInfo;
    }

    /**
     * 获得尸体昆虫情况
     * 
     * @return 尸体昆虫情况
     */
    public String getInsectInfo() {
        return this.insectInfo;
    }

    /**
     * 获得腐败程度
     * 
     * @return 腐败程度
     */
    public String getRottenDegree() {
        return this.rottenDegree;
    }

    /**
     * 获得头面部发色
     * 
     * @return 头面部发色
     */
    public String getHairColor() {
        return this.hairColor;
    }

    /**
     * 获得头面部发型
     * 
     * @return 头面部发型
     */
    public String getHairStyle() {
        return this.hairStyle;
    }

    /**
     * 获得头面部发长
     * 
     * @return 头面部发长
     */
    public Integer getHairLength() {
        return this.hairLength;
    }

    /**
     * 获得头面部面色
     * 
     * @return 头面部面色
     */
    public String getFaceColor() {
        return this.faceColor;
    }

    /**
     * 获得头面部眼角膜
     * 
     * @return 头面部眼角膜
     */
    public String getCornea() {
        return this.cornea;
    }

    /**
     * 获得头面部瞳孔
     * 
     * @return 头面部瞳孔
     */
    public String getPupil() {
        return this.pupil;
    }

    /**
     * 获得头面部眼球
     * 
     * @return 头面部眼球
     */
    public String getEyeball() {
        return this.eyeball;
    }

    /**
     * 获得左球睑结合膜
     * 
     * @return 左球睑结合膜
     */
    public String getLeftBallLidFilm() {
        return this.leftBallLidFilm;
    }

    /**
     * 获得右球睑结合膜
     * 
     * @return 右球睑结合膜
     */
    public String getRightBallLidFilm() {
        return this.rightBallLidFilm;
    }

    /**
     * 获得头面部耳廓
     * 
     * @return 头面部耳廓
     */
    public String getAuricle() {
        return this.auricle;
    }

    /**
     * 获得头面部外耳道
     * 
     * @return 头面部外耳道
     */
    public String getExternalAuditoryCanal() {
        return this.externalAuditoryCanal;
    }

    /**
     * 获得头面部外鼻
     * 
     * @return 头面部外鼻
     */
    public String getExternalNose() {
        return this.externalNose;
    }

    /**
     * 获得头面部鼻腔
     * 
     * @return 头面部鼻腔
     */
    public String getNasalCavity() {
        return this.nasalCavity;
    }

    /**
     * 获得头面部口唇
     * 
     * @return 头面部口唇
     */
    public String getLips() {
        return this.lips;
    }

    /**
     * 获得头面部口腔
     * 
     * @return 头面部口腔
     */
    public String getMouthCavity() {
        return this.mouthCavity;
    }

    /**
     * 获得头面部舌
     * 
     * @return 头面部舌
     */
    public String getTongue() {
        return this.tongue;
    }

    /**
     * 获得头面部牙齿
     * 
     * @return 头面部牙齿
     */
    public String getTooth() {
        return this.tooth;
    }

    /**
     * 获得头面部齿龈
     * 
     * @return 头面部齿龈
     */
    public String getGingiva() {
        return this.gingiva;
    }

    /**
     * 获得头面部其它
     * 
     * @return 头面部其它
     */
    public String getHeadOther() {
        return this.headOther;
    }

    /**
     * 获得颈项部
     * 
     * @return 颈项部
     */
    public String getNeck() {
        return this.neck;
    }

    /**
     * 获得胸部
     * 
     * @return 胸部
     */
    public String getChest() {
        return this.chest;
    }

    /**
     * 获得腹部
     * 
     * @return 腹部
     */
    public String getBelly() {
        return this.belly;
    }

    /**
     * 获得背臀部
     * 
     * @return 背臀部
     */
    public String getBack() {
        return this.back;
    }

    /**
     * 获得四肢部
     * 
     * @return 四肢部
     */
    public String getLimbs() {
        return this.limbs;
    }

    /**
     * 获得生殖器
     * 
     * @return 生殖器
     */
    public String getGenitalOrgan() {
        return this.genitalOrgan;
    }

    /**
     * 获得肛门
     * 
     * @return 肛门
     */
    public String getAnus() {
        return this.anus;
    }

    /**
     * 获得其它
     * 
     * @return 其它
     */
    public String getOther() {
        return this.other;
    }

    /**
     * 获得尸体颜色
     * 
     * @return 尸体颜色
     */
    public String getStainColor() {
        return this.stainColor;
    }

    /**
     * 获得尸斑部位
     * 
     * @return 尸斑部位
     */
    public String getStainBw() {
        return this.stainBw;
    }

    /**
     * 获得尸斑指压
     * 
     * @return 尸斑指压
     */
    public String getStainZy() {
        return this.stainZy;
    }

    /**
     * 获得尸僵颌
     * 
     * @return 尸僵颌
     */
    public String getRigidityHe() {
        return this.rigidityHe;
    }

    /**
     * 获得尸僵颈
     * 
     * @return 尸僵颈
     */
    public String getRigidityJing() {
        return this.rigidityJing;
    }

    /**
     * 获得尸僵上肢
     * 
     * @return 尸僵上肢
     */
    public String getRigiditySz() {
        return this.rigiditySz;
    }

    /**
     * 获得尸僵下肢
     * 
     * @return 尸僵下肢
     */
    public String getRigidityXz() {
        return this.rigidityXz;
    }

    /**
     * 获得尸僵强度
     * 
     * @return 尸僵强度
     */
    public String getRigidityQd() {
        return this.rigidityQd;
    }

    /**
     * 获得头面部瞳孔左
     * 
     * @return 头面部瞳孔左
     */
    public String getPupilLeft() {
        return this.pupilLeft;
    }

    /**
     * 获得头面部瞳孔右
     * 
     * @return 头面部瞳孔右
     */
    public String getPupilRight() {
        return this.pupilRight;
    }

    /**
     * 获得头面部眼球
     * 
     * @return 头面部眼球
     */
    public String getEyeIfclose() {
        return this.eyeIfclose;
    }

    /**
     * 获得头面部外耳道左
     * 
     * @return 头面部外耳道左
     */
    public String getCanalLeft() {
        return this.canalLeft;
    }

    /**
     * 获得头面部外耳道右
     * 
     * @return 头面部外耳道右
     */
    public String getCanalRight() {
        return this.canalRight;
    }

    /**
     * 获得测量环境湿度1
     * 
     * @return 测量环境湿度1
     */
    public Integer getEnvSd1() {
        return this.envSd1;
    }

    /**
     * 获得测量环境湿度2
     * 
     * @return 测量环境湿度2
     */
    public Integer getEnvSd2() {
        return this.envSd2;
    }

    /**
     * 获得尸体面部损伤情况
     * 
     * @return 尸体面部损伤情况
     */
    public String getFaceInjureCondition() {
        return this.faceInjureCondition;
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
     * 设置尸体信息ID
     * 
     * @param bodyId 尸体信息ID
     */
    public void setBodyId(String bodyId) {
        this.bodyId = bodyId;
    }

    /**
     * 设置尸体概貌尸长
     * 
     * @param bodyLength 尸体概貌尸长
     */
    public void setBodyLength(Integer bodyLength) {
        this.bodyLength = bodyLength;
    }

    /**
     * 设置尸体概貌肤色
     * 
     * @param skinColor 尸体概貌肤色
     */
    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    /**
     * 设置尸体概貌发育
     * 
     * @param growth 尸体概貌发育
     */
    public void setGrowth(String growth) {
        this.growth = growth;
    }

    /**
     * 设置尸体概貌营养
     * 
     * @param nutrition 尸体概貌营养
     */
    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    /**
     * 设置尸斑
     * 
     * @param stain 尸斑
     */
    public void setStain(String stain) {
        this.stain = stain;
    }

    /**
     * 设置尸僵
     * 
     * @param rigidity 尸僵
     */
    public void setRigidity(String rigidity) {
        this.rigidity = rigidity;
    }

    /**
     * 设置尸温测量时间1
     * 
     * @param measuringTime1 尸温测量时间1
     */
    public void setMeasuringTime1(String measuringTime1) {
        this.measuringTime1 = measuringTime1;
    }

    /**
     * 设置尸温测量时间2
     * 
     * @param measuringTime2 尸温测量时间2
     */
    public void setMeasuringTime2(String measuringTime2) {
        this.measuringTime2 = measuringTime2;
    }

    /**
     * 设置测量环境温度1
     * 
     * @param envTemperature1 测量环境温度1
     */
    public void setEnvTemperature1(Integer envTemperature1) {
        this.envTemperature1 = envTemperature1;
    }

    /**
     * 设置测量环境温度2
     * 
     * @param envTemperature2 测量环境温度2
     */
    public void setEnvTemperature2(Integer envTemperature2) {
        this.envTemperature2 = envTemperature2;
    }

    /**
     * 设置尸温1
     * 
     * @param bodyTemerature1 尸温1
     */
    public void setBodyTemerature1(Integer bodyTemerature1) {
        this.bodyTemerature1 = bodyTemerature1;
    }

    /**
     * 设置尸温2
     * 
     * @param bodyTemerature2 尸温2
     */
    public void setBodyTemerature2(Integer bodyTemerature2) {
        this.bodyTemerature2 = bodyTemerature2;
    }

    /**
     * 设置尸体状况
     * 
     * @param bodyInfo 尸体状况
     */
    public void setBodyInfo(String bodyInfo) {
        this.bodyInfo = bodyInfo;
    }

    /**
     * 设置尸体昆虫情况
     * 
     * @param insectInfo 尸体昆虫情况
     */
    public void setInsectInfo(String insectInfo) {
        this.insectInfo = insectInfo;
    }

    /**
     * 设置腐败程度
     * 
     * @param rottenDegree 腐败程度
     */
    public void setRottenDegree(String rottenDegree) {
        this.rottenDegree = rottenDegree;
    }

    /**
     * 设置头面部发色
     * 
     * @param hairColor 头面部发色
     */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * 设置头面部发型
     * 
     * @param hairStyle 头面部发型
     */
    public void setHairStyle(String hairStyle) {
        this.hairStyle = hairStyle;
    }

    /**
     * 设置头面部发长
     * 
     * @param hairLength 头面部发长
     */
    public void setHairLength(Integer hairLength) {
        this.hairLength = hairLength;
    }

    /**
     * 设置头面部面色
     * 
     * @param faceColor 头面部面色
     */
    public void setFaceColor(String faceColor) {
        this.faceColor = faceColor;
    }

    /**
     * 设置头面部眼角膜
     * 
     * @param cornea 头面部眼角膜
     */
    public void setCornea(String cornea) {
        this.cornea = cornea;
    }

    /**
     * 设置头面部瞳孔
     * 
     * @param pupil 头面部瞳孔
     */
    public void setPupil(String pupil) {
        this.pupil = pupil;
    }

    /**
     * 设置头面部眼球
     * 
     * @param eyeball 头面部眼球
     */
    public void setEyeball(String eyeball) {
        this.eyeball = eyeball;
    }

    /**
     * 设置左球睑结合膜
     * 
     * @param leftBallLidFilm 左球睑结合膜
     */
    public void setLeftBallLidFilm(String leftBallLidFilm) {
        this.leftBallLidFilm = leftBallLidFilm;
    }

    /**
     * 设置右球睑结合膜
     * 
     * @param rightBallLidFilm 右球睑结合膜
     */
    public void setRightBallLidFilm(String rightBallLidFilm) {
        this.rightBallLidFilm = rightBallLidFilm;
    }

    /**
     * 设置头面部耳廓
     * 
     * @param auricle 头面部耳廓
     */
    public void setAuricle(String auricle) {
        this.auricle = auricle;
    }

    /**
     * 设置头面部外耳道
     * 
     * @param externalAuditoryCanal 头面部外耳道
     */
    public void setExternalAuditoryCanal(String externalAuditoryCanal) {
        this.externalAuditoryCanal = externalAuditoryCanal;
    }

    /**
     * 设置头面部外鼻
     * 
     * @param externalNose 头面部外鼻
     */
    public void setExternalNose(String externalNose) {
        this.externalNose = externalNose;
    }

    /**
     * 设置头面部鼻腔
     * 
     * @param nasalCavity 头面部鼻腔
     */
    public void setNasalCavity(String nasalCavity) {
        this.nasalCavity = nasalCavity;
    }

    /**
     * 设置头面部口唇
     * 
     * @param lips 头面部口唇
     */
    public void setLips(String lips) {
        this.lips = lips;
    }

    /**
     * 设置头面部口腔
     * 
     * @param mouthCavity 头面部口腔
     */
    public void setMouthCavity(String mouthCavity) {
        this.mouthCavity = mouthCavity;
    }

    /**
     * 设置头面部舌
     * 
     * @param tongue 头面部舌
     */
    public void setTongue(String tongue) {
        this.tongue = tongue;
    }

    /**
     * 设置头面部牙齿
     * 
     * @param tooth 头面部牙齿
     */
    public void setTooth(String tooth) {
        this.tooth = tooth;
    }

    /**
     * 设置头面部齿龈
     * 
     * @param gingiva 头面部齿龈
     */
    public void setGingiva(String gingiva) {
        this.gingiva = gingiva;
    }

    /**
     * 设置头面部其它
     * 
     * @param headOther 头面部其它
     */
    public void setHeadOther(String headOther) {
        this.headOther = headOther;
    }

    /**
     * 设置颈项部
     * 
     * @param neck 颈项部
     */
    public void setNeck(String neck) {
        this.neck = neck;
    }

    /**
     * 设置胸部
     * 
     * @param chest 胸部
     */
    public void setChest(String chest) {
        this.chest = chest;
    }

    /**
     * 设置腹部
     * 
     * @param belly 腹部
     */
    public void setBelly(String belly) {
        this.belly = belly;
    }

    /**
     * 设置背臀部
     * 
     * @param back 背臀部
     */
    public void setBack(String back) {
        this.back = back;
    }

    /**
     * 设置四肢部
     * 
     * @param limbs 四肢部
     */
    public void setLimbs(String limbs) {
        this.limbs = limbs;
    }

    /**
     * 设置生殖器
     * 
     * @param genitalOrgan 生殖器
     */
    public void setGenitalOrgan(String genitalOrgan) {
        this.genitalOrgan = genitalOrgan;
    }

    /**
     * 设置肛门
     * 
     * @param anus 肛门
     */
    public void setAnus(String anus) {
        this.anus = anus;
    }

    /**
     * 设置其它
     * 
     * @param other 其它
     */
    public void setOther(String other) {
        this.other = other;
    }

    /**
     * 设置尸体颜色
     * 
     * @param stainColor 尸体颜色
     */
    public void setStainColor(String stainColor) {
        this.stainColor = stainColor;
    }

    /**
     * 设置尸斑部位
     * 
     * @param stainBw 尸斑部位
     */
    public void setStainBw(String stainBw) {
        this.stainBw = stainBw;
    }

    /**
     * 设置尸斑指压
     * 
     * @param stainZy 尸斑指压
     */
    public void setStainZy(String stainZy) {
        this.stainZy = stainZy;
    }

    /**
     * 设置尸僵颌
     * 
     * @param rigidityHe 尸僵颌
     */
    public void setRigidityHe(String rigidityHe) {
        this.rigidityHe = rigidityHe;
    }

    /**
     * 设置尸僵颈
     * 
     * @param rigidityJing 尸僵颈
     */
    public void setRigidityJing(String rigidityJing) {
        this.rigidityJing = rigidityJing;
    }

    /**
     * 设置尸僵上肢
     * 
     * @param rigiditySz 尸僵上肢
     */
    public void setRigiditySz(String rigiditySz) {
        this.rigiditySz = rigiditySz;
    }

    /**
     * 设置尸僵下肢
     * 
     * @param rigidityXz 尸僵下肢
     */
    public void setRigidityXz(String rigidityXz) {
        this.rigidityXz = rigidityXz;
    }

    /**
     * 设置尸僵强度
     * 
     * @param rigidityQd 尸僵强度
     */
    public void setRigidityQd(String rigidityQd) {
        this.rigidityQd = rigidityQd;
    }

    /**
     * 设置头面部瞳孔左
     * 
     * @param pupilLeft 头面部瞳孔左
     */
    public void setPupilLeft(String pupilLeft) {
        this.pupilLeft = pupilLeft;
    }

    /**
     * 设置头面部瞳孔右
     * 
     * @param pupilRight 头面部瞳孔右
     */
    public void setPupilRight(String pupilRight) {
        this.pupilRight = pupilRight;
    }

    /**
     * 设置头面部眼球
     * 
     * @param eyeIfclose 头面部眼球
     */
    public void setEyeIfclose(String eyeIfclose) {
        this.eyeIfclose = eyeIfclose;
    }

    /**
     * 设置头面部外耳道左
     * 
     * @param canalLeft 头面部外耳道左
     */
    public void setCanalLeft(String canalLeft) {
        this.canalLeft = canalLeft;
    }

    /**
     * 设置头面部外耳道右
     * 
     * @param canalRight 头面部外耳道右
     */
    public void setCanalRight(String canalRight) {
        this.canalRight = canalRight;
    }

    /**
     * 设置测量环境湿度1
     * 
     * @param envSd1 测量环境湿度1
     */
    public void setEnvSd1(Integer envSd1) {
        this.envSd1 = envSd1;
    }

    /**
     * 设置测量环境湿度2
     * 
     * @param envSd2 测量环境湿度2
     */
    public void setEnvSd2(Integer envSd2) {
        this.envSd2 = envSd2;
    }

    /**
     * 设置尸体面部损伤情况
     * 
     * @param faceInjureCondition 尸体面部损伤情况
     */
    public void setFaceInjureCondition(String faceInjureCondition) {
        this.faceInjureCondition = faceInjureCondition;
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