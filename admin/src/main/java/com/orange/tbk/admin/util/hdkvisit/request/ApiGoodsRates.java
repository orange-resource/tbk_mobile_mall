package com.orange.tbk.admin.util.hdkvisit.request;

import com.orange.tbk.admin.util.hdkvisit.base.BaseInterface;
import com.orange.tbk.admin.util.hdkvisit.base.BaseRequest;
import com.orange.tbk.admin.util.hdkvisit.type.HttpRequestMethod;

public class ApiGoodsRates extends BaseRequest implements BaseInterface {

    //宝贝id
    private String itemid;

    //推广位pid
    private String pid;

    //淘宝账号名称
    private String tb_name;

    @Override
    public String getApiUrl() {
        return "http://v2.api.haodanku.com/ratesurl";
    }

    @Override
    public String getRequestMethod() {
        return HttpRequestMethod.POST;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTb_name() {
        return tb_name;
    }

    public void setTb_name(String tb_name) {
        this.tb_name = tb_name;
    }
}
