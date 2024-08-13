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
