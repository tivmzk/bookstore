<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<title>고객 등록</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>고객 등록</h1>
		</div>
		<form method="post">
			<div class="article">
				<label>고객명</label>
				<select name="cusid">
					<c:forEach var="item" items="${cuslist}">
						<option value="${item.id}">${item.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="article">
				<label>상품명</label>
				<select name="bookid">
					<c:forEach var="item" items="${booklist}">
						<option value="${item.id}">${item.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="menu">
				<div>
					<input type="submit" value="등록">
				</div>
				<div>
					<a href="list">돌아가기</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>