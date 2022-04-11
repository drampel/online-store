hamburgerMenuShow();
hamburgerMenuClose();

function hamburgerMenuShow() {
    document.getElementById("hamburger_menu").addEventListener('click', () => {
        document.getElementById("top_nav_table_block").style.display = "flex";
        document.getElementById("blackout_hamburger").style.display = "block";
        document.getElementById("hamburger_menu").style.color = "#00ff00";
    })
}

function hamburgerMenuClose() {
    document.getElementById("blackout_hamburger").addEventListener('click', () => {
        document.getElementById("top_nav_table_block").style.display = "none";
        document.getElementById("blackout_hamburger").style.display = "none";
        document.getElementById("hamburger_menu").style.color = "white";
    })
}