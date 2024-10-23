package com.yedam.control.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyServiceImpl;

public class DeleteReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int replyNo = Integer.parseInt(req.getParameter("replyNo"));
		
		ReplyServiceImpl replyServiceImpl = new ReplyServiceImpl();
		boolean isSuccess = replyServiceImpl.removeReply(replyNo);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(isSuccess);
		
		resp.getWriter().print(json);
	}

}
