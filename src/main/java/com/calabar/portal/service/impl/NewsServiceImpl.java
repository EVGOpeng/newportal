package com.calabar.portal.service.impl;

import com.calabar.portal.bean.News;
import com.calabar.portal.dao.NewsMapper;
import com.calabar.portal.service.NewsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service("newsServiceImpl")
public class NewsServiceImpl  implements NewsService  {
    @Resource
    private NewsMapper newsMapper;
    public List<News> selectAll(Map<String, Object> map) {
        return newsMapper.selectAll(map);
    }
    public Page selectAll(Integer currentPage, Integer pageSize, Map<String, Object> map) {
        if(currentPage==null)
            currentPage=1;
        if(pageSize==null){
            pageSize=15;
        }
        PageHelper.startPage(currentPage, pageSize);//线程绑定分页对象
        try {
            return  newsMapper.selectAll(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            PageHelper.clearPage();//清除该线程上的分页对象
        }
        return null;
    }

    public int insert(News bean) {
        return newsMapper.insert(bean);
    }

    public int update(News bean) {
        return newsMapper.update(bean);
    }

    public News selectById(Serializable id) {
        return newsMapper.selectById(id);
    }
    public int deleteById(Serializable id) {
        return newsMapper.deleteById(id);
    }
}
