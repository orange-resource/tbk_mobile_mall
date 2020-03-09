package com.orange.tbk.admin.impl;

import com.orange.tbk.admin.mapper.HdkConfigMapper;
import com.orange.tbk.admin.util.hdkvisit.HdkApiVisit;
import com.orange.tbk.admin.util.hdkvisit.request.*;
import com.orange.tbk.api.bean.HdkConfig;
import com.orange.tbk.api.redis.RedisKeyConstant;
import com.orange.tbk.api.service.MobileHomeService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Service(version = "${version}")
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
                e.printStackTrace();
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
                e.printStackTrace();
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
                e.printStackTrace();
                return e.getMessage();
            }
        }

        return data;
    }

    @Override
    public String talent() {

        String redisKey = RedisKeyConstant.API_DATA + "talent";

        String data = (String) redisTemplate.opsForValue().get(redisKey);
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiTalent apiTalent = new ApiTalent();
            apiTalent.setApikey(hdkConfig.getAppkey());

            try {
                String execute = HdkApiVisit.execute(apiTalent);

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
    public String talentArticle(String articleId) {

        String redisKey = RedisKeyConstant.API_DATA + "talent-article:" + articleId;

        String data = (String) redisTemplate.opsForValue().get(redisKey);
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiTalentArticle apiTalentArticle = new ApiTalentArticle();
            apiTalentArticle.setApikey(hdkConfig.getAppkey());
            apiTalentArticle.setId(articleId);

            try {
                String execute = HdkApiVisit.execute(apiTalentArticle);

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
    public String hot(Integer category) {

        String redisKey = RedisKeyConstant.API_DATA + "hot:" + category;

        String data = (String) redisTemplate.opsForValue().get(redisKey);
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiHot apiHot = new ApiHot();
            apiHot.setApikey(hdkConfig.getAppkey());
            apiHot.setCid(category);

            try {
                String execute = HdkApiVisit.execute(apiHot);

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
