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
        
        var questionWrapper = $('div.domain-question-wrapper-' + domainIndex);
        var questions =  questionWrapper.find(".question-container");//array of questions
        var currentQuestionVisited = 0;//bacause it's an array
        var questionsNumber = questions.length;
        
        if (questionsNumber === 1) {
            var visiblePanel = $('div.domain-question-wrapper-' + domainIndex);
            var nextVisiblePanel = $('div.domain-question-wrapper-' + (domainIndex + 1));
            if (visiblePanel && nextVisiblePanel) {
                visiblePanel.addClass("hidden");
                nextVisiblePanel.removeClass("hidden");
            }
        } else {
            //go to next question, if not visited
            currentQuestionVisited +=1;
            if ((currentQuestionVisited) < questionsNumber) {
                $(questions[currentQuestionVisited - 1]).addClass("hidden");//current visible
                $(questions[currentQuestionVisited]).removeClass("hidden");
            }
        }
    });
});

function calculateAnswerAverage(answerValue, domainIndex) {
    
    
}