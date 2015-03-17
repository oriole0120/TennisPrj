<%@page import="com.htmtennis.prj.dao.mybatis.MyBFreeDao"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcFreeDao"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcFreeFileDao"%>
<%@page import="com.htmtennis.prj.dao.FreeFileDao"%>
<%@page import="com.htmtennis.prj.model.FreeFile"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.htmtennis.prj.dao.FreeDao"%>
<%-- <%@page import="com.htmtennis.prj.dao.mybatis.MyBatisMain"%> --%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.htmtennis.prj.model.Free"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	ServletContext ctx = request.getServletContext();
	String path = ctx.getRealPath("/root/members/Community/freeboard/upload");
	out.print(path + "<br />");

	MultipartRequest req = new MultipartRequest(request
							, path
							, 1024 * 1024 * 10
							, "UTF-8"
							, new DefaultFileRenamePolicy());

	String title = req.getParameter("title");
	String filename = req.getFilesystemName("file");
	String content = req.getParameter("content");
	
	/* out.print(path + "<br />");
	out.print(path + "<br />");
	out.print(path + "<br />"); */

	Free fr = new Free();
	
	fr.setTitle(title);

	fr.setWriter("admin");
	fr.setContents(content);
	
	/* if(filename)
		free.setFileName();  */

	/* SqlSession sqlSession = MyBatisMain.getSqlSessionFactory().openSession(true); */
		
	FreeDao freeDao = new JdbcFreeDao();
	
	/* freeDao.insert(free); */
	freeDao.insert(fr);

	 if (req.getFile("file") != null) {

		String freeCode = freeDao.lastCode();

		FreeFile freeFile = new FreeFile();
		
		/* freeFile.setFilename(filename);
		freeFile.setFreecode(freeCode); */
		
		freeFile.setFilename(filename);
		freeFile.setFilesrc("");
		freeFile.setFreecode(freeCode);

		FreeFileDao fileDao = new JdbcFreeFileDao();
		fileDao.insert(freeFile);
	}
	//목록페이지로 이동
	response.sendRedirect("list.jsp");
%>	
	
