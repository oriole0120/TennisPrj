package com.newlecture.jspprj.dao;

import java.util.List;

import com.newlecture.jspprj.model.Member;

public interface MemberDao {
	public Member getMember(String uid);	//public List<Member> getMembers(String name, String phone, String email);// ȸ��Ż��

	public List<Member> getMembers(String uid, String pwd);// �α���

	public List<Member> getMembers(String uid, String name, String email,String birth, String gender);// ��й�ȣã��

	//public List<Member> getMembers(String name, String birth, String gender);// ���̵�ã��

	public int insert(Member member);

	public int update(Member member);

	public int delete(String code);

}
