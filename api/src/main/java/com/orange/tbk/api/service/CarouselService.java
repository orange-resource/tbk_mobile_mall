package com.orange.tbk.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.tbk.api.bean.Carousel;
import com.orange.tbk.api.vo.open.CarouselVo;

import java.util.List;

public interface CarouselService extends IService<Carousel> {

    List<Carousel> getListByCreateDate();

    List<CarouselVo> getListBySort();

}
