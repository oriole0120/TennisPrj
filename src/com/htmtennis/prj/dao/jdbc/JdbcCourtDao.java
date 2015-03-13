package com.htmtennis.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htmtennis.prj.model.Court;
import com.htmtennis.prj.dao.CourtDao;
import com.htmtennis.prj.model.Court;

public class JdbcCourtDao implements CourtDao{

	@Override
	public Court getCourt(String code) {
		String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=tennisdb";
		String sql = "SELECT * FROM LinkCourts WHERE CODE = '"+ code+"'";
		

			try {
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				Connection con = DriverManager.getConnection(url, "tennis", "tennis89"); 
			      Statement st = con.createStatement(); 
			      ResultSet rs = st.executeQuery(sql);     
				
				rs.next();
				
				//모델 마련하기
				Court c = new Court();
				
				c.setCode(rs.getString("code"));
				c.setName(rs.getString("name"));
				c.setAddress(rs.getString("address"));
				c.setPhoneNumber(rs.getString("phoneNumber"));
			    c.setSite(rs.getString("site"));
			    c.setPositionX(rs.getInt("positionX"));
			    c.setPositionY(rs.getInt("positionY"));
				
			  	rs.close();
				st.close();
				con.close();
				return c;
				
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
	public List<Court> getCourts(int page, String query, String field) {
		int start=1+(page-1)*20;
	    int end= 20+(page-1)*20;
		
		/*String sql = "SELECT *FROM (SELECT ROWNUM NUM, NO.* FROM ( "
	            + "SELECT * FROM NOTICES WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) NO) "
	            + "WHERE NUM BETWEEN ? AND ?";*/
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/
	    /*String sql = "SELECT * FROM NOTICES";*/
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
				
			    List<Court> list = new ArrayList<Court>();
				
			    while(rs.next())
			    {
					//모델 마련하기
					Court c = new Court();
					
					c.setCode(rs.getString("code"));
					c.setName(rs.getString("name"));
					c.setAddress(rs.getString("address"));
					c.setPhoneNumber(rs.getString("phoneNumber"));
				    c.setSite(rs.getString("site"));
				    c.setPositionX(rs.getInt("positionX"));
				    c.setPositionY(rs.getInt("positionY"));
					
				  	list.add(c);
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
	public List<Court> getCourts(int page, String query) {
		return getCourts(page, query, "name");
		
	}

	@Override
	public List<Court> getCourts(int page) {
		return getCourts(page, "");
		
	}

	@Override
	public int insert(Court court) {
		String sqlCode = "SELECT isnull(MAX(CAST(CODE as int)),0)+1 CODE FROM LinkCourts";
		
        String sql = "INSERT INTO LinkCourts(code, name, address, phoneNumber, site, positionX, positionY) VALUES(?,?,?,?,?,?,?)";

        //String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
        String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=newlecdb";
        try {
           //Class.forName("oracle.jdbc.driver.OracleDriver");
   	 		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
           
           Statement stCode=con.createStatement();
           ResultSet rs=stCode.executeQuery(sqlCode);
           rs.next();
           String code=rs.getString("code");
           
           rs.close();
           stCode.close();
           
           PreparedStatement st = con.prepareStatement(sql);
           st.setString(1, code);
           st.setString(2, court.getName());
           st.setString(3, court.getAddress());
           st.setString(4, court.getPhoneNumber());
           st.setString(5, court.getSite());
           st.setInt(6, court.getPositionX());
           st.setInt(7, court.getPositionY());
           

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
	public int update(Court court) {
		String sql = "UPDATE LinkCourts SET name=?, address=? WHERE code=?";

        //String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
        String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=newlecdb";
        try {
          // Class.forName("oracle.jdbc.driver.OracleDriver");
       	 	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
           PreparedStatement st = con.prepareStatement(sql);
           st.setString(1, court.getName());
           st.setString(2, court.getAddress());
           st.setString(3, court.getCode());

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
		 String sql = "DELETE FROM LinkCourts WHERE code=?";

         //String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
         String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=newlecdb";
         try {
            //Class.forName("oracle.jdbc.driver.OracleDriver");
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
		String sql = "SELECT COUNT(*) CNT FROM LinkCourts WHERE "+ field +" LIKE ?";
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
		return getSize(query, "name");
		
	}

}
