package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;


public interface BoardService {
	List<BoardVO> boardList();
	List<BoardVO> boardListByPage(int page);
	boolean RegisterBoard(BoardVO board);
	boolean removeBoard(int boardNo);
	boolean modifyBoard(BoardVO board);
	BoardVO searchBoard(int boardNo);
}
