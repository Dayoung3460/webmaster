package src.yedam.control.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberAddControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		MemberServiceImpl memberServiceImpl = new MemberServiceImpl();
		
		String id = req.getParameter("mid");
		String name = req.getParameter("mname");
		String password = req.getParameter("pass");
		String phone = req.getParameter("phone");

		MemberVO member = new MemberVO();
		member.setMemberId(id);
		member.setMemberName(name);
		member.setPassword(password);
		member.setPhone(phone);
		
		
		
		boolean isAdded = memberServiceImpl.addMember(member);
		if (isAdded) {
			resp.sendRedirect("memberList.do");
		} else {
			resp.sendRedirect("memberAddForm.do");
		}
	}

}
