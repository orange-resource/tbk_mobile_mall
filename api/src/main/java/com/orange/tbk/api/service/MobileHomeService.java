package com.orange.tbk.api.service;

public interface MobileHomeService {

    String deserver();

    String brand(Integer page,Integer tag);

    String district(Integer page,Integer tag,Integer type,Integer category);

    String talent();

    String talentArticle(String articleId);

    String hot(Integer category);

}
