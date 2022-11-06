package com.orange.tbk.admin.impl;

import com.orange.tbk.api.bean.InterfaceManagement;
import com.orange.tbk.api.redis.RedisKeyConstant;
import com.orange.tbk.api.service.InterfaceManagementService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service(version = "${version}")
public class InterfaceManagementImpl implements InterfaceManagementService {

    @Autowired
    private RedisTemplate<String,Object> template;

    @Override
    public List<InterfaceManagement> getAll() throws Exception {

        List<InterfaceManagement> interfaceManagements = new ArrayList<>();

        Set<String> keys = template.keys(RedisKeyConstant.OPEN_INTERFACE + "*");
        for (String key : keys) {

            InterfaceManagement interfaceManagement = (InterfaceManagement) template.opsForValue().get(key);
            interfaceManagements.add(interfaceManagement);
        }

        return interfaceManagements;
    }

    @Override
    public void closeInterface(String key,Integer on) throws Exception {

        InterfaceManagement interfaceManagementRedis = (InterfaceManagement) template.opsForValue().get(key);

        interfaceManagementRedis.setVisit(on);

        template.opsForValue().set(key,interfaceManagementRedis);
    }

    @Override
    public InterfaceManagement getSingle(String key) throws Exception {

        return (InterfaceManagement) template.opsForValue().get(key);
    }

    @Override
    public void update(InterfaceManagement interfaceManagement) throws Exception {

        InterfaceManagement interfaceManagementRedis = (InterfaceManagement) template.opsForValue().get(interfaceManagement.getKey());

        interfaceManagementRedis.setIpVisits(interfaceManagement.getIpVisits());
        interfaceManagementRedis.setIpRedisInterval(interfaceManagement.getIpRedisInterval());

        template.opsForValue().set(interfaceManagement.getKey(),interfaceManagementRedis);
    }

    @Override
    public void ipHandle(String key,Integer on) throws Exception {

        InterfaceManagement interfaceManagementRedis = (InterfaceManagement) template.opsForValue().get(key);

        interfaceManagementRedis.setIpHandle(on);

        template.opsForValue().set(key,interfaceManagementRedis);
    }

}
