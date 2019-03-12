package com.orange.tbk.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.tbk.api.bean.Course;

public interface CourseService extends IService<Course> {

    Page<Course> page(Course course, Page page);

}
