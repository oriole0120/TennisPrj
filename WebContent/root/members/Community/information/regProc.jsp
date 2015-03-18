
<%@page import="com.htmtennis.prj.dao.mybatis.MyBInformationDao"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcInformationFileDao"%>
<%@page import="com.htmtennis.prj.dao.InformationFileDao"%>
<%@page import="com.htmtennis.prj.model.InformationFile"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcInformationDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.htmtennis.prj.dao.InformationDao"%>
<%-- <%@page import="com.htmtennis.prj.dao.mybatis.MyBatisMain"%> --%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.htmtennis.prj.model.Information"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	ServletContext ctx = request.getServletContext();
	String path = ctx.getRealPath("/root/members/Community/information/upload");
	out.print(path + "<br />");

	/* MultipartRequest req = new MultipartRequest(request
							, path
							, 1024 * 1024 * 10
							, "UTF-8"
							, new DefaultFileRenamePolicy()); */

	String title = request.getParameter("title");
	/* String filename = request.getFilesystemName("file"); */
	String content = request.getParameter("content");
	
	/* out.print(path + "<br />");
	out.print(path + "<br />");
	out.print(path + "<br />"); */

	Information inf = new Information();
	
	inf.setTitle(title);
	inf.setWriter("admin");
	inf.setContents(content);
	
	/* if(filename)
		information.setFileName();  */

	/* SqlSession sqlSession = MyBatisMain.getSqlSessionFactory().openSession(true); */
		
	/* InformationDao informationDao = new JdbcInformationDao(); */
	InformationDao informationDao = new MyBInformationDao();
	informationDao.insert(inf);

	 /* if (request.getFile("file") != null) {

		String informationCode = informationDao.lastCode();

		InformationFile informationFile = new InformationFile();
		
		informationFile.setFilename(filename);
		informationFile.setInformationcode(informationCode);
		
		informationFile.setFilename(filename);
		informationFile.setFilesrc("");
		informationFile.setInformationcode(informationCode);

		InformationFileDao fileDao = new JdbcInformationFileDao();
		fileDao.insert(informationFile);
	} */
	//목록페이지로 이동
	response.sendRedirect("list.jsp");
%>	
	