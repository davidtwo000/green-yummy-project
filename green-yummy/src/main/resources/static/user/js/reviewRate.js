function reviewRate(){
	let rateStars = document.querySelectorAll('.rateSelect img');
	rateStars = Array.from(rateStars);
	let radioBtns = document.querySelectorAll('input[type="radio"]');
	radioBtns = [...radioBtns];
	
	for(let i=0;i<5;i++){
		for(let j=4-i;j>=-i;j--){
			
			i+j==0 && radioBtns[i+j].checked ? rateStars[i+j].style.display = "block" : rateStars[i+j].style.display = "none";
			
			
		}
	}
}
