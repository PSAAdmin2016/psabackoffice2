Application.$controller("PartPSRCivilPageController", ["$scope", "$rootScope", "DialogService", function($scope, $rootScope, DialogService) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {

    };


    $rootScope.gridApprovalReviewSelectCivil = function() {
        //Get Matches
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 72) {
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


    $rootScope.gridApprovalReviewDeselectCivil = function() {
        $scope.Variables.serviceGetMatches.invoke({
            "inputFields": {
                "BidID": 0
            }
        });
        $scope.Variables.serviceGetMatchesByTestPackage.invoke({
            "inputFields": {
                "TestPackage": 'XNAX'
            }
        });
    };


    $scope.buttonDetail1Click = function($event, $isolateScope) {
        $scope.Variables.liveCivilFA.listRecords({
            filterFields: {
                "activityId": {
                    "value": $scope.pageParams.ActivityID
                }
            }
        });
    };


    $scope.popoverAssignHide = function($event, $isolateScope, item, currentItemWidgets) {
        $scope.Variables.serviceUnLockSASActivity.invoke();
    };


    $scope.buttonAssign2Click = function($event, $isolateScope) {
        $scope.Variables.serviceLockSASActivity.invoke(); //Calls dialog onResults
        $scope.Variables.serviceGetQuantitiesTestPackage.invoke();
    };


    $scope.buttonResearchClick = function($event, $isolateScope) {
        $scope.$parent.savePageSettings();
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 70 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 71) {
            $scope.$parent.Variables.navigationToClassicCivil.setData({
                'PageLoadBidID': $scope.pageParams.BidID,
                'PageLoadFiltered': true
            });
            $scope.$parent.Variables.navigationToClassicCivil.invoke();
        }

        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 72) {
            $scope.$parent.Variables.navigationToClassicCivil.setData({
                'PageLoadTestPackage': $scope.pageParams.TestPackage,
                'PageLoadFiltered': true
            });
            $scope.$parent.Variables.navigationToClassicCivil.invoke();
        }
    };


    $scope.buttonReviewNotesClick = function($event, $isolateScope) { //Called by BOTH notes buttons
        DialogService.open('dialogNotes', $scope.$parent);
    };


    $scope.buttonHoldClick = function($event, $isolateScope) {
        $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 44);
        $scope.Variables.serviceUpdateSAS.setInput("BidID", null);
        $scope.Variables.serviceUpdateSAS.invoke(); //Updates GetActivitiesPendingApproval
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


    $scope.serviceCreateLooseHoursActivitiesonResult = function(variable, data) {
        if (!data[0].ReturnStatus) {
            $scope.$parent.Variables.notificationUpdateError.setMessage(data[0].ErrorText);
            $scope.$parent.Variables.notificationUpdateError.invoke();
        }
    };


    $scope.timerLabelFlasheronTimerFire = function(variable, data) {
        if ($scope.Widgets.textCivilTestHrsEarned.datavalue > $scope.Widgets.labelTestPackageHoursRemaining.caption) {
            if ($scope.Variables.staticBrightLabel === false) {
                //console.log("Normal" + $scope.Widgets.textShakeHrsEarned.datavalue);
                $scope.Widgets.labelTestPackageHoursRemaining.fontsize = '';
                $scope.Widgets.labelTestPackageHoursRemaining.borderstyle = '';
                $scope.Widgets.labelTestPackageHoursRemaining.bordercolor = '';
                $scope.Widgets.labelTestPackageHoursRemaining.padding = '';
                $scope.Widgets.labelTestPackageHoursRemaining.color = '';
                $scope.Widgets.labelTestPackageHoursRemaining.backgroundcolor = '';
                $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
            } else {
                //console.log("Bright");
                $scope.Widgets.labelTestPackageHoursRemaining.fontsize = "16";
                $scope.Widgets.labelTestPackageHoursRemaining.borderstyle = "solid";
                $scope.Widgets.labelTestPackageHoursRemaining.bordercolor = "#fffd00";
                $scope.Widgets.labelTestPackageHoursRemaining.padding = "1%";
                $scope.Widgets.labelTestPackageHoursRemaining.color = 'black';
                $scope.Widgets.labelTestPackageHoursRemaining.backgroundcolor = 'red';
                $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
            }
        }

    };

}]);




Application.$controller("dialogRejectionController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.formRejectSubmit = function($event, $isolateScope, $formData) {
            $scope.Variables.timerLabelFlasher.cancel();
            $scope.Variables.serviceUnLockSASActivity.invoke();
            $scope.$parent.$parent.savePageSettings();

            $scope.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 6);
            $scope.Variables.serviceUpdateSAS.setInput("RejectID", $scope.Widgets.formReject.formWidgets.selectRejectReason.datavalue);
            $scope.Variables.serviceUpdateSAS.setInput("BidID", null);
            $scope.Variables.serviceUpdateSAS.invoke(); //Updates GetActivitiesPendingApproval

            $scope.$parent.$parent.Variables.serviceCreateSASNote.setInput("Note", $scope.Widgets.formReject.formWidgets.textareaSASNoteReject.datavalue);
            $scope.$parent.$parent.Variables.serviceCreateSASNote.invoke();
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
            $scope.Variables.serviceCreateLooseHoursActivities.invoke(); //Stored Procedure only runs if Global setting is 1
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