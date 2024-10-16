<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
<jsp:include page="../includes/header.jsp"></jsp:include>


<h3>Member List</h3>
<% 
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("memberList");
	%>
	<table border="2" class="table">
	<tbody>
	<tr>
	<td>id</td>
	<td>name</td>
	<td>phone</td>
	<td>삭제</td>
	</tr>
	
	
	<%
	for(MemberVO mvo : list) {
		%>
			<tr>
			<td><%=mvo.getMemberId() %></td>
			<td><%=mvo.getMemberName() %></td>
			<td><%=mvo.getPhone() %></td>
			<td>
			<form action="memberDelete.do" >
			<input name="mid" value=<%=mvo.getMemberId() %> hidden="true"/>
			<button class="btn btn-danger" type=submit>삭제</button>
			</form>
			</td>
			</tr>
	<% }%>
</tbody>
</table>	
<a class="btn btn-success" href='memberAddForm.do'>추가</a>

<jsp:include page="../includes/footer.jsp"></jsp:include>