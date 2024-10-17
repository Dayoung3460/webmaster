<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>글 작성(boardAddForm.jsp)</h3>

<% String msg = (String) request.getAttribute("msg");%>
<%if(msg != null){ %>
<p class="text-danger"><%=msg %></p>
<% }%>

<form class="form-control" action="addBoard.do" method="get">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input class="form-control" type="text" name="title" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="4" cols="30" name="content"
					class="form-control"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input class="form-control" type="text" name="writer" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input class="btn btn-primary" type="submit" value="저장" /> 
				<input class="btn btn-warning" type="submit" value="취소" />
			</td>
		</tr>

	</table>
</form>

<jsp:include page="../includes/footer.jsp"></jsp:include>