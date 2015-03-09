package com.htmtennis.prj.dao;

import java.util.List;

import com.htmtennis.prj.model.Court;

public interface CourtDao {

		public Court getCourt(String code);
		public List<Court> getCourts(int page, String query, String field);
		public List<Court> getCourts(int page, String query);
		public List<Court> getCourts(int page);
		public int insert(Court court);
		public int update(Court court);
		public int delete(String code);
		public int getSize(String query, String field);
		public int getSize(String query);
}
