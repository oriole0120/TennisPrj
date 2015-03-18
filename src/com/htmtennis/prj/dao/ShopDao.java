package com.htmtennis.prj.dao;

import java.util.List;



import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.htmtennis.prj.model.Court;
import com.htmtennis.prj.model.Shop;

public interface ShopDao {
	
	@Select("SELECT * FROM LinkShops WHERE CODE = #{code}")
	public Shop getShop(String code);

	/*@Select("SELECT TOP 1 * FROM PHOTOBOARDS "
			+ "WHERE REGDATE &gt; (SELECT REGDATE FROM PHOTOBOARDS WHERE CODE = #{code}) "
			+ "ORDER BY REGDATE ASC")
	public Court prevPhoto(String curCode);*/

	/*@Select("SELECT TOP 1 * FROM PHOTOBOARDS "
			+ "WHERE REGDATE &lt; (SELECT REGDATE FROM PHOTOBOARDS WHERE CODE = #{code}) "
			+ "ORDER BY REGDATE DESC")
	public Court nextPhoto(String curCode);*/


	@Select("SELECT N.* FROM( "
			+ "SELECT ("
			+ "			ROW_NUMBER() OVER (ORDER BY code DESC) "
			+ ") NUM, LinkShops.* FROM LinkShops WHERE ${field} LIKE '%${query}%' "
			+ ") N "
			+ "WHERE N.NUM BETWEEN 1+(#{page}-1)*20 AND 20+(#{page}-1)*20")
	public List<Shop> getShops(@Param("page")int page, @Param("query")String query, @Param("field")String field);
	/*public List<Shp[> getShops(int page, String query);
	public List<Shop> getShops(int page);*/


	@SelectKey( before = true, 
			keyColumn = "code", 
			statement = "SELECT isnull(MAX(CAST(CODE as int)),0)+1 CODE FROM LinkShops",
			resultType = java.lang.String.class, keyProperty = "code" ) 

	@Insert("INSERT INTO LinkShops(code, name, address, phoneNumber, site, positionX, positionY) "
	+ "VALUES(#{code},#{name},#{address},#{phoneNumber},#{site},#{positionX},#{positionY})"	)
	public int insert(Shop shop);


	@Update("UPDATE LinkShops SET name=#{name}, address=#{address} WHERE code=#{code}")
	public int update(Shop shop);

	@Delete("DELETE FROM LinkShops WHERE CODE = #{code}")
	public int delete(String code);



	@Select("SELECT COUNT(*) CNT FROM LinkShops WHERE #{field} LIKE '%${query}%'" )
	public int getSize(@Param("query") String query, @Param("field") String field);
	/*public int getSize(String query);*/

	/*@Select("SELECT ISNULL(MAX(CAST(CODE AS INT)), 0) Code  FROM PHOTOBOARDS")
	public String lastCode();

	}*/
	}	
