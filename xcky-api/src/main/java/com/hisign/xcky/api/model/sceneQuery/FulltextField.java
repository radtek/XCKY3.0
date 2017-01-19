package com.hisign.xcky.api.model.sceneQuery;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class FulltextField {
	@JSONField  (name = "ID")
	private String ID;
	
	@JSONField  (name = "INVESTIGATION_NO")
    private String INVESTIGATION_NO;
	
	@JSONField  (name = "INVESTIGATION_DATE")
	private String INVESTIGATION_DATE;
	
	@JSONField  (name = "INVESTIGATION_DATE_HM")
	private String INVESTIGATION_DATE_HM;
	
	@JSONField  (name = "INVESTIGATION_PLACE")
    private String INVESTIGATION_PLACE;
	
	@JSONField  (name = "CASE_LON")
    private String CASE_LON;
	
	@JSONField  (name = "CASE_LAT")
    private String CASE_LAT;
	
	@JSONField  (name = "INVEST_NOTE")
    private String INVEST_NOTE;
	
	@JSONField  (name = "LOST_TOTAL_VALUE")
    private Long   LOST_TOTAL_VALUE;
	
	@JSONField  (name = "REMNANT_DESC")
    private String REMNANT_DESC;
	
	@JSONField  (name = "SCENE_DISPOSAL")
    private String SCENE_DISPOSAL;
	
	@JSONField  (name = "SCENE_DISPOSAL_DESC")
    private String SCENE_DISPOSAL_DESC;
	
	@JSONField  (name = "VIDEO_TIME")
    private Integer VIDEO_TIME;
	
	@JSONField  (name = "RECORD_TIME")
    private Integer RECORD_TIME;
	
	@JSONField  (name = "ORGAN_NO")
    private String ORGAN_NO;
	
	@JSONField  (name = "ORGAN_NAME")
    private String ORGAN_NAME;
	
	@JSONField  (name = "OTHER_PERSONS")
    private String OTHER_PERSONS;
	
	@JSONField  (name = "CHANGE_REASON")
    private String CHANGE_REASON;
	
	@JSONField  (name = "CHANGE_REASON_DESC")
    private String CHANGE_REASON_DESC;
	
	@JSONField  (name = "WITNESS_REMARK")
    private String WITNESS_REMARK;
	
	@JSONField  (name = "SOURCE")
    private String SOURCE;
	
	@JSONField  (name = "CREATE_USER")
    private String CREATE_USER;
	
	@JSONField  (name = "ALARM_NO")
    private String ALARM_NO;
	
	@JSONField  (name = "ALARM_ACCEPT_NO")
    private String ALARM_ACCEPT_NO;
	
	@JSONField  (name = "ALARM_RECEIVER")
    private String ALARM_RECEIVER;
	
	@JSONField  (name = "ASSIGN_PERSON")
    private String ASSIGN_PERSON;
	
	@JSONField  (name = "ASSIGN_METHOD")
    private String ASSIGN_METHOD;
	
	@JSONField  (name = "ASSIGN_METHOD_DESC")
    private String ASSIGN_METHOD_DESC;
	
	@JSONField  (name = "ASSIGN_REASON")
    private String ASSIGN_REASON;
	
	@JSONField  (name = "CASE_NO")
    private String CASE_NO;
	
	@JSONField  (name = "CASE_TYPE")
    private String CASE_TYPE;
	
	@JSONField  (name = "CASE_TYPE_DM")
	private String CASE_TYPE_DM;
	
	@JSONField  (name = "CASE_NATURE")
    private String CASE_NATURE;
	
	@JSONField  (name = "CASE_NAME")
    private String CASE_NAME;
	
	@JSONField  (name = "CASE_BRIEF")
    private String CASE_BRIEF;
	
	@JSONField  (name = "CASE_REGIONALISM")
    private String CASE_REGIONALISM;
	
	@JSONField  (name = "CASE_LOCATION")
    private String CASE_LOCATION;
	
	@JSONField  (name = "MURDER_FLAG")
    private String MURDER_FLAG;
	
	@JSONField  (name = "CRIMINAL_FLAG")
    private String CRIMINAL_FLAG;
	
	@JSONField  (name = "WOUNDED_AMOUNT")
    private Integer WOUNDED_AMOUNT;
	
	@JSONField  (name = "DEAD_AMOUNT")
    private Integer DEAD_AMOUNT;
	
	@JSONField  (name = "INVESTIGATOR_NAME")
    private String INVESTIGATOR_NAME;
	
	@JSONField  (name = "COMMAND_NAME")
    private String COMMAND_NAME;
	
	@JSONField  (name = "INVESTIGATION_DATE_FROM",format="yyyy-MM-dd HH:mm")
    private Date   INVESTIGATION_DATE_FROM;
	
	@JSONField  (name = "INVESTIGATION_DATE_TO",format="yyyy-MM-dd HH:mm")
    private Date   INVESTIGATION_DATE_TO;
	
	@JSONField  (name = "CREATE_TIME",format="yyyy-MM-dd HH:mm")
    private Date   CREATE_TIME;
	
	@JSONField  (name = "ALARM_TIME",format="yyyy-MM-dd HH:mm")
    private Date   ALARM_TIME;
	
	@JSONField  (name = "DISPATCH_TIME",format="yyyy-MM-dd HH:mm")
    private Date   DISPATCH_TIME;
	
	@JSONField  (name = "CRIME_TIME_BEGIN",format="yyyy-MM-dd HH:mm")
    private Date   CRIME_TIME_BEGIN;
	
	@JSONField  (name = "CRIME_TIME_END",format="yyyy-MM-dd HH:mm")
    private Date   CRIME_TIME_END;

	@JSONField  (name = "CASE_TYPE_FACET")
    private String CASE_TYPE_FACET;
	
	@JSONField  (name = "ORGAN_NAME_FACET")
    private String ORGAN_NAME_FACET;
	
	@JSONField  (name = "CASE_REGIONALISM_FACET")
    private String CASE_REGIONALISM_FACET;
 	
	@JSONField  (name = "PROTECTOR")
    private String PROTECTOR;

	//相关图片数量信息
	/**
     * 指纹痕迹数量
     */
	@JSONField  (name = "HANDPRINT_AMOUNT")
    private Integer HANDPRINT_AMOUNT;

    /**
     * 足迹痕迹数量
     */
	@JSONField  (name = "FOOTPRINT_AMOUNT")
    private Integer FOOTPRINT_AMOUNT;

    /**
     * 工具痕迹数量
     */
	@JSONField  (name = "TOOLMARK_AMOUNT")
    private Integer TOOLMARK_AMOUNT;

    /**
     * 枪弹痕迹数量
     */
	@JSONField  (name = "BULLETPRINT_AMOUNT")
    private Integer BULLETPRINT_AMOUNT;

    /**
     * 特殊痕迹数量
     */
	@JSONField  (name = "SPECIALPRINT_AMOUNT")
    private Integer SPECIALPRINT_AMOUNT;

    /**
     * 生物物证数量
     */
	@JSONField  (name = "BIO_EVIDENCE_AMOUNT")
    private Integer BIO_EVIDENCE_AMOUNT;

    /**
     * 毒化物证数量
     */
	@JSONField  (name = "TOXIC_EVIDENCE_AMOUNT")
    private Integer TOXIC_EVIDENCE_AMOUNT;

    /**
     * 理化物证数量
     */
	@JSONField  (name = "PHYSICAL_EVIDENCE_AMOUNT")
    private Integer PHYSICAL_EVIDENCE_AMOUNT;

    /**
     * 文检物证数量
     */
	@JSONField  (name = "FILE_EVIDENCE_AMOUNT")
    private Integer FILE_EVIDENCE_AMOUNT;

    /**
     * 电子物证数量
     */
	@JSONField  (name = "ELECTRO_EVIDENCE_AMOUNT")
    private Integer ELECTRO_EVIDENCE_AMOUNT;

    /**
     * 视听物证数量
     */
	@JSONField  (name = "VIDEO_EVIDENCE_AMOUNT")
    private Integer VIDEO_EVIDENCE_AMOUNT;

    /**
     * 其他物证数量
     */
	@JSONField  (name = "OTHER_EVIDENCE_AMOUNT")
    private Integer OTHER_EVIDENCE_AMOUNT;

	/**
     * 现场图数量
     */
	@JSONField  (name = "SCENE_PHOTO_AMOUNT")
    private Integer SCENE_PHOTO_AMOUNT;
	
	/**
     * 现场图数量
     */
	@JSONField  (name = "SCENE_PICTURE_AMOUNT")
    private Integer SCENE_PICTURE_AMOUNT;

    /**
     * 平面图数量
     */
	@JSONField  (name = "PLANE_GRAPH_AMOUNT")
    private Integer PLANE_GRAPH_AMOUNT;

    /**
     * 方位图数量
     */
	@JSONField  (name = "ORIENTATION_MAP_AMOUNT")
    private Integer ORIENTATION_MAP_AMOUNT;

    /**
     * 概貌图片数量
     */
	@JSONField  (name = "PROFILE_PICTURE_AMOUNT")
    private Integer PROFILE_PICTURE_AMOUNT;

    /**
     * 细目图片数量
     */
	@JSONField  (name = "DETAIL_PICTURE_AMOUNT")
    private Integer DETAIL_PICTURE_AMOUNT;

    /**
     * 重点部位图片数量
     */
	@JSONField  (name = "FOCUS_PART_PIC_AMOUNT")
    private Integer FOCUS_PART_PIC_AMOUNT;
    
	@JSONField  (name = "text")
    private String text;

	@JSONField  (name = "_version_")
    private Long _version_;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getINVESTIGATION_NO() {
		return INVESTIGATION_NO;
	}

	public void setINVESTIGATION_NO(String iNVESTIGATION_NO) {
		INVESTIGATION_NO = iNVESTIGATION_NO;
	}

	public String getINVESTIGATION_DATE() {
		return INVESTIGATION_DATE;
	}

	public void setINVESTIGATION_DATE(String iNVESTIGATION_DATE) {
		INVESTIGATION_DATE = iNVESTIGATION_DATE;
	}

	public Date getINVESTIGATION_DATE_FROM() {
		return INVESTIGATION_DATE_FROM;
	}

	public void setINVESTIGATION_DATE_FROM(Date iNVESTIGATION_DATE_FROM) {
		INVESTIGATION_DATE_FROM = iNVESTIGATION_DATE_FROM;
	}

	public Date getINVESTIGATION_DATE_TO() {
		return INVESTIGATION_DATE_TO;
	}

	public void setINVESTIGATION_DATE_TO(Date iNVESTIGATION_DATE_TO) {
		INVESTIGATION_DATE_TO = iNVESTIGATION_DATE_TO;
	}

	public String getINVESTIGATION_DATE_HM() {
		return INVESTIGATION_DATE_HM;
	}

	public void setINVESTIGATION_DATE_HM(String iNVESTIGATION_DATE_HM) {
		INVESTIGATION_DATE_HM = iNVESTIGATION_DATE_HM;
	}

	public String getINVESTIGATION_PLACE() {
		return INVESTIGATION_PLACE;
	}

	public void setINVESTIGATION_PLACE(String iNVESTIGATION_PLACE) {
		INVESTIGATION_PLACE = iNVESTIGATION_PLACE;
	}

	public String getCASE_LON() {
		return CASE_LON;
	}

	public void setCASE_LON(String cASE_LON) {
		CASE_LON = cASE_LON;
	}

	public String getCASE_LAT() {
		return CASE_LAT;
	}

	public void setCASE_LAT(String cASE_LAT) {
		CASE_LAT = cASE_LAT;
	}

	public String getINVEST_NOTE() {
		return INVEST_NOTE;
	}

	public void setINVEST_NOTE(String iNVEST_NOTE) {
		INVEST_NOTE = iNVEST_NOTE;
	}

	public Long getLOST_TOTAL_VALUE() {
		return LOST_TOTAL_VALUE;
	}

	public void setLOST_TOTAL_VALUE(Long lOST_TOTAL_VALUE) {
		LOST_TOTAL_VALUE = lOST_TOTAL_VALUE;
	}

	public String getREMNANT_DESC() {
		return REMNANT_DESC;
	}

	public void setREMNANT_DESC(String rEMNANT_DESC) {
		REMNANT_DESC = rEMNANT_DESC;
	}

	public String getSCENE_DISPOSAL() {
		return SCENE_DISPOSAL;
	}

	public void setSCENE_DISPOSAL(String sCENE_DISPOSAL) {
		SCENE_DISPOSAL = sCENE_DISPOSAL;
	}

	public String getSCENE_DISPOSAL_DESC() {
		return SCENE_DISPOSAL_DESC;
	}

	public void setSCENE_DISPOSAL_DESC(String sCENE_DISPOSAL_DESC) {
		SCENE_DISPOSAL_DESC = sCENE_DISPOSAL_DESC;
	}

	public Integer getVIDEO_TIME() {
		return VIDEO_TIME;
	}

	public void setVIDEO_TIME(Integer vIDEO_TIME) {
		VIDEO_TIME = vIDEO_TIME;
	}

	public Integer getRECORD_TIME() {
		return RECORD_TIME;
	}

	public void setRECORD_TIME(Integer rECORD_TIME) {
		RECORD_TIME = rECORD_TIME;
	}

	public String getORGAN_NO() {
		return ORGAN_NO;
	}

	public void setORGAN_NO(String oRGAN_NO) {
		ORGAN_NO = oRGAN_NO;
	}

	public String getORGAN_NAME() {
		return ORGAN_NAME;
	}

	public void setORGAN_NAME(String oRGAN_NAME) {
		ORGAN_NAME = oRGAN_NAME;
	}

	public String getOTHER_PERSONS() {
		return OTHER_PERSONS;
	}

	public void setOTHER_PERSONS(String oTHER_PERSONS) {
		OTHER_PERSONS = oTHER_PERSONS;
	}

	public String getCHANGE_REASON() {
		return CHANGE_REASON;
	}

	public void setCHANGE_REASON(String cHANGE_REASON) {
		CHANGE_REASON = cHANGE_REASON;
	}

	public String getCHANGE_REASON_DESC() {
		return CHANGE_REASON_DESC;
	}

	public void setCHANGE_REASON_DESC(String cHANGE_REASON_DESC) {
		CHANGE_REASON_DESC = cHANGE_REASON_DESC;
	}

	public String getWITNESS_REMARK() {
		return WITNESS_REMARK;
	}

	public void setWITNESS_REMARK(String wITNESS_REMARK) {
		WITNESS_REMARK = wITNESS_REMARK;
	}

	public String getSOURCE() {
		return SOURCE;
	}

	public void setSOURCE(String sOURCE) {
		SOURCE = sOURCE;
	}

	public String getCREATE_USER() {
		return CREATE_USER;
	}

	public void setCREATE_USER(String cREATE_USER) {
		CREATE_USER = cREATE_USER;
	}

	public Date getCREATE_TIME() {
		return CREATE_TIME;
	}

	public void setCREATE_TIME(Date cREATE_TIME) {
		CREATE_TIME = cREATE_TIME;
	}

	public String getALARM_NO() {
		return ALARM_NO;
	}

	public void setALARM_NO(String aLARM_NO) {
		ALARM_NO = aLARM_NO;
	}

	public String getALARM_ACCEPT_NO() {
		return ALARM_ACCEPT_NO;
	}

	public void setALARM_ACCEPT_NO(String aLARM_ACCEPT_NO) {
		ALARM_ACCEPT_NO = aLARM_ACCEPT_NO;
	}

	public Date getALARM_TIME() {
		return ALARM_TIME;
	}

	public void setALARM_TIME(Date aLARM_TIME) {
		ALARM_TIME = aLARM_TIME;
	}

	public String getALARM_RECEIVER() {
		return ALARM_RECEIVER;
	}

	public void setALARM_RECEIVER(String aLARM_RECEIVER) {
		ALARM_RECEIVER = aLARM_RECEIVER;
	}

	public String getASSIGN_PERSON() {
		return ASSIGN_PERSON;
	}

	public void setASSIGN_PERSON(String aSSIGN_PERSON) {
		ASSIGN_PERSON = aSSIGN_PERSON;
	}

	public String getASSIGN_METHOD() {
		return ASSIGN_METHOD;
	}

	public void setASSIGN_METHOD(String aSSIGN_METHOD) {
		ASSIGN_METHOD = aSSIGN_METHOD;
	}

	public String getASSIGN_METHOD_DESC() {
		return ASSIGN_METHOD_DESC;
	}

	public void setASSIGN_METHOD_DESC(String aSSIGN_METHOD_DESC) {
		ASSIGN_METHOD_DESC = aSSIGN_METHOD_DESC;
	}

	public String getASSIGN_REASON() {
		return ASSIGN_REASON;
	}

	public void setASSIGN_REASON(String aSSIGN_REASON) {
		ASSIGN_REASON = aSSIGN_REASON;
	}

	public Date getDISPATCH_TIME() {
		return DISPATCH_TIME;
	}

	public void setDISPATCH_TIME(Date dISPATCH_TIME) {
		DISPATCH_TIME = dISPATCH_TIME;
	}

	public String getCASE_NO() {
		return CASE_NO;
	}

	public void setCASE_NO(String cASE_NO) {
		CASE_NO = cASE_NO;
	}

	public String getCASE_TYPE() {
		return CASE_TYPE;
	}

	public void setCASE_TYPE(String cASE_TYPE) {
		CASE_TYPE = cASE_TYPE;
	}

	public String getCASE_TYPE_DM() {
		return CASE_TYPE_DM;
	}

	public void setCASE_TYPE_DM(String cASE_TYPE_DM) {
		CASE_TYPE_DM = cASE_TYPE_DM;
	}

	public String getCASE_NATURE() {
		return CASE_NATURE;
	}

	public void setCASE_NATURE(String cASE_NATURE) {
		CASE_NATURE = cASE_NATURE;
	}

	public String getCASE_NAME() {
		return CASE_NAME;
	}

	public void setCASE_NAME(String cASE_NAME) {
		CASE_NAME = cASE_NAME;
	}

	public String getCASE_BRIEF() {
		return CASE_BRIEF;
	}

	public void setCASE_BRIEF(String cASE_BRIEF) {
		CASE_BRIEF = cASE_BRIEF;
	}

	public String getCASE_REGIONALISM() {
		return CASE_REGIONALISM;
	}

	public void setCASE_REGIONALISM(String cASE_REGIONALISM) {
		CASE_REGIONALISM = cASE_REGIONALISM;
	}

	public String getCASE_LOCATION() {
		return CASE_LOCATION;
	}

	public void setCASE_LOCATION(String cASE_LOCATION) {
		CASE_LOCATION = cASE_LOCATION;
	}

	public Date getCRIME_TIME_BEGIN() {
		return CRIME_TIME_BEGIN;
	}

	public void setCRIME_TIME_BEGIN(Date cRIME_TIME_BEGIN) {
		CRIME_TIME_BEGIN = cRIME_TIME_BEGIN;
	}

	public Date getCRIME_TIME_END() {
		return CRIME_TIME_END;
	}

	public void setCRIME_TIME_END(Date cRIME_TIME_END) {
		CRIME_TIME_END = cRIME_TIME_END;
	}

	public String getMURDER_FLAG() {
		return MURDER_FLAG;
	}

	public void setMURDER_FLAG(String mURDER_FLAG) {
		MURDER_FLAG = mURDER_FLAG;
	}

	public String getCRIMINAL_FLAG() {
		return CRIMINAL_FLAG;
	}

	public void setCRIMINAL_FLAG(String cRIMINAL_FLAG) {
		CRIMINAL_FLAG = cRIMINAL_FLAG;
	}

	public Integer getWOUNDED_AMOUNT() {
		return WOUNDED_AMOUNT;
	}

	public void setWOUNDED_AMOUNT(Integer wOUNDED_AMOUNT) {
		WOUNDED_AMOUNT = wOUNDED_AMOUNT;
	}

	public Integer getDEAD_AMOUNT() {
		return DEAD_AMOUNT;
	}

	public void setDEAD_AMOUNT(Integer dEAD_AMOUNT) {
		DEAD_AMOUNT = dEAD_AMOUNT;
	}

	public String getINVESTIGATOR_NAME() {
		return INVESTIGATOR_NAME;
	}

	public void setINVESTIGATOR_NAME(String iNVESTIGATOR_NAME) {
		INVESTIGATOR_NAME = iNVESTIGATOR_NAME;
	}

	public String getCASE_TYPE_FACET() {
		return CASE_TYPE_FACET;
	}

	public void setCASE_TYPE_FACET(String cASE_TYPE_FACET) {
		CASE_TYPE_FACET = cASE_TYPE_FACET;
	}

	public String getORGAN_NAME_FACET() {
		return ORGAN_NAME_FACET;
	}

	public void setORGAN_NAME_FACET(String oRGAN_NAME_FACET) {
		ORGAN_NAME_FACET = oRGAN_NAME_FACET;
	}

	public String getCASE_REGIONALISM_FACET() {
		return CASE_REGIONALISM_FACET;
	}

	public void setCASE_REGIONALISM_FACET(String cASE_REGIONALISM_FACET) {
		CASE_REGIONALISM_FACET = cASE_REGIONALISM_FACET;
	}

	public String getPROTECTOR() {
		return PROTECTOR;
	}

	public void setPROTECTOR(String pROTECTOR) {
		PROTECTOR = pROTECTOR;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long get_version_() {
		return _version_;
	}

	public void set_version_(Long _version_) {
		this._version_ = _version_;
	}

	public Integer getHANDPRINT_AMOUNT() {
		return HANDPRINT_AMOUNT;
	}

	public void setHANDPRINT_AMOUNT(Integer hANDPRINT_AMOUNT) {
		HANDPRINT_AMOUNT = hANDPRINT_AMOUNT;
	}

	public Integer getFOOTPRINT_AMOUNT() {
		return FOOTPRINT_AMOUNT;
	}

	public void setFOOTPRINT_AMOUNT(Integer fOOTPRINT_AMOUNT) {
		FOOTPRINT_AMOUNT = fOOTPRINT_AMOUNT;
	}

	public Integer getTOOLMARK_AMOUNT() {
		return TOOLMARK_AMOUNT;
	}

	public void setTOOLMARK_AMOUNT(Integer tOOLMARK_AMOUNT) {
		TOOLMARK_AMOUNT = tOOLMARK_AMOUNT;
	}

	public Integer getBULLETPRINT_AMOUNT() {
		return BULLETPRINT_AMOUNT;
	}

	public void setBULLETPRINT_AMOUNT(Integer bULLETPRINT_AMOUNT) {
		BULLETPRINT_AMOUNT = bULLETPRINT_AMOUNT;
	}

	public Integer getSPECIALPRINT_AMOUNT() {
		return SPECIALPRINT_AMOUNT;
	}

	public void setSPECIALPRINT_AMOUNT(Integer sPECIALPRINT_AMOUNT) {
		SPECIALPRINT_AMOUNT = sPECIALPRINT_AMOUNT;
	}

	public Integer getBIO_EVIDENCE_AMOUNT() {
		return BIO_EVIDENCE_AMOUNT;
	}

	public void setBIO_EVIDENCE_AMOUNT(Integer bIO_EVIDENCE_AMOUNT) {
		BIO_EVIDENCE_AMOUNT = bIO_EVIDENCE_AMOUNT;
	}

	public Integer getTOXIC_EVIDENCE_AMOUNT() {
		return TOXIC_EVIDENCE_AMOUNT;
	}

	public void setTOXIC_EVIDENCE_AMOUNT(Integer tOXIC_EVIDENCE_AMOUNT) {
		TOXIC_EVIDENCE_AMOUNT = tOXIC_EVIDENCE_AMOUNT;
	}

	public Integer getPHYSICAL_EVIDENCE_AMOUNT() {
		return PHYSICAL_EVIDENCE_AMOUNT;
	}

	public void setPHYSICAL_EVIDENCE_AMOUNT(Integer pHYSICAL_EVIDENCE_AMOUNT) {
		PHYSICAL_EVIDENCE_AMOUNT = pHYSICAL_EVIDENCE_AMOUNT;
	}

	public Integer getFILE_EVIDENCE_AMOUNT() {
		return FILE_EVIDENCE_AMOUNT;
	}

	public void setFILE_EVIDENCE_AMOUNT(Integer fILE_EVIDENCE_AMOUNT) {
		FILE_EVIDENCE_AMOUNT = fILE_EVIDENCE_AMOUNT;
	}

	public Integer getELECTRO_EVIDENCE_AMOUNT() {
		return ELECTRO_EVIDENCE_AMOUNT;
	}

	public void setELECTRO_EVIDENCE_AMOUNT(Integer eLECTRO_EVIDENCE_AMOUNT) {
		ELECTRO_EVIDENCE_AMOUNT = eLECTRO_EVIDENCE_AMOUNT;
	}

	public Integer getVIDEO_EVIDENCE_AMOUNT() {
		return VIDEO_EVIDENCE_AMOUNT;
	}

	public void setVIDEO_EVIDENCE_AMOUNT(Integer vIDEO_EVIDENCE_AMOUNT) {
		VIDEO_EVIDENCE_AMOUNT = vIDEO_EVIDENCE_AMOUNT;
	}

	public Integer getOTHER_EVIDENCE_AMOUNT() {
		return OTHER_EVIDENCE_AMOUNT;
	}

	public void setOTHER_EVIDENCE_AMOUNT(Integer oTHER_EVIDENCE_AMOUNT) {
		OTHER_EVIDENCE_AMOUNT = oTHER_EVIDENCE_AMOUNT;
	}

	public Integer getSCENE_PHOTO_AMOUNT() {
		return SCENE_PHOTO_AMOUNT;
	}

	public void setSCENE_PHOTO_AMOUNT(Integer sCENE_PHOTO_AMOUNT) {
		SCENE_PHOTO_AMOUNT = sCENE_PHOTO_AMOUNT;
	}

	public Integer getSCENE_PICTURE_AMOUNT() {
		return SCENE_PICTURE_AMOUNT;
	}

	public void setSCENE_PICTURE_AMOUNT(Integer sCENE_PICTURE_AMOUNT) {
		SCENE_PICTURE_AMOUNT = sCENE_PICTURE_AMOUNT;
	}

	public Integer getPLANE_GRAPH_AMOUNT() {
		return PLANE_GRAPH_AMOUNT;
	}

	public void setPLANE_GRAPH_AMOUNT(Integer pLANE_GRAPH_AMOUNT) {
		PLANE_GRAPH_AMOUNT = pLANE_GRAPH_AMOUNT;
	}

	public Integer getORIENTATION_MAP_AMOUNT() {
		return ORIENTATION_MAP_AMOUNT;
	}

	public void setORIENTATION_MAP_AMOUNT(Integer oRIENTATION_MAP_AMOUNT) {
		ORIENTATION_MAP_AMOUNT = oRIENTATION_MAP_AMOUNT;
	}

	public Integer getPROFILE_PICTURE_AMOUNT() {
		return PROFILE_PICTURE_AMOUNT;
	}

	public void setPROFILE_PICTURE_AMOUNT(Integer pROFILE_PICTURE_AMOUNT) {
		PROFILE_PICTURE_AMOUNT = pROFILE_PICTURE_AMOUNT;
	}

	public Integer getDETAIL_PICTURE_AMOUNT() {
		return DETAIL_PICTURE_AMOUNT;
	}

	public void setDETAIL_PICTURE_AMOUNT(Integer dETAIL_PICTURE_AMOUNT) {
		DETAIL_PICTURE_AMOUNT = dETAIL_PICTURE_AMOUNT;
	}

	public Integer getFOCUS_PART_PIC_AMOUNT() {
		return FOCUS_PART_PIC_AMOUNT;
	}

	public void setFOCUS_PART_PIC_AMOUNT(Integer fOCUS_PART_PIC_AMOUNT) {
		FOCUS_PART_PIC_AMOUNT = fOCUS_PART_PIC_AMOUNT;
	}

	public String getCOMMAND_NAME() {
		return COMMAND_NAME;
	}

	public void setCOMMAND_NAME(String cOMMAND_NAME) {
		COMMAND_NAME = cOMMAND_NAME;
	}

	
}
