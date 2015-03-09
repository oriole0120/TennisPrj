package com.htmtennis.prj.dao;

import java.util.List;


import com.htmtennis.prj.model.Shop;

public interface ShopDao {
	
		public Shop getShop(String code);
		public List<Shop> getShops(int page, String query, String field);
		public List<Shop> getShops(int page, String query);
		public List<Shop> getShops(int page);
		public int insert(Shop shop);
		public int update(Shop shop);
		public int delete(String code);
		public int getSize(String query, String field);
		public int getSize(String query);
}
