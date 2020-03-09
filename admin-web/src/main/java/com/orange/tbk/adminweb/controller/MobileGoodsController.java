package com.orange.tbk.adminweb.controller;

import com.orange.tbk.adminweb.annotation.CurrentLimiting;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.api.service.MobileGoodsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品
 */
@Controller
@RequestMapping(value = "goods")
public class MobileGoodsController {

    @Reference(version = "${admin.version}", check = false)
    private MobileGoodsService mobileGoodsService;

    /**
     * 获取商品详情
     */
    @CurrentLimiting(explain = "获取商品详情")
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "getDetails",method = RequestMethod.GET)
    @ResponseBody
    public Object getDetails(String goodsId) {

        return mobileGoodsService.getDetails(goodsId);
    }

    /**
     * 申请商品高佣
     */
    @CurrentLimiting(explain = "申请商品高佣")
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "rates",method = RequestMethod.GET)
    @ResponseBody
    public Object rates(String goodsId) {

        return mobileGoodsService.rates(goodsId);
    }
    /**
     * 获取猜你商品
     */
    @CurrentLimiting(explain = "获取猜你商品")
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "like",method = RequestMethod.GET)
    @ResponseBody
    public Object like(String goodsId) {

        return mobileGoodsService.like(goodsId);
    }

}
