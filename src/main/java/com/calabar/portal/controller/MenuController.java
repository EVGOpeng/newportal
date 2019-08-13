package com.calabar.portal.controller;

import com.calabar.portal.service.MenuService;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource(name="menuServiceImpl")
    private MenuService menuServiceImpl;
    @GetMapping("/selectAll")
    public Page selectAll(Integer currentPage,Integer pageSize){
        Map map=new HashMap<String,Object>();
        Page p=menuServiceImpl.selectAll(currentPage,pageSize,map);
        return p;
    }
}
