const getCountByWriter = (success) => {
	fetch(`countByWriter.do`)
		.then((resolve) => {
			return resolve.json()
		}).then(success)
		.catch((err) => {
			console.log(err)
		})
}