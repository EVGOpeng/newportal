package com.calabar.portal.service.impl;

import com.calabar.portal.bean.Menu;
import com.calabar.portal.bean.Menu;
import com.calabar.portal.dao.MenuMapper;
import com.calabar.portal.dao.common.BaseMapper;
import com.calabar.portal.service.MenuService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;
    public List<Menu> selectAll(Map<String, Object> map) {
        return menuMapper.selectAll(map);
    }
    public Page selectAll(Integer currentPage, Integer pageSize, Map<String, Object> map) {
        if(currentPage==null)
            currentPage=1;
        if(pageSize==null){
            pageSize=15;
        }
        PageHelper.startPage(currentPage, pageSize);//线程绑定分页对象
        try {
            return  menuMapper.selectAll(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            PageHelper.clearPage();//清除该线程上的分页对象
        }
        return null;
    }

    public int insert(Menu bean) {
        return menuMapper.insert(bean);
    }

    public int update(Menu bean) {
        return menuMapper.update(bean);
    }

    public Menu selectById(Serializable id) {
        return menuMapper.selectById(id);
    }
    public int deleteById(Serializable id) {
       return menuMapper.deleteById(id);
    }
}
