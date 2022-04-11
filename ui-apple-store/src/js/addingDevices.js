import {deviceSelectionByColour} from './deviceSelectionByColour';
import {openFirstColorInList} from './openingFirstColorInList';

module.exports = {
    appendAllDevices:
        function appendAllDevices(centralColumn, device) {
            let images = Object.values(device.images);
            let imageIds = Object.values(device.imageIds);
            let imageNames = Object.values(device.imageNames);
            let colours = Object.values(device.colours);
            centralColumn.innerHTML += `
    <div id="i_content_${device.id}" class="i_content">
    <a id="device_${device.id}" class="central_column_link" href="#">
    <div id="i_content_images_${device.id}" class="i_content_images">
    </div>
    <div id="device_name_${device.id}" class="device_name_one">
    </div> 
    </a>
    <div id="color_selection_${device.id}" class="color_selection_one">
    </div>
    <div id="device_price_and_basket_${device.id}" class="device_price_and_basket_one">
    <input id="device_price_${device.id}" class="device_price_p_one" type="text" name="device_price_${device.id}"
    value="${device.price}" readonly>
    <u id="currency_rate_${device.id}" class="currency_rate">AZN</u>
    <div id="add_to_cart_one_${device.id}" class="add_to_cart_one">
    <input id="add_to_cart_button_one_${device.id}" class="add_to_cart_button_one" type="button" value="Add to cart">
    </div>
    </div>
    </div>
    `
            let i = 0;
            let y = 0;
            let contentImages = document.getElementById(`i_content_images_${device.id}`);
            for (let image of images) {
                contentImages.innerHTML += `
    <img id="image_${device.id}_${++i}" class="i_content_image" src="data:image/jpeg;base64,${image}" 
    width="260" height="250" alt="image_${device.id}_${++y}">
    `
            }
            let divDeviceName = document.getElementById(`device_name_${device.id}`);
            for (let imageName of imageNames) {
                divDeviceName.innerHTML += `
     <p id = "p_device_name_${device.id}_${imageName}" class="device_name_p device_name_p_one">${imageName}</p> 
    `
            }
            let divColours = document.getElementById(`color_selection_${device.id}`);
            for (let colour of colours) {
                divColours.innerHTML += `
    <div id = "color_${device.id}_${colour.colour}_div" class="div_select_button_one ${colour.colour}_button_div">
    <button id = "button_${device.id}_${colour.colour}" class="select_button_one ${colour.colour}_button"
     onclick="deviceSelectionByColour()"></button>
    </div>
    `
                openFirstColorInList(device.id, colour.colour);
            }
        }
}