const drawChart = (resultData) => {
	let arrayToData = [['Writer', 'Count By Writer']];
	resultData.forEach((item) => {
		let arr = [item.writer, item.count]
		arrayToData.push(arr)
	})

	let data = google.visualization.arrayToDataTable(arrayToData);

	let options = {
		title: 'Count By Writer',
		is3D: false,
		pieHole: 0.4, // 0 < x < 1
		pieSliceText: 'label', // 파이 라벨명이 슬라이스에 표시. 없으면 퍼센티지 표시, 'none': 아무표시안함
		pieSliceTextStyle: {
			color: '#ffffff',
		},
		//tooltip: { trigger: 'none' },
		//legend: 'none',
		//pieStartAngle: 150,
		//sliceVisibilityThreshold: .2, // 20퍼 이하의 슬라이스들은 합해져서 '기타'로 표시
		//slices: {
		//	0: {
				//offset : 0.2
		//		color: 'black', // 'transparent'
		//	},

		//},
	};

	let chart = new google.visualization.PieChart(document
		.getElementById('piechart'));

	chart.draw(data, options);
}

const loadChart = () => {
	google.charts.load('current', {
		'packages': ['corechart']
	});

}


getCountByWriter((result) => {
	loadChart()
	google.charts.setOnLoadCallback(() => drawChart(result))
});