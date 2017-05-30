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


    $scope.button1Click = function($event, $isolateScope, item, currentItemWidgets) {
        /*
        console.log("ScopeK: " + _.keys($scope.Widgets.livelist1));
        console.log("ScopeV: " + _.values($scope.Widgets.livelist1));
        console.log("Scope2K: " + _.keys(item));
        console.log("Scope2V: " + _.values(item));
        console.log("Keys1: " + _.keys($scope.$parent));
        console.log("Keys2: " + _.keys($scope.$parent.$parent));
        console.log("Keys3: " + _.keys($scope.$parent.$parent.$parent));
        console.log("Keys4: " + _.keys($scope.$parent.$parent.$parent.$parent));
        console.log("Keys5: " + _.keys($scope.$parent.$parent.$parent.$parent.$parent));
        console.log("Keys6: " + _.keys($scope.$parent.$parent.$parent.$parent.$parent.$parent));
        console.log("Rabbit Hole: " + _.keys($scope.$parent.$parent.$parent.$parent.$parent.$parent.Variables.serviceGetBidWorkHistoryExpanded.dataSet.content[0]));
        */
    };


    $scope.serviceUpdateSSReturnToListPSonSuccess = function(variable, data) {
        $scope.$parent.$parent.$parent.$parent.$parent.Variables.serviceGetBidWorkHistoryExpanded.invoke();
        $scope.$parent.$parent.$parent.$parent.$parent.Variables.serviceGetBidWorkHistory.invoke();
        $scope.$parent.$parent.$parent.$parent.$parent.Variables.serviceUpdateClassicTracker.invoke();
    };


    $scope.buttonOverRideClick = function($event, $isolateScope, item, currentItemWidgets) {
        $scope.$parent.$parent.$parent.$parent.$parent.dialogOverrideOpen(item);
        //DialogService.open('dialogQuantityOverride', $scope.$parent.$parent.$parent.$parent.$parent, item); //Possibly more correct way of doing this.
    };



    $scope.buttonHistoryClick = function($event, $isolateScope, item, currentItemWidgets) {
        $scope.$parent.$parent.$parent.$parent.$parent.dialogActivityHistoryOpen(item);
    };

}]);