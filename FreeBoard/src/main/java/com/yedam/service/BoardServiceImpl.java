package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public List<BoardVO> boardList() {
		return mapper.boardList();
	}
	
	@Override
	public List<BoardVO> boardListByPage(SearchDTO search) {
		return mapper.boardListByPage(search);
	}
	
	@Override
	public int boardTotalCount(SearchDTO search) {
		return mapper.boardTotalCount(search);
	}
	
	@Override
	public boolean RegisterBoard(BoardVO board) {
		return mapper.insertBoard(board) == 1;
	}
	@Override
	public boolean removeBoard(int boardNo) {
		return mapper.deleteBoard(boardNo) == 1;
	}
	@Override
	public boolean modifyBoard(BoardVO board) {
		return mapper.updateBoard(board) == 1;
	}
	@Override
	public BoardVO searchBoard(int boardNo) {
		// 글이 조회될 때마다 viewCnt+1
		mapper.updateCount(boardNo);
		return mapper.selectBoard(boardNo);
	}

	@Override
	public List<Map<String, Object>> countByWriter() {
		return mapper.countByWriter();
	}

	

	
	
	
}
