package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberServiceImpl;

public class MemberDeleteControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberServiceImpl memberServiceImpl = new MemberServiceImpl();
		
		String id = req.getParameter("mid");
		System.out.println("id : " + id);
		boolean isAdded = memberServiceImpl.retireMember(id);
		if(isAdded) {
			resp.sendRedirect("memberList.do");
		}

	}

}
