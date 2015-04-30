<%@ page contentType="text/html; charset=gbk" language="java" %>
<%@ include file="taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>电子相册管理系统</title>
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
			<SCRIPT language="javascript1.2" src="JavaScript/validate.js"></SCRIPT>		  
          <tr>
            <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="19" class="td_shang12">&nbsp;</td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="666" valign="bottom" class="td_shang12"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="400" class="Statistic"><span class="sail">&nbsp;${sessionScope.kind.name}</span>
					相册列表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共有${requestScope.page.rsCount}个相册</td>
                    <td class="tuijian">&nbsp;</td>
                  </tr>
                </table></td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="19" height="35" class="td_shang12">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="5">
					<div align="center">
					<logic:iterate id="album" name="albums" scope="request">
						<div class="PhotoWrapClass">
							<div class="PhotoImgClass">
							<logic:present name="album" property="coverUrl">
							<a href="viewalbumk.do?albumId=${pageScope.album.id}">
							<img src="${pageScope.album.coverUrl}" border="0"></a>							</logic:present>
							<logic:notPresent name="album" property="coverUrl">
							<a href="viewalbumk.do?albumId=${pageScope.album.id}">
							<img src="none.gif" width="140" height="105" border="0"></a>
                            <br>
</logic:notPresent></div>
							<div class="PhotoNameClass"><a href="#">${pageScope.album.name}</a>							</div>
						</div>
					</logic:iterate>
					</div>
					<form  action="otheralbums.do" name="form1">
					<input name="kindId" type="hidden" value="${requestScope.kind.id}">
					<input name="currentPage" type="hidden" value="${requestScope.page.currentPage}">
					
					<input name="pageCount" type="hidden" value="${requestScope.page.pageCount}">
                    </form>				</td>
              </tr>
              <tr>
                <td height="40" colspan="5" class="td_down"><div align="center">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="td_xia12">
                      <tr>
                        <td class="page"><div align="right">共${requestScope.page.pageCount}页 
						当前：${requestScope.page.currentPage}/${requestScope.page.pageCount} 
						<a href="javascript:firstPage(form1);">首页</a> 
						<a href="javascript:prePage(form1);">上一页</a> 
						<a href="javascript:nextPage(form1);">下一页</a> 
						<a href="javascript:lastPage(form1);">尾页</a></div></td>
                        <td width="32">&nbsp;</td>
                      </tr>
                          </table>
                </div></td>
              </tr>
            </table></td>
          </tr>

  <tr>
    <td><jsp:include page="l_copyright.jsp"/></td>
  </tr>

</body>
</html>
