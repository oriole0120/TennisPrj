package com.htmtennis.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htmtennis.prj.dao.ScheduleFileDao;
import com.htmtennis.prj.model.ScheduleFile;

public class JdbcScheduleFileDao implements ScheduleFileDao {

	@Override
	public List<ScheduleFile> getscheduleFiles(String ScheduleCode) {
		
		String sql = "select * from ScheduleFiles";

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
				
			    List<ScheduleFile> list = new ArrayList<ScheduleFile>();
				
			    while(rs.next())
			    {
					//모델 마련하기
			    	ScheduleFile s = new ScheduleFile();
					
					s.setSchedulename(rs.getString("Schedulename"));
					s.setSchedulecode(rs.getString("Schedulecode"));
					s.setRegdate(rs.getDate("regdate"));
					s.setSchedulesrc(rs.getString("Schedulesrc"));
				  	s.setSchedulevent(rs.getString("schedulevent"));
					
				  	list.add(s);
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
	public int insert(ScheduleFile file) {
		
		
		String sqlCode = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM SCHEDULEFILES";	/*코드를생성하기위해*/
        String sql = "INSERT INTO SCHEDULEFILES(SCHEDULENAME, SCHEDULECODE, REGDATE, SCHEDULESRC, SCHEDULEVENT) VALUES(?,?,GETDATE(),?,?,?)";

        String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
           
           Statement stCode=con.createStatement();
           ResultSet rs=stCode.executeQuery(sqlCode);
           
           rs.next();
           
           String code=rs.getString("SCHEDULECODE");
           
           rs.close();
           stCode.close();
           
           PreparedStatement st = con.prepareStatement(sql);
           st.setString(1, file.getSchedulename());
           st.setString(2, code);
           st.setString(3, file.getSchedulesrc());
           st.setString(4, file.getSchedulevent());
           

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
