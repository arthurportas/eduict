$(document).ready(function () {
    $('a.references').bind('click', function (e) {
        e.preventDefault();
        var referencesPanel = $('div.web-references');
        if (referencesPanel) {
            if (referencesPanel.hasClass("hidden")) {
                referencesPanel.removeClass("hidden");
            } else {
                referencesPanel.addClass("hidden");
            }
        }
    });
});