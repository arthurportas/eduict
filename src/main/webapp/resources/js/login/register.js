$(document).ready(function () {
    $('a.register-menu').bind('click', function (e) {
        e.preventDefault();
        var registerPanel = $('div.register');
        if (registerPanel) {
            if (registerPanel.hasClass("hidden")) {
                registerPanel.removeClass("hidden");
            } else {
                registerPanel.addClass("hidden");
            }
        }
    });

    $('select.work-region').change(function () {
        //get selected option-region Id
        //ajax call to get this specific region
        //replace school selct html with schools according to selected region
    })
});