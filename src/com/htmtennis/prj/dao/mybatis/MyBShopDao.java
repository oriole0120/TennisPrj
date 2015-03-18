package com.htmtennis.prj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.htmtennis.prj.dao.CourtDao;
import com.htmtennis.prj.dao.ShopDao;
import com.htmtennis.prj.model.Shop;

public class MyBShopDao implements ShopDao {

	@Override
	public Shop getShop(String code) {
		return null;
		
	}

	@Override
	public List<Shop> getShops(int page, String query, String field) {
		
			SqlSessionFactory factory = MyBatisMain.getSqlSessionFactory();
			SqlSession sqlSession = factory.openSession(true);
			ShopDao shopDao = sqlSession.getMapper(ShopDao.class);
			
			return shopDao.getShops(page, query, field);
		
	}

	/*@Override
	public List<Shop> getShops(int page, String query) {
		return null;
		
	}

	@Override
	public List<Shop> getShops(int page) {
		return null;
		
	}*/

	@Override
	public int insert(Shop shop) {
		return 0;
		
	}

	@Override
	public int update(Shop shop) {
		return 0;
		
	}

	@Override
	public int delete(String code) {
		SqlSessionFactory factory = MyBatisMain.getSqlSessionFactory();
		SqlSession sqlSession = factory.openSession(true);
		ShopDao shopDao = sqlSession.getMapper(ShopDao.class);
		
		
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
