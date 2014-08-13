$(document).ready(function () {
    $('a.user-menu').bind('click', function (e) {
        e.preventDefault();
        var personalPanel = $('div.user-personal');
        if (personalPanel) {
            if (personalPanel.hasClass("hidden")) {
                personalPanel.removeClass("hidden");
            } else {
                personalPanel.addClass("hidden");
            }
        }
    });
});