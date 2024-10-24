

const calendarInit = (events) => {
	var calendarEl = document.getElementById('calendar');

	let date = new Date()
	let today = `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()}`

	var calendar = new FullCalendar.Calendar(calendarEl, {
		
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

			var title = prompt('Event Title:');
			if (title) {
				let eventData = {
					title: title,
					start: arg.start,
					end: arg.end,
					allDay: arg.allDay
				}
				setNewEvent(eventData)
				calendar.addEvent(eventData)
			}

			calendar.unselect()
		},
		eventClick: function(arg) {
			if (confirm('Are you sure you want to delete this event?')) {
				removeEvent(arg.event.id)
				arg.event.remove()
			}
		},
		eventChange: (e) => changeEvent(e.event),

		/**
		eventMouseEnter: function(mouseEnterInfo) {
			
			console.log(mouseEnterInfo)
			console.log(event)
			console.log(el)
			console.log(jsEvent)
			console.log(view)
			
		},
		 */
		editable: true,
		droppable: true,
		dayMaxEvents: true, // allow "more" link when too many events. false: 달력 하루 네모 칸이 길어짐
		events: events, // groupId: 999, url: 'http://google.com/', start: '2023-01-09T16:00:00', end: '2023-01-10'

	});

	calendar.render();

	
}

const removeEvent = (id) => {
	deleteEvent(id)
}

const changeEvent = (event) => {
	console.log(event)
	let changedEvent = {}
	
	if (event.allDay) {
		formattedStartDate = formatDate(event.start, false);
		changedEvent = {
			eventNo: event.id,
			startDate: formattedStartDate
		}
	} else {
		
		formattedStartDate = formatDate(event.start);
		formattedEndDate = formatDate(event.end);

		changedEvent = {
			eventNo: event.id,
			startDate: formattedStartDate,
			endDate: formattedEndDate
		}
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
	let formattedStartDate = ''
	let formattedEndDate = ''
	let newEvent = {}

	if (eventData.allDay) {
		formattedStartDate = formatDate(eventData.start, false);
		newEvent = {
			title: eventData.title,
			startDate: formattedStartDate
		}
	} else {
		formattedStartDate = formatDate(eventData.start);
		formattedEndDate = formatDate(eventData.end);

		newEvent = {
			title: eventData.title,
			startDate: formattedStartDate,
			endDate: formattedEndDate
		}
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
	console.log('client', list)
	let events = setEventData(list);

	calendarInit(events);
};

init()

/** 
getEventList((result) => {
	console.log(result)
	let events = setEventData(result)
	calendarInit(events)
});

*/












