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
    <td width="748">
      <s:form action="/diaryadd_admin" method="post"  onsubmit="return add();">
      <s:token></s:token>
    <table width="600" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
      <tr>
        <td width="92" height="47" align="right" bgcolor="#FFFFFF">题目：</td>
        <td width="498" bgcolor="#FFFFFF"><label>
          <input name="mvo.subject" type="text" size="40" id="subject" />
        </label></td>
      </tr>
      <tr>
        <td height="260" align="right" bgcolor="#FFFFFF">内容：</td>
        <td bgcolor="#FFFFFF"><textarea name="mvo.content" id="content" cols="60" rows="20"></textarea></td>
      </tr>
      <tr>
        <td height="36" colspan="2" align="center" bgcolor="#FFFFFF"><label>
          <input type="submit" name="Submit" value="提交" />
        </label></td>
        </tr>
    </table>
      </s:form>
    </td>
  </tr>
</table>
<jsp:include flush="true" page="foot.jsp"></jsp:include>

</body>
</html>