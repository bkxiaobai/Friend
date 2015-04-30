<%@ page contentType="text/html; charset=gbk" language="java" %>
<%@ include file="taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>后台管理</title>
<link href="css.css" rel="stylesheet" type="text/css">
</head>

<body>
<table width="768" align="center"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
		<table width="100%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="30" colspan="2">
				<jsp:include page="l_sail.jsp"/>
			</td>
            </tr>
          <tr>
            <td height="17"><jsp:include page="my_sail.jsp"/></td>
          </tr>
        </table>
	</td>
  </tr>
  <tr>
    <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="718" height="186" valign="top" class="td_shang14"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><div align="center">
<script language="JavaScript" src="JavaScript/validate.js">

</script>

			</div></td>
          </tr>
          <tr>
            <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="19" class="td_shang12">&nbsp;</td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="666" valign="bottom" class="td_shang12"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr> 
				  	<td class="huanying">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;你的登录名是:${sessionScope.clientInfo.name}</td>
                    <td width="400" class="Statistic"><jsp:include page="album_sail.jsp"/></td>
                  </tr>
                </table></td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="19" height="35" class="td_shang12">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="5"><div align="center">
                  <html:form action="addalbum.do" onsubmit="return validateAddAlbumForm(this);">
                    <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td>&nbsp;</td>
                        <td width="100">&nbsp;</td>
                        <td width="150" class="sail"><br>
						<logic:messagesPresent>
				  	    	<html:messages id="error">
				  		    	<bean:write name="error"/><br><br>
					      	</html:messages>
				        </logic:messagesPresent>						</td>
                        <td width="280">&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td height="25" class="Statistic2">相册名称:</td>
                        <td><html:text property="name" styleClass="input"/></td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td height="25" class="Statistic2">选择分类:</td>
                        <td><html:select property="kind" styleClass="input">
                          <logic:iterate id="kind" name="kinds" scope="session">
						  <html:option value="${pageScope.kind.id}">${pageScope.kind.name}</html:option>
						  </logic:iterate>
                        </html:select></td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td height="25" class="Statistic2">相册简介:</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td class="Statistic2">&nbsp;</td>
                        <td colspan="2"><html:textarea property="desc" cols="40" rows="5" styleClass="input3"/></td>
                        </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td class="Statistic2">验证码:</td>
                        <td><input type="text" name="code" class="input"></td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td class="Statistic2">&nbsp;</td>
                        <td>
					<img id="img" src="clientImage.jsp"/>
<img src="images/login/an.gif" border="0" onClick="javascript:document.getElementById('img').src='clientImage.jsp'"/>					</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td class="Statistic2">&nbsp;</td>
                        <td>&nbsp;						</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td><input name="Submit" type="submit" class="input" value="提交">
                        <input type="button"  class="input" onclick="javascript:history.back();" value="返回"/></td>
                        <td>&nbsp;</td>
                      </tr>
                    </table>
                  </html:form>
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
        </table></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td><jsp:include page="l_copyright.jsp"/></td>
  </tr>
</table>
</body>
</html>
