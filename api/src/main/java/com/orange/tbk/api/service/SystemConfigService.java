package com.orange.tbk.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.tbk.api.bean.SystemConfig;

public interface SystemConfigService extends IService<SystemConfig> {

    void create(SystemConfig systemConfig);

}
