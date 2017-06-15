Application.$controller("PopSteelFAExpandedPageController", ["$scope", "DialogService", function($scope, DialogService) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. to get dataSet in a staticVariable named 'loggedInUser' use following script
         * $scope.Variables.loggedInUser.getData()
         *
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. to get value of text widget named 'username' use following script
         * '$scope.Widgets.username.datavalue'
         */

    };


    $scope.serviceUpdateSSReturnToListPSonSuccess = function(variable, data) {
        $scope.$parent.$parent.$parent.$parent.$parent.Variables.serviceGetBidWorkHistoryExpanded.invoke();
        $scope.$parent.$parent.$parent.$parent.$parent.Variables.serviceGetBidWorkHistory.invoke();
        $scope.$parent.$parent.$parent.$parent.$parent.Variables.serviceUpdateClassicTracker.invoke();
    };


    $scope.buttonOverRideClick = function($event, $isolateScope, item, currentItemWidgets) {
        $scope.$parent.$parent.$parent.$parent.$parent.dialogOverrideOpen(item);
    };


    $scope.buttonHistoryClick = function($event, $isolateScope, item, currentItemWidgets) {
        $scope.$parent.$parent.$parent.$parent.$parent.dialogActivityHistoryOpen(item);
    };

}]);