package com.hisign.xcky.api.model.statistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 十类案件统计对象
 * 项目名称：xcky-api   
 * 类名称：TenSceneInputAmount   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-26 上午11:26:48   
 * 修改人：hisign   
 * 修改时间：2016-12-26 上午11:26:48   
 * 修改备注：   
 * @version
 */
@JsonIgnoreProperties(ignoreUnknown=true)
//前台传json格式，忽略对不上的属性
public class TenSceneInputAmount{
	/**
	 * 统计单位名称
	 */
	private String parentUnitName;
	/**
	 * 单位名称
	 */
	private String unitName;
	/**
	 * 杀人案
	 */
	private int killCount=0;
	/**
	 * 伤害案
	 */
	private int injureCount=0;
	/**
	 * 强奸案
	 */
	private int rapeCount=0;
	/**
	 * 绑架案
	 */
	private int kidnapCount=0;
	/**
	 * 抢劫案
	 */
	private int robCount=0;
	/**
	 * 放火案
	 */
	private int fireCount=0;
	/**
	 * 爆炸案
	 */
	private int bombCount=0;
	/**
	 * 劫持案
	 */
	private int hijackCount=0;
	/**
	 * 入室盗窃案
	 */
	private int stealCount=0;
	/**
	 * 破坏案
	 */
	private int destroyCount=0;
	/**
	 * 投毒案
	 */
	private int poisoningCount=0;
	/**
	 * 其他命案
	 */
	private int otherCount=0;
	/**
	 * 导出excel合并行用
	 */
	private int rowSpan=1;
	/**
	 * 是否合并显示
	 */
	private int sfhb=1;
	
	public int getSfhb() {
		return sfhb;
	}
	public void setSfhb(int sfhb) {
		this.sfhb = sfhb;
	}
	public int getRowSpan() {
		return rowSpan;
	}
	public void setRowSpan(int rowSpan) {
		this.rowSpan = rowSpan;
	}
	public String getParentUnitName() {
		return parentUnitName;
	}
	public void setParentUnitName(String parentUnitName) {
		this.parentUnitName = parentUnitName;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public int getKillCount() {
		return killCount;
	}
	public void setKillCount(int killCount) {
		this.killCount = killCount;
	}
	public int getInjureCount() {
		return injureCount;
	}
	public void setInjureCount(int injureCount) {
		this.injureCount = injureCount;
	}
	public int getRapeCount() {
		return rapeCount;
	}
	public void setRapeCount(int rapeCount) {
		this.rapeCount = rapeCount;
	}
	public int getKidnapCount() {
		return kidnapCount;
	}
	public void setKidnapCount(int kidnapCount) {
		this.kidnapCount = kidnapCount;
	}
	public int getRobCount() {
		return robCount;
	}
	public void setRobCount(int robCount) {
		this.robCount = robCount;
	}
	public int getFireCount() {
		return fireCount;
	}
	public void setFireCount(int fireCount) {
		this.fireCount = fireCount;
	}
	public int getBombCount() {
		return bombCount;
	}
	public void setBombCount(int bombCount) {
		this.bombCount = bombCount;
	}
	public int getHijackCount() {
		return hijackCount;
	}
	public void setHijackCount(int hijackCount) {
		this.hijackCount = hijackCount;
	}
	public int getStealCount() {
		return stealCount;
	}
	public void setStealCount(int stealCount) {
		this.stealCount = stealCount;
	}
	public int getDestroyCount() {
		return destroyCount;
	}
	public void setDestroyCount(int destroyCount) {
		this.destroyCount = destroyCount;
	}
	public int getPoisoningCount() {
		return poisoningCount;
	}
	public void setPoisoningCount(int poisoningCount) {
		this.poisoningCount = poisoningCount;
	}
	public int getOtherCount() {
		return otherCount;
	}
	public void setOtherCount(int otherCount) {
		this.otherCount = otherCount;
	}
	
}
