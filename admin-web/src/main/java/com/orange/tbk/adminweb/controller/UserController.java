package com.orange.tbk.adminweb.controller;

import cn.hutool.core.util.StrUtil;
import com.orange.tbk.adminweb.annotation.ApiAuth;
import com.orange.tbk.adminweb.annotation.CurrentLimiting;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.adminweb.model.ApiAuthConstant;
import com.orange.tbk.adminweb.model.Response;
import com.orange.tbk.adminweb.model.ResponseCode;
import com.orange.tbk.api.bean.User;
import com.orange.tbk.api.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Reference(version = "${admin.version}", check = false)
    private UserService userService;

    @CurrentLimiting(explain = "系统后台登陆接口...")
    @RspHandle
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Response login(@RequestBody User user) {

        String token = userService.verifyUser(user.getUsername(), user.getPassword());
        if (StrUtil.isBlank(token)) return Response.build(ResponseCode.LOGIN_ERROR);
        return Response.build(ResponseCode.LOGIN_SUCCESS, ResponseCode.LOGIN_SUCCESS.getDesc(), token);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "logout",method = RequestMethod.POST)
    @ResponseBody
    public Response logout(@CookieValue("token") String token) {
        userService.logout(token);
        return Response.build(ResponseCode.LOGOUT_SUCCESS);
    }

}
