package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
	
	
	@Override
	public List<ReplyVO> replyList2(int boardNo) {
		return mapper.replyList2(boardNo);
	}

	
	@Override
	public boolean RegisterReply(ReplyVO reply) {
		return mapper.insertReply(reply) == 1;
	}
	@Override
	public boolean removeReply(int replyNo) {
		return mapper.deleteReply(replyNo) == 1;
	}
	
	@Override
	public ReplyVO searchReply(int replyNo) {
		return mapper.selectReply(replyNo);
	}


	@Override
	public boolean editReply(ReplyVO reply) {
		return mapper.updateReply(reply) == 1;
	}


	@Override
	public List<ReplyVO> replyList(int boardNo, int page) {
		// TODO Auto-generated method stub
		return mapper.replyList(boardNo, page);
	}


	@Override
	public int countReply(int boardNo) {
		return mapper.countReply(boardNo);
	}

	
	
	
}
