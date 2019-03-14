package com.orange.tbk.admin.util.hdkvisit.request;

import com.orange.tbk.admin.util.hdkvisit.base.BaseInterface;
import com.orange.tbk.admin.util.hdkvisit.base.BaseRequest;
import com.orange.tbk.admin.util.hdkvisit.type.HttpRequestMethod;

/**
 * 今日值得买
 * @author Orange软件
 * @date 2019.3.14
 */
public class ApiDeserver extends BaseRequest implements BaseInterface {

    @Override
    public String getApiUrl() {
        return "http://v2.api.haodanku.com/get_deserve_item";
    }

    @Override
    public String getRequestMethod() {
        return HttpRequestMethod.GET;
    }

}
