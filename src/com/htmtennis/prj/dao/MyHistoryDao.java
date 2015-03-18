package com.htmtennis.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.htmtennis.prj.model.Free;

public interface MyHistoryDao {
	@Select("SELECT * FROM FREEBOARDS WHERE CODE = #{code}")
	public Free getFree(String code);
	
	@Select("SELECT TOP 1 * FROM FREEBOARDS "
			+ "WHERE REGDATE &gt; (SELECT REGDATE FROM FREEBOARDS WHERE CODE = #{code}) "
			+ "ORDER BY REGDATE ASC")
	public Free prevFree(String curCode);
	
	@Select("SELECT TOP 1 * FROM FREEBOARDS "
			+ "WHERE REGDATE &lt; (SELECT REGDATE FROM FREEBOARDS WHERE CODE = #{code}) "
			+ "ORDER BY REGDATE DESC")
	public Free nextFree(String curCode);
	
	@Select("SELECT N.* FROM ( "
			+ "				SELECT ( "
			+ "						ROW_NUMBER() OVER (ORDER BY REGDATE DESC)"
			+ "				) NUM, FREEBOARDS.* FROM FREEBOARDS WHERE ${field} LIKE '%${query}%' "
			+ "		) N "
			+ "		WHERE N.NUM BETWEEN 1+(#{page}-1)*20 AND 20+(#{page}-1)*20")
	public List<Free> getFrees(@Param("page")int page, @Param("query")String query, @Param("field")String field);
	/*public List<Free> getFrees(int page, String query);
	public List<Free> getFrees(int page);*/

	
	@SelectKey( before = true, 
			keyColumn = "code", 
			statement = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM FREEBOARDS",
			resultType = java.lang.String.class, keyProperty = "code" ) 
	@Insert("INSERT INTO FREEBOARDS(CODE, WRITER, REGDATE, TITLE, CONTENTS, HIT, THUMB, AUTHORITY)	"
			+ "VALUES(#{code}, #{writer}, GETDATE(), #{title}, #{contents}, 0, 0, 'B')"	)
	public int insert(Free free);
	
	
	@Update("UPDATE FREEBOARDS SET TITLE=#{title}, CONTENTS=#{contents} WHERE CODE=#{code}")
	public int update(Free free);
	
	@Delete("DELETE FROM FREEBOARDS WHERE CODE = #{code}")
	public int delete(String code);
	
	@Select("SELECT COUNT(*) CNT FROM FREEBOARDS WHERE #{field} LIKE '%${query}%' ")
	public int getSize(@Param("query") String query, @Param("field") String field);
	/*public int getSize(String query);*/
	
	@Select("SELECT ISNULL(MAX(CAST(CODE AS INT)), 0) Code  FROM FREEBOARDS")
	public String lastCode();

}
