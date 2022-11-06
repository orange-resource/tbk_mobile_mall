package com.orange.tbk.api.vo.open;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class CarouselVo implements Serializable {

    /**
     * 点击跳转地址
     * click_url
     */
    private String clickUrl;

    /**
     * 轮播主图
     * image
     */
    private String image;

}
