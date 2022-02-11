<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setting.css">
<title>책 수정</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>책 수정</h1>
		</div>
		<form method="post">
			<input type="hidden" value="${item.id}" name="id">
			<input type="hidden" value="${item.cusid}" name="cusid">
			<div class="article">
				<label>고객명</label>
				<input type="text" readonly="readonly" value="${item.cusname}">
			</div>
			<div class="article">
				<label>상품명</label>
				<select name="bookid">
					<c:forEach var="book" items="${booklist}">
						<option value="${book.id}">${book.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="menu">
				<div>
					<input type="submit" value="완료">
				</div>
				<div>
					<a href="list">돌아가기</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>