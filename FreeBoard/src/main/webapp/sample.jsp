<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sample</title>
<script src="js/jquery-3.7.1.js"></script>
<script >
	document.addEventListener('DOMContentLoaded', () => {
		$('<ul/>').append(
				$('<li>apple</li>'), 
				$('<li/>').html('banana'),
				$('<li/>').text('peach')
				).appendTo($('body'))
				
				/*
		$(function() {
			$("p").on("click", function() {
				$(".jq span").css("backgroundColor", "lightGray");
			});
		});
		*/
		
		let pElements2 = document.querySelectorAll('.jq')
		console.log(pElements2)
		pElements2.forEach((item) => {
			console.log(item)
		})
		
		
		let pElements = document.getElementsByClassName('jq')
		console.log(pElements)
		
		for(let p of pElements) {
			
			p.addEventListener('click', (e) => {
				e.currentTarget.getElementsByTagName('span')[0].style.backgroundColor = 'lightGray'
			})
		}
	})
	
			
			
</script>
</head>
<body>
	<p class="class1"><span>jquery1</span></p>
	<p class="class2"><span>jquery2</span></p>
	<p class="class3"><span>jquery3</span></p>
	
	<p class="jq">aaaa <span>jq</span> aaaaa</p>
	<p class="jq">bbbbb <span>jq</span> bbbbb</p>
</body>
</html>