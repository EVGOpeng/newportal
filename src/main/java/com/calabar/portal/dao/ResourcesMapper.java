package com.calabar.portal.dao;

import com.calabar.portal.bean.News;
import com.calabar.portal.bean.Resources;
import com.calabar.portal.bean.Role;
import com.calabar.portal.dao.common.BaseMapper;

import java.util.List;

public interface ResourcesMapper extends BaseMapper<Resources> {
List<Resources> sellectByParentId(Long parentId);
List<Resources> selectByRoleIds(List<Role> list);
List<Resources> selectSubmenuByParentId(Resources resources);
}
