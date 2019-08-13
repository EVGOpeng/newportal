package com.calabar.portal.controller.htmlController;

import com.calabar.portal.bean.News;
import com.calabar.portal.service.NewsService;
import com.calabar.portal.service.impl.NewsServiceImpl;
import com.calabar.portal.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 后台管理页面跳转类,拦截器进行了拦截，处理edit页面
 */
@Controller
public class NewsHtmlController {
    @Resource
    private NewsService newsServiceImpl;
    /**新闻编辑
     * @param req
     * @param siteId
     * @param li_menuid
     * @param id
     * @return
     */
    @GetMapping("/managerhtml/{siteId}/news/newsManagerEdit/edit")
public String htmlPage(HttpServletRequest req,@PathVariable("siteId")String siteId,String li_menuid,String id){
        req.setAttribute("li_menuid", li_menuid);
        req.setAttribute("siteId",siteId);
        if(StringUtils.isNotBlank(id)){
            News news=  newsServiceImpl.selectById(Long.valueOf(id));
            req.setAttribute("news", news);
        }
        return "siteid/news/newsManagerEdit";
}
    @GetMapping("/managerhtml/{siteId}/news/deleteById")
    @ResponseBody
    public int deleteById(Long id){
        return newsServiceImpl.deleteById(id);
    }
}
