<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글등록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/board.css">
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
			<hr>
			<h1>새글등록 폼</h1>
			<hr>
			<br>
			<form:form method="post" modelAttribute="boardVO">
				<form:hidden path="writer"/>
				<table style="width: 100%">
					<tr>
						<th width="25%">제목</th>
						<td>
							<form:input path="title"/><form:errors path="title"/>
						</td>
					</tr>
					<tr>
						<th width="25%">작성자</th>
						<td>
							${userVO.id }
						</td>
					</tr>
					<tr>
						<th width="25%">내용</th>
						<td>
							<form:textarea path= "content" /><form:errors path="content"/>
						</td>
					</tr>
				</table>
				<button type="submit">새글등록</button>
			</form:form>
			
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>