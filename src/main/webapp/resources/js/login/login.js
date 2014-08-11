$(document).ready(function() {    
    $('a.login-menu').bind('click', function(e) {
        e.preventDefault();
        var loginPanel = $('div.login');
        if (loginPanel) {
            loginPanel.toggle("slow");
        }
    });
});