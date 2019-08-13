package com.calabar.portal;

import com.calabar.portal.bean.Menu;
import com.calabar.portal.bean.Resources;
import com.calabar.portal.bean.Role;
import com.calabar.portal.bean.User;
import com.calabar.portal.service.MenuService;
import com.calabar.portal.service.ResourcesService;
import com.calabar.portal.service.RoleService;
import com.calabar.portal.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.awt.SunHints;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortalApplicationTests {
    @Resource(name="resourcesServiceImpl")
    private ResourcesService resourcesServiceImpl;
    @Resource(name="roleServiceImpl")
    private RoleService roleServiceImpl;
    @Resource(name="userServiceImpl")
    private UserService userServiceImpl;
    @Resource(name="menuServiceImpl")
    private MenuService menuServiceImpl;

    /**
     * 添加资源
     */
    @Test
    public void contextLoads() {
        Resources bean =new Resources();
        bean.setName("企业管理");
        bean.setResType((short)1);
        bean.setSiteId(11701L);
        bean.setSort((short)1);
        bean.setStatus((short)1);
        resourcesServiceImpl.insert(bean);
        Resources bean1 =new Resources();
        bean1.setName("生产制造");
        bean1.setResType((short)1);
        bean1.setSiteId(11701L);
        bean1.setSort((short)2);
        bean1.setStatus((short)1);
        resourcesServiceImpl.insert(bean);
    }

    /**
     * 更改资源
     */
    @Test
    public void contextLoads1() {
        Resources bean1=resourcesServiceImpl.selectById(4L);
        bean1.setName("十九大");
        resourcesServiceImpl.update(bean1);
    }

    /**
     * 更改角色资源
     */
    @Test
    public void contextLoads2() {
        List<Long> ids=new ArrayList<Long>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        ids.add(4L);
        roleServiceImpl.updateRoleResources(0L, ids);
    }

    /**
     * 添加角色，更改角色资源
     */
    @Test
    public void contextLoads3() {
       /* Role bean1=new Role();
        bean1.setName("党建工作管理员");
        bean1.setSiteId(11701L);
        bean1.setStatus((short)1);
        Role bean2=new Role();
        bean2.setName("生产制造管理员");
        bean2.setSiteId(11701L);
        bean2.setStatus((short)1);
        Role bean3=new Role();
        bean3.setName("技术中心管理员");
        bean3.setSiteId(11701L);
        bean3.setStatus((short)1);
        Role bean4=new Role();
        bean4.setName("三联厂管理员");
        bean4.setSiteId(11701L);
        bean4.setStatus((short)1);
        roleServiceImpl.insert(bean1);
        roleServiceImpl.insert(bean2);
        roleServiceImpl.insert(bean3);
        roleServiceImpl.insert(bean4);*/
        List<Long> ids=new ArrayList<Long>();
        ids.add(7860L);
        /*ids.add(2L);
        ids.add(3L);
        ids.add(4L);*/
        List<Long> rid=new ArrayList<Long>();
        rid.add(1L);
        rid.add(2L);
        rid.add(3L);
        rid.add(4L);
        userServiceImpl.updateUserRole(ids, rid);
    }

    /**
     * 查询用户包含角色
     */
    @Test
    public void contextLoads4() {
    User user= userServiceImpl.selectById(7860L);
    user.getList();
    user.getRoles();
        System.out.println(user);
    }
    /**
     * 给单个角色添加资源
     */
    @Test
    public void contextLoads5() {
        List<Long> rid=new ArrayList<Long>();
        rid.add(1L);
        rid.add(2L);
        rid.add(3L);
        rid.add(4L);
        roleServiceImpl.updateRoleResources(1L, rid);
    }
    /**
     * 根据角色查询资源
     */
    @Test
    public void contextLoads6() {
        User user= userServiceImpl.selectById(7860L);
        System.out.println(user);
        List<Role> roles = roleServiceImpl.selectByIds(user.getList());
        System.out.println(roles);
    }
    /**
     * 添加菜单
     */
    @Test
    public void contextLoads7() {/*
        Menu bean1=new Menu();
        bean1.setMenuName("公司首页");
        bean1.setSiteId(11701L);
        bean1.setMenuUrl("/menuhtml/menu/innerindex");
        bean1.setSort(1);
        bean1.setStatus((short)1);
        Menu bean2=new Menu();
        bean2.setMenuName("企业概况");
        bean2.setSiteId(11701L);
        bean2.setMenuUrl("/menuhtml/menu/qygk");
        bean2.setSort(2);
        bean2.setStatus((short)1);
        Menu bean3=new Menu();
        bean3.setMenuName("党建工作");
        bean3.setSiteId(11701L);
        bean3.setMenuUrl("/menuhtml/menu/djgz");
        bean3.setSort(3);
        bean3.setStatus((short)1);
        Menu bean4=new Menu();
        bean4.setMenuName("办事公开");
        bean4.setSiteId(11701L);
        bean4.setMenuUrl("http://10.165.1.133:9080/SCEGOV/comweb/bizopen/IndexAction.do?method=getHomePage");
        bean4.setSort(4);
        bean4.setStatus((short)1);
        menuServiceImpl.insert(bean1);
        menuServiceImpl.insert(bean2);
        menuServiceImpl.insert(bean3);
        menuServiceImpl.insert(bean4);*/
    }
    /**
     * 查询菜单
     */
    @Test
    public void contextLoads8() {
        Map map=new HashMap<String,Object>();
        map.put("menuName", "首页");
        map.put("siteId", 11701L);
        map.put("status",1);
        List list = menuServiceImpl.selectAll(map);
        System.out.println(list);
    }
}
