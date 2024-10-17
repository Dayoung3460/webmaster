package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardMapper {
	List<BoardVO> boardList();
	List<BoardVO> boardListByPage(int page);
	List<BoardVO> boardListByNo();
	
	int insertBoard(BoardVO board);
	int updateBoard(BoardVO board);
	int deleteBoard(int boardNo);
	BoardVO selectBoard(int boardNo);
	int updateCount(int boardNo);
}