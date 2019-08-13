package com.calabar.portal.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
public class OldRole implements Serializable {
   private Long roleId;
    private Long companyId;
    private Long  classnameId;
    private Long classpk;
    private String name;
    private String title;
    private String description;
    private Integer type;
    private String subType;
}
