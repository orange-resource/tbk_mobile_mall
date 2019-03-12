package com.orange.tbk.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.tbk.admin.mapper.HdkConfigMapper;
import com.orange.tbk.api.bean.HdkConfig;
import com.orange.tbk.api.service.HdkConfigService;

@Service
public class HdkConfigImpl extends ServiceImpl<HdkConfigMapper, HdkConfig> implements HdkConfigService {

    @Override
    public void create(HdkConfig hdkConfig) {

        Integer count = super.baseMapper.selectCount(null);
        if (count > 0) { //保存
            super.baseMapper.updateById(hdkConfig);
        } else { //创建
            super.baseMapper.insert(hdkConfig);
        }
    }
}
