package com.orange.tbk.api.bean;

import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;

/**
 * 首页轮播模块
 * t_carousel
 * @author Orange
 * @date 2020/03/09
 */
@TableName("t_carousel")
@KeySequence("SEQ_TEST")
public class Carousel implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @TableField(value = "create_date",fill = FieldFill.INSERT)
    private Long createDate;

    @TableLogic
    private Integer delFlag;

    private String remarks;

    @TableField(value = "update_date",fill = FieldFill.UPDATE)
    private Long updateDate;

    /**
     * 点击跳转地址
     * click_url
     */
    private String clickUrl;

    /**
     * 排序
     * sort
     */
    private Long sort;

    /**
     * 轮播主图
     * image
     */
    private String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl == null ? null : clickUrl.trim();
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}