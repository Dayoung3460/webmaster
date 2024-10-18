package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data // getter, setter, toString, equals, hasCode 모두 통틀어서
public class BoardVO {
	private int boardNo;
	private String title;
	private String content;
	private String writer; // writerId memberId
	private String writerName;
	private int viewCnt;
	private Date writeDate;
	private Date updateDate;
	private int totalCount;
}
