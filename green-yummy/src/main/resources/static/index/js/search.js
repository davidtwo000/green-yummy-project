//dataSearch로 이동

function searchBytext() {

	const option = document.getElementById('selectBox').value;

	const content = document.getElementById('findByOption').value;



	window.location.href = `/public/dataSearch?option=${encodeURIComponent(option)}&content=${encodeURIComponent(content)}`;



	const selectBox = document.getElementById('selectBox');

	const findByOption = document.getElementById('findByOption');



	selectBox.value = option;

	findByOption.value = content;

}



function check(data) {

	console.log(data);

	let option = '';

	let content = '';



	if (data.startsWith('area')) {

		option = 'area';

		content = data.replace('area', '');

	} else if (data.startsWith('type')) {

		option = 'type';

		content = data.replace('type', '');

	}



	window.location.href = `/public/dataSearch?option=${encodeURIComponent(option)}&content=${encodeURIComponent(content)}`;

}