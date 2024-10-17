package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class modifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		BoardVO board;
		int bno = Integer.parseInt(req.getParameter("bno"));
		BoardService svc = new BoardServiceImpl();
		
		
		if(req.getMethod().equals("GET")) {
			board = svc.searchBoard(bno);
			
			req.setAttribute("boardvo", board);
			req.getRequestDispatcher("WEB-INF/jsp/boardModifyForm.jsp").forward(req, resp);			
		} else {
			board = new BoardVO();
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			board.setBoardNo(bno);
			board.setTitle(title);
			board.setContent(content);
			
			boolean isSuccess = svc.modifyBoard(board);
			if(isSuccess) {
				resp.sendRedirect("boardList.do");
			} else {
				req.setAttribute("msg", "수정하는 중 오류가 발생했습니다.");
				req.getRequestDispatcher("WEB-INF/jsp/boardModifyForm.jsp").forward(req, resp);
			}
		}
		

	}

}
