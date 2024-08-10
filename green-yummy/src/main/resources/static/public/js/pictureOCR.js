
let storeSignImgInput = document.querySelector("#storeSign");
let storeImgPlace = document.querySelector(".OCRsearch");
let useComment = document.querySelector(".OCRsearch > span");

let ocrQuestion = document.querySelector(".OCRhelp img");
let ocrHelp = document.querySelector(".OCRexplain");

let imgTag =document.createElement("img");


//추가한 사진이 따로 만들어둔 div 안에 뜨게 하는 함수
storeSignImgInput.onchange = (event) => {
    let storeImg = event.target.files[0];//input type file로 불러낸 파일
    

    if(storeImg){
        let fileread = new FileReader();

        fileread.onload = (e) => {
            imgTag.src = e.target.result;//여기서 타겟은 fileread
            imgTag.style.width = 1000 + "px";
            imgTag.style.height = 600 + "px"; 
            storeImgPlace.appendChild(imgTag);
            storeImgPlace.style.display = "block";
            useComment.style.display = "none";
        }

        fileread.readAsDataURL(storeImg);
    }else{
        storeImgPlace.style.display = "none";
        useComment.style.display = "block";
    }
}

ocrQuestion.onclick = () => {
	if(ocrHelp.classList.contains("invisible")){
		ocrHelp.classList.remove("invisible")
		ocrHelp.style.transition = "opacity 300ms ease-in-out";
	}else if(!ocrHelp.classList.contains("invisible")){
		ocrHelp.classList.add("invisible");
		ocrHelp.style.transition = "opacity 300ms ease-in-out";
	}
}

