function reviewRate(){
	let rateStars = document.querySelectorAll('.rateSelect img');
	rateStars = Array.from(rateStars);
	let radioBtns = document.querySelectorAll('input[type="radio"]');
	radioBtns = [...radioBtns];
	
	for(let i=0;i<radioBtns.length;i++){
		radioBtns[i].onclick = () => {
			
		}
	}
}
