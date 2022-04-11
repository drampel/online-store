searchBlockShow();
searchBlockClose();

function searchBlockShow() {
    document.getElementById("device_search_link").addEventListener('click', () => {
        document.getElementById("device_search_block").style.display = "flex";
        document.getElementById("blackout_search").style.display = "block";
        document.getElementById("search_bar").value = "";
        document.getElementById("device_search_link").style.color = "#00ff00";
    })
}

function searchBlockClose() {
    document.getElementById("blackout_search").addEventListener('click', () => {
        document.getElementById("device_search_block").style.display = "none";
        document.getElementById("blackout_search").style.display = "none";
        document.getElementById("search_bar").value = "";
        document.getElementById("device_search_link").style.color = "white";
    })
}