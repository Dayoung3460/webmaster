package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
	public List<MemberVO> members();
	public MemberVO memberById(String memberId);
	public int insertMember(MemberVO member);
	public int updateMember(MemberVO member);
	public int deleteMember(String memberId);
	
	public MemberVO loginMember(@Param("id") String id, @Param("pw") String pw);
}
