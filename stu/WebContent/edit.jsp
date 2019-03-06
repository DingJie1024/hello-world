<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新学生信息</title>
</head>
<body>
	<h3>更新学生页面</h3>
	<form method="post" action="UpdateServlet">
		<input type="hidden" name="sid" value="${stu.sid }"/>
		<table border="1" width="600">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="sname" value="${stu.sname}"/></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					
					<input type="radio" name="sgender" value="男" <c:if test="${stu.sgender == '男'}">checked</c:if>>男
				 	<input type="radio" name="sgender" value="女" <c:if test="${stu.sgender == '女'}">checked</c:if>>女
				</td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="sphone" value="${sphone }"/></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="text" name="sbirthday" value="${sbirthday }"/></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td>	
					<input type="checkbox" name="shobby" value="吃" <c:if test="${fn:contains(stu.shobby,'吃') }">checked</c:if>>吃
					<input type="checkbox" name="shobby" value="喝" <c:if test="${fn:contains(stu.shobby,'喝') }">checked</c:if>>喝
					<input type="checkbox" name="shobby" value="玩" <c:if test="${fn:contains(stu.shobby,'玩') }">checked</c:if>>玩
					<input type="checkbox" name="shobby" value="乐" <c:if test="${fn:contains(stu.shobby,'乐') }">checked</c:if>>乐
					<input type="checkbox" name="shobby" value="睡" <c:if test="${fn:contains(stu.shobby,'睡') }">checked</c:if>>睡
				</td>
			</tr>
			<tr>
				<td>简介</td>
				<td><textarea name="sinfo" rows="3" cols="20"/>${stu.sinfo }</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="更新" /></td>
			</tr>
		</table>
	</form>
</body>
</html>