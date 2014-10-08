package com.moke.jpa.util;

import java.util.List;

/**
 * 
 * @author L 
 * @time     2014年10月8日 下午2:56:02
 * 
 * @目的 设计分页类，除了分页的信息，还需要存储返回的结果集
 *  
 *  @优点 Page<T>能做为返回值对象，在页面分页显示的时候获取页数等信息
 * 
 *  @关键
 *  	PageNum(总页数) = maxResults（结果集的大小） / pageSize(一页的大小);
 *  	
 * 
 * @param <T>
 */
public class Page<T> {
	
	private long currentPage = 0;
	private long maxResults = 0;
	private long pageSize = 7;
	private List<T> results;
	
	public Page() {}
	
	public Page(long currentPage,long pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	
	public Page(long currentPage,long maxResults,long pageSize) {
		this.currentPage = currentPage;
		this.maxResults = maxResults;
		this.pageSize = pageSize;
	}
	
	public long getPre() {
		if (currentPage > 1 ) {
			return  --currentPage;
		}  else {
			return currentPage;
		}
	}
	
	public long getNext() {
		if (currentPage < (maxResults/pageSize)) {
			return ++ currentPage;
		}  else {
			return currentPage;
		}
	}
	
	public long getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}
	public long getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(long maxResults) {
		this.maxResults = maxResults;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getResults() {
		return results;
	}
	public void setResults(List<T> results) {
		this.results = results;
	}
	
}
