package com.orange.tbk.adminweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orange.tbk.adminweb.annotation.RspHandle;
import com.orange.tbk.adminweb.model.Response;
import com.orange.tbk.adminweb.model.ResponseCode;
import com.orange.tbk.api.bean.Course;
import com.orange.tbk.api.service.CourseService;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "course")
public class CourseController {

    @Reference
    private CourseService courseService;

    @RspHandle
    @RequiresUser
    @RequestMapping(value = "page",method = RequestMethod.GET)
    @ResponseBody
    public Response page(Course course, Page page) {

        Page<Course> coursePage = courseService.page(course, page);

        return Response.build(ResponseCode.QUERY_SUCCESS,coursePage);
    }

    @RspHandle
    @RequiresUser
    @RequestMapping(value = "single",method = RequestMethod.GET)
    @ResponseBody
    public Response single(String courseId) {

        Course course = courseService.getById(courseId);

        return Response.build(ResponseCode.QUERY_SUCCESS,course);
    }

    @RspHandle
    @RequiresUser
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
    @RequiresUser
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
    @RequiresUser
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
