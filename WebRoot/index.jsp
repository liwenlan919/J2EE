<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head id="Head1" runat="server">
    <title></title>
   <link href="<%=request.getContextPath() %>/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
 
    <div>
   <table width="1000" border="0" align="center">
  <tr>
    <td height="80" class="topbg"><img src="images/logos.jpg" width="366" height="47" /></td>
  </tr>
</table>
<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="252" height="393" valign="top" class="leftbg">
    <form method="post" action="memberslogin_admin">
	<table width="224" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="40" height="30">&nbsp;</td>
        <td width="184">&nbsp;</td>
      </tr>
      <tr>
        <td height="72" align="right">’À∫≈:</td>
        <td><label>
          <input name="par.username" type="text" class="input" />
        </label></td>
      </tr>
      <tr>
        <td height="30" align="right">√‹¬Î:</td>
        <td><label>
          <input name="par.password" type="password" class="input" />
        </label></td>
      </tr>
      <tr>
        <td height="74" colspan="2" align="center">
		<input type="image" src="images/logo.jpg" />
	
		</td>
		<%=request.getAttribute("message")==null?"":request.getAttribute("message") %>	
      </tr>
      <tr>
        <td height="50" colspan="2" align="center"><a href="members_add.jsp" target="_blank"><img src="images/reg.jpg" width="222"  border="0" height="44" /></a></td>
        </tr>
    </table>
	</form>
	
	</td>
    <td width="748"><div align="center"><img src="images/rightbg.jpg" width="663" height="280"/></div></td>
  </tr>
</table>
<jsp:include flush="true" page="foot.jsp"></jsp:include>

</body>
</html>