package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		BoardServiceImpl boardServiceImpl = new BoardServiceImpl();
		boolean isSuccess = boardServiceImpl.RegisterBoard(board);
		if (isSuccess) {
			// page 재지정
			resp.sendRedirect("boardList.do");
		} else {
			req.setAttribute("msg", "등록하는 중 오류가 발생했습니다.");
			// req에서 받은 값을 다시 전달에서 페이지 이동
			req.getRequestDispatcher("WEB-INF/jsp/boardAddForm.jsp").forward(req, resp);
		}
	}

}
