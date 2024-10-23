package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> replyList(@Param("bno") int boardNo, @Param("page") int page);
	List<ReplyVO> replyList2(int boardNo);
	int deleteReply(int replyNo);
	int insertReply(ReplyVO reply);
	ReplyVO selectReply(int replyNo);
	int updateReply(ReplyVO reply);
	int countReply(int boardNo);
}
