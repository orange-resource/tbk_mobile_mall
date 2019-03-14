package com.orange.tbk.admin.util.hdkvisit.request;

import com.orange.tbk.admin.util.hdkvisit.base.BaseInterface;
import com.orange.tbk.admin.util.hdkvisit.base.BaseRequest;
import com.orange.tbk.admin.util.hdkvisit.type.HttpRequestMethod;

public class ApiBrand extends BaseRequest implements BaseInterface {

    //页数
    private Integer min_id;

    //品牌分类
    private Integer brandcat;

    //返回数据数量
    private Integer back = 20;

    @Override
    public String getApiUrl() {
        return "http://v2.api.haodanku.com/brand";
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

    public Integer getBrandcat() {
        return brandcat;
    }

    public void setBrandcat(Integer brandcat) {
        this.brandcat = brandcat;
    }
}
