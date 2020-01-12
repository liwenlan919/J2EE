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
 
    <div>
 <jsp:include flush="true" page="head.jsp"></jsp:include>
<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="252" height="393" valign="top" class="leftbg">
	<jsp:include flush="true" page="left.jsp"></jsp:include>
	</td>
    <td width="748">
      <s:form action="/jobadd_admin" method="post"  onsubmit="return add();">
      <s:token></s:token>
    <table width="600" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
      <tr>
        <td width="92" height="47" align="right" bgcolor="#FFFFFF">公司名称：</td>
        <td width="498" bgcolor="#FFFFFF"><label>
         ${resObj.firm}
        </label></td>
      </tr>
          <tr>
        <td width="92" height="47" align="right" bgcolor="#FFFFFF">职位：</td>
        <td width="498" bgcolor="#FFFFFF"><label>
          ${resObj.jobtitle}
        </label></td>
      </tr>
          <tr>
        <td width="92" height="47" align="right" bgcolor="#FFFFFF">招聘人数：</td>
        <td width="498" bgcolor="#FFFFFF"><label>
            ${resObj.num}
        </label></td>
      </tr>
          <tr>
        <td width="92" height="47" align="right" bgcolor="#FFFFFF">工资待遇：</td>
        <td width="498" bgcolor="#FFFFFF"><label>
          
           ${resObj.salary}
        </label></td>
      </tr>
      <tr>
        <td height="260" align="right" bgcolor="#FFFFFF">详细内容：</td>
        <td bgcolor="#FFFFFF">
        ${resObj.content}
        </td>
      </tr>
   
    </table>
      </s:form>
    </td>
  </tr>
</table>
<jsp:include flush="true" page="foot.jsp"></jsp:include>

</body>
</html>