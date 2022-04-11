export let clickableDropdown;

window.clickableDropdown = function (top_link, dropdown) {
    document.getElementById(top_link).style.color = "#00ff00";
    document.getElementById(dropdown).classList.toggle("show");

    window.onclick = function (e) {
        if (!e.target.matches('#top_link_1')) {
            let dropdown = document.getElementById('dropdown_1');
            if (dropdown.classList.contains('show')) {
                document.getElementById("top_link_1").style.color = "#a3c3a3";
                dropdown.classList.remove('show');
            }
        }
        if (!e.target.matches('#top_link_2')) {
            let dropdown = document.getElementById('dropdown_2');
            if (dropdown.classList.contains('show')) {
                document.getElementById("top_link_2").style.color = "#a3c3a3";
                dropdown.classList.remove('show')
            }
        }
        if (!e.target.matches('#top_link_3')) {
            let dropdown = document.getElementById("dropdown_3");
            if (dropdown.classList.contains('show')) {
                document.getElementById("top_link_3").style.color = "#a3c3a3";
                dropdown.classList.remove('show');
            }
        }
        if (!e.target.matches('#top_link_4')) {
            let dropdown = document.getElementById("dropdown_4");
            if (dropdown.classList.contains('show')) {
                document.getElementById("top_link_4").style.color = "#a3c3a3";
                dropdown.classList.remove('show');
            }
        }
        if (!e.target.matches('#top_link_5')) {
            let dropdown = document.getElementById("dropdown_5");
            if (dropdown.classList.contains('show')) {
                document.getElementById("top_link_5").style.color = "#a3c3a3";
                dropdown.classList.remove('show');
            }
        }
        if (!e.target.matches('#top_link_6')) {
            let dropdown = document.getElementById("dropdown_6");
            if (dropdown.classList.contains('show')) {
                document.getElementById("top_link_6").style.color = "#a3c3a3";
                dropdown.classList.remove('show');
            }
        }
        if (!e.target.matches('#top_link_7')) {
            let dropdown = document.getElementById("dropdown_7");
            if (dropdown.classList.contains('show')) {
                document.getElementById("top_link_7").style.color = "#a3c3a3";
                dropdown.classList.remove('show');
            }
        }
        if (!e.target.matches('#top_link_8')) {
            let dropdown = document.getElementById("dropdown_8");
            if (dropdown.classList.contains('show')) {
                document.getElementById("top_link_8").style.color = "#a3c3a3";
                dropdown.classList.remove('show');
            }
        }
    }
}