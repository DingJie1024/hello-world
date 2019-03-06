<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加学生</title>
</head>
<body>

	<form method="post" action="AddStudentServlet">
		<table border="1" width="600">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="sname" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" name="sgender" value="男" />男 <input
					type="radio" name="sgender" value="女" />女</td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="sphone" /></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="text" name="sbirthday" /></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td>
				<input type="checkbox" name="shobby" value="吃" />吃 <input
					type="checkbox" name="shobby" value="喝" />喝 <input type="checkbox"
					name="shobby" value="玩" />玩 <input type="checkbox" name="shobby"
					value="乐" />乐 <input type="checkbox" name="shobby" value="睡" />睡</td>
			</tr>
			<tr>
				<td>简介</td>
				<td><textarea name="sinfo" rows="3" cols="20"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="添加" /></td>
			</tr>
		</table>
	</form>
</body>
</html>