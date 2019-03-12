package com.orange.tbk.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.tbk.admin.mapper.AliyunOssMapper;
import com.orange.tbk.api.bean.AliyunOss;
import com.orange.tbk.api.service.AliyunOssService;

@Service
public class AliyunOssImpl extends ServiceImpl<AliyunOssMapper, AliyunOss> implements AliyunOssService {

    @Override
    public void create(AliyunOss aliyunOss) {

        Integer count = super.baseMapper.selectCount(null);
        if (count > 0) { //保存
            super.baseMapper.updateById(aliyunOss);
        } else { //创建
            super.baseMapper.insert(aliyunOss);
        }
    }
}
