package com.orange.tbk.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.tbk.admin.mapper.CarouselMapper;
import com.orange.tbk.api.bean.Carousel;
import com.orange.tbk.api.service.CarouselService;

@Service
public class CarouselImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {
}
