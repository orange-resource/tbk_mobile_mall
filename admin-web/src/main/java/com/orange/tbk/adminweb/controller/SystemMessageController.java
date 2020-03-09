package com.orange.tbk.adminweb.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orange.tbk.adminweb.annotation.ApiAuth;
import com.orange.tbk.adminweb.annotation.CurrentLimiting;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.adminweb.model.ApiAuthConstant;
import com.orange.tbk.adminweb.model.Response;
import com.orange.tbk.adminweb.model.ResponseCode;
import com.orange.tbk.api.bean.SystemMessage;
import com.orange.tbk.api.service.SystemMessageService;
import com.orange.tbk.api.vo.open.SystemMessageVo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 系统消息
 */
@Controller
@RequestMapping(value = "systemMessage")
public class SystemMessageController {

    @Reference(version = "${admin.version}", check = false)
    private SystemMessageService systemMessageService;

    /**
     * 只会显示前30条系统消息
     */
    @CurrentLimiting(explain = "获取系统消息列表 只会显示前30条系统消息")
    @RspHandle
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public Response list() {

        List<SystemMessageVo> list = systemMessageService.getList();

        return Response.build(ResponseCode.QUERY_SUCCESS,list);
    }

    @CurrentLimiting(explain = "获取系统消息文章详情...")
    @RspHandle
    @RequestMapping(value = "article",method = RequestMethod.GET)
    @ResponseBody
    public Response article(String articleId) {

        SystemMessageVo article = systemMessageService.article(articleId);

        return Response.build(ResponseCode.QUERY_SUCCESS,article);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "page",method = RequestMethod.GET)
    @ResponseBody
    public Response page(SystemMessage systemMessage, Page page) {

        Page<SystemMessage> systemMessagePage = systemMessageService.page(systemMessage, page);

        return Response.build(ResponseCode.QUERY_SUCCESS,systemMessagePage);
    }

    @RspHandle
    @RequestMapping(value = "count",method = RequestMethod.GET)
    @ResponseBody
    public Response count() {

        int count = systemMessageService.count();

        return Response.build(ResponseCode.QUERY_SUCCESS,count);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "single",method = RequestMethod.GET)
    @ResponseBody
    public Response single(String systemMessageId) {

        SystemMessage systemMessage = systemMessageService.getById(systemMessageId);

        return Response.build(ResponseCode.QUERY_SUCCESS,systemMessage);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public Response create(SystemMessage systemMessage) {

        boolean save = systemMessageService.save(systemMessage);
        if (save == true) {
            return Response.build(ResponseCode.SUCCESS);
        }
        return Response.build(ResponseCode.ERROR);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "alter",method = RequestMethod.POST)
    @ResponseBody
    public Response alter(SystemMessage systemMessage) {

        boolean update = systemMessageService.updateById(systemMessage);
        if (update == true) {
            return Response.build(ResponseCode.SUCCESS);
        }
        return Response.build(ResponseCode.ERROR);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Response delete(String systemMessageId) {

        boolean remove = systemMessageService.removeById(systemMessageId);
        if (remove == true) {
            return Response.build(ResponseCode.SUCCESS);
        }
        return Response.build(ResponseCode.ERROR);
    }

}
