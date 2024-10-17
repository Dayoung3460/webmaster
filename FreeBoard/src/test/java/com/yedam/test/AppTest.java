package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class AppTest {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class); // 구현 클래스 가져온거
		
		BoardVO bvo = new BoardVO();
//		bvo.setTitle("mapper TEST");
//		bvo.setContent("content!");
//		bvo.setWriter("user7");
		bvo.setBoardNo(4);
		
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
		List<BoardVO> list = mapper.boardListByPage(1);
		for(BoardVO bvo2 : list) {
			System.out.println(bvo2.toString());
		}
		
	}
}
