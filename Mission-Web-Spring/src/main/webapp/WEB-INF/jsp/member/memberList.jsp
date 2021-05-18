<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css">
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
</head>
	<script>
		function goDetail(boardNo) {
				location.href = "${ pageContext.request.contextPath}/member/" + memberId;
				}
	</script>
<body>
<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
		<br>
		<hr>
		<h1>전체회원 목록</h1>
		<hr>
		<br>
		
		<table border="1" style="width: 100%;">
			<tr>
				<th width="25%">아이디</th>
				<th width= 25%>이름</th>
				<th width="25%">비밀번호</th>
				<th width="25%">가입일</th>
			</tr>
			<c:forEach items="${ memberList }" var="member">
				<tr>
					<td>${ member.id }</td>
					<td>
						<a href = "javascript:goDetail(${member.id})">
							<c:out value="${ member.name }" />
						</a>
					</td>
					<td>${ member.password }</td>
					<td>${ member.regDate }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>