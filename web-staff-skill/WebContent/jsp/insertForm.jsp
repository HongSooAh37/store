<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>StaffInsertForm</title>
<style>
	table,td,th{
		border: 1px solid blue;
	}
</style>
</head>
<body>
	<table>
		<form action="<%=request.getContextPath()%>/StaffInsert.do" method="post">
		<tr>
			<td>�̸�</td><td><input type="text" id="name" name="name"></td>
			<td>�ֹε�Ϲ�ȣ</td><td><input type="text" id="sn1" name="sn2">-<input type="text" id="sn2" name="sn2"></td>
			<td>����
			 <select name = religion  size = 1>
	        	<OPTION value = 1 >����</OPTION>
	        	<OPTION value = 2 >�ұ�</OPTION>
	        	<OPTION value = 3 >�⵶��</OPTION>
	        	<OPTION value = 4 >õ�ֱ�</OPTION>
	        </select>
		</tr>
		<tr>
			<td>�з�</td>
			<td>
			 <input type = radio name = graduateday value = 1 > ����
			<input type = radio name = graduateday value = 2 > ��������
			<input type = radio name = graduateday value = 3 > �Ϲݴ���
			</td>
			<td>���</td>
			<td>
			<input type = checkbox name = skill  value = java> java
			<input type = checkbox name = skill  value = html5> html5
			<input type = checkbox name = skill  value = JSP> JSP		
			<input type = checkbox name = skill  value = SQL> SQL
			<input type = checkbox name = skill  value = javascript>javascript
			</td>
		</tr>
		<tr>
			<td>������</td><td><input type="date" name="graduateday"></td>
		</tr>
		<tr>
			<p style="text-align:center">
			<em><td><input type="submit" value="���"><input type="reset" value="�ʱ�ȭ"></td></em>
			</p>
		</tr>
		</form>
	</table>
</body>
</html>