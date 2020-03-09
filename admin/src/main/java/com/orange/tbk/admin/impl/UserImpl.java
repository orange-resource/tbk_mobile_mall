package com.orange.tbk.admin.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.tbk.admin.mapper.UserMapper;
import com.orange.tbk.api.bean.User;
import com.orange.tbk.api.redis.RedisKeyConstant;
import com.orange.tbk.api.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Service(version = "${version}")
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public String verifyUser(String username, String password) {
        int verifyUser = super.baseMapper.verifyUser(username, password);
        if (verifyUser == 0) return "";
        String token = IdUtil.simpleUUID() + IdUtil.simpleUUID();
        redisTemplate.opsForValue().set(RedisKeyConstant.TOKEN + token, token, 1, TimeUnit.DAYS);
        return token;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(RedisKeyConstant.TOKEN + token);
    }

}
