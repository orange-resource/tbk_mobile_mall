package com.orange.tbk.admin.util.hdkvisit.request;

import com.orange.tbk.admin.util.hdkvisit.base.BaseInterface;
import com.orange.tbk.admin.util.hdkvisit.base.BaseRequest;
import com.orange.tbk.admin.util.hdkvisit.type.HttpRequestMethod;

/**
 * 获取精选主题 item 项...
 * @author Orange软件
 * @date 2019.3.15
 */
public class ApiTheme extends BaseRequest implements BaseInterface {

    /**
     * 主题id
     */
    private Integer id;

    @Override
    public String getApiUrl() {
        return "http://v2.api.haodanku.com/get_subject_item";
    }

    @Override
    public String getRequestMethod() {
        return HttpRequestMethod.GET;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
