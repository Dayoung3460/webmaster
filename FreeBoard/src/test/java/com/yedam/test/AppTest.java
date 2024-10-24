package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.service.CalendarService;
import com.yedam.service.CalendarServiceImpl;
import com.yedam.vo.CalendarVO;

public class AppTest {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession();
		//ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class); // 구현 클래스 가져온거

//		BoardService svc = new BoardServiceImpl();
		CalendarServiceImpl svc = new CalendarServiceImpl();
		List<CalendarVO> result = svc.eventList();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(result);
				
		System.out.println(json);
		
		
//		ReplyVO reply = new ReplyVO();
//		reply.setReply("ReplyReplyReplyReply");
//		reply.setReplyer("user2");
//		reply.setBoardNo(596);
//		
//		ReplyVO reply = mapper.selectReply(2);
//		System.out.println("success: " + reply.toString());
		
		
//		for(ReplyVO item : reply) {
//			System.out.println("print2: " + item.toString());
//		}
		
//		BoardVO bvo = new BoardVO();
//		bvo.setTitle("mapper TEST");
//		bvo.setContent("content!");
//		bvo.setWriter("user7");
//		bvo.setBoardNo(4);
		
//		if(mapper.insertBoard(bvo) == 1) {
//			sqlSession.commit();
//		}
//		
//		if(mapper.updateBoard(bvo) == 1) {
//			sqlSession.commit();
//		}
		
//		if(mapper.deleteBoard(1) == 1) {
//			sqlSession.commit();
//		}
		
//		if(mapper.selectBoard(1) == null) {
//			System.out.println("조회된 내용이 없습니다.");
//		} 
		
//		List<BoardVO> list = mapper.boardList();
//		List<BoardVO> list = mapper.boardListByPage(1);
//		for(BoardVO bvo2 : list) {
//			System.out.println(bvo2.toString());
//		}
		
		
		
		
	}
}
