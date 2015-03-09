package com.newlecture.jspprj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.newlecture.jspprj.dao.MemberDao;
import com.newlecture.jspprj.model.Member;
import com.newlecture.jspprj.model.Notice;

public class JdbcMemberDao implements MemberDao{


	@Override
	public int insert(Member member) {		

		String sql = "insert into Members(mid,uid,pwd,name,nicname,photo,gender,birth,islunar,phone,email) values(3,?,?,?,?,?,?,?,?,?,?)";
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/ //oracle
	      String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb"; // mssql
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,"sist","newlec"); //연결

			/*Statement stcode = con.createStatement();*/
			PreparedStatement st = con.prepareStatement(sql); // 문장실행 //preparedStatement 값을꽂아줌 꽂을값이 있으면 프리페얼드
			
			st.setString(1, member.getUid());
		    st.setString(2, member.getPwd());
		    st.setString(3, member.getName());
		    st.setString(4, member.getNicname());
		    st.setString(5, member.getPhoto());
		    st.setString(6, member.getGender());
		    st.setString(7, member.getBirth());
		    st.setString(8, member.getIslunar());
		    st.setString(9, member.getPhone());
		    st.setString(10, member.getEmail());
		    
			
			//ResultSet rs = st.executeQuery();

			//rs.next();

			//String code = rs.getString("CODE");
		    
		    
		    
		    
		    int result = st.executeUpdate();
		    
		    //rs.close();
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
	public int update(Member Member) {
		// TODO Auto-generated method stub
		String sql = "update Members set TITLE = ?,CONTENT = ? where code =? ";
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/ //oracle
	      String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb"; // mssql
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,"sist","newlec"); //연결
		    PreparedStatement st = con.prepareStatement(sql); // 문장실행, 값을 꽂아야함
		    
		    st.setString(1, Member.getUid());
		    st.setString(2, Member.getName());
		    st.setString(3, Member.getPwd());
		    
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




//////////////////////

	@Override
	public List<Member> getMembers(String uid, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getMembers(String uid, String name, String email,
			String birth, String gender) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int delete(String code) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member getMember(String uid) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

