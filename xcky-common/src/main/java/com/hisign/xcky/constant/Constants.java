package com.hisign.xcky.constant;

/**
 * 常量类
 * 
 * @author Hong
 */
public class Constants {

	/**
	 * 当前用户
	 */
	public static final String CURRENT_USER = "currentUser";

	/**
	 * 是否代码：是
	 */
	public static final String SFDM_S = "1";

	/**
	 * 是否代码：否
	 */
	public static final String SFDM_F = "0";
	
	/**
	 * 删除标识：是
	 */
	public static final String DELETE_TRUE = "1";

	/**
	 * 删除标识：否
	 */
	public static final String DELETE_FALSE = "0";

	/**
	 * 成功
	 */
	public static final String SUCCESS = "success";

	/**
	 * 失败
	 */
	public static final String ERROR = "error";

	/**
	 * token名
	 */
	public static final String TOKEN = "token";

	/**
	 * 系统唯一标识名
	 */
	public static final String SYSTEMID = "XCKY";
	
	static public final byte HEX_DIGITS[] = {
        (byte) '0', (byte) '1', (byte) '2', (byte) '3',
        (byte) '4', (byte) '5', (byte) '6', (byte) '7',
        (byte) '8', (byte) '9', (byte) 'a', (byte) 'b',
        (byte) 'c', (byte) 'd', (byte) 'e', (byte) 'f'
    };


	/**
	 * redis服务中的常量
	 */
	public static final class Redis {

		/**
		 * 缓存全部单位信息的键值
		 */
		public static final String ORGAN = "ORGAN:";
		
		/**
		 * 缓存字典的键值前缀
		 */
		public static final String RES_DICT_PREFIX = "DICT:";
		/**
		 * 缓存系统参数
		 */
		public static final String RES_PARAMS_PREFIX = "PARAMS:";
		/**
		 * 过期时间（小时为单位）
		 */
		public static final int EXPIRE_TIME = 2;
		
		/**
		 * 现场信息录入模块缓存前缀
		 */
		public static final String INPUT_PREFIX = "INPUT:";
		
	}
	
	/**
	 * 编号前缀
	 * @author yinxiaoyong
	 * @mailto yinxiaoyong@hisign.com.cn
	 * 2016年12月20日
	 */
	public static final class SerialNo{
		
		/**
		 * 勘验编号前缀
		 */
		public static final String SCENEINVESTION_NO = "K";
		
		/**
		 * 提取物品编号前缀
		 */
		public static final String SCENECOLLECTEDGOODS_NO = "W";
		/**
		 * 提取物品编号前缀
		 */
		public static final String SCENEMATERIALEVIDENCE_NO = "H";
		
		/**
		 * 实体编号前缀
		 */
		public static final String SCENEBODYBASIC_NO = "J";
	}
	
	public static final class PICTURE_TYPE{
		public static final String PICTURE_TYPE_XCT_I = "1";// 现场图
		public static final String PICTURE_TYPE_XCZP_I = "2";// 现场照片
		public static final String PICTURE_TYPE_SYHJ_I = "3";// 手印痕迹
		public static final String PICTURE_TYPE_ZJHJ_I = "4";// 足迹痕迹
		public static final String PICTURE_TYPE_GJHJ_I = "5";// 工具痕迹
		public static final String PICTURE_TYPE_QDHJ_I = "6";// 枪弹痕迹
		public static final String PICTURE_TYPE_TSHJ_I = "7";// 特殊痕迹
		public static final String PICTURE_TYPE_SWWZ_I = "8";// 生物物证
		public static final String PICTURE_TYPE_DHWZ_I = "9";// 毒化物证
		public static final String PICTURE_TYPE_LHWZ_I = "10";// 理化物证
		public static final String PICTURE_TYPE_WJWZ_I = "11";// 文检物证
		public static final String PICTURE_TYPE_DZWZ_I = "12";// 电子物证
		public static final String PICTURE_TYPE_STWZ_I = "13";// 视听物证
		public static final String PICTURE_TYPE_QTWZ_I = "14";// 其他物证
		public static final String PICTURE_TYPE_STZP_I = "15";// 尸体照片
		public static final String PICTURE_TYPE_JZTP_I = "16";// 卷宗照片
		public static final String PICTURE_TYPE_XXTTP_I = "17";// 摄像头照片
		public static final String PICTURE_TYPE_TQWPZP_I = "18";// 提取物品照片
		
	}
	
	/**
	 * 系统参数中的常量
	 */
	public static final class SysParam {
		
		/**
		 * 文件服务器地址
		 */
		public static final String FILE_SERVER_PATH = "fileServerPath";
		
		/**
		 * 文件服务器上传地址
		 */
		public static final String FILE_UPLOAD_PATH = "fileUploadPath";
		
		/**
		 * 警综关联类型
		 */
		public static final String ALARM_RELATE_TYPE = "alarmRelateType";
		
		/**
		 * solr服务地址
		 */
		public static final String SOLR_ADDRESS_PATH = "solrAddress";
		
		/**
		 * solr全国服务地址
		 */
		public static final String SOLR_CHINA_ADDRESS_PATH = "solrGabAddress";
		
	}
	
}
