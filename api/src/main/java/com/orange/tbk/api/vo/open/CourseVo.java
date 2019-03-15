package com.orange.tbk.api.vo.open;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class CourseVo implements Serializable {

    private String id;

    private Long createDate;

    /**
     * 新手教程标题
     * title
     */
    private String title;

    /**
     * 作者
     * author
     */
    private String author;

    /**
     * 教程内容
     * content
     */
    private String content;

    /**
     * 主图地址
     * image
     */
    private String image;

}
