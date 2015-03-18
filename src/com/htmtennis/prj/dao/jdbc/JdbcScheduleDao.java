package com.htmtennis.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htmtennis.prj.dao.ScheduleDao;
import com.htmtennis.prj.model.Schedule;

public class JdbcScheduleDao implements ScheduleDao {




	@Override
	public Schedule getSchedule(String code) {

		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		String sql = "SELECT * FROM SCHEDULES WHERE CODE = '"+ code +"' ";


		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89"); 
			Statement st = con.createStatement(); 
			ResultSet rs = st.executeQuery(sql);     

			rs.next();

			//모델 마련하기
			Schedule s = new Schedule();

			s.setCode(rs.getString("code"));
			s.setWriter(rs.getString("writer"));
			s.setRegdate(rs.getDate("regdate"));
			s.setEventdate(rs.getString("eventdate"));
			s.setTitle(rs.getString("title"));
			s.setContents(rs.getString("contents"));
			s.setAuthority(rs.getString("Authority"));



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
	public Schedule preSchedule(String curCode) {


		String sql ="SELECT TOP 1"
				+ " *FROM SCHEDULES WHERE REGDATE >"
				+ " (SELECT REGDATE FROM SCHEDULES WHERE CODE=?)"
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


			Schedule s = new Schedule();

			s.setCode(rs.getString("code"));
			s.setWriter(rs.getString("writer"));
			s.setRegdate(rs.getDate("regdate"));
			s.setEventdate(rs.getString("eventdate"));
			s.setTitle(rs.getString("title"));
			s.setContents(rs.getString("contents"));
			s.setAuthority(rs.getString("Authority"));


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
	public Schedule nextSchedule(String curCode) {

		String sql ="SELECT TOP 1 "
				+ " *FROM SCHEDULES WHERE REGDATE <"
				+ " (SELECT REGDATE FROM SCHEDULES WHERE CODE=?)"
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

			Schedule s = new Schedule();

			s.setCode(rs.getString("code"));
			s.setWriter(rs.getString("writer"));
			s.setRegdate(rs.getDate("regdate"));
			s.setEventdate(rs.getString("eventdate"));
			s.setTitle(rs.getString("title"));
			s.setContents(rs.getString("contents"));
			s.setAuthority(rs.getString("Authority"));


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
	public int insert(Schedule schedule) {

		String sql1 = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM SCHEDULES";
		String sql = "INSERT INTO Schedules(CODE, WRITER, REGDATE, EVENTDATE, TITLE, CONTENTS,  AUTHORITY) VALUES(?, ?, Getdate(),?, ?, ?,'A')";
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
			st.setString(2, "admin");
			st.setString(3, schedule.getEventdate());
			st.setString(4, schedule.getTitle());
			st.setString(5, schedule.getContents());

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
	public int update(Schedule schedule) {

		String sql = "UPDATE SCHEDULES SET TITLE=?, CONTENT=? WHERE CODE=?";

		//String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";
		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			PreparedStatement st = con.prepareStatement(sql);


			st.setString(1,schedule.getTitle());
			st.setString(2,schedule.getContents());
			st.setString(3,schedule.getCode());


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

		String sql = "DELETE FROM SCHEDULES WHERE CODE=?";

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

		String sql = "SELECT COUNT(*) CNT FROM SCHEDULES WHERE "+ field +" LIKE ?";
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

		String sql = "SELECT ISNULL(MAX(CAST(CODE AS INT)),0) Code FROM SCHEDULES";



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




	@Override
	public List<Schedule> getSchedules(int page, String query, String field) {


		int start=1+(page-1)*20;
		int end= 20+(page-1)*20;

		/*String sql = "SELECT *FROM (SELECT ROWNUM NUM, NO.* FROM ( "
	            + "SELECT * FROM NOTICES WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) NO) "
	            + "WHERE NUM BETWEEN ? AND ?";*/
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/
		/*String sql = "SELECT * FROM NOTICES";*/
		String sql = "SELECT N.* FROM("
				+ "SELECT (ROW_NUMBER() OVER(ORDER BY EVENTDATE DESC)"
				+ ")NUM, SCHEDULES.* FROM SCHEDULES WHERE "+field+" LIKE ?) N "
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

			List<Schedule> list = new ArrayList<Schedule>();

			while(rs.next())
			{
				//모델 마련하기
				Schedule s = new Schedule();

				s.setCode(rs.getString("code"));
				s.setWriter(rs.getString("writer"));
				s.setRegdate(rs.getDate("regdate"));
				s.setEventdate(rs.getString("eventdate"));
				s.setTitle(rs.getString("title"));
				s.setContents(rs.getString("contents"));
				s.setAuthority(rs.getString("authority"));

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
	public List<Schedule> getSchedules(int page, String query) {
		
		return getSchedules(page, query, "Title");
	}

	@Override
	public List<Schedule> getSchedules(int page) {
		return getSchedules(page,"");
	}









}
