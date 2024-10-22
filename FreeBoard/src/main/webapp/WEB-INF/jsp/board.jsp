<%@page import="com.yedam.common.SearchDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
		<td>${boardvo.boardNo }</td>
		<th>조회수</th>
		<td>${boardvo.viewCnt }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3">${boardvo.title }</td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><textarea readonly rows="4" cols="30"
				class="form-control"><%=board.getContent()%></textarea></td>
	</tr>

	<c:if test="${ boardvo.image != null }">
		<tr>
			<th>image</th>
			<td><img src="image/${ boardvo.image }"></td>

		</tr>
	</c:if>
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

	<%
	String logIn = (String) session.getAttribute("logId");
	%>
	<%
	if (board.getWriter().equals(logIn)) {
	%>
	<button type="submit" class="btn btn-success modifyBtn">수정</button>

	<a><button type="submit" class="btn btn-danger deleteBtn">삭제</button></a>

	<%
	}
	%>

</div>

<h4>===========================Reply==============================</h4>

<table class="dataTable table">
	<thead>
		<tr>
			<th>replyNo</th>
			<th>reply</th>
			<th>replyer</th>
			<th>replyDate</th>
			<th>remove</th>
		</tr>
	</thead>
	<tbody>

	</tbody>
</table>


<textarea class="form-control" placeholder="write comment"></textarea>
<button class="btn btn-primary addReplyBtn">Done</button>

<script>
	let bno = ${boardvo.boardNo}


	document.querySelector('.modifyBtn')?.addEventListener('click', (e) => {
		// get method
		location.href = 'modifyBoard.do?bno=<%=board.getBoardNo()%>&currentPage=<%=search.getCurrentPage()%>&searchCondition=<%=search.getSearchCondition()%>&keyword=<%=search.getKeyword()%>';
	})
	
	document.querySelector('.deleteBtn')?.addEventListener('click', (e) => {
		location.href = 'deleteBoard.do?bno=<%=board.getBoardNo()%>&currentPage=<%=search.getCurrentPage()%>&searchCondition=<%=search.getSearchCondition()%>&keyword=<%=search.getKeyword()%>';
	})
	
	
</script>
<script src="js/replyService.js"></script>
<script src="js/reply.js"></script>