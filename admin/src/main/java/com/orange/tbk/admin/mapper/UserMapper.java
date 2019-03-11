package com.orange.tbk.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.orange.tbk.api.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {

    @Select("select count(*) from t_user where username = #{username} and password = #{password}")
    int verifyUser(@Param("username") String username, @Param("password") String password);

}