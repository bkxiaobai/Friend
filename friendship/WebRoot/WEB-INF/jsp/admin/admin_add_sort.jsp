<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ include file="../taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>后台管理</title>
<link href="css.css" rel="stylesheet" type="text/css">
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
                    <td class="huanying">欢迎管理员登录</td>
                  </tr>
                </table></td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="19" height="35" class="td_shang12">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="5"><div align="center">
                  <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td><html:form action="addkind.do" onsubmit="return validateAddKindForm(this)">
                        <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="170">&nbsp;</td>
                            <td width="100">&nbsp;</td>
                            <td width="150">
							<span class="sail">
						<logic:messagesPresent>
				  	    <html:messages id="error">
				  		    <bean:write name="error"/><br>
					      </html:messages>
				        </logic:messagesPresent>${requestScope.success}</span></td>
                            <td>&nbsp;</td>
                          </tr>
                          <tr>
                            <td>&nbsp;</td>
                            <td class="Statistic2">添加分类：</td>
                            <td><input name="name" type="text" class="input" size="20"></td>
                            <td><input name="Submit" type="submit" class="input" value="提交"></td>
                          </tr>
                        </table>
                      </html:form></td>
                    </tr>
                    <tr>
                      <td><form name="form2" method="post" action="">
                        <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="70">&nbsp;</td>
                            <td width="100">&nbsp;</td>
                            <td width="150">&nbsp;</td>
                            <td colspan="3">&nbsp;</td>
                          </tr>
                          <tr>
                            <td>&nbsp;</td>
                            <td class="Statistic2">管理分类：</td>
                            <td><select name="kind" class="input">
							<logic:iterate id="kind" name="kinds">
                              <option value="${pageScope.kind.id}">${pageScope.kind.name}</option>
							</logic:iterate>
                           
                          <tr>
                            <td height="40">&nbsp;</td>
                            <td class="Statistic2">&nbsp;</td>
                            <td>&nbsp;</td>
                            <td valign="bottom">&nbsp;</td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                          </tr>
                        </table>
                      </form></td>
                    </tr>
                  </table>
                  </div></td>
              </tr>
              <tr>
                <td height="40" colspan="5" class="td_down"><div align="center">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="td_xia12">
                      <tr>
                        <td class="page"><div align="right"></div></td>
                        <td width="32">&nbsp;</td>
                      </tr>
                          </table>
                </div></td>
              </tr>
            </table></td>
          </tr>

  <tr>
    <td><jsp:include page="a_l_copyright.jsp"/></td>
  </tr>

</body>
</html>
