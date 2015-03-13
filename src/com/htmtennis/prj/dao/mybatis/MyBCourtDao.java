package com.htmtennis.prj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.htmtennis.prj.dao.CourtDao;
import com.htmtennis.prj.dao.PhotoDao;
import com.htmtennis.prj.model.Court;
import com.htmtennis.prj.model.Photo;

public class MyBCourtDao implements CourtDao {

	@Override
	public Court getCourt(String code) {
		return null;
		
	}

	@Override
	public List<Court> getCourts(int page, String query, String field) {
		
			SqlSessionFactory factory = MyBatisMain.getSqlSessionFactory();
			SqlSession sqlSession = factory.openSession(true);
			CourtDao courtDao = sqlSession.getMapper(CourtDao.class);
			
			return courtDao.getCourts(page, query, field);
		
	}

	/*@Override
	public List<Court> getCourts(int page, String query) {
		return null;
		
	}

	@Override
	public List<Court> getCourts(int page) {
		return null;
		
	}*/

	@Override
	public int insert(Court court) {
		return 0;
		
	}

	@Override
	public int update(Court court) {
		return 0;
		
	}

	@Override
	public int delete(String code) {
		return 0;
		
	}

	@Override
	public int getSize(String query, String field) {
		return 0;
		
	}

	/*@Override
	public int getSize(String query) {
		return 0;
		
	}*/

	
}
