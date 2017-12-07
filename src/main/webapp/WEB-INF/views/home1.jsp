<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>
		<a href="${pageContext.request.contextPath}/offers"> 지금까지 수강한 교과목</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/createoffer"> 수강 신청하기</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/createoffer3"> 학기별 이수 학점 조회</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/createoffer1"> 이수별 학점 조회</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/createoffer2"> 수강 신청 조회</a>
	</p>


	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>

	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

</body>
</html>