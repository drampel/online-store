let myIndex = 0;
autoSlider();

  function autoSlider () {
    let i;
    let x = document.getElementsByClassName("auto_slider_phones");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    myIndex++;
    if (myIndex > x.length) myIndex = 1;
    x[myIndex - 1].style.display = "block";
    setTimeout(autoSlider, 2000);
}