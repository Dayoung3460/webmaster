getMembers()

function getMembers() {
	fetch('memberJson.do').then((resolve) => {
		return resolve.json()
	}).then((result) => {
		makeList(result)
	}).catch((err) => {
		console.log("err: " + err)
	})
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
function addMember(member) {
	fetch(`memberAddJson.do?mid=${member.mid}&mname=${member.pass}&pass=${member.mname}&phone=${member.phone}`).then((resolve) => {
		return resolve.json()
	}).then((result) => {
		if (result.result) {
			getMembers()
			resetInput()
		} else {
			"member add failed"
		}
	}).catch((err) => {
		console.log("err: " + err)
	})
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

function resetInput() {
	let inputArr = [...document.getElementsByTagName('input')]
	inputArr.forEach((ele) => {
		ele.value = ''
	})
}

function deleteMember(item) {
	fetch(`memberDeleteJson.do?mid=${item.memberId}`).then((resolve) => {
		return resolve.json()
	}).then((result) => {
		if (result.result) {
			getMembers()
		} else {
			console.log('삭제 실패')
		}

	}).catch((err) => {
		console.log("err: " + err)
	})
}



function editMember() {

}
