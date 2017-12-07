<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resource/css/main.css">
</head>
<body>
<form method="post"
		action="${pageContext.request.contextPath }/docreate">
		
	<table class="formtable">
		<tr><td class="label"> 연도 : </td> <td> <input class="control" type="text" name="year"/></td></tr>
		<tr><td class="label"> 학기 : </td> <td> <input class="control" type="text" name="semester"/></td></tr>
		<tr><td class="label"> 과목코드 : </td> <td> <input class="control" type="text" name="code"/></td></tr>
		<tr><td class="label"> 수강과목: </td> <td> <input class="control" type="text" name="name"/></td></tr>
		<tr><td class="label"> 구분: </td> <td> <input class="control" type="text" name="divide"/></td></tr>
		<tr><td class="label"> 학점 : </td> <td> <input class="control" type="text" name="credit"/></td></tr>
		
		<tr>
				<td class="lable"></td>
				<td><input class="control" type="submit" value="수강 신청" /></td>
			</tr>
		
	</table>
		
</form>
</body>
</html>