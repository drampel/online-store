export function returnToHomePage(display) {
    document.getElementById("search_without_result").style.display = "none";
    document.getElementById("left_column_two").innerHTML = "";
    document.getElementById("left_column_two").style.display = "none";
    document.getElementById("central_column_two").style.display = "none";
    document.getElementById("left_column_one").style.display = "block";
    document.getElementById("central_column_one").style.display = "flex";
    document.getElementById("sorting_block").style.display = "flex";
    let iContent = document.querySelectorAll('.i_content');
    for (let i = 0; i < iContent.length; i++) {
        iContent[i].style.display = display;
    }
}