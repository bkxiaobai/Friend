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
<script language="JavaScript" src="JavaScript/validate.js"></script>		  
          <tr>
            <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="19" class="td_shang12">&nbsp;</td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="666" valign="bottom" class="td_shang12"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="400" class="Statistic">
					欢迎进入${requestScope.album.name}相册 &nbsp;&nbsp;&nbsp;共有
					${requestScope.page.rsCount}张相片</td>
                    <td class="sail"></td>
                  </tr>
                </table></td>
                <td width="8" class="td_shang12">&nbsp;</td>
                <td width="19" height="35" class="td_shang12">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="5">
					<div class="sail">
&nbsp;&nbsp;&nbsp;&nbsp;						</div>
					<div align="center">
						<logic:empty name="photos" scope="request">
						<div>
&nbsp;&nbsp;&nbsp;&nbsp;						</div>
						<div>
&nbsp;&nbsp;&nbsp;&nbsp;						</div>
							<span class="PhotoNameClass">暂无照片</span>
						<div>
&nbsp;&nbsp;&nbsp;&nbsp;						</div>
						<div>
&nbsp;&nbsp;&nbsp;&nbsp;						</div>
						</logic:empty>
						<logic:iterate id="photo" name="photos" scope="request">
						<div class="PhotoWrapClass">
							<div class="PhotoImgClass">
							<a href="photoclient.do?photoId=${pageScope.photo.id}"><img src="${pageScope.photo.smallPicUrl}" border="0"></a></div>
							<div class="PhotoNameClass">							</div>
						</div>
						</logic:iterate>
                        <html:form action="otherphotosa.do">
						  <input type="hidden" name="albumId" value="${requestScope.album.id}">
                          <input type="hidden" name="currentPage" value="${requestScope.page.currentPage}">
                          <input type="hidden" name="pageCount" value="${requestScope.page.pageCount}">
                        </html:form>
</div>				</td>
              </tr>
                <tr>
              		<td colspan="5" class="Statistic"><a href="seealbumcomment.do?albumId=${sessionScope.albumInfo.id}">点击查看评论</a></td><br>
              </tr>
              <tr>
                <td height="40" colspan="5" class="td_down"><div align="center">
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="td_xia12">
                      <tr>
                        <td class="page"><div align="right">
						共 页 当前：
						${requestScope.page.currentPage}/${requestScope.page.pageCount}
						<a href="javascript:firstPage();">首页</a> 
						<a href="javascript:prePage();">上一页</a> 
						<a href="javascript:nextPage();">下一页</a> 
						<a href="javascript:lastPage();">尾页</a></div></td>
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
