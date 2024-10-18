package com.yedam.common;

import lombok.Data;

@Data
public class SearchDTO {
	private String currentPage;
	private String searchCondition;
	private String keyword;
}
