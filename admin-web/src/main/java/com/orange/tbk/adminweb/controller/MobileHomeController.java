package com.orange.tbk.adminweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.api.service.MobileHomeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "home")
public class MobileHomeController {

    @Reference
    private MobileHomeService mobileHomeService;

    /**
     * 获取今日值得买
     * 用于首页下方常展示
     */
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "deserver",method = RequestMethod.GET)
    @ResponseBody
    public Object deserver() {

        return mobileHomeService.deserver();
    }

}
