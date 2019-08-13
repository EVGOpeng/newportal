package com.calabar.portal.controller;

import com.calabar.portal.bean.Resources;
import com.calabar.portal.bean.Role;
import com.calabar.portal.service.ResourcesService;
import com.calabar.portal.service.RoleService;
import com.calabar.portal.service.impl.ResourcesServiceImpl;
import com.cdcalabar.cas.client.util.CASAssertionHolder;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resources")
public class ResourcesController {
    @Resource(name="resourcesServiceImpl")
    private ResourcesService resourcesServiceImpl;
    @Resource(name="roleServiceImpl")
    private RoleService roleServiceImpl;

    /**查询角色拥有的资源，可以作为管理菜单
     * @param request
     * @return
     */
    @GetMapping("/islogin/selectByRoleIds")
    public List<Resources> selectByRoleIds(HttpServletRequest request){
        String id=CASAssertionHolder.getAssertion().getPrincipal().getName();
        List<Role> roles = roleServiceImpl.sellectByUserId(Long.valueOf(id));
        return  resourcesServiceImpl.selectByRoleIds(roles);
    }

    /**查询 当前父级菜单的子菜单
     * @param parentId
     * @return
     */
    @GetMapping("/sellectByParentId")
    public List<Resources> sellectByParentId(Long parentId) {
        return resourcesServiceImpl.sellectByParentId(parentId);
    }

    /**查询菜单及其子菜单或者只查询子菜单
     * @param parentId 父菜单id
     * @param resType 0，查询父菜单及其子菜单，1只查询子菜单
     * @return
     */
    @GetMapping("/selectSubmenuByParentId")
    public List<Resources> selectSubmenuByParentId(Long parentId,Short resType){
        Resources resources =new Resources();
        resources.setParentId(parentId);
        resources.setResType(resType);
       return  resourcesServiceImpl.selectSubmenuByParentId(resources);
    }
}
