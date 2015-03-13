<%@page import="com.htmtennis.prj.dao.jdbc.JdbcPhotoFileDao"%>
<%@page import="com.htmtennis.prj.dao.jdbc.JdbcPhotoDao"%>
<%@page import="com.htmtennis.prj.dao.PhotoFileDao"%>
<%@page import="com.htmtennis.prj.model.PhotoFile"%>
<%@page import="com.htmtennis.prj.dao.PhotoDao"%>
<%@page import="com.htmtennis.prj.model.Photo"%>
<%-- <%@page import="com.htmtennis.prj.dao.mybatis.MyBatisMain"%> --%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%

	/* out.println("ir1 : "+request.getParameter("ir1"));
	out.println("\ncontent!!!!!"); */

 	ServletContext ctx = request.getServletContext();
	String path = ctx.getRealPath("/root/members/Gallery/photo/upload");
	out.print(path + "<br />");

	MultipartRequest req = new MultipartRequest(request, path, 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());

	String title = req.getParameter("title");
	String filename = req.getFilesystemName("file");
	String content = req.getParameter("ir1");
	
	
	out.print(content);	
	
	Photo photo = new Photo();
	photo.setTitle(title);
	photo.setWriter("admin");
	photo.setContents(content);

	
	
	//if(filename != null)
	//	photo.setFileName(filename);
	/* SqlSession sqlSession = MyBatisMain.getSqlSessionFactory().openSession(true);
	PhotoDao photoDao = sqlSession.getMapper(PhotoDao.class); */
	
	 PhotoDao photoDao = new JdbcPhotoDao();
	photoDao.insert(photo);

	if (req.getFile("file") != null) {

		String photoCode = photoDao.lastCode();

		PhotoFile photoFile = new PhotoFile();
		photoFile.setPhotoName(filename);
		photoFile.setPhotoCode(photoCode);

		PhotoFileDao fileDao = new JdbcPhotoFileDao();
		fileDao.insert(photoFile);
	}
	//목록페이지로 이동
	response.sendRedirect("list.jsp"); 
%>	
	