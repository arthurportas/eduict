$(document).ready(function() {    
    $('a.login-menu').bind('click', function(e) {
        e.preventDefault();
        var loginPanel = $('div.login');
        if (loginPanel) {
            if (loginPanel.hasClass("hidden")) {
                loginPanel.removeClass("hidden");    
            } else {
                loginPanel.addClass("hidden"); 
            }
        } 
    });
});