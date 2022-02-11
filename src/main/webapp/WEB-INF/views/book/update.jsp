<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<div class="article">
				<label>이름</label>
				<input type="text" required="required" name="name" value="${item.name}">
			</div>
			<div class="article">
				<label>가격</label>
				<input type="number" required="required" name="price" value="${item.price}">
			</div>
			<div class="article">
				<label>출판사</label>
				<input type="text" required="required" name="publisher" value="${item.publisher}">
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