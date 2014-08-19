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
        window.myRadar.datasets[1].points[domainIndex-1].value=answerValue;
        window.myRadar.update();
        var visiblePanel = $('div.domain-question-wrapper-' + domainIndex);
        var nextVisiblePanel = $('div.domain-question-wrapper-' + (domainIndex + 1));
        if (visiblePanel && nextVisiblePanel) {
            visiblePanel.addClass("hidden");
            nextVisiblePanel.removeClass("hidden");
        }
    });
});

function updateGraph(answerValue, domainIndex) {
    
    
}