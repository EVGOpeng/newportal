package com.calabar.portal.service.impl;

import com.calabar.portal.bean.News;
import com.calabar.portal.bean.Role;
import com.calabar.portal.dao.RoleMapper;
import com.calabar.portal.dao.RoleMapper;
import com.calabar.portal.service.NewsService;
import com.calabar.portal.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    public List<Role> selectAll(Map<String, Object> map) {
        return roleMapper.selectAll(map);
    }
    public Page selectAll(Integer currentPage, Integer pageSize, Map<String, Object> map) {
        if(currentPage==null)
            currentPage=1;
        if(pageSize==null){
            pageSize=15;
        }
        PageHelper.startPage(currentPage, pageSize);//线程绑定分页对象
        try {
            return  roleMapper.selectAll(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            PageHelper.clearPage();//清除该线程上的分页对象
        }
        return null;
    }

    public int insert(Role bean) {
        return roleMapper.insert(bean);
    }

    public int update(Role bean) {
        return roleMapper.update(bean);
    }

    public Role selectById(Serializable id) {
        return roleMapper.selectById(id);
    }
    public List<Role> selectByIds(List<Role> list) {
        return roleMapper.selectByIds(list);
    }
    public List<Role> sellectByUserId(Long userId){
    return roleMapper.sellectByUserId(userId);
    };
    public int updateRoleResources(Long roleId,List<Long> resIds){
        roleMapper.deleteRoleResources(roleId);
       return roleMapper.insertRoleResources(roleId, resIds);
    }
    public int deleteRole(Long roleId){
        roleMapper.deleteRoleResources(roleId);
      return  roleMapper.deleteRole(roleId);
    }
    public int deleteById(Serializable id) {
        return roleMapper.deleteById(id);
    }
}
