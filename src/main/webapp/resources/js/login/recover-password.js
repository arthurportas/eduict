$(document).ready(function () {
    $('a.recover-password').bind('click', function (e) {
        e.preventDefault();
        var recoverPasswordPanel = $('div.recover-password');
        if (recoverPasswordPanel) {
            if (recoverPasswordPanel.hasClass("hidden")) {
                recoverPasswordPanel.removeClass("hidden");
            } else {
                recoverPasswordPanel.addClass("hidden");
            }
        }
    });
});

$(document).ready(function () {
    $('button.recover-password').bind('click', function (e) {
        e.preventDefault();
        // Assign handlers immediately after making the request,
        // and remember the jqxhr object for this request
        var recoverPasswordAlertElement = $('div.recover-password-alert');
        var email = $('.recover-email').val();
        $.ajax({
            type: "GET",
            url: "/recover-password?recover-email=" + email,
            contentType: 'text/html',
            beforeSend: function() {
            },
            success: function(jqXHR, textStatus, errorThrown) {
                if (recoverPasswordAlertElement) {
                    recoverPasswordAlertElement.html(jqXHR);    
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
                    if (recoverPasswordAlertElement) {
                        recoverPasswordAlertElement.html(jqXHR);    
                    }
                }   
            },
            complete: function(jqXHR, textStatus, errorThrown) {
            }
        });
    });
});


        