<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
<title>북 스토어</title>
</head>
<body>
	<div class="container">
		<h1 class="header">북 스토어</h1>
		<ul class="menu_list">
			<li>
				<a href="book/list">책 목록</a>
			</li>
			<li>
				<a href="customer/list">고객 목록</a>
			</li>
			<li>
				<a href="orders/list">주문 목록</a>
			</li>
		</ul>
	</div>
</body>
</html>