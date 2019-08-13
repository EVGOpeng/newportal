package com.calabar.portal.service.impl;

import com.calabar.portal.bean.Role;
import com.calabar.portal.bean.User;
import com.calabar.portal.dao.UserMapper;
import com.calabar.portal.service.RoleService;
import com.calabar.portal.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleService roleServiceImpl;
    public List<User> selectAll(Map<String, Object> map) {
        return userMapper.selectAll(map);
    }
    public Page selectAll(Integer currentPage, Integer pageSize, Map<String, Object> map) {
        if(currentPage==null)
            currentPage=1;
        if(pageSize==null){
            pageSize=15;
        }
        PageHelper.startPage(currentPage, pageSize);//线程绑定分页对象
        try {
            return  userMapper.selectAll(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            PageHelper.clearPage();//清除该线程上的分页对象
        }
        return null;
    }

    public int insert(User bean) {
        return userMapper.insert(bean);
    }

    public int update(User bean) {
        return userMapper.update(bean);
    }

    public User selectById(Serializable id) {
        return userMapper.selectById(id);
    }
    public int updateUserRole(List<Long> userIds,List<Long> roleIds){
        userMapper.deleteUserRole(userIds);
      return  userMapper.updateUserRole(userIds, roleIds);
    }
    /**
     * @param id 根据用户id查询用户信息，包含角色和角色的资源
     * @return
     */
    public User selectUserRoleResource(Long id){
        User user=selectById(id);
            user.setList(roleServiceImpl.selectByIds(user.getList()));
            return user;
    }
    public int deleteById(Serializable id) {
        return roleServiceImpl.deleteById(id);
    }
}
