package com.calabar.portal.dao;

import com.calabar.portal.bean.User;
import com.calabar.portal.dao.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    int updateUserRole(@Param("userIds") List<Long> userIds,@Param("roleIds") List<Long> roleIds);
    int deleteUserRole(@Param("userIds") List<Long> userIds);
}
