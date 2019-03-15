package com.orange.tbk.api.vo.open;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class SystemConfigVo implements Serializable {

    /**
     * 联系方式
     * contact
     */
    private String contact;

    /**
     * 关于我们
     * about
     */
    private String about;

    /**
     * 网站底部
     * footer
     */
    private String footer;

}
