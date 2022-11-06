package com.orange.tbk.adminweb.controller;

import com.orange.tbk.adminweb.annotation.CurrentLimiting;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.api.service.MobileDiscoveryService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 发现
 */
@Controller
@RequestMapping(value = "discovery")
public class MobileDiscoveryController {

    @Reference(version = "${admin.version}", check = false)
    private MobileDiscoveryService mobileDiscoveryService;

    /**
     * 获取精选单品
     */
    @CurrentLimiting(explain = "获取精选单品")
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "handpick",method = RequestMethod.GET)
    @ResponseBody
    public Object handpick(Integer page) {

        return mobileDiscoveryService.handpick(page);
    }

    /**
     * 获取好货专场
     */
    @CurrentLimiting(explain = "获取好货专场")
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "news",method = RequestMethod.GET)
    @ResponseBody
    public Object news(Integer page) {

        return mobileDiscoveryService.news(page);
    }

    /**
     * 获取精选主题 list
     */
    @CurrentLimiting(explain = "获取精选主题 list")
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "themeList",method = RequestMethod.GET)
    @ResponseBody
    public Object themeList() {

        return mobileDiscoveryService.themeList();
    }

    /**
     * 获取精选主题 item
     */
    @CurrentLimiting(explain = "获取精选主题 item")
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "theme",method = RequestMethod.GET)
    @ResponseBody
    public Object theme(Integer themeId) {

        return mobileDiscoveryService.theme(themeId);
    }

}
