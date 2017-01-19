package com.hisign.xcky.persist.mapper.system;

import com.hisign.xcky.api.model.system.SysCustomCaseType;
import com.hisign.xcky.api.persist.Mapper;

import java.util.Map;

/**
 * 自定义案件类别分组mapper
 * @Author hotdog
 * @Mail zhaoqian@hisign.com.cn
 * @Date 2017/1/12 14:06
 */
public interface SysCustomCaseTypeMapper extends Mapper<SysCustomCaseType> {

    void delete (Map<String,String> map);
}
