package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardServiceImpl;

public class deleteBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int bno = Integer.parseInt(req.getParameter("bno"));
		String isConfirmed = (String) req.getParameter("confirm");
		
		System.out.println("isConfirmed: " + isConfirmed);
		
		if(isConfirmed == null) {
			req.setAttribute("bno", bno);
			req.getRequestDispatcher("WEB-INF/jsp/boardDelete.jsp").forward(req, resp);
		} else {
			BoardServiceImpl boardServiceImpl = new BoardServiceImpl();
			boolean isSuccess = boardServiceImpl.removeBoard(bno);
			if (isSuccess) {
				resp.sendRedirect("boardList.do");
			} else {
				req.setAttribute("msg", "삭제하는 중 오류가 발생했습니다.");
				req.getRequestDispatcher("WEB-INF/jsp/board.jsp").forward(req, resp);
			}
		}
		

		

	}

}
