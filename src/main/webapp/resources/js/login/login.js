$(document).ready(function() {    
    $('a.login-menu').bind('click', function() {
        var loginPanel = $('div.login');
        if (loginPanel) {
            loginPanel.removeClass("hidden");
        }
    });
});