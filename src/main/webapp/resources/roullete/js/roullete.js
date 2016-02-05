var roullete = $('#roulette');
function onRoll() {
    var number = 28;
    var width = 150;
    var fullWidth = number * width;
    var time = 4000;

    // minimum deviation
    var minDeviation = -30;
    //maximum deviation
    var maxDeviation = 110;
    // rand deviation in range -30 ... 110
    var randDeviation = Math.random() * (maxDeviation - minDeviation) + minDeviation;
    // total width = the value of the scroll
    fullWidth += randDeviation;
    roullete.stop();
    (function go() {
        roullete.animate({
            left: '-=' + fullWidth
        }, time, function () {
        })
    }())
}

