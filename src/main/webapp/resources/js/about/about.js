$(document).ready(function() {    
    $('a.about-project').bind('click', function(e) {
        e.preventDefault();
        var aboutPanel = $('div.about-project ');
        if (aboutPanel) {
            if (aboutPanel.hasClass("hidden")) {
                aboutPanel.removeClass("hidden");    
            } else {
                aboutPanel.addClass("hidden"); 
            }
        } 
    });
});