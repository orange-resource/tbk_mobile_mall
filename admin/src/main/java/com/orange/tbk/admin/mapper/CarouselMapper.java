package com.orange.tbk.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.orange.tbk.api.bean.Carousel;
import com.orange.tbk.api.vo.open.CarouselVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CarouselMapper extends BaseMapper<Carousel> {

    @Select("select * from t_carousel order by create_date desc")
    List<Carousel> getListByCreateDate();

    @Select("select image,click_url from t_carousel order by sort asc")
    List<CarouselVo> getListBySort();

}