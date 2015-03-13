package com.htmtennis.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.htmtennis.prj.model.Court;



public interface CourtDao {

		/*public Court getCourt(String code);
		public List<Court> getCourts(int page, String query, String field);
		public List<Court> getCourts(int page, String query);
		public List<Court> getCourts(int page);
		public int insert(Court court);
		public int update(Court court);
		public int delete(String code);
		public int getSize(String query, String field);
		public int getSize(String query);*/
/*}*/


@Select("SELECT * FROM LinkCourts WHERE CODE = #{code}")
public Court getCourt(String code);

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
		+ "			ROW_NUMBER() OVER (ORDER BY site DESC) "
		+ ") NUM, LinkCourts.* FROM LinkCourts WHERE ${field} LIKE '%${query}%' "
		+ ") N "
		+ "WHERE N.NUM BETWEEN 1+(#{page}-1)*20 AND 20+(#{page}-1)*20")
public List<Court> getCourts(@Param("page")int page, @Param("query")String query, @Param("field")String field);
/*public List<Photo> getPhotos(int page, String query);
public List<Photo> getPhotos(int page);*/


@SelectKey( before = true, 
		keyColumn = "code", 
		statement = "SELECT isnull(MAX(CAST(CODE as int)),0)+1 CODE FROM LinkCourts",
		resultType = java.lang.String.class, keyProperty = "code" ) 

@Insert("INSERT INTO LinkCourts(code, name, address, phoneNumber, site, positionX, positionY) "
+ "VALUES(#{code},#{name},#{address},#{phoneNumber},#{site},#{positionX},#{positionY})"	)
public int insert(Court court);


@Update("UPDATE LinkCourts SET name=#{name}, address=#{address} WHERE code=#{code}")
public int update(Court court);

@Delete("DELETE FROM LinkCourts WHERE CODE = #{code}")
public int delete(String code);



@Select("SELECT COUNT(*) CNT FROM LinkCourts WHERE #{field} LIKE '%${query}%'" )
public int getSize(@Param("query") String query, @Param("field") String field);
/*public int getSize(String query);*/

/*@Select("SELECT ISNULL(MAX(CAST(CODE AS INT)), 0) Code  FROM PHOTOBOARDS")
public String lastCode();

}*/
}	
	