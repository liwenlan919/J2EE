<%@ page language="java" pageEncoding="utf-8"%>
<html>
  <head>
  	 <%
   	request.getSession().removeAttribute("user");
   	response.sendRedirect(request.getContextPath()+"/index.jsp");
   %>
  </head>
  
  <body>
  
  </body>
</html>
