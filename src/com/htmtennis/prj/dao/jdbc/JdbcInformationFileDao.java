package com.htmtennis.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htmtennis.prj.dao.InformationFileDao;
import com.htmtennis.prj.model.InformationFile;

public class JdbcInformationFileDao implements InformationFileDao{

	@Override
	public List<InformationFile> getInformationFiles(String informationCode) {
		
		String sql = "select * from InformationFiles";

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
				
			    List<InformationFile> list = new ArrayList<InformationFile>();
				
			    while(rs.next())
			    {
					//모델 마련하기
					InformationFile inf = new InformationFile();
					
					inf.setFilename(rs.getString("filename"));
					inf.setInformationcode(rs.getString("informationcode"));
					inf.setRegdate(rs.getDate("regdate"));
					inf.setFilesrc(rs.getString("filesrc"));
				  	
					
				  	list.add(inf);
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
	public int insert(InformationFile file) {
		
		String sqlCode = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM INFORMATIONSFILES";	/*코드를생성하기위해*/
        String sql = "INSERT INTO INFORMATIONSFILES(FILENAME, INFORMATIONSCODE, REGDATE, FILESRC) VALUES(?,?,GETDATE(),?,?)";

        String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
           
           Statement stCode=con.createStatement();
           ResultSet rs=stCode.executeQuery(sqlCode);
           
           rs.next();
           
           String code=rs.getString("INFORMATIONSCODE");
           
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
