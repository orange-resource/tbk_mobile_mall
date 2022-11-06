package com.orange.tbk.api.service;

import com.orange.tbk.api.bean.InterfaceManagement;

import java.util.List;

public interface InterfaceManagementService {

    List<InterfaceManagement> getAll() throws Exception;

    void closeInterface(String key, Integer on) throws Exception;

    InterfaceManagement getSingle(String key) throws Exception;

    void update(InterfaceManagement interfaceManagement) throws Exception;

    void ipHandle(String key, Integer on) throws Exception;

}
