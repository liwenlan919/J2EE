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
	<table width="224" border="0" align="center" cellpadding="0" cellspacing="0">
     <tr>
        <td width="224" height="31" colspan="2" align="center"><a href="photoslist_admin2?mvo.uid=${resObj.username}"><img border="0" src="images/m2.jpg"/></a></td>
      </tr>

      <tr>
        <td height="31" colspan="2" align="center"><a href="diarylist_admin2?mvo.uid=${resObj.username}"><img border="0" src="images/m4.jpg"/></a></td>
      </tr>
      <tr>
        <td height="31" colspan="2" align="center"><a href="musiclist_admin2?mvo.uid=${resObj.username}"><img border="0" src="images/m5.jpg"/></a></td>
      </tr>
      <tr>
        <td height="31" colspan="2" align="center"><a href="videolist_admin2?mvo.uid=${resObj.username}"><img border="0" src="images/m6.jpg"/></a></td>
      </tr>
	        <tr>
        <td height="39" colspan="2" align="center"><a href="liuyuanlist_admin2?mvo.uid=${resObj.username}"><img border="0" src="images/m1.jpg"/></a></td>
      </tr>
	      
      <tr>
        <td height="31" colspan="2" align="center"><a href="yulelist_admin2?mvo.uid=${resObj.username}"><img border="0" src="images/m7.jpg"/></a></td>
      </tr>
      <tr>
        <td height="31" colspan="2" align="center"><a href="joblist_admin2?mvo.uid=${resObj.username}"><img border="0" src="images/m8.jpg"/></a></td>
      </tr>
      <tr>
        <td height="50" colspan="2" align="center"></td>
  </tr>
    </table>

	</td>
    <td width="748">

      <table width="600" border="0" align="center" cellpadding="1" cellspacing="1" bgcolor="#5796DB">
        <tr>
          <td width="136" height="58" align="right" bgcolor="#FFFFFF">头像：</td>
          <td width="457" bgcolor="#FFFFFF">&nbsp; 
          <img src="${resObj.picurl}" with="40" height="40" alt="" />
          
          </td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">性别：</td>
          <td bgcolor="#FFFFFF"><label>
            ${resObj.sex}
          </label></td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">生日：</td>
          <td bgcolor="#FFFFFF"><label>
		  ${resObj.birthday}
           
          </label></td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">家乡：</td>
          <td bgcolor="#FFFFFF">
		    ${resObj.hometown}
		  </td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">大学：</td>
          <td bgcolor="#FFFFFF">
		   ${resObj.university}
		 </td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">高中：</td>
          <td bgcolor="#FFFFFF">
		   ${resObj.middle}
		</td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">初中：</td>
          <td bgcolor="#FFFFFF">
		     ${resObj.chuzhong}
		 </td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">小学：</td>
          <td bgcolor="#FFFFFF">
		   ${resObj.xiaoxue}
		 </td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">爱好：</td>
          <td bgcolor="#FFFFFF">
		    ${resObj.hobby}
		  </td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">QQ：</td>
          <td bgcolor="#FFFFFF"> ${resObj.QQ}
		  
		</td>
        </tr>
        <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">手机：</td>
          <td bgcolor="#FFFFFF">
		  ${resObj.phone}
          </td>
        </tr>
   <tr>
          <td height="30" align="right" bgcolor="#FFFFFF">邮箱：</td>
          <td bgcolor="#FFFFFF">
		  ${resObj.email}
          </td>
        </tr>
      </table>

      </td>
  </tr>
</table>
<jsp:include flush="true" page="foot.jsp"></jsp:include>

</body>
</html>