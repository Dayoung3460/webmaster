package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	private int startPage, endPage;
	private boolean prev, next;
	
	public PageDTO(int page) { 
		int totalCnt = 46;
		
		this.endPage = (int) Math.ceil(page / 10.0) * 10; 
		this.startPage = this.endPage - 9; 
		
		int realEnd = (int) Math.ceil(totalCnt / 5.0);
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		this.prev = startPage > 1;
		this.next = endPage == realEnd;// 
	}
}
