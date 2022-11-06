package com.orange.tbk.admin.util.hdkvisit.request;

import com.orange.tbk.admin.util.hdkvisit.base.BaseInterface;
import com.orange.tbk.admin.util.hdkvisit.base.BaseRequest;
import com.orange.tbk.admin.util.hdkvisit.type.HttpRequestMethod;

/**
 * 商品详情
 * @author Orange软件
 * @date 2019.3.14
 */
public class ApiGoodsDetails extends BaseRequest implements BaseInterface {

    //宝贝id
    private String itemid;

    @Override
    public String getApiUrl() {
        return "http://v2.api.haodanku.com/item_detail";
    }

    @Override
    public String getRequestMethod() {
        return HttpRequestMethod.GET;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }
}
