package com.orange.tbk.api.service;

public interface MobileGoodsService {

    String getDetails(String goodsId);

    String rates(String goodsId);

    String like(String goodsId);

}
