package com.calabar.portal.service.common;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService <T>{
    List<T> selectAll(Map<String,Object> map);
    Page selectAll(Integer currentPage, Integer pageSize, Map<String,Object> map);
    int insert(T bean);
    int update(T bean);
    T selectById(Serializable id);
    int deleteById(Serializable id);
}
