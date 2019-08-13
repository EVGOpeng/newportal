package com.calabar.portal.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 模块和菜单以及资源类
 */
@Getter
@Setter
@ToString
public class Resources implements Serializable {
    private Long id;
    /**
     *展示页面栏目名称
     */
    private String name;
     /**
     * *后台发布分类名称
     */
    private String typeName;
    /**
     *站点id
     */
    private Long siteId;
    /**
     *父栏目id
     */
    private Long parentId;
    /**
     *菜单栏目id，可以为空
     */
    private Long menuSczyId;
    /**
     *资源目录
     */
    private String url;
    /**
     *资源请求路径
     */
    private String action;
    /**
     *排序
     */
    private Short sort;
    /**
     * 2 父菜单，资源权限按此分类
     * 1 最后一级子菜单，公文按此类型分类
     */
    private Short resType;
    /**
     *菜单栏状态，0隐藏，1启用
     */
    private Short status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getMenuSczyId() {
        return menuSczyId;
    }

    public void setMenuSczyId(Long menuSczyId) {
        this.menuSczyId = menuSczyId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }

    public Short getResType() {
        return resType;
    }

    public void setResType(Short resType) {
        this.resType = resType;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}
