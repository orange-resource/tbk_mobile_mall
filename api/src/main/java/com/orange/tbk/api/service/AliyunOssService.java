package com.orange.tbk.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.tbk.api.bean.AliyunOss;

public interface AliyunOssService extends IService<AliyunOss> {

    void create(AliyunOss aliyunOss);

    AliyunOss single();

}
