<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head id="Head1" runat="server">
    <title>社交网站</title>
   <link href="<%=request.getContextPath() %>/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
   <script> 
	function add(){
		var subject = $("#subject").attr("value");
		var content = $("#content").attr("value");
		if(subject.length == 0){
			alert("题目不能为空");
			return false;
		}
		if(content.length == 0){
			alert("内容不能为空");
			return false;
		}
	
			
	}
</script>
</head>
<body>
 
    <div>
 <jsp:include flush="true" page="head.jsp"></jsp:include>
<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="252" height="393" valign="top" class="leftbg">
	<jsp:include flush="true" page="left.jsp"></jsp:include>
	</td>
    <td width="748" valign="top">
	&nbsp;&nbsp;<a href="diarytoadd_admin">我要写日记
    </a><br />
	 <table width="98%"  border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC" class="border">
  <tr class="title_top">
    <td width="76%" align="center" bgcolor="#FFFFFF"><strong>题目</strong></td>
    <td width="24%" bgcolor="#FFFFFF"><div align="center">操作</div></td>
  </tr>

<c:forEach items="${pi.list}" var="obj" varStatus="con">
  <tr class="tdbg">
    
    <td bgcolor="#FFFFFF"><div align="center">${obj.subject}</div></td>
    <td bgcolor="#FFFFFF"><div align="center"><a href="<%=request.getContextPath() %>/diarydelete_admin?par.id=${obj.id }" onClick="return confirm('确定删除吗？')">删除</a>&nbsp;&nbsp;<a href="diary_detail?mvo.id=${obj.id }">浏览</a></div></td>
	</tr>
		</c:forEach>
</table>

<div align="center">
	<jsp:include page="/pageinfo.jsp">
									<jsp:param value="diarylist_admin" name="path"/>
  </jsp:include>
</div>
    </td>
  </tr>
</table>
<jsp:include flush="true" page="foot.jsp"></jsp:include>

</body>
</html>