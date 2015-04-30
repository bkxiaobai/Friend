<%@ page contentType="text/html; charset=gbk" language="java"%>
<%@ include file="taglibs.jsp"%>
<br>
<center>
	<font color="blue" size="5"> <b>* * *电子相册管理系统* * *</b> </font>
</center>
<br>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	class="sail">
	<tr>
		<td>
			&nbsp;
		</td>
		<logic:empty name="kinds" scope="session">
			<td>
				暂无任何种类的相册
			</td>
		</logic:empty>

		<logic:notEmpty name="kinds" scope="session">
			<logic:iterate id="kind" name="kinds" scope="session">
				<td width="73">
					<a href="viewalbumsk.do?kindId=${pageScope.kind.id}" class="03"><bean:write
							name="kind" property="name" /> </a>
				</td>
			</logic:iterate>
		</logic:notEmpty>
		<td>
			&nbsp;
		</td>
	</tr>
</table>