package com.orange.tbk.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.orange.tbk.admin.mapper.HdkConfigMapper;
import com.orange.tbk.admin.util.hdkvisit.HdkApiVisit;
import com.orange.tbk.admin.util.hdkvisit.request.ApiGoodsLike;
import com.orange.tbk.admin.util.hdkvisit.request.ApiKeyword;
import com.orange.tbk.admin.util.hdkvisit.request.ApiSearchGoods;
import com.orange.tbk.api.bean.HdkConfig;
import com.orange.tbk.api.redis.RedisKeyConstant;
import com.orange.tbk.api.service.MobileSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class MobileSearchImpl implements MobileSearchService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private HdkConfigMapper hdkConfigMapper;

    @Override
    public String keyword() {

        String redisKey = RedisKeyConstant.API_DATA + "keyword";

        String data = (String) redisTemplate.opsForValue().get(redisKey);
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiKeyword apiKeyword = new ApiKeyword();
            apiKeyword.setApikey(hdkConfig.getAppkey());

            try {
                String execute = HdkApiVisit.execute(apiKeyword);

                redisTemplate.opsForValue().set(redisKey,execute,1,
                        TimeUnit.DAYS);

                return execute;
            } catch (Exception e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }

        return data;
    }

    @Override
    public String goods(String keyword, Integer tag, Integer page) {

        String redisKey = RedisKeyConstant.API_DATA + "goods:" + keyword + "-" + tag + "-" + page;

        String data = (String) redisTemplate.opsForValue().get(redisKey);
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiSearchGoods apiSearchGoods = new ApiSearchGoods();
            apiSearchGoods.setApikey(hdkConfig.getAppkey());
            apiSearchGoods.setSort(tag);
            apiSearchGoods.setMin_id(page);
            apiSearchGoods.setKeyword(keyword);

            try {
                String execute = HdkApiVisit.execute(apiSearchGoods);

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
