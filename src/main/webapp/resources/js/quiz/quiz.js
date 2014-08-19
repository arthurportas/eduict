$(document).ready(function () {
    $("input[name=response-radios]:radio").change(function () {
        var responseButtonId = $(this).data("question");
        $('button.response-' + responseButtonId).removeClass('disabled');
        var value = $(this).val();
        $('button.response-' + responseButtonId).data("answerValue", value);
        
    })
    
    $('button.response').bind('click', function (e) {
        e.preventDefault();
        var answerValue = $(this).data("answerValue");
        var domainIndex = $(this).data("domain");
        var clientDataset = 1;
        window.myRadar.datasets[1].points[domainIndex].value=3;
        window.myRadar.update();
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

function updateGraph(answerValue, domainIndex) {
    
    
}