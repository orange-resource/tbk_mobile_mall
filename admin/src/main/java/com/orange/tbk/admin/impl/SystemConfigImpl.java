package com.orange.tbk.admin.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orange.tbk.admin.mapper.SystemConfigMapper;
import com.orange.tbk.api.bean.SystemConfig;
import com.orange.tbk.api.redis.RedisKeyConstant;
import com.orange.tbk.api.service.SystemConfigService;
import com.orange.tbk.api.vo.open.SystemConfigVo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

@Service(version = "${version}")
public class SystemConfigImpl extends ServiceImpl<SystemConfigMapper, SystemConfig> implements SystemConfigService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public void create(SystemConfig systemConfig) {

        Integer count = super.baseMapper.selectCount(null);
        if (count > 0) { //保存

            String redisKey = RedisKeyConstant.SYSTEMCONFIG_IMPL + "SystemConfig";

            redisTemplate.delete(redisKey);

            super.baseMapper.updateById(systemConfig);
        } else { //创建
            super.baseMapper.insert(systemConfig);
        }
    }

    @Override
    public SystemConfigVo getSystemConfigVo() {

        String redisKey = RedisKeyConstant.SYSTEMCONFIG_IMPL + "SystemConfig";

        SystemConfigVo systemConfigVo = (SystemConfigVo) redisTemplate.opsForValue().get(redisKey);
        if (systemConfigVo == null) {

            systemConfigVo = super.baseMapper.getSystemConfigVo();
            if (systemConfigVo == null) {
                return null;
            }
            redisTemplate.opsForValue().set(redisKey,systemConfigVo);
        }

        return systemConfigVo;
    }

}
