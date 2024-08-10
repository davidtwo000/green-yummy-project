
/*
let menuList = document.querySelectorAll(".category li");
let areaMenu = document.querySelector(".areaSublist");
let typeMenu = document.querySelector(".typeSublist");
let starMenu = document.querySelector(".starSublist");
let subMenus = [areaMenu, typeMenu, starMenu];

// 클릭하면 나타났다가 사라진다.
for (let i = 0; i < 3; i++) {
    menuList[i].onclick = () => {
        if (subMenus[i].classList.contains("hide")) {
            subMenus[i].classList.remove("hide");
            subMenus[i].style.transition = "all 300ms ease-in-out";
        } else {
            subMenus[i].classList.add("hide");
        }

        subMenus.forEach((comp, idx) => {
            if (idx !== i) {
                comp.classList.add("hide");
            }
        });
    }
}


function findbyarea(data) {
	console.log(data);
}
*/

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