<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/board.css">
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
<script>
	function goList() {
		location.href = "${ pageContext.request.contextPath}/board"		
	}
	function goDelete() {
		if(confirm('${board.no}번 게시글을 삭제할까요?')){
			location.href = "${pageContext.request.contextPath}/board/delete/${board.no}"
		}
		
	}
	
	function getReplyList(){
		
		$('#replyList').empty()
		
		$.ajax({
			url: '${pagerContext.request.contextPath}/reply/${board.no}'
			, success : function(responseData){
				let replyList = JSON.parse(responseData)
				
				for(let reply of replyList){
					let data = '<hr>'
					data += '<div>'
					data += '<strong>' + reply.content+ '</strong>'
					data += '(' + reply.writer + ')'
					data += '&nbsp;&nbsp;&nbsp;' + reply.regDate
					data += '</div>'
					
					$('#replyList').append(data)
					
				}
				
			}, error : function(){
				alert('실패')	
			}
		})
	}
	
	$(document).ready(function(){
		getReplyList()
	})
	
	$(document).ready(function(){
		$('#replyBtn').click(function(){
			let content = document.replyForm.content
			let writer = document.replyForm.writer

			$.ajax({
				url: '${pageContext.request.contextPath}/reply'
				,type: 'post'
				, data: {
					content: content.value
					, writer : writer.value
					, boardNo : ${board.no}
				}, success: function(){
					alert('댓글추가 성공')
					getReplyList()
					content.value=''
					writer.value=''
				}, error : function(){
					alert('댓글추가 실패')
				}
			})
		})
	})
</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
		<hr>
		<h1>게시물 상세</h1>
		<hr>
		<br>
		
		<table border="1" style="width:100%">
			<tr>
				<th width="25%">번호</th>
				<td>${ board.no }</td>
			</tr>
			<tr>
				<th width="25%">제목</th>
				<td>${ board.title }</td>
			</tr>
			<tr>
				<th width="25%">작성자</th>
				<td>${ board.writer }</td>
			</tr>
			<tr>
				<th width="25%">내용</th>
				<td>${ board.content }</td>
			</tr>
			<tr>
				<th width="25%">조회수</th>
				<td>${ board.viewCnt }</td>
			</tr>
			<tr>
				<th width="25%">등록일</th>
				<td>${ board.regDate }</td>
			</tr>
		</table>
		<br><br>
		<button onclick="goList()">목  록</button>
		<button onclick="goDelete()">삭  제</button>
		
		<form name ="replyForm">
			댓글 :<input type="text" name ="content" size="50">
			이름 :<input type ="text" name ="writer" size="10">
			<input type ="button" value="댓글추가" id="replyBtn">
		</form>
		
		<div id="replyList" >
		</div>
		
	</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>