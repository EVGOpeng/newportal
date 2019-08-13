package com.calabar.portal.service.impl;

import com.calabar.portal.bean.Resources;
import com.calabar.portal.bean.Role;
import com.calabar.portal.dao.ResourcesMapper;
import com.calabar.portal.dao.RoleMapper;
import com.calabar.portal.service.ResourcesService;
import com.calabar.portal.service.RoleService;
import com.calabar.portal.utils.CodeStatus;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("resourcesServiceImpl")
public class ResourcesServiceImpl implements ResourcesService {
    @Resource
    private ResourcesMapper resourcesMapper;
    @Resource
    private CodeStatus codeStatus;
    @Override
    public List<Resources> sellectByParentId(Long parentId) {

        return resourcesMapper.sellectByParentId(parentId);
    }

    @Override
    public List<Resources> selectAll(Map<String, Object> map) {
        return resourcesMapper.selectAll(map);
    }

    @Override
    public Page selectAll(Integer currentPage, Integer pageSize, Map<String, Object> map) {
        if(currentPage==null)
            currentPage=1;
        if(pageSize==null){
            pageSize=15;
        }
        PageHelper.startPage(currentPage, pageSize);//线程绑定分页对象
        try {
            return  resourcesMapper.selectAll(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            PageHelper.clearPage();//清除该线程上的分页对象
        }
        return null;
    }

    @Override
    public int insert(Resources bean) {
        return resourcesMapper.insert(bean);
    }

    @Override
    public int update(Resources bean) {
        return resourcesMapper.update(bean);
    }

    @Override
    public Resources selectById(Serializable id) {
        return resourcesMapper.selectById(id);
    }
    public List<Resources> selectByRoleIds(List<Role> list) {
        //超级管理员查出所有资源
        for (Role role:list) {
            if(Long.valueOf(codeStatus.getAdministratorRoleId()).equals(role.getId())){
                Map map= new HashMap<String,Object>();
                map.put("status", 1);//可用
                map.put("resType",2);//分类父级菜单
                return resourcesMapper.selectAll(map);
            }
        }
        return resourcesMapper.selectByRoleIds(list);
    }
    /**查询子菜单分类
     * @param resources
     * @return
     */
    public List<Resources> selectSubmenuByParentId(Resources resources){
        return resourcesMapper.selectSubmenuByParentId(resources);
    }
    public int deleteById(Serializable id) {
       return resourcesMapper.deleteById(id);
    }
}
