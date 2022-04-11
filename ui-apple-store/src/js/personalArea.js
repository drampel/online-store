personalAreaBlockShow();
personalAreaBlockClose("blackout_personal_area");
personalAreaBlockClose("personal_area_close");

function personalAreaBlockShow() {
    document.getElementById("personal_area_link").addEventListener('click', () => {
        document.getElementById("personal_area_block_one").style.display = "flex";
        document.getElementById("blackout_personal_area").style.display = "block";
        document.getElementById("personal_area_link").style.color = "#00ff00";

    })
}

function personalAreaBlockClose(choiceId) {
    document.getElementById(choiceId).addEventListener('click', () => {
        document.getElementById("personal_area_block_one").style.display = "none";
        document.getElementById("blackout_personal_area").style.display = "none";
        document.getElementById("personal_area_link").style.color = "white";
    })
}

export function logOut(email) {
        document.getElementById("log_out_button").addEventListener('click', () => {
            localStorage.removeItem('email');
            document.getElementById('personal_area').style.display = "none";
            document.getElementById("personal_area_block_one").style.display = "none";
            document.getElementById("blackout_personal_area").style.display = "none";
            document.getElementById("personal_area_link").style.color = "white";
            document.getElementById('login_and_registration').style.display = "flex";
            document.getElementById('user_data_first_name').value = "";
            document.getElementById('user_data_last_name').value = "";
            document.getElementById('user_data_mobile_number').value = "";
            document.getElementById('user_data_email').value = "";
        })
}