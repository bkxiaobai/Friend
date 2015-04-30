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
                <td width="33" class="td_shang12">&nbsp;</td>
                <td width="13" class="td_shang12">&nbsp;</td>
                <td width="1156" valign="bottom" class="td_shang12"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="400" class="Statistic">
					&nbsp;${sessionScope.clientInfo.name}&nbsp;&nbsp;欢迎进入&nbsp;${sessionScope.albumInfo.name}&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共有&nbsp;${requestScope.page.rsCount}&nbsp;张图片</td>
                    <td class="sail"><div align="center">
					<a href="albumlist.do">相册列表</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="addphotolink.do?albumId=${sessionScope.albumInfo.id}">上传照片</a></div></td>
                  </tr>
                </table></td>
                <td width="13" class="td_shang12">&nbsp;</td>
                <td width="45" height="35" class="td_shang12">&nbsp;</td>
              </tr>
              <tr>
                <td colspan="5">
					<div class="sail">
						<bean:write name="success" scope="request" ignore="true"/>
						<bean:write name="noexist" scope="request" ignore="true"/>&nbsp;&nbsp;&nbsp;&nbsp;						</div>
					<div align="center">
						<logic:empty name="photos" scope="request">
						<div>
&nbsp;&nbsp;&nbsp;&nbsp;						</div>
						<div>
&nbsp;&nbsp;&nbsp;&nbsp;						</div>
							<span class="PhotoNameClass">暂无照片,可以先上传</span>
						<div>
&nbsp;&nbsp;&nbsp;&nbsp;						</div>
						<div>
&nbsp;&nbsp;&nbsp;&nbsp;						</div>
						</logic:empty>
						<logic:iterate id="photo" name="photos" scope="request">
						<div class="PhotoWrapClass">
							<div class="PhotoImgClass">
							<a href="viewphoto.do?photoId=${pageScope.photo.id}"><img src="${pageScope.photo.smallPicUrl}" border="0"></a></div>
							<div class="PhotoNameClass">
							<a href="#">${pageScope.photo.title}</a> | 点击：${pageScope.photo.times}<br><br>
							上传时间:<span class="PhotoNameClass">${pageScope.photo.upDate}</span><br><br>
							<a href="changeCover.do?photoId=${pageScope.photo.id}">设为相册封面</a><br>
							<a href="viewphotoinfo.do?photoId=${pageScope.photo.id}&cId=${sessionScope.clientInfo.id}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="delphoto.do?photoId=${pageScope.photo.id}">删除</a>							</div>
						</div>
						</logic:iterate>
                        <form name="pageForm" action="managephotopage.do">
						  <input type="hidden" name="albumId" value="${requestScope.album.id}">
                          <input type="hidden" name="currentPage" value="${requestScope.page.currentPage}">
                          <input type="hidden" name="pageCount" value="${requestScope.page.pageCount}">
                        </form>
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
						共${requestScope.page.pageCount} 页 当前：
						${requestScope.page.currentPage}/${requestScope.page.pageCount} 
						<a href="javascript:firstPage(pageForm);">首页</a> 
						<a href="javascript:prePage(pageForm);">上一页</a> 
						<a href="javascript:nextPage(pageForm);">下一页</a> 
						<a href="javascript:lastPage(pageForm);">尾页</a></div></td>
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
   </table>
</body>
</html>
