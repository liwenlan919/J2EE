<%@ page pageEncoding="GB2312"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head id="Head1" runat="server">
    <title>网站后台管理系统</title>
   <link href="images/style.css" rel="stylesheet" type="text/css" />
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
<script language="JavaScript">
function CheckForm()
{
	if (document.form1.user.value.length == 0)
 {
		alert("请输入用户名.");
		document.form1.user.focus();
		return false;
	}
	if (document.form1.user.value.indexOf("<")!=-1 || document.form1.user.value.indexOf(">")!=-1)
{
		alert("用户名中包含非法字符 (<,>) ");
		document.form1.user.focus();
		return false;
	}
	if (document.form1.user.value.indexOf("'")!=-1)
{
		alert("用户名中包含非法字符 (') ");
		document.form1.user.focus();
		return false;
	}
	if (document.form1.pass.value.length == 0) 
{
		alert("请输入密码.");
		document.form1.pass.focus();
		return false;
	}

}
</script>
</head>
<body>
 
    <div>
    <form name="form1" method="post" action="<%=request.getContextPath() %>/adminlogin_admin" onSubmit="return CheckForm();">
    
    <table width="990" height="650" border="0" align="left" cellpadding="0" align="center" cellspacing="0" >
  <tr>
    <td width="318" valign="top">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="299" align="right"><img src="images/login1_01.gif" width="318" height="299" /></td>
        </tr>
        <tr>
          <td height="351" align="right"><img src="images/login1_04.gif" width="318" height="351" /></td>
        </tr>
      </table>
    </td>
    <td width="366" valign="top">
  	
      <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
        <tr>
          <td height="299" ><img src="images/login1_02.gif" width="366" height="299" /></td>
        </tr>
        <tr>
          <td height="96" valign="top" background="images/login_9.gif">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="25" style="width: 93px">&nbsp;</td>
                <td width="48%" valign="top">
                  <label>
                      &nbsp;<input name="mvo.m_name" type="text" class="buttonface" id="user" size="21"></label></td>
                <td rowspan="2" style="width: 27%">
                   <input type="image" src="images/login_2.gif"/></td>
              </tr> 
              <tr>
                <td style="width: 93px">&nbsp;</td>
                <td>
                    &nbsp;<input name="mvo.m_pwd " type="password"  class="buttonface" id="Pass" size="23"></td>
              </tr>
              <tr>
                <td align="right" style="width: 93px; height: 18px"></td>
                <td style="height: 18px">
                    </td>
              </tr>

            </table>
          </td>
        </tr>
        <tr>
          <td height="255" background="images/login1_07.gif">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="129">&nbsp;</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
    <td width="318" valign="top">
      <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="299" align="left" background="images/login1_03.gif">&nbsp;</td>
        </tr>
        <tr>
          <td height="351" align="left" background="images/login1_06.gif">&nbsp;</td>
        </tr>
      </table>
    </td>
  </tr>
</table>
 </form>
    </div>

</body>
</html>