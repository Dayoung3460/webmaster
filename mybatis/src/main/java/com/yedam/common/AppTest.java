package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

public class AppTest {

	public static void main(String[] args) {
//		MemberDAO dao = new MemberDAO();
		SqlSession sqlSession = DataSource.getInstance().openSession();
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		Member mbr = new Member();
		mbr.setMemberId("test99");
//		mbr.setMemberName("연습11");
//		mbr.setPhone("000-8888-8888");
//		mbr.setPassword("999");
		
//		if(dao.insertMember(mbr) == 1) {
//			sqlSession.commit();
//		}
//		
//		
//		if(dao.updateMember(mbr) == 1) {
//			sqlSession.commit();
//		}
		
		if(dao.deleteMember(mbr.getMemberId()) == 1) {
			sqlSession.commit();
		}
		
		List<Member> result = dao.members();
		for(Member member : result) {
			System.out.println(member.toString());
		}
	}

}
