<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/list.css">
</head>
<body>
	<div class="container">
		<div class="header"><h1>책의 목록</h1></div>
		<div class="section">
			<div class="menu">
				<div><a href="add">등록</a></div>
				<div><a href="..">돌아가기</a></div>
				<div><a href="dummy">대량 등록</a></div>
				<div><a href="init">초기화</a></div>
			</div>
			<div class="contents">
				<table>
					<thead>
						<tr>
							<th>이름</th>
							<th>가격</th>
							<th>출판사</th>
							<th>설정</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${list.size() == 0}">
							<tr>
								<td colspan="4">등록된 책이 없습니다.</td>
							</tr>
						</c:if>
						<c:forEach var="item" items="${list}">
							<tr>
								<td>${item.name}</td>
								<td>${item.price}</td>
								<td>${item.publisher}</td>
								<td class="config"><a href="update?id=${item.id}">수정</a> <a href="delete?id=${item.id}">삭제</a></td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
						 <td colspan="4">
						 	<div class="nav">
						 		<div><a href="?page=1">처음으로</a></div>
							 	<div><a href="?page=${pager.prev}">이전</a></div>
							 	<c:forEach var="item" items="${pager.list}">
							 		<div><a class="${item == pager.page ? 'curr' : ''}" href="?page=${item}">${item}</a></div>
							 	</c:forEach>
							 	<div><a href="?page=${pager.next}">다음</a></div>
							 	<div><a href="?page=${pager.last}">끝으로</a></div>
						 	</div>
						 </td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</body>
</html>