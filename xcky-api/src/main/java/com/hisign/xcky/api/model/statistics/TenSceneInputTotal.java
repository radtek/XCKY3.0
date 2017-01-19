package com.hisign.xcky.api.model.statistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 十类案件统计合计
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
public class TenSceneInputTotal{
	/**
	 * 杀人案
	 */
	private int killTotal=0;
	/**
	 * 伤害案
	 */
	private int injureTotal=0;
	/**
	 * 强奸案
	 */
	private int rapeTotal=0;
	/**
	 * 绑架案
	 */
	private int kidnapTotal=0;
	/**
	 * 抢劫案
	 */
	private int robTotal=0;
	/**
	 * 放火案
	 */
	private int fireTotal=0;
	/**
	 * 爆炸案
	 */
	private int bombTotal=0;
	/**
	 * 劫持案
	 */
	private int hijackTotal=0;
	/**
	 * 入室盗窃案
	 */
	private int stealTotal=0;
	/**
	 * 破坏案
	 */
	private int destroyTotal=0;
	/**
	 * 投毒案
	 */
	private int poisoningTotal=0;
	/**
	 * 其他命案
	 */
	private int otherTotal=0;
	public int getKillTotal() {
		return killTotal;
	}
	public void setKillTotal(int killTotal) {
		this.killTotal = killTotal;
	}
	public int getInjureTotal() {
		return injureTotal;
	}
	public void setInjureTotal(int injureTotal) {
		this.injureTotal = injureTotal;
	}
	public int getRapeTotal() {
		return rapeTotal;
	}
	public void setRapeTotal(int rapeTotal) {
		this.rapeTotal = rapeTotal;
	}
	public int getKidnapTotal() {
		return kidnapTotal;
	}
	public void setKidnapTotal(int kidnapTotal) {
		this.kidnapTotal = kidnapTotal;
	}
	public int getRobTotal() {
		return robTotal;
	}
	public void setRobTotal(int robTotal) {
		this.robTotal = robTotal;
	}
	public int getFireTotal() {
		return fireTotal;
	}
	public void setFireTotal(int fireTotal) {
		this.fireTotal = fireTotal;
	}
	public int getBombTotal() {
		return bombTotal;
	}
	public void setBombTotal(int bombTotal) {
		this.bombTotal = bombTotal;
	}
	public int getHijackTotal() {
		return hijackTotal;
	}
	public void setHijackTotal(int hijackTotal) {
		this.hijackTotal = hijackTotal;
	}
	public int getStealTotal() {
		return stealTotal;
	}
	public void setStealTotal(int stealTotal) {
		this.stealTotal = stealTotal;
	}
	public int getDestroyTotal() {
		return destroyTotal;
	}
	public void setDestroyTotal(int destroyTotal) {
		this.destroyTotal = destroyTotal;
	}
	public int getPoisoningTotal() {
		return poisoningTotal;
	}
	public void setPoisoningTotal(int poisoningTotal) {
		this.poisoningTotal = poisoningTotal;
	}
	public int getOtherTotal() {
		return otherTotal;
	}
	public void setOtherTotal(int otherTotal) {
		this.otherTotal = otherTotal;
	}
	
}
