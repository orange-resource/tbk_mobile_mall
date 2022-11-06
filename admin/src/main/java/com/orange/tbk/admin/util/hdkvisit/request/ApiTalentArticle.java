package com.orange.tbk.admin.util.hdkvisit.request;

import com.orange.tbk.admin.util.hdkvisit.base.BaseInterface;
import com.orange.tbk.admin.util.hdkvisit.base.BaseRequest;
import com.orange.tbk.admin.util.hdkvisit.type.HttpRequestMethod;

/**
 * 获取达人说文章
 * @author Orange软件
 * @date 2019.3.15
 */
public class ApiTalentArticle extends BaseRequest implements BaseInterface {

    /**
     * 文章id
     */
    private String id;

    @Override
    public String getApiUrl() {
        return "http://v2.api.haodanku.com/talent_article";
    }

    @Override
    public String getRequestMethod() {
        return HttpRequestMethod.GET;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
