<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
�ܼ�${pi.sum }����¼,
��Ϊ${pi.sumpage}ҳ,
��ǰ${pi.page }ҳ &nbsp;
	    <a href="<%=request.getContextPath() %>/<%=request.getParameter("path") %>?pi.page=1">��ҳ</a>
	     <c:choose>
	     	<c:when test="${pi.page==1}">��һҳ</c:when>
	    	<c:otherwise>
	    		<a href="<%=request.getContextPath() %>/<%=request.getParameter("path") %>?pi.page=${pi.page-1 }">��һҳ</a>
	    	</c:otherwise>
	     </c:choose>
	   
	     <c:choose>
	     	<c:when test="${pi.sumpage==0||pi.sumpage==pi.page}">
	      		��һҳ
	      	</c:when>
	      	<c:otherwise>
	      		<a href="<%=request.getContextPath() %>/<%=request.getParameter("path") %>?pi.page=${pi.page+1 }">��һҳ</a>
	      	</c:otherwise>
	     </c:choose>
    	<a href="<%=request.getContextPath() %>/<%=request.getParameter("path") %>?pi.page=${pi.sumpage}">βҳ</a>
