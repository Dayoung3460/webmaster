const getEventList = (success) => {
	fetch('eventList.do')
		.then((resolve) => {
			return resolve.json()
		}).then(success)
		.catch((err) => {
			console.log(err)
		})
}

const addEvent = (newEvent, success) => {
	let url = `addEvent.do?title=${newEvent.title}&startDate=${newEvent.startDate}`
	if(newEvent.endDate) {
		url += `&endDate=${newEvent.endDate}`
	}
	
	fetch(url)
		.then((resolve) => {
			return resolve.json()
		}).then(success)
		.catch((err) => {
			console.log(err)
		})
}

const updateEvent = (changedEvent, success) => {
	let url = `updateEvent.do?eventNo=${changedEvent.eventNo}&startDate=${changedEvent.startDate}`
	if(changedEvent.endDate) {
		url += `&endDate=${changedEvent.endDate}`
	}
	
	fetch(url)
		.then((resolve) => {
			return resolve.json()
		}).then(success)
		.catch((err) => {
			console.log(err)
		})
}

const deleteEvent = (eventNo, success) => {
	fetch(`deleteEvent.do?eventNo=${eventNo}`)
		.then((resolve) => {
			return resolve.json()
		}).then(success)
		.catch((err) => {
			console.log(err)
		})
}