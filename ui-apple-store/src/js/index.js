import '../css/style.css';
import bignumberJs from 'bignumber.js';
import {srpClientFactory} from './srpClient';
import {returnToHomePage} from "./returnToHomePage";
import {logOut} from "./personalArea";

let addingLinksToDevices = require('./addingLinksToDevices');
let gettingDeviceByLink = require('./gettingDeviceByLink');
let addingDevices = require('./addingDevices');
let gettingDevice = require('./gettingDevice');
let deviceSearch = require('./deviceSearch');
let sortingByPriceReduction = require('./sortingByPriceReduction');
let sortingByPriceIncrease = require('./sortingByPriceIncrease');

require('./autoSlider');
require('./searchBar');
require('./loginAndRegistration');
require('./personalArea');
require('./hamburgerMenu');

async function getLinksToDevices() {
    return await fetch('http://k8s.localhost/devices').then(response => {
        response.json().then(devices => {
            let tbody = document.getElementById("top_nav_tbody");
            for (let device of devices) {
                addingLinksToDevices.appendLinksToDevices(tbody, device)
            }
        })
    }).catch(response => {
        if (!response.ok) {
            throw new Error("HTTP status " + response.status);
        }
    })
}

async function getAllDevices() {
    return await fetch('http://k8s.localhost/devices').then(response => {
        response.json().then(devices => {
            let centralColumn = document.getElementById("central_column_one");
            for (let device of devices) {
                addingDevices.appendAllDevices(centralColumn, device)
            }
        })
    }).catch(response => {
        if (!response.ok) {
            throw new Error("HTTP status " + response.status);
        }
    })
}

async function getDeviceByLink() {
    return await fetch('http://k8s.localhost/devices').then(response => {
        response.json().then(devices => {
            for (let device of devices) {
                let colours = Object.values(device[`colours`]);
                for (let colour of colours) {
                    let colourId = document.getElementById(`color_${device.id}_${colour[`colour`]}`);
                    gettingDeviceByLink.getDeviceByLink(colourId, device);
                }
            }
        })
    }).catch(response => {
        if (!response.ok) {
            throw new Error("HTTP status " + response.status);
        }
    })
}

async function getDevice() {
    return await fetch('http://k8s.localhost/devices').then(response => {
        response.json().then(devices => {
            let leftColumnTwo = document.getElementById("left_column_two");
            for (let device of devices) {
                document.getElementById(`device_${device.id}`).addEventListener('click', () => {
                    gettingDevice.getDevice(leftColumnTwo, device);
                })
            }
        })
    }).catch(response => {
        if (!response.ok) {
            throw new Error("HTTP status " + response.status);
        }
    })
}

async function findDevice() {
    return await fetch('http://k8s.localhost/devices').then(response => {
        response.json().then(devices => {
            document.getElementById('search_button').addEventListener('click', () => {
                deviceSearch.findDevice(devices);
            });
            document.getElementById('search_bar').addEventListener('keydown', (e) => {
                if (e.key === 'Enter') {
                    deviceSearch.findDevice(devices);
                }
            });
        })
    }).catch(response => {
        if (!response.ok) {
            throw new Error("HTTP status " + response.status);
        }
    })
}

async function sortByPrice() {
    return await fetch('http://k8s.localhost/devices').then(response => {
        response.json().then(devices => {
            document.getElementById('lowest_price_link').addEventListener('click', () => {
                sortingByPriceReduction.sortByPriceReduction(devices);
            });
            document.getElementById('highest_price_link').addEventListener('click', () => {
                sortingByPriceIncrease.sortByPriceIncrease(devices);
            });
            document.getElementById("top_logo_link").addEventListener('click', () => {
                returnToHomePage("block");
                sortingByPriceIncrease.sortByPriceIncrease(devices);
            })
        })
    }).catch(response => {
        if (!response.ok) {
            throw new Error("HTTP status " + response.status);
        }
    })
}


getLinksToDevices().then(result => result);
getAllDevices().then(result => result);
getDeviceByLink().then(result => result);
getDevice().then(result => result);
findDevice().then(result => result);
sortByPrice().then(result => result);

async function signUp(firstName, lastName, mobileNumber, email, password, passwordConfirmation) {
    if (firstName !== "" && lastName !== "" && mobileNumber !== "" && email !== "" && password !== ""
        && passwordConfirmation !== "" && password === passwordConfirmation) {
        let client = srpClientFactory(new bignumberJs(
                '115b8b692e0e045692cf280b436735c77a5a9e8a9e7ed56c965f87db5b2a2ece3',
                16,
            ).toString(10), '2',
            'EA366B4591F92BD1AA926CAE731BF510C10639B63BDAA79B3319BFF4F43E19E3')
        let s = client.prototype.generateRandomSalt();
        let v = client.prototype.generateVerifier(s, email, password);
        const rawResponse = await fetch('http://k8s.localhost/auth/sign-up', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                firstName: firstName,
                lastName: lastName,
                mobileNumber: mobileNumber,
                email: email,
                salt: s,
                verifier: v,
            })
        }).then(response => {
            if (!response.ok) {
                throw new Error("HTTP status " + response.status);
            }
        });
        document.getElementById("login_and_registration_block").style.display = "none";
        document.getElementById("blackout").style.display = "none";
        document.getElementById("registration_block").style.display = "none";
        document.getElementById("login_and_registration_link").style.color = "white";
    }
}

if (localStorage.length !== 0) {
    let email = localStorage.getItem('email');
    getUserByEmail(email).then(r => r);
}

async function signIn(email, password) {
    let client = srpClientFactory(new bignumberJs(
            '115b8b692e0e045692cf280b436735c77a5a9e8a9e7ed56c965f87db5b2a2ece3',
            16,
        ).toString(10), '2',
        'EA366B4591F92BD1AA926CAE731BF510C10639B63BDAA79B3319BFF4F43E19E3')

    let serverStep1Response = await step1(email)
    console.log(serverStep1Response)

    client.prototype.step1(email, password)
    let clientStep2Response = client.prototype.step2(serverStep1Response.salt, serverStep1Response.b)

    let step2Response = await step2(clientStep2Response.A.toString(16), clientStep2Response.M1, email);
    console.log(step2Response)
    client.prototype.step3(step2Response.m2)
    console.log(client.prototype)
    document.getElementById("login_and_registration_block").style.display = "none";
    document.getElementById("blackout").style.display = "none";
    document.getElementById("registration_block").style.display = "none";
    document.getElementById("login_and_registration_link").style.color = "white";
    if (step2Response.m2 !== null) {
        localStorage.setItem('email', email);
        getUserByEmail(email).then(result => result);
    }
}

function getUserByEmail(email) {
    return fetch(`http://k8s.localhost/auth/${email}`).then(response => {
        response.json().then(user => {
                document.getElementById('login_and_registration').style.display = "none";
                document.getElementById('personal_area').style.display = "flex";
                document.getElementById('user_data_first_name').value = user.firstName;
                document.getElementById('user_data_last_name').value = user.lastName;
                document.getElementById('user_data_mobile_number').value = user.mobileNumber;
                document.getElementById('user_data_email').value = user.email;
                logOut(email);
            }
        )
    }).catch(response => {
        if (!response.ok) {
            throw new Error("HTTP status " + response.status);
        }
    })
}

function getCookie(cname) {
    let name = cname + "=";
    let ca = document.cookie.split(';');
    for (let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) === ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

async function step1(email) {
    return await fetch('http://k8s.localhost/auth/srp/step1', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({email: email})
    }).then(response => response.json());
}

async function step2(a, m1, email) {
    return await fetch('http://k8s.localhost/auth/srp/step2', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({a: a, m1: m1, email: email})
    }).then(response => {
        console.log(document.cookie);
        return response.json();
    }).catch(response => {
        if (!response.ok) {
            throw new Error("HTTP status " + response.status);
        }
    });
}

document.querySelector('#log_in_button').addEventListener('click', () => {
    signIn(document.getElementById('login_email').value,
        document.getElementById('login_password').value);
    console.log(getCookie('Access-Token'));
})

document.querySelector('#sign_up_button').addEventListener('click', () => {
    signUp(
        document.getElementById('registration_first_name').value,
        document.getElementById('registration_last_name').value,
        document.getElementById('registration_mobile_number').value,
        document.getElementById('registration_email').value,
        document.getElementById('registration_password').value,
        document.getElementById('registration_confirm_password').value
    )
    console.log(document.cookie)
})