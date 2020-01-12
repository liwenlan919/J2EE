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
		var firm = $("#firm").attr("value");
		var jobtitle = $("#jobtitle").attr("value");
		var num = $("#num").attr("value");
		var salary = $("#salary").attr("value");
		if(firm.length == 0){
			alert("公司不能为空");
			return false;
		}
		if(jobtitle.length == 0){
			alert("职位不能为空");
			return false;
		}
			
		if(num.length == 0){
			alert("招聘人数不能为空");
			return false;
		}
	    if(salary.length == 0){
			alert("工资待遇不能为空");
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
      <s:form action="/jobadd_admin" method="post"  onsubmit="return add();">
      <s:token></s:token>
    <table width="600" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#CCCCCC">
      <tr>
        <td width="92" height="47" align="right" bgcolor="#FFFFFF">公司名称：</td>
        <td width="498" bgcolor="#FFFFFF"><label>
          <input name="mvo.firm" type="text" size="40" id="firm" />
        </label></td>
      </tr>
          <tr>
        <td width="92" height="47" align="right" bgcolor="#FFFFFF">职位：</td>
        <td width="498" bgcolor="#FFFFFF"><label>
          <input name="mvo.jobtitle" type="text" size="40" id="jobtitle" />
        </label></td>
      </tr>
          <tr>
        <td width="92" height="47" align="right" bgcolor="#FFFFFF">招聘人数：</td>
        <td width="498" bgcolor="#FFFFFF"><label>
          <input name="mvo.num" type="text" size="40" id="num" />
        </label></td>
      </tr>
          <tr>
        <td width="92" height="47" align="right" bgcolor="#FFFFFF">工资待遇：</td>
        <td width="498" bgcolor="#FFFFFF"><label>
          <input name="mvo.salary" type="text" size="40" id="salary" />
        </label></td>
      </tr>
      <tr>
        <td height="260" align="right" bgcolor="#FFFFFF">详细内容：</td>
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