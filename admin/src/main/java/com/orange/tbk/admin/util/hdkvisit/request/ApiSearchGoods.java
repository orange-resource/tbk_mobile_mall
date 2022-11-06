package com.orange.tbk.admin.util.hdkvisit.request;

import com.orange.tbk.admin.util.hdkvisit.base.BaseInterface;
import com.orange.tbk.admin.util.hdkvisit.base.BaseRequest;
import com.orange.tbk.admin.util.hdkvisit.type.HttpRequestMethod;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 商品搜索
 * @author Orange软件
 * @date 2019.3.15
 */
public class ApiSearchGoods extends BaseRequest implements BaseInterface {

    //搜索词
    private String keyword;

    //page
    private Integer min_id;

    //返回条数
    private Integer back = 20;

    //淘宝分页
    private Integer tb_p;

    //是否只取有券商品：0否；1是，默认是0
    private Integer is_coupon = 1;

    private Integer sort;

    @Override
    public String getApiUrl() {
        return "http://v2.api.haodanku.com/supersearch";
    }

    @Override
    public String getRequestMethod() {
        return HttpRequestMethod.GET;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {

        try {
            String encode = URLEncoder.encode(keyword, "UTF-8");
            encode = URLEncoder.encode(encode, "UTF-8");
            this.keyword = encode;
        } catch (UnsupportedEncodingException e) {
            this.keyword = "";
        }
    }

    public Integer getMin_id() {
        return min_id;
    }

    public void setMin_id(Integer min_id) {
        this.min_id = min_id;
        this.tb_p = min_id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
