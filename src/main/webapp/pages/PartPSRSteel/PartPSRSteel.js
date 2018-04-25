Application.$controller("PartPSRSteelPageController", ["$scope", "$rootScope", "DialogService", function($scope, $rootScope, DialogService) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {

    };


    $rootScope.gridApprovalReviewSelectSteel = function() {
        //Get Matches
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 66) {
            $scope.Variables.serviceGetMatchesByTestPackage.invoke({
                "inputFields": {
                    "TestPackage": $scope.pageParams.TestPackage
                }
            });
        } else {
            $scope.Variables.serviceGetMatches.invoke({
                "inputFields": {
                    "BidID": $scope.pageParams.BidID
                }
            });
        }
    };


    $rootScope.gridApprovalReviewDeselectSteel = function() {
        $scope.Variables.serviceGetMatches.invoke({
            "inputFields": {
                "BidID": 0
            }
        });
    };


    //buttonDetail1Click not needed.  All info already avaliable in PendingGrid


    $scope.popoverAssignHide = function($event, $isolateScope, item, currentItemWidgets) {
        $scope.Variables.serviceUnLockSASActivity.invoke();
    };


    $scope.buttonAssign2Click = function($event, $isolateScope) {
        $scope.Variables.serviceLockSASActivity.invoke(); //Calls dialog onResults
        $scope.Variables.serviceGetQuantitiesTestPackage.invoke();
    };


    $scope.ResearchClick = function($event, $isolateScope) {
        $scope.$parent.savePageSettings();
        if ($scope.pageParams.ActivityTypeID == 66) {
            $scope.$parent.Variables.navigationToClassicSteel.setData({
                'PageLoadTestPackage': $scope.pageParams.BidID,
                'PageLoadFiltered': true
            });
        } else {
            $scope.$parent.Variables.navigationToClassicSteel.setData({
                'PageLoadBidID': $scope.pageParams.BidID,
                'PageLoadFiltered': true
            });
        }
        $scope.$parent.Variables.navigationToClassicSteel.invoke();
    };


    $scope.buttonReviewNotesClick = function($event, $isolateScope) { //Called by BOTH notes buttons
        DialogService.open('dialogNotes', $scope.$parent);
    };


    $scope.buttonHoldClick = function($event, $isolateScope) {
        $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 44);
        $scope.Variables.serviceUpdateSAS.setInput("BidID", null);
        $scope.Variables.serviceUpdateSAS.invoke(); //Updates GetActivitiesPendingApproval
    };


    $scope.buttonDissmissClick = function($event, $isolateScope) {
        $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 13);
        $scope.Variables.serviceUpdateSAS.setInput("BidID", null);
        $scope.$parent.$parent.Variables.serviceUpdateSSApproval.invoke(); //Updates GetActivitiesPendingApproval
    };


    $scope.serviceUpdateSASonSuccess = function(variable, data) {
        $scope.$parent.$parent.Variables.serviceGetActivitiesPendingApproval.invoke();
    };


    $scope.serviceLockSASActivityonResult = function(variable, data) {
        if (data[0].ReturnStatus) {
            DialogService.open('dialogAssignTestingQuantities', $scope);
        } else {
            $scope.$parent.Variables.staticRecordLockedMessage.setData({
                "dataValue": data[0].ErrorText
            });
            DialogService.open('alertRecordLocked', $scope.$parent);
        }
    };


    $scope.timerLabelFlasheronTimerFire = function(variable, data) { //Called By dialogAssignQuantitiesOpened
        if ($scope.pageParams.ActivityTypeID == 66) {
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
    };
}]);




Application.$controller("dialogRejectionController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.formRejectSubmit = function($event, $isolateScope, $formData) {
            $scope.Variables.serviceUnLockSASActivity.invoke();
            $scope.$parent.$parent.savePageSettings();

            $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 6);
            $scope.Variables.serviceUpdateSAS.setInput("RejectID", $scope.Widgets.formReject.formWidgets.selectRejectReason.datavalue);
            $scope.Variables.serviceUpdateSAS.setInput("BidID", null);
            $scope.Variables.serviceUpdateSAS.invoke(); //Updates GetActivitiesPendingApproval

            $scope.$parent.$parent.Variables.serviceCreateSASNote.setInput("Note", $scope.Widgets.formReject.formWidgets.textareaSASNoteReject.datavalue);
            $scope.$parent.$parent.Variables.serviceCreateSASNote.invoke();
        };


        $scope.buttonDialogRejectionSaveClick = function($event, $isolateScope) {
            $scope.Variables.timerLabelFlasher.cancel();
        };

    }
]);


Application.$controller("dialogPSAActivityDetailsController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("dialogBidActivityDetailsController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);


Application.$controller("dialogAssignTestingQuantitiesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.buttonQuantitiesUpdate2Click = function($event, $isolateScope) {
            $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 5);
            $scope.Variables.serviceUpdateSAS.setInput("BidID", '');
            $scope.Variables.serviceUpdateSAS.invoke(); //Updates GetActivitiesPendingApproval

            $scope.Variables.timerLabelFlasher.cancel();
            if ($scope.Variables.Job1111SettingsData.getData().data.find(x => x.label === 'LooseHoursRoundupSteel').value2 == 1) { //Run only if Global setting is 1
                $scope.Variables.serviceCreateLooseHoursActivities.invoke();
            }
        };


        $scope.dialogAssignTestingQuantitiesOpened = function($event, $isolateScope) {
            $scope.Variables.staticBrightLabel = false;
            $scope.Variables.timerLabelFlasher.invoke();
        };


        $scope.dialogAssignTestingQuantitiesClose = function($event, $isolateScope) {
            $scope.Variables.serviceUnLockSASActivity.invoke();
            $scope.Variables.timerLabelFlasher.cancel();
        };

    }
]);

Application.$controller("Table1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);