package com.calabar.portal.bean;





import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 菜单栏
 */
@Getter
@Setter
@ToString
public class Menu implements Serializable {
    private Long id;
    private String menuName;
    /**
     *状态，0隐藏，1启用
     */
    private Short status;
    /**
     *排序
     */
    private Integer sort;
     /**
      * 站点
     */
    private Long siteId;
     /**
      * 请求地址
     */
    private String menuUrl;
}
