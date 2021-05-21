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
			<h1>회원가입 폼</h1>
			<hr>
			<br>
			<form:form method="post" modelAttribute="MemberVO">
				<table style="width: 100%">
					<tr>
						<th width="20%">아이디</th>
						<td>
							<form:input path="id"/><form:errors path="id"/>
						</td>
					</tr>
					<tr>
						<th width="20%">비밀번호</th>
						<td>
							<form:input path="password"/><form:errors path="password"/>
						</td>
					</tr>
					<tr>
						<th width="20%">이름</th>
						<td>
							<form:textarea path= "name" /><form:errors path="name"/>
						</td>
					</tr>
					<tr>
						<th width="20%">이메일아이디</th>
						<td>
							<form:textarea path= "email_id" /><form:errors path="id"/>
						</td>
					</tr>
					<tr>
						<th width="20%">이메일 도메인</th>
						<td>
							<form:textarea path= "email_domain" /><form:errors path="domain"/>
						</td>
					</tr>
				</table>
				<button type="submit">회원가입</button>
			</form:form>
			
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>