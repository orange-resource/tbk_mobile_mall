package com.orange.tbk.adminweb.controller;

import com.orange.tbk.adminweb.annotation.ApiAuth;
import com.orange.tbk.adminweb.annotation.CurrentLimiting;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.adminweb.model.ApiAuthConstant;
import com.orange.tbk.adminweb.model.Response;
import com.orange.tbk.adminweb.model.ResponseCode;
import com.orange.tbk.api.bean.Carousel;
import com.orange.tbk.api.service.CarouselService;
import com.orange.tbk.api.vo.open.CarouselVo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 首页轮播
 */
@Controller
@RequestMapping(value = "carousel")
public class CarouselController {

    @Reference(version = "${admin.version}", check = false)
    private CarouselService carouselService;

    @CurrentLimiting(explain = "获取首页轮播 按照sort字段排序")
    @RspHandle
    @RequestMapping(value = "getListBySort",method = RequestMethod.GET)
    @ResponseBody
    public Response getListBySort() {

        List<CarouselVo> carouselVoList = carouselService.getListBySort();

        return Response.build(ResponseCode.QUERY_SUCCESS,carouselVoList);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "getListByCreateDate",method = RequestMethod.GET)
    @ResponseBody
    public Response getListByCreateDate() {

        List<Carousel> carouselList = carouselService.getListByCreateDate();

        return Response.build(ResponseCode.QUERY_SUCCESS,carouselList);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "single",method = RequestMethod.GET)
    @ResponseBody
    public Response single(String carouselId) {

        Carousel carousel = carouselService.getById(carouselId);

        return Response.build(ResponseCode.QUERY_SUCCESS,carousel);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public Response create(Carousel carousel) {

        carouselService.create(carousel);

        return Response.build(ResponseCode.SUCCESS);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "alter",method = RequestMethod.POST)
    @ResponseBody
    public Response alter(Carousel carousel) {

        carouselService.alter(carousel);

        return Response.build(ResponseCode.SUCCESS);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Response delete(String carouselId) {

        carouselService.delete(carouselId);

        return Response.build(ResponseCode.SUCCESS);
    }

}
