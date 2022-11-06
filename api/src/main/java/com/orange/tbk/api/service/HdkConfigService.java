package com.orange.tbk.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.tbk.api.bean.HdkConfig;

public interface HdkConfigService extends IService<HdkConfig> {

    void create(HdkConfig hdkConfig);

}
