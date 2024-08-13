
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



