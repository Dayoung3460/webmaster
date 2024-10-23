package com.yedam.control.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class UpdateReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int replyNo = Integer.parseInt(req.getParameter("replyNo"));
		String replyContent = req.getParameter("reply");
		
		ReplyService replyServiceImpl = new ReplyServiceImpl();
		
		ReplyVO reply = new ReplyVO();
		reply.setReplyNo(replyNo);
		reply.setReply(replyContent);
		
		boolean isSuccess = replyServiceImpl.editReply(reply);
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(isSuccess);

		resp.getWriter().print(json);
		
	}

}
