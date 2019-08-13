package com.calabar.portal.bean.common;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class BaseQuery implements Serializable
{

	// 默认的当前页
	private static final int DEFAULT_CURRENT_PAGE = 1;
	// 默认的每页条数
	private static final int DEFAULT_PAGE_SIZE = 15;
	// 当前页
	private int currentPage = DEFAULT_CURRENT_PAGE;
	// 每页条数
	private int pageSize = DEFAULT_PAGE_SIZE;
	// 所有页
	private int totalPage = 0;

	public int getTotalPage()
	{
		//totalPage = this.total / pageSize + 1;
		totalPage = (this.total + pageSize -1) / pageSize;
		return totalPage;
	}

	// 总记录条数
	private int total;
	// 开始的记录行数
	private int start;
	private String count;
	private List<String> expression = new ArrayList<String>();

	public Integer getCurrentPage()
	{
		if (start == 0)
		{
			return this.currentPage;
		}
		if (start > 0)
		{
			this.currentPage = (this.start - 1) / this.pageSize + 1;
		}
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage)
	{
		this.currentPage = currentPage;
	}

	public Integer getEnd()
	{
		int endRecord = 0;
		if (getTotal().intValue() == 0)
		{
			return endRecord;
		}
		endRecord = getPageSize() * getCurrentPage();
		if (endRecord > this.total)
		{
			endRecord = this.total;
		}
		return endRecord;
	}

	public Integer getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(Integer pageSize)
	{
		if (null != pageSize && pageSize.intValue() != 0)
		{
			this.pageSize = pageSize;
		}
	}

	public Integer getStart()
	{
		if (this.start > 0)
		{
			return this.start;
		}
		int startRecord = this.pageSize * (this.currentPage - 1) + 1;
		if (startRecord >= this.total)
		{
			startRecord = this.total;
		}
		this.start = startRecord;
		return this.start;
	}

	public void setStart(Integer start)
	{
		this.start = start;
	}

	public Integer getTotal()
	{
		return total;
	}

	public void setTotal(Integer total)
	{
		this.total = total;
	}

	public String getCount()
	{
		return count;
	}

	public void setCount(String count)
	{
		this.count = count;
	}


}
