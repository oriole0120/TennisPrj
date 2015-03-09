package com.htmtennis.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.htmtennis.prj.model.Photo;

public interface PhotoDao {
	@Select("SELECT * FROM PHOTOBOARDS WHERE CODE = #{code}")
	public Photo getPhoto(String code);
	
	@Select("SELECT TOP 1 * FROM PHOTOBOARDS "
			+ "WHERE REGDATE &gt; (SELECT REGDATE FROM PHOTOBOARDS WHERE CODE = #{code}) "
			+ "ORDER BY REGDATE ASC")
	public Photo prevPhoto(String curCode);
	
	@Select("SELECT TOP 1 * FROM PHOTOBOARDS "
			+ "WHERE REGDATE &lt; (SELECT REGDATE FROM PHOTOBOARDS WHERE CODE = #{code}) "
			+ "ORDER BY REGDATE DESC")
	public Photo nextPhoto(String curCode);
	
	@Select("SELECT N.* FROM ( "
			+ "				SELECT ( "
			+ "						ROW_NUMBER() OVER (ORDER BY REGDATE DESC)"
			+ "				) NUM, PHOTOBOARDS.* FROM PHOTOBOARDS WHERE ${field} LIKE '%${query}%' "
			+ "		) N "
			+ "		WHERE N.NUM BETWEEN 1+(#{page}-1)*20 AND 20+(#{page}-1)*20")
	public List<Photo> getPhotos(@Param("page")int page, @Param("query")String query, @Param("field")String field);
	public List<Photo> getPhotos(int page, String query);
	public List<Photo> getPhotos(int page);

	
	@SelectKey( before = true, 
			keyColumn = "code", 
			statement = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM PHOTOBOARDS",
			resultType = java.lang.String.class, keyProperty = "code" ) 
	@Insert("INSERT INTO PHOTOBOARDS(CODE, WRITER, REGDATE, TITLE, CONTENTS, HIT, THUMB, AUTHORITY)	"
			+ "VALUES(#{code}, #{writer}, GETDATE(), #{title}, #{contents}, 0, 0, 'B')"	)
	public int insert(Photo photo);
	
	
	@Update("UPDATE PHOTOBOARDS SET TITLE=#{title}, CONTENTS=#{contents} WHERE CODE=#{code}")
	public int update(Photo photo);
	
	@Delete("DELETE FROM PHOTOBOARDS WHERE CODE = #{code}")
	public int delete(String code);
	
	@Select("SELECT COUNT(*) CNT FROM PHOTOBOARDS WHERE #{field} LIKE '%${query}%' ")
	public int getSize(@Param("query") String query, @Param("field") String field);
	public int getSize(String query);
	
	@Select("SELECT ISNULL(MAX(CAST(CODE AS INT)), 0) Code  FROM PHOTOBOARDS")
	public String lastCode();

}
