package com.orange.tbk.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.orange.tbk.api.bean.SystemMessage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SystemMessageMapper extends BaseMapper<SystemMessage> {

    @Select("<script>" +
            "select * from t_system_message " +
            "where " +
            "<if test=\"systemMessage.title != null and systemMessage.title !=''\">" +
            "and title like concat('%',#{systemMessage.title},'%') " +
            "</if>" +
            "<if test=\"systemMessage.content != null and systemMessage.content !=''\">" +
            "and content like concat('%',#{systemMessage.content},'%') " +
            "</if>" +
            "order by create_date desc" +
            "</script>")
    List<SystemMessage> page(@Param("systemMessage") SystemMessage systemMessage, Page page);

}