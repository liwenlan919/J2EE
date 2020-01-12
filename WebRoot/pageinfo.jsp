<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
总计${pi.sum }条记录,
分为${pi.sumpage}页,
当前${pi.page }页 &nbsp;
	    <a href="<%=request.getContextPath() %>/<%=request.getParameter("path") %>?pi.page=1">首页</a>
	     <c:choose>
	     	<c:when test="${pi.page==1}">上一页</c:when>
	    	<c:otherwise>
	    		<a href="<%=request.getContextPath() %>/<%=request.getParameter("path") %>?pi.page=${pi.page-1 }">上一页</a>
	    	</c:otherwise>
	     </c:choose>
	   
	     <c:choose>
	     	<c:when test="${pi.sumpage==0||pi.sumpage==pi.page}">
	      		下一页
	      	</c:when>
	      	<c:otherwise>
	      		<a href="<%=request.getContextPath() %>/<%=request.getParameter("path") %>?pi.page=${pi.page+1 }">下一页</a>
	      	</c:otherwise>
	     </c:choose>
    	<a href="<%=request.getContextPath() %>/<%=request.getParameter("path") %>?pi.page=${pi.sumpage}">尾页</a>
