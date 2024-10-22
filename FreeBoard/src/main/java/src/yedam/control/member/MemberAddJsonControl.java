package src.yedam.control.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberAddJsonControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		MemberService svc = new MemberServiceImpl();

		String id = req.getParameter("mid");
		String name = req.getParameter("mname");
		String password = req.getParameter("pass");
		String phone = req.getParameter("phone");

		MemberVO member = new MemberVO();
		member.setMemberId(id);
		member.setMemberName(name);
		member.setPassword(password);
		member.setPhone(phone);

		boolean isAdded = svc.addMember(member);
		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", isAdded);

		try {
			String json = objectMapper.writeValueAsString(resultMap);
			resp.getWriter().print(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
