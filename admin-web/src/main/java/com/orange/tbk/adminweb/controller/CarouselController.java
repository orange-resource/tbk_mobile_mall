package com.orange.tbk.adminweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.adminweb.model.Response;
import com.orange.tbk.adminweb.model.ResponseCode;
import com.orange.tbk.api.bean.Carousel;
import com.orange.tbk.api.service.CarouselService;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "course")
public class CarouselController {

    @Reference
    private CarouselService carouselService;

    @RspHandle
    @RequiresUser
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public Response list() {

        List<Carousel> carouselList = carouselService.list();

        return Response.build(ResponseCode.QUERY_SUCCESS,carouselList);
    }

    @RspHandle
    @RequiresUser
    @RequestMapping(value = "single",method = RequestMethod.GET)
    @ResponseBody
    public Response single(String carouselId) {

        Carousel carousel = carouselService.getById(carouselId);

        return Response.build(ResponseCode.QUERY_SUCCESS,carousel);
    }

    @RspHandle
    @RequiresUser
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public Response create(Carousel carousel) {

        boolean save = carouselService.save(carousel);
        if (save == true) {
            return Response.build(ResponseCode.SUCCESS);
        }
        return Response.build(ResponseCode.ERROR);
    }

    @RspHandle
    @RequiresUser
    @RequestMapping(value = "alter",method = RequestMethod.POST)
    @ResponseBody
    public Response update(Carousel carousel) {

        boolean update = carouselService.updateById(carousel);
        if (update == true) {
            return Response.build(ResponseCode.SUCCESS);
        }
        return Response.build(ResponseCode.ERROR);
    }

    @RspHandle
    @RequiresUser
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Response delete(String carouselId) {

        boolean delete = carouselService.removeById(carouselId);
        if (delete == true) {
            return Response.build(ResponseCode.SUCCESS);
        }
        return Response.build(ResponseCode.ERROR);
    }

}
