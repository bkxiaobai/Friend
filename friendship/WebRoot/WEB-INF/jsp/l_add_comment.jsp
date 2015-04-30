<%@ page contentType="text/html; charset=gbk" language="java" %>
<%@ include file="taglibs.jsp"%>
<html:form action="addComment.do" onsubmit="return validateCommentForm(this)">
  <table width="100%"  border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="40" height="30">&nbsp;</td>
      <td width="150" class="sayabout">我有话要说</td>
    </tr>
    <tr>
      <td height="20" class="Statistic2">标题：</td>
      <td><input name="title" type="text" class="input" size="15"></td>
    </tr>
    <tr>
      <td height="20" class="Statistic2">内容：</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><textarea name="content" cols="23" rows="5" class="input3"></textarea></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input type="hidden" name="photoId" value="${requestScope.photo.id}"></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;&nbsp;&nbsp;<input name="Submit" type="submit" class="input" value="发表评论">        </td>
    </tr>
  </table>
</html:form>