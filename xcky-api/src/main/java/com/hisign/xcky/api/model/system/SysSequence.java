package com.hisign.xcky.api.model.system;

import com.hisign.xcky.api.model.common.BaseModel;
/**
 * 流水
 * 项目名称：xcky-api   
 * 类名称：SysSequence   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-8 下午3:28:37   
 * 修改人：hisign   
 * 修改时间：2016-12-8 下午3:28:37   
 * 修改备注：   
 * @version
 */
public class SysSequence extends BaseModel{
	
	//流水号
	private String maxSeq;
	//流水号类型
	private String seqType;
	//单位代码
	private String orgCode;
	//当前年月
	private String curDate;
	//版本标识
	private long versionFlag;
	
	public String getMaxSeq() {
		return maxSeq;
	}
	public void setMaxSeq(String maxSeq) {
		this.maxSeq = maxSeq;
	}
	public String getSeqType() {
		return seqType;
	}
	public void setSeqType(String seqType) {
		this.seqType = seqType;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getCurDate() {
		return curDate;
	}
	public void setCurDate(String curDate) {
		this.curDate = curDate;
	}
	public long getVersionFlag() {
		return versionFlag;
	}
	public void setVersionFlag(long versionFlag) {
		this.versionFlag = versionFlag;
	}
}
