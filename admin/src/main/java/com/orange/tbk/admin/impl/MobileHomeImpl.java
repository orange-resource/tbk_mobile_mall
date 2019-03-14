package com.orange.tbk.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.orange.tbk.admin.mapper.HdkConfigMapper;
import com.orange.tbk.admin.util.hdkvisit.HdkApiVisit;
import com.orange.tbk.admin.util.hdkvisit.request.ApiBrand;
import com.orange.tbk.admin.util.hdkvisit.request.ApiColumn;
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

        String redisKey = RedisKeyConstant.API_DATA + "deserver";

        String data = (String) redisTemplate.opsForValue().get(redisKey);
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiDeserver apiDeserver = new ApiDeserver();
            apiDeserver.setApikey(hdkConfig.getAppkey());

            try {
                String execute = HdkApiVisit.execute(apiDeserver);

                redisTemplate.opsForValue().set(redisKey,execute,1,
                        TimeUnit.HOURS);

                return execute;
            } catch (Exception e) {
                return e.getMessage();
            }
        }

        return data;
    }

    @Override
    public String brand(Integer page,Integer tag) {

        String redisKey = RedisKeyConstant.API_DATA + "brand:" + page + "-" + tag;

        String data = (String) redisTemplate.opsForValue().get(redisKey);
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiBrand apiBrand = new ApiBrand();
            apiBrand.setApikey(hdkConfig.getAppkey());
            apiBrand.setMin_id(page);
            apiBrand.setBrandcat(tag);

            try {
                String execute = HdkApiVisit.execute(apiBrand);

                redisTemplate.opsForValue().set(redisKey,execute,1,
                        TimeUnit.HOURS);

                return execute;
            } catch (Exception e) {
                return e.getMessage();
            }
        }

        return data;
    }

    @Override
    public String district(Integer page, Integer tag, Integer type, Integer category) {

        String redisKey = RedisKeyConstant.API_DATA + "district:" + page + "-" + tag + "-" + type + "-" + category;

        String data = (String) redisTemplate.opsForValue().get(redisKey);
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiColumn apiColumn = new ApiColumn();
            apiColumn.setApikey(hdkConfig.getAppkey());
            apiColumn.setCid(category);
            apiColumn.setMin_id(page);
            apiColumn.setType(type);
            apiColumn.setSort(tag);

            try {
                String execute = HdkApiVisit.execute(apiColumn);

                redisTemplate.opsForValue().set(redisKey,execute,1,
                        TimeUnit.HOURS);

                return execute;
            } catch (Exception e) {
                return e.getMessage();
            }
        }

        return data;
    }

}
