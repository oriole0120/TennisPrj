<%-- <%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcPhotoFileDao"%>
<%@page import="com.htmtennis.prj.dao.PhotoFileDao"%>
<%@page import="com.htmtennis.prj.model.PhotoFile"%>

<%@page import="com.htmtennis.prj.dao.jdbc.JdbcPhotoDao"%>
<%@page import="com.htmtennis.prj.dao.PhotoDao"%>
<%@page import="com.htmtennis.prj.model.Photo"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
	ServletContext ctx = request.getServletContext();
	String path = ctx.getRealPath("upload");
	out.print(path + "<br />");

	MultipartRequest req = new MultipartRequest(request, path, 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());

	String title = req.getParameter("title");
	String filename = req.getFilesystemName("file");
	String content = req.getParameter("content");

	Photo notice = new Photo();
	notice.setTitle(title);
	notice.setWriter("deian");
	notice.setContent(content);
	//notice.setFile();

	PhotoDao noticeDao = new JdbcPhotoDao();
	noticeDao.insert(notice);

	if (req.getFile("file") != null) {

		String code = noticeDao.lastCode();

		PhotoFile photoFile = new PhotoFile();
		photoFile.setSrc(filename);
		photoFile.setCode(code);

		PhotoFileDao fileDao = new JdbcPhotoFileDao();
		fileDao.insert(photoFile);
	}
	//목록페이지로 이동
	response.sendRedirect("list.jsp");
%>	
	
	
	 --%>