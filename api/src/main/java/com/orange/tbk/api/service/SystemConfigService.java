package com.orange.tbk.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.tbk.api.bean.SystemConfig;
import com.orange.tbk.api.vo.open.SystemConfigVo;

public interface SystemConfigService extends IService<SystemConfig> {

    void create(SystemConfig systemConfig);

    SystemConfigVo getSystemConfigVo();

}
