<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="user/css/styles.css" rel="stylesheet" />
</head>
<body>
<!--  
	<p>js</p>

	<ul id="show">
		<li>aaa</li>
		<li>bbb</li>
	</ul>

	<table id="table" border="1">
		<tbody>
			<tr>
				<th>이름</th>
				<td>홍</td>
			</tr>
		</tbody>
	</table>
	<div>
		<input class='th' /> <input class='td' />
	</div>

	<button id='button'>add</button>
	
	<hr/>

	<table id='table2' border="2">
		<thead>
			<tr>
				<th>이름</th>
				<td>나이</td>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>

	<button id='button2'>add</button>
	
<hr/>
-->

<table class="table mb-4 addTable">
	<tr>
		<th>ID</th>
		<td><input type="text" id="mid" /></td>
	</tr>
	<tr>
		<th>PASSWORD</th>
		<td><input type="password" id="pass" /></td>
	</tr>
	<tr>
		<th>NAME</th>
		<td><input type="text" id="mname" /></td>
	</tr>
	<tr>
		<th>PHONE</th>
		<td><input type="text" id="phone" /></td>
	</tr>
	<tr>
		<th colspan="2"><button id="addBtn" class="btn btn-primary">등록</button></th>
	</tr>
</table>

<hr/>

<table class="dataTable table">
	<thead>
		<tr>
			<th>memberId</td>
			<th>password</th>
			<th>memberName</th>
			<th>phone</th>
			<th>responsibility</th>
			<th>creationDate</th>
			<th>remove</th>
			<th>edit</th>
		</tr>
	</thead>
	<tbody>
		
	</tbody>
</table>

	

</body>

<script src="js/ajax1.js"></script>
<!--<script src="js/members.js"></script>

<script src="js/data.js"></script>

<script src="js/json.js"></script>
 <script src="js/basic.js"></script> -->


</html>
