package com.orange.tbk.admin.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.tbk.admin.mapper.CourseMapper;
import com.orange.tbk.api.bean.Course;
import com.orange.tbk.api.service.CourseService;
import com.orange.tbk.api.vo.open.CourseVo;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "${version}")
public class CourseImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Override
    public Page<Course> page(Course course, Page page) {

        return page.setRecords(super.baseMapper.page(course,page));
    }

    @Override
    public List<CourseVo> getList() {

        return super.baseMapper.getList();
    }

    @Override
    public CourseVo article(String articleId) {

        return super.baseMapper.article(articleId);
    }

}
