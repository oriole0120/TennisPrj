package com.htmtennis.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.htmtennis.prj.dao.JoinDao;
import com.htmtennis.prj.model.Join;


public class JdbcJoinDao implements JoinDao{

	/*@Override
	public Join getJoin(String mid) {
		String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=tennisdb";
		String sql = "SELECT * FROM LinkCourts WHERE CODE = '"+ mid+"'";
		

			try {
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				Connection con = DriverManager.getConnection(url, "tennis", "tennis89"); 
			      Statement st = con.createStatement(); 
			      ResultSet rs = st.executeQuery(sql);     
				
				rs.next();
				
				//모델 마련하기
				Join j = new Join();
				
				j.setMid(rs.getString("mid"));
				j.setPwd(rs.getString("pwd"));
				j.setName(rs.getString("name"));
				j.setEmail(rs.getString("email"));
			    j.setPhone(rs.getString("phone"));
			    j.setStudentNum(rs.getInt("studentNum"));
			    j.setAuthority(rs.getString("authority"));
			  	
				
			  	rs.close();
				st.close();
				con.close();
				
				return j;
				
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
	public List<Join> getJoins(int page, String query, String field) {
		int start=1+(page-1)*20;
	    int end= 20+(page-1)*20;
		
		String sql = "SELECT *FROM (SELECT ROWNUM NUM, NO.* FROM ( "
	            + "SELECT * FROM NOTICES WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) NO) "
	            + "WHERE NUM BETWEEN ? AND ?";
		String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
	    String sql = "SELECT * FROM NOTICES";
	    String sql = "SELECT N.* FROM("
	             + "SELECT (ROW_NUMBER() OVER(ORDER BY site DESC)"
	             + ")NUM, LinkCourts.* FROM LinkCourts WHERE "+field+" LIKE ?) N "
	             + "WHERE N.NUM BETWEEN ? AND ?";
	    
		String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=tennisdb";

			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				Connection con = DriverManager.getConnection(url, "tennis", "tennis89"); 
			    PreparedStatement st = con.prepareStatement(sql); 
			    st.setString(1, "%"+query+"%");
			    st.setInt(2, start);
			    st.setInt(3, end);
			    
			    ResultSet rs = st.executeQuery();     
				
			    List<Join> list = new ArrayList<Join>();
				
			    while(rs.next())
			    {
					//모델 마련하기
					Join j = new Join();
					
					j.setMid(rs.getString("mid"));
					j.setPwd(rs.getString("pwd"));
					j.setName(rs.getString("name"));
					j.setEmail(rs.getString("email"));
				    j.setPhone(rs.getString("phone"));
				    j.setStudentNum(rs.getInt("studentNum"));
				    j.setAuthority(rs.getString("authority"));
					
				  	list.add(j);
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
	public List<Join> getJoins(int page, String query) {
		return getJoins(page, query, "name");
		
	}

	@Override
	public List<Join> getJoins(int page) {
		return getJoins(page, "");
		
	}*/

	@Override
	public int insert(Join join) {

		String sqlMid = "SELECT NVL(TO_NUMBER(MAX(Mid)), 0)+1 Mid FROM Members";	/*코드를생성하기위해*/
        String sql = "INSERT INTO Members(mid, pwd, name, gender, studentNum, email, phone, authority) VALUES(?,?,?,?,?,?,?,'Associate')";


        //String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
        String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=tennisdb";
        try {
           //Class.forName("oracle.jdbc.driver.OracleDriver");
   	 		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
           
           Statement stCode=con.createStatement();
           ResultSet rs=stCode.executeQuery(sqlMid);
           
           rs.next();
           String mid=rs.getString("mid");
           
           rs.close();
           stCode.close();
           
           PreparedStatement st = con.prepareStatement(sql);
           st.setString(1, mid);
           st.setString(2, join.getPwd());
           st.setString(3, join.getName());
           st.setString(4, join.getGender());
           st.setInt(5, join.getStudentNum());
           st.setString(6, join.getEmail());
           st.setString(7, join.getPhone());
           
           //st.setString(7, join.getAuthority());

           

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
	public int update(Join join) {
		String sql = "UPDATE Members SET phone=?, email=? WHERE pwd=?";

        //String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
        String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=tennisdb";
        try {
          // Class.forName("oracle.jdbc.driver.OracleDriver");
       	 	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
           PreparedStatement st = con.prepareStatement(sql);
           st.setString(1, join.getPhone());
           st.setString(2, join.getEmail());
           st.setString(3, join.getPwd());

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
	public int delete(String mid) {
		String sql = "DELETE FROM Members WHERE mid=?";

        //String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
        String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=newlecdb";
        try {
           //Class.forName("oracle.jdbc.driver.OracleDriver");
       	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
           PreparedStatement st = con.prepareStatement(sql);
           
           st.setString(1, mid);

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
	public Join getJoin(String code) {
		return null;
		
	}



/*	@Override
	public int getSize(String query, String field) {
		return 0;
		
	}*/



	/*@Override
	public int getSize(String query) {
		return 0;
		
	}*/

}

/*탈퇴 /  가입 / 수정 / 회원정보*/
