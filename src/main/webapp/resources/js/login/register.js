$(document).ready(function () {
    $('a.register-menu').bind('click', function (e) {
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

    $('select.work-region').change(function () {
        //get selected option-region Id
        //ajax call to get this specific region
        //replace school select html with schools according to selected region
        var schoolSelect = $('select.work-school');
        var regionId = $('.work-region option:selected').val();
        $.ajax({
            type: "GET",
            url: "/regions?id=" + regionId,
            contentType: 'text/html',
            beforeSend: function() {
            },
            success: function(jqXHR, textStatus, errorThrown) {
                if (schoolSelect) {
                    schoolSelect.empty().append(jqXHR);
                    schoolSelect.selectpicker('refresh');
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
                    if (schoolSelect) {
                        schoolSelect.html(jqXHR);    
                    }
                }   
            },
            complete: function(jqXHR, textStatus, errorThrown) {
            }
        });
    })
});