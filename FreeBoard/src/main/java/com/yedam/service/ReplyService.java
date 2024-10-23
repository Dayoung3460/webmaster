package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;


public interface ReplyService {
	List<ReplyVO> replyList(int boardNo, int page);
	List<ReplyVO> replyList2(int boardNo);
	boolean RegisterReply(ReplyVO reply);
	boolean removeReply(int replyNo);
	ReplyVO searchReply(int replyNo);
	boolean editReply(ReplyVO reply);
	int countReply(int boardNo);
	
}
