let data =
	[{ "id": 1, "first_name": "Itch", "last_name": "Trusler", "email": "itrusler0@nih.gov", "gender": "Male", "salary": 6310 },
	{ "id": 2, "first_name": "Neil", "last_name": "Peetermann", "email": "npeetermann1@guardian.co.uk", "gender": "Male", "salary": 8788 },
	{ "id": 3, "first_name": "Breanne", "last_name": "Fall", "email": "bfall2@go.com", "gender": "Female", "salary": 6860 },
	{ "id": 4, "first_name": "Flint", "last_name": "Dominighi", "email": "fdominighi3@t.co", "gender": "Male", "salary": 4867 },
	{ "id": 5, "first_name": "Zeb", "last_name": "Edgeller", "email": "zedgeller4@google.com", "gender": "Male", "salary": 6687 },
	{ "id": 6, "first_name": "Fawnia", "last_name": "Bulled", "email": "fbulled5@1und1.de", "gender": "Female", "salary": 7779 },
	{ "id": 7, "first_name": "Dorella", "last_name": "Mehmet", "email": "dmehmet6@parallels.com", "gender": "Female", "salary": 3043 },
	{ "id": 8, "first_name": "Aleen", "last_name": "Angrock", "email": "aangrock7@dmoz.org", "gender": "Female", "salary": 9026 },
	{ "id": 9, "first_name": "Dennie", "last_name": "Whitmell", "email": "dwhitmell8@apple.com", "gender": "Female", "salary": 9462 },
	{ "id": 10, "first_name": "Archambault", "last_name": "Wastie", "email": "awastie9@google.com.au", "gender": "Male", "salary": 8771 },
	{ "id": 11, "first_name": "Ora", "last_name": "Comini", "email": "ocominia@army.mil", "gender": "Genderfluid", "salary": 4690 },
	{ "id": 12, "first_name": "Dyanna", "last_name": "Baly", "email": "dbalyb@cnet.com", "gender": "Female", "salary": 4118 },
	{ "id": 13, "first_name": "Milli", "last_name": "Kaufman", "email": "mkaufmanc@sourceforge.net", "gender": "Female", "salary": 3983 },
	{ "id": 14, "first_name": "Vikky", "last_name": "McCreath", "email": "vmccreathd@tripod.com", "gender": "Polygender", "salary": 5855 },
	{ "id": 15, "first_name": "Joanie", "last_name": "Fenelow", "email": "jfenelowe@sakura.ne.jp", "gender": "Female", "salary": 3136 },
	{ "id": 16, "first_name": "Margareta", "last_name": "Feldhammer", "email": "mfeldhammerf@purevolume.com", "gender": "Female", "salary": 3096 },
	{ "id": 17, "first_name": "Clara", "last_name": "Lawey", "email": "claweyg@geocities.jp", "gender": "Female", "salary": 5006 },
	{ "id": 18, "first_name": "Barbette", "last_name": "Harraway", "email": "bharrawayh@wikispaces.com", "gender": "Female", "salary": 5882 },
	{ "id": 19, "first_name": "Northrup", "last_name": "Parnby", "email": "nparnbyi@icq.com", "gender": "Male", "salary": 3029 },
	{ "id": 20, "first_name": "Ambrosio", "last_name": "Norcop", "email": "anorcopj@barnesandnoble.com", "gender": "Male", "salary": 7653 }]




fetch('js/data.json').then((resolve) => {
	return resolve.json()
}).then((result) => {
	makeList(result)
})


const FIELDS = ['id', 'first_name', 'last_name', 'email', 'gender', 'salary', 'remove']
function makeList(data) {
	let tbodyEle = document.querySelector('.dataTable tbody')
	tbodyEle.innerHTML = ''

	data.forEach((item, idx) => {
		let trEle = document.createElement('tr')


		FIELDS.forEach((field) => {
			let tdEle = document.createElement('td')
			if (field != 'remove') {
				tdEle.innerText = item[field]
			} else {
				let btnEle = document.createElement('button')
				btnEle.innerText = field
				tdEle.appendChild(btnEle)

				btnEle.addEventListener('click', (e) => {
					data.splice(idx, 1)
					makeList(data)
				})
			}

			trEle.appendChild(tdEle)
		})

		trEle.addEventListener('mouseover', (e) => {
			e.currentTarget.style.backgroundColor = 'gray'
		})

		trEle.addEventListener('mouseout', (e) => {
			e.currentTarget.style.backgroundColor = 'transparent'
		})


		tbodyEle.appendChild(trEle)
	})
}

