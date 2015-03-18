package com.htmtennis.prj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.htmtennis.prj.model.Information;

public interface InformationDao {
	@Select("SELECT * FROM INFORMATIONBOARDS WHERE CODE = #{code}")
	public Information getInformation(String code);
	
	@Select("SELECT TOP 1 * FROM INFORMATIONBOARDS "
			+ "WHERE REGDATE > (SELECT REGDATE FROM INFORMATIONBOARDS WHERE CODE = #{curCode}) "
			+ "ORDER BY REGDATE ASC")
	public Information prevInformation(String curCode);
	
	@Select("SELECT TOP 1 * FROM INFORMATIONBOARDS "
			+ "WHERE REGDATE < (SELECT REGDATE FROM INFORMATIONBOARDS WHERE CODE = #{curCode}) "
			+ "ORDER BY REGDATE DESC")
	public Information nextInformation(String curCode);
	
	@Select("SELECT N.* FROM ( "
			+ "				SELECT ( "
			+ "						ROW_NUMBER() OVER (ORDER BY REGDATE DESC)"
			+ "				) NUM, INFORMATIONBOARDS.* FROM INFORMATIONBOARDS WHERE ${field} LIKE '%${query}%' "
			+ "		) N "
			+ "		WHERE N.NUM BETWEEN 1+(#{page}-1)*20 AND 20+(#{page}-1)*20")
	public List<Information> getInformations(@Param("page")int page, @Param("query")String query, @Param("field")String field);
	/*public List<Information> getInformations(int page, String query);
	public List<Information> getInformations(int page);*/

	
	@SelectKey( before = true, 
			keyColumn = "code", 
			statement = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM INFORMATIONBOARDS",
			resultType = java.lang.String.class, keyProperty = "code" ) 
	@Insert("INSERT INTO INFORMATIONBOARDS(CODE, WRITER, REGDATE, TITLE, CONTENTS, HIT, THUMB, AUTHORITY)	"
			+ "VALUES(#{code}, #{writer}, GETDATE(), #{title}, #{contents}, 0, 0, 'B')"	)
	public int insert(Information information);
	
	
	@Update("UPDATE INFORMATIONBOARDS SET TITLE=#{title}, CONTENTS=#{contents} WHERE CODE=#{code}")
	public int update(Information information);
	
	@Delete("DELETE FROM INFORMATIONBOARDS WHERE CODE = #{code}")
	public int delete(String code);
	
	@Select("SELECT COUNT(*) CNT FROM INFORMATIONBOARDS WHERE #{field} LIKE '%${query}%' ")
	public int getSize(@Param("query") String query, @Param("field") String field);
	/*public int getSize(String query);*/
	
	@Select("SELECT ISNULL(MAX(CAST(CODE AS INT)), 0) Code  FROM INFORMATIONBOARDS")
	public String lastCode();

}
