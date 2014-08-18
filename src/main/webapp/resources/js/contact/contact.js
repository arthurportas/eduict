$(document).ready(function () {
    $('a.contacts').bind('click', function (e) {
        e.preventDefault();
        var contactPanel = $('div.contact');
        if (contactPanel) {
            if (contactPanel.hasClass("hidden")) {
                contactPanel.removeClass("hidden");
            } else {
                contactPanel.addClass("hidden");
            }
        }
    });
});
$(document).ready(function () {
    $('textarea.contact-message').bind('keyup', function (e) {
        $('button.contact-email').removeClass("disabled");
    });
    
    $('button.contact-email').bind('click', function (e) {
        e.preventDefault();
        // Assign handlers immediately after making the request,
        // and remember the jqxhr object for this request
        var contactMessageAlertElement = $('div.contact-message-alert');
        var _email = $('.contact-email').val();
        var _subject = $('.contact-subject').val();
        var _message = $('.contact-message').val();
        var formData = "?email="  + _email + "&subject="  + _subject + "&message=" + _message;  
 
        $.ajax({
            type: "POST",
            url: "/contact-eduict" + formData,
            contentType: 'text/html',
            beforeSend: function() {
            },
            success: function(jqXHR, textStatus, errorThrown) {
                if (contactMessageAlertElement) {
                    contactMessageAlertElement.html(jqXHR);    
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
                    if (contactMessageAlertElement) {
                        contactMessageAlertElement.html(jqXHR);    
                    }
                }   
            },
            complete: function(jqXHR, textStatus, errorThrown) {
            }
        });
    });
});