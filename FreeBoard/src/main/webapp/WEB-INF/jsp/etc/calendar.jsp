<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='js/calendar/dist/index.global.js'></script>
<script src='js/calendar/calendarService.js'></script>

<style>
#calendar {
	max-width: 1100px;
	margin: 40px auto;
}

#listBox .container {
	width: 400px;
	background-color: antiquewhite;
}

#listBox .container span {
	display: inline-block;
	width: 90px;
	background-color: yellow;
	margin: 2px;
}
</style>
</head>
<body>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Event</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body hide" id="input-body">
					<div class="mb-4">
						<span>Title</span> <input type="text" class="inputTitle" />
					</div>
					<div class="mb-4">
						<span>Start Date</span> <input type="Date" class="inputStartDate" />
					</div>
					<div class="mb-4">
						<span>End Date</span> <input type="Date" class="inputEndDate" />
					</div>

				</div>
				<div class="modal-body hide" id="cancel-body">
					<p>삭제하시겠습니까</p>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary addEventBtn"
						data-bs-dismiss="modal">Save changes</button>
				</div>
			</div>
		</div>
	</div>

	<div id='calendar'></div>

	<div id='listBox'>
		<input type="text" id="userValue">
		<button id="delBtn">삭제</button>
		<div class="container">
			<span>Lorem</span> <span>ipsum</span> <span>dolor</span> <span>sit</span>
			<span>amet</span> <span>consectetur,</span> <span>adipisicing</span>
			<span>elit.</span> <span>Maxime</span> <span>voluptate,</span> <span>itaque</span>
			<span>quibusdam</span> <span>vitae</span> <span>ipsa</span> <span>ut,</span>
			<span>cum</span> <span>explicabo</span> <span>cumque</span> <span>omnis</span>
			<span>modi,</span> <span>harum</span> <span>repudiandae</span> <span>eius</span>
			<span>deserunt</span> <span>voluptas</span> <span>unde</span> <span>corporis</span>
			<span>earum</span> <span>id</span> <span>libero.</span>
		</div>

	</div>

	<div id="oct">
		<table border="1">
			<thead>
				<tr>
					<th>Sun</th>
					<th>Mon</th>
					<th>Tue</th>
					<th>Wed</th>
					<th>Thr</th>
					<th>Fri</th>
					<th>Sat</th>
				</tr>
			</thead>
			<tbody id="list"></tbody>
		</table>

	</div>


</body>
<script src='js/calendar/calendar.js'></script>
<script src='js/list.js'></script>
<script src='js/oct.js'></script>



</html>
