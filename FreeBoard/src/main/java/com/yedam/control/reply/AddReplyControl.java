package com.yedam.control.reply;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		String replyContent = req.getParameter("reply");
		HttpSession session = req.getSession();
		String replyer = (String) session.getAttribute("logId");
		System.out.println(replyer);
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		ReplyVO reply = new ReplyVO();
		reply.setReply(replyContent);
		reply.setReplyer(replyer);
		reply.setBoardNo(bno);
		
		ReplyService replyServiceImpl = new ReplyServiceImpl();

		// reply를 출력해보면 replyNo도 들어있음
		// setReplyNo() 한적 없는데도.
		// ReplyMapper.xml 에서 selectKey로 처리
		boolean isSuccess = replyServiceImpl.RegisterReply(reply);
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(isSuccess);

		resp.getWriter().print(json);
	
		
//		Map<String, Object> result = new HashMap<>();
//		
//		if(isSuccess) {
//			result.put("retCode", "OK");
//			result.put("retVal", reply);
//		} else {
//			result.put("retCode", "FAIL");
//			result.put("retVal", null);
//		}
//		
//		Gson gson = new GsonBuilder().create();
//		String json = gson.toJson(result);
//
//		resp.getWriter().print(json);


		
	}

}
