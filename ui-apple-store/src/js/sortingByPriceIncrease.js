const gettingDevice = require("./gettingDevice");
module.exports = {
    sortByPriceIncrease:
        function sortByPriceIncrease(devices) {
            let allDivIContent = [];
            let clone;
            let iContent = document.querySelectorAll('.i_content');
            for (let i = 0; i < iContent.length; i++) {
                clone = iContent[i].cloneNode(true);
                allDivIContent.push(clone);
                iContent[i].remove();
            }
            let centralColumn = document.getElementById("central_column_one");
            let leftColumnTwo = document.getElementById("left_column_two");
            devices = devices.sort((a, b) => b[`price`] - a[`price`]);
            for (let device of devices) {
                for (let divIContent of allDivIContent) {
                    if (divIContent.id === `i_content_${device.id}`) {
                        centralColumn.append(divIContent);
                        document.getElementById(`device_${device.id}`).addEventListener('click', () => {
                            gettingDevice.getDevice(leftColumnTwo, device);
                        })
                    }
                }
            }
        }
}