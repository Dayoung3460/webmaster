let xhtp = new XMLHttpRequest();

getMembers()

function getMembers() {
	xhtp.open('GET', 'memberJson.do', true);
	xhtp.send();

	xhtp.onload = function() {
		let obj = JSON.parse(xhtp.responseText)
		makeList(obj)
	}
}

const FIELDS = ['memberId', 'memberName', 'password', 'phone', 'responsibility', 'creationDate', 'remove', 'edit']
function makeList(data) {
	let tbodyEle = document.querySelector('.dataTable tbody')
	tbodyEle.innerHTML = ''

	data.forEach((item) => {
		let trEle = makeRow(item)

		trEle.addEventListener('mouseover', (e) => {
			e.currentTarget.style.backgroundColor = 'gray'
		})

		trEle.addEventListener('mouseout', (e) => {
			e.currentTarget.style.backgroundColor = 'transparent'
		})


		tbodyEle.appendChild(trEle)
	})
}

function makeRow(item) {
	let trEle = document.createElement('tr')


	FIELDS.forEach((field) => {
		let tdEle = document.createElement('td')
		if (field !== 'remove' && field !== 'edit') {
			tdEle.innerText = item[field]
		} else {
			let btnEle = document.createElement('button')
			btnEle.innerText = field
			tdEle.appendChild(btnEle)

			if (field === 'remove') {
				btnEle.addEventListener('click', (e) => {
					deleteMember(item)
				})
			} else {
				btnEle.addEventListener('click', (e) => {
					editMember(item)
				})
			}

		}

		trEle.appendChild(tdEle)
	})
	return trEle
}
let addBtn = document.getElementById('addBtn')
addBtn.addEventListener('click', (e) => {
	let member = {
		mid: document.getElementById('mid').value,
		pass: document.getElementById('pass').value,
		mname: document.getElementById('mname').value,
		phone: document.getElementById('phone').value
	}
	addMember(member)
})
function addMember(member) {
	xhtp.open('GET', `memberAddJson.do?mid=${member.mid}&mname=${member.pass}&pass=${member.mname}&phone=${member.phone}`, true);
	xhtp.send();

	xhtp.onload = function() {
		let obj = JSON.parse(xhtp.responseText)
		if(obj.result) {
			getMembers()
			resetInput()
		} else {
			console.log("member add failed")
		}
	}
}

function resetInput() {
	let inputArr = [...document.getElementsByTagName('input')]
	inputArr.forEach((ele) => {
		ele.value = ''
	})
}

function deleteMember(item) {
	xhtp.open('GET', `memberDeleteJson.do?mid=${item.memberId}`, true);
	xhtp.send();

	xhtp.onload = function() {
		let obj = JSON.parse(xhtp.responseText)
		if(obj.result) {
			getMembers()
		} else {
			console.log("member add failed")
		}
	}
}
