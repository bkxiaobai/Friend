<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ include file="../taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>后台管理</title>
<link href="css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<table width="768" align="center" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
		<table width="100%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="30" colspan="2">
				<jsp:include page="../l_sail.jsp"/>
			</td>
            </tr>
          <tr>
            <td height="17"><jsp:include page="../my_sail.jsp"/></td>
          </tr>
        </table>
	</td>
  </tr>
<script language="JavaScript" src="JavaScript/validate.js"></script>		  
          <tr>
            <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="19" class="td_shang12">&nbsp;</td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="666" valign="bottom" class="td_shang12"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="400" class="Statistic"><jsp:include page="a_l_sail2.jsp"/></td>
                    <td class="huanying">欢迎 管理员
					 <bean:write name="adminInfo" property="name" scope="session"/> 登录</td>
                  </tr>
                </table></td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="19" height="35" class="td_shang12">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="5">
					<div align="center" class="sail">
					<br><br><br><br><br>
					<br>欢迎进入FriendShip后台管理
					<br><br><br><br><br><br></div>				</td>
              </tr>
              <tr>
                <td height="40" colspan="5" class="td_down"><div align="center">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="td_xia12">
                      <tr>
                        <td class="page"></td>
                        <td width="32">&nbsp;</td>
                      </tr>
                          </table>
                </div></td>
              </tr>
            </table></td>
          </tr>
        </table>
  <tr>
    <td><jsp:include page="a_l_copyright.jsp"/></td>
  </tr>
</body>
</html>
