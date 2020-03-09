package com.orange.tbk.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.orange.tbk.api.bean.User;

public interface UserService extends IService<User> {

    String verifyUser(String username, String password);

    void logout(String token);

}
