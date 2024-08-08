
let menuList = document.querySelectorAll(".category li");
let areaMenu = document.querySelector(".areaSublist");
let typeMenu = document.querySelector(".typeSublist");
let foodMenu = document.querySelector(".menuSublist");
let starMenu = document.querySelector(".starSublist");
let subMenus = [areaMenu, typeMenu, foodMenu, starMenu];

//클릭하면 나타났다가 사라진다. 
for(let i=0;i<4;i++){
	menuList[i].onclick = () => {
		if(subMenus[i].classList.contains("hide")){
			subMenus[i].classList.remove("hide");
			subMenus[i].style.transition = "all 300ms ease-in-out";
		}else if(!subMenus[i].classList.contains("hide")){
			subMenus[i].classList.add("hide");
		}
		
		subMenus.forEach((comp, idx) => {
			if(idx!==i){
				comp.classList.add("hide");
			}
		});
	}
}