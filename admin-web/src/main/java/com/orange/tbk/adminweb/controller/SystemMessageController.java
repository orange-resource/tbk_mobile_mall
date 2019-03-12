package com.orange.tbk.adminweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.adminweb.model.Response;
import com.orange.tbk.adminweb.model.ResponseCode;
import com.orange.tbk.api.bean.SystemMessage;
import com.orange.tbk.api.service.SystemMessageService;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "systemMessage")
public class SystemMessageController {

    @Reference
    private SystemMessageService systemMessageService;

    @RspHandle
    @RequiresUser
    @RequestMapping(value = "page",method = RequestMethod.GET)
    @ResponseBody
    public Response page(SystemMessage systemMessage, Page page) {

        Page<SystemMessage> systemMessagePage = systemMessageService.page(systemMessage, page);

        return Response.build(ResponseCode.QUERY_SUCCESS,systemMessagePage);
    }

    @RspHandle
    @RequiresUser
    @RequestMapping(value = "single",method = RequestMethod.GET)
    @ResponseBody
    public Response single(String systemMessageId) {

        SystemMessage systemMessage = systemMessageService.getById(systemMessageId);

        return Response.build(ResponseCode.QUERY_SUCCESS,systemMessage);
    }

    @RspHandle
    @RequiresUser
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
    @RequiresUser
    @RequestMapping(value = "alter",method = RequestMethod.POST)
    @ResponseBody
    public Response update(SystemMessage systemMessage) {

        boolean update = systemMessageService.updateById(systemMessage);
        if (update == true) {
            return Response.build(ResponseCode.SUCCESS);
        }
        return Response.build(ResponseCode.ERROR);
    }

    @RspHandle
    @RequiresUser
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Response delete(String systemMessageId) {

        boolean delete = systemMessageService.removeById(systemMessageId);
        if (delete == true) {
            return Response.build(ResponseCode.SUCCESS);
        }
        return Response.build(ResponseCode.ERROR);
    }

}
