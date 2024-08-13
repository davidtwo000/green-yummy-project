
function search(data) {

    const lists = document.querySelectorAll('.list-show ul');
	
	const searchList = document.querySelectorAll(".search-list li");

    lists.forEach(list => list.style.display = 'none');
	
	


    if (data === 'area') {
		
		searchList[0].classList.add("listSelect");
		searchList[1].classList.remove("listSelect");
        document.getElementById('searchByArea').style.display = 'flex';

    } else if (data === 'type') {
		
		searchList[0].classList.remove("listSelect");
		searchList[1].classList.add("listSelect");
        document.getElementById('searchByType').style.display = 'flex';

    }

}



function check(data) {

    console.log(data);

}



