

/**
const svc = {
	rlist: (bno, successFnc, failFnc) => {
		fetch(`replyList.do?bno=${bno}`).then((resolve) => {
			return resolve.json()
		}).then(successFnc).catch(failFnc)
	}
}
 */

const getList = (bno, success, fail) => {
	fetch(`replyList.do?bno=${bno}`).then((resolve) => {
			return resolve.json()
		}).then(success).catch(fail)
}



const writeReply = (bno, success, fail) => {
	fetch(`replyList.do?bno=${bno}`).then((resolve) => {
			return resolve.json()
		}).then(success).catch(fail)
}

const showList = (data) => {
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

const FIELDS = ['replyNo', 'reply', 'replyer', 'replyDate', 'remove']
const makeRow = (item) => {
	let trEle = document.createElement('tr')


	FIELDS.forEach((field) => {
		let tdEle = document.createElement('td')
		if (field !== 'remove') {
			tdEle.innerText = item[field]
		} else {
			let btnEle = document.createElement('button')
			btnEle.innerText = field
			tdEle.appendChild(btnEle)

			if (field === 'remove') {
				btnEle.addEventListener('click', (e) => {
					deleteMember(item)
				})
			}
		}

		trEle.appendChild(tdEle)
	})
	return trEle
}