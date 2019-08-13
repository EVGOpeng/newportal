package com.calabar.portal.bean.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 新增公文模块通用类,根据这个建表新增开发
 */
@Getter
@Setter
@ToString
public class CommonDocument implements Serializable {
    /**
     * 数据库表名
     */
    private String tableName;
    private String uuid;
    /**
     * id
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 没有使用
     */
    private String pic;
    /**
     * 没有使用
     */
    private String smpic;
    /**
     * 所属资源模块id
     */
    private Integer resId;
    /**
     * 所属资源模块下的值类型类型iD
     */
    private Integer type;
    /**
     *简介没有使用
     */
    private String smcontent;
    /**
     *是否头条
     */
    private Integer isheadlines;
    /**
     * 发布人
     */
    private Long userid;
    /**
     * 发布人姓名
     */
    private String userName;
    //是否推送
    /**
     * 是否推送
     */
    private Integer isPush;
    /**
     * 是否发布
     */
    private Integer ispublish;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     *更新时间
     */
    private Date lastUpdateTime;
    /**
     *来源没有使用
     */
    private String source;
    /**
     * 访问量
     */
    private Integer views;
    /**
     * 排序没有使用
     */
    private String sort;
    /**
     * 关键字没有使用
     */
    private String keyWords;
    /**
     * 副标题
     */
    private String subTitle;
    /**
     * 样式id
     */
    private Integer styleId;//所属报纸样式
    /**
     * 站点id（公司id）
     */
    private Long siteId;
    /**
     * 版面,未使用
     */
    private Integer newspapers;
}
