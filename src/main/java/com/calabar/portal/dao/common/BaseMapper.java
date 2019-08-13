package com.calabar.portal.dao.common;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.Map;
import java.util.List;

public interface BaseMapper <T>{
    Page<T> selectAll(Map<String,Object> map);
    int insert(T bean);
    int update(T bean);
    T selectById(Serializable id);
    int deleteById(Serializable id);
}
