registrationBlockShow();
loginBlockShow();
loginAndRegistrationBlockClose("blackout");
loginAndRegistrationBlockClose("login_close");
loginAndRegistrationBlockClose("registration_close");

function loginBlockShow() {
    document.getElementById("login_and_registration_link").addEventListener('click', () => {
        document.getElementById("login_and_registration_block").style.display = "flex";
        document.getElementById("blackout").style.display = "block";
        document.getElementById("login_block").style.display = "block";
        document.getElementById("login_and_registration_link").style.color = "#00ff00";
        clearFields();
    })
}

function registrationBlockShow() {
    document.getElementById("create_new_account_button").addEventListener('click', () => {
        document.getElementById("registration_block").style.display = "block";
        document.getElementById("login_block").style.display = "none";
        // clearFields();
    })
}

function loginAndRegistrationBlockClose(choiceId) {
    document.getElementById(choiceId).addEventListener('click', () => {
        document.getElementById("login_and_registration_block").style.display = "none";
        document.getElementById("blackout").style.display = "none";
        document.getElementById("registration_block").style.display = "none";
        document.getElementById("login_and_registration_link").style.color = "white";
        clearFields();
    })
}

function clearFields() {
    document.getElementById('login_email').value = "";
    document.getElementById('login_password').value = "";
    document.getElementById('registration_first_name').value = "";
    document.getElementById('registration_last_name').value = "";
    document.getElementById('registration_mobile_number').value = "";
    document.getElementById('registration_email').value = "";
    document.getElementById('registration_password').value = "";
    document.getElementById('registration_confirm_password').value = "";
}