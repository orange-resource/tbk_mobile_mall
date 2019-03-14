package com.orange.tbk.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.orange.tbk.admin.mapper.HdkConfigMapper;
import com.orange.tbk.admin.util.hdkvisit.HdkApiVisit;
import com.orange.tbk.admin.util.hdkvisit.request.ApiDeserver;
import com.orange.tbk.api.bean.HdkConfig;
import com.orange.tbk.api.redis.RedisKeyConstant;
import com.orange.tbk.api.service.MobileHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class MobileHomeImpl implements MobileHomeService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private HdkConfigMapper hdkConfigMapper;

    @Override
    public String deserver() {

        String data = (String) redisTemplate.opsForValue().get(RedisKeyConstant.API_DATA + "deserver");
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiDeserver apiDeserver = new ApiDeserver();
            apiDeserver.setApikey(hdkConfig.getAppkey());

            try {
                String execute = HdkApiVisit.execute(apiDeserver);

                redisTemplate.opsForValue().set(RedisKeyConstant.API_DATA + "deserver",execute,1,
                        TimeUnit.HOURS);

                return execute;
            } catch (Exception e) {
                return "";
            }
        }

        return data;
    }

}
