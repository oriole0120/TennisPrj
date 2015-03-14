package com.htmtennis.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htmtennis.prj.dao.VideoFileDao;
import com.htmtennis.prj.model.VideoFile;

public class JdbcVideoFileDao implements VideoFileDao{

	@Override
	public List<VideoFile> getVideoFiles(String code) {
		String sql = "SELECT * FROM VIDEOBOARDS WHERE CODE = ?";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			PreparedStatement st = con.prepareStatement(sql);
								
			st.setString(1, code);
						
			ResultSet rs = st.executeQuery();

			List<VideoFile> list = new ArrayList<VideoFile>();
			
			while(rs.next()){
						
				VideoFile vF = new VideoFile();
				vF.setVideoName(rs.getString("VIDEONAME"));
				vF.setVideoCode(rs.getString("VIDEOCODE"));
				vF.setRegdate(rs.getDate("REGDATE"));
				vF.setFileSize(rs.getString("FILESIZE"));  
				vF.setFileSrc(rs.getString("FILESRC"));
				
				list.add(vF);
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
	public int insert(VideoFile file) {
		String sql1 = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM VIDEOFILES";
		String sql = "INSERT INTO VIDEOFILES(VIDEONAME, VIDEOCODE, REGDATE, FILESIZE, FILESRC) VALUES(?, ?, getDate(), ?, ?)";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			Statement stCode = con.createStatement();
			ResultSet rs = stCode.executeQuery(sql1);
			
			rs.next();
			String code = rs.getString("VIDEOCODE"); 
					
			rs.close();
			stCode.close();
			
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, file.getVideoName());
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
