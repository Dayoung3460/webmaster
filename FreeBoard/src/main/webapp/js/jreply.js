$.ajax('replyList.do?bno=' + bno + '&currentPage=1')
	.done(function(result) {
		console.log(result)
		result.forEach((item) => {
			$('<tr/>')
				.append(
					$('<td/>').addClass('col-sm-2').text(item.replyNo),
					$('<td/>').addClass('col-sm-2').text(item.reply),
					$('<td/>').addClass('col-sm-2').text(item.replyer),
					$('<td/>').addClass('col-sm-2').text(item.replyDate),
					$('<td/>').addClass('col-sm-2').append($('<button>remove</button>'))
				)
				.appendTo($('.dataTable tbody'))
		})
		/**
		$('.dataTable tbody button').on('click', function(e) {
			$(e.target).parent().parent().remove()
		})
		 */
	})
	.fail(function(err) {
		console.log(err)
	})

$('.dataTable tbody').on('click', 'button', function(e) {
	let replyNo = $(e.currentTarget).parent().parent().find('td:eq(0)').text()
	
	$.ajax({
		url: 'deleteReply.do',
		data: {replyNo: replyNo},
		method: 'get',
		dataType: 'json' // 문자열을 객체로 만들어줌
	})
	.done(function(result) {
		if(result) {
			$(e.target).parent().parent().remove()
		}
	})
})

