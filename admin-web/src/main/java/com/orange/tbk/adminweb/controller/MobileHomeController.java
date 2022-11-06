package com.orange.tbk.adminweb.controller;

import com.orange.tbk.adminweb.annotation.CurrentLimiting;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.api.service.MobileHomeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 首页
 */
@Controller
@RequestMapping(value = "home")
public class MobileHomeController {

    @Reference(version = "${admin.version}", check = false)
    private MobileHomeService mobileHomeService;

    /**
     * 获取今日值得买
     * 用于首页下方常展示
     */
    @CurrentLimiting(explain = "获取今日值得买")
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "deserver",method = RequestMethod.GET)
    @ResponseBody
    public Object deserver() {

        return mobileHomeService.deserver();
    }
    
    /**
     * 获取超值大牌
     */
    @CurrentLimiting(explain = "获取超值大牌")
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "brand",method = RequestMethod.GET)
    @ResponseBody
    public Object brand(Integer page,Integer tag) {

        return mobileHomeService.brand(page,tag);
    }

    /**
     * 商品筛选 主要获取聚划算,淘抢购,9.9包邮...
     */
    @CurrentLimiting(explain = "商品筛选 主要获取聚划算,淘抢购,9.9包邮...")
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "district",method = RequestMethod.GET)
    @ResponseBody
    public Object district(Integer page,Integer tag,Integer type,Integer category) {

        return mobileHomeService.district(page,tag,type,category);
    }
    
    /**
     * 获取达人说列表
     */
    @CurrentLimiting(explain = "获取达人说列表")
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "talent",method = RequestMethod.GET)
    @ResponseBody
    public Object talent() {

        return mobileHomeService.talent();
    }

    /**
     * 获取达人说文章
     */
    @CurrentLimiting(explain = "获取达人说文章")
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "talent/article",method = RequestMethod.GET)
    @ResponseBody
    public Object talentArticle(String articleId) {

        return mobileHomeService.talentArticle(articleId);
    }

    /**
     * 获取热销榜单
     */
    @CurrentLimiting(explain = "获取热销榜单")
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "hot",method = RequestMethod.GET)
    @ResponseBody
    public Object hot(Integer category) {

        return mobileHomeService.hot(category);
    }
}
