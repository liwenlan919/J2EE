<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head id="Head1" runat="server">
    <title>社交网站</title>
   <link href="<%=request.getContextPath() %>/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
 
    <div><div align="center"> 
 <jsp:include flush="true" page="head.jsp"></jsp:include> 
</div><table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="252" height="393" valign="top" class="leftbg" align="center"><jsp:include flush="true" page="left.jsp"></jsp:include>
	</td>
    <td width="748" valign="top"><div align="center">
   
      <table width="735" border="0">
        <tr>
          <td height="34" align="center">
          <form action="<%=request.getContextPath() %>/membersmlist_admin" method="post" style="border: 0">
			   		  		类别:
			   		<select name="par.cid">
			   		  <option value="u.username">名称</option>
			   		  <option value="u.university">学校</option>
			   		  <option value="u.hometown">家乡</option>
			   		</select>&nbsp;&nbsp;
			   		关键字：<input type="text" name="par.keyword"/>
			   		<input class="button" type="submit" value="查 询" />	
			   		</form>
          
          </td>
        </tr>
        <tr>
          <td height="80">
		  <c:forEach items="${pi.list}" var="obj" varStatus="con">
		  <table width="150" border="0" style="float:left;">

           <tr>
              <td height="26" align="center">姓名：${obj.uid}</a></td>
            </tr> 
            <tr>
              <td height="26" align="center"><a href="members_showUser?mvo.username=${obj.uid}">查看详情</a></td>
            </tr>                       
            <tr>
              <td align="center"><a href="Friendsshenhe_admin?par.id=${obj.id}">同意</a>&nbsp;&nbsp;<a href="Friendsdelete_admin?par.id=${obj.id}">拒绝</a></td>
            </tr>
          </table>
		  </c:forEach>
		  
		  </td>
        </tr>
      </table>
          </td>
  </tr>
</table>
<jsp:include flush="true" page="foot.jsp"></jsp:include>

</body>
</html>