import {getDevice} from './gettingDevice';
import {deviceSelectionLinksByColour} from './deviceSelectionLinksByColour';

module.exports = {
    getDeviceByLink: function getDeviceByLink(colourId, device) {
        let leftColumnTwo = document.getElementById("left_column_two");
        colourId.addEventListener('click', () => {
            getDevice(leftColumnTwo, device);
            deviceSelectionLinksByColour(colourId.id);
            document.getElementById("top_nav_table_block").style.display = "none";
            document.getElementById("blackout_hamburger").style.display = "none";
            document.getElementById("hamburger_menu").style.color = "white";
        })
    }
}