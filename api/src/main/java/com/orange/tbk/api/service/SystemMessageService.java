package com.orange.tbk.api.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.tbk.api.bean.SystemMessage;
import com.orange.tbk.api.vo.open.SystemMessageVo;

import java.util.List;

public interface SystemMessageService extends IService<SystemMessage> {

    Page<SystemMessage> page(SystemMessage systemMessage,Page page);

    List<SystemMessageVo> getList();

    SystemMessageVo article(String articleId);

}
