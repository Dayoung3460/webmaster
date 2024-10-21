package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchCondition = req.getParameter("searchCondition") == null ? "" : req.getParameter("searchCondition");
		String keyword = req.getParameter("keyword") == null ? "" : req.getParameter("keyword");
		String currentPage = req.getParameter("currentPage") == null ? "1" : req.getParameter("currentPage");
		
		SearchDTO search = new SearchDTO();
		search.setCurrentPage(currentPage);
		search.setSearchCondition(searchCondition);
		search.setKeyword(keyword);
		
		
		BoardService svc = new BoardServiceImpl();

		
		List<BoardVO> list = svc.boardListByPage(search);
		int totalCount = svc.boardTotalCount(search);
		
		req.setAttribute("search", search);
		req.setAttribute("boardList", list);
		req.setAttribute("paging", new PageDTO(Integer.parseInt(currentPage), totalCount));
		req.getRequestDispatcher("board/boardList.tiles").forward(req, resp);
	}

}
