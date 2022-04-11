export function openFirstColorInList(deviceId, colour) {
    if (`button_${deviceId}_${colour}` === "button_1_Gold") {
        document.getElementById("color_1_Gold_div").style.border = "2px solid #f6e0c9";
        document.getElementById("color_1_Gold_div").style.padding = "2px";
    } else if (`button_${deviceId}_${colour}` === "button_2_Graphite") {
        document.getElementById("color_2_Graphite_div").style.border = "2px solid #686868";
        document.getElementById("color_2_Graphite_div").style.padding = "2px";
    } else if (`button_${deviceId}_${colour}` === "button_3_Green") {
        document.getElementById("color_3_Green_div").style.border = "2px solid #165f67";
        document.getElementById("color_3_Green_div").style.padding = "2px";
    } else if (`button_${deviceId}_${colour}` === "button_4_Grey") {
        document.getElementById("color_4_Grey_div").style.border = "2px solid #343d46";
        document.getElementById("color_4_Grey_div").style.padding = "2px";
    } else if (`button_${deviceId}_${colour}` === "button_5_Space Gray") {
        document.getElementById("color_5_Space Gray_div").style.border = "2px solid #343d46";
        document.getElementById("color_5_Space Gray_div").style.padding = "2px";
    } else if (`button_${deviceId}_${colour}` === "button_6_Blue") {
        document.getElementById("color_6_Blue_div").style.border = "2px solid #00a6dc";
        document.getElementById("color_6_Blue_div").style.padding = "2px";
    } else if (`button_${deviceId}_${colour}` === "button_7_White") {
        document.getElementById("color_7_White_div").style.border = "2px solid #e9e9e9";
        document.getElementById("color_7_White_div").style.padding = "2px";
    } else if (`button_${deviceId}_${colour}` === "button_8_Black") {
        document.getElementById("color_8_Black_div").style.border = "2px solid #404040";
        document.getElementById("color_8_Black_div").style.padding = "2px";
    }
}