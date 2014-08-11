$(document).ready(function(e) {    
    $('a.login-menu').bind('click', function() {
        e.preventDefault();
        var loginPanel = $('div.login');
        if (loginPanel && loginPanel.hasClass("hidden")) {
            loginPanel.removeClass("hidden");
        }
    });
});