package com.htmtennis.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htmtennis.prj.dao.FreeFileDao;
import com.htmtennis.prj.model.FreeFile;

public class JdbcFreeFileDao implements FreeFileDao{

	@Override
	public List<FreeFile> getFreeFiles(String freeCode) {
		
		String sql = "select * from FreeFiles";

		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";

			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				Connection con = DriverManager.getConnection(url, "tennis", "tennis89"); 
			    PreparedStatement st = con.prepareStatement(sql); 
			    /*st.setString(1, "%"+query+"%");
			    st.setInt(2, start);
			    st.setInt(3, end);
			    */
			    ResultSet rs = st.executeQuery();     
				
			    List<FreeFile> list = new ArrayList<FreeFile>();
				
			    while(rs.next())
			    {
					//모델 마련하기
					FreeFile fr = new FreeFile();
					
					fr.setFilename(rs.getString("filename"));
					fr.setFreecode(rs.getString("freecode"));
					fr.setRegdate(rs.getDate("regdate"));
					fr.setFilesrc(rs.getString("filesrc"));
				  	
					
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
	public int insert(FreeFile file) {
		
		String sqlCode = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM FREEFILES";	/*코드를생성하기위해*/
        String sql = "INSERT INTO FREEFILES(FILENAME, FREECODE, REGDATE, FILESRC) VALUES(?,?,GETDATE(),?,?)";

        String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
           
           Statement stCode=con.createStatement();
           ResultSet rs=stCode.executeQuery(sqlCode);
           
           rs.next();
           
           String code=rs.getString("FREECODE");
           
           rs.close();
           stCode.close();
           
           PreparedStatement st = con.prepareStatement(sql);
           st.setString(1, file.getFilename());
           st.setString(2, code);
           st.setString(3, file.getFilesrc());

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
