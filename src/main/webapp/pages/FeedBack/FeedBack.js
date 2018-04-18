Application.$controller("FeedBackPageController", ["$scope", "$timeout", function($scope, $timeout) {
    "use strict";

    $scope.items = ["one", 'two', 'three'];

    /* perform any action on the variables within this block(on-page-load) */
    $scope.onPageVariablesReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
         * $scope.Variables.loggedInUser.getData()
         */

    };

    /* perform any action on widgets within this block */
    $scope.onPageReady = function() {
        /*
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */


    };


    $scope.button2Click = function($event, $isolateScope) {
        $timeout(function() {
            $('[name="popoverFeedback"]').click();
        });
    };


    $scope.formFeedbackSubmit = function($event, $isolateScope, $formData) {
        $scope.Variables.PSAExecuteInsertFeedbackTicket.update();
        $timeout(function() {
            $('[name="popoverFeedback"]').click();
        });
    };



}]);