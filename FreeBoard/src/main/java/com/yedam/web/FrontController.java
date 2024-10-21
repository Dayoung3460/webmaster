package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

// .do로 끝나는 url에서 요청이 들어올 때 
//@WebServlet("*.do")
public class FrontController extends HttpServlet{
	Map<String, Control> map;
	
	public FrontController() {
		map = new HashMap<>();
	}
	
	@Override
	public void init() throws ServletException {
		map.put("/memberList.do", new MemberListControl());
		map.put("/memberAddForm.do", new MemberAddFormControl());
		map.put("/memberAdd.do", new MemberAddControl());
		map.put("/memberDelete.do", new MemberDeleteControl());
		
		map.put("/boardList.do", new BoardListControl());
		map.put("/board.do", new BoardControl());
		map.put("/addBoardForm.do", new AddBoardFormControl());
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/modifyBoard.do", new ModifyBoardControl());
		map.put("/deleteBoard.do", new DeleteBoardControl());

		map.put("/loginForm.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		map.put("/javascript.do", new JavascriptControl());
	};

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI(); // /FreeBoard/memberAdd.do
		String context = req.getContextPath(); // /FreeBoard
		String page = url.substring(context.length()); // /memberAdd.do
		
		Control control = map.get(page);
		control.exec(req, resp);
	}
}
