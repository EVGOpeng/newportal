package com.calabar.portal.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

import java.util.List;
@ToString
public class Role implements Serializable {
   private Long id;
    private String name;
    private  Long siteId;
    private   Short status;
    private List<Resources> resourcess;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getSiteId() {
        return siteId;
    }

    public Short getStatus() {
        return status;
    }

    public List<Resources> getResourcess() {
        return resourcess;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public void setResourcess(List<Resources> resourcess) {
        this.resourcess = resourcess;
    }
}
