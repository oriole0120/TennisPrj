package com.htmtennis.prj.dao;

import java.util.List;

import com.htmtennis.prj.model.Information;

public interface InformationDao {

	public Information getInformation(String code);
	public Information prevInformation(String curCode);
	public Information nextInformation(String curCode);
	
	public List<Information> getInformations(int page, String query, String field);
	public List<Information> getInformations(int page, String query);
	public List<Information> getInformations(int page);

	public int insert(Information information);
	public int update(Information information);
	public int delete(String code);
	
	public int getSize(String query, String field);
	public int getSize(String query);
	public String lastCode();

}
