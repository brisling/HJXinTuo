package com.hjxintuo.model;

import java.util.List;

// 用于分页的工具类
public class Pagination<T> {
	private List<T> objectList;              // 结果对象集
	private int pageCount = 1;               // 总记录数
	private int currentPage = 1;             // 当前页码
	
	private int navigatePageNum = 5;         // 每页显示的导航页码数
	private int[] navigatePages;             // 所有导航页号
	
	private int isFirstPage = 0;     // 是否为第一页
    private int isLastPage = 0;      // 是否为最后一页
    
    private int firstResultOffset = 0;
    
    public Pagination(int total, int currentPage, int objectsPerPage, int navigatePageNum) {
    	this.pageCount = total / objectsPerPage;
    	if (total % objectsPerPage != 0) {
    		this.pageCount += 1;
    	}
    	
    	this.currentPage = currentPage;
    	if (this.currentPage > this.pageCount) {
    		this.currentPage = this.pageCount;
    	}
    	
    	this.navigatePageNum = navigatePageNum;
    	
    	this.firstResultOffset = (this.currentPage - 1) * objectsPerPage;
    	this.isFirstPage = (this.currentPage == 1) ? 1 : 0;
    	this.isLastPage = (this.currentPage == this.pageCount) ? 1 : 0;
    	
    	calcNavigatePages();
    }
    
    public Pagination(int total, int currentPage, int objectsPerPage) {
    	this(total, currentPage, objectsPerPage, 5);
    }
    
    public Pagination(int total, int currentPage) {
    	this(total, currentPage, 10, 5);
    }
    
    // 计算要展示的导航页码
	private void calcNavigatePages(){
		if (pageCount < navigatePageNum) {
			// 当总页数小于或等于导航页码数时
			navigatePages = new int[pageCount];
			for (int i = 0; i < pageCount; i++){
				navigatePages[i] = i + 1;
			}
		} else { 
			// 当总页数大于导航页码数时
			navigatePages = new int[navigatePageNum];
			
			int startNo = currentPage - navigatePageNum / 2;
			int endNo = currentPage + navigatePageNum / 2;
			if (startNo < 1) {               // 最前几页
				startNo = 1;                 
			} else if (endNo > pageCount) {   // 最后几页
				startNo = pageCount - navigatePageNum + 1;
			}
			
			for (int i = 0; i < navigatePageNum; ++i) {
				navigatePages[i] = startNo++;
			}
		}
	}
	
	
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNavigatePageNum() {
		return navigatePageNum;
	}

	public void setNavigatePageNum(int navigatePageNum) {
		this.navigatePageNum = navigatePageNum;
	}

	public int[] getNavigatePages() {
		return navigatePages;
	}

	public void setNavigatePages(int[] navigatePages) {
		this.navigatePages = navigatePages;
	}

	public int getIsFirstPage() {
		return isFirstPage;
	}

	public void setIsFirstPage(int isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public int getIsLastPage() {
		return isLastPage;
	}

	public void setIsLastPage(int isLastPage) {
		this.isLastPage = isLastPage;
	}

	public int getFirstResultOffset() {
		return firstResultOffset;
	}

	public void setFirstResultOffset(int firstResultOffset) {
		this.firstResultOffset = firstResultOffset;
	}

	public List<T> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<T> objectList) {
		this.objectList = objectList;
	}
}