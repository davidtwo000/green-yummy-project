
function search(data) {

    const lists = document.querySelectorAll('.list-show ul');
	const sublists = document.querySelectorAll('.list-show ul li');

    lists.forEach(list => list.style.display = 'none');
	

	sublists[0].classList.add("listSelect");
    

    if (data === 'area') {
		const sublists = document.querySelectorAll('.list-show ul li');
		
        document.getElementById('searchByArea').style.display = 'flex';
		sublists[0].classList.add("listSelect");
		sublists[1].classList.remove("listSelect");

    } else if (data === 'type') {
		const sublists = document.querySelectorAll('.list-show ul li');

        document.getElementById('searchByType').style.display = 'flex';
		sublists[0].classList.remove("listSelect");
		sublists[1].classList.add("listSelect");

    }

}



function check(data) {

    console.log(data);

}



