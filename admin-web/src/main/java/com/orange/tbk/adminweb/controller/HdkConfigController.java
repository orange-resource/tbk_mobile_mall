package com.orange.tbk.adminweb.controller;

import com.orange.tbk.adminweb.annotation.ApiAuth;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.adminweb.model.ApiAuthConstant;
import com.orange.tbk.adminweb.model.Response;
import com.orange.tbk.adminweb.model.ResponseCode;
import com.orange.tbk.api.bean.HdkConfig;
import com.orange.tbk.api.service.HdkConfigService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 好单库 配置
 */
@Controller
@RequestMapping(value = "hdkConfig")
public class HdkConfigController {

    @Reference(version = "${admin.version}", check = false)
    private HdkConfigService hdkConfigService;

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "single",method = RequestMethod.GET)
    @ResponseBody
    public Response single() {

        List<HdkConfig> list = hdkConfigService.list();
        if (list == null || list.size() == 0) {
            return Response.build(ResponseCode.EMPTY);
        }

        return Response.build(ResponseCode.QUERY_SUCCESS,list.get(0));
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public Response create(HdkConfig hdkConfig) {

        hdkConfigService.create(hdkConfig);

        return Response.build(ResponseCode.SUCCESS);
    }

}
