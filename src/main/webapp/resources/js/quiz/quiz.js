$(document).ready(function () {
    $('button.response').bind('click', function (e) {
        e.preventDefault();
        var answerValue = 3;
        var domainIndex = 1;
        var clientDataset = 1;
        window.myRadar.datasets[1].points[1].value=3;
        /*var visiblePanel = $('div.login');
        if (visiblePanel) {
            if (visiblePanel.hasClass("hidden")) {
                visiblePanel.removeClass("hidden");
            } else {
                visiblePanel.addClass("hidden");
            }
        }*/
    });
});