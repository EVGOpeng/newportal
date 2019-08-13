package com.calabar.portal.interceptor;
import com.calabar.portal.bean.User;
import com.calabar.portal.service.UserService;
import com.calabar.portal.utils.CodeStatus;
import com.calabar.portal.utils.StringUtils;
import com.cdcalabar.cas.client.util.CASAssertionHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 后台管理权限拦截,请求路径个事必须是manager/站点名/资源名/*格式
 */
@Component
public  class ManagerHandlerInterceptor implements HandlerInterceptor {
    @Resource
    private UserService userServiceImpl;
    @Resource
    private CodeStatus codeStatus;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestPath = request.getServletPath();
        System.out.println("资源拦截");
        String[] str=requestPath.split("/");
        //管理员才能进入管理页面
        if("/managerhtml/index".contains(requestPath)){
            String id=CASAssertionHolder.getAssertion().getPrincipal().getName();
            User user=userServiceImpl.selectById(Long.valueOf(id));
            if(user.getList().size()==0){
                //跳转没权限页面
                response.sendRedirect("http://10.165.1.186:9080/web/cyzy/home");
                return false;
            }else{
                return true;
            }
        }
        if(str.length<4)
        {
            return  false;}
        String id=CASAssertionHolder.getAssertion().getPrincipal().getName();
        User user=userServiceImpl.selectUserRoleResource(Long.valueOf(id));
        //超级管理员权限
        for (int i = 0; i <user.getList().size(); i++) {
            if(Long.valueOf(codeStatus.getAdministratorRoleId()).equals(user.getList().get(i).getId())){
                return true;
            }
        }
        String path=str[2]+"/"+str[3];
        for (int i = 0; i <user.getList().size(); i++) {
            for (int j = 0; j <user.getList().get(i).getResourcess().size() ; j++) {
                String resUrl="/"+user.getList().get(i).getResourcess().get(j).getSiteId()+"/"
                        +user.getList().get(i).getResourcess().get(j).getUrl()+"/";
                 if(StringUtils.isNotEmpty(resUrl)&&resUrl.indexOf(path)>0){
                    return true;
                }
            }
        }
        //跳转没权限页面
        response.sendRedirect("http://10.165.1.186:9080/web/cyzy/home");
        return  false;
    }
}