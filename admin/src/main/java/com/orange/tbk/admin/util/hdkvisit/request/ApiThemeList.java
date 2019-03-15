package com.orange.tbk.admin.util.hdkvisit.request;

import com.orange.tbk.admin.util.hdkvisit.base.BaseInterface;
import com.orange.tbk.admin.util.hdkvisit.base.BaseRequest;
import com.orange.tbk.admin.util.hdkvisit.type.HttpRequestMethod;

/**
 * 获取精选主题list
 * @author Orange软件
 * @date 2019.3.15
 */
public class ApiThemeList extends BaseRequest implements BaseInterface {
    @Override
    public String getApiUrl() {
        return "http://v2.api.haodanku.com/get_subject";
    }

    @Override
    public String getRequestMethod() {
        return HttpRequestMethod.GET;
    }
}
