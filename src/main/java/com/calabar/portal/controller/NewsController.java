package com.calabar.portal.controller;

import com.calabar.portal.bean.News;
import com.calabar.portal.bean.common.BeanVO;
import com.calabar.portal.service.NewsService;
import com.calabar.portal.utils.DateUtil;
import com.calabar.portal.utils.ParametersUtil;
import com.calabar.portal.utils.StringUtils;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/{siteId}/{rescouse}")
public class NewsController {
    @Resource(name="newsServiceImpl")
    private NewsService newsServiceImpl;
    @GetMapping("/editor")
    public String editer(Long id){
     return  "siteId/news/editor";
    }
    /**
     * @param siteId
     * @param title
     * @param minTime
     * @param resId 资源id
     * @param ispublish
     * @param maxTime
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/selectAll")
    public BeanVO selectAll(@PathVariable("siteId")Long siteId, String title, String minTime, Long resId,
                            Integer ispublish, String maxTime, Integer currentPage, Integer pageSize,String isheadlines){
        Map map= ParametersUtil.setparatersToMap( siteId, title, minTime, resId,ispublish, maxTime);
        if(StringUtils.isNotBlank(isheadlines))
            map.put("isheadlines", Integer.valueOf(isheadlines));
        Page page=newsServiceImpl.selectAll(currentPage,pageSize,map);
        BeanVO beanVO=new BeanVO(page);
        return beanVO;
    }
}
