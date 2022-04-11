export function deviceSelectionLinksByColour(colourId) {
    if (colourId === "color_1_Gold") {
        document.getElementById("image_1_2").style.display = "none";
        document.getElementById("image_1_1").style.display = "block";
        document.getElementById("p_device_name_1_iPhone 12 Pro Max 512 GB Pacific Blue").style.display = "none";
        document.getElementById("p_device_name_1_iPhone 12 Pro Max 512 GB Gold").style.display = "inline-block";
        document.getElementById("color_1_Gold_div").style.border = "2px solid #f6e0c9";
        document.getElementById("color_1_Gold_div").style.padding = "2px";
        document.getElementById("color_1_Pacific Blue_div").style.border = "";
        document.getElementById("color_1_Pacific Blue_div").style.padding = "";
    }
    if (colourId === "color_1_Pacific Blue") {
        document.getElementById("image_1_1").style.display = "none";
        document.getElementById("image_1_2").style.display = "block";
        document.getElementById("p_device_name_1_iPhone 12 Pro Max 512 GB Gold").style.display = "none";
        document.getElementById("p_device_name_1_iPhone 12 Pro Max 512 GB Pacific Blue").style.display = "inline-block";
        document.getElementById("color_1_Pacific Blue_div").style.border = "2px solid #00a6dc";
        document.getElementById("color_1_Pacific Blue_div").style.padding = "2px";
        document.getElementById("color_1_Gold_div").style.border = "";
        document.getElementById("color_1_Gold_div").style.padding = "";
    }

    if (colourId === "color_2_Graphite") {
        document.getElementById("image_2_3").style.display = "none";
        document.getElementById("image_2_2").style.display = "none";
        document.getElementById("image_2_1").style.display = "block";
        document.getElementById("p_device_name_2_iPhone 12 Pro 256 GB Gold").style.display = "none";
        document.getElementById("p_device_name_2_iPhone 12 Pro 256 GB Pacific Blue").style.display = "none";
        document.getElementById("p_device_name_2_iPhone 12 Pro 256 GB Graphite").style.display = "inline-block";
        document.getElementById("color_2_Graphite_div").style.border = "2px solid #686868";
        document.getElementById("color_2_Graphite_div").style.padding = "2px";
        document.getElementById("color_2_Gold_div").style.border = "";
        document.getElementById("color_2_Gold_div").style.padding = "";
        document.getElementById("color_2_Pacific Blue_div").style.border = "";
        document.getElementById("color_2_Pacific Blue_div").style.padding = "";
    }
    if (colourId === "color_2_Gold") {
        document.getElementById("image_2_1").style.display = "none";
        document.getElementById("image_2_3").style.display = "none";
        document.getElementById("image_2_2").style.display = "block";
        document.getElementById("p_device_name_2_iPhone 12 Pro 256 GB Graphite").style.display = "none";
        document.getElementById("p_device_name_2_iPhone 12 Pro 256 GB Pacific Blue").style.display = "none";
        document.getElementById("p_device_name_2_iPhone 12 Pro 256 GB Gold").style.display = "inline-block";
        document.getElementById("color_2_Gold_div").style.border = "2px solid #f6e0c9";
        document.getElementById("color_2_Gold_div").style.padding = "2px";
        document.getElementById("color_2_Graphite_div").style.border = "";
        document.getElementById("color_2_Graphite_div").style.padding = "";
        document.getElementById("color_2_Pacific Blue_div").style.border = "";
        document.getElementById("color_2_Pacific Blue_div").style.padding = "";
    }
    if (colourId === "color_2_Pacific Blue") {
        document.getElementById("image_2_1").style.display = "none";
        document.getElementById("image_2_2").style.display = "none";
        document.getElementById("image_2_3").style.display = "block";
        document.getElementById("p_device_name_2_iPhone 12 Pro 256 GB Gold").style.display = "none";
        document.getElementById("p_device_name_2_iPhone 12 Pro 256 GB Graphite").style.display = "none";
        document.getElementById("p_device_name_2_iPhone 12 Pro 256 GB Pacific Blue").style.display = "inline-block";
        document.getElementById("color_2_Pacific Blue_div").style.border = "2px solid #00a6dc";
        document.getElementById("color_2_Pacific Blue_div").style.padding = "2px";
        document.getElementById("color_2_Gold_div").style.border = "";
        document.getElementById("color_2_Gold_div").style.padding = "";
        document.getElementById("color_2_Graphite_div").style.border = "";
        document.getElementById("color_2_Graphite_div").style.padding = "";
    }

    if (colourId === "color_3_Green") {
        document.getElementById("image_3_2").style.display = "none";
        document.getElementById("image_3_1").style.display = "block";
        document.getElementById("p_device_name_3_iPhone 11 Pro Max 256 GB Grey").style.display = "none";
        document.getElementById("p_device_name_3_iPhone 11 Pro Max 256 GB Green").style.display = "inline-block";
        document.getElementById("color_3_Green_div").style.border = "2px solid #165f67";
        document.getElementById("color_3_Green_div").style.padding = "2px";
        document.getElementById("color_3_Grey_div").style.border = "";
        document.getElementById("color_3_Grey_div").style.padding = "";
    }
    if (colourId === "color_3_Grey") {
        document.getElementById("image_3_1").style.display = "none";
        document.getElementById("image_3_2").style.display = "block";
        document.getElementById("p_device_name_3_iPhone 11 Pro Max 256 GB Green").style.display = "none";
        document.getElementById("p_device_name_3_iPhone 11 Pro Max 256 GB Grey").style.display = "inline-block";
        document.getElementById("color_3_Grey_div").style.border = "2px solid #343d46";
        document.getElementById("color_3_Grey_div").style.padding = "2px";
        document.getElementById("color_3_Green_div").style.border = "";
        document.getElementById("color_3_Green_div").style.padding = "";
    }

    if (colourId === "color_4_Grey") {
        document.getElementById("image_4_3").style.display = "none";
        document.getElementById("image_4_2").style.display = "none";
        document.getElementById("image_4_1").style.display = "block";
        document.getElementById("p_device_name_4_iPhone 11 Pro 256 GB Gold").style.display = "none";
        document.getElementById("p_device_name_4_iPhone 11 Pro 256 GB Green").style.display = "none";
        document.getElementById("p_device_name_4_iPhone 11 Pro 256 GB Grey").style.display = "inline-block";
        document.getElementById("color_4_Grey_div").style.border = "2px solid #343d46";
        document.getElementById("color_4_Grey_div").style.padding = "2px";
        document.getElementById("color_4_Gold_div").style.border = "";
        document.getElementById("color_4_Gold_div").style.padding = "";
        document.getElementById("color_4_Green_div").style.border = "";
        document.getElementById("color_4_Green_div").style.padding = "";
    }
    if (colourId === "color_4_Gold") {
        document.getElementById("image_4_1").style.display = "none";
        document.getElementById("image_4_3").style.display = "none";
        document.getElementById("image_4_2").style.display = "block";
        document.getElementById("p_device_name_4_iPhone 11 Pro 256 GB Grey").style.display = "none";
        document.getElementById("p_device_name_4_iPhone 11 Pro 256 GB Green").style.display = "none";
        document.getElementById("p_device_name_4_iPhone 11 Pro 256 GB Gold").style.display = "inline-block";
        document.getElementById("color_4_Gold_div").style.border = "2px solid #f6e0c9";
        document.getElementById("color_4_Gold_div").style.padding = "2px";
        document.getElementById("color_4_Grey_div").style.border = "";
        document.getElementById("color_4_Grey_div").style.padding = "";
        document.getElementById("color_4_Green_div").style.border = "";
        document.getElementById("color_4_Green_div").style.padding = "";
    }
    if (colourId === "color_4_Green") {
        document.getElementById("image_4_1").style.display = "none";
        document.getElementById("image_4_2").style.display = "none";
        document.getElementById("image_4_3").style.display = "block";
        document.getElementById("p_device_name_4_iPhone 11 Pro 256 GB Gold").style.display = "none";
        document.getElementById("p_device_name_4_iPhone 11 Pro 256 GB Grey").style.display = "none";
        document.getElementById("p_device_name_4_iPhone 11 Pro 256 GB Green").style.display = "inline-block";
        document.getElementById("color_4_Green_div").style.border = "2px solid #165f67";
        document.getElementById("color_4_Green_div").style.padding = "2px";
        document.getElementById("color_4_Grey_div").style.border = "";
        document.getElementById("color_4_Grey_div").style.padding = "";
        document.getElementById("color_4_Gold_div").style.border = "";
        document.getElementById("color_4_Gold_div").style.padding = "";
    }

    if (colourId === "color_5_Space Gray") {
        document.getElementById("image_5_3").style.display = "none";
        document.getElementById("image_5_2").style.display = "none";
        document.getElementById("image_5_1").style.display = "block";
        document.getElementById("p_device_name_5_iPhone XS Max 256 GB Space Silver").style.display = "none";
        document.getElementById("p_device_name_5_iPhone XS Max 256 GB Space Gold").style.display = "none";
        document.getElementById("p_device_name_5_iPhone XS Max 256 GB Space Gray").style.display = "inline-block";
        document.getElementById("color_5_Space Gray_div").style.border = "2px solid #343d46";
        document.getElementById("color_5_Space Gray_div").style.padding = "2px";
        document.getElementById("color_5_Space Gold_div").style.border = "";
        document.getElementById("color_5_Space Gold_div").style.padding = "";
        document.getElementById("color_5_Space Silver_div").style.border = "";
        document.getElementById("color_5_Space Silver_div").style.padding = "";
    }
    if (colourId === "color_5_Space Gold") {
        document.getElementById("image_5_1").style.display = "none";
        document.getElementById("image_5_3").style.display = "none";
        document.getElementById("image_5_2").style.display = "block";
        document.getElementById("p_device_name_5_iPhone XS Max 256 GB Space Silver").style.display = "none";
        document.getElementById("p_device_name_5_iPhone XS Max 256 GB Space Gray").style.display = "none";
        document.getElementById("p_device_name_5_iPhone XS Max 256 GB Space Gold").style.display = "inline-block";
        document.getElementById("color_5_Space Gold_div").style.border = "2px solid #f6e0c9";
        document.getElementById("color_5_Space Gold_div").style.padding = "2px";
        document.getElementById("color_5_Space Gray_div").style.border = "";
        document.getElementById("color_5_Space Gray_div").style.padding = "";
        document.getElementById("color_5_Space Silver_div").style.border = "";
        document.getElementById("color_5_Space Silver_div").style.padding = "";
    }
    if (colourId === "color_5_Space Silver") {
        document.getElementById("image_5_1").style.display = "none";
        document.getElementById("image_5_2").style.display = "none";
        document.getElementById("image_5_3").style.display = "block";
        document.getElementById("p_device_name_5_iPhone XS Max 256 GB Space Gray").style.display = "none";
        document.getElementById("p_device_name_5_iPhone XS Max 256 GB Space Gold").style.display = "none";
        document.getElementById("p_device_name_5_iPhone XS Max 256 GB Space Silver").style.display = "inline-block";
        document.getElementById("color_5_Space Silver_div").style.border = "2px solid #e7e7e5";
        document.getElementById("color_5_Space Silver_div").style.padding = "2px";
        document.getElementById("color_5_Space Gold_div").style.border = "";
        document.getElementById("color_5_Space Gold_div").style.padding = "";
        document.getElementById("color_5_Space Gray_div").style.border = "";
        document.getElementById("color_5_Space Gray_div").style.padding = "";
    }

    if (colourId === "color_6_Blue") {
        document.getElementById("image_6_6").style.display = "none";
        document.getElementById("image_6_5").style.display = "none";
        document.getElementById("image_6_4").style.display = "none";
        document.getElementById("image_6_3").style.display = "none";
        document.getElementById("image_6_2").style.display = "none";
        document.getElementById("image_6_1").style.display = "block";
        document.getElementById("p_device_name_6_iPhone 12 128 GB White").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Red").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Purple").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Green").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Black").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Blue").style.display = "inline-block";
        document.getElementById("color_6_Blue_div").style.border = "2px solid #00a6dc";
        document.getElementById("color_6_Blue_div").style.padding = "2px";
        document.getElementById("color_6_Black_div").style.border = "";
        document.getElementById("color_6_Black_div").style.padding = "";
        document.getElementById("color_6_Green_div").style.border = "";
        document.getElementById("color_6_Green_div").style.padding = "";
        document.getElementById("color_6_Purple_div").style.border = "";
        document.getElementById("color_6_Purple_div").style.padding = "";
        document.getElementById("color_6_Red_div").style.border = "";
        document.getElementById("color_6_Red_div").style.padding = "";
        document.getElementById("color_6_White_div").style.border = "";
        document.getElementById("color_6_White_div").style.padding = "";
    }
    if (colourId === "color_6_Black") {
        document.getElementById("image_6_6").style.display = "none";
        document.getElementById("image_6_5").style.display = "none";
        document.getElementById("image_6_4").style.display = "none";
        document.getElementById("image_6_3").style.display = "none";
        document.getElementById("image_6_1").style.display = "none";
        document.getElementById("image_6_2").style.display = "block";
        document.getElementById("p_device_name_6_iPhone 12 128 GB White").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Red").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Purple").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Green").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Blue").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Black").style.display = "inline-block";
        document.getElementById("color_6_Black_div").style.border = "2px solid #404040";
        document.getElementById("color_6_Black_div").style.padding = "2px";
        document.getElementById("color_6_Blue_div").style.border = "";
        document.getElementById("color_6_Blue_div").style.padding = "";
        document.getElementById("color_6_Green_div").style.border = "";
        document.getElementById("color_6_Green_div").style.padding = "";
        document.getElementById("color_6_Purple_div").style.border = "";
        document.getElementById("color_6_Purple_div").style.padding = "";
        document.getElementById("color_6_Red_div").style.border = "";
        document.getElementById("color_6_Red_div").style.padding = "";
        document.getElementById("color_6_White_div").style.border = "";
        document.getElementById("color_6_White_div").style.padding = "";
    }
    if (colourId === "color_6_Green") {
        document.getElementById("image_6_6").style.display = "none";
        document.getElementById("image_6_5").style.display = "none";
        document.getElementById("image_6_4").style.display = "none";
        document.getElementById("image_6_2").style.display = "none";
        document.getElementById("image_6_1").style.display = "none";
        document.getElementById("image_6_3").style.display = "block";
        document.getElementById("p_device_name_6_iPhone 12 128 GB White").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Red").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Purple").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Blue").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Black").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Green").style.display = "inline-block";
        document.getElementById("color_6_Green_div").style.border = "2px solid #165f67";
        document.getElementById("color_6_Green_div").style.padding = "2px";
        document.getElementById("color_6_Black_div").style.border = "";
        document.getElementById("color_6_Black_div").style.padding = "";
        document.getElementById("color_6_Blue_div").style.border = "";
        document.getElementById("color_6_Blue_div").style.padding = "";
        document.getElementById("color_6_Purple_div").style.border = "";
        document.getElementById("color_6_Purple_div").style.padding = "";
        document.getElementById("color_6_Red_div").style.border = "";
        document.getElementById("color_6_Red_div").style.padding = "";
        document.getElementById("color_6_White_div").style.border = "";
        document.getElementById("color_6_White_div").style.padding = "";
    }
    if (colourId === "color_6_Purple") {
        document.getElementById("image_6_6").style.display = "none";
        document.getElementById("image_6_5").style.display = "none";
        document.getElementById("image_6_3").style.display = "none";
        document.getElementById("image_6_2").style.display = "none";
        document.getElementById("image_6_1").style.display = "none";
        document.getElementById("image_6_4").style.display = "block";
        document.getElementById("p_device_name_6_iPhone 12 128 GB White").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Red").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Blue").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Green").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Black").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Purple").style.display = "inline-block";
        document.getElementById("color_6_Purple_div").style.border = "2px solid #c8a2c8";
        document.getElementById("color_6_Purple_div").style.padding = "2px";
        document.getElementById("color_6_Green_div").style.border = "";
        document.getElementById("color_6_Green_div").style.padding = "";
        document.getElementById("color_6_Black_div").style.border = "";
        document.getElementById("color_6_Black_div").style.padding = "";
        document.getElementById("color_6_Blue_div").style.border = "";
        document.getElementById("color_6_Blue_div").style.padding = "";
        document.getElementById("color_6_Red_div").style.border = "";
        document.getElementById("color_6_Red_div").style.padding = "";
        document.getElementById("color_6_White_div").style.border = "";
        document.getElementById("color_6_White_div").style.padding = "";
    }
    if (colourId === "color_6_Red") {
        document.getElementById("image_6_6").style.display = "none";
        document.getElementById("image_6_4").style.display = "none";
        document.getElementById("image_6_3").style.display = "none";
        document.getElementById("image_6_2").style.display = "none";
        document.getElementById("image_6_1").style.display = "none";
        document.getElementById("image_6_5").style.display = "block";
        document.getElementById("p_device_name_6_iPhone 12 128 GB White").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Blue").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Purple").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Green").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Black").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Red").style.display = "inline-block";
        document.getElementById("color_6_Red_div").style.border = "2px solid #e5040e";
        document.getElementById("color_6_Red_div").style.padding = "2px";
        document.getElementById("color_6_Purple_div").style.border = "";
        document.getElementById("color_6_Purple_div").style.padding = "";
        document.getElementById("color_6_Green_div").style.border = "";
        document.getElementById("color_6_Green_div").style.padding = "";
        document.getElementById("color_6_Black_div").style.border = "";
        document.getElementById("color_6_Black_div").style.padding = "";
        document.getElementById("color_6_Blue_div").style.border = "";
        document.getElementById("color_6_Blue_div").style.padding = "";
        document.getElementById("color_6_White_div").style.border = "";
        document.getElementById("color_6_White_div").style.padding = "";
    }
    if (colourId === "color_6_White") {
        document.getElementById("image_6_5").style.display = "none";
        document.getElementById("image_6_4").style.display = "none";
        document.getElementById("image_6_3").style.display = "none";
        document.getElementById("image_6_2").style.display = "none";
        document.getElementById("image_6_1").style.display = "none";
        document.getElementById("image_6_6").style.display = "block";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Blue").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Red").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Purple").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Green").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB Black").style.display = "none";
        document.getElementById("p_device_name_6_iPhone 12 128 GB White").style.display = "inline-block";
        document.getElementById("color_6_White_div").style.border = "2px solid #e9e9e9";
        document.getElementById("color_6_White_div").style.padding = "2px";
        document.getElementById("color_6_Red_div").style.border = "";
        document.getElementById("color_6_Red_div").style.padding = "";
        document.getElementById("color_6_Purple_div").style.border = "";
        document.getElementById("color_6_Purple_div").style.padding = "";
        document.getElementById("color_6_Green_div").style.border = "";
        document.getElementById("color_6_Green_div").style.padding = "";
        document.getElementById("color_6_Black_div").style.border = "";
        document.getElementById("color_6_Black_div").style.padding = "";
        document.getElementById("color_6_Blue_div").style.border = "";
        document.getElementById("color_6_Blue_div").style.padding = "";
    }

    if (colourId === "color_7_White") {
        document.getElementById("image_7_4").style.display = "none";
        document.getElementById("image_7_3").style.display = "none";
        document.getElementById("image_7_2").style.display = "none";
        document.getElementById("image_7_1").style.display = "block";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB Black").style.display = "none";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB Blue").style.display = "none";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB Red").style.display = "none";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB White").style.display = "inline-block";
        document.getElementById("color_7_White_div").style.border = "2px solid #e9e9e9";
        document.getElementById("color_7_White_div").style.padding = "2px";
        document.getElementById("color_7_Black_div").style.border = "";
        document.getElementById("color_7_Black_div").style.padding = "";
        document.getElementById("color_7_Blue_div").style.border = "";
        document.getElementById("color_7_Blue_div").style.padding = "";
        document.getElementById("color_7_Red_div").style.border = "";
        document.getElementById("color_7_Red_div").style.padding = "";
    }
    if (colourId === "color_7_Black") {
        document.getElementById("image_7_4").style.display = "none";
        document.getElementById("image_7_3").style.display = "none";
        document.getElementById("image_7_1").style.display = "none";
        document.getElementById("image_7_2").style.display = "block";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB White").style.display = "none";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB Blue").style.display = "none";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB Red").style.display = "none";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB Black").style.display = "inline-block";
        document.getElementById("color_7_Black_div").style.border = "2px solid #404040";
        document.getElementById("color_7_Black_div").style.padding = "2px";
        document.getElementById("color_7_White_div").style.border = "";
        document.getElementById("color_7_White_div").style.padding = "";
        document.getElementById("color_7_Blue_div").style.border = "";
        document.getElementById("color_7_Blue_div").style.padding = "";
        document.getElementById("color_7_Red_div").style.border = "";
        document.getElementById("color_7_Red_div").style.padding = "";
    }
    if (colourId === "color_7_Blue") {
        document.getElementById("image_7_4").style.display = "none";
        document.getElementById("image_7_1").style.display = "none";
        document.getElementById("image_7_2").style.display = "none";
        document.getElementById("image_7_3").style.display = "block";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB Black").style.display = "none";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB White").style.display = "none";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB Red").style.display = "none";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB Blue").style.display = "inline-block";
        document.getElementById("color_7_Blue_div").style.border = "2px solid #00a6dc";
        document.getElementById("color_7_Blue_div").style.padding = "2px";
        document.getElementById("color_7_Black_div").style.border = "";
        document.getElementById("color_7_Black_div").style.padding = "";
        document.getElementById("color_7_White_div").style.border = "";
        document.getElementById("color_7_White_div").style.padding = "";
        document.getElementById("color_7_Red_div").style.border = "";
        document.getElementById("color_7_Red_div").style.padding = "";
    }
    if (colourId === "color_7_Red") {
        document.getElementById("image_7_1").style.display = "none";
        document.getElementById("image_7_3").style.display = "none";
        document.getElementById("image_7_2").style.display = "none";
        document.getElementById("image_7_4").style.display = "block";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB Black").style.display = "none";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB Blue").style.display = "none";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB White").style.display = "none";
        document.getElementById("p_device_name_7_iPhone 12 mini 128 GB Red").style.display = "inline-block";
        document.getElementById("color_7_Red_div").style.border = "2px solid #e5040e";
        document.getElementById("color_7_Red_div").style.padding = "2px";
        document.getElementById("color_7_Blue_div").style.border = "";
        document.getElementById("color_7_Blue_div").style.padding = "";
        document.getElementById("color_7_Black_div").style.border = "";
        document.getElementById("color_7_Black_div").style.padding = "";
        document.getElementById("color_7_White_div").style.border = "";
        document.getElementById("color_7_White_div").style.padding = "";
    }

    if (colourId === "color_8_Black") {
        document.getElementById("image_8_3").style.display = "none";
        document.getElementById("image_8_2").style.display = "none";
        document.getElementById("image_8_1").style.display = "block";
        document.getElementById("p_device_name_8_iPhone SE 128 GB White").style.display = "none";
        document.getElementById("p_device_name_8_iPhone SE 128 GB Red").style.display = "none";
        document.getElementById("p_device_name_8_iPhone SE 128 GB Black").style.display = "inline-block";
        document.getElementById("color_8_Black_div").style.border = "2px solid #404040";
        document.getElementById("color_8_Black_div").style.padding = "2px";
        document.getElementById("color_8_Red_div").style.border = "";
        document.getElementById("color_8_Red_div").style.padding = "";
        document.getElementById("color_8_White_div").style.border = "";
        document.getElementById("color_8_White_div").style.padding = "";
    }
    if (colourId === "color_8_Red") {
        document.getElementById("image_8_3").style.display = "none";
        document.getElementById("image_8_1").style.display = "none";
        document.getElementById("image_8_2").style.display = "block";
        document.getElementById("p_device_name_8_iPhone SE 128 GB White").style.display = "none";
        document.getElementById("p_device_name_8_iPhone SE 128 GB Black").style.display = "none";
        document.getElementById("p_device_name_8_iPhone SE 128 GB Red").style.display = "inline-block";
        document.getElementById("color_8_Red_div").style.border = "2px solid #e5040e";
        document.getElementById("color_8_Red_div").style.padding = "2px";
        document.getElementById("color_8_Black_div").style.border = "";
        document.getElementById("color_8_Black_div").style.padding = "";
        document.getElementById("color_8_White_div").style.border = "";
        document.getElementById("color_8_White_div").style.padding = "";
    }
    if (colourId === "color_8_White") {
        document.getElementById("image_8_1").style.display = "none";
        document.getElementById("image_8_2").style.display = "none";
        document.getElementById("image_8_3").style.display = "block";
        document.getElementById("p_device_name_8_iPhone SE 128 GB Black").style.display = "none";
        document.getElementById("p_device_name_8_iPhone SE 128 GB Red").style.display = "none";
        document.getElementById("p_device_name_8_iPhone SE 128 GB White").style.display = "inline-block";
        document.getElementById("color_8_White_div").style.border = "2px solid #e9e9e9";
        document.getElementById("color_8_White_div").style.padding = "2px";
        document.getElementById("color_8_Red_div").style.border = "";
        document.getElementById("color_8_Red_div").style.padding = "";
        document.getElementById("color_8_Black_div").style.border = "";
        document.getElementById("color_8_Black_div").style.padding = "";
    }
}