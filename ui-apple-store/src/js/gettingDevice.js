const {openFirstColorInList} = require("./openingFirstColorInList");
module.exports = {
    getDevice:
        function getDevice(leftColumnTwo, device) {
            document.getElementById("search_without_result").style.display = "none";
            document.getElementById("left_column_one").style.display = "none";
            document.getElementById("central_column_one").style.display = "none";
            document.getElementById("left_column_two").style.display = "block";
            document.getElementById("central_column_two").style.display = "block";
            let imageNames = Object.values(device.imageNames);
            let images = Object.values(device.images);
            let colours = Object.values(device.colours);
            let specifications = new Map(Object.entries(device.specifications));
            leftColumnTwo.innerHTML = `
        <div id="device_${device.id}_div" class="device">
        <div id="device_name_${device.id}" class="device_name_two">
        </div>
        <div id="device_image_${device.id}" class="device_image">
        </div>
        <div id="color_selection_${device.id}" class="color_selection_two">
        </div>
        <div id="device_price_and_basket_${device.id}" class="device_price_and_basket_two">
        <p id="device_price_${device.id}_${device.id}" class="device_price_p_two">${device.price}<u>AZN</u></p>
        <div id="add_to_cart_two_${device.id}" class="add_to_cart_two">
        <input id="add_to_cart_button_two_${device.id}" class="add_to_cart_button_two" type="button" value="Add to cart">
        </div>
        </div>
        </div>
         `
            let divDeviceName = document.getElementById(`device_name_${device.id}`);
            for (let imageName of imageNames) {
                divDeviceName.innerHTML += `
         <p id="p_device_name_${device.id}_${imageName}" class="device_name_p device_name_p_two">${imageName}</p>
        `
            }
            let i = 0;
            let y = 0;
            let contentImages = document.getElementById(`device_image_${device.id}`);
            for (let image of images) {
                contentImages.innerHTML += `
        <img id="image_${device.id}_${++i}" class="i_content_image i_content_img" src="data:image/png;base64,${image}" 
        width="350" height="350" alt="image_${device.id}_${++y}">
        `
            }
            let divColours = document.getElementById(`color_selection_${device.id}`);
            for (let colour of colours) {
                divColours.innerHTML += `
        <div id = "color_${device.id}_${colour.colour}_div" class="div_select_button_two ${colour.colour}_button_div">
        <button id = "button_${device.id}_${colour.colour}" class="select_button_two ${colour.colour}_button"
        onclick="deviceSelectionByColour()"></button>
        </div>  
        `
                openFirstColorInList(device.id, colour.colour);
            }
            let n = 0;
            let centralColumnTwo = document.getElementById("central_column_two");
            centralColumnTwo.innerHTML = `
        <div id="device_specifications_${device.id}" class="device_specifications">
        <div id="table_name_${device.id}" class="table_name">
        <p id="table_name_p_${device.id}" class="table_name_p">Specifications</p>
        </div>
        <div id="specifications_${device.id}" class="specifications">
        <table id="specifications_table_${device.id}" class="specifications_table">
        <tbody id="specifications_tbody_${device.id}" class="specifications_tbody">
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">Dimensions</td>
        </tr>
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">Weight</td>
        </tr>
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">SIM card type</td>
        </tr>  
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">SIM quantity</td>
        </tr>
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">Mobile networks</td>
        </tr>
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">Operating system</td>
        </tr>
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">Processor (CPU)</td>
        </tr>
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">Built-in memory</td>
        </tr>
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">RAM size</td>
        </tr>
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">Screen type</td>
        </tr>
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">Diagonal</td>
        </tr>
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">Screen resolution</td>
        </tr>
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">Main camera</td>
        </tr>
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">Front camera</td>
        </tr>
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">Wi-Fi</td>
        </tr>
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">Bluetooth</td>
        </tr>
        <tr id="specifications_tr_${device.id}_${++n}" class="specifications_tr">
        <td class="specifications_name">Battery capacity</td>
        </tr>
        </tbody>
        </table>
        </div>
        </div>
        `
            n = 0;
            for (let specification of specifications.values()) {
                let specificationsTr = document.getElementById(`specifications_tr_${device.id}_${++n}`);
                specificationsTr.innerHTML += `
                <td class="specifications_description">${specification}</td>`
            }
        }
}