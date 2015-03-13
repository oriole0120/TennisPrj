package com.htmtennis.prj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.htmtennis.prj.dao.FreeDao;
import com.htmtennis.prj.dao.InformationDao;
import com.htmtennis.prj.model.Information;

public class MyBInformationDao implements InformationDao {

	@Override
	public Information getInformation(String code) {
		return null;
		
	}

	@Override
	public Information prevInformation(String curCode) {
		return null;
		
	}

	@Override
	public Information nextInformation(String curCode) {
		return null;
		
	}

	@Override
	public List<Information> getInformations(int page, String query,
			String field) {
		
		SqlSessionFactory factory = MyBatisMain.getSqlSessionFactory();
		SqlSession sqlSession = factory.openSession(true);
		InformationDao informationDao = sqlSession.getMapper(InformationDao.class);
		
		return informationDao.getInformations(page, query, field);
		
	}

	/*@Override
	public List<Information> getInformations(int page, String query) {
		return null;
		
	}

	@Override
	public List<Information> getInformations(int page) {
		return null;
		
	}*/

	@Override
	public int insert(Information information) {
		return 0;
		
	}

	@Override
	public int update(Information information) {
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

/*	@Override
	public int getSize(String query) {
		return 0;
		
	}*/

	@Override
	public String lastCode() {
		return null;
		
	}

}
