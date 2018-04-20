Application.$controller("PartAssignEquipPageController", ["$scope", "DialogService", function($scope, DialogService) {
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
        $scope.Variables.staticBrightLabel = false; //simple page scope variable needed for Flasher.
    };


    $scope.buttonQuantitiesUpdateClick = function($event, $isolateScope) {
        $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 5);
        $scope.Variables.serviceUpdateSAS.invoke(); //Updates GetActivitiesPendingApproval
        // Nothing at this point forces a select of new row in Pending (even though it refreshes), and in turn no new match.. so no force closure of the popOver
        // This needs to be handled 2 ways.  1 make the logic for selecting a row in Pending after update stronger.  2. Make the logic clearing of the PSRPart page container more robust
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


    $scope.timerLabelFlasheronTimerFire = function(variable, data) {
        if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelFAHoursRemaining.caption) {
            if ($scope.Variables.staticBrightLabel === false) {
                //console.log("Normal" + $scope.Widgets.textShakeHrsEarned.datavalue);
                $scope.Widgets.labelFAHoursRemaining.fontsize = '';
                $scope.Widgets.labelFAHoursRemaining.borderstyle = '';
                $scope.Widgets.labelFAHoursRemaining.bordercolor = '';
                $scope.Widgets.labelFAHoursRemaining.padding = '';
                $scope.Widgets.labelFAHoursRemaining.color = '';
                $scope.Widgets.labelFAHoursRemaining.backgroundcolor = '';
                $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
            } else {
                //console.log("Bright");
                $scope.Widgets.labelFAHoursRemaining.fontsize = "16";
                $scope.Widgets.labelFAHoursRemaining.borderstyle = "solid";
                $scope.Widgets.labelFAHoursRemaining.bordercolor = "#fffd00";
                $scope.Widgets.labelFAHoursRemaining.padding = "1%";
                $scope.Widgets.labelFAHoursRemaining.color = 'black';
                $scope.Widgets.labelFAHoursRemaining.backgroundcolor = 'red';
                $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
            }
        }

    };

}]);