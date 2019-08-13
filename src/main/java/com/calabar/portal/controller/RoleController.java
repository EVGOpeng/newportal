package com.calabar.portal.controller;

import com.calabar.portal.bean.Role;
import com.calabar.portal.service.RoleService;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource(name="roleServiceImpl")
    private RoleService roleServiceImpl;
    @GetMapping("/selectAll")
    public Page selectAll(Integer currentPage,Integer pageSize){
        Map map=new HashMap<String,Object>();
        Page p=roleServiceImpl.selectAll(currentPage,pageSize,map);
        p.getResult();
        return p;
    }
    @GetMapping("/selectRoleById")
    public  Role selectRoleById(Long id){
        return roleServiceImpl.selectById(id);
    }
}
