package com.htmtennis.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htmtennis.prj.dao.FreeDao;
import com.htmtennis.prj.model.Free;
import com.htmtennis.prj.model.Photo;

public class JdbcFreeDao implements FreeDao {

	@Override
	public Free getFree(String code) {
		String sql = "SELECT * FROM FREEBOARDS WHERE CODE = '"+code+"' ";
		
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			//모델마련하기		
			rs.next();

			
			Free fr=new Free();
			fr.setCode(rs.getString("CODE"));
			fr.setWriter(rs.getString("WRITER"));
			fr.setRegdate(rs.getDate("REGDATE"));
			fr.setTitle(rs.getString("TITLE"));
			fr.setContents(rs.getString("CONTENTS"));
			fr.setHit(rs.getInt("HIT"));
			fr.setThumb(rs.getInt("THUMB"));
			fr.setAuthority(rs.getString( "AUTHORITY"));
					
			rs.close();
			st.close();
			con.close();
			return fr;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public List<Free> getFrees(int page, String query, String field) {
		int start	=  1+(page-1)*20;	//(page-1)*20+1;
		int end 	= 20+(page-1)*20;	//page*20;
		
		/*String sql = "SELECT F.* FROM ( "
				+ "SELECT(ROW_NUMBER() OVER ( "
				+ "ORDER BY REGDATE DESC)) NUM, FREEBOARDS.* FROM FREEBOARDS)"
				+ "WHERE " + field + " LIKE ?" + ") F "
				+ "WHERE F.NUM BETWEEN ? AND ?"; */
		
		String sql = "SELECT F.* FROM ( "
				+ "SELECT (ROW_NUMBER() OVER (ORDER BY REGDATE DESC)) NUM, FREEBOARDS.* "
				+ "FROM FREEBOARDS WHERE '" + field + "' LIKE ?" + ") F "
						+ "WHERE F.NUM BETWEEN ? AND ?";
		
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%"+ query +"%");
			st.setInt(2, start);
			st.setInt(3, end);
			
			ResultSet rs = st.executeQuery();
			List<Free> list = new ArrayList<Free>();
			
			while(rs.next()) {
				Free fr = new Free();
				fr.setCode(rs.getString("CODE"));
				fr.setWriter(rs.getString("WRITER"));
				fr.setRegdate(rs.getDate("REGDATE"));
				fr.setTitle(rs.getString("TITLE"));
				fr.setContents(rs.getString("CONTENTS"));
				fr.setHit(rs.getInt("HIT"));
				fr.setThumb(rs.getInt("THUMB"));
				fr.setAuthority(rs.getString("AUTHORITY"));
				
				list.add(fr);
			}
			
			rs.close();
			st.close();
			con.close();
			
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Free> getFrees(int page, String query) {
		
		return getFrees(page, query, "Title");
	}

	@Override
	public List<Free> getFrees(int page) {
		
		return getFrees(page, "");
	}

	@Override
	public int insert(Free free) {
		String sql1 = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM FREEBOARDS";
		String sql = "INSERT INTO FREEBOARDS(CODE, WRITER, REGDATE, TITLE, CONTENTS, HIT, THUMB, AUTHORITY) VALUES(?, ?, Getdate(), ?, ?, 0, 0, 'B')";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			Statement stCode = con.createStatement();
			ResultSet rs = stCode.executeQuery(sql1);
			
			rs.next();
			String code = rs.getString("CODE"); 
					
			rs.close();
			stCode.close();
			
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, code);
			st.setString(2, free.getWriter());
			st.setString(3, free.getTitle());
			st.setString(4, free.getContents());

			int result = st.executeUpdate(); // 실행했을때 영향받는 row 수

			st.close();
			con.close();

			return result;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(Free free) {
		String sql = "UPDATE FREEBOARDS SET TITLE=?, CONTENTS=? WHERE CODE=?";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			PreparedStatement st = con.prepareStatement(sql);
		
			st.setString(1, free.getTitle());
			st.setString(2, free.getContents());
			st.setString(3, free.getCode());
			
			int result = st.executeUpdate();
			
			st.close();
			con.close();
			
			return result;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(String code) {
		String sql = "DELETE FROM FREEBOARDS WHERE CODE=?";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, code);
						
			int result = st.executeUpdate();

			st.close();
			con.close();

			return result;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getSize(String query, String field) {
		String sql = "SELECT COUNT(*) CNT FROM FREEBOARDS WHERE "+ field +" LIKE ?";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%"+ query +"%");
			
			ResultSet rs = st.executeQuery();
	
			// 모델마련하기
			rs.next();
			
			int size = rs.getInt("CNT");
			
			
			rs.close();
			st.close();
			con.close();
			
			return size;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getSize(String query) {
		
		return getSize(query, "TITLE");
	}

	@Override
	public String lastCode() {
		String sql = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0) Code  FROM FREEBOARDS";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			rs.next();
			String code = rs.getString("Code");
		
			
			rs.close();
			st.close();
			con.close();
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Free prevFree(String curCode) {
		String sql = "SELECT TOP 1 * FROM FREEBOARDS"
				+ " WHERE REGDATE > (SELECT REGDATE FROM FREEBOARDS WHERE CODE = ?) "
				+ " ORDER BY REGDATE ASC";
	String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
	
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, curCode);
		ResultSet rs = st.executeQuery();

		rs.next();
		
		Free fr = new Free();
		fr.setCode(rs.getString("CODE"));
		fr.setWriter(rs.getString("WRITER"));
		fr.setRegdate(rs.getDate("REGDATE"));
		fr.setTitle(rs.getString("TITLE"));
		fr.setContents(rs.getString("CONTENTS"));
		fr.setHit(rs.getInt("HIT"));
		fr.setThumb(rs.getInt("THUMB"));
		fr.setAuthority(rs.getString("AUTHORITY"));
		
		rs.close();
		st.close();
		con.close();
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}

	@Override
	public Free nextFree(String curCode) {
		String sql = "SELECT TOP 1 * FROM FREEBOARDS "
				+ " WHERE REGDATE < (SELECT REGDATE FROM FREEBOARDS WHERE CODE = ?) "
				+ " ORDER BY REGDATE DESC";
		
		
		
	String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
	
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, curCode);
		ResultSet rs = st.executeQuery();

		rs.next();
		
		Free fr = new Free();
		fr.setCode(rs.getString("CODE"));
		fr.setWriter(rs.getString("WRITER"));
		fr.setRegdate(rs.getDate("REGDATE"));
		fr.setTitle(rs.getString("TITLE"));
		fr.setContents(rs.getString("CONTENTS"));
		fr.setHit(rs.getInt("HIT"));
		fr.setThumb(rs.getInt("THUMB"));
		fr.setAuthority(rs.getString("AUTHORITY"));
		
			
		rs.close();
		st.close();
		con.close();
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	}
	
	
}
