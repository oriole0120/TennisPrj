<%@page import="com.htmtennis.prj.dao.jdbc.JdbcVideoFileDao"%>
<%@page import="com.htmtennis.prj.dao.mybatis.MyBatisMain"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.htmtennis.prj.dao.VideoFileDao"%>
<%@page import="com.htmtennis.prj.model.VideoFile"%>
<%@page import="com.htmtennis.prj.dao.VideoDao"%>
<%@page import="com.htmtennis.prj.model.Video"%>

<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%

	/* out.println("ir1 : "+request.getParameter("ir1"));
	out.println("\ncontent!!!!!"); */

 	ServletContext ctx = request.getServletContext();
	String path = ctx.getRealPath("/root/members/Gallery/video/upload");
	out.print(path + "<br />");

	MultipartRequest req = new MultipartRequest(request, path, 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());

	String title = req.getParameter("title");
	String filename = req.getFilesystemName("file");
	String content = req.getParameter("ir1");
	
	
	out.print(content);	
	
	Video video = new Video();
	video.setTitle(title);
	video.setWriter("admin");
	video.setContents(content);

	
	
	//if(filename != null)
	//	video.setFileName(filename);
	SqlSession sqlSession = MyBatisMain.getSqlSessionFactory().openSession(true);
	VideoDao videoDao = sqlSession.getMapper(VideoDao.class);
//	VideoFileDao fileDao = sqlSession.getMapper(VideoFileDao.class);
	
//	VideoDao videoDao = new JdbcVideoDao();
	VideoFileDao fileDao = new JdbcVideoFileDao();
	
	videoDao.insert(video);

	if (req.getFile("file") != null) {

		String videoCode = videoDao.lastCode();

		VideoFile videoFile = new VideoFile();
		videoFile.setVideoName(filename);
		videoFile.setVideoCode(videoCode);

		fileDao.insert(videoFile);
	}
	//목록페이지로 이동
	response.sendRedirect("list.jsp"); 
%>	
	