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
        /*var recoverPasswordPanel = $('div.recover-password');
        if (recoverPasswordPanel) {
            if (recoverPasswordPanel.hasClass("hidden")) {
                recoverPasswordPanel.removeClass("hidden");
            } else {
                recoverPasswordPanel.addClass("hidden");
            }
        }*/
        // Assign handlers immediately after making the request,
        // and remember the jqxhr object for this request
        var jqxhr = $.post( "/recover-password", function() {
            alert( "success" );
        })
          .done(function(data, textStatus, jqXHR) {
            alert(data);
          })
          .fail(function() {
            alert("error");
          })
          .always(function() {
            alert("finished");
        });
    });
});


        