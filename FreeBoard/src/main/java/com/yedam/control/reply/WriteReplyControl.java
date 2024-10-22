package com.yedam.control.reply;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class WriteReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		int bno = Integer.parseInt(req.getParameter("bno"));
//		String reply = req.getParameter("reply");
//		String replyer = req.getParameter("replyer");
//
//		ReplyService replyService = new ReplyServiceImpl();
//		List<ReplyVO> list = replyService.inertReply(bno);
//
//		Gson gson = new GsonBuilder().create();
//		String json = gson.toJson(list);
//
//		resp.getWriter().print(json);

	}

}
