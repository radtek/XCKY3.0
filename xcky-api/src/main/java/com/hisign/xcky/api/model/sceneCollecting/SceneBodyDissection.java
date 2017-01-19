/**
 * SceneBodyDissectionModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 尸体解剖检验信息
 *
 * @author ModelGenerator
 */
public class SceneBodyDissection extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 尸体信息ID
     */
    private String bodyId;

    /**
     * 检验时间（起）
     */
    private java.util.Date examinationTimeFrom;

    /**
     * 检验时间（止）
     */
    private java.util.Date examinationTimeTo;

    /**
     * 检验地点
     */
    private String examinationPlace;

    /**
     * 头皮
     */
    private String scalp;

    /**
     * 颞肌左
     */
    private String niejiLeft;

    /**
     * 颞肌右
     */
    private String niejiRight;

    /**
     * 帽状腱膜
     */
    private String mzjm;

    /**
     * 颅盖
     */
    private String cranialUp;

    /**
     * 颅底
     */
    private String cranialDown;

    /**
     * 面颅
     */
    private String cranialFace;

    /**
     * 颅骨
     */
    private String cranialBone;

    /**
     * 脑膜
     */
    private String meningo;

    /**
     * 硬膜外
     */
    private String meningoOut;

    /**
     * 硬膜下
     */
    private String meningoIn;

    /**
     * 蛛网膜下腔
     */
    private String meningoZwmxq;

    /**
     * 全脑重
脑沟回
全脑重
     */
    private String brainZl;

    /**
     * 脑沟回
     */
    private String brainGh;

    /**
     * 脑血管
     */
    private String brainXg;

    /**
     * 各脑室
     */
    private String brainGns;

    /**
     * 大脑
     */
    private String brainDn;

    /**
     * 小脑
     */
    private String brainXn;

    /**
     * 脑干
     */
    private String brainNg;

    /**
     * 脑垂体
     */
    private String brainNct;

    /**
     * 组织
     */
    private String brainTissue;

    /**
     * 颈部皮下组织
     */
    private String neckPxzz;

    /**
     * 颈部肌肉
     */
    private String neckJr;

    /**
     * 颈部大血管
     */
    private String neckDxg;

    /**
     * 颈部甲状腺
     */
    private String neckJzx;

    /**
     * 颌下腺
     */
    private String neckHxx;

    /**
     * 舌骨
     */
    private String neckSg;

    /**
     * 甲状软骨
     */
    private String neckJzrg;

    /**
     * 环状软骨
     */
    private String neckHzrg;

    /**
     * 会厌
     */
    private String neckHy;

    /**
     * 咽喉粘膜
     */
    private String neckYhnm;

    /**
     * 喉头
     */
    private String neckHt;

    /**
     * 扁桃体
     */
    private String neckBtt;

    /**
     * 椎前筋膜
     */
    private String neckZqjm;

    /**
     * 颈椎
     */
    private String neckJz;

    /**
     * 胸壁
     */
    private String chestWall;

    /**
     * 胸骨
     */
    private String chestBone;

    /**
     * 肋骨
     */
    private String chestNg;

    /**
     * 胸膜
     */
    private String chestPleura;

    /**
     * 胸腔左
     */
    private String chestLeft;

    /**
     * 胸腔右
     */
    private String chestRight;

    /**
     * 胸腺
     */
    private String chestXxzl;

    /**
     * 心包
     */
    private String heartSac;

    /**
     * 心包腔
     */
    private String heartSacq;

    /**
     * 心脏重量
     */
    private String heartZl;

    /**
     * 心脏外观
     */
    private String heartWg;

    /**
     * 心脏外膜
     */
    private String heartWm;

    /**
     * 心脏内膜
     */
    private String heartNm;

    /**
     * 左心室厚
     */
    private String heartLefth;

    /**
     * 右心室厚
     */
    private String heartRighth;

    /**
     * 室间隔厚
     */
    private String heartBetwh;

    /**
     * 心肌
     */
    private String heartXj;

    /**
     * 心腔
     */
    private String heartXq;

    /**
     * 三尖瓣周径
     */
    private String heartSjbzj;

    /**
     * 三尖瓣膜
     */
    private String heartSjbm;

    /**
     * 肺动脉瓣周径
     */
    private String heartFdmbzj;

    /**
     * 肺动脉瓣膜
     */
    private String heartFdmbm;

    /**
     * 二尖瓣周径
     */
    private String heartEjbzj;

    /**
     * 二尖瓣膜
     */
    private String heartEjbm;

    /**
     * 主动脉瓣周径
     */
    private String heartZdmbzj;

    /**
     * 主动脉瓣膜
     */
    private String heartZdmbm;

    /**
     * 大血管
     */
    private String heartDxg;

    /**
     * 冠状动脉口左
     */
    private String heartGzdmkz;

    /**
     * 冠状动脉口右
     */
    private String heartGzdmky;

    /**
     * 冠状动脉
     */
    private String heartGzdm;

    /**
     * 气管
     */
    private String tracheaQg;

    /**
     * 支气管左
     */
    private String tracheaZqgz;

    /**
     * 支气管右
     */
    private String tracheaZqgy;

    /**
     * 左肺重量
     */
    private String lungLeftzl;

    /**
     * 左肺表面
     */
    private String lungLeftbm;

    /**
     * 左肺质地
     */
    private String lungLeftzd;

    /**
     * 左肺切面
     */
    private String lungLeftqm;

    /**
     * 右肺重量
     */
    private String lungRightzl;

    /**
     * 右肺表面
     */
    private String lungRightbm;

    /**
     * 右肺质地
     */
    private String lungRightzd;

    /**
     * 右肺切面
     */
    private String lungRightqm;

    /**
     * 腹壁
     */
    private String abdominalWall;

    /**
     * 腹腔
     */
    private String abdominalCavity;

    /**
     * 网膜
     */
    private String abdominalRetina;

    /**
     * 腹膜
     */
    private String abdominalFm;

    /**
     * 器官位置
     */
    private String abdominalQgwz;

    /**
     * 食道
     */
    private String gullet;

    /**
     * 胃内容物性状
     */
    private String stomachObjectProperty;

    /**
     * 胃内容物量
     */
    private Integer stomachObjectAmount;

    /**
     * 胃内容物量单位
     */
    private String stomachObjectUnit;

    /**
     * 胃内容物成分
     */
    private String stomachObjectComponent;

    /**
     * 胃粘膜
     */
    private String gastricMucosa;

    /**
     * 肠管
     */
    private String intestinalCanal;

    /**
     * 肠系膜
     */
    private String mesenterium;

    /**
     * 胰腺重量
     */
    private String pancreasZl;

    /**
     * 胰腺颜色
     */
    private String pancreasYs;

    /**
     * 胰腺切面
     */
    private String pancreasQm;

    /**
     * 肝脏重量
     */
    private String liverZl;

    /**
     * 肝脏被膜
     */
    private String liverYzbm;

    /**
     * 肝脏表面
     */
    private String liverBm;

    /**
     * 肝脏切面
     */
    private String liverQm;

    /**
     * 脾脏重量
     */
    private String lienZl;

    /**
     * 脾脏被膜
     */
    private String lienYzbm;

    /**
     * 脾脏表面
     */
    private String lienBm;

    /**
     * 脾脏切面
     */
    private String lienQm;

    /**
     * 左肾重量
     */
    private String kidneyLeftZl;

    /**
     * 左肾被膜
     */
    private String kidneyLeftYzbm;

    /**
     * 左肾表面
     */
    private String kidneyLeftBm;

    /**
     * 左肾切面
     */
    private String kidneyLeftQm;

    /**
     * 右肾重量
     */
    private String kidneyRightZl;

    /**
     * 右肾被膜
     */
    private String kidneyRightYzbm;

    /**
     * 右肾表面
     */
    private String kidneyRightBm;

    /**
     * 右肾切面
     */
    private String kidneyRightQm;

    /**
     * 输尿管
     */
    private String kidneySng;

    /**
     * 肾上腺左重量
     */
    private String adrenalLeftzl;

    /**
     * 肾上腺左性状
     */
    private String adrenalLeftxz;

    /**
     * 肾上腺右重量
     */
    private String adrenalRightzl;

    /**
     * 肾上腺右性状
     */
    private String adrenalRightxz;

    /**
     * 膀胱
     */
    private String bladder;

    /**
     * 膀胱尿量
     */
    private String bladderNl;

    /**
     * 膀胱尿颜色
     */
    private String bladderNys;

    /**
     * 膀胱浊度
     */
    private String bladderNzd;

    /**
     * 子宫
     */
    private String uterus;

    /**
     * 子宫大小
     */
    private String uterusDx;

    /**
     * 子宫宫颈
     */
    private String uterusGj;

    /**
     * 子宫宫腔
     */
    private String uterusGq;

    /**
     * 子宫内膜
     */
    private String uterusNm;

    /**
     * 输卵管及卵巢
     */
    private String ovaryOviduct;

    /**
     * 睾丸及附睾
     */
    private String spermary;

    /**
     * 脊柱、脊髓、四肢等
     */
    private String spondyle;

    /**
     * 其他特殊尸体检验
     */
    private String specialRemark;

    /**
     * 其它
     */
    private String other;

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
     * 获得检验时间（起）
     * 
     * @return 检验时间（起）
     */
    public java.util.Date getExaminationTimeFrom() {
        return this.examinationTimeFrom;
    }

    /**
     * 获得检验时间（止）
     * 
     * @return 检验时间（止）
     */
    public java.util.Date getExaminationTimeTo() {
        return this.examinationTimeTo;
    }

    /**
     * 获得检验地点
     * 
     * @return 检验地点
     */
    public String getExaminationPlace() {
        return this.examinationPlace;
    }

    /**
     * 获得头皮
     * 
     * @return 头皮
     */
    public String getScalp() {
        return this.scalp;
    }

    /**
     * 获得颞肌左
     * 
     * @return 颞肌左
     */
    public String getNiejiLeft() {
        return this.niejiLeft;
    }

    /**
     * 获得颞肌右
     * 
     * @return 颞肌右
     */
    public String getNiejiRight() {
        return this.niejiRight;
    }

    /**
     * 获得帽状腱膜
     * 
     * @return 帽状腱膜
     */
    public String getMzjm() {
        return this.mzjm;
    }

    /**
     * 获得颅盖
     * 
     * @return 颅盖
     */
    public String getCranialUp() {
        return this.cranialUp;
    }

    /**
     * 获得颅底
     * 
     * @return 颅底
     */
    public String getCranialDown() {
        return this.cranialDown;
    }

    /**
     * 获得面颅
     * 
     * @return 面颅
     */
    public String getCranialFace() {
        return this.cranialFace;
    }

    /**
     * 获得颅骨
     * 
     * @return 颅骨
     */
    public String getCranialBone() {
        return this.cranialBone;
    }

    /**
     * 获得脑膜
     * 
     * @return 脑膜
     */
    public String getMeningo() {
        return this.meningo;
    }

    /**
     * 获得硬膜外
     * 
     * @return 硬膜外
     */
    public String getMeningoOut() {
        return this.meningoOut;
    }

    /**
     * 获得硬膜下
     * 
     * @return 硬膜下
     */
    public String getMeningoIn() {
        return this.meningoIn;
    }

    /**
     * 获得蛛网膜下腔
     * 
     * @return 蛛网膜下腔
     */
    public String getMeningoZwmxq() {
        return this.meningoZwmxq;
    }

    /**
     * 获得全脑重
脑沟回
全脑重
     * 
     * @return 全脑重
脑沟回
全脑重
     */
    public String getBrainZl() {
        return this.brainZl;
    }

    /**
     * 获得脑沟回
     * 
     * @return 脑沟回
     */
    public String getBrainGh() {
        return this.brainGh;
    }

    /**
     * 获得脑血管
     * 
     * @return 脑血管
     */
    public String getBrainXg() {
        return this.brainXg;
    }

    /**
     * 获得各脑室
     * 
     * @return 各脑室
     */
    public String getBrainGns() {
        return this.brainGns;
    }

    /**
     * 获得大脑
     * 
     * @return 大脑
     */
    public String getBrainDn() {
        return this.brainDn;
    }

    /**
     * 获得小脑
     * 
     * @return 小脑
     */
    public String getBrainXn() {
        return this.brainXn;
    }

    /**
     * 获得脑干
     * 
     * @return 脑干
     */
    public String getBrainNg() {
        return this.brainNg;
    }

    /**
     * 获得脑垂体
     * 
     * @return 脑垂体
     */
    public String getBrainNct() {
        return this.brainNct;
    }

    /**
     * 获得组织
     * 
     * @return 组织
     */
    public String getBrainTissue() {
        return this.brainTissue;
    }

    /**
     * 获得颈部皮下组织
     * 
     * @return 颈部皮下组织
     */
    public String getNeckPxzz() {
        return this.neckPxzz;
    }

    /**
     * 获得颈部肌肉
     * 
     * @return 颈部肌肉
     */
    public String getNeckJr() {
        return this.neckJr;
    }

    /**
     * 获得颈部大血管
     * 
     * @return 颈部大血管
     */
    public String getNeckDxg() {
        return this.neckDxg;
    }

    /**
     * 获得颈部甲状腺
     * 
     * @return 颈部甲状腺
     */
    public String getNeckJzx() {
        return this.neckJzx;
    }

    /**
     * 获得颌下腺
     * 
     * @return 颌下腺
     */
    public String getNeckHxx() {
        return this.neckHxx;
    }

    /**
     * 获得舌骨
     * 
     * @return 舌骨
     */
    public String getNeckSg() {
        return this.neckSg;
    }

    /**
     * 获得甲状软骨
     * 
     * @return 甲状软骨
     */
    public String getNeckJzrg() {
        return this.neckJzrg;
    }

    /**
     * 获得环状软骨
     * 
     * @return 环状软骨
     */
    public String getNeckHzrg() {
        return this.neckHzrg;
    }

    /**
     * 获得会厌
     * 
     * @return 会厌
     */
    public String getNeckHy() {
        return this.neckHy;
    }

    /**
     * 获得咽喉粘膜
     * 
     * @return 咽喉粘膜
     */
    public String getNeckYhnm() {
        return this.neckYhnm;
    }

    /**
     * 获得喉头
     * 
     * @return 喉头
     */
    public String getNeckHt() {
        return this.neckHt;
    }

    /**
     * 获得扁桃体
     * 
     * @return 扁桃体
     */
    public String getNeckBtt() {
        return this.neckBtt;
    }

    /**
     * 获得椎前筋膜
     * 
     * @return 椎前筋膜
     */
    public String getNeckZqjm() {
        return this.neckZqjm;
    }

    /**
     * 获得颈椎
     * 
     * @return 颈椎
     */
    public String getNeckJz() {
        return this.neckJz;
    }

    /**
     * 获得胸壁
     * 
     * @return 胸壁
     */
    public String getChestWall() {
        return this.chestWall;
    }

    /**
     * 获得胸骨
     * 
     * @return 胸骨
     */
    public String getChestBone() {
        return this.chestBone;
    }

    /**
     * 获得肋骨
     * 
     * @return 肋骨
     */
    public String getChestNg() {
        return this.chestNg;
    }

    /**
     * 获得胸膜
     * 
     * @return 胸膜
     */
    public String getChestPleura() {
        return this.chestPleura;
    }

    /**
     * 获得胸腔左
     * 
     * @return 胸腔左
     */
    public String getChestLeft() {
        return this.chestLeft;
    }

    /**
     * 获得胸腔右
     * 
     * @return 胸腔右
     */
    public String getChestRight() {
        return this.chestRight;
    }

    /**
     * 获得胸腺
     * 
     * @return 胸腺
     */
    public String getChestXxzl() {
        return this.chestXxzl;
    }

    /**
     * 获得心包
     * 
     * @return 心包
     */
    public String getHeartSac() {
        return this.heartSac;
    }

    /**
     * 获得心包腔
     * 
     * @return 心包腔
     */
    public String getHeartSacq() {
        return this.heartSacq;
    }

    /**
     * 获得心脏重量
     * 
     * @return 心脏重量
     */
    public String getHeartZl() {
        return this.heartZl;
    }

    /**
     * 获得心脏外观
     * 
     * @return 心脏外观
     */
    public String getHeartWg() {
        return this.heartWg;
    }

    /**
     * 获得心脏外膜
     * 
     * @return 心脏外膜
     */
    public String getHeartWm() {
        return this.heartWm;
    }

    /**
     * 获得心脏内膜
     * 
     * @return 心脏内膜
     */
    public String getHeartNm() {
        return this.heartNm;
    }

    /**
     * 获得左心室厚
     * 
     * @return 左心室厚
     */
    public String getHeartLefth() {
        return this.heartLefth;
    }

    /**
     * 获得右心室厚
     * 
     * @return 右心室厚
     */
    public String getHeartRighth() {
        return this.heartRighth;
    }

    /**
     * 获得室间隔厚
     * 
     * @return 室间隔厚
     */
    public String getHeartBetwh() {
        return this.heartBetwh;
    }

    /**
     * 获得心肌
     * 
     * @return 心肌
     */
    public String getHeartXj() {
        return this.heartXj;
    }

    /**
     * 获得心腔
     * 
     * @return 心腔
     */
    public String getHeartXq() {
        return this.heartXq;
    }

    /**
     * 获得三尖瓣周径
     * 
     * @return 三尖瓣周径
     */
    public String getHeartSjbzj() {
        return this.heartSjbzj;
    }

    /**
     * 获得三尖瓣膜
     * 
     * @return 三尖瓣膜
     */
    public String getHeartSjbm() {
        return this.heartSjbm;
    }

    /**
     * 获得肺动脉瓣周径
     * 
     * @return 肺动脉瓣周径
     */
    public String getHeartFdmbzj() {
        return this.heartFdmbzj;
    }

    /**
     * 获得肺动脉瓣膜
     * 
     * @return 肺动脉瓣膜
     */
    public String getHeartFdmbm() {
        return this.heartFdmbm;
    }

    /**
     * 获得二尖瓣周径
     * 
     * @return 二尖瓣周径
     */
    public String getHeartEjbzj() {
        return this.heartEjbzj;
    }

    /**
     * 获得二尖瓣膜
     * 
     * @return 二尖瓣膜
     */
    public String getHeartEjbm() {
        return this.heartEjbm;
    }

    /**
     * 获得主动脉瓣周径
     * 
     * @return 主动脉瓣周径
     */
    public String getHeartZdmbzj() {
        return this.heartZdmbzj;
    }

    /**
     * 获得主动脉瓣膜
     * 
     * @return 主动脉瓣膜
     */
    public String getHeartZdmbm() {
        return this.heartZdmbm;
    }

    /**
     * 获得大血管
     * 
     * @return 大血管
     */
    public String getHeartDxg() {
        return this.heartDxg;
    }

    /**
     * 获得冠状动脉口左
     * 
     * @return 冠状动脉口左
     */
    public String getHeartGzdmkz() {
        return this.heartGzdmkz;
    }

    /**
     * 获得冠状动脉口右
     * 
     * @return 冠状动脉口右
     */
    public String getHeartGzdmky() {
        return this.heartGzdmky;
    }

    /**
     * 获得冠状动脉
     * 
     * @return 冠状动脉
     */
    public String getHeartGzdm() {
        return this.heartGzdm;
    }

    /**
     * 获得气管
     * 
     * @return 气管
     */
    public String getTracheaQg() {
        return this.tracheaQg;
    }

    /**
     * 获得支气管左
     * 
     * @return 支气管左
     */
    public String getTracheaZqgz() {
        return this.tracheaZqgz;
    }

    /**
     * 获得支气管右
     * 
     * @return 支气管右
     */
    public String getTracheaZqgy() {
        return this.tracheaZqgy;
    }

    /**
     * 获得左肺重量
     * 
     * @return 左肺重量
     */
    public String getLungLeftzl() {
        return this.lungLeftzl;
    }

    /**
     * 获得左肺表面
     * 
     * @return 左肺表面
     */
    public String getLungLeftbm() {
        return this.lungLeftbm;
    }

    /**
     * 获得左肺质地
     * 
     * @return 左肺质地
     */
    public String getLungLeftzd() {
        return this.lungLeftzd;
    }

    /**
     * 获得左肺切面
     * 
     * @return 左肺切面
     */
    public String getLungLeftqm() {
        return this.lungLeftqm;
    }

    /**
     * 获得右肺重量
     * 
     * @return 右肺重量
     */
    public String getLungRightzl() {
        return this.lungRightzl;
    }

    /**
     * 获得右肺表面
     * 
     * @return 右肺表面
     */
    public String getLungRightbm() {
        return this.lungRightbm;
    }

    /**
     * 获得右肺质地
     * 
     * @return 右肺质地
     */
    public String getLungRightzd() {
        return this.lungRightzd;
    }

    /**
     * 获得右肺切面
     * 
     * @return 右肺切面
     */
    public String getLungRightqm() {
        return this.lungRightqm;
    }

    /**
     * 获得腹壁
     * 
     * @return 腹壁
     */
    public String getAbdominalWall() {
        return this.abdominalWall;
    }

    /**
     * 获得腹腔
     * 
     * @return 腹腔
     */
    public String getAbdominalCavity() {
        return this.abdominalCavity;
    }

    /**
     * 获得网膜
     * 
     * @return 网膜
     */
    public String getAbdominalRetina() {
        return this.abdominalRetina;
    }

    /**
     * 获得腹膜
     * 
     * @return 腹膜
     */
    public String getAbdominalFm() {
        return this.abdominalFm;
    }

    /**
     * 获得器官位置
     * 
     * @return 器官位置
     */
    public String getAbdominalQgwz() {
        return this.abdominalQgwz;
    }

    /**
     * 获得食道
     * 
     * @return 食道
     */
    public String getGullet() {
        return this.gullet;
    }

    /**
     * 获得胃内容物性状
     * 
     * @return 胃内容物性状
     */
    public String getStomachObjectProperty() {
        return this.stomachObjectProperty;
    }

    /**
     * 获得胃内容物量
     * 
     * @return 胃内容物量
     */
    public Integer getStomachObjectAmount() {
        return this.stomachObjectAmount;
    }

    /**
     * 获得胃内容物量单位
     * 
     * @return 胃内容物量单位
     */
    public String getStomachObjectUnit() {
        return this.stomachObjectUnit;
    }

    /**
     * 获得胃内容物成分
     * 
     * @return 胃内容物成分
     */
    public String getStomachObjectComponent() {
        return this.stomachObjectComponent;
    }

    /**
     * 获得胃粘膜
     * 
     * @return 胃粘膜
     */
    public String getGastricMucosa() {
        return this.gastricMucosa;
    }

    /**
     * 获得肠管
     * 
     * @return 肠管
     */
    public String getIntestinalCanal() {
        return this.intestinalCanal;
    }

    /**
     * 获得肠系膜
     * 
     * @return 肠系膜
     */
    public String getMesenterium() {
        return this.mesenterium;
    }

    /**
     * 获得胰腺重量
     * 
     * @return 胰腺重量
     */
    public String getPancreasZl() {
        return this.pancreasZl;
    }

    /**
     * 获得胰腺颜色
     * 
     * @return 胰腺颜色
     */
    public String getPancreasYs() {
        return this.pancreasYs;
    }

    /**
     * 获得胰腺切面
     * 
     * @return 胰腺切面
     */
    public String getPancreasQm() {
        return this.pancreasQm;
    }

    /**
     * 获得肝脏重量
     * 
     * @return 肝脏重量
     */
    public String getLiverZl() {
        return this.liverZl;
    }

    /**
     * 获得肝脏被膜
     * 
     * @return 肝脏被膜
     */
    public String getLiverYzbm() {
        return this.liverYzbm;
    }

    /**
     * 获得肝脏表面
     * 
     * @return 肝脏表面
     */
    public String getLiverBm() {
        return this.liverBm;
    }

    /**
     * 获得肝脏切面
     * 
     * @return 肝脏切面
     */
    public String getLiverQm() {
        return this.liverQm;
    }

    /**
     * 获得脾脏重量
     * 
     * @return 脾脏重量
     */
    public String getLienZl() {
        return this.lienZl;
    }

    /**
     * 获得脾脏被膜
     * 
     * @return 脾脏被膜
     */
    public String getLienYzbm() {
        return this.lienYzbm;
    }

    /**
     * 获得脾脏表面
     * 
     * @return 脾脏表面
     */
    public String getLienBm() {
        return this.lienBm;
    }

    /**
     * 获得脾脏切面
     * 
     * @return 脾脏切面
     */
    public String getLienQm() {
        return this.lienQm;
    }

    /**
     * 获得左肾重量
     * 
     * @return 左肾重量
     */
    public String getKidneyLeftZl() {
        return this.kidneyLeftZl;
    }

    /**
     * 获得左肾被膜
     * 
     * @return 左肾被膜
     */
    public String getKidneyLeftYzbm() {
        return this.kidneyLeftYzbm;
    }

    /**
     * 获得左肾表面
     * 
     * @return 左肾表面
     */
    public String getKidneyLeftBm() {
        return this.kidneyLeftBm;
    }

    /**
     * 获得左肾切面
     * 
     * @return 左肾切面
     */
    public String getKidneyLeftQm() {
        return this.kidneyLeftQm;
    }

    /**
     * 获得右肾重量
     * 
     * @return 右肾重量
     */
    public String getKidneyRightZl() {
        return this.kidneyRightZl;
    }

    /**
     * 获得右肾被膜
     * 
     * @return 右肾被膜
     */
    public String getKidneyRightYzbm() {
        return this.kidneyRightYzbm;
    }

    /**
     * 获得右肾表面
     * 
     * @return 右肾表面
     */
    public String getKidneyRightBm() {
        return this.kidneyRightBm;
    }

    /**
     * 获得右肾切面
     * 
     * @return 右肾切面
     */
    public String getKidneyRightQm() {
        return this.kidneyRightQm;
    }

    /**
     * 获得输尿管
     * 
     * @return 输尿管
     */
    public String getKidneySng() {
        return this.kidneySng;
    }

    /**
     * 获得肾上腺左重量
     * 
     * @return 肾上腺左重量
     */
    public String getAdrenalLeftzl() {
        return this.adrenalLeftzl;
    }

    /**
     * 获得肾上腺左性状
     * 
     * @return 肾上腺左性状
     */
    public String getAdrenalLeftxz() {
        return this.adrenalLeftxz;
    }

    /**
     * 获得肾上腺右重量
     * 
     * @return 肾上腺右重量
     */
    public String getAdrenalRightzl() {
        return this.adrenalRightzl;
    }

    /**
     * 获得肾上腺右性状
     * 
     * @return 肾上腺右性状
     */
    public String getAdrenalRightxz() {
        return this.adrenalRightxz;
    }

    /**
     * 获得膀胱
     * 
     * @return 膀胱
     */
    public String getBladder() {
        return this.bladder;
    }

    /**
     * 获得膀胱尿量
     * 
     * @return 膀胱尿量
     */
    public String getBladderNl() {
        return this.bladderNl;
    }

    /**
     * 获得膀胱尿颜色
     * 
     * @return 膀胱尿颜色
     */
    public String getBladderNys() {
        return this.bladderNys;
    }

    /**
     * 获得膀胱浊度
     * 
     * @return 膀胱浊度
     */
    public String getBladderNzd() {
        return this.bladderNzd;
    }

    /**
     * 获得子宫
     * 
     * @return 子宫
     */
    public String getUterus() {
        return this.uterus;
    }

    /**
     * 获得子宫大小
     * 
     * @return 子宫大小
     */
    public String getUterusDx() {
        return this.uterusDx;
    }

    /**
     * 获得子宫宫颈
     * 
     * @return 子宫宫颈
     */
    public String getUterusGj() {
        return this.uterusGj;
    }

    /**
     * 获得子宫宫腔
     * 
     * @return 子宫宫腔
     */
    public String getUterusGq() {
        return this.uterusGq;
    }

    /**
     * 获得子宫内膜
     * 
     * @return 子宫内膜
     */
    public String getUterusNm() {
        return this.uterusNm;
    }

    /**
     * 获得输卵管及卵巢
     * 
     * @return 输卵管及卵巢
     */
    public String getOvaryOviduct() {
        return this.ovaryOviduct;
    }

    /**
     * 获得睾丸及附睾
     * 
     * @return 睾丸及附睾
     */
    public String getSpermary() {
        return this.spermary;
    }

    /**
     * 获得脊柱、脊髓、四肢等
     * 
     * @return 脊柱、脊髓、四肢等
     */
    public String getSpondyle() {
        return this.spondyle;
    }

    /**
     * 获得其他特殊尸体检验
     * 
     * @return 其他特殊尸体检验
     */
    public String getSpecialRemark() {
        return this.specialRemark;
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
     * 设置检验时间（起）
     * 
     * @param examinationTimeFrom 检验时间（起）
     */
    public void setExaminationTimeFrom(java.util.Date examinationTimeFrom) {
        this.examinationTimeFrom = examinationTimeFrom;
    }

    /**
     * 设置检验时间（止）
     * 
     * @param examinationTimeTo 检验时间（止）
     */
    public void setExaminationTimeTo(java.util.Date examinationTimeTo) {
        this.examinationTimeTo = examinationTimeTo;
    }

    /**
     * 设置检验地点
     * 
     * @param examinationPlace 检验地点
     */
    public void setExaminationPlace(String examinationPlace) {
        this.examinationPlace = examinationPlace;
    }

    /**
     * 设置头皮
     * 
     * @param scalp 头皮
     */
    public void setScalp(String scalp) {
        this.scalp = scalp;
    }

    /**
     * 设置颞肌左
     * 
     * @param niejiLeft 颞肌左
     */
    public void setNiejiLeft(String niejiLeft) {
        this.niejiLeft = niejiLeft;
    }

    /**
     * 设置颞肌右
     * 
     * @param niejiRight 颞肌右
     */
    public void setNiejiRight(String niejiRight) {
        this.niejiRight = niejiRight;
    }

    /**
     * 设置帽状腱膜
     * 
     * @param mzjm 帽状腱膜
     */
    public void setMzjm(String mzjm) {
        this.mzjm = mzjm;
    }

    /**
     * 设置颅盖
     * 
     * @param cranialUp 颅盖
     */
    public void setCranialUp(String cranialUp) {
        this.cranialUp = cranialUp;
    }

    /**
     * 设置颅底
     * 
     * @param cranialDown 颅底
     */
    public void setCranialDown(String cranialDown) {
        this.cranialDown = cranialDown;
    }

    /**
     * 设置面颅
     * 
     * @param cranialFace 面颅
     */
    public void setCranialFace(String cranialFace) {
        this.cranialFace = cranialFace;
    }

    /**
     * 设置颅骨
     * 
     * @param cranialBone 颅骨
     */
    public void setCranialBone(String cranialBone) {
        this.cranialBone = cranialBone;
    }

    /**
     * 设置脑膜
     * 
     * @param meningo 脑膜
     */
    public void setMeningo(String meningo) {
        this.meningo = meningo;
    }

    /**
     * 设置硬膜外
     * 
     * @param meningoOut 硬膜外
     */
    public void setMeningoOut(String meningoOut) {
        this.meningoOut = meningoOut;
    }

    /**
     * 设置硬膜下
     * 
     * @param meningoIn 硬膜下
     */
    public void setMeningoIn(String meningoIn) {
        this.meningoIn = meningoIn;
    }

    /**
     * 设置蛛网膜下腔
     * 
     * @param meningoZwmxq 蛛网膜下腔
     */
    public void setMeningoZwmxq(String meningoZwmxq) {
        this.meningoZwmxq = meningoZwmxq;
    }

    /**
     * 设置全脑重
脑沟回
全脑重
     * 
     * @param brainZl 全脑重
脑沟回
全脑重
     */
    public void setBrainZl(String brainZl) {
        this.brainZl = brainZl;
    }

    /**
     * 设置脑沟回
     * 
     * @param brainGh 脑沟回
     */
    public void setBrainGh(String brainGh) {
        this.brainGh = brainGh;
    }

    /**
     * 设置脑血管
     * 
     * @param brainXg 脑血管
     */
    public void setBrainXg(String brainXg) {
        this.brainXg = brainXg;
    }

    /**
     * 设置各脑室
     * 
     * @param brainGns 各脑室
     */
    public void setBrainGns(String brainGns) {
        this.brainGns = brainGns;
    }

    /**
     * 设置大脑
     * 
     * @param brainDn 大脑
     */
    public void setBrainDn(String brainDn) {
        this.brainDn = brainDn;
    }

    /**
     * 设置小脑
     * 
     * @param brainXn 小脑
     */
    public void setBrainXn(String brainXn) {
        this.brainXn = brainXn;
    }

    /**
     * 设置脑干
     * 
     * @param brainNg 脑干
     */
    public void setBrainNg(String brainNg) {
        this.brainNg = brainNg;
    }

    /**
     * 设置脑垂体
     * 
     * @param brainNct 脑垂体
     */
    public void setBrainNct(String brainNct) {
        this.brainNct = brainNct;
    }

    /**
     * 设置组织
     * 
     * @param brainTissue 组织
     */
    public void setBrainTissue(String brainTissue) {
        this.brainTissue = brainTissue;
    }

    /**
     * 设置颈部皮下组织
     * 
     * @param neckPxzz 颈部皮下组织
     */
    public void setNeckPxzz(String neckPxzz) {
        this.neckPxzz = neckPxzz;
    }

    /**
     * 设置颈部肌肉
     * 
     * @param neckJr 颈部肌肉
     */
    public void setNeckJr(String neckJr) {
        this.neckJr = neckJr;
    }

    /**
     * 设置颈部大血管
     * 
     * @param neckDxg 颈部大血管
     */
    public void setNeckDxg(String neckDxg) {
        this.neckDxg = neckDxg;
    }

    /**
     * 设置颈部甲状腺
     * 
     * @param neckJzx 颈部甲状腺
     */
    public void setNeckJzx(String neckJzx) {
        this.neckJzx = neckJzx;
    }

    /**
     * 设置颌下腺
     * 
     * @param neckHxx 颌下腺
     */
    public void setNeckHxx(String neckHxx) {
        this.neckHxx = neckHxx;
    }

    /**
     * 设置舌骨
     * 
     * @param neckSg 舌骨
     */
    public void setNeckSg(String neckSg) {
        this.neckSg = neckSg;
    }

    /**
     * 设置甲状软骨
     * 
     * @param neckJzrg 甲状软骨
     */
    public void setNeckJzrg(String neckJzrg) {
        this.neckJzrg = neckJzrg;
    }

    /**
     * 设置环状软骨
     * 
     * @param neckHzrg 环状软骨
     */
    public void setNeckHzrg(String neckHzrg) {
        this.neckHzrg = neckHzrg;
    }

    /**
     * 设置会厌
     * 
     * @param neckHy 会厌
     */
    public void setNeckHy(String neckHy) {
        this.neckHy = neckHy;
    }

    /**
     * 设置咽喉粘膜
     * 
     * @param neckYhnm 咽喉粘膜
     */
    public void setNeckYhnm(String neckYhnm) {
        this.neckYhnm = neckYhnm;
    }

    /**
     * 设置喉头
     * 
     * @param neckHt 喉头
     */
    public void setNeckHt(String neckHt) {
        this.neckHt = neckHt;
    }

    /**
     * 设置扁桃体
     * 
     * @param neckBtt 扁桃体
     */
    public void setNeckBtt(String neckBtt) {
        this.neckBtt = neckBtt;
    }

    /**
     * 设置椎前筋膜
     * 
     * @param neckZqjm 椎前筋膜
     */
    public void setNeckZqjm(String neckZqjm) {
        this.neckZqjm = neckZqjm;
    }

    /**
     * 设置颈椎
     * 
     * @param neckJz 颈椎
     */
    public void setNeckJz(String neckJz) {
        this.neckJz = neckJz;
    }

    /**
     * 设置胸壁
     * 
     * @param chestWall 胸壁
     */
    public void setChestWall(String chestWall) {
        this.chestWall = chestWall;
    }

    /**
     * 设置胸骨
     * 
     * @param chestBone 胸骨
     */
    public void setChestBone(String chestBone) {
        this.chestBone = chestBone;
    }

    /**
     * 设置肋骨
     * 
     * @param chestNg 肋骨
     */
    public void setChestNg(String chestNg) {
        this.chestNg = chestNg;
    }

    /**
     * 设置胸膜
     * 
     * @param chestPleura 胸膜
     */
    public void setChestPleura(String chestPleura) {
        this.chestPleura = chestPleura;
    }

    /**
     * 设置胸腔左
     * 
     * @param chestLeft 胸腔左
     */
    public void setChestLeft(String chestLeft) {
        this.chestLeft = chestLeft;
    }

    /**
     * 设置胸腔右
     * 
     * @param chestRight 胸腔右
     */
    public void setChestRight(String chestRight) {
        this.chestRight = chestRight;
    }

    /**
     * 设置胸腺
     * 
     * @param chestXxzl 胸腺
     */
    public void setChestXxzl(String chestXxzl) {
        this.chestXxzl = chestXxzl;
    }

    /**
     * 设置心包
     * 
     * @param heartSac 心包
     */
    public void setHeartSac(String heartSac) {
        this.heartSac = heartSac;
    }

    /**
     * 设置心包腔
     * 
     * @param heartSacq 心包腔
     */
    public void setHeartSacq(String heartSacq) {
        this.heartSacq = heartSacq;
    }

    /**
     * 设置心脏重量
     * 
     * @param heartZl 心脏重量
     */
    public void setHeartZl(String heartZl) {
        this.heartZl = heartZl;
    }

    /**
     * 设置心脏外观
     * 
     * @param heartWg 心脏外观
     */
    public void setHeartWg(String heartWg) {
        this.heartWg = heartWg;
    }

    /**
     * 设置心脏外膜
     * 
     * @param heartWm 心脏外膜
     */
    public void setHeartWm(String heartWm) {
        this.heartWm = heartWm;
    }

    /**
     * 设置心脏内膜
     * 
     * @param heartNm 心脏内膜
     */
    public void setHeartNm(String heartNm) {
        this.heartNm = heartNm;
    }

    /**
     * 设置左心室厚
     * 
     * @param heartLefth 左心室厚
     */
    public void setHeartLefth(String heartLefth) {
        this.heartLefth = heartLefth;
    }

    /**
     * 设置右心室厚
     * 
     * @param heartRighth 右心室厚
     */
    public void setHeartRighth(String heartRighth) {
        this.heartRighth = heartRighth;
    }

    /**
     * 设置室间隔厚
     * 
     * @param heartBetwh 室间隔厚
     */
    public void setHeartBetwh(String heartBetwh) {
        this.heartBetwh = heartBetwh;
    }

    /**
     * 设置心肌
     * 
     * @param heartXj 心肌
     */
    public void setHeartXj(String heartXj) {
        this.heartXj = heartXj;
    }

    /**
     * 设置心腔
     * 
     * @param heartXq 心腔
     */
    public void setHeartXq(String heartXq) {
        this.heartXq = heartXq;
    }

    /**
     * 设置三尖瓣周径
     * 
     * @param heartSjbzj 三尖瓣周径
     */
    public void setHeartSjbzj(String heartSjbzj) {
        this.heartSjbzj = heartSjbzj;
    }

    /**
     * 设置三尖瓣膜
     * 
     * @param heartSjbm 三尖瓣膜
     */
    public void setHeartSjbm(String heartSjbm) {
        this.heartSjbm = heartSjbm;
    }

    /**
     * 设置肺动脉瓣周径
     * 
     * @param heartFdmbzj 肺动脉瓣周径
     */
    public void setHeartFdmbzj(String heartFdmbzj) {
        this.heartFdmbzj = heartFdmbzj;
    }

    /**
     * 设置肺动脉瓣膜
     * 
     * @param heartFdmbm 肺动脉瓣膜
     */
    public void setHeartFdmbm(String heartFdmbm) {
        this.heartFdmbm = heartFdmbm;
    }

    /**
     * 设置二尖瓣周径
     * 
     * @param heartEjbzj 二尖瓣周径
     */
    public void setHeartEjbzj(String heartEjbzj) {
        this.heartEjbzj = heartEjbzj;
    }

    /**
     * 设置二尖瓣膜
     * 
     * @param heartEjbm 二尖瓣膜
     */
    public void setHeartEjbm(String heartEjbm) {
        this.heartEjbm = heartEjbm;
    }

    /**
     * 设置主动脉瓣周径
     * 
     * @param heartZdmbzj 主动脉瓣周径
     */
    public void setHeartZdmbzj(String heartZdmbzj) {
        this.heartZdmbzj = heartZdmbzj;
    }

    /**
     * 设置主动脉瓣膜
     * 
     * @param heartZdmbm 主动脉瓣膜
     */
    public void setHeartZdmbm(String heartZdmbm) {
        this.heartZdmbm = heartZdmbm;
    }

    /**
     * 设置大血管
     * 
     * @param heartDxg 大血管
     */
    public void setHeartDxg(String heartDxg) {
        this.heartDxg = heartDxg;
    }

    /**
     * 设置冠状动脉口左
     * 
     * @param heartGzdmkz 冠状动脉口左
     */
    public void setHeartGzdmkz(String heartGzdmkz) {
        this.heartGzdmkz = heartGzdmkz;
    }

    /**
     * 设置冠状动脉口右
     * 
     * @param heartGzdmky 冠状动脉口右
     */
    public void setHeartGzdmky(String heartGzdmky) {
        this.heartGzdmky = heartGzdmky;
    }

    /**
     * 设置冠状动脉
     * 
     * @param heartGzdm 冠状动脉
     */
    public void setHeartGzdm(String heartGzdm) {
        this.heartGzdm = heartGzdm;
    }

    /**
     * 设置气管
     * 
     * @param tracheaQg 气管
     */
    public void setTracheaQg(String tracheaQg) {
        this.tracheaQg = tracheaQg;
    }

    /**
     * 设置支气管左
     * 
     * @param tracheaZqgz 支气管左
     */
    public void setTracheaZqgz(String tracheaZqgz) {
        this.tracheaZqgz = tracheaZqgz;
    }

    /**
     * 设置支气管右
     * 
     * @param tracheaZqgy 支气管右
     */
    public void setTracheaZqgy(String tracheaZqgy) {
        this.tracheaZqgy = tracheaZqgy;
    }

    /**
     * 设置左肺重量
     * 
     * @param lungLeftzl 左肺重量
     */
    public void setLungLeftzl(String lungLeftzl) {
        this.lungLeftzl = lungLeftzl;
    }

    /**
     * 设置左肺表面
     * 
     * @param lungLeftbm 左肺表面
     */
    public void setLungLeftbm(String lungLeftbm) {
        this.lungLeftbm = lungLeftbm;
    }

    /**
     * 设置左肺质地
     * 
     * @param lungLeftzd 左肺质地
     */
    public void setLungLeftzd(String lungLeftzd) {
        this.lungLeftzd = lungLeftzd;
    }

    /**
     * 设置左肺切面
     * 
     * @param lungLeftqm 左肺切面
     */
    public void setLungLeftqm(String lungLeftqm) {
        this.lungLeftqm = lungLeftqm;
    }

    /**
     * 设置右肺重量
     * 
     * @param lungRightzl 右肺重量
     */
    public void setLungRightzl(String lungRightzl) {
        this.lungRightzl = lungRightzl;
    }

    /**
     * 设置右肺表面
     * 
     * @param lungRightbm 右肺表面
     */
    public void setLungRightbm(String lungRightbm) {
        this.lungRightbm = lungRightbm;
    }

    /**
     * 设置右肺质地
     * 
     * @param lungRightzd 右肺质地
     */
    public void setLungRightzd(String lungRightzd) {
        this.lungRightzd = lungRightzd;
    }

    /**
     * 设置右肺切面
     * 
     * @param lungRightqm 右肺切面
     */
    public void setLungRightqm(String lungRightqm) {
        this.lungRightqm = lungRightqm;
    }

    /**
     * 设置腹壁
     * 
     * @param abdominalWall 腹壁
     */
    public void setAbdominalWall(String abdominalWall) {
        this.abdominalWall = abdominalWall;
    }

    /**
     * 设置腹腔
     * 
     * @param abdominalCavity 腹腔
     */
    public void setAbdominalCavity(String abdominalCavity) {
        this.abdominalCavity = abdominalCavity;
    }

    /**
     * 设置网膜
     * 
     * @param abdominalRetina 网膜
     */
    public void setAbdominalRetina(String abdominalRetina) {
        this.abdominalRetina = abdominalRetina;
    }

    /**
     * 设置腹膜
     * 
     * @param abdominalFm 腹膜
     */
    public void setAbdominalFm(String abdominalFm) {
        this.abdominalFm = abdominalFm;
    }

    /**
     * 设置器官位置
     * 
     * @param abdominalQgwz 器官位置
     */
    public void setAbdominalQgwz(String abdominalQgwz) {
        this.abdominalQgwz = abdominalQgwz;
    }

    /**
     * 设置食道
     * 
     * @param gullet 食道
     */
    public void setGullet(String gullet) {
        this.gullet = gullet;
    }

    /**
     * 设置胃内容物性状
     * 
     * @param stomachObjectProperty 胃内容物性状
     */
    public void setStomachObjectProperty(String stomachObjectProperty) {
        this.stomachObjectProperty = stomachObjectProperty;
    }

    /**
     * 设置胃内容物量
     * 
     * @param stomachObjectAmount 胃内容物量
     */
    public void setStomachObjectAmount(Integer stomachObjectAmount) {
        this.stomachObjectAmount = stomachObjectAmount;
    }

    /**
     * 设置胃内容物量单位
     * 
     * @param stomachObjectUnit 胃内容物量单位
     */
    public void setStomachObjectUnit(String stomachObjectUnit) {
        this.stomachObjectUnit = stomachObjectUnit;
    }

    /**
     * 设置胃内容物成分
     * 
     * @param stomachObjectComponent 胃内容物成分
     */
    public void setStomachObjectComponent(String stomachObjectComponent) {
        this.stomachObjectComponent = stomachObjectComponent;
    }

    /**
     * 设置胃粘膜
     * 
     * @param gastricMucosa 胃粘膜
     */
    public void setGastricMucosa(String gastricMucosa) {
        this.gastricMucosa = gastricMucosa;
    }

    /**
     * 设置肠管
     * 
     * @param intestinalCanal 肠管
     */
    public void setIntestinalCanal(String intestinalCanal) {
        this.intestinalCanal = intestinalCanal;
    }

    /**
     * 设置肠系膜
     * 
     * @param mesenterium 肠系膜
     */
    public void setMesenterium(String mesenterium) {
        this.mesenterium = mesenterium;
    }

    /**
     * 设置胰腺重量
     * 
     * @param pancreasZl 胰腺重量
     */
    public void setPancreasZl(String pancreasZl) {
        this.pancreasZl = pancreasZl;
    }

    /**
     * 设置胰腺颜色
     * 
     * @param pancreasYs 胰腺颜色
     */
    public void setPancreasYs(String pancreasYs) {
        this.pancreasYs = pancreasYs;
    }

    /**
     * 设置胰腺切面
     * 
     * @param pancreasQm 胰腺切面
     */
    public void setPancreasQm(String pancreasQm) {
        this.pancreasQm = pancreasQm;
    }

    /**
     * 设置肝脏重量
     * 
     * @param liverZl 肝脏重量
     */
    public void setLiverZl(String liverZl) {
        this.liverZl = liverZl;
    }

    /**
     * 设置肝脏被膜
     * 
     * @param liverYzbm 肝脏被膜
     */
    public void setLiverYzbm(String liverYzbm) {
        this.liverYzbm = liverYzbm;
    }

    /**
     * 设置肝脏表面
     * 
     * @param liverBm 肝脏表面
     */
    public void setLiverBm(String liverBm) {
        this.liverBm = liverBm;
    }

    /**
     * 设置肝脏切面
     * 
     * @param liverQm 肝脏切面
     */
    public void setLiverQm(String liverQm) {
        this.liverQm = liverQm;
    }

    /**
     * 设置脾脏重量
     * 
     * @param lienZl 脾脏重量
     */
    public void setLienZl(String lienZl) {
        this.lienZl = lienZl;
    }

    /**
     * 设置脾脏被膜
     * 
     * @param lienYzbm 脾脏被膜
     */
    public void setLienYzbm(String lienYzbm) {
        this.lienYzbm = lienYzbm;
    }

    /**
     * 设置脾脏表面
     * 
     * @param lienBm 脾脏表面
     */
    public void setLienBm(String lienBm) {
        this.lienBm = lienBm;
    }

    /**
     * 设置脾脏切面
     * 
     * @param lienQm 脾脏切面
     */
    public void setLienQm(String lienQm) {
        this.lienQm = lienQm;
    }

    /**
     * 设置左肾重量
     * 
     * @param kidneyLeftZl 左肾重量
     */
    public void setKidneyLeftZl(String kidneyLeftZl) {
        this.kidneyLeftZl = kidneyLeftZl;
    }

    /**
     * 设置左肾被膜
     * 
     * @param kidneyLeftYzbm 左肾被膜
     */
    public void setKidneyLeftYzbm(String kidneyLeftYzbm) {
        this.kidneyLeftYzbm = kidneyLeftYzbm;
    }

    /**
     * 设置左肾表面
     * 
     * @param kidneyLeftBm 左肾表面
     */
    public void setKidneyLeftBm(String kidneyLeftBm) {
        this.kidneyLeftBm = kidneyLeftBm;
    }

    /**
     * 设置左肾切面
     * 
     * @param kidneyLeftQm 左肾切面
     */
    public void setKidneyLeftQm(String kidneyLeftQm) {
        this.kidneyLeftQm = kidneyLeftQm;
    }

    /**
     * 设置右肾重量
     * 
     * @param kidneyRightZl 右肾重量
     */
    public void setKidneyRightZl(String kidneyRightZl) {
        this.kidneyRightZl = kidneyRightZl;
    }

    /**
     * 设置右肾被膜
     * 
     * @param kidneyRightYzbm 右肾被膜
     */
    public void setKidneyRightYzbm(String kidneyRightYzbm) {
        this.kidneyRightYzbm = kidneyRightYzbm;
    }

    /**
     * 设置右肾表面
     * 
     * @param kidneyRightBm 右肾表面
     */
    public void setKidneyRightBm(String kidneyRightBm) {
        this.kidneyRightBm = kidneyRightBm;
    }

    /**
     * 设置右肾切面
     * 
     * @param kidneyRightQm 右肾切面
     */
    public void setKidneyRightQm(String kidneyRightQm) {
        this.kidneyRightQm = kidneyRightQm;
    }

    /**
     * 设置输尿管
     * 
     * @param kidneySng 输尿管
     */
    public void setKidneySng(String kidneySng) {
        this.kidneySng = kidneySng;
    }

    /**
     * 设置肾上腺左重量
     * 
     * @param adrenalLeftzl 肾上腺左重量
     */
    public void setAdrenalLeftzl(String adrenalLeftzl) {
        this.adrenalLeftzl = adrenalLeftzl;
    }

    /**
     * 设置肾上腺左性状
     * 
     * @param adrenalLeftxz 肾上腺左性状
     */
    public void setAdrenalLeftxz(String adrenalLeftxz) {
        this.adrenalLeftxz = adrenalLeftxz;
    }

    /**
     * 设置肾上腺右重量
     * 
     * @param adrenalRightzl 肾上腺右重量
     */
    public void setAdrenalRightzl(String adrenalRightzl) {
        this.adrenalRightzl = adrenalRightzl;
    }

    /**
     * 设置肾上腺右性状
     * 
     * @param adrenalRightxz 肾上腺右性状
     */
    public void setAdrenalRightxz(String adrenalRightxz) {
        this.adrenalRightxz = adrenalRightxz;
    }

    /**
     * 设置膀胱
     * 
     * @param bladder 膀胱
     */
    public void setBladder(String bladder) {
        this.bladder = bladder;
    }

    /**
     * 设置膀胱尿量
     * 
     * @param bladderNl 膀胱尿量
     */
    public void setBladderNl(String bladderNl) {
        this.bladderNl = bladderNl;
    }

    /**
     * 设置膀胱尿颜色
     * 
     * @param bladderNys 膀胱尿颜色
     */
    public void setBladderNys(String bladderNys) {
        this.bladderNys = bladderNys;
    }

    /**
     * 设置膀胱浊度
     * 
     * @param bladderNzd 膀胱浊度
     */
    public void setBladderNzd(String bladderNzd) {
        this.bladderNzd = bladderNzd;
    }

    /**
     * 设置子宫
     * 
     * @param uterus 子宫
     */
    public void setUterus(String uterus) {
        this.uterus = uterus;
    }

    /**
     * 设置子宫大小
     * 
     * @param uterusDx 子宫大小
     */
    public void setUterusDx(String uterusDx) {
        this.uterusDx = uterusDx;
    }

    /**
     * 设置子宫宫颈
     * 
     * @param uterusGj 子宫宫颈
     */
    public void setUterusGj(String uterusGj) {
        this.uterusGj = uterusGj;
    }

    /**
     * 设置子宫宫腔
     * 
     * @param uterusGq 子宫宫腔
     */
    public void setUterusGq(String uterusGq) {
        this.uterusGq = uterusGq;
    }

    /**
     * 设置子宫内膜
     * 
     * @param uterusNm 子宫内膜
     */
    public void setUterusNm(String uterusNm) {
        this.uterusNm = uterusNm;
    }

    /**
     * 设置输卵管及卵巢
     * 
     * @param ovaryOviduct 输卵管及卵巢
     */
    public void setOvaryOviduct(String ovaryOviduct) {
        this.ovaryOviduct = ovaryOviduct;
    }

    /**
     * 设置睾丸及附睾
     * 
     * @param spermary 睾丸及附睾
     */
    public void setSpermary(String spermary) {
        this.spermary = spermary;
    }

    /**
     * 设置脊柱、脊髓、四肢等
     * 
     * @param spondyle 脊柱、脊髓、四肢等
     */
    public void setSpondyle(String spondyle) {
        this.spondyle = spondyle;
    }

    /**
     * 设置其他特殊尸体检验
     * 
     * @param specialRemark 其他特殊尸体检验
     */
    public void setSpecialRemark(String specialRemark) {
        this.specialRemark = specialRemark;
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
     * 设置数据来源(SJLYDM)
     * 
     * @param source 数据来源(SJLYDM)
     */
    public void setSource(String source) {
        this.source = source;
    }

}