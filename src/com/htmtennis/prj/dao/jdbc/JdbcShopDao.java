package com.htmtennis.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htmtennis.prj.dao.ShopDao;

import com.htmtennis.prj.model.Shop;


public class JdbcShopDao implements ShopDao{

	@Override
	public Shop getShop(String code) {
		String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=tennisdb";
		String sql = "SELECT * FROM LinkShops WHERE CODE = '"+ code+"'";
		

			try {
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				Connection con = DriverManager.getConnection(url, "tennis", "tennis89"); 
			      Statement st = con.createStatement(); 
			      ResultSet rs = st.executeQuery(sql);     
				
				rs.next();
				
				//모델 마련하기
				Shop s = new Shop();
				
				s.setCode(rs.getString("code"));
				s.setName(rs.getString("name"));
				s.setAddress(rs.getString("address"));
				s.setPhoneNumber(rs.getString("phoneNumber"));
			    s.setSite(rs.getString("site"));
			  	
				
			  	rs.close();
				st.close();
				con.close();
				return s;
				
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
	public List<Shop> getShops(int page, String query, String field) {
		int start=1+(page-1)*20;
	    int end= 20+(page-1)*20;
		
		/*String sql = "SELECT *FROM (SELECT ROWNUM NUM, NO.* FROM ( "
	            + "SELECT * FROM NOTICES WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) NO) "
	            + "WHERE NUM BETWEEN ? AND ?";*/
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/
	    /*String sql = "SELECT * FROM NOTICES";*/
	    String sql = "SELECT N.* FROM("
	             + "SELECT (ROW_NUMBER() OVER(ORDER BY site DESC)"
	             + ")NUM, LinkShops.* FROM LinkShops WHERE "+field+" LIKE ?) N "
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
				
			    List<Shop> list = new ArrayList<Shop>();
				
			    while(rs.next())
			    {
					//모델 마련하기
					Shop s = new Shop();
					
					s.setCode(rs.getString("code"));
					s.setName(rs.getString("name"));
					s.setAddress(rs.getString("address"));
					s.setPhoneNumber(rs.getString("phoneNumber"));
				    s.setSite(rs.getString("site"));
					
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
	public List<Shop> getShops(int page, String query) {
		return getShops(page, query, "name");
		
	}

	@Override
	public List<Shop> getShops(int page) {
		return getShops(page, "");
		
	}

	@Override
	public int insert(Shop shop) {
		String sqlCode = "SELECT NVL(TO_NUMBER(MAX(CODE)), 0)+1 CODE FROM LinkShops";	/*코드를생성하기위해*/
        String sql = "INSERT INTO LinkShops(CODE, name, address, phoneNumber, site) VALUES(?,?,?,?,?)";

        //String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
        String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=newlecdb";
        try {
           //Class.forName("oracle.jdbc.driver.OracleDriver");
   	 		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
           
           Statement stCode=con.createStatement();
           ResultSet rs=stCode.executeQuery(sqlCode);
           rs.next();
           String code=rs.getString("CODE");
           
           rs.close();
           stCode.close();
           
           PreparedStatement st = con.prepareStatement(sql);
           st.setString(1, code);
           st.setString(2, shop.getName());
           st.setString(3, shop.getAddress());
           st.setString(4, shop.getPhoneNumber());

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
	public int update(Shop shop) {
		String sql = "UPDATE LinkShops SET name=?, address=? WHERE code=?";

        //String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
        String url = "jdbc:sqlserver://win.newlecture.com:1433;datebaseName=newlecdb";
        try {
          // Class.forName("oracle.jdbc.driver.OracleDriver");
       	 	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
           PreparedStatement st = con.prepareStatement(sql);
           st.setString(1, shop.getName());
           st.setString(2, shop.getAddress());
           st.setString(3, shop.getCode());

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
		String sql = "DELETE FROM LinkShops WHERE code=?";

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
		String sql = "SELECT COUNT(*) CNT FROM LinkShops WHERE "+ field +" LIKE ?";
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