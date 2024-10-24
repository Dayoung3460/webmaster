package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.AddEventControl;
import com.yedam.control.CalendarControl;
import com.yedam.control.ChartControl;
import com.yedam.control.DeleteEventControl;
import com.yedam.control.EventListControl;
import com.yedam.control.JavascriptControl;
import com.yedam.control.UpdateEventControl;
import com.yedam.control.reply.ReplyListControl;
import com.yedam.control.reply.UpdateReplyControl;
import com.yedam.control.reply.AddReplyControl;
import com.yedam.control.reply.CountReplyControl;
import com.yedam.control.reply.DeleteReplyControl;

import src.yedam.control.board.AddBoardControl;
import src.yedam.control.board.AddBoardFormControl;
import src.yedam.control.board.BoardControl;
import src.yedam.control.board.BoardListControl;
import src.yedam.control.board.CountByWriterControl;
import src.yedam.control.board.DeleteBoardControl;
import src.yedam.control.board.ModifyBoardControl;
import src.yedam.control.member.LoginControl;
import src.yedam.control.member.LogoutControl;
import src.yedam.control.member.MemberAddControl;
import src.yedam.control.member.MemberAddFormControl;
import src.yedam.control.member.MemberAddJsonControl;
import src.yedam.control.member.MemberDeleteControl;
import src.yedam.control.member.MemberDeleteJsonControl;
import src.yedam.control.member.MemberJsonControl;
import src.yedam.control.member.MemberListControl;



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
		
		map.put("/memberJson.do", new MemberJsonControl());
		map.put("/memberDeleteJson.do", new MemberDeleteJsonControl());
		map.put("/memberAddJson.do", new MemberAddJsonControl());
		
		map.put("/replyList.do", new ReplyListControl());
		map.put("/addReply.do", new AddReplyControl());
		map.put("/deleteReply.do", new DeleteReplyControl());
		map.put("/updateReply.do", new UpdateReplyControl());
		map.put("/countReply.do", new CountReplyControl());
		
		map.put("/chart.do", new ChartControl());
		map.put("/countByWriter.do", new CountByWriterControl());
		
		map.put("/calendar.do", new CalendarControl());
		map.put("/eventList.do", new EventListControl());
		map.put("/addEvent.do", new AddEventControl());
		map.put("/deleteEvent.do", new DeleteEventControl());
		map.put("/updateEvent.do", new UpdateEventControl());
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
