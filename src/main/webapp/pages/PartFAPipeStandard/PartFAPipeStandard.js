Application.$controller("PartFAPipeStandardPageController", ["$scope", function($scope) {
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
        inputData.Notes = $scope.Widgets.textareaFANotes.datavalue;
        inputData.BidID = $scope.$parent.Variables.liveGetActivityDetails.dataSet.data[0].pipeFa.fabidId;

        switch ($scope.$parent.Variables.liveGetActivityDetails.dataSet.data[0].activityType) {
            case 23:
            case 31:
            case 32:
            case 33:
            case 39:
                inputData.Rework = $scope.Widgets.checkboxFARework.datavalue;
                inputData.Quantity = Widgets.textFAQuantity1.datavalue;
                inputData.Percent = 1.00;
                break;
            case 38:
                inputData.Rework = $scope.Widgets.checkboxFARework.datavalue;
                inputData.Quantity = $scope.Widgets.textFAQuantity2.datavalue;
                inputData.Percent = $scope.Widgets.selectFAPercent2.datavalue;
                break;
            case 51:
            case 52:
            case 53:
                inputData.Rework = 0;
                inputData.Quantity = 1;
                inputData.Percent = $scope.Widgets.selectFAPercent3.datavalue;
                break;
            case 90:
                inputData.Rework = $scope.Widgets.checkboxFARework.datavalue;
                inputData.Quantity = 1;
                inputData.Percent = $scope.Widgets.selectFAPercent3.datavalue;
                break;
        }
    };


}]);