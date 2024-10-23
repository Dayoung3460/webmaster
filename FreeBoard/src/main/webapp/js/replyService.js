

/**
const svc = {
	rlist: (bno, successFnc, failFnc) => {
		fetch(`replyList.do?bno=${bno}`).then((resolve) => {
			return resolve.json()
		}).then(successFnc).catch(failFnc)
	}
}
 */

const getReplyList = (param = {bno, currentPage}, success) => {
	fetch(`replyList.do?bno=${param.bno}&currentPage=${param.currentPage}`)
		.then((resolve) => {
			return resolve.json()
		}).then(success)
		.catch((err) => {
			console.log(err)
		})
}

const getReplyCount = (bno, success) => {
	fetch(`countReply.do?bno=${bno}`)
		.then((resolve) => {
			return resolve.json()
		}).then(success)
		.catch((err) => {
			console.log(err)
		})
}


const addReply = (reply, bno, success) => {
	fetch(`addReply.do?reply=${reply}&bno=${bno}`).then((resolve) => {
		return resolve.json()
	}).then(success).catch((err) => {
		console.log(err)
	})
}

const deleteReply = (replyNo, success) => {
	fetch(`deleteReply.do?replyNo=${replyNo}`).then((resolve) => {
		return resolve.json()
	}).then(success).catch((err) => {
		console.log(err)
	})
}

const editReply = (replyNo, reply, success) => {
	fetch(`updateReply.do?replyNo=${replyNo}&reply=${reply}`).then((resolve) => {
		return resolve.json()
	}).then(success).catch((err) => {
		console.log(err)
	})
}

