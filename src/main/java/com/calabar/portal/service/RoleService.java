package com.calabar.portal.service;

import com.calabar.portal.bean.Role;
import com.calabar.portal.service.common.BaseService;

import java.util.List;

public interface RoleService extends BaseService<Role> {
    List<Role> sellectByUserId(Long userId);
    /**根据多个角色id查询角色资源
     * @param list
     * @return
     */
    List<Role> selectByIds(List<Role> list);
    int updateRoleResources(Long roleId,List<Long> resIds);
    int deleteRole(Long roleId);
}