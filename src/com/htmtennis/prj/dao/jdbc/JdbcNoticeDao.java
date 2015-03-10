package com.htmtennis.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htmtennis.prj.dao.NoticeDao;
import com.htmtennis.prj.model.Notice;

public class JdbcNoticeDao implements NoticeDao {

	@Override
	public Notice getNotice(String code) {
		
		
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		String sql = "SELECT * FROM NOTICEBOARDS WHERE CODE = '"+ code+"'";
		

			try {
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				Connection con = DriverManager.getConnection(url, "tennis", "tennis89"); 
			      Statement st = con.createStatement(); 
			      ResultSet rs = st.executeQuery(sql);     
				
				rs.next();
				
				//모델 마련하기
				Notice n = new Notice();
				
				n.setCode(rs.getString("code"));
				n.setTitle(rs.getString("title"));
				n.setRegdate(rs.getDate("regdate"));
				n.setWriter(rs.getString("writer"));
			    n.setHit(rs.getInt("hit"));
			    
			  	n.setContents(rs.getString("contents"));
				n.setAuthority(rs.getString("Authority"));
			  	
			  	
			  	
			  	rs.close();
				st.close();
				con.close();
				return n;
				
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
	public Notice prevtNotice(String curCode) {
		
		
		String sql ="SELECT TOP 1"
				+ " *FROM NOTICEBOARDS WHERE REGDATE >"
				+ " (SELECT REGDATE FROM NOTICEBOARDS WHERE CODE=?)"
                + " ORDER BY REGDATE ASC; ";
		
		
		
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
	
		

			try {
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				Connection con = DriverManager.getConnection(url, "tennis", "tennis89"); 
			      PreparedStatement st = con.prepareStatement(sql); 
			      st.setString(1, curCode);
			      ResultSet rs = st.executeQuery();     
				
				rs.next();
				
				//모델 마련하기
			
				
                Notice n = new Notice();
				
                n.setCode(rs.getString("code"));
				n.setTitle(rs.getString("title"));
				n.setRegdate(rs.getDate("regdate"));
				n.setWriter(rs.getString("writer"));
			    n.setHit(rs.getInt("hit"));
			 
			  	n.setContents(rs.getString("contents"));
				n.setAuthority(rs.getNString("Authority"));
				
				
				
				
				
				
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
	public Notice nextNotice(String curCode) {
		
		
		String sql ="SELECT TOP 1 "
				+ " *FROM NOTICEBOARDS WHERE REGDATE <"
				+ " (SELECT REGDATE FROM NOTICEBOARDS WHERE CODE=?)"
                + " ORDER BY REGDATE DESC; ";
		
		
		
		
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		

		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connection con = DriverManager.getConnection(url, "tennis", "tennis89"); 
		      PreparedStatement st = con.prepareStatement(sql); 
		      st.setString(1, curCode);
		      ResultSet rs = st.executeQuery();     
			
			rs.next();
			
			//모델 마련하기
		
			Notice n = new Notice();
			
            n.setCode(rs.getString("code"));
			n.setTitle(rs.getString("title"));
			n.setRegdate(rs.getDate("regdate"));
			n.setWriter(rs.getString("writer"));
		    n.setHit(rs.getInt("hit"));
		    
		  	n.setContents(rs.getString("contents"));
			n.setAuthority(rs.getNString("Authority"));
			
			
			
			
			
			
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
	public List<Notice> getNotices(int page, String query, String field) {
		
		
		int start=1+(page-1)*20;
	    int end= 20+(page-1)*20;
		
		
	    String sql = "SELECT N.* FROM ( "
				+" SELECT ( ROW_NUMBER() OVER (ORDER BY REGDATE DESC) ) NUM, NOTICEBOARDS.* "
				+" FROM NOTICEBOARDS WHERE "+ field +" LIKE ? ) N "
				+" WHERE N.NUM BETWEEN ? AND ?";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";

			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				Connection con = DriverManager.getConnection(url, "tennis", "tennis89"); 
			  
				
				
				
				
				PreparedStatement st = con.prepareStatement(sql); 
			   st.setString(1, "%"+query+"%");
			    st.setInt(2, start);
		        st.setInt(3, end);
			    
			    ResultSet rs = st.executeQuery();     
				
			    List<Notice> list = new ArrayList<Notice>();
				
			    while(rs.next())
			    {
					//모델 마련하기
					Notice n = new Notice();
					
					n.setCode(rs.getString("code"));
					n.setTitle(rs.getString("title"));
					n.setRegdate(rs.getDate("regdate"));
					n.setWriter(rs.getString("writer"));
				    n.setHit(rs.getInt("hit"));
				    
				  	n.setContents(rs.getString("contents"));
				  	n.setAuthority(rs.getString("Authority"));
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
	public List<Notice> getNotices(int page, String query) {
		
		return getNotices(page, query, "Title");
	}

	@Override
	public List<Notice> getNotices(int page) {
		
		return getNotices(page, "");
	}

	
	
	
	
	
	@Override
	public int insert(Notice notice) {
		String sql1 = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM NOTICEBOARDS";
		String sql = "INSERT INTO NOTICEBOARDS(CODE, WRITER, REGDATE, TITLE, CONTENTS, HIT, AUTHORITY) VALUES(?, ?, Getdate(), ?, ?, 0, 'A')";
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
			st.setString(2, notice.getWriter());
			st.setString(3, notice.getTitle());
			
			st.setString(4, notice.getContents());

			int result = st.executeUpdate(); // 실행했을때 영향받는 row 수

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
	public int update(Notice notice) {
		
		 String sql = "UPDATE NoticeBoards SET TITLE=?, CONTENT=? WHERE CODE=?";

         //String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
         String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
         try {
           // Class.forName("oracle.jdbc.driver.OracleDriver");
        	 	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, notice.getTitle());
            st.setString(2, notice.getContents());
            st.setString(3, notice.getCode());

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
		
		String sql = "DELETE FROM NoticeBoards WHERE CODE=?";

        //String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
        String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
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
		String sql = "SELECT COUNT(*) CNT FROM NoticeBoards WHERE "+ field +" LIKE ?";
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
		
		return getSize(query, "TITLE");
	}
	
	
	
	
	@Override
	public String lastCode() {
		
		
String sql = "SELECT ISNULL(MAX(CAST(CODE AS INT)),0) Code FROM NoticeBoards";
		
		
		
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		
		

			try {
				//Class.forName("oracle.jdbc.driver.OracleDriver");
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
				Connection con = DriverManager.getConnection(url, "tennis", "tennis89"); 
			      Statement st = con.createStatement(); 
			     
			  
			      ResultSet rs= st.executeQuery(sql);
			      
			      String code = rs.getString("Code");
			      
			      rs.next();
			      
			     
			      
				st.close();
				con.close();
				
				return code;
			
				
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
