package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		MemberServiceImpl memberServiceImpl = new MemberServiceImpl();

		List<MemberVO> list = memberServiceImpl.memberList();
		req.setAttribute("memberList", list);
		try {
			// memberList.do에서 요청받았던거를 memberList.jsp로 재요청
			req.getRequestDispatcher("WEB-INF/jsp/memberList.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		};

	}
}
