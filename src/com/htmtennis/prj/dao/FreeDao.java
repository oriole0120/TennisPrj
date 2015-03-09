package com.htmtennis.prj.dao;

import java.util.List;

import com.htmtennis.prj.model.Free;

public interface FreeDao {

	public Free getFree(String code);
	public Free prevFree(String curCode);
	public Free nextFree(String curCode);
	
	public List<Free> getFrees(int page, String query, String field);
	public List<Free> getFrees(int page, String query);
	public List<Free> getFrees(int page);

	public int insert(Free free);
	public int update(Free free);
	public int delete(String code);
	
	public int getSize(String query, String field);
	public int getSize(String query);
	public String lastCode();

}
