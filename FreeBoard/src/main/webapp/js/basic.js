//console.log = function() {}

let name = "hong";
console.log(name);

let object = {
	name: name,
	age: 20,
	showInfo: () => {
		return object.name + ": " + object.age
	}
}

console.log(object.showInfo());


let liEle = document.createElement('li')
liEle.innerText = 'ccc'

console.log(liEle)

let ulEle = document.getElementById('show')

console.log(ulEle)
ulEle.appendChild(liEle)


let liArr = document.querySelectorAll('#show li');
liArr.forEach((li) => {

	li.addEventListener('click', (e) => {
		if (li.style.color === 'red') {
			li.remove();
		} else {
			li.style.color = 'red'
		}
	})
	console.log(li.innerHTML)
})



let thEle = document.getElementsByClassName('th')[0]
let tdEle = document.getElementsByClassName('td')[0]

let btnEle = document.getElementById('button')
tdEle.addEventListener('keydown', (e) => {
	if (e.keyCode == 13) {
		addRow(thEle.value, tdEle.value)
	}
})

btnEle.addEventListener('click', (e) => {
	addRow(thEle.value, tdEle.value)
})


let addRow = (thValue, tdValue) => {
	if (!thValue || !tdValue) {
		return
	}
	let tableEle = document.querySelector('#table')
	let trEle = document.createElement('tr')
	let thEle = document.createElement('th')
	let tdEle = document.createElement('td')
	thEle.innerText = thValue
	tdEle.innerText = tdValue

	tableEle.appendChild(trEle)
	trEle.appendChild(thEle)
	trEle.appendChild(tdEle)

	document.getElementsByClassName('th')[0].value = ''
	document.getElementsByClassName('td')[0].value = ''
}


let data = [object]
data.push({ name: "kim", age: 30 })
data.push({ name: "lee", age: 40 })


let tbodyEle = document.querySelector('#table2 tbody')


data.forEach((item) => {
	let trEle = document.createElement('tr')
	let thEle = document.createElement('th')
	let tdEle = document.createElement('td')

	thEle.innerText = item.name
	tdEle.innerText = item.age
	tbodyEle.appendChild(trEle)
	trEle.appendChild(thEle)
	trEle.appendChild(tdEle)
})

let btn2 = document.getElementById('button2')
btn2.addEventListener('click', (e) => {
	let trEle = document.createElement('tr')
	let thEle = document.createElement('th')
	let tdEle = document.createElement('td')
	let inputEle1 = document.createElement('input')
	let inputEle2 = document.createElement('input')
	
	//thEle.style.height = '30px'
	//tdEle.style.height = '30px'
	//thEle.style.border = '1px solid black'
	//tdEle.style.border = '1px solid black'
	
	
	tbodyEle.appendChild(trEle)
	trEle.appendChild(thEle)
	trEle.appendChild(tdEle)
	thEle.appendChild(inputEle1)
	tdEle.appendChild(inputEle2)
	
	inputEle1.focus()
	
	data.push({name:inputEle1.value, age: inputEle2.value })
})















