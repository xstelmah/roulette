function guestMenuChanged(id) {
    var input = $('#guestHiddenMenuInput');
    //if (input.val() != id) {
        input.val(id);
        input.change();
    //}
}
function userMenuChanged(id) {
    var input = $('#userHiddenMenuInput');
    //if (input.val() != id) {
        input.val(id);
        input.change();
    //}
}