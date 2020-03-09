package com.orange.tbk.adminweb.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orange.tbk.adminweb.annotation.ApiAuth;
import com.orange.tbk.adminweb.annotation.CurrentLimiting;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.adminweb.model.ApiAuthConstant;
import com.orange.tbk.adminweb.model.Response;
import com.orange.tbk.adminweb.model.ResponseCode;
import com.orange.tbk.api.bean.Course;
import com.orange.tbk.api.service.CourseService;
import com.orange.tbk.api.vo.open.CourseVo;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 新手教程
 */
@Controller
@RequestMapping(value = "course")
public class CourseController {

    @Reference(version = "${admin.version}", check = false)
    private CourseService courseService;

    /**
     * 只会显示前30条
     */
    @CurrentLimiting(explain = "获取新手教程列表 只会显示前30条")
    @RspHandle
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public Response list() {

        List<CourseVo> list = courseService.getList();

        return Response.build(ResponseCode.QUERY_SUCCESS,list);
    }

    @CurrentLimiting(explain = "获取新手教程文章")
    @RspHandle
    @RequestMapping(value = "article",method = RequestMethod.GET)
    @ResponseBody
    public Response article(String articleId) {

        CourseVo article = courseService.article(articleId);

        return Response.build(ResponseCode.QUERY_SUCCESS,article);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "page",method = RequestMethod.GET)
    @ResponseBody
    public Response page(Course course, Page page) {

        Page<Course> coursePage = courseService.page(course, page);

        return Response.build(ResponseCode.QUERY_SUCCESS,coursePage);
    }

    @RspHandle
    @RequestMapping(value = "count",method = RequestMethod.GET)
    @ResponseBody
    public Response count() {

        int count = courseService.count();

        return Response.build(ResponseCode.QUERY_SUCCESS,count);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "single",method = RequestMethod.GET)
    @ResponseBody
    public Response single(String courseId) {

        Course course = courseService.getById(courseId);

        return Response.build(ResponseCode.QUERY_SUCCESS,course);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public Response create(Course course) {

        boolean save = courseService.save(course);
        if (save == true) {
            return Response.build(ResponseCode.SUCCESS);
        }
        return Response.build(ResponseCode.ERROR);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "alter",method = RequestMethod.POST)
    @ResponseBody
    public Response alter(Course course) {

        boolean update = courseService.updateById(course);
        if (update == true) {
            return Response.build(ResponseCode.SUCCESS);
        }
        return Response.build(ResponseCode.ERROR);
    }

    @RspHandle
    @ApiAuth(type = ApiAuthConstant.ADMIN)
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public Response delete(String courseId) {

        boolean remove = courseService.removeById(courseId);
        if (remove == true) {
            return Response.build(ResponseCode.SUCCESS);
        }
        return Response.build(ResponseCode.ERROR);
    }


}
