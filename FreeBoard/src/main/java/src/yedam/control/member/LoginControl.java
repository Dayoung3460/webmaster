package src.yedam.control.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String logId = req.getParameter("logId");
		String logPw = req.getParameter("logPw");
		
		if(req.getMethod().equals("GET")) {
			req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);			
		} else if(req.getMethod().equals("POST")) {
			
			
			MemberService svc = new MemberServiceImpl();
			
			MemberVO member = svc.loginCheck(logId, logPw);
			
			if(member == null) {
				req.setAttribute("msg", "아이디와 비밀번호를 확인하세요.");
				req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
				return;
			}
			// session 객체는 계속 살아있음. 전역에 설정되는 변수.
			HttpSession session = req.getSession();
			session.setAttribute("logId", logId);
			
			if(member.getResponsibility().equals("User")) {
				resp.sendRedirect("boardList.do");
			} else {
				resp.sendRedirect("memberList.do");
			}
			
			
		}
	}
	
}
