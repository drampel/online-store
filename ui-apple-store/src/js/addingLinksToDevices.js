import {clickableDropdown} from './clickableDropdown';

module.exports = {
    appendLinksToDevices: function appendLinksToDevices(tbody, device) {
        tbody.innerHTML += `
    <tr class="top_nav_table_tr">
    <th><a id="top_link_${device.id}" class="top_link" onclick="clickableDropdown('top_link_${device.id}','dropdown_${device.id}')">
    ${device[`name`]}</a></th>
    <td id="dropdown_${device.id}" class="dropdown_content">
    </td>
    </tr>
    `
        let specifications = new Map(Object.entries(device.specifications));
        let builtInMemory = specifications.get('BUILT_IN_MEMORY');
        let links = document.getElementById(`dropdown_${device.id}`);
        let colours = Object.values(device.colours);
        for (let colour of colours) {
            links.innerHTML += `
    <a id="color_${device.id}_${colour.colour}" class="dropdown_content_links" href="#">${builtInMemory} ${colour.colour}</a>
    `
        }
    }
}