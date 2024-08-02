let findTab = document.querySelectorAll(".findIdPassCon > ul > li");
let findId = document.querySelector(".findId");
let findPswd = document.querySelector(".findPswd");

findTab[1].onclick = () => {
	if(!findTab[1].classList.contains("findThis")){
		findTab[0].classList.remove("findThis");
		findTab[1].classList.add("findThis");
		findId.classList.add("hidden");
		findPswd.classList.remove("hidden");
	}else{
		findTab[1].classList.contains("findThis");
	}
}
findTab[0].onclick = () => {
	if(!findTab[0].classList.contains("findThis")){
		findTab[1].classList.remove("findThis");
		findTab[0].classList.add("findThis");
		findId.classList.remove("hidden");
		findPswd.classList.add("hidden");
	}else{
		findTab[0].classList.contains("findThis");
	}
}