package com.calabar.portal.service;

import com.calabar.portal.bean.Resources;
import com.calabar.portal.bean.Role;
import com.calabar.portal.service.common.BaseService;

import java.util.List;

public interface ResourcesService extends BaseService<Resources> {
    List<Resources> sellectByParentId(Long parentId);

    /**后台管理查询去去重后的资源菜单
     * @param list
     * @return
     */
    List<Resources> selectByRoleIds(List<Role> list);

    /**查询子菜单分类
     * @param resources
     * @return
     */
    List<Resources> selectSubmenuByParentId(Resources resources);
}