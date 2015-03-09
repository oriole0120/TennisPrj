package com.htmtennis.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htmtennis.prj.dao.PhotoFileDao;
import com.htmtennis.prj.model.PhotoFile;

public class JdbcPhotoFileDao implements PhotoFileDao{

	@Override
	public List<PhotoFile> getPhotoFiles(String code) {
		String sql = "SELECT * FROM PHOTOBOARDS WHERE CODE = ?";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			PreparedStatement st = con.prepareStatement(sql);
								
			st.setString(1, code);
						
			ResultSet rs = st.executeQuery();

			List<PhotoFile> list = new ArrayList<PhotoFile>();
			
			while(rs.next()){
						
				PhotoFile phF = new PhotoFile();
				phF.setPhotoName(rs.getString("PHOTONAME"));
				phF.setPhotoCode(rs.getString("PHOTOCODE"));
				phF.setRegdate(rs.getDate("REGDATE"));
				phF.setFileSize(rs.getString("FILESIZE"));  
				phF.setFileSrc(rs.getString("FILESRC"));
				
				list.add(phF);
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
	public int insert(PhotoFile file) {
		String sql1 = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM PHOTOFILES";
		String sql = "INSERT INTO PHOTOFILES(PHOTONAME, PHOTOCODE, REGDATE, FILESIZE, FILESRC) VALUES(?, ?, getDate(), ?, ?)";
		String url = "jdbc:sqlserver://wiphF.newlecture.com:1433;databaseName=tennisdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			Statement stCode = con.createStatement();
			ResultSet rs = stCode.executeQuery(sql1);
			
			rs.next();
			String code = rs.getString("PHOTOCODE"); 
					
			rs.close();
			stCode.close();
			
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, file.getPhotoName());
			st.setString(2, code);
			st.setString(3, file.getFileSize());
			st.setString(4, file.getFileSrc());

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

	
}
