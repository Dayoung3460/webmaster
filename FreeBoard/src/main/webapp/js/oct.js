document.addEventListener('DOMContentLoaded', function(e) {
	createCalender(document.querySelector('#list'));
})

// 달력생성함수.
function createCalender(target) {
	let firstDay = new Date('2024-10-01').getDay() 
	
	let tr = document.createElement('tr');
	
	
	for (let d = 1; d <= 31; d++) {
		let td = document.createElement('td');
		
		
	
		if(firstDay === d) {
			td.innerHTML = null;
		} else {
			td.innerHTML = day;
			
		}
		
		
		tr.appendChild(td);
		if (d % 7 == 0) {
			document.querySelector('#list').appendChild(tr);
			tr = document.createElement('tr'); // 토요일(7번 td를 생성하면)이 되면 tr을 새롭게 생성.
		}
	}
	target.appendChild(tr);
}