package com.orange.tbk.adminweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.api.service.MobileGoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "goods")
public class MobileGoodsController {

    @Reference
    private MobileGoodsService mobileGoodsService;

    /**
     * 获取商品详情
     */
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "getDetails",method = RequestMethod.GET)
    @ResponseBody
    public Object getDetails(String goodsId) {

        return mobileGoodsService.getDetails(goodsId);
    }

    /**
     * 申请商品高佣
     */
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "rates",method = RequestMethod.GET)
    @ResponseBody
    public Object rates(String goodsId) {

        return mobileGoodsService.rates(goodsId);
    }
    /**
     * 获取猜你商品
     */
    @RspHandle(isReturnObject = true)
    @RequestMapping(value = "like",method = RequestMethod.GET)
    @ResponseBody
    public Object like(String goodsId) {

        return mobileGoodsService.like(goodsId);
    }

}
