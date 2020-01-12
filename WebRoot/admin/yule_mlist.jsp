<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>网站后台管理系统</title>
<%@ taglib uri="/struts-tags" prefix="s"%>

   <link href="<%=request.getContextPath() %>/admin/images/Css_Main.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	background-image: url(login1_08.gif);
	background-repeat: repeat-x;
	margin-bottom: 0px;
	font-family: "宋体";
	font-size: 12px;
	line-height: 1.5;
	font-weight: normal;
	color: #546D87;
	background-color: #BBD9F5;
}
-->
</style>

</head>
<body>
 
    <div>
    <table width="98%"  border="0" align="center" cellpadding="0" cellspacing="1" class="border">
  <tr>
    <td class="title_dh"><div align="center">
      <div align="center">娱乐管理</div>
    </div></td>
  </tr>

  <tr>
    <td class="tdbg"><div align="left"></div></td>
  </tr></form>
</table>

<table width="98%"  border="0" align="center" cellpadding="0" cellspacing="1" class="border">
  <tr class="title_top">
    <td width="11%" align="center"><div align="center"><strong>用户</strong></div></td>
    <td width="11%" align="center"><strong>题目</strong></td>
    <td width="14%"><div align="center">操作</div></td>
  </tr>

<c:forEach items="${pi.list}" var="obj" varStatus="con">
  <tr class="tdbg">
    
    <td>&nbsp;	${obj.uid}</td>
    <td><div align="center">${obj.subject}</div></td>
    <td><div align="center"><a href="<%=request.getContextPath() %>/yulemdelete_admin?par.id=${obj.id }" onClick="return confirm('确定删除吗？')">删除</a></div></td>
	</tr>
			</c:forEach>
</table>
<table width="98%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="40">
      <div align="center"></div></td>
  </tr>
</table>
<div align="center">
	<jsp:include page="/pageinfo.jsp">
									<jsp:param value="yulemlist_admin" name="path"/>
  </jsp:include>
</div>

    </div>

</body>
</html>