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
        if ($scope.pageParams.ActivityTypeID == 11) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelErectionHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelErectionHoursRemaining.fontsize = '';
                    $scope.Widgets.labelErectionHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelErectionHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelErectionHoursRemaining.padding = '';
                    $scope.Widgets.labelErectionHoursRemaining.color = '';
                    $scope.Widgets.labelErectionHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelErectionHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelErectionHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelErectionHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelErectionHoursRemaining.padding = "1%";
                    $scope.Widgets.labelErectionHoursRemaining.color = 'black';
                    $scope.Widgets.labelErectionHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.pageParams.ActivityTypeID == 21) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelBoltUpHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelBoltUpHoursRemaining.fontsize = '';
                    $scope.Widgets.labelBoltUpHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelBoltUpHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelBoltUpHoursRemaining.padding = '';
                    $scope.Widgets.labelBoltUpHoursRemaining.color = '';
                    $scope.Widgets.labelBoltUpHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelBoltUpHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelBoltUpHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelBoltUpHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelBoltUpHoursRemaining.padding = "1%";
                    $scope.Widgets.labelBoltUpHoursRemaining.color = 'black';
                    $scope.Widgets.labelBoltUpHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.pageParams.ActivityTypeID == 22) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelWeldHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelWeldHoursRemaining.fontsize = '';
                    $scope.Widgets.labelWeldHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelWeldHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelWeldHoursRemaining.padding = '';
                    $scope.Widgets.labelWeldHoursRemaining.color = '';
                    $scope.Widgets.labelWeldHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelWeldHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelWeldHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelWeldHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelWeldHoursRemaining.padding = "1%";
                    $scope.Widgets.labelWeldHoursRemaining.color = 'black';
                    $scope.Widgets.labelWeldHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.pageParams.ActivityTypeID == 23) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelCutHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelCutHoursRemaining.fontsize = '';
                    $scope.Widgets.labelCutHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelCutHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelCutHoursRemaining.padding = '';
                    $scope.Widgets.labelCutHoursRemaining.color = '';
                    $scope.Widgets.labelCutHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelCutHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelCutHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelCutHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelCutHoursRemaining.padding = "1%";
                    $scope.Widgets.labelCutHoursRemaining.color = 'black';
                    $scope.Widgets.labelCutHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.pageParams.ActivityTypeID == 31 || $scope.pageParams.ActivityTypeID == 33 || $scope.pageParams.ActivityTypeID == 34 || $scope.pageParams.ActivityTypeID == 35 || $scope.pageParams.ActivityTypeID == 39) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelTrimHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelTrimHoursRemaining.fontsize = '';
                    $scope.Widgets.labelTrimHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelTrimHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelTrimHoursRemaining.padding = '';
                    $scope.Widgets.labelTrimHoursRemaining.color = '';
                    $scope.Widgets.labelTrimHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelTrimHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelTrimHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelTrimHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelTrimHoursRemaining.padding = "1%";
                    $scope.Widgets.labelTrimHoursRemaining.color = 'black';
                    $scope.Widgets.labelTrimHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.pageParams.ActivityTypeID == 32) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelSupportHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelSupportHoursRemaining.fontsize = '';
                    $scope.Widgets.labelSupportHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelSupportHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelSupportHoursRemaining.padding = '';
                    $scope.Widgets.labelSupportHoursRemaining.color = '';
                    $scope.Widgets.labelSupportHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelSupportHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelSupportHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelSupportHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelSupportHoursRemaining.padding = "1%";
                    $scope.Widgets.labelSupportHoursRemaining.color = 'black';
                    $scope.Widgets.labelSupportHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.pageParams.ActivityTypeID == 51 || $scope.pageParams.ActivityTypeID == 52 || $scope.pageParams.ActivityTypeID == 53) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelDemoHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelDemoHoursRemaining.fontsize = '';
                    $scope.Widgets.labelDemoHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelDemoHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelDemoHoursRemaining.padding = '';
                    $scope.Widgets.labelDemoHoursRemaining.color = '';
                    $scope.Widgets.labelDemoHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire

                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelDemoHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelDemoHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelDemoHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelDemoHoursRemaining.padding = "1%";
                    $scope.Widgets.labelDemoHoursRemaining.color = 'black';
                    $scope.Widgets.labelDemoHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.pageParams.ActivityTypeID == 91) {
            if ($scope.Widgets.textHrsEarned.datavalue > $scope.Widgets.labelMiscHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelMiscHoursRemaining.fontsize = '';
                    $scope.Widgets.labelMiscHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelMiscHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelMiscHoursRemaining.padding = '';
                    $scope.Widgets.labelMiscHoursRemaining.color = '';
                    $scope.Widgets.labelMiscHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelMiscHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelMiscHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelMiscHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelMiscHoursRemaining.padding = "1%";
                    $scope.Widgets.labelMiscHoursRemaining.color = 'black';
                    $scope.Widgets.labelMiscHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
    };


}]);