package com.orange.tbk.adminweb.controller;

import com.orange.tbk.adminweb.annotation.ApiAuth;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.adminweb.model.ApiAuthConstant;
import com.orange.tbk.adminweb.model.Response;
import com.orange.tbk.adminweb.model.ResponseCode;
import com.orange.tbk.api.bean.InterfaceManagement;
import com.orange.tbk.api.service.InterfaceManagementService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 接口管理
 */
@Controller
@RequestMapping(value = "interfaceManagement")
public class InterfaceManagementController {

    @Reference(version = "${admin.version}", check = false)
    private InterfaceManagementService interfaceManagementService;

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public Response list() {

        try {
            List<InterfaceManagement> all = interfaceManagementService.getAll();
            return Response.build(ResponseCode.QUERY_SUCCESS,all);
        } catch (Exception e) {
            return Response.build(ResponseCode.QUERY_ERROR);
        }
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "getSingle",method = RequestMethod.GET)
    @ResponseBody
    public Response getSingle(String key) {

        try {
            InterfaceManagement interfaceManagement = interfaceManagementService.getSingle(key);
            return Response.build(ResponseCode.QUERY_SUCCESS,interfaceManagement);
        } catch (Exception e) {
            return Response.build(ResponseCode.QUERY_ERROR);
        }
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "closeInterface",method = RequestMethod.POST)
    @ResponseBody
    public Response closeInterface(String key,Integer on) {

        try {

            if (on < 0 || on > 1) {
                return Response.build(ResponseCode.PARAMETER_ERROR);
            }

            interfaceManagementService.closeInterface(key,on);
            return Response.build(ResponseCode.SUCCESS);
        } catch (Exception e) {
            return Response.build(ResponseCode.ERROR);
        }
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "ipHandle",method = RequestMethod.POST)
    @ResponseBody
    public Response ipHandle(String key,Integer on) {

        try {

            if (on < 0 || on > 1) {
                return Response.build(ResponseCode.PARAMETER_ERROR);
            }

            interfaceManagementService.ipHandle(key,on);
            return Response.build(ResponseCode.SUCCESS);
        } catch (Exception e) {
            return Response.build(ResponseCode.ERROR);
        }
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Response update(InterfaceManagement interfaceManagement) {

        try {

            interfaceManagementService.update(interfaceManagement);
            return Response.build(ResponseCode.SUCCESS);
        } catch (Exception e) {
            return Response.build(ResponseCode.ERROR);
        }
    }

}
