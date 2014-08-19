$(document).ready(function () {
    $('button.response').bind('click', function (e) {
        e.preventDefault();
        var answerValue = 3;
        var domainIndex = 1;
        var clientDataset = 1;
        var chart = radarChartData;
        if(chart) {
            chart.datasets[clientDataset].data[domainIndex] = answerValue;
            chart.update();
        }
        debugger;
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