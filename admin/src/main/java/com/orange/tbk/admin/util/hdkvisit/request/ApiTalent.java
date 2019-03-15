package com.orange.tbk.admin.util.hdkvisit.request;

import com.orange.tbk.admin.util.hdkvisit.base.BaseInterface;
import com.orange.tbk.admin.util.hdkvisit.base.BaseRequest;
import com.orange.tbk.admin.util.hdkvisit.type.HttpRequestMethod;

/**
 * 达人说列表
 * @author Orange软件
 * @date 2019.3.15
 */
public class ApiTalent extends BaseRequest implements BaseInterface {

    //文章类别
    private Integer talentcat = 0;

    @Override
    public String getApiUrl() {
        return "http://v2.api.haodanku.com/talent_info";
    }

    @Override
    public String getRequestMethod() {
        return HttpRequestMethod.GET;
    }

}
