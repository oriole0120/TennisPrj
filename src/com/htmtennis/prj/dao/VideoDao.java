package com.htmtennis.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.htmtennis.prj.model.Video;

public interface VideoDao {

	@Select("SELECT * FROM VIDEOBOARDS WHERE CODE = #{code}")
	public Video getVideo(String code);
	
	@Select("SELECT TOP 1 * FROM VIDEOBOARDS "
			+ "WHERE REGDATE &gt; (SELECT REGDATE FROM VIDEOBOARDS WHERE CODE = #{code}) "
			+ "ORDER BY REGDATE ASC")
	public Video prevVideo(String curCode);
	
	@Select("SELECT TOP 1 * FROM VIDEOBOARDS "
			+ "WHERE REGDATE &lt; (SELECT REGDATE FROM VIDEOBOARDS WHERE CODE = #{code}) "
			+ "ORDER BY REGDATE DESC")
	public Video nextVideo(String curCode);
	
	@Select("SELECT N.* FROM ( "
			+ "				SELECT ( "
			+ "						ROW_NUMBER() OVER (ORDER BY REGDATE DESC)"
			+ "				) NUM, VIDEOBOARDS.* FROM VIDEOBOARDS WHERE ${field} LIKE '%${query}%' "
			+ "		) N "
			+ "		WHERE N.NUM BETWEEN 1+(#{page}-1)*20 AND 20+(#{page}-1)*20")
	public List<Video> getVideos(@Param("page")int page, @Param("query")String query, @Param("field")String field);
	/*public List<Video> getVideos(int page, String query);
	public List<Video> getVideos(int page);*/

	@SelectKey( before = true, 
			keyColumn = "code", 
			statement = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM VIDEOBOARDS",
			resultType = java.lang.String.class, keyProperty = "code" ) 
	@Insert("INSERT INTO VIDEOBOARDS(CODE, WRITER, REGDATE, TITLE, CONTENTS, HIT, THUMB, AUTHORITY)	"
			+ "VALUES(#{code}, #{writer}, GETDATE(), #{title}, #{contents}, 0, 0, 'B')"	)
	public int insert(Video video);
	
	@Update("UPDATE VIDEOBOARDS SET TITLE=#{title}, CONTENTS=#{contents} WHERE CODE=#{code}")
	public int update(Video video);
	
	@Delete("DELETE FROM VIDEOBOARDS WHERE CODE = #{code}")
	public int delete(String code);
	
	@Select("SELECT COUNT(*) CNT FROM VIDEOBOARDS WHERE #{field} LIKE '%${query}%' ")
	public int getSize(@Param("query") String query, @Param("field") String field);
	/*public int getSize(String query);*/
	
	@Select("SELECT ISNULL(MAX(CAST(CODE AS INT)), 0) Code  FROM VIDEOBOARDS")
	public String lastCode();
}
