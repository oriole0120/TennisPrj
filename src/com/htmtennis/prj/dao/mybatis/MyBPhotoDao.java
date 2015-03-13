package com.htmtennis.prj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.htmtennis.prj.dao.PhotoDao;
import com.htmtennis.prj.model.Photo;

public class MyBPhotoDao implements PhotoDao {

	@Override
	public Photo getPhoto(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Photo prevPhoto(String curCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Photo nextPhoto(String curCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Photo> getPhotos(int page, String query, String field) {
		SqlSessionFactory factory = MyBatisMain.getSqlSessionFactory();
		SqlSession sqlSession = factory.openSession(true);
		PhotoDao photoDao = sqlSession.getMapper(PhotoDao.class);
		
		return photoDao.getPhotos(page, query, field);
	}

	/*@Override
	public List<Photo> getPhotos(int page, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Photo> getPhotos(int page) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public int insert(Photo photo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Photo photo) {
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
