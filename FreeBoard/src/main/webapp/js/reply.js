

let replyTextarea = document.getElementsByClassName('replyTextarea')[0]
let addReplyBtn = document.getElementsByClassName('addReplyBtn')[0]

let currentPage = 1
let totalCnt = 0
let startPage, endPage, realEnd
let prev, next



const createPageList = () => {
	if (currentPage > realEnd) {
		currentPage = realEnd
	}
	endPage = Math.ceil(currentPage / 5) * 5
	startPage = endPage - 4

	realEnd = Math.ceil(totalCnt / 5)
	endPage = endPage > realEnd ? realEnd : endPage

	prev = startPage > 1
	next = endPage < realEnd

	console.log('currentPage', currentPage)
	console.log('startPage', startPage)
	console.log('endPage', endPage)
	console.log('realEnd', realEnd)
	console.log('prev', prev)
	console.log('next', next)
}

const printPageList = () => {
	let pageList = document.getElementsByClassName('pageList')[0]
	pageList.innerHTML = ''

	let previousBtn = document.getElementsByClassName('previous')[0]
	previousBtn.classList.remove('show')
	previousBtn.classList.remove('hide')

	let nextBtn = document.getElementsByClassName('next')[0]
	nextBtn.classList.remove('show')
	nextBtn.classList.remove('hide')

	if (prev) {
		previousBtn.classList.add('show')
		previousBtn.addEventListener('click', (e) => {
			e.preventDefault()
			currentPage = startPage - 1
			if (currentPage <= 0 || currentPage > realEnd) {
				return
			}
			getReplyList({ bno, currentPage }, (result) => { showList(result) })
			createPageList()
			printPageList()
		})
	} else {
		previousBtn.classList.add('hide')
	}

	if (next) {
		nextBtn.classList.add('show')
		nextBtn.addEventListener('click', (e) => {
			e.preventDefault()
			currentPage = endPage + 1
			if (currentPage <= 0 || currentPage > realEnd) {
				return
			}
			getReplyList({ bno, currentPage }, (result) => { showList(result) })
			createPageList()
			printPageList()
		})
	} else {
		nextBtn.classList.add('hide')
	}

	for (let i = startPage; i <= endPage; i++) {
		let pageLiEle = document.createElement('li')
		pageLiEle.classList.add('page-item')
		let aEle = document.createElement('a')
		aEle.classList.add('page-link')
		aEle.innerText = i

		aEle.addEventListener('click', (e) => {
			e.preventDefault()
			currentPage = e.currentTarget.innerText
			if (currentPage <= 0 || currentPage > realEnd) {
				return
			}
			getReplyList({ bno, currentPage }, (result) => { showList(result) })
		})

		pageList.appendChild(pageLiEle.appendChild(aEle))
	}

}
const movePage = () => {
	let aNodeList = document.querySelectorAll('.paginationNav a')
	aNodeList.forEach((aEle) => {
		aEle.addEventListener('click', (e) => {
			e.preventDefault()

			if (aEle.getAttribute('aria-label') === 'Next') {
				currentPage = endPage + 1
				if (currentPage <= 0 || currentPage > realEnd) {
					return
				}
				createPageList()
				printPageList()
				getReplyList({ bno, currentPage }, (result) => { showList(result) })
			} else if (aEle.getAttribute('aria-label') === 'Previous') {
				currentPage = startPage - 1
			} else {
				currentPage = aEle.innerText
				if (currentPage <= 0 || currentPage > realEnd) {
					return
				}
				getReplyList({ bno, currentPage }, (result) => { showList(result) })
			}
		})
	})
}


const makeList = (result) => {
	// cloneNode(true): 하위요소 모두 클론하겠다

	result.forEach((item) => {
		let template = document.getElementById('replyList').cloneNode(true);
		let ulEle = document.querySelector('.reply ul');
		let replyNo = document.querySelector('#replyList span:nth-of-type(1)');
		replyNo.innerText = item.replyNo
		let reply = document.querySelector('#replyList span:nth-of-type(2)');
		reply.innerText = item.reply
		let replyer = document.querySelector('#replyList span:nth-of-type(3)');
		replyer.innerText = item.replyer
		let deleteEle = document.querySelector('#replyList span:nth-of-type(4)');
		let btn = document.createElement('button')
		deleteEle.appendChild(btn)
		btn.innerText = 'Delete'
		ulEle.appendChild(template)
	})


}

const showList = (data) => {
	console.log('data', data)
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

const FIELDS = ['replyNo', 'reply', 'replyer', 'replyDate', 'remove', 'edit']
const makeRow = (item) => {
	let trEle = document.createElement('tr')


	FIELDS.forEach((field) => {
		let tdEle = document.createElement('td')
		if (field === 'reply') {
			let textareaEle = document.createElement('textarea')
			textareaEle.className = 'form-control editTextarea'
			textareaEle.readOnly = true
			textareaEle.value = item[field]
			tdEle.appendChild(textareaEle)

		} else if (field == 'replyNo' || field === 'replyer' || field === 'replyDate') {
			tdEle.innerText = item[field]

			// 로그인한 사용자와 댓글 단 사람이 같은 사람일 때
			// 댓글 삭제 및 수정 가능
		} else if (item.replyer === logId) {
			let btnEle = document.createElement('button')
			btnEle.innerText = field
			btnEle.classList.add('btn')
			btnEle.classList.add('btn-warning')
			tdEle.appendChild(btnEle)

			if (field === 'remove') {

				btnEle.addEventListener('click', (e) => {
					deleteReply(item.replyNo, (result) => {
						if (currentPage <= 0 || currentPage > realEnd || !result) {
							return
						}

						getReplyCount(bno, (result) => {
							console.log('remove2')
							totalCnt = result.replyCount
							createPageList()
							printPageList()

							getReplyList({ bno, currentPage }, (result) => { showList(result) })
						})


					}
					)
				})
			} else if (field === 'edit') {
				btnEle.addEventListener('click', (e) => {
					let rowEle = e.currentTarget.parentElement.parentElement
					let replyEle = rowEle.getElementsByTagName('textarea')[0]
					replyEle.readOnly = false
					replyEle.classList.remove("editTextarea");
					btnEle.style.display = 'none'

					let newBtnEle = document.createElement('button')
					newBtnEle.innerText = '수정 완료'
					newBtnEle.classList.add('btn')
					newBtnEle.classList.add('btn-success')
					tdEle.appendChild(newBtnEle)

					newBtnEle.addEventListener('click', (e) => {
						editReply(item.replyNo, item.reply, (result) => {
							result && getReplyList({ bno, currentPage }, (result) => { showList(result) }
							)
						}
						)
					})

				})
			}
		}

		trEle.appendChild(tdEle)
	})
	return trEle
}


addReplyBtn.addEventListener('click', (e) => {
	if (!logId) {
		alert('로그인 후 사용해주세요')
		return
	}
	addReply(replyTextarea.value, bno, (result) => {
		if (result) {
			getReplyList({ bno, currentPage }, (result) => {
				showList(result)
			})
			replyTextarea.value = ''
			currentPage = 1
			printPageList()
			movePage()
		}
	})
})


getReplyList({ bno, currentPage }, (result) => { showList(result) })


getReplyCount(bno, (result) => {
	totalCnt = result.replyCount
	createPageList()
	printPageList()
})








