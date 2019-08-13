package com.calabar.portal.controller;

import com.calabar.portal.bean.User;
import com.calabar.portal.service.UserService;
import com.calabar.portal.utils.StringUtils;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource(name="userServiceImpl")
    private UserService userServiceImpl;

    /**分页查询用户，该用户信息不包含角色信息
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/selectAll")
    public Page selectAll(Integer currentPage,Integer pageSize,String name){
        Map map=new HashMap<String,Object>();
        name=StringUtils.removeBlank(name);
        if(com.calabar.portal.utils.StringUtils.isNotEmpty(name)){
        map.put("name", name);
        }
        Page p=userServiceImpl.selectAll(currentPage,pageSize,map);
        p.getResult();
        return p;
    }

    /**
     * @param id 用户id，根据用户id查询用户信息，包含角色信息，不包含角色的资源
     * @return
     */
    @GetMapping("/selectUserRoleById")
    public User selectUserRoleById(Long id){
        return userServiceImpl.selectById(id);
    }

    /**
     * @param id 根据用户id查询用户信息，包含角色和角色的资源
     * @return
     */
    public User selectUserRoleResource(Long id){
        return userServiceImpl.selectUserRoleResource(id);
    }
    @PostMapping("/updateUserRole")
    public  int updateUserRole(List<Long> userIds,List<Long> roleIds){
        return userServiceImpl.updateUserRole(userIds,roleIds);
    }
}
