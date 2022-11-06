package com.orange.tbk.adminweb.controller;

import com.orange.tbk.adminweb.annotation.CurrentLimiting;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.api.service.MobileSearchService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 搜索
 */
@Controller
@RequestMapping(value = "search")
public class MobileSearchController {

    @Reference(version = "${admin.version}", check = false)
    private MobileSearchService mobileSearchService;

    @CurrentLimiting(explain = "获取热搜关键词")
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "keyword",method = RequestMethod.GET)
    @ResponseBody
    public Object keyword() {

        return mobileSearchService.keyword();
    }

    @CurrentLimiting(explain = "搜索商品")
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "goods",method = RequestMethod.GET)
    @ResponseBody
    public Object goods(String keyword,Integer tag,Integer page) {

        return mobileSearchService.goods(keyword,tag,page);
    }

}
