package com.htmtennis.prj.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisMain extends HttpServlet{
	
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		MyBatisMain.sqlSessionFactory = sqlSessionFactory;
	}
	
	public static void start() {
		InputStream ins;
		try {
			
			ins = Resources.getResourceAsStream("com/htmtennis/prj/dao/mybatis/mybatis-config.xml");
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = builder.build(ins);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void init() throws ServletException {
		
		InputStream ins;
		
		try {
			
			ins = Resources.getResourceAsStream("com/htmtennis/prj/dao/mybatis/mybatis-config.xml");
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = builder.build(ins);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
