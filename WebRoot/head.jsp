<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
   <table width="1000" border="0" align="center">
  <tr>
    <td height="80" class="topbg"><table width="998" border="0">
        <tr>
          <td width="456"><img src="images/logos.jpg" width="366" height="47" /></td>
          <td width="532"><%if(request.getSession().getAttribute("user") != null){%>
          <font color="white">
			��ӭ�û���½</font>
		${user.username} &nbsp;&nbsp; 
		<a href="loginout.jsp"><font color="white">�˳�</font></a> &nbsp;&nbsp;
		<a href="membersmlist_admin"><font color="white"></font></a>&nbsp;&nbsp;
		<a href="memberstoupdate_admin"><font color="white">�ҵ�����</font></a>&nbsp;&nbsp; 
		<a href="loginout.jsp"><font color="white">�˳�</font></a> &nbsp;&nbsp;
		<a href="Friendslist_admin"><font color="white">�鿴����</font></a>&nbsp;&nbsp;
		<a href="Friendsmlist_admin"><font color="white">��˺���</font></a>
        
        <%
		
	}

%></td>
        </tr>
      </table></td>
    </tr>
</table>
