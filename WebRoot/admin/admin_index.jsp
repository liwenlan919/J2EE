<%@ page pageEncoding="GB2312"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" >
<head runat="server">
    <title>网站后台管理系统</title>
    <link href="<%=request.getContextPath() %>/admin/images/style.css" rel="stylesheet" type="text/css" />
<style type="text/css">

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	background-color: #2286C2;
}

</style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="74" colspan="2" background="<%=request.getContextPath() %>/admin/images/index1_03.gif">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="33%" rowspan="2">
		  <span  style="font-size:20px; color:#333333; font-weight:bold; padding-left:20px;">网站后台管理系统</span></td>
          <td width="6%" rowspan="2">&nbsp;</td>
          <td width="61%" height="38" align="right">
            <table width="120" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="center">&nbsp;</td>
                <td align="center" class="font2"><a href="#" class="font2"></a></td>
                <td align="center"></td>
                <td align="center" class="font2"><img src="<%=request.getContextPath() %>/admin/images/index1_08.gif" width="16" height="16" /><a href="<%=request.getContextPath() %>/admin/loginout.jsp" class="font2"><strong>退出</strong></a></td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td align="right">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td align="right" class="font2">&nbsp;欢迎登陆
                 <%
	if(request.getSession().getAttribute("ADMIN") != null){
		%>
			    管理员：&nbsp;&nbsp;${ADMIN.m_name }
                              
		<%
		
	}
%>

                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <table width="100%" border="0" cellspacing="10" cellpadding="0">
        <tr>
          <td width="10%" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="8" height="8"><img src="<%=request.getContextPath() %>/admin/images/index1_23.gif" width="8" height="29" /></td>
                <td width="99%" background="<%=request.getContextPath() %>/admin/images/index1_24.gif"></td>
                <td width="8" height="8"><img src="<%=request.getContextPath() %>/admin/images/index1_26.gif" width="8" height="29" /></td>
              </tr>
              <tr>
                <td background="<%=request.getContextPath() %>/admin/images/index1_45.gif"></td>
                <td bgcolor="#FFFFFF" style="padding:0 2px 0 2px; vertical-align:top;height:500px;">
               <SCRIPT language=javascript1.2>
function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display='';");

}
else
{
eval("submenu" + sid + ".style.display='none';");


}
}
</SCRIPT>
<table width="200" border="0" cellpadding="0" cellspacing="5">
         <tr onClick="showsubmenu('1')" style="cursor:hand; ">
                      <td align="center" style="width: 31px"><img src="<%=request.getContextPath() %>/admin/images/close.jpg" id="subimg1"  ></td>
                      <td style="width: 155px">
                          会员管理</td>
                    </tr>
                    
                    <tr id="submenu1" style="display:none">
                      <td align="center" style="width: 31px">&nbsp;</td>
                      <td style="width: 155px">
                        <table width="100%" border="0" cellspacing="5" cellpadding="0">
                        
                    
                      
                          <tr>
                            <td align="center"><img src="<%=request.getContextPath() %>/admin/images/index1_68.gif" width="11" height="14" /></td>
                            <td>
                                <span style="font-size: 12px; font-family: ''"><a href="<%=request.getContextPath() %>/memberslist_admin" target="main">管理会员</a></span></td>
                          </tr>
                        </table>
                      </td>
                    </tr>

     
                    <tr onClick="showsubmenu('2')" style="cursor:hand; ">
                      <td align="center" style="width: 31px"><img src="<%=request.getContextPath() %>/admin/images/close.jpg"   id="subimg2" /></td>
                      <td style="width: 155px">
                         内容管理</td>
                    </tr>
					   <tr id="submenu2" style="display:none">
                      <td align="center" style="width: 31px">&nbsp;</td>
                      <td style="width: 155px"><table width="100%" border="0" cellspacing="5" cellpadding="0">
 
                        <tr>
                          <td width="18%" align="center"><img src="<%=request.getContextPath() %>/admin/images/index1_68.gif" width="11" height="14" /></td>
                          <td width="82%">
                            <a href="<%=request.getContextPath() %>/diarymlist_admin" target="main">日记管理</a></td>
                        </tr>
                                    		

                        <tr >
                          <td align="center"><img src="<%=request.getContextPath() %>/admin/images/index1_68.gif" width="11" height="14" /></td>
                          <td><a href="<%=request.getContextPath() %>/photosmlist_admin" target="main">相册管理</a></td>
                        </tr>
                          <tr >
                          <td align="center"><img src="<%=request.getContextPath() %>/admin/images/index1_68.gif" width="11" height="14" /></td>
                          <td><a href="<%=request.getContextPath() %>/musicmlist_admin" target="main">音乐管理</a></td>
                        </tr>
                          <tr >
                          <td align="center"><img src="<%=request.getContextPath() %>/admin/images/index1_68.gif" width="11" height="14" /></td>
                          <td><a href="<%=request.getContextPath() %>/videomlist_admin" target="main">视频管理</a></td>
                        </tr>
                          <tr >
                          <td align="center"><img src="<%=request.getContextPath() %>/admin/images/index1_68.gif" width="11" height="14" /></td>
                          <td><a href="<%=request.getContextPath() %>/liuyuanmlist_admin" target="main">留言管理</a></td>
                        </tr>
                          <tr >
                          <td align="center"><img src="<%=request.getContextPath() %>/admin/images/index1_68.gif" width="11" height="14" /></td>
                          <td><a href="<%=request.getContextPath() %>/yulemlist_admin" target="main">娱乐管理</a></td>
                        </tr>
                     
                          <tr >
                          <td align="center"><img src="<%=request.getContextPath() %>/admin/images/index1_68.gif" width="11" height="14" /></td>
                          <td><a href="<%=request.getContextPath() %>/jobmlist_admin" target="main">招聘管理</a></td>
                        </tr>
                     
                        
                      </table></td>
                    </tr>
		              
				  
                  </table>
                </td>
                <td background="<%=request.getContextPath() %>/admin/images/index1_47.gif"></td>
              </tr>
              <tr>
                <td width="8" height="8"><img src="<%=request.getContextPath() %>/admin/images/index1_91.gif" width="8" height="8" /></td>
                <td background="<%=request.getContextPath() %>/admin/images/index1_92.gif"></td>
                <td width="8" height="8"><img src="<%=request.getContextPath() %>/admin/images/index1_93.gif" width="8" height="8" /></td>
              </tr>
            </table>
          </td>
          <td width="70%" valign="top">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="8" height="8"><img src="<%=request.getContextPath() %>/admin/images/index1_28.gif" width="8" height="39" /></td>
                <td width="99%" background="<%=request.getContextPath() %>/admin/images/index1_40.gif">
				
				欢迎进入本网站
				</td>
                <td width="8" height="8"><img src="<%=request.getContextPath() %>/admin/images/index1_43.gif" width="8" height="39" /></td>
              </tr>
              <tr>
                <td background="<%=request.getContextPath() %>/admin/images/index1_45.gif"></td>
                <td bgcolor="#FFFFFF" style="height:490px; vertical-align:top;">
				  <iframe height="100%" name="main" width="100%" border="0" frameborder="0" src="<%=request.getContextPath() %>/memberslist_admin"></iframe>
                </td>
                <td background="<%=request.getContextPath() %>/admin/images/index1_47.gif"></td>
              </tr>
              <tr>
                <td width="8" height="8"><img src="<%=request.getContextPath() %>/admin/images/index1_91.gif" width="8" height="8" /></td>
                <td background="<%=request.getContextPath() %>/admin/images/index1_92.gif"></td>
                <td width="8" height="8"><img src="<%=request.getContextPath() %>/admin/images/index1_93.gif" width="8" height="8" /></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
    </div>
    </form>
</body>
</html>