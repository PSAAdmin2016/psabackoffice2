Application.run(function($rootScope, DialogService) {
    "use strict";

    $rootScope.onAppVariablesReady = function() {

    };


    $rootScope.serviceGetDefaultJobNumberonSuccess = function(variable, data) {
        try {
            console.log("Assigned Job Number: " + data.content[0].fk_DefaultJobNumberId);
            $rootScope.Variables.ActiveJobNumber.dataSet.dataValue = data.content[0].fk_DefaultJobNumberId;
        } catch (err) {
            console.log("Job Number Assign Error:app.js:serviceGetDefaultJobNumberonSuccess: " + err);
        }
    };


    $rootScope.PSAExecuteGetAssignedJobNumbersBYSelectedonResult = function(variable, data) {
        var selectedData = '';
        _.forEach(data.content, function(value, index) {
            var framedOption = value.fk_JobNumber + " - " + value.SiteCity + " " + value.SiteState;
            selectedData += index < data.content.length - 1 ? framedOption + "," : framedOption;
            console.log("data.content: " + value);
        });
        $rootScope.Variables.staticSelectedValuesCheckbox.dataSet.dataValue = selectedData;
    };


    $rootScope.loginVariableonBeforeUpdate = function(variable, inputData) {
        inputData.username = $rootScope.Widgets.usernametext.datavalue;
        inputData.password = $rootScope.Variables.serviceSHA2Hash.dataSet.value;
    };


    $rootScope.serviceLoginSuccessonBeforeUpdate = function(variable, inputData) {
        inputData.EnteredUsername = $rootScope.Variables.loggedInUser.dataSet.name;
    };


    $rootScope.liveGetChatTimerIntervalonSuccess = function(variable, data) {
        $rootScope.Variables.timerGetChatConversations.delay = data[0].value2;
        $rootScope.Variables.timerGetChatConversations.fire();
    };
});


var basicModule = WM.module('wm.widgets.basic');
basicModule.directive('wmVideo', function() {
    return {
        'restrict': 'E',
        'link': function($s, $el, attrs) {
            if (attrs.autoplay) {
                $el.find('video').attr('autoplay', 'autoplay');
            }
        }
    };
});