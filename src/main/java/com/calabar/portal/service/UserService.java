package com.calabar.portal.service;

import com.calabar.portal.bean.User;
import com.calabar.portal.service.common.BaseService;

import java.util.List;

public interface UserService extends BaseService<User> {
    int updateUserRole(List<Long> userIds,List<Long> roleIds);
    /**
     * @param id 根据用户id查询用户信息，包含角色和角色的资源
     * @return
     */
    public User selectUserRoleResource(Long id);
}