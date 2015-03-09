package com.htmtennis.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htmtennis.prj.dao.InformationDao;
import com.htmtennis.prj.model.Free;
import com.htmtennis.prj.model.Information;

public class JdbcInformationDao implements InformationDao {

	@Override
	public Information getInformation(String code) {
		String sql = "SELECT * FROM INFORMATIONBOARDS WHERE CODE = '" + code + "' ";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis",
					"tennis89");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			// 모델마련하기
			rs.next();

			Information inf = new Information();
			inf.setCode(rs.getString("CODE"));
			inf.setWriter(rs.getString("WRITER"));
			inf.setRegdate(rs.getDate("REGDATE"));
			inf.setTitle(rs.getString("TITLE"));
			inf.setContents(rs.getString("CONTENTS"));
			inf.setHit(rs.getInt("HIT"));
			inf.setAuthority(rs.getString( "AUTHORITY"));

			rs.close();
			st.close();
			con.close();
			return inf;

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
	public List<Information> getInformations(int page, String query, String field) {
		int start = 1 + (page - 1) * 20; // (page-1)*20+1;
		int end = 20 + (page - 1) * 20; // page*20;

		String sql = "SELECT N.* FROM ( "
				+ " SELECT ( ROW_NUMBER() OVER (ORDER BY REGDATE DESC) ) NUM, INFORMATIONBOARDS.* "
				+ " FROM INFORMATIONBOARDS WHERE " + field + " LIKE ? ) N "
				+ " WHERE N.NUM BETWEEN ? AND ?";
		/*String sql = "SELECT N.* FROM ( "
				+" SELECT ( ROW_NUMBER() OVER (ORDER BY REGDATE DESC) ) NUM, FREEBOARDS.* "
				+" FROM FREEBOARDS WHERE "+ field +" LIKE ? ) N "
				+" WHERE N.NUM BETWEEN ? AND ?";*/

		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			PreparedStatement st = con.prepareStatement(sql);

			// st.setString(1,field);라고 넣으면 'field'라고 들어가므로 sql 직접 넣어준다

			st.setString(1, "%" + query + "%");
			st.setInt(2, start);
			st.setInt(3, end);

			ResultSet rs = st.executeQuery();

			List<Information> list = new ArrayList<Information>();

			// 모델마련하기
			while (rs.next()) {

				Information inf = new Information();
				inf.setCode(rs.getString("CODE"));
				inf.setWriter(rs.getString("WRITER"));
				inf.setRegdate(rs.getDate("REGDATE"));
				inf.setTitle(rs.getString("TITLE"));
				inf.setContents(rs.getString("CONTENTS"));
				inf.setHit(rs.getInt("HIT"));
				inf.setAuthority(rs.getString( "AUTHORITY"));

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
	public List<Information> getInformations(int page, String query) {

		return getInformations(page, query, "Title");
	}

	@Override
	public List<Information> getInformations(int page) {

		return getInformations(page, "");
	}

	@Override
	public int insert(Information Information) {
		String sql1 = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM INFORMATIONBOARDS";
		String sql = "INSERT INTO INFORMATIONBOARDS(CODE, TITLE, WRITER, CONTENT, REGDATE, HIT) VALUES(?,?,?,?,Getdate(), 0)";
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
			st.setString(2, Information.getTitle());
			st.setString(3, Information.getWriter());
			st.setString(4, Information.getContents());

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
	public int update(Information Information) {
		String sql = "UPDATE INFORMATIONBOARDS SET TITLE=?, CONTENT=? WHERE CODE=?";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, Information.getTitle());
			st.setString(2, Information.getContents());
			st.setString(3, Information.getCode());

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
		String sql = "DELETE FROM INFORMATIONBOARDS WHERE CODE=?";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";

		try {
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
		String sql = "SELECT COUNT(*) CNT FROM INFORMATIONBOARDS WHERE " + field
				+ " LIKE ?";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, "%" + query + "%");

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
		String sql = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0) Code  FROM INFORMATIONBOARDS";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis", "tennis89");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			rs.next();
			String code = rs.getString("Code");

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
	public Information prevInformation(String curCode) {
		String sql = "SELECT TOP 1 * FROM INFORMATIONBOARDS"
				+ " WHERE REGDATE > (SELECT REGDATE FROM INFOBOARDS WHERE CODE = ?) "
				+ " ORDER BY REGDATE ASC";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis",
					"tennis89");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, curCode);
			ResultSet rs = st.executeQuery();

			rs.next();

			Information inf = new Information();
			inf.setCode(rs.getString("CODE"));
			inf.setWriter(rs.getString("WRITER"));
			inf.setRegdate(rs.getDate("REGDATE"));
			inf.setTitle(rs.getString("TITLE"));
			inf.setContents(rs.getString("CONTENTS"));
			inf.setHit(rs.getInt("HIT"));
			inf.setAuthority(rs.getString( "AUTHORITY"));

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
	public Information nextInformation(String curCode) {
		String sql = "SELECT TOP 1 * FROM INFORMATIONBOARDS "
				+ " WHERE REGDATE < (SELECT REGDATE FROM INFOBOARDS WHERE CODE = ?) "
				+ " ORDER BY REGDATE DESC";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=tennisdb";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "tennis",
					"tennis89");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, curCode);
			ResultSet rs = st.executeQuery();

			rs.next();

			Information inf = new Information();
			inf.setCode(rs.getString("CODE"));
			inf.setWriter(rs.getString("WRITER"));
			inf.setRegdate(rs.getDate("REGDATE"));
			inf.setTitle(rs.getString("TITLE"));
			inf.setContents(rs.getString("CONTENTS"));
			inf.setHit(rs.getInt("HIT"));
			inf.setAuthority(rs.getString( "AUTHORITY"));

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

}
