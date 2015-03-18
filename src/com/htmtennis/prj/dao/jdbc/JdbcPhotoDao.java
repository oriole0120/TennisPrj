package com.htmtennis.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htmtennis.prj.dao.PhotoDao;
import com.htmtennis.prj.model.Photo;

public class JdbcPhotoDao implements PhotoDao {

	@Override
	public Photo getPhoto(String code) {
		
		String sql = "SELECT * FROM PHOTOBOARDS WHERE CODE = '"+code+"' ";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			rs.next();
		
			Photo ph = new Photo();
			ph.setCode(rs.getString("CODE"));
			ph.setWriter(rs.getString("WRITER"));
			ph.setRegdate(rs.getDate("REGDATE"));
			ph.setTitle(rs.getString("TITLE"));
			ph.setContents(rs.getString("CONTENTS"));
			ph.setHit(rs.getInt("HIT"));
			ph.setThumb(rs.getInt("THUMB"));
			ph.setAuthority(rs.getString("AUTHORITY"));
			
			rs.close();
			st.close();
			con.close();
			
			return ph;
			
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
	public List<Photo> getPhotos(int page, String query, String field) {
		
		int start	=  1+(page-1)*20;	
		int end 	= 20+(page-1)*20;
		
/*		String sql = "SELECT N.* FROM ( "
				+" SELECT ( ROW_NUMBER() OVER (ORDER BY REGDATE DESC) ) NUM, PHOTOBOARDS.* "
				+" FROM PHOTOBOARDS WHERE "+ field +" LIKE ? ) N "
				+" WHERE N.NUM BETWEEN ? AND ?";*/
		
		String sql = "SELECT PH.* FROM ("
				+ "		SELECT(ROW_NUMBER() OVER ( ORDER BY REGDATE DESC)) NUM, PHOTOBOARDS.* "
				+ "			FROM PHOTOBOARDS WHERE " + field + " LIKE ?) PH "
				+ "			WHERE PH.NUM BETWEEN ? AND ?"; 
		
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%"+ query +"%");
			st.setInt(2, start);
			st.setInt(3, end);
			
			ResultSet rs = st.executeQuery();
			List<Photo> list = new ArrayList<Photo>();
			
			while(rs.next()) {
				Photo ph = new Photo();
				ph.setCode(rs.getString("CODE"));
				ph.setWriter(rs.getString("WRITER"));
				ph.setRegdate(rs.getDate("REGDATE"));
				ph.setTitle(rs.getString("TITLE"));
				ph.setContents(rs.getString("CONTENTS"));
				ph.setHit(rs.getInt("HIT"));
				ph.setThumb(rs.getInt("THUMB"));
				ph.setAuthority(rs.getString("AUTHORITY"));
				
				list.add(ph);
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

	/*@Override
	public List<Photo> getPhotos(int page, String query) {
		
		return getPhotos(page, query, "TITLE");
	}

	@Override
	public List<Photo> getPhotos(int page) {
		
		return getPhotos(page, "");
	}*/

	@Override
	public int insert(Photo photo) {
		String sql1 = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM PHOTOBOARDS";
		String sql = "INSERT INTO PHOTOBOARDS(CODE, WRITER, REGDATE, TITLE, CONTENTS, HIT, THUMB, AUTHORITY) VALUES(?, ?, Getdate(), ?, ?, 0, 0, 'B')";
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
			st.setString(2, photo.getWriter());
			st.setString(3, photo.getTitle());
			st.setString(4, photo.getContents());
		
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
	public int update(Photo photo) {
		String sql = "UPDATE PHOTOBOARDS SET TITLE=?, CONTENTS=? WHERE CODE=?";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			PreparedStatement st = con.prepareStatement(sql);
		
			st.setString(1, photo.getTitle());
			st.setString(2, photo.getContents());
			st.setString(3, photo.getCode());
			
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
		String sql = "DELETE FROM PHOTOBOARDS WHERE CODE=?";
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
	public Photo prevPhoto(String curCode) {
		String sql = "SELECT TOP 1 * FROM PHOTOBOARDS"
				+ " WHERE REGDATE > (SELECT REGDATE FROM PHOTOBOARDS WHERE CODE = ?) "
				+ " ORDER BY REGDATE ASC";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, curCode);
			ResultSet rs = st.executeQuery();
			
			rs.next();
			
			Photo ph = new Photo();
			ph.setCode(rs.getString("CODE"));
			ph.setWriter(rs.getString("WRITER"));
			ph.setRegdate(rs.getDate("REGDATE"));
			ph.setTitle(rs.getString("TITLE"));
			ph.setContents(rs.getString("CONTENTS"));
			ph.setHit(rs.getInt("HIT"));
			ph.setThumb(rs.getInt("THUMB"));
			ph.setAuthority(rs.getString("AUTHORITY"));
			
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
	public Photo nextPhoto(String curCode) {
		String sql = "SELECT TOP 1 * FROM PHOTOBOARDS "
				+ " WHERE REGDATE < (SELECT REGDATE FROM PHOTOBOARDS WHERE CODE = ?) "
				+ " ORDER BY REGDATE DESC";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, curCode);
			ResultSet rs = st.executeQuery();

			rs.next();
			
			Photo ph = new Photo();
			ph.setCode(rs.getString("CODE"));
			ph.setWriter(rs.getString("WRITER"));
			ph.setRegdate(rs.getDate("REGDATE"));
			ph.setTitle(rs.getString("TITLE"));
			ph.setContents(rs.getString("CONTENTS"));
			ph.setHit(rs.getInt("HIT"));
			ph.setThumb(rs.getInt("THUMB"));
			ph.setAuthority(rs.getString("AUTHORITY"));
			
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
	public int getSize(String query, String field) {
		String sql = "SELECT COUNT(*) CNT FROM PHOTOBOARDS WHERE " + field +" LIKE ?";	
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%"+ query +"%");
			ResultSet rs = st.executeQuery();
			
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

	/*@Override
	public int getSize(String query) {
		
		return getSize(query, "TITLE");
	}*/

	@Override
	public String lastCode() {
		String sql = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0) Code  FROM PHOTOBOARDS";
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
}
