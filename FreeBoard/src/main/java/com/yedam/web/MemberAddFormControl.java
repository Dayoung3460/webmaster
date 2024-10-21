package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberServiceImpl;

public class MemberAddFormControl implements Control {

	@Override
	// WEB-INF 폴더는 외부에서 접근 불가
	// 바로 url 치고 들어갈 수 없게 jsp 폴더를 WEB-INF 안으로 넣음
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("admin/memberAddForm.tiles").forward(req, resp);
	}
}
