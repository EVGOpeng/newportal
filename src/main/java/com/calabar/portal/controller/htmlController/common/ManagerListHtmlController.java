package com.calabar.portal.controller.htmlController.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台管理页面跳转类,拦截器进行了拦截，处理list页面
 */
@Controller
@RequestMapping("/managerhtml")
public class ManagerListHtmlController {
    /**请求路径和站点名文件夹、资源名文件夹、html名字对应
     * @param siteId 站点名11701四川中烟
     * @param resource 资源类型 如news,notice
     * @param htmlPage 页面名字 如list,edite
     * @return
     */
    @GetMapping("/{siteId}/{resource}/{htmlPage}")
public String htmlPage(HttpServletRequest req,@PathVariable("siteId")String siteId,@PathVariable("resource")String resource,@PathVariable("htmlPage")String htmlPage,String li_menuid,String id){
        req.setAttribute("li_menuid", li_menuid);
        req.setAttribute("id", id);//公文id
        req.setAttribute("siteId", siteId);//公文id
        return siteId+"/"+resource+"/"+htmlPage;
}
    /**后台管理首页
     * @param request
     * @return
     */
    @GetMapping("/index")
    public String adminIndexPage(HttpServletRequest request){
        return "managerhtml/index";
    }
}
