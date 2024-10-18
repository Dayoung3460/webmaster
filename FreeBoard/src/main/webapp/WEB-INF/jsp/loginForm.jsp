<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>로그인(LoginForm.jsp)</h3>
<form class="form-control" action="loginForm.do" method="post">
<table class="table">
	<tr>
		<th>ID</th>
		<td>
			<input type="text" name="logId" />
		</td>
	</tr>
	<tr>
		<th>Password</th>
		<td>
			<input type="password" name="logPw" />
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<button type="submit" class="btn btn-primary">Login</button>
		</td>
	</tr>
</table>
</form>



<jsp:include page="../includes/footer.jsp"></jsp:include>