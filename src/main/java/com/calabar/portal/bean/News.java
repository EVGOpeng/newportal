package com.calabar.portal.bean;

import com.calabar.portal.bean.common.BaseQuery;

import java.util.Date;

public class News extends BaseQuery
{
	private String uuid;
	/**
	 * id
	 */
	private Long newid;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 没有使用
	 */
	private String pic;
	/**
	 * 没有使用
	 */
	private String smpic;
	/**
	 * 类型0公司新闻，1行业新闻
	 */
	private Integer type;
	/**
	 *简介没有使用 
	 */
	private String smcontent;
	/**
	 *是否头条新闻 
	 */
	private Integer isheadlines;
	/**
	 * 发布人
	 */
	private Long userid;
	/**
	 * 发布人姓名
	 */
	private String userName;
	//是否推送到移动门户，0为不推送，1为推送
	/**
	 * 是否推送
	 */
	private Integer isPush;
	/**
	 * 是否发布
	 */
	private Integer ispublish;
	/**
	 * 发布时间
	 */
	private Date publishTime;
	/**
	 *更新时间 
	 */
	private Date lastUpdateTime;
	/**
	 *来源没有使用 
	 */
	private String source;
	/**
	 * 访问量
	 */
	private Integer views;
	/**
	 * 排序没有使用
	 */
	private String sort;
	/**
	 * 关键字没有使用
	 */
	private String keyWords;
	/**
	 * 副标题
	 */
	private String subTitle;
	/**
	 * 样式id
	 */
	private Integer styleId;//所属报纸样式
	/**
	  * 站点id（公司id）
	  */
	 private Long siteId;
	/**
	 * 类型，项目重新设计后分类字段
	 */
	private Long resId;

	public Long getResId() {
		return resId;
	}

	public void setResId(Long resId) {
		this.resId = resId;
	}

	public Long getSiteId() {
		return siteId;
	}
	
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	
	
	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}


	/**
	 * 长江烟报版面，1-首页，2—第一版,3-第二版，4-第三版，5-第四版
	 */
	private Integer newspapers;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Long getNewid() {
		return newid;
	}
	public void setNewid(Long newid) {
		this.newid = newid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getSmpic() {
		return smpic;
	}
	public void setSmpic(String smpic) {
		this.smpic = smpic;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getSmcontent() {
		return smcontent;
	}
	public void setSmcontent(String smcontent) {
		this.smcontent = smcontent;
	}
	public Integer getIsheadlines() {
		return isheadlines;
	}
	public void setIsheadlines(Integer isheadlines) {
		this.isheadlines = isheadlines;
	}
	public Integer getIspublish() {
		return ispublish;
	}
	public void setIspublish(Integer ispublish) {
		this.ispublish = ispublish;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public Integer getNewspapers() {
		return newspapers;
	}
	public void setNewspapers(Integer newspapers) {
		this.newspapers = newspapers;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}

	/**
	 * @return the isPush
	 */
	public Integer getIsPush() {
		return isPush;
	}

	/**
	 * @param isPush the isPush to set
	 */
	public void setIsPush(Integer isPush) {
		this.isPush = isPush;
	}

	public Integer getStyleId() {
		return styleId;
	}

	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}

}
