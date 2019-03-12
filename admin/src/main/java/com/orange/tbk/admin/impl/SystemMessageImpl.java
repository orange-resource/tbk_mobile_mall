package com.orange.tbk.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.tbk.admin.mapper.SystemMessageMapper;
import com.orange.tbk.api.bean.SystemMessage;
import com.orange.tbk.api.service.SystemMessageService;

@Service
public class SystemMessageImpl extends ServiceImpl<SystemMessageMapper, SystemMessage> implements SystemMessageService {

    @Override
    public Page<SystemMessage> page(SystemMessage systemMessage,Page page) {

        return page.setRecords(super.baseMapper.page(systemMessage,page));
    }
}
