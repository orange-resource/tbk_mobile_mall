package com.orange.tbk.api.vo.open;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class SystemMessageVo implements Serializable {

    private String id;

    private Long createDate;

    /**
     * 消息标题
     * title
     */
    private String title;

    /**
     * 作者
     * author
     */
    private String author;

    /**
     * 消息内容
     * content
     */
    private String content;

    /**
     * 消息主图
     * image
     */
    private String image;

}
