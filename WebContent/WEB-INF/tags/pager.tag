<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="total" required="false" rtexprvalue="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.newlecture.com/jsp/tags/function" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="urlTokens" value="${fn:split(pageContext.request.requestURI, '?')}"/>
<%-- ${urlTokens[0]} --%>

    	<ul class="pager-list">
    	 
               <%--     <new:for var="i" count="5">
                        <c:forEach var="i" begin="1" end="5">
                        <c:if test="${empty param.page}"> --%>
                        
                        
                        <c:if test="${empty param.p}">
                        	<c:set var="page" value="1"></c:set>
                        </c:if>
						<c:if test="${not empty param.p}">
						     <c:set var="page" value="${param.p}"></c:set>
						</c:if>
						
							<c:set var="startNum" value="${page-(page-1)%5}" ></c:set>
						
						   <c:forEach begin="${startNum}" end="${startNum+4}" var="i" >

						<c:if test="${i <= f:lastNum(total) }">
							<c:if test="${page == i}">
						         <li class="page"><a class="text-highlight" 
						            href="list.jsp?page=${i}">${i}</a></li>      

						      	</c:if>
			
						      	<c:if test="${page != i}" >
						        	 <li class="page"><a  href="list.jsp?p=${i}&q=${param.q}&f=${param.f}">${i}</a></li>
						      		</c:if>
						      </c:if>
						      <c:if test="${i>f:lastNum(total)}">
						      	<c:if test="${page != i}">
						         <li class="page" >${i}</li>
						         
						      	</c:if>
						      </c:if>
						     
						   </c:forEach>
						</ul>
