package com.orange.tbk.api.service;

public interface MobileSearchService {

    String keyword();

    String goods(String keyword,Integer tag,Integer page);

}
