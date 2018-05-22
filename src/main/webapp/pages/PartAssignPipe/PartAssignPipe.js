Application.$controller("PartAssignPipePageController", ["$scope", "DialogService", function($scope, DialogService) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {
        $scope.Variables.staticBrightLabel = false; //simple page scope variable needed for Flasher.
    };


    $scope.buttonQuantitiesUpdateClick = function($event, $isolateScope) {
        $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 5);
        $scope.Variables.serviceUpdateSAS.invoke(); //Updates GetActivitiesPendingApproval
        $scope.Variables.serviceUnLockSASActivity.invoke();
    };


    $scope.buttonRejectQuantityClick = function($event, $isolateScope) {
        DialogService.open('dialogRejection', $scope.$parent.$parent.$parent.$parent.$parent); //This closes PopOver -> PopOver onHide Triggers serviceUnLockSASActivity
    };


    $scope.serviceUpdateSASonSuccess = function(variable, data) {
        $scope.Variables.timerLabelFlasher.cancel();
        $scope.$parent.$parent.$parent.$parent.$parent.$parent.$parent.Variables.serviceGetActivitiesPendingApproval.invoke();
    };


    $scope.serviceLockSASActivityonResult = function(variable, data) { // Called on Page load
        if (!data[0].ReturnStatus) {
            $scope.$parent.$parent.$parent.$parent.$parent.$parent.$parent.Variables.staticRecordLockedMessage.setData({
                "dataValue": data[0].ErrorText
            });
            DialogService.open('alertRecordLocked', $scope.$parent.$parent.$parent.$parent.$parent.$parent.$parent);
        }
    };


    $scope.timerLabelFlasheronTimerFire = function(variable, data) { // Fired from Assign Dialog On Open
        if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelHoursRemaining.caption) {
            if ($scope.Variables.staticBrightLabel === false) {
                $scope.Widgets.labelHoursRemaining.fontsize = '';
                $scope.Widgets.labelHoursRemaining.borderstyle = '';
                $scope.Widgets.labelHoursRemaining.bordercolor = '';
                $scope.Widgets.labelHoursRemaining.padding = '';
                $scope.Widgets.labelHoursRemaining.color = '';
                $scope.Widgets.labelHoursRemaining.backgroundcolor = '';
                $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
            } else {
                //console.log("Bright");
                $scope.Widgets.labelHoursRemaining.fontsize = "16";
                $scope.Widgets.labelHoursRemaining.borderstyle = "solid";
                $scope.Widgets.labelHoursRemaining.bordercolor = "#fffd00";
                $scope.Widgets.labelHoursRemaining.padding = "1%";
                $scope.Widgets.labelHoursRemaining.color = 'black';
                $scope.Widgets.labelHoursRemaining.backgroundcolor = 'red';
                $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
            }
        }
    };


}]);