package com.orange.tbk.admin.util.hdkvisit.request;

import com.orange.tbk.admin.util.hdkvisit.base.BaseInterface;
import com.orange.tbk.admin.util.hdkvisit.base.BaseRequest;
import com.orange.tbk.admin.util.hdkvisit.type.HttpRequestMethod;

/**
 * 获取好货专场
 * @author Orange软件
 * @date 2019.3.15
 */
public class ApiNews extends BaseRequest implements BaseInterface {
    
    /**
     * 分页
     */
    private Integer min_id;
    
    @Override
    public String getApiUrl() {
        return "http://v2.api.haodanku.com/subject_hot";
    }

    @Override
    public String getRequestMethod() {
        return HttpRequestMethod.GET;
    }

    public Integer getMin_id() {
        return min_id;
    }

    public void setMin_id(Integer min_id) {
        this.min_id = min_id;
    }
}
