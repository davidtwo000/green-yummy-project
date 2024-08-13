


window.onload = () => {
	const highrate = document.querySelector(".highr");
	const lowrate = document.querySelector(".lowr");
	
	highrate.onclick = () => {
		if(!highrate.classList.contains("selectRate")){
			highrate.classList.add("selectRate");
			lowrate.classList.remove("selectRate");
		}
		
	}
	lowrate.onclick = () => {
		if(!lowrate.classList.contains("selectRate")){
			highrate.classList.remove("selectRate");
			lowrate.classList.add("selectRate");
		}
		
	}
}


function search(data) {

    const lists = document.querySelectorAll('.searchByArea, .searchByType, .searchByRating');

    lists.forEach(list => list.style.display = 'none');

    

    if (data === 'area') {

        document.getElementById('searchByArea').style.display = 'flex';

    } else if (data === 'type') {

        document.getElementById('searchByType').style.display = 'flex';

    } else if (data === 'rating') {

        document.getElementById('searchByRating').style.display = 'flex';

    }

}



function check(data) {

    console.log(data);

}



