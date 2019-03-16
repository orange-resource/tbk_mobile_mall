package com.orange.tbk.admin.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.tbk.admin.mapper.AliyunOssMapper;
import com.orange.tbk.api.bean.AliyunOss;
import com.orange.tbk.api.redis.RedisKeyConstant;
import com.orange.tbk.api.service.AliyunOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@Service
public class AliyunOssImpl extends ServiceImpl<AliyunOssMapper, AliyunOss> implements AliyunOssService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public void create(AliyunOss aliyunOss) {

        Integer count = super.baseMapper.selectCount(null);
        if (count > 0) { //保存

            //删除数据
            redisTemplate.delete(RedisKeyConstant.ALIYUNOSS_IMPL + "AliyunOss.class");

            super.baseMapper.updateById(aliyunOss);

        } else { //创建

            super.baseMapper.insert(aliyunOss);
        }

    }

    @Override
    public AliyunOss single() {

        //首先从缓存中读取
        AliyunOss aliyunOss = (AliyunOss) redisTemplate.opsForValue().get(RedisKeyConstant.ALIYUNOSS_IMPL + "AliyunOss.class");
        if (aliyunOss == null) {

            //数据为空到 mysql 中进行读取
            List<AliyunOss> aliyunOsses = super.baseMapper.selectList(null);
            if (aliyunOsses == null || aliyunOsses.size() == 0) {
                return null;
            }
            aliyunOss = aliyunOsses.get(0);

            //进行数据缓存
            redisTemplate.opsForValue().set(RedisKeyConstant.ALIYUNOSS_IMPL + "AliyunOss.class",aliyunOss);
        }

        return aliyunOss;
    }
}
