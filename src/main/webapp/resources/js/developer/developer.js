$(document).ready(function() {    
    $('a.developer-credits').bind('click', function(e) {
        e.preventDefault();
        var developerPanel = $('div.developer');
        if (developerPanel) {
            if (developerPanel.hasClass("hidden")) {
                developerPanel.removeClass("hidden");    
            } else {
                developerPanel.addClass("hidden"); 
            }
        } 
    });
});