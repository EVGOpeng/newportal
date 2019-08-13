package com.calabar.portal.dao;

import com.calabar.portal.bean.Resources;
import com.calabar.portal.bean.Role;
import com.calabar.portal.dao.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
List<Role> sellectByUserId(Long userId);

    /**根据多个角色id查询角色资源
     * @param list
     * @return
     */
List<Role> selectByIds(List<Role> list);
int insertRoleResources(@Param("roleId") Long roleId,@Param("resIds") List<Long> resIds);
int deleteRoleResources(@Param("roleId") Long roleId);
int deleteRole(@Param("roleId") Long roleId);
}
