package com.orange.tbk.admin.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.tbk.admin.mapper.SystemMessageMapper;
import com.orange.tbk.api.bean.SystemMessage;
import com.orange.tbk.api.service.SystemMessageService;
import com.orange.tbk.api.vo.open.SystemMessageVo;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "${version}")
public class SystemMessageImpl extends ServiceImpl<SystemMessageMapper, SystemMessage> implements SystemMessageService {

    @Override
    public Page<SystemMessage> page(SystemMessage systemMessage,Page page) {

        return page.setRecords(super.baseMapper.page(systemMessage,page));
    }

    @Override
    public List<SystemMessageVo> getList() {

        return super.baseMapper.getList();
    }

    @Override
    public SystemMessageVo article(String articleId) {

        return super.baseMapper.article(articleId);
    }
}
