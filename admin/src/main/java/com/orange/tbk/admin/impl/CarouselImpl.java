package com.orange.tbk.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.tbk.admin.mapper.CarouselMapper;
import com.orange.tbk.api.bean.Carousel;
import com.orange.tbk.api.service.CarouselService;
import com.orange.tbk.api.vo.open.CarouselVo;

import java.util.List;

@Service
public class CarouselImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {

    @Override
    public List<Carousel> getListByCreateDate() {

        return super.baseMapper.getListByCreateDate();
    }

    @Override
    public List<CarouselVo> getListBySort() {
        return null;
    }

}
