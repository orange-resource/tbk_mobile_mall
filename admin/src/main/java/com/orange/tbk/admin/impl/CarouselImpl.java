package com.orange.tbk.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.tbk.admin.mapper.CarouselMapper;
import com.orange.tbk.api.bean.Carousel;
import com.orange.tbk.api.redis.RedisKeyConstant;
import com.orange.tbk.api.service.CarouselService;
import com.orange.tbk.api.vo.open.CarouselVo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

@Service(version = "${version}")
public class CarouselImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public List<Carousel> getListByCreateDate() {

        return super.baseMapper.getListByCreateDate();
    }

    @Override
    public List<CarouselVo> getListBySort() {

        String redisKey = RedisKeyConstant.CAROUSEL_IMPL + "List<Carousel>";

        List<CarouselVo> carouselVoList = (List) redisTemplate.opsForValue().get(redisKey);
        if (carouselVoList == null) {

            List<CarouselVo> listBySort = super.baseMapper.getListBySort();
            if (listBySort == null) {
                return new ArrayList<>();
            }
            redisTemplate.opsForValue().set(redisKey,listBySort);

            return listBySort;
        }

        return carouselVoList;
    }

    @Override
    public void create(Carousel carousel) {

        String redisKey = RedisKeyConstant.CAROUSEL_IMPL + "List<Carousel>";

        redisTemplate.delete(redisKey);

        super.baseMapper.insert(carousel);
    }

    @Override
    public void alter(Carousel carousel) {

        String redisKey = RedisKeyConstant.CAROUSEL_IMPL + "List<Carousel>";

        redisTemplate.delete(redisKey);

        super.baseMapper.updateById(carousel);
    }

    @Override
    public void delete(String carouselId) {

        String redisKey = RedisKeyConstant.CAROUSEL_IMPL + "List<Carousel>";

        redisTemplate.delete(redisKey);

        super.baseMapper.deleteById(carouselId);
    }

}
