package com.travel.util;
//分页类
public class Page {
	private int startPage=0;//初始页码
	private int pageSize=5;//初始页面容量
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		if(startPage>0) {
			this.startPage = startPage;
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize>0) {
			this.pageSize = pageSize;
		}
	}
}
