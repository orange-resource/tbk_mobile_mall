package com.orange.tbk.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.orange.tbk.admin.mapper.HdkConfigMapper;
import com.orange.tbk.admin.util.hdkvisit.HdkApiVisit;
import com.orange.tbk.admin.util.hdkvisit.request.ApiGoodsDetails;
import com.orange.tbk.admin.util.hdkvisit.request.ApiGoodsLike;
import com.orange.tbk.admin.util.hdkvisit.request.ApiGoodsRates;
import com.orange.tbk.api.bean.HdkConfig;
import com.orange.tbk.api.redis.RedisKeyConstant;
import com.orange.tbk.api.service.MobileGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class MobileGoodsImpl implements MobileGoodsService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private HdkConfigMapper hdkConfigMapper;

    @Override
    public String getDetails(String goodsId) {

        String redisKey = RedisKeyConstant.API_DATA + "goods-details:" + goodsId;

        String data = (String) redisTemplate.opsForValue().get(redisKey);
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiGoodsDetails apiGoodsDetails = new ApiGoodsDetails();
            apiGoodsDetails.setApikey(hdkConfig.getAppkey());
            apiGoodsDetails.setItemid(goodsId);

            try {
                String execute = HdkApiVisit.execute(apiGoodsDetails);

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
    public String rates(String goodsId) {

        String redisKey = RedisKeyConstant.API_DATA + "goods-rates:" + goodsId;

        String data = (String) redisTemplate.opsForValue().get(redisKey);
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiGoodsRates apiGoodsRates = new ApiGoodsRates();
            apiGoodsRates.setApikey(hdkConfig.getAppkey());
            apiGoodsRates.setItemid(goodsId);
            apiGoodsRates.setPid(hdkConfig.getPid());
            apiGoodsRates.setTb_name(hdkConfig.getTbName());

            try {
                String execute = HdkApiVisit.execute(apiGoodsRates);

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
    public String like(String goodsId) {

        String redisKey = RedisKeyConstant.API_DATA + "goods-like:" + goodsId;

        String data = (String) redisTemplate.opsForValue().get(redisKey);
        if (data == null || data.equals("")) {

            HdkConfig hdkConfig = hdkConfigMapper.selectList(null).get(0);

            ApiGoodsLike apiGoodsLike = new ApiGoodsLike();
            apiGoodsLike.setApikey(hdkConfig.getAppkey());
            apiGoodsLike.setItemid(goodsId);

            try {
                String execute = HdkApiVisit.execute(apiGoodsLike);

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

}
