Application.$controller("PartFACivilStandardPageController", ["$scope", function($scope) {
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


    $scope.serviceUpdateActivityonBeforeUpdate = function(variable, inputData) {
        inputData.Notes = $scope.Widgets.textareaNotes.datavalue;
        inputData.BidID = $scope.$parent.Variables.liveGetActivityDetails.dataSet.data[0].civilFa.fabidId;
        inputData.Rework = $scope.Widgets.checkboxRework.datavalue;

        switch ($scope.$parent.Variables.liveGetActivityDetails.dataSet.data[0].activityType) {
            case 70:
                inputData.Quantity = 1;
                inputData.Percent = $scope.Widgets.selectPercentCompleted.datavalue;
                break;
            case 71:
                inputData.Quantity = $scope.Widgets.textQuantity.datavalue;
                inputData.Percent = 1.00;
                break;
        }
    };

}]);