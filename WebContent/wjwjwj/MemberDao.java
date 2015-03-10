package com.newlecture.jspprj.dao;

import java.util.List;

import com.newlecture.jspprj.model.Member;

public interface MemberDao {
	public Member getMember(String uid);	//public List<Member> getMembers(String name, String phone, String email);// 회원탈퇴

	public List<Member> getMembers(String uid, String pwd);// 로그인

	public List<Member> getMembers(String uid, String name, String email,String birth, String gender);// 비밀번호찾기

	//public List<Member> getMembers(String name, String birth, String gender);// 아이디찾기

	public int insert(Member member);

	public int update(Member member);

	public int delete(String code);

}
