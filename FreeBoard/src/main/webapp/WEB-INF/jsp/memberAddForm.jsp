<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>Add Member</h3>
<form action="memberAdd.do" method="get" class="form-control">
	id: <input type="text" name="mid" /><br/>
	name: <input type="text" name="mname" /><br/>
	password: <input type="password" name="pass" /><br/>
	phone: <input type="text" name="phone" /><br/>
	<input class="btn btn-primary" type="submit"/>
	</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>