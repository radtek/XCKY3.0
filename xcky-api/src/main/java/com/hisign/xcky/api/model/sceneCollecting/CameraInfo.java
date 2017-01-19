package com.hisign.xcky.api.model.sceneCollecting;

import com.hisign.xcky.api.model.common.BaseModel;
/**
 * 摄像头信息
 * 项目名称：xcky-api   
 * 类名称：CameraInfo   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-19 上午10:11:24   
 * 修改人：hisign   
 * 修改时间：2016-12-19 上午10:11:24   
 * 修改备注：   
 * @version
 */
public class CameraInfo extends BaseModel{


	/**
     * 勘验信息ID
     */
    private String investigationId;
    /**
     * 摄像头名称
     */
    private String cameraName;
    /**
     * 设备类型
     */
    private String cameraType;
    /**
     * 摄像头朝向
     */
    private String cameraOrientation;
    /**
     * 经度
     */
    private float longitude;
    /**
     * 纬度
     */
    private float latitude;
    /**
     * 图片ID
     */
    private String pictureId;
    /**
     * 设备类型
     */
    private String cameraTypeCn;
    /**
     * 摄像头朝向
     */
    private String cameraOrientationCn;    
    /**
     * 原始文件附件ID与传值
     */
    private String attachmentId;
    
    
	public String getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(String attachmentId) {
		this.attachmentId = attachmentId;
	}
	public String getInvestigationId() {
		return investigationId;
	}
	public void setInvestigationId(String investigationId) {
		this.investigationId = investigationId;
	}
	public String getCameraName() {
		return cameraName;
	}
	public void setCameraName(String cameraName) {
		this.cameraName = cameraName;
	}
	public String getCameraType() {
		return cameraType;
	}
	public void setCameraType(String cameraType) {
		this.cameraType = cameraType;
	}
	public String getCameraOrientation() {
		return cameraOrientation;
	}
	public void setCameraOrientation(String cameraOrientation) {
		this.cameraOrientation = cameraOrientation;
	}
	
	public String getPictureId() {
		return pictureId;
	}
	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public String getCameraTypeCn() {
		return cameraTypeCn;
	}
	public void setCameraTypeCn(String cameraTypeCn) {
		this.cameraTypeCn = cameraTypeCn;
	}
	public String getCameraOrientationCn() {
		return cameraOrientationCn;
	}
	public void setCameraOrientationCn(String cameraOrientationCn) {
		this.cameraOrientationCn = cameraOrientationCn;
	}
}
