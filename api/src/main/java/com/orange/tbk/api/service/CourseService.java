package com.orange.tbk.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.tbk.api.bean.Course;
import com.orange.tbk.api.vo.open.CourseVo;

import java.util.List;

public interface CourseService extends IService<Course> {

    Page<Course> page(Course course, Page page);

    List<CourseVo> getList();

    CourseVo article(String articleId);

}
