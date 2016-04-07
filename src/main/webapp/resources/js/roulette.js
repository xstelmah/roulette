function onRoll() {
    var roulette = $('#roulette');
    var rouletteRemove = $('#roulette-remove');
    var buttonPlay = $('#buttonPlay');
    buttonPlay.prop('disabled', true);
    go();

    function go() {
        //rouletteRemove.removeAttribute('display');
        var number = 26;
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
        roulette.animate({
            left: '-=' + fullWidth
        }, time, function () {
            //hide(2500);
            buttonPlay.prop('disabled', false);
        })
    }

    function hide(ms) {
        rouletteRemove.hide(ms, function () {
            rouletteRemove.remove();
        });
    }


}



