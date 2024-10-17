<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>글 수정(boardModifyForm.jsp)</h3>

<%
BoardVO board = (BoardVO) request.getAttribute("boardvo");
%>


<form class="form-control" action="modifyBoard.do" method="post">
	<table class="table">
	  
		<tr>
			<th>글번호</th>
			<td><input readonly class="form-control" type="number" name="bno"
				value="<%=board.getBoardNo()%>" /></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><input readonly disabled class="form-control" type="text"
				name="viewCnt" value="<%=board.getViewCnt()%>" /></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input class="form-control" type="text" name="title"
				value="<%=board.getTitle()%>" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="4" cols="30" name="content"
					class="form-control"><%=board.getContent()%></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input readonly disabled class="form-control" type="text" name="writer"
				value="<%=board.getWriter()%>" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input class="btn btn-primary"
				type="submit" value="저장" /> <input class="btn btn-danger"
				type="submit" value="취소" /></td>
		</tr>
	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>