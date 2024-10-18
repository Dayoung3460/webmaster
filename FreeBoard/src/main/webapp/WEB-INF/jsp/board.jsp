<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>상세페이지(board.jsp)</h3>
<table class="table">
	<%
	BoardVO board = (BoardVO) request.getAttribute("boardvo");
	SearchDTO search = (SearchDTO) request.getAttribute("search");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String wdate = sdf.format(board.getWriteDate());
	%>
	<tr>
		<th>글번호</th>
		<td><%=board.getBoardNo()%></td>
		<th>조회수</th>
		<td><%=board.getViewCnt()%></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3"><%=board.getTitle()%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><textarea readonly rows="4" cols="30"
				class="form-control"><%=board.getContent()%></textarea></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td colspan="3"><%=board.getWriter()%></td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td colspan="3"><%=wdate%></td>
	</tr>
</table>
<div align="center">
	<!-- 
	<a href="modifyBoard.do?bno=<%=board.getBoardNo()%>"> -->
	<button type="submit" class="btn btn-success modifyBtn">수정</button>
	<!--</a> -->
	<a><button type="submit" class="btn btn-danger deleteBtn">삭제</button></a>

</div>


<jsp:include page="../includes/footer.jsp"></jsp:include>

<script>
	document.querySelector('.modifyBtn').addEventListener('click', (e) => {
		// get method
		location.href = 'modifyBoard.do?bno=<%=board.getBoardNo()%>&currentPage=<%=search.getCurrentPage()%>&searchCondition=<%=search.getSearchCondition()%>&keyword=<%=search.getKeyword()%>';
	})
	
	document.querySelector('.deleteBtn').addEventListener('click', (e) => {
		location.href = 'deleteBoard.do?bno=<%=board.getBoardNo()%>&currentPage=<%=search.getCurrentPage()%>&searchCondition=<%=search.getSearchCondition()%>&keyword=<%=search.getKeyword()%>';
	})
</script>