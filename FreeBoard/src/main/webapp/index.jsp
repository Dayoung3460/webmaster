<%@page import="com.yedam.service.MemberService"%>
<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="com.yedam.service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	String myName = "dayoung";
	MemberService svc = new MemberServiceImpl();
	if(svc.retireMember("mvc test")) {
%>
	<p>삭제되었습니다.</p>
	<%} else{ %>
	<p>회원정보가 없습니다.</p>
<%} %>

	<h3>내 이름은 <%=myName %>입니다</h3>
	<a href='memberList.do'>memberList.do</a>
</body>
</html>