Application.$controller("PartAssignSteelPageController", ["$scope", "DialogService", function($scope, DialogService) {
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


    $scope.timerLabelFlasheronTimerFire = function(variable, data) { //Called By dialogAssignQuantitiesOpened
        if ($scope.pageParams.ActivityTypeID == 61) {
            if ($scope.Widgets.textShakeHrsEarned.datavalue > $scope.Widgets.labelShakeHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textShakeHrsEarned.datavalue);
                    $scope.Widgets.labelShakeHoursRemaining.fontsize = '';
                    $scope.Widgets.labelShakeHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelShakeHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelShakeHoursRemaining.padding = '';
                    $scope.Widgets.labelShakeHoursRemaining.color = '';
                    $scope.Widgets.labelShakeHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelShakeHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelShakeHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelShakeHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelShakeHoursRemaining.padding = "1%";
                    $scope.Widgets.labelShakeHoursRemaining.color = 'black';
                    $scope.Widgets.labelShakeHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.pageParams.ActivityTypeID == 62) {
            if ($scope.Widgets.textErectHrsEarned.datavalue > $scope.Widgets.labelErectHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textErectHrsEarned.datavalue);
                    $scope.Widgets.labelErectHoursRemaining.fontsize = '';
                    $scope.Widgets.labelErectHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelErectHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelErectHoursRemaining.padding = '';
                    $scope.Widgets.labelErectHoursRemaining.color = '';
                    $scope.Widgets.labelErectHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelErectHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelErectHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelErectHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelErectHoursRemaining.padding = "1%";
                    $scope.Widgets.labelErectHoursRemaining.color = 'black';
                    $scope.Widgets.labelErectHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.pageParams.ActivityTypeID == 63) {
            if ($scope.Widgets.textBoltoutHrsEarned.datavalue > $scope.Widgets.labelBoltoutHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textBoltoutHrsEarned.datavalue);
                    $scope.Widgets.labelBoltoutHoursRemaining.fontsize = '';
                    $scope.Widgets.labelBoltoutHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelBoltoutHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelBoltoutHoursRemaining.padding = '';
                    $scope.Widgets.labelBoltoutHoursRemaining.color = '';
                    $scope.Widgets.labelBoltoutHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelBoltoutHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelBoltoutHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelBoltoutHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelBoltoutHoursRemaining.padding = "1%";
                    $scope.Widgets.labelBoltoutHoursRemaining.color = 'black';
                    $scope.Widgets.labelBoltoutHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.pageParams.ActivityTypeID == 64) {
            if ($scope.Widgets.textImpHrsEarned.datavalue > $scope.Widgets.labelImpHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textImpHrsEarned.datavalue);
                    $scope.Widgets.labelImpHoursRemaining.fontsize = '';
                    $scope.Widgets.labelImpHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelImpHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelImpHoursRemaining.padding = '';
                    $scope.Widgets.labelImpHoursRemaining.color = '';
                    $scope.Widgets.labelImpHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelImpHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelImpHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelImpHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelImpHoursRemaining.padding = "1%";
                    $scope.Widgets.labelImpHoursRemaining.color = 'black';
                    $scope.Widgets.labelImpHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.pageParams.ActivityTypeID == 65) {
            if ($scope.Widgets.textSellHrsEarned.datavalue > $scope.Widgets.labelSellHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textSellHrsEarned.datavalue);
                    $scope.Widgets.labelSellHoursRemaining.fontsize = '';
                    $scope.Widgets.labelSellHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelSellHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelSellHoursRemaining.padding = '';
                    $scope.Widgets.labelSellHoursRemaining.color = '';
                    $scope.Widgets.labelSellHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelSellHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelSellHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelSellHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelSellHoursRemaining.padding = "1%";
                    $scope.Widgets.labelSellHoursRemaining.color = 'black';
                    $scope.Widgets.labelSellHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.pageParams.ActivityTypeID == 67) {
            if ($scope.Widgets.textDemoHrsEarned.datavalue > $scope.Widgets.labelDemoHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textDemoHrsEarned.datavalue);
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
        if ($scope.pageParams.ActivityTypeID == 68) {
            if ($scope.Widgets.textWeldHrsEarned.datavalue > $scope.Widgets.labelWeldHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textWeldHrsEarned.datavalue);
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
        if ($scope.pageParams.ActivityTypeID == 96) {
            if ($scope.Widgets.textMiscHrsEarned.datavalue > $scope.Widgets.labelMiscHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textMiscHrsEarned.datavalue);
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