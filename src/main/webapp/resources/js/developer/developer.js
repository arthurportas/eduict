$(document).ready(function () {
    $('a.developer-credits').bind('click', function (e) {
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
$(document).ready(function () {
    $('button.developer-message').bind('click', function (e) {
        e.preventDefault();
        // Assign handlers immediately after making the request,
        // and remember the jqxhr object for this request
        var developerMessageAlertElement = $('div.developer-message-alert');
        var email = $('.developer-email').val();
        var subject = $('.developer-subject').val();
        var message = $('.developer-message').val();
        $.ajax({
            type: "POST",
            url: "/contact-developer",
            contentType: 'text/html',
            beforeSend: function() {
            },
            success: function(jqXHR, textStatus, errorThrown) {
                if (developerMessageAlertElement) {
                    developerMessageAlertElement.html(jqXHR);    
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                if (jqXHR.status === 0) {
                    alert('Not connect.\n Verify Network.');
                    return;
                } else if (jqXHR.status == 404) {
                    alert('Requested page not found. [404]');
                    return;
                } else if (jqXHR.status == 500) {
                    alert('Internal Server Error [500].');
                    return;
                } else if (errorThrown === 'parsererror') {
                    alert('Requested JSON parse failed.');
                    return;
                } else if (errorThrown === 'timeout') {
                    alert('Time out error.');
                    return;
                } else if (errorThrown === 'abort') {
                    alert('Ajax request aborted.');
                    return;
                } else {
                    if (developerMessageAlertElement) {
                        developerMessageAlertElement.html(jqXHR);    
                    }
                }   
            },
            complete: function(jqXHR, textStatus, errorThrown) {
            }
        });
    });
});