let delBtn = document.getElementById('delBtn')

delBtn.addEventListener('click', (e) => {
	let userValue = document.getElementById('userValue')
	let list = document.querySelectorAll('#listBox span')
	
	list.forEach((item) => {
		if(item.innerText === userValue.value) {
			item.style.display = 'none'
			userValue = ''
		}
	})
})