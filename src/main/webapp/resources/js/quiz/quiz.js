$(document).ready(function () {
    $("input[name=response-radios]:radio").change(function () {
        var responseButtonId = $(this).data("question");
        $('button.response-' + responseButtonId).removeClass('disabled');
        var value = $(this).val();
        $('button.response-' + responseButtonId).data("answerValue", value);
        
    })
    var currentQuestionVisited = 0;//bacause it's an array
    var currentLevel = 1;
    
    $('button.response').bind('click', function (e) {
        e.preventDefault();
        var answerValue = $(this).data("answerValue");
        var levelIndex = $(this).data("level");
        var domainIndex = $(this).data("domain");
        var clientDataset = 1;
        var level2Offset = 6;
        var level3OOffset = 12;
        
        /*hack to know domain index per level*/
        if (levelIndex === 2) {
            $('a.level-1').removeClass("active");
            $('a.level-1').addClass("disabled");
            
            $('a.level-2').addClass("active");
            $('a.level-2').removeClass("disabled");
            currentLevel = levelIndex;
            domainIndex = domainIndex - level2Offset;
        } else if (levelIndex === 3) {
            $('a.level-2').removeClass("active");
            $('a.level-2').addClass("disabled");
            
            $('a.level-3').removeClass("disabled");
            $('a.level-2').addClass("active");
            
            currentLevel = levelIndex;
            domainIndex = domainIndex - 12;
        }
        
        window.myRadar.datasets[1].points[domainIndex-1].value=answerValue;
        window.myRadar.update();
        
        var questionWrapper = $('div.domain-question-wrapper-' + domainIndex);
        var questions =  questionWrapper.find(".question-container");//array of questions
        
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
            currentQuestionVisited = currentQuestionVisited + 1;
            if ((currentQuestionVisited) < questionsNumber) {
                $(questions[currentQuestionVisited - 1]).addClass("hidden");//current visible
                //$(questions[currentQuestionVisited]).removeClass("hidden");
            } else if (currentQuestionVisited === questionsNumber) {
                $(questions[currentQuestionVisited - 1]).addClass("hidden");//current visible
                visiblePanel = $('div.domain-question-wrapper-' + domainIndex);
                nextVisiblePanel = $('div.domain-question-wrapper-' + (domainIndex + 1));
                if (visiblePanel && nextVisiblePanel) {
                    visiblePanel.addClass("hidden");
                    nextVisiblePanel.removeClass("hidden");
                }
                currentQuestionVisited = 0;
            }
        }
    });
});

function calculateAnswerAverage(answerValue, domainIndex) {
    
    
}