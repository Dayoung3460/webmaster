package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

@WebServlet("/member.action")
public class MemberControlServlet extends HttpServlet {
	public MemberControlServlet() {
		System.out.println("MemberControl instance created");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("excuted, when first request");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doGet, doPost 요청 상관없이 실행되는 메소드
		System.out.println("excuted, whenever servlet requested");

		resp.setContentType("text/html;charset=utf-8");
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);

		String id = req.getParameter("mid");

		if (req.getMethod().equals("GET")) {
			resp.getWriter().print(id);
			Member member = dao.memberById(id);

			if (member == null) {
				resp.getWriter().print("member not found");
			}

			String str = "<h3>Member details</h3>";

			str += "<form action='member.action' method='post'>";
			str += "<input type='hidden' name='mid' value='" + member.getMemberId() + "'>";
			str += "<table border='1'>";
			str += "<tr><th>Id</th><td>" + member.getMemberId() + "</td></tr>";
			str += "<tr><th>Name</th><td>" + member.getMemberName() + "</td></tr>";
			str += "<tr><th>Phone</th><td>" + member.getPhone() + "</td></tr>";
			str += "<tr><th>CreationDate</th><td>" + member.getCreationDate() + "</td></tr>";
			str += "<tr><th>Responsibility</th><td>" + member.getResponsibility() + "</td></tr>";
			str += "<tr><td colspan='2'><input type='submit'>삭제<td><tr>";
			str += "</table>";
			str += "</form>";
			str += "<a href='MemberListServlet'>Go to List</a>";

			resp.getWriter().print(str);
		} else if (req.getMethod().equals("POST")) {
			if (dao.deleteMember(id) == 1) {
				resp.getWriter().print("<p>Deleted</p>");
			} else {
				resp.getWriter().print("<p>삭제할 회원 없음</p>");
			}
			resp.getWriter().print("<a href='MemberListServlet'>Go to List</a>");
		} else {

		}
	}

	@Override
	public void destroy() {
		System.out.println("excuted once, when server closed");
	}
}
