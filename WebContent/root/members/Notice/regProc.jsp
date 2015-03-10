
<%@page import="com.htmtennis.prj.dao.jdbc.jdbcNoticeFileDao"%>
<%@page import="com.htmtennis.prj.dao.NoticeFileDao"%>
<%@page import="com.htmtennis.prj.model.NoticeFile"%>
<%@page import="com.htmtennis.prj.dao.NoticeDao"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcNoticeDao"%>
<%@page import="com.htmtennis.prj.model.Notice"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<%-- <%@page import="com.htmtennis.prj.dao.mybatis.MyBatisMain"%> --%>
<%@page import="org.apache.ibatis.session.SqlSession"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	ServletContext ctx = request.getServletContext();
	String path = ctx.getRealPath("/root/members/Notice/upload");
	out.print(path + "<br />");

	MultipartRequest req = new MultipartRequest(request
							, path
							, 1024 * 1024 * 10
							, "UTF-8"
							, new DefaultFileRenamePolicy());

	String title = req.getParameter("title");
	String noticename = req.getFilesystemName("file");
	String content = req.getParameter("content");
	
	/* out.print(path + "<br />");
	out.print(path + "<br />");
	out.print(path + "<br />"); */

	Notice n = new Notice();
	
	n.setTitle(title);
	n.setWriter("deian");
	n.setContents(content);
	
	/* if(filename)
		free.setFileName();  */

	/* SqlSession sqlSession = MyBatisMain.getSqlSessionFactory().openSession(true); */
		
	
	NoticeDao noticeDao = new JdbcNoticeDao();
	noticeDao.insert(n);

	 if (req.getFile("file") != null) {

		 String noticecode = noticeDao.lastCode();
		 
		 NoticeFile noticeFile = new NoticeFile();
		 
		    noticeFile.setNoticename(noticename);
			noticeFile.setNoticecode(noticecode);
			
			NoticeFileDao fileDao = new jdbcNoticeFileDao();
			fileDao.insert(noticeFile);	
		 
	}
	
	
	

	//목록페이지로 이동
	response.sendRedirect("list.jsp");
%>	
	