<%@ page contentType="text/html; charset=gbk" language="java"%>
<%@ include file="taglibs.jsp"%>
<br>
<center>
	<font color="blue" size="5"> <b>* * *����������ϵͳ* * *</b> </font>
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
				�����κ���������
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