package src.yedam.control.member;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberJsonControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		MemberService svc = new MemberServiceImpl();
		List<MemberVO> list = svc.memberList();
		
		ObjectMapper objectMapper = new ObjectMapper();
		// java의 Date 객체를 바로 json으로 넘기면 long 타입으로 변경되어 프론트에 밀리세컨드로 넘어감
        
     // java.util.Date에 대한 직렬화 포맷 설정
        SimpleModule dateModule = new SimpleModule();
        dateModule.addSerializer(Date.class, new com.fasterxml.jackson.databind.ser.std.DateSerializer(false, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
        objectMapper.registerModule(dateModule);
        
        // 타임스탬프 비활성화 (기본 설정)
//        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        
		try {
            String json = objectMapper.writeValueAsString(list);
            resp.getWriter().print(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
		
//		String json = "[";
//		for(int i = 0; i < list.size(); i++) {
//			json += "{\"memberId\": \"" + list.get(i).getMemberId() + "\", \"memberName\": \""+ list.get(i).getMemberName() + "\"}";
//			if(i < list.size() - 1) {
//				json += ",";
//			}
//		}
//		json += "]";
//		resp.getWriter().print(json);
		

	}

}
