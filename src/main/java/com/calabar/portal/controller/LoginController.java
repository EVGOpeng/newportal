package com.calabar.portal.controller;

import com.calabar.portal.bean.User;
import com.cdcalabar.cas.client.util.CASAssertionHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/cas")
public class LoginController {
    /**
     单点登录
     */
    @RequestMapping(value="/singleLogin/login",method=RequestMethod.GET)
    public void singleLogin(){
        String id=CASAssertionHolder.getAssertion().getPrincipal().getName();
        System.out.println("单点登录id"+id);

    }
    /**
     注销登录
     注销url
     http://10.165.1.169:8899/cas/logout?
     注销成功后回调url
     */
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public void singleLogout(HttpServletResponse res) throws IOException {
        String id=CASAssertionHolder.getAssertion().getPrincipal().getName();
        System.out.println("单点退出id"+id);
        res.sendRedirect("http://10.165.4.38:8899/cas/logout?service=http://10.165.106.124:8080/cas/logoutOk");
    }
    /**
     注销成功后回调
     */
    @RequestMapping(value="/logoutOk",method=RequestMethod.GET)
    public void singleLogoutOk(HttpServletRequest req, HttpServletResponse res){
        String id=CASAssertionHolder.getAssertion().getPrincipal().getName();
        req.getSession().invalidate();
        System.out.println("单点退出okid"+id);
    }
}
