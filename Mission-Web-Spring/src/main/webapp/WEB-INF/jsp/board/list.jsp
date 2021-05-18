<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="${ pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		$('#newBtn').click(function() {
//			location.href = "${ pageContext.request.contextPath }/jsp/board/writeForm.jsp"
			location.href = "writeForm.jsp"
		})
	}) 
	
	function goDetail(boardNo) {
		location.href = "${ pageContext.request.contextPath}/board/" + boardNo;
		/* location.href = "${ pageContext.request.contextPath}/board/detail?no=" + boardNo; */
		/*
		<c:if test="${ empty userVO}">
			if(confirm('로그인 서비스가 필요합니다\n로그인 페이지로 이동할까요?')){
				location.href= "${pageContext.request.contextPath}/jsp/login/login.jsp"
			}
		</c:if>
		
		<c:if test="${not empty userVO}">
			location.href = "detail.jsp?no=" + boardNo
		</c:if>
			*/
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
		<br>
		<hr>
		<h1>전체게시물 목록</h1>
		<hr>
		<br>
		
		<table border="1" style="width: 100%;">
			<tr>
				<th width="7%">번호</th>
				<th>제목</th>
				<th width="16%">작성자</th>
				<th width="20%">등록일</th>
			</tr>
			<c:forEach items="${ boardList }" var="board">
				<tr>
					<td>${ board.no }</td>
					<td>
						<!-- <a href="/Mission-Web/jsp/board/detail.jsp"> -->
					<%-- 	<a href="detail.jsp?no=${ board.no }"> --%>
						<%-- <a onclick="goDetail(${ board.no })"> --%>
						<a href = "javascript:goDetail(${board.no})">
							<c:out value="${ board.title }" />
						</a>
						<span class="badge bg-info">${board.viewCnt }</span>
						<c:if test="${ fn:length(board.regDate) eq 8 }">
							<span class="badge bg-danger">new</span>
						</c:if>
						<c:if test="${board.viewCnt >=3 }">
							<span class="badge bg-warning"><em>best</em></span>
						</c:if>
						</td>
					<td>${ board.writer }</td>
					<td>${ board.regDate }</td>
				</tr>
			</c:forEach>
		</table>
		<br><br>
		<c:if test="${ not empty userVO }">
			<button id="newBtn">새글등록</button>
		</c:if>
	</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>