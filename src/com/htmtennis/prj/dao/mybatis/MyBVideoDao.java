package com.htmtennis.prj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.htmtennis.prj.dao.VideoDao;
import com.htmtennis.prj.model.Video;

public class MyBVideoDao implements VideoDao{

	@Override
	public Video getVideo(String code) {
		// TODO Auto-generated method stub
		return null;
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
		SqlSessionFactory factory = MyBatisMain.getSqlSessionFactory();
		SqlSession sqlSession = factory.openSession(true);
		VideoDao videoDao = sqlSession.getMapper(VideoDao.class);
		
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
		// TODO Auto-generated method stub
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
