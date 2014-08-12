$(document).ready(function () {
    $('a.recover-password').bind('click', function (e) {
        e.preventDefault();
        var recoverPasswordPanel = $('div.recover-password');
        if (recoverPasswordPanel) {
            if (recoverPasswordPanel.hasClass("hidden")) {
                recoverPasswordPanel.removeClass("hidden");
            } else {
                recoverPasswordPanel.addClass("hidden");
            }
        }
    });
});