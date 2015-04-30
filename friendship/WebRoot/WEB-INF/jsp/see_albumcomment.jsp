<%@ page contentType="text/html; charset=gbk" language="java" %>
<%@ include file="taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>电子相册管理系统</title>
<link href="css.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.style1 {color: #333333}
-->
</style>

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
        <td width="657" height="186" valign="top" bgcolor="#F1F9FF" class="td_top"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="416" class="td_shang14-2">

		<table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="150"><table width="120"  border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td bgcolor="#FFFFFF" class="td_shang-xia"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td class="td_shang8_xia8">
                          
                             <logic:notEmpty name="album" property="coverUrl" >
							<img src="${requestScope.album.coverUrl}" border="0">
							</logic:notEmpty>
							<logic:empty name="album" property="coverUrl">
							<img src="none.gif" width="140" height="105" border="0">
                          </logic:empty>
                          </td>
                        </tr>
                    </table></td>
                    <td width="9" bgcolor="#FFFFFF">&nbsp;</td>
                  </tr>
                </table></td>
                <td><table width="100%"  border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="25">&nbsp;</td>
                    <td width="60">&nbsp;</td>
                    <td width="100">&nbsp;</td>
                    <td width="160">&nbsp;</td>
                    <td width="70">&nbsp;</td>
                    <td width="30">&nbsp;</td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td class="Statistic2">相册名称：</td>
                    <td class="Statistic">${requestScope.album.name}</td>
                    <td class="Statistic"><span class="style1">点击次数：</span>${requestScope.album.times}</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td class="Statistic2">所属分类：</td>
                    <td class="Statistic">${requestScope.kind.name}</td>
                    <td class="Statistic"><span class="style1">共有评论：</span>
					${requestScope.page.rsCount}</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td class="Statistic2">添加时间：</td>
                    <td colspan="3" class="Statistic"><span class="style1"></span>${requestScope.album.createDate}</td>                    
                    <td>&nbsp;</td>
                  </tr>
                  <tr>
                    <td>&nbsp;</td>
                    <td class="Statistic2">相册简介：</td>
                    <td colspan="3"><span class="Statistic">${requestScope.album.desc}</span></td>
                    <td>&nbsp;</td>
                  </tr>
                </table></td>
              </tr>
            </table>
              <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td colspan="4"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
				  <logic:present name="awvo" scope="request">
				  <logic:iterate id="awvo" name="awvo" scope="request">
                    <tr>
                      <td width="40" height="30">&nbsp;</td>
                      <td width="100">&nbsp;</td>
                      <td colspan="3">&nbsp;</td>
                    </tr>
                    <tr>
                      <td class="time2"><div align="center"><img src="images/comment/man.gif" width="18" height="19"></div></td>
                      <td class="comment_name">${pageScope.awvo.CName}</td>
                      <td width="380" class="time2">[ ${pageScope.awvo.addDate} ]</td>
                      <td width="20" class="comment_name">&nbsp;</td>
                      <td>&nbsp;</td>
                    </tr>
                    <tr>
                      <td>&nbsp;</td>
                      <td colspan="2" class="comment_info">标题：${pageScope.awvo.title}<br>
                        内容：${pageScope.awvo.content}</td>
                      <td colspan="2">&nbsp;</td>
                    </tr>
					</logic:iterate>
					</logic:present>
					<logic:notPresent name="awvo" scope="request">
						<td align="center" colspan="2" class="comment_info">暂无评论</td>
					</logic:notPresent>
                  </table>                    </td>
                </tr>
                <tr>
                  <td width="3%" height="50" class="page"><div align="left"></div></td>
                  <td width="30%" class="page"><form name="photoWordPageForm" action="othercomment.do">
                    <input type="hidden" name="currentPage" value="${requestScope.page.currentPage}">
                    <input type="hidden" name="pageCount" value="${requestScope.page.pageCount}">
                    <input type="hidden" name="photoId" value="${requestScope.photo.id}">
                  </form></td>
                  <td width="45%" class="page">&nbsp;</td>
                  <td width="22%" class="page"><a href="javascript:showCommentForm();">我有话说</a></td>
                </tr>
                <tr>
                  <td height="50" colspan="4" class="page"><div align="right">
				  共${requestScope.page.pageCount}页 当前：
				  ${requestScope.page.currentPage}/${requestScope.page.pageCount}页 
	<a href="javascript:firstPageNew(photoWordPageForm, photoWordPageForm.currentPage.value, photoWordPageForm.pageCount.value)">
				  首页</a> 
	<a href="javascript:prePageNew(photoWordPageForm, photoWordPageForm.currentPage.value, photoWordPageForm.pageCount.value)">
				  上一页</a> 
	<a href="javascript:nextPageNew(photoWordPageForm, photoWordPageForm.currentPage.value, photoWordPageForm.pageCount.value)">
				  下一页</a> 
	 <a href="javascript:lastPageNew(photoWordPageForm, photoWordPageForm.currentPage.value, photoWordPageForm.pageCount.value)">
	    		  尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
                </tr>
                <tr id="commentForm" style="display:none">
                  <td width="3%" height="50" class="page"><div align="left"></div></td>
                  <td width="30%" class="page">&nbsp;</td>
                  <td width="45%" class="page">
						<logic:messagesPresent>
				  	    	<html:messages id="error">
				  		    	<bean:write name="error"/><br>&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;					      	</html:messages>
				        </logic:messagesPresent>	  
				  <jsp:include page="a_add_comment.jsp"/></td>
                  <td width="22%" class="page"></td>
                </tr>
              </table></td>
          </tr>
          <tr>
            <td height="66"><div align="right">
              <table width="100%"  border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td><div align="right"><a href="#" target="_blank"><img src="images/index/copyright.gif" width="255" height="53" border="0"></a></div></td>
                  <td width="9">&nbsp;</td>
                </tr>
              </table>
            </div></td>
          </tr>
        </table></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>
