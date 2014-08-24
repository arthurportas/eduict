$(document).ready(function () {
    $("input[name=response-radios]:radio").change(function () {
        var responseButtonId = $(this).data("question");
        $('button.response-' + responseButtonId).removeClass('disabled');
        var value = $(this).val();
        $('button.response-' + responseButtonId).data("answerValue", value);
        
    })
    var currentQuestionVisited = 0;//bacause it's an array
    var currentLevel = 1;
    var level2Offset = 6;
    var level3OOffset = 12;
    var averages = {
            level1 :{
                domain1 :{
                    value: 0
                },
                domain2 :{
                    value: 0
                },
                domain3 :{
                    value: 0
                },
                domain4 :{
                    value: 0
                },
                domain5 :{
                    value: 0
                },
                domain6 :{
                    value: 0
                },
            },
            level2 :{
                domain1 :{
                    value: 0,
                    visible: false
                },
                domain2 :{
                    value: 0,
                    visible: false
                },
                domain3 :{
                    value: 0,
                    visible: false
                },
                domain4 :{
                    value: 0,
                    visible: false
                },
                domain5 :{
                    value: 0,
                    visible: false
                },
                domain6 :{
                    value: 0,
                    visible: false
                },
            },
            level3 :{
                domain1 :{
                    value: 0,
                    visible: false
                },
                domain2 :{
                    value: 0,
                    visible: false
                },
                domain3 :{
                    value: 0,
                    visible: false
                },
                domain4 :{
                    value: 0,
                    visible: false
                },
                domain5 :{
                    value: 0,
                    visible: false
                },
                domain6 :{
                    value: 0,
                    visible: false
                },
            },
        };
        
    $('button.response').bind('click', function (e) {
        e.preventDefault();
        var answerValue = $(this).data("answerValue");
        var levelIndex = $(this).data("level");
        var questionVisible = $(this).data("question");
        var domainIndex = $(this).data("domain");
        var datasetValueIndex = domainIndex;
        var clientDataset = 1;
        
        /*hack to know domain index per level*/
        if (questionVisible === 22) {//22 is the last question on first level
            //may i see the next level?
        
            $('div.level-1-wrapper').addClass("hidden");
            $('div.level-2-wrapper').removeClass("hidden");
            
            $('a.level-1').removeClass("active");
            $('a.level-1').addClass("disabled");
            
            $('a.level-2').addClass("active");
            $('a.level-2').removeClass("disabled");
            
        } else if (questionVisible === 23) {//23 is the first question on second level
            currentLevel = 2;
        } else if (questionVisible === 43) {//43 is the last question on second level
            $('div.level-2-wrapper').addClass("hidden");
            $('div.level-3-wrapper').removeClass("hidden");
            
            $('a.level-2').removeClass("active");
            $('a.level-2').addClass("disabled");
            
            $('a.level-3').removeClass("disabled");
            $('a.level-3').addClass("active");

        } else if (questionVisible === 44) {//44 is the first question on third level
            currentLevel = 3;
        } else if (questionVisible === 61) {//61 is the last question 
            $(this).html('Selecionar a resposta e gravar resultados');
            //ajax call to record my results
        }
            //console.log('currentLevel->' + currentLevel);
            //console.log('currentDomain->' + domainIndex);
       
        var questionWrapper = $('div.domain-question-wrapper-' + domainIndex);
        var questions =  questionWrapper.find(".question-container");//array of questions
        
        var questionsNumber = questions.length;
        
        if (currentLevel === 2) {
            datasetValueIndex = domainIndex - level2Offset;
        } else if (currentLevel === 3) {
            datasetValueIndex = domainIndex - level3OOffset;
        }
        
        var valueToUpdate = window.myRadar.datasets[1].points[datasetValueIndex-1];
        console.log('atualizar indice ->' + (datasetValueIndex-1));
        
        if (valueToUpdate) {
             valueToUpdate.value = valueToUpdate.value + (answerValue / questionsNumber);
            window.myRadar.update();
        }
        
        switch (questionVisible) {
            case 1: averages.level1.domain1.value = window.myRadar.datasets[1].points[0].value;
                break;
            case 2: averages.level1.domain2.value = window.myRadar.datasets[1].points[1].value;
                break;
            case 5: averages.level1.domain3.value = window.myRadar.datasets[1].points[2].value;
                break;
            case 16: averages.level1.domain4.value = window.myRadar.datasets[1].points[3].value;
                break;
            case 19: averages.level1.domain5.value = window.myRadar.datasets[1].points[4].value;
                break;
            case 22: averages.level1.domain6.value = window.myRadar.datasets[1].points[5].value;
                if (averages.level1.domain1.value === 1) {
                    averages.level2.domain1.visible = true; 
                } 
                if (averages.level1.domain2.value === 1) {
                    averages.level2.domain2.visible = true; 
                } 
                if (averages.level1.domain3.value === 1) {
                    averages.level2.domain3.visible = true; 
                }
                if (averages.level1.domain4.value === 1) {
                    averages.level2.domain4.visible = true; 
                }
                if (averages.level1.domain5.value === 1) {
                    averages.level2.domain5.visible = true; 
                }
                if (averages.level1.domain6.value === 1) {
                    averages.level2.domain6.visible = true; 
                }
                break;
            case 23: averages.level2.domain1.value = window.myRadar.datasets[1].points[0].value;
                break;
            case 25: averages.level2.domain2.value = window.myRadar.datasets[1].points[1].value;
                break;
            case 31: averages.level2.domain3.value = window.myRadar.datasets[1].points[2].value;
                break;
            case 38: averages.level2.domain4.value = window.myRadar.datasets[1].points[3].value;
                break;
            case 40: averages.level2.domain5.value = window.myRadar.datasets[1].points[4].value;
                break;
            case 43: averages.level2.domain6.value = window.myRadar.datasets[1].points[5].value;
                break;
            case 44: averages.level3.domain1.value = window.myRadar.datasets[1].points[0].value;
                break;
            case 49: averages.level3.domain2.value = window.myRadar.datasets[1].points[1].value;
                break;
            case 54: averages.level3.domain3.value = window.myRadar.datasets[1].points[2].value;
                break;
            case 55: averages.level3.domain4.value = window.myRadar.datasets[1].points[3].value;
                break;
            case 57: averages.level3.domain5.value = window.myRadar.datasets[1].points[4].value;
                break;
            case 61: averages.level3.domain6.value = window.myRadar.datasets[1].points[5].value;
                break;
            default:
                // code
        }
        
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