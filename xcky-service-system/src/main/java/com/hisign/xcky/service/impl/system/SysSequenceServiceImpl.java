package com.hisign.xcky.service.impl.system;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hisign.xcky.api.model.system.SysSequence;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.system.SysSequenceService;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.persist.mapper.system.SysSequenceMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;

/**
 * 流水业务接口
 * 项目名称：xcky-service-system   
 * 类名称：SysSequenceServiceImpl   
 * 类描述：   
 * 创建人：郭辰 
 * 创建时间：2016-12-8 下午5:43:21   
 * 修改人：hisign   
 * 修改时间：2016-12-8 下午5:43:21   
 * 修改备注：   
 * @version
 */
@Service("sysSequenceService")
public class SysSequenceServiceImpl extends BaseServiceImpl<SysSequence> implements SysSequenceService{
	private final static Logger logger = LoggerFactory.getLogger(SysSequenceServiceImpl.class);
	/**
	 * 持久层接口
	 */
	@Autowired
	private SysSequenceMapper sysSequenceMapper;
	@Override
	public Mapper<SysSequence> getMapper() {
		// TODO Auto-generated method stub
		return sysSequenceMapper;
	}
	//流水号时间格式
	public DateFormat dateFormat = new SimpleDateFormat("yyyyMM");
	
	//最大流水号补充
	public DecimalFormat decimalFormat = new DecimalFormat(StringUtils.repeat("0",4));
	/**
	 * 获取最新的业务流水号
	 * 方法功能说明：  
	 * 创建：2016-12-8 下午4:01:04 by guochen
	 * @参数： 
	 * @参数：    
	 * @return  
	 * @throws
	 */
	@Override
	public String getNextSerialNo(String seqType,String token) {
		SysUser optUser = getCurrentUser(token);
		//获取最大流水对象并更新数据库
		SysSequence  sysSequence =getNewSysSequence(seqType, optUser.getOrganCode(),token);
		String nextSerialNo = "";
		nextSerialNo =seqType+optUser.getOrganCode()+sysSequence.getCurDate()+sysSequence.getMaxSeq();
		logger.info("业务流水号："+nextSerialNo);
		return nextSerialNo;
	}
	/**
	 * 得到最新的流水信息
	 * 方法功能说明：  
	 * 创建：2016-12-8 下午4:28:31 by guochen
	 * @参数： seqType流水号类型，前缀
	 * @参数：  orgCode 当前用户机构代码  
	 * @return  
	 * @throws
	 */
	public SysSequence getNewSysSequence(String seqType, String orgCode,String token){
		SysUser optUser = getCurrentUser(token);
		SysSequence t = null;
		SysSequence filter = new SysSequence();
		filter.setSeqType(seqType);
		filter.setOrgCode(orgCode);
		filter.setCurDate(dateFormat.format(this.getSyetemTime()));
		t = sysSequenceMapper.findMaxSeqByFilter(filter);
		String maxNo = null;
		if(t==null){
			logger.info("流水信息不存在，插入新数据");
			t=new SysSequence();
			maxNo = decimalFormat.format(1);
			logger.info("流水最大值"+maxNo);
			t.setSeqType(seqType);
			t.setOrgCode(orgCode);
			t.setMaxSeq(maxNo);
			t.setCurDate(dateFormat.format(this.getSyetemTime()));
			//插入
			Date now = this.getSyetemTime();
			if(t.getId()==null||"".equals(t.getId())){
				t.setId(this.generateUUID());
			}
			t.setVersion(this.generateVersion());
			t.setCreateUserId(optUser.getId());
			t.setUpdateUserId(optUser.getId());
			t.setCreateTime(now);
			t.setUpdateTime(now);
			t.setDeleteFlag(Constants.DELETE_FALSE);
			// 数据来源，默认XCKY
			if (StringUtils.isBlank(t.getSource())) {
				t.setSource(Constants.SYSTEMID);
			}
			getMapper().add(t);
			//返回
			return t;
		}else{
			logger.info("当前业务流水存在");
			maxNo = t.getMaxSeq();
			logger.info("当前存库流水好最大值"+maxNo);
			maxNo = decimalFormat.format(Long.parseLong(maxNo) + 1);
			t.setMaxSeq(maxNo);
			//当前库的版本
			long versionData=t.getVersion();
			t.setVersionFlag(versionData);
			long version = this.generateVersion();
			t.setVersion(version);
			t.setUpdateUserId(optUser.getId());
			t.setUpdateTime(this.getSyetemTime());
			sysSequenceMapper.updateByIdAndVersionFlag(t);
			SysSequence filter2 = new SysSequence();
			filter2.setId(t.getId());
			filter2.setVersion(version);
			SysSequence sysSequence = sysSequenceMapper.findSysSequenceByIdAndVersion(filter2);
			if(sysSequence!=null){
				return sysSequence;
			}else{
				return getNewSysSequence(seqType, orgCode,token);
			}
		}
	}
}
