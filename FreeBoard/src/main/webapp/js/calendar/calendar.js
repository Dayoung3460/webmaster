

const calendarInit = (events) => {
	console.log('calendar')
	let calendarEl = document.getElementById('calendar');

	let date = new Date()
	let today = `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()}`



	let calendar = new FullCalendar.Calendar(calendarEl, {
		headerToolbar: {
			left: 'prev,next today',
			center: 'title',
			right: 'dayGridMonth,timeGridWeek,timeGridDay'
		},
		initialDate: today,
		navLinks: true, // can click day/week names to navigate views
		selectable: true,
		selectMirror: true,

		select: function(arg) {
			openModalToAdd(arg, calendar)
		},

		eventClick: function(arg) {


			openModalToDelete(arg)
		},

		eventChange: (e) => changeEvent(e.event),
		editable: true,
		droppable: true,
		dayMaxEvents: true, // allow "more" link when too many events. false: 달력 하루 네모 칸이 길어짐
		events: events, // groupId: 999, url: 'http://google.com/', start: '2023-01-09T16:00:00', end: '2023-01-10'

	});

	calendar.render();


}

const openModalToDelete = (arg) => {
	console.log(1111);

	let inputBody = document.getElementById('input-body')
	inputBody.classList.remove('show')
	inputBody.classList.add('hide')
	let cancelBody = document.getElementById('cancel-body')
	cancelBody.classList.remove('hide')
	cancelBody.classList.add('show')

	let target = arg.jsEvent.target
	target.setAttribute('data-bs-toggle', 'modal')
	target.setAttribute('data-bs-target', '#exampleModal')
	target.click()

	let modal = document.getElementById('exampleModal')


	modal.addEventListener('shown.bs.modal', () => {
		let addEventBtn = document.getElementsByClassName('addEventBtn')[0]

		addEventBtn.addEventListener('click', () => {
			if (arg.event.id) {
				deleteEvent(arg.event.id)
				arg.event.remove()
			} else {
				alert('삭제 실패')
			}

		})
	})

}

let obj = {
	inputTitle: '',
	startDate: '',
	endDate: '',
	allDay: '',
	calendar: '',
}

const saveData = () => {
	console.log('addEventBtn.addEventListener')
	if (obj.inputTitle.value) {
		let eventData = {
			title: obj.inputTitle.value,
			start: obj.startDate,
			end: obj.endDate,
			allDay: obj.allDay
		}
		setNewEvent(eventData)
		obj.calendar.addEvent(eventData)
		obj.calendar.unselect()

		eventData = {}
	}
}



const clickSave = (inputTitle, startDate, endDate, allDay, calendar) => {
	let addEventBtn = document.getElementsByClassName('addEventBtn')[0]
	addEventBtn.removeEventListener('click', saveData)

	obj.inputTitle = inputTitle
	obj.startDate = startDate
	obj.endDate = endDate
	obj.allDay = allDay
	obj.calendar = calendar

	addEventBtn.addEventListener('click', saveData)
}


function setModalData(arg, calendar) {
	let newArg = arg
	let inputTitle = document.getElementsByClassName('inputTitle')[0];
	let inputStartDate = document.getElementsByClassName('inputStartDate')[0];
	let inputEndDate = document.getElementsByClassName('inputEndDate')[0];

	let endDate = arg.end;



	inputTitle = document.getElementsByClassName('inputTitle')[0];
	inputTitle.focus();

	inputStartDate = document.getElementsByClassName('inputStartDate')[0];
	inputEndDate = document.getElementsByClassName('inputEndDate')[0];

	endDate = newArg.end;

	if (formatDate(newArg.end).split('T')[1] === '00:00:00') {
		endDate = new Date(newArg.end);
		endDate.setDate(endDate.getDate() - 1);
	}

	inputStartDate.value = formatDate(newArg.start, false);
	inputEndDate.value = formatDate(endDate, false);

	console.log(2, newArg)
	clickSave(inputTitle, newArg.start, newArg.end, newArg.allDay, calendar);

	inputTitle = ''
	inputStartDate = ''
	inputEndDate = ''
	endDate = ''

}

const openModalToAdd = (arg, calendar) => {
	let target = arg.jsEvent.target;
	target.setAttribute('data-bs-toggle', 'modal');
	target.setAttribute('data-bs-target', '#exampleModal');
	target.click();
	target.removeAttribute('data-bs-toggle');
	target.removeAttribute('data-bs-target');

	let modal = null
	modal = document.getElementById('exampleModal');

	let inputBody = document.getElementById('input-body');
	inputBody.classList.remove('hide');
	inputBody.classList.add('show');
	let cancelBody = document.getElementById('cancel-body');
	cancelBody.classList.remove('show');
	cancelBody.classList.add('hide');

	let inputTitle = document.getElementsByClassName('inputTitle')[0];
	inputTitle.value = '';


	setModalData(arg, calendar)
};




const changeEvent = (event) => {
	let changedEvent = {
		eventNo: event.id,
	}

	if (event.allDay) {
		changedEvent.startDate = formatDate(event.start, false)
		changedEvent.endDate = formatDate(event.end, false)
	} else {
		changedEvent.startDate = formatDate(event.start)
		changedEvent.endDate = formatDate(event.end)
	}

	updateEvent(changedEvent)
}

const formatDate = (dateString, withTime = true) => {
	const date = new Date(dateString);

	const year = date.getFullYear();
	const month = String(date.getMonth() + 1).padStart(2, '0');
	const day = String(date.getDate()).padStart(2, '0');
	const hours = String(date.getHours()).padStart(2, '0');
	const minutes = String(date.getMinutes()).padStart(2, '0');
	const seconds = String(date.getSeconds()).padStart(2, '0');

	if (withTime) {
		return `${year}-${month}-${day}T${hours}:${minutes}:${seconds}`;
	} else {
		return `${year}-${month}-${day}`
	}
}

const setNewEvent = (eventData) => {
	let newEvent = {
		title: eventData.title,
	}

	if (eventData.allDay) {
		newEvent.startDate = formatDate(eventData.start, false)
		newEvent.endDate = formatDate(eventData.end, false)
	} else {
		newEvent.startDate = formatDate(eventData.start)
		newEvent.endDate = formatDate(eventData.end)
	}

	addEvent(newEvent)
}

const setEventData = (list) => {
	let events = []

	list.forEach((data) => {
		let event = {
			title: data.title,
			start: data.startDate,
			id: data.eventNo
		}
		if (data.endDate) {
			event.end = data.endDate
		}

		events.push(event)
	})

	return events
}

const getEventListPromise = () => {
	return new Promise((resolve, reject) => {
		getEventList((resultData) => {
			if (resultData) {
				resolve(resultData);
			} else {
				reject("No data found");
			}
		});
	});
};

const init = async () => {
	let list = await getEventListPromise()
	console.log(list)
	let events = setEventData(list)
	calendarInit(events)
}

init()

/** 
getEventList((result) => {
	console.log(result)
	let events = setEventData(result)
	calendarInit(events)
});

*/












