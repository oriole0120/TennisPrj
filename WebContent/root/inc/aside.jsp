<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<c:set var="ctxName" value="${pageContext.request.servletContext.contextPath}" />
     
            <aside id="side">
                <!--  aside menu part  -->
                <!--<h2 class="hidden">Menu</h2>-->
                <nav id="side-menu">
                    <ul class="clearfix">
                        <li class="side-menu-item"><a class="side-menu-text" href="${ctxName}/root/members/Notice/list.jsp">Notice</a></li>
                        <li class="side-menu-item"><a class="side-menu-text" href="">Tennis</a></li>

                        <li class="side-menu-item">
                            <a class="side-menu-text" href="">Community</a>
                            <ul>
                                <li class="side-menu-detail"><a class="side-menu-text" href="${ctxName}/root/members/Community/freeboard/list.jsp">Free</a>
                                <li class="side-menu-detail"><a class="side-menu-text" href="${ctxName}/root/members/Community/information/list.jsp">Info</a>
                            </ul>
                        </li>

                        <li class="side-menu-item">
                            <a class="side-menu-text" href="">Gallery</a>
                            <ul>
                                <li class="side-menu-detail"><a class="side-menu-text" href="${ctxName}/root/members/Gallery/photo/list.jsp">Photo</a>
                                <li class="side-menu-detail"><a class="side-menu-text" href="${ctxName}/root/members/Gallery/video/list.jsp">Video</a>
                            </ul>
                        </li>

                        <li class="side-menu-item"><a class="side-menu-text" href="${ctxName}/root/members/Schedule/list.jsp">Schedule</a></li>
                        <li class="side-menu-item"><a class="side-menu-text" href="${ctxName}/root/members/main.jsp">Link</a></li>
                    </ul>
                </nav>

            </aside>
