function reviewRate(){
	let rateStars = document.querySelectorAll('.rateSelect img');
	rateStars = Array.from(rateStars);
	let radioBtns = document.querySelectorAll('input[type="radio"]');
	radioBtns = [...radioBtns];
	
	for(let i=0;i<radioBtns.length;i++){
		radioBtns[i].onclick = () => {
			rateStars[i].style.display = "block";
			rateStars[i].style.textAlign = "center";
			
			rateStars.forEach((comp, idx) => {
				if(idx!==i){
					comp.style.display = "none";
				}
			});
		}
	}
}



function addReviewPhoto(){
	let photolabel = document.querySelector("label");
	let addPhoto = document.getElementById("addPhoto");
	let inputfile = document.getElementById("file");

	
	let myReviewPhoto = inputfile.files[0];
	let fr = new FileReader();
		
	//	let filename = addfile.value;
		
		fr.onload = function(event){
			let pictureUrl = event.target.result;
			let imgtag = document.createElement("img");
			addPhoto.classList.add("hidden");
			photolabel.appendChild(imgtag);
			imgtag.src = pictureUrl;
			imgtag.style.opacity = "1";
					
			console.log(pictureUrl);
		};
		
		fr.readAsDataURL(myReviewPhoto);
}

