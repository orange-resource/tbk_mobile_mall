package com.orange.tbk.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.tbk.api.bean.User;

public interface UserService extends IService<User> {

    int verifyUser(String username, String password);

}
