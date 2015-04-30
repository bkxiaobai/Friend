<%@ page contentType="text/html; charset=gbk" language="java" %>
<%@ include file="taglibs.jsp"%>
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
				<jsp:include page="l_sail.jsp"/>
			</td>
            </tr>
          <tr>
            <td height="17"><jsp:include page="my_sail.jsp"/></td>
          </tr>
        </table>
	</td>
  </tr>
<script language="JavaScript" src="JavaScript/validate.js">
</script>		  
          <tr>
            <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="19" class="td_shang12">&nbsp;</td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="666" valign="bottom" class="td_shang12"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="400" class="Statistic">&nbsp;&nbsp;
					你正在为&nbsp;&nbsp;<span class="sail">${sessionScope.albumInfo.name}</span>
					&nbsp;&nbsp;上传照片
					&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="viewphotos.do?albumId=${sessionScope.albumInfo.id}">查看相片列表</a></td>
                    <td width="313" class="Statistic"><jsp:include page="album_sail.jsp"/></td>
                  </tr>
                </table></td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="19" height="35" class="td_shang12">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="5"><div align="center">
                  <html:form action="addphoto.do" enctype="multipart/form-data" onsubmit="return validateAddPhotoForm(this);">
                    <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="19">&nbsp;</td>
                        <td width="147">&nbsp;</td>
                        <td width="200">
						<label><span class="sail">&nbsp;&nbsp;&nbsp;&nbsp;
						<logic:messagesPresent>
				  	    	<html:messages id="error">
				  		    	<bean:write name="error"/><br>&nbsp;&nbsp;&nbsp;&nbsp;					      	
				  		    </html:messages>
				        </logic:messagesPresent>
					<bean:write name="wrongType" scope="request" ignore="true"/>
					<bean:write name="success" scope="request" ignore="true"/>
					<bean:write name="nofind" scope="request" ignore="true"/>
					<bean:write name="tooBig" scope="request" ignore="true"/>
						</span></label>						</td>
                        <td width="233">&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td height="25" class="Statistic2">图片名称：</td>
                        <td><html:text property="name" styleClass="input"/></td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td height="25" class="Statistic2">图片：</td>
                        <td><html:file property="image" styleClass="input"/>  </td>
                        <td class="Statistic"><div align="left">(只支持bmp,jpeg格式图片,请注意格式)</div></td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td height="25" class="Statistic2">文件简介：</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td class="Statistic2">&nbsp;</td>
                        <td colspan="2"><input type="hidden" name="albumId" value="${requestScope.albumInfo.id}">
                          <html:textarea property="desc" cols="40" rows="5" styleClass="input3"/></td>
                        </tr>
                      <tr>
                        <td>&nbsp;</td>
                        <td class="Statistic2">&nbsp;</td>
                        <td>&nbsp;</td>
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
        </table>

  <tr>
    <td><jsp:include page="l_copyright.jsp"/></td>
  </tr>

</body>
</html>
