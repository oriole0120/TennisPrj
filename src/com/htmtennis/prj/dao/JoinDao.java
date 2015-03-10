package com.htmtennis.prj.dao;

import java.util.List;

import com.htmtennis.prj.model.Join;

public interface JoinDao {
	public Join getJoin(String code);
	/*public List<Join> getJoins(int page, String query, String field);
	public List<Join> getJoins(int page, String query);
	public List<Join> getJoins(int page);*/
	public int insert(Join join);
	public int update(Join join);
	public int delete(String mid);
	/*public int getSize(String query, String field);*/
	
}
