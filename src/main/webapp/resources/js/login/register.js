$(document).ready(function() {    
    $('a.register-menu').bind('click', function(e) {
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
});