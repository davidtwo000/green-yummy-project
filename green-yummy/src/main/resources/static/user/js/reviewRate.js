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


let emptybox = document.getElementById("addPhoto");
let addfile = document.getElementById("file");

function addReviewPhoto(){
	
	let myShopPhoto = addfile.files[0];
	let reader = new FileReader();
		
	//	let filename = addfile.value;
		
		reader.onload = function(event){
			let imgurl = event.target.result;
			let thumbnail = document.createElement("img");
			emptybox.classList.add("hidden");
			label.appendChild(thumbnail);
			thumbnail.src = imgurl;
			thumbnail.style.opacity = "1";
					
			console.log(imgurl);
		};
		
		reader.readAsDataURL(myShopPhoto);
}

addfile.addEventListener("change", addReviewPhoto);