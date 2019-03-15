package com.orange.tbk.adminweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.api.service.MobileSearchService;
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

    @Reference
    private MobileSearchService mobileSearchService;

    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "keyword",method = RequestMethod.GET)
    @ResponseBody
    public Object keyword() {

        return mobileSearchService.keyword();
    }

    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "goods",method = RequestMethod.GET)
    @ResponseBody
    public Object goods(String keyword,Integer tag,Integer page) {

        return mobileSearchService.goods(keyword,tag,page);
    }

}
