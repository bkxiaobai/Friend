<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ include file="taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>����������ϵͳ</title>
<link href="css.css" rel="stylesheet" type="text/css">
</head>

<body>
<table width="768" align="center" border="0" cellspacing="0" cellpadding="0">
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
            <td bgcolor="#FFFFFF"><div align="center">
			<SCRIPT language="JavaScript" src="JavaScript/validate.js">

</SCRIPT>

			</div></td>
          </tr>
          <tr>
            <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="19" class="td_shang12">&nbsp;</td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="666" valign="bottom" class="td_shang12"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td class="Statistic">&nbsp;&nbsp;&nbsp;��ӭ���٣�Forever Friendship ���&nbsp;&nbsp;<span class="RegFont darkRed">
					<a href="reglink.do">���û���ʺ�����ע��</a></span>
					&nbsp;&nbsp;&nbsp;<span class="RegFont blue">Change Time For......</span></td>
                    </tr>
                </table></td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="19" height="35" class="td_shang12">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="5">
				<div id="RegisterDivWrap">
					<html:form action="clientLogin.do" onsubmit="return validateClientLoginForm(this)">
					<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<label><span class="red">
						<logic:messagesPresent>
				  	    	<html:messages id="error">
				  		    	<bean:write name="error"/><br>&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;					      	</html:messages>
				        </logic:messagesPresent>
						</span>
						<bean:write name="wrong" scope="request" ignore="true"/>
						<bean:write name="success" scope="request" ignore="true"/>
						<bean:write name="wrongCode" scope="request" ignore="true"/>
						</label>
					</div>
					<div>
						<label><span class="red">*</span> ��&nbsp;&nbsp;&nbsp;&nbsp;�ƣ�</label>
					    <html:text property="name" styleClass="input" value="${requestScope.name}"/>
					</div>
					<div>
						<label><span class="red">*</span> ��&nbsp;&nbsp;&nbsp;&nbsp;�룺</label>
						<input type="password" name="pass" class="input">
					</div>
					<div>
						<label><span class="red">*</span> ��&nbsp;֤&nbsp;�룺</label>
						<input type="text" name="code" class="input"></div>
					<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<img id="img" src="clientImage.jsp"/>
<img src="images/login/an.gif" border="0" onClick="javascript:document.getElementById('img').src='clientImage.jsp'"/>					</div>
					<div style="margin-top:20px; ">
					<input name="" type="submit" value="�� ¼" class="input" style="width:50px;">
					&nbsp;&nbsp;<input name="" type="reset" value="�� ��" class="input" style="width:50px;">
					</div>
					</html:form>
				</div>				</td>
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
