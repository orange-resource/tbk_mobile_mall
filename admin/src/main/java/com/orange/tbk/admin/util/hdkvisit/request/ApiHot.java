package com.orange.tbk.admin.util.hdkvisit.request;

import com.orange.tbk.admin.util.hdkvisit.base.BaseInterface;
import com.orange.tbk.admin.util.hdkvisit.base.BaseRequest;
import com.orange.tbk.admin.util.hdkvisit.type.HttpRequestMethod;

/**
 * 热销榜单
 * @author orange软件
 * @date 2019.3.15
 */
public class ApiHot extends BaseRequest implements BaseInterface {

    //商品类目
    private Integer cid;

    //榜单类型 sale_type=1是实时销量榜（近2小时销量），type=2是今日爆单榜，type=3是昨日爆单榜，type=4是出单指数版
    private Integer sale_type = 2;

    @Override
    public String getApiUrl() {
        return "http://v2.api.haodanku.com/sales_list";
    }

    @Override
    public String getRequestMethod() {
        return HttpRequestMethod.GET;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
