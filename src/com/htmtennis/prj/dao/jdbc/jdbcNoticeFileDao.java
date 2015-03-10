package com.htmtennis.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htmtennis.prj.dao.NoticeFileDao;
import com.htmtennis.prj.model.NoticeFile;

public class jdbcNoticeFileDao implements NoticeFileDao{

	@Override
	public List<NoticeFile> getnoticeFiles(String noticeCode) {
		// TODO Auto-generated method stub
	
		String sql = "select * from NoticeFiles";

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
				
			    List<NoticeFile> list = new ArrayList<NoticeFile>();
				
			    while(rs.next())
			    {
					//모델 마련하기
			    	NoticeFile n = new NoticeFile();
					
					n.setNoticename(rs.getString("noticename"));
					n.setNoticecode(rs.getString("noticecode"));
					n.setRegdate(rs.getDate("regdate"));
					n.setNoticesrc(rs.getString("noticesrc"));
				  	
					
				  	list.add(n);
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
	public int insert(NoticeFile file) {
		
		String sqlCode = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM NOTICEFILES";	/*코드를생성하기위해*/
        String sql = "INSERT INTO NOTICEFILES(NOTICENAME, NOTICECODE, REGDATE, NOTICESRC) VALUES(?,?,GETDATE(),?,?)";

        String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
           
           Statement stCode=con.createStatement();
           ResultSet rs=stCode.executeQuery(sqlCode);
           
           rs.next();
           
           String code=rs.getString("NOTICECODE");
           
           rs.close();
           stCode.close();
           
           PreparedStatement st = con.prepareStatement(sql);
           st.setString(1, file.getNoticename());
           st.setString(2, code);
           st.setString(3, file.getNoticesrc());

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
