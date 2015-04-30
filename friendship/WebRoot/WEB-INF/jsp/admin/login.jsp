<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ include file="../taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>管理员登录</title>
<link href="css.css" rel="stylesheet" type="text/css">
</head>
<script language="javascript1.2" src="JavaScript/validate.js">

</script>

<body>
<br>
<center><font color="red" size="5"><b>* * *管理员登录* * *</b></font></center>
<br>
<table width="768"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td class="td_top"><table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="230" class="td_top"><html:form action="adminLogin.do" onsubmit="return validateAdminLoginForm(this)">
          <table width="270"  border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td height="70" colspan="2" class="login_title"><div align="center">
                <logic:messagesPresent>
                  <html:messages id="error">
                    <bean:write name="error"/>
                    <br>
                  </html:messages>
                </logic:messagesPresent>
                <bean:write name="wrongCode" scope="request" ignore="true"/>
                <bean:write name="wrong" scope="request" ignore="true"/>
              </div></td>
            </tr>
            <tr>
              <td width="65" height="20" class="login_title">用户名：</td>
              <td width="190" valign="bottom" class="login_dixian"><html:text property="userName" styleClass="input4" size="15"/></td>
            </tr>
            <tr>
              <td height="20" class="login_title">密码：</td>
              <td class="login_dixian"><input name="pass" type="password" class="input4" size="15"></td>
            </tr>
            <tr>
              <td class="login_title">验证码：</td>
              <td class="login_dixian"><input name="code" type="text" class="input4" size="15"></td>
            </tr>
            <tr>
              <td height="40" class="login_dixian">&nbsp;</td>
              <td class="login_dixian" style="padding-top:4px;"><div style="border:1px #5D1108 solid;padding:3px;display:inline;"><img id="img" src="image.jsp"/></div>
                      <img src="images/login/an.gif" border="0" onClick="javascript:document.getElementById('img').src='image.jsp'"/></td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;
                      <input name="image" type="image" src="images/login/go.gif" width="83" height="25" border="0"></td>
            </tr>
          </table>
        </html:form></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
