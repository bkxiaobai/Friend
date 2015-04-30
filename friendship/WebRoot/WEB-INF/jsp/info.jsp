<%@ page contentType="text/html; charset=gb2312" language="java"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk">
		<title>电子相册管理系统</title>
		<link href="css.css" rel="stylesheet" type="text/css">
	</head>

	<body>
		
		<table width="1280" align="center" border="0" cellspacing="0"
			cellpadding="0" bgcolor="#46a3FF">
			<tr>
				<td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="30" colspan="2">
								<jsp:include page="l_sail.jsp" />
							</td>
						</tr>
						<tr>
							<td height="17"><jsp:include page="my_sail.jsp" /></td>
						</tr>
					</table>
				</td>
			</tr>

			<tr valign="bottom">
				<td align="center">
					
						<img src="images/index/main_new.jpg">
					
				</td>
				<!--  <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="718" height="186" bgcolor="#FFFFFF" class="td_shang14"><div align="center"></div></td>
         
         </tr>
    </table></td>
     -->
			</tr>
			<tr valign="top">

				<td><jsp:include page="l_copyright.jsp" /></td>
			</tr>
		</table>

	</body>
</html>
