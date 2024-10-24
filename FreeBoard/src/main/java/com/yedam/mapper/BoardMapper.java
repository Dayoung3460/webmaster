package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> boardList();
	List<BoardVO> boardListByPage(SearchDTO search);
	int boardTotalCount(SearchDTO search);
	List<BoardVO> boardListByNo();
	
	int insertBoard(BoardVO board);
	int updateBoard(BoardVO board);
	int deleteBoard(int boardNo);
	BoardVO selectBoard(int boardNo);
	int updateCount(int boardNo);
	
	// 사용자별 게시글 작성개수
	List<Map<String, Object>> countByWriter();
}
