package com.orange.tbk.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.tbk.admin.mapper.SystemConfigMapper;
import com.orange.tbk.api.bean.SystemConfig;
import com.orange.tbk.api.service.SystemConfigService;

@Service
public class SystemConfigImpl extends ServiceImpl<SystemConfigMapper, SystemConfig> implements SystemConfigService {

    @Override
    public void create(SystemConfig systemConfig) {

        Integer count = super.baseMapper.selectCount(null);
        if (count > 0) { //保存
            super.baseMapper.updateById(systemConfig);
        } else { //创建
            super.baseMapper.insert(systemConfig);
        }
    }

}
