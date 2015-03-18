package com.htmtennis.prj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.htmtennis.prj.dao.VideoDao;
import com.htmtennis.prj.model.Video;

public class MyBVideoDao implements VideoDao{

	private SqlSessionFactory factory;
	private SqlSession sqlSession;
	private VideoDao videoDao;
	
	private void settingSession() {
		factory = MyBatisMain.getSqlSessionFactory();
		sqlSession = factory.openSession(true);
		videoDao = sqlSession.getMapper(VideoDao.class);
	}
	
	@Override
	public Video getVideo(String code) {
		settingSession();		
		return videoDao.getVideo(code);
	}

	@Override
	public Video prevVideo(String curCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video nextVideo(String curCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> getVideos(int page, String query, String field) {
		settingSession();		
		return videoDao.getVideos(page, query, field);
	}

	/*@Override
	public List<Video> getVideos(int page, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> getVideos(int page) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public int insert(Video video) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Video video) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String code) {
		settingSession();
		videoDao.delete(code);
		return 0;
	}

	@Override
	public int getSize(String query, String field) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*@Override
	public int getSize(String query) {
		// TODO Auto-generated method stub
		return 0;
	}*/

	@Override
	public String lastCode() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
