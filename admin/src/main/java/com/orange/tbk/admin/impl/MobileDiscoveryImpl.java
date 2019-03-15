package com.orange.tbk.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.orange.tbk.admin.mapper.HdkConfigMapper;
import com.orange.tbk.admin.util.hdkvisit.HdkApiVisit;
import com.orange.tbk.admin.util.hdkvisit.request.*;
import com.orange.tbk.api.bean.HdkConfig;
import com.orange.tbk.api.redis.RedisKeyConstant;
import com.orange.tbk.api.service.MobileDiscoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class MobileDiscoveryImpl implements MobileDiscoveryService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private HdkConfigMapper hdkConfigMapper;

    @Override
    public String handpick(Integer page) {

        String redisKey = RedisKeyConstant.API_DATA + "handpick:" + page;

        String data = (String) redisTemplate.opsForValue().get(redisKey);
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiHandpick apiHandpick = new ApiHandpick();
            apiHandpick.setApikey(hdkConfig.getAppkey());
            apiHandpick.setMin_id(page);

            try {
                String execute = HdkApiVisit.execute(apiHandpick);

                redisTemplate.opsForValue().set(redisKey,execute,1,
                        TimeUnit.HOURS);

                return execute;
            } catch (Exception e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }

        return data;
    }

    @Override
    public String news(Integer page) {

        String redisKey = RedisKeyConstant.API_DATA + "news:" + page;

        String data = (String) redisTemplate.opsForValue().get(redisKey);
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiNews apiNews = new ApiNews();
            apiNews.setApikey(hdkConfig.getAppkey());
            apiNews.setMin_id(page);

            try {
                String execute = HdkApiVisit.execute(apiNews);

                redisTemplate.opsForValue().set(redisKey,execute,1,
                        TimeUnit.HOURS);

                return execute;
            } catch (Exception e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }

        return data;
    }

    @Override
    public String themeList() {

        String redisKey = RedisKeyConstant.API_DATA + "themeList";

        String data = (String) redisTemplate.opsForValue().get(redisKey);
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiThemeList apiThemeList = new ApiThemeList();
            apiThemeList.setApikey(hdkConfig.getAppkey());

            try {
                String execute = HdkApiVisit.execute(apiThemeList);

                redisTemplate.opsForValue().set(redisKey,execute,1,
                        TimeUnit.HOURS);

                return execute;
            } catch (Exception e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }

        return data;
    }

    @Override
    public String theme(Integer themeId) {

        String redisKey = RedisKeyConstant.API_DATA + "theme:" + themeId;

        String data = (String) redisTemplate.opsForValue().get(redisKey);
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiTheme apiTheme = new ApiTheme();
            apiTheme.setApikey(hdkConfig.getAppkey());
            apiTheme.setId(themeId);

            try {
                String execute = HdkApiVisit.execute(apiTheme);

                redisTemplate.opsForValue().set(redisKey,execute,1,
                        TimeUnit.HOURS);

                return execute;
            } catch (Exception e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }

        return data;
    }

}
