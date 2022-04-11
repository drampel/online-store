const {returnToHomePage} = require("./returnToHomePage");
const {sortByPriceIncrease} = require("./sortingByPriceIncrease");

module.exports = {
    findDevice:
        function findDevice(devices) {
            let deviceSearch = document.getElementById('search_bar').value;
            returnToHomePage("none");
            let foundDevices = [];
            for (let device of devices) {
                if (device[`name`].match(new RegExp(deviceSearch, 'gi')) && deviceSearch !== "") {
                    foundDevices.push(device);
                }
            }
            if (foundDevices !== null) {
                for (let foundDevice of foundDevices) {
                    document.getElementById(`i_content_${foundDevice.id}`).style.display = "block";
                }
                sortByPriceIncrease(devices);
                document.getElementById("sorting_block").style.display = "flex";
            }
            if (foundDevices.length === 0) {
                returnToHomePage("none");
                document.getElementById("sorting_block").style.display = "none";
                document.getElementById("search_without_result").style.display = "flex";
            }
            if (deviceSearch === "") {
                returnToHomePage("block");
                sortByPriceIncrease(devices);
                document.getElementById("search_without_result").style.display = "none";
            }
            document.getElementById("device_search_block").style.display = "none";
            document.getElementById("blackout_search").style.display = "none";
            document.getElementById("device_search_link").style.color = "white";
        }
}