package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;


public interface BoardService {
	List<BoardVO> boardList();
	List<BoardVO> boardListByPage(SearchDTO search);
	int boardTotalCount(SearchDTO search);
	boolean RegisterBoard(BoardVO board);
	boolean removeBoard(int boardNo);
	boolean modifyBoard(BoardVO board);
	BoardVO searchBoard(int boardNo);

	List<Map<String, Object>> countByWriter();
	
}
