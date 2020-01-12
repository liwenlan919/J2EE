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
    <td width="748"><div align="center">
       <s:form action="membersupdate_admin" method="post"  onsubmit="return add();" enctype="multipart/form-data">
      <s:token></s:token>
      <table width="600" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#5796DB">
        <tr>
          <td width="136" height="58" align="right" bgcolor="#FFFFFF">头像：</td>
          <td width="457" bgcolor="#FFFFFF">&nbsp;  <s:file name="fvo.myFile" id="file" theme="simple"></s:file>
          <img src="${resObj.picurl}" with="40" height="40" alt="" />
          
          </td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">性别：</td>
          <td bgcolor="#FFFFFF"><label>
            <input type="radio" name="mvo.sex"  <c:if test="${resObj.sex =='男'}">checked</c:if> value="男" />
       男     
            <input type="radio" name="mvo.sex" <c:if test="${resObj.sex =='女'}">checked</c:if>  value="女" />
            女
          </label></td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">生日：</td>
          <td bgcolor="#FFFFFF"><label>
            <input type="text" name="mvo.birthday" value="${resObj.birthday}" />
          </label></td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">家乡：</td>
          <td bgcolor="#FFFFFF"><input type="text" name="mvo.hometown" value="${resObj.hometown}" /></td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">大学：</td>
          <td bgcolor="#FFFFFF"><input type="text" name="mvo.university"  value="${resObj.university}" /></td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">高中：</td>
          <td bgcolor="#FFFFFF"><input type="text" name="mvo.middle"   value="${resObj.middle}"/></td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">初中：</td>
          <td bgcolor="#FFFFFF"><input type="text" name="mvo.chuzhong"  value="${resObj.chuzhong}" /></td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">小学：</td>
          <td bgcolor="#FFFFFF"><input type="text" name="mvo.xiaoxue"  value="${resObj.xiaoxue}" /></td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">爱好：</td>
          <td bgcolor="#FFFFFF"><input type="text" name="mvo.hobby"  value="${resObj.hobby}" /></td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">QQ：</td>
          <td bgcolor="#FFFFFF"><input type="text" name="mvo.QQ"  value="${resObj.QQ}" /></td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">手机：</td>
          <td bgcolor="#FFFFFF"><input type="text" name="mvo.phone"  value="${resObj.phone}" />
          <input type="hidden" name="mvo.username"  value="${resObj.username}" />
          <input type="hidden" name="mvo.password"  value="${resObj.password}" />
          <input type="hidden" name="mvo.picurl"  value="${resObj.picurl}" />
           <input type="hidden" name="mvo.email"  value="${resObj.email}" />
          <input type="hidden" name="mvo.id"  value="${resObj.id}" />
          </td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">&nbsp;</td>
          <td bgcolor="#FFFFFF"><label>
            <input type="submit" name="Submit" value="修改" />
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