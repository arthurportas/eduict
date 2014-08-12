$(document).ready(function () {
    $('a.contacts').bind('click', function (e) {
        e.preventDefault();
        var contactPanel = $('div.contact');
        if (contactPanel) {
            if (contactPanel.hasClass("hidden")) {
                contactPanel.removeClass("hidden");
            } else {
                contactPanel.addClass("hidden");
            }
        }
    });
});