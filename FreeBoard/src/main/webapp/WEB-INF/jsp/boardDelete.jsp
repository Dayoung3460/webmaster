<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
		int bno = (Integer) request.getAttribute("bno");
	%>
<h3><%=bno %>번 글을 삭제하시겠습니까?</h3>

<button class="btn btn-warning deleteBtn">예</button>
<button class="btn btn-primary backBtn">아니요</button>
<jsp:include page="../includes/footer.jsp"></jsp:include>

<script>
document.querySelector('.deleteBtn').addEventListener('click', (e) => {
	location.href = 'deleteBoard.do?bno=<%=bno%>&confirm=yes';
})

document.querySelector('.backBtn').addEventListener('click', (e) => {
	history.back();
})
</script>