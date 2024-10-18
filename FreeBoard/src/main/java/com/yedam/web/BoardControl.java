package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.SearchDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String currentPage = req.getParameter("currentPage");
		String searchCondition = req.getParameter("searchCondition");
		String keyword = req.getParameter("keyword");
		
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.searchBoard(Integer.parseInt(bno));
		
		req.setAttribute("boardvo", board);
		
		SearchDTO search = new SearchDTO();
		search.setCurrentPage(currentPage);
		search.setSearchCondition(searchCondition);
		search.setKeyword(keyword);
		
		req.setAttribute("search", search);

		req.getRequestDispatcher("WEB-INF/jsp/board.jsp").forward(req, resp);

	}

}
