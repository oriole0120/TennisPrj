package com.htmtennis.prj.dao;


import com.htmtennis.prj.model.Member;

public interface MemberDao {
	public Member getMember(String code);
	/*public List<Member> getMembers(int page, String query, String field);
	public List<Member> getMembers(int page, String query);
	public List<Member> getMembers(int page);*/
	public int insert(Member member);
	public int update(Member member);
	public int delete(String mid);
	/*public int getSize(String query, String field);*/
	
}
