package com.orange.tbk.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orange.tbk.api.bean.Course;
import com.orange.tbk.api.vo.open.CourseVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper extends BaseMapper<Course> {

    @Select("<script>" +
            "select * from t_course " +
            "<where> " +
            "<if test=\"course.title != null and course.title !=''\">" +
            "and title like concat('%',#{course.title},'%') " +
            "</if>" +
            "<if test=\"course.content != null and course.content !=''\">" +
            "and content like concat('%',#{course.content},'%') " +
            "</if>" +
            "</where>" +
            "order by create_date desc" +
            "</script>")
    List<Course> page(@Param("course") Course course, Page page);

    @Select("select id,create_date,title,content,author,image from t_course " +
            "order by create_date desc " +
            "limit 0,30")
    List<CourseVo> getList();

    @Select("select id,create_date,title,content,author,image from t_course " +
            "where id = #{articleId}")
    CourseVo article(@Param("articleId") String articleId);

}