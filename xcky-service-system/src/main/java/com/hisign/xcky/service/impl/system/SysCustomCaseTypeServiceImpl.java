package com.hisign.xcky.service.impl.system;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.hisign.sso.api.rest.exception.RestBusinessException;
import com.hisign.xcky.api.model.system.SysCustomCaseType;
import com.hisign.xcky.api.model.system.SysUser;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.api.service.system.SysCustomCaseTypeService;
import com.hisign.xcky.common.JsonResult;
import com.hisign.xcky.constant.Constants;
import com.hisign.xcky.persist.mapper.system.SysCustomCaseTypeMapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;
import com.hisign.xcky.util.JsonResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义案件类别服务实现类
 * @Author hotdog
 * @Mail zhaoqian@hisign.com.cn
 * @Date 2017/1/12 14:55
 */
@Path("/sysCustomCaseType")
@Consumes({ MediaType.APPLICATION_JSON})
@Produces({ ContentType.APPLICATION_JSON_UTF_8})
@Service("sysCustomCaseTypeService")
@Transactional
public class SysCustomCaseTypeServiceImpl extends BaseServiceImpl implements SysCustomCaseTypeService{

    private Logger logger = LoggerFactory.getLogger(SysCustomCaseTypeServiceImpl.class);

    @Resource
    private SysCustomCaseTypeMapper mapper;

    @Override
    @POST
    @Path("add")
    public JsonResult add(SysCustomCaseType t, @HeaderParam("token") String token) throws Exception {
        logger.debug("自定义案件类别添加");
        SysUser optUser = getCurrentUser(token);
        Date now = super.getSyetemTime();
        SysCustomCaseType obj = new SysCustomCaseType();
        obj.setGroupId(super.generateUUID());
        obj.setGroupName(t.getGroupName());
        obj.setGroupDesc(t.getGroupDesc());
        obj.setVersion(super.generateVersion());
        obj.setCreateUserId(optUser.getId());
        obj.setUpdateUserId(optUser.getId());
        obj.setCreateTime(now);
        obj.setUpdateTime(now);
        obj.setDeleteFlag(Constants.DELETE_FALSE);
        obj.setSystemFlag(Constants.DELETE_FALSE); // 客户端录入的自定义为非系统默认
        mapper.add(obj);
        obj.setCaseType(t.getCaseType());
        addSub(obj);
        return JsonResultUtil.success();
    }

    @Override
    public void addSub(SysCustomCaseType obj) {
        if (obj == null || obj.getCaseType() == null) {
            return;
        }
        obj.setGroupName(null);
        obj.setGroupDesc(null);
        String[] caseType = obj.getCaseType().split(",");
        String groupId = obj.getGroupId();
        for (int i = 0, l = caseType.length; i < l; i++) {
            obj.setGroupId(super.generateUUID());
            obj.setParentGroupId(groupId);
            obj.setCaseType(caseType[i]);
            mapper.add(obj);
        }
    }

    @Override
    @POST
    @Path("update")
    public JsonResult update(SysCustomCaseType t, @HeaderParam("token") String token) throws Exception {
        logger.debug("自定义案件类别编辑");
        SysUser optUser = getCurrentUser(token);
        Date now = super.getSyetemTime();

        t.setVersion(super.generateVersion());
        t.setUpdateUserId(optUser.getId());
        t.setUpdateTime(now);
        mapper.updateById(t);
        Map<String,String> map = new HashMap<String, String>();
        map.put("parentGroupId",t.getGroupId());
        mapper.delete(map);

        t.setCreateUserId(optUser.getId());
        t.setCreateTime(now);
        t.setDeleteFlag(Constants.DELETE_FALSE);
        t.setSystemFlag(Constants.DELETE_FALSE);
        addSub(t);
        return JsonResultUtil.success();
    }

    @Override
    @POST
    @Path("pagequery")
    public JsonResult pagequery(SysCustomCaseType t) throws Exception {
        logger.debug("自定义案件类别分页查询");
        return super.queryPage(t);
    }

    @Override
    @GET
    @Path("delete/{groupId}")
    public JsonResult delete(@PathParam("groupId") String groupId) throws Exception {
        Map<String,String> map = new HashMap<String, String>();
        map.put("groupId",groupId);
        mapper.delete(map);
        return JsonResultUtil.success();
    }

    @Override
    public Mapper getMapper() {
        return mapper;
    }


}
