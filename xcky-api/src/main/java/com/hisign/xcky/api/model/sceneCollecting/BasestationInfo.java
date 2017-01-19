/**
 * BasestationInfoModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.api.model.sceneCollecting;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.hisign.xcky.api.model.common.BaseModel;

/**
 * 基站信息
 *
 * @author ModelGenerator
 */
public class BasestationInfo extends BaseModel {

    /**
     * 勘验信息ID
     */
    private String investigationId;

    /**
     * 采集设备ID
     */
    private String deviceId;

    /**
     * 数据类型(1:静态采集,2:动态采集)
     */
    private String dataType;

    /**
     * 基站类型
     */
    private String bsType;

    /**
     * 是否当前基站
     */
    private String ifactive;

    /**
     * 登记区码
     */
    private String regZone;

    /**
     * 系统识别码
     */
    @JacksonXmlProperty(localName="SID")
    private String sid;

    /**
     * 网络识别码
     */
    @JacksonXmlProperty(localName="NID")
    private String nid;

    /**
     * 基站识别码
     */
    @JacksonXmlProperty(localName="BASE_ID")
    private String baseId;

    /**
     * 基站信道
     */
    @JacksonXmlProperty(localName="CDMA_CH")
    private String cdmaCh;

    /**
     * 伪随机序列
     */
    @JacksonXmlProperty(localName="PN")
    private String pn;

    /**
     * 信号强度
     */
    @JacksonXmlProperty(localName="strength")
    private String strength;

    /**
     * 国家识别码-移动网络识别码
     */
    @JacksonXmlProperty(localName="MCC-MNC")
    private String mccMnc;

    /**
     * 位置区域识别码
     */
    @JacksonXmlProperty(localName="LAC")
    private String lac;

    /**
     * 小区识别码
     */
    @JacksonXmlProperty(localName="CELL_ID")
    private String cellId;

    /**
     * 广播控制信道
     */
    @JacksonXmlProperty(localName="BCCH")
    private String bcch;

    /**
     * 基站识别码
     */
    @JacksonXmlProperty(localName="BSIC")
    private String bsic;

    /**
     * 系统频段
     */
    @JacksonXmlProperty(localName="SYS_BAND")
    private String sysBand;

    /**
     * 经度
     */
    @JacksonXmlProperty(localName="LON")
    private String lon;

    /**
     * 纬度
     */
    @JacksonXmlProperty(localName="LAT")
    private String lat;

    /**
     * 采集时间
     */
    @JacksonXmlProperty(localName="TIME")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private java.util.Date colTime;

    /**
     * 工信部牌照
     */
    @JacksonXmlProperty(localName="ERFCN")
    private String erfcn;

    /**
     * 4G使用
     */
    @JacksonXmlProperty(localName="PCI")
    private String pci;

    /**
     * 4G使用
     */
    @JacksonXmlProperty(localName="BAND")
    private String band;

    /**
     * 4G使用
     */
    @JacksonXmlProperty(localName="CELL")
    private String cell;

    /**
     * 4G使用
     */
    @JacksonXmlProperty(localName="EARFCN")
    private String earfcn;

    /**
     * 信号接收功率
     */
    @JacksonXmlProperty(localName="RSRP")
    private String rsrp;

    /**
     * 信号质量
     */
    @JacksonXmlProperty(localName="RSRQ")
    private String rsrq;

    /**
     * 信号强度
     */
    @JacksonXmlProperty(localName="RSSI")
    private String rssi;

    /**
     * 数据来源(SJLYDM)
     */
    private String source;

    /**
     * 附件ID
     */
    private String attachmentId;

    /**
     * WIFI使用
     */
    @JacksonXmlProperty(localName="SECMOD")
    private String secmod;

    /**
     * WIFI名称
     */
    @JacksonXmlProperty(localName="SSID")
    private String ssid;

    /**
     * MAC地址
     */
    @JacksonXmlProperty(localName="MAC")
    private String mac;
    
    /**
     * WIFI信道
     */
    @JacksonXmlProperty(localName="CHN")
    private String chn;
    
    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 获得勘验信息ID
     * 
     * @return 勘验信息ID
     */
    public String getInvestigationId() {
        return this.investigationId;
    }

    /**
     * 获得采集设备ID
     * 
     * @return 采集设备ID
     */
    public String getDeviceId() {
        return this.deviceId;
    }

    /**
     * 获得数据类型(1:静态采集,2:动态采集)
     * 
     * @return 数据类型(1:静态采集,2:动态采集)
     */
    public String getDataType() {
        return this.dataType;
    }

    /**
     * 获得基站类型
     * 
     * @return 基站类型
     */
    public String getBsType() {
        return this.bsType;
    }

    /**
     * 获得是否当前基站
     * 
     * @return 是否当前基站
     */
    public String getIfactive() {
        return this.ifactive;
    }

    /**
     * 获得登记区码
     * 
     * @return 登记区码
     */
    public String getRegZone() {
        return this.regZone;
    }

    /**
     * 获得系统识别码
     * 
     * @return 系统识别码
     */
    public String getSid() {
        return this.sid;
    }

    /**
     * 获得网络识别码
     * 
     * @return 网络识别码
     */
    public String getNid() {
        return this.nid;
    }

    /**
     * 获得基站识别码
     * 
     * @return 基站识别码
     */
    public String getBaseId() {
        return this.baseId;
    }

    /**
     * 获得基站信道
     * 
     * @return 基站信道
     */
    public String getCdmaCh() {
        return this.cdmaCh;
    }

    /**
     * 获得伪随机序列
     * 
     * @return 伪随机序列
     */
    public String getPn() {
        return this.pn;
    }

    /**
     * 获得信号强度
     * 
     * @return 信号强度
     */
    public String getStrength() {
        return this.strength;
    }

    /**
     * 获得国家识别码-移动网络识别码
     * 
     * @return 国家识别码-移动网络识别码
     */
    public String getMccMnc() {
        return this.mccMnc;
    }

    /**
     * 获得位置区域识别码
     * 
     * @return 位置区域识别码
     */
    public String getLac() {
        return this.lac;
    }

    /**
     * 获得小区识别码
     * 
     * @return 小区识别码
     */
    public String getCellId() {
        return this.cellId;
    }

    /**
     * 获得广播控制信道
     * 
     * @return 广播控制信道
     */
    public String getBcch() {
        return this.bcch;
    }

    /**
     * 获得基站识别码
     * 
     * @return 基站识别码
     */
    public String getBsic() {
        return this.bsic;
    }

    /**
     * 获得系统频段
     * 
     * @return 系统频段
     */
    public String getSysBand() {
        return this.sysBand;
    }

    /**
     * 获得经度
     * 
     * @return 经度
     */
    public String getLon() {
        return this.lon;
    }

    /**
     * 获得纬度
     * 
     * @return 纬度
     */
    public String getLat() {
        return this.lat;
    }

    /**
     * 获得采集时间
     * 
     * @return 采集时间
     */
    public java.util.Date getColTime() {
        return this.colTime;
    }

    /**
     * 获得工信部牌照
     * 
     * @return 工信部牌照
     */
    public String getErfcn() {
        return this.erfcn;
    }

    /**
     * 获得4G使用
     * 
     * @return 4G使用
     */
    public String getPci() {
        return this.pci;
    }

    /**
     * 获得4G使用
     * 
     * @return 4G使用
     */
    public String getBand() {
        return this.band;
    }

    /**
     * 获得4G使用
     * 
     * @return 4G使用
     */
    public String getCell() {
        return this.cell;
    }

    /**
     * 获得4G使用
     * 
     * @return 4G使用
     */
    public String getEarfcn() {
        return this.earfcn;
    }

    /**
     * 获得信号接收功率
     * 
     * @return 信号接收功率
     */
    public String getRsrp() {
        return this.rsrp;
    }

    /**
     * 获得信号质量
     * 
     * @return 信号质量
     */
    public String getRsrq() {
        return this.rsrq;
    }

    /**
     * 获得信号强度
     * 
     * @return 信号强度
     */
    public String getRssi() {
        return this.rssi;
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
     * 获得附件ID
     * 
     * @return 附件ID
     */
    public String getAttachmentId() {
        return this.attachmentId;
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
     * 设置采集设备ID
     * 
     * @param deviceId 采集设备ID
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 设置数据类型(1:静态采集,2:动态采集)
     * 
     * @param dataType 数据类型(1:静态采集,2:动态采集)
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * 设置基站类型
     * 
     * @param bsType 基站类型
     */
    public void setBsType(String bsType) {
        this.bsType = bsType;
    }

    /**
     * 设置是否当前基站
     * 
     * @param ifactive 是否当前基站
     */
    public void setIfactive(String ifactive) {
        this.ifactive = ifactive;
    }

    /**
     * 设置登记区码
     * 
     * @param regZone 登记区码
     */
    public void setRegZone(String regZone) {
        this.regZone = regZone;
    }

    /**
     * 设置系统识别码
     * 
     * @param sid 系统识别码
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * 设置网络识别码
     * 
     * @param nid 网络识别码
     */
    public void setNid(String nid) {
        this.nid = nid;
    }

    /**
     * 设置基站识别码
     * 
     * @param baseId 基站识别码
     */
    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    /**
     * 设置基站信道
     * 
     * @param cdmaCh 基站信道
     */
    public void setCdmaCh(String cdmaCh) {
        this.cdmaCh = cdmaCh;
    }

    /**
     * 设置伪随机序列
     * 
     * @param pn 伪随机序列
     */
    public void setPn(String pn) {
        this.pn = pn;
    }

    /**
     * 设置信号强度
     * 
     * @param strength 信号强度
     */
    public void setStrength(String strength) {
        this.strength = strength;
    }

    /**
     * 设置国家识别码-移动网络识别码
     * 
     * @param mccMnc 国家识别码-移动网络识别码
     */
    public void setMccMnc(String mccMnc) {
        this.mccMnc = mccMnc;
    }

    /**
     * 设置位置区域识别码
     * 
     * @param lac 位置区域识别码
     */
    public void setLac(String lac) {
        this.lac = lac;
    }

    /**
     * 设置小区识别码
     * 
     * @param cellId 小区识别码
     */
    public void setCellId(String cellId) {
        this.cellId = cellId;
    }

    /**
     * 设置广播控制信道
     * 
     * @param bcch 广播控制信道
     */
    public void setBcch(String bcch) {
        this.bcch = bcch;
    }

    /**
     * 设置基站识别码
     * 
     * @param bsic 基站识别码
     */
    public void setBsic(String bsic) {
        this.bsic = bsic;
    }

    /**
     * 设置系统频段
     * 
     * @param sysBand 系统频段
     */
    public void setSysBand(String sysBand) {
        this.sysBand = sysBand;
    }

    /**
     * 设置经度
     * 
     * @param lon 经度
     */
    public void setLon(String lon) {
        this.lon = lon;
    }

    /**
     * 设置纬度
     * 
     * @param lat 纬度
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 设置采集时间
     * 
     * @param colTime 采集时间
     */
    public void setColTime(java.util.Date colTime) {
        this.colTime = colTime;
    }

    /**
     * 设置工信部牌照
     * 
     * @param erfcn 工信部牌照
     */
    public void setErfcn(String erfcn) {
        this.erfcn = erfcn;
    }

    /**
     * 设置4G使用
     * 
     * @param pci 4G使用
     */
    public void setPci(String pci) {
        this.pci = pci;
    }

    /**
     * 设置4G使用
     * 
     * @param band 4G使用
     */
    public void setBand(String band) {
        this.band = band;
    }

    /**
     * 设置4G使用
     * 
     * @param cell 4G使用
     */
    public void setCell(String cell) {
        this.cell = cell;
    }

    /**
     * 设置4G使用
     * 
     * @param earfcn 4G使用
     */
    public void setEarfcn(String earfcn) {
        this.earfcn = earfcn;
    }

    /**
     * 设置信号接收功率
     * 
     * @param rsrp 信号接收功率
     */
    public void setRsrp(String rsrp) {
        this.rsrp = rsrp;
    }

    /**
     * 设置信号质量
     * 
     * @param rsrq 信号质量
     */
    public void setRsrq(String rsrq) {
        this.rsrq = rsrq;
    }

    /**
     * 设置信号强度
     * 
     * @param rssi 信号强度
     */
    public void setRssi(String rssi) {
        this.rssi = rssi;
    }

    /**
     * 设置数据来源(SJLYDM)
     * 
     * @param source 数据来源(SJLYDM)
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 设置附件ID
     * 
     * @param attachmentId 附件ID
     */
    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

	public String getSecmod() {
		return secmod;
	}

	public void setSecmod(String secmod) {
		this.secmod = secmod;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getChn() {
		return chn;
	}

	public void setChn(String chn) {
		this.chn = chn;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
    
}