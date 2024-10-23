package com.yedam.control.reply;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class CountReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		ReplyService replyServiceImpl = new ReplyServiceImpl();
		int replyCount = replyServiceImpl.countReply(bno);
		
		Map<String, Integer> result = new HashMap<>();
		result.put("replyCount", replyCount);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(result);

		resp.getWriter().print(json);
		
	}

}
