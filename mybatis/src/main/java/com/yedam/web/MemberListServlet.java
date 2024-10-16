package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;
// 해당 url에서 요청이 들어오면 HttpServlet를 상속받고 있는 클래스가 실행됨
@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberListServlet() {
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		out.print("<h3>web browser 한글</h3>");
//		out.print("<h3>web browser 한글222222</h3>");
//		out.print("<a href='index.html'>첫페이지로 이동</a>");
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		try {
			if(dao.members() != null) {
				out.print("총 " + dao.members().size() + "명");
				out.print("<hr/>");
				for(Member member : dao.members()) {
					out.print("<h4> ID: " + member.getMemberId() + "</h4>");
					
					out.print("Name: " + member.getMemberName());
					out.print("<br/>");
//					out.print("Phone: " + member.getPhone());
//					out.print("<br/>");
//					out.print("CreationDate: " + member.getCreationDate());
//					out.print("<br/>");
//					out.print("Password: " + member.getPassword());
//					out.print("<br/>");
//					out.print("Responsibility: " + member.getResponsibility());
//					out.print("<br/>");
					out.print("<a href='member.action?mid=" + member.getMemberId() + "'>상세 조회</a>");
					out.print("<hr/>");
				}
				
			}		
		} catch (Exception e) {
			response.getWriter().print("NG");
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("mid");
		String name = request.getParameter("mname");
		String password = request.getParameter("pass");
		String phone = request.getParameter("phone");
		
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberName(name);
		member.setPassword(password);
		member.setPhone(phone);
		
		// openSession에 true로 파라미터 넘겨주면 자동 커밋됨
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		try {
			if(dao.insertMember(member) == 1) {
				response.getWriter().print("OK");
			}		
		} catch (Exception e) {
			response.getWriter().print("NG");
		}
	
	}

}
