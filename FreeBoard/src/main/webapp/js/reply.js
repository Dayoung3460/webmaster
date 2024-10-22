
getList(`${bno}`,
	(result) => {
		showList(result)
	},
	(err) => {
		console.log(err)
	}
)

