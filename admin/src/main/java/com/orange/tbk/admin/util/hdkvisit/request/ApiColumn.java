package com.orange.tbk.admin.util.hdkvisit.request;

import com.orange.tbk.admin.util.hdkvisit.base.BaseInterface;
import com.orange.tbk.admin.util.hdkvisit.base.BaseRequest;
import com.orange.tbk.admin.util.hdkvisit.type.HttpRequestMethod;

/**
 * 商品筛选 ... 获取9.9包邮,聚划算,淘抢购等等商品...
 * @author Orange软件
 * @date 2019.3.14
 */
public class ApiColumn extends BaseRequest implements BaseInterface {

    //商品筛选类型
    private Integer type;

    //返回数据数量
    private Integer back = 20;

    //分页
    private Integer min_id;

    //综合 月销量 tag...
    private Integer sort;

    //类目
    private Integer cid;

    @Override
    public String getApiUrl() {
        return "http://v2.api.haodanku.com/column";
    }

    @Override
    public String getRequestMethod() {
        return HttpRequestMethod.GET;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMin_id() {
        return min_id;
    }

    public void setMin_id(Integer min_id) {
        this.min_id = min_id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
