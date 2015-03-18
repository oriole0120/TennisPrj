package com.htmtennis.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.htmtennis.prj.model.Notice;



public interface NoticeDao {
	
	
	
	@Select("SELECT * FROM NOTICEBOARDS WHERE CODE = #{code}")
	public Notice getNotice(String code);
	
		
	
	@Select("SELECT TOP 1 * FROM NOTICEBOARDS "
			+ "WHERE REGDATE &gt; (SELECT REGDATE FROM NOTICEBOARDS WHERE CODE = #{code}) "
			+ "ORDER BY REGDATE ASC")
	public Notice prevtNotice(String curCode);
	
	
	
	@Select("SELECT TOP 1 * FROM NOTICEBOARDS "
			+ "WHERE REGDATE &lt; (SELECT REGDATE FROM NOTICEBOARDS WHERE CODE = #{code}) "
			+ "ORDER BY REGDATE DESC")
	public Notice nextNotice(String curCode);
	
	
	
	@Select("SELECT N.* FROM ( "
			+ "				SELECT ( "
			+ "						ROW_NUMBER() OVER (ORDER BY REGDATE DESC)"
			+ "				) NUM, NOTICEBOARDS.* FROM NOTICEBOARDS WHERE ${field} LIKE '%${query}%' "
			+ "		) N "
			+ "		WHERE N.NUM BETWEEN 1+(#{page}-1)*20 AND 20+(#{page}-1)*20")
	public List<Notice> getNotices(@Param("page")int page, @Param("query")String query, @Param("field")String field);
	//public List<Notice> getNotices(int page, String query);
	//public List<Notice> getNotices(int page);
	
	
	
	
	@SelectKey( before = true, 
			keyColumn = "code", 
			statement = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM NOTICEBOARDS",
			resultType = java.lang.String.class, keyProperty = "code" ) 
	@Insert("INSERT INTO NOTICEBOARDS(CODE, WRITER, REGDATE, TITLE, CONTENTS, HIT, THUMB, AUTHORITY)	"
			+ "VALUES(#{code}, #{writer}, GETDATE(), #{title}, #{contents}, 0, 0, 'B')"	)
	public int insert(Notice notice);
	
	
	
	
	
	@Update("UPDATE  NOTICEBOARDS SET TITLE=#{title}, CONTENTS=#{contents} WHERE CODE=#{code}")
	public int update(Notice notice);
	
	@Delete("DELETE FROM NOTICEBOARDS WHERE CODE = #{code}")
	public int delete(String code);
	
	
	@Select("SELECT COUNT(*) CNT FROM NOTICEBOARDS WHERE #{field} LIKE '%${query}%' ")
	public int getSize(@Param("query") String query, @Param("field") String field);
	//public int getSize(String query, String field);
	
	
	@Select("SELECT ISNULL(MAX(CAST(CODE AS INT)), 0) Code  FROM FREEBOARDS")
	public String lastCode();
}