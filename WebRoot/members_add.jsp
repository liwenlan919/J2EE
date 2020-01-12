<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head id="Head1" runat="server">
    <title>社交网站</title>
   <link href="<%=request.getContextPath() %>/style.css" rel="stylesheet" type="text/css" />
   <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
   <script> 
	function add(){
		var username = $("#username").attr("value");
		var password = $("#password").attr("value");
		var email = $("#email").attr("value");
		if(username.length == 0){
			alert("账号不能为空");
			return false;
		}
		if(password.length == 0){
			alert("密码不能为空");
			return false;
		}
		
		if(email.length == 0){
			alert("邮箱不能为空");
			return false;
		}
			
	}
</script>
</head>
<body>
 
    <div>
   <table width="1000" border="0" align="center">
</table>
<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="748"><div align="center">
    <s:form action="/membersadd_admin" method="post"  onsubmit="return add();">
					<s:token></s:token>
      <table width="500" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#4579AB">
        <tr>
          <td height="30" colspan="2" align="center" bgcolor="#FFFFFF">用户注册</td>
        </tr>
        <tr>
          <td width="133" height="30" align="right" bgcolor="#FFFFFF">用户名：</td>
          <td width="360" align="left" bgcolor="#FFFFFF"><input type="text" name="mvo.username"  id="username" /></td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">密码：</td>
          <td align="left" bgcolor="#FFFFFF"><input type="text" name="mvo.password" id="password" /></td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">邮箱：</td>
          <td align="left" bgcolor="#FFFFFF"><input type="text" name="mvo.email" id="email" /></td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">&nbsp;</td>
          <td bgcolor="#FFFFFF"><label><input class="button" type="submit" value="注册" />	</label></td>
        </tr>

        <tr>
          <td height="30" colspan="2" bgcolor="#FFFFFF">&nbsp;</td>
        </tr>
      </table>
      </s:form>
    </div></td>
  </tr>
</table>
<table width="1000" height="50" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="50" align="center">欢迎登录本网站</td>
  </tr>
</table>

</body>
</html>