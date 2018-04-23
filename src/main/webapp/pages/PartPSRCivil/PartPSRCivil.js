Application.$controller("PartPSRCivilPageController", ["$scope", "$rootScope", "DialogService", function($scope, $rootScope, DialogService) {
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
    };


    $scope.buttonDetail1Click = function($event, $isolateScope) {
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 70 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 71) {
            $scope.Variables.liveCivilFA.listRecords({
                filterFields: {
                    "activityId": {
                        "value": $parent.Widgets.gridApprovalReview.selecteditem.ActivityID
                    }
                }
            });
        }
    };


    $scope.buttonAssign2Click = function($event, $isolateScope) {
        $scope.Variables.serviceLockSASActivity.invoke(); //Calls dialog onResults
        $scope.Variables.serviceGetQuantitiesTestPackage.invoke(); //Get quantities query running asap.
    };


    $scope.serviceLockSASActivityonResult = function(variable, data) {
        if (data[0].ReturnStatus) {
            if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType != 72) {
                DialogService.open('dialogAssignQuantities', $scope);
            } else {
                DialogService.open('dialogAssignTestingQuantities', $scope);
            }
        } else {
            $scope.$parent.Variables.staticRecordLockedMessage.setData({
                "dataValue": data[0].ErrorText
            });
            DialogService.open('alertRecordLocked', $scope.$parent);
        }
    };


    $scope.timerLabelFlasheronTimerFire = function(variable, data) {
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 70) {
            if ($scope.Widgets.textNonPourHrsEarned.datavalue > $scope.Widgets.labelFAHoursRemaining.caption) {
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
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 71) {
            if ($scope.Widgets.textPourHrsEarned.datavalue > $scope.Widgets.labelFAHoursRemaining.caption) {
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
        }

    };


    $scope.timerLabelFlasher2onTimerFire = function(variable, data) {
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


    $scope.buttonResearchClick = function($event, $isolateScope) {
        $scope.$parent.savePageSettings();
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 70 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 71) {
            $scope.$parent.Variables.navigationToClassicCivil.setData({
                'PageLoadBidID': parseInt($scope.$parent.Widgets.gridApprovalReview.selecteditem.Spool2),
                'PageLoadFiltered': true
            });
            $scope.$parent.Variables.navigationToClassicCivil.invoke();
        }

        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 72) {
            $scope.$parent.Variables.navigationToClassicCivil.setData({
                'PageLoadTestPackage': $scope.$parent.Widgets.gridApprovalReview.selecteditem.Line1,
                'PageLoadFiltered': true
            });
            $scope.$parent.Variables.navigationToClassicCivil.invoke();
        }
    };


    $scope.buttonReviewNotesClick = function($event, $isolateScope) { //Called by BOTH notes buttons
        DialogService.open('dialogNotes', $scope.$parent);
    };


    $scope.buttonHoldClick = function($event, $isolateScope) {
        $scope.$parent.$parent.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 44);
        $scope.$parent.$parent.Variables.serviceUpdateSAS.setInput("BidID", null);
        $scope.$parent.$parent.Variables.serviceUpdateSAS.invoke(); //Updates GetActivitiesPendingApproval
    };

}]);




Application.$controller("dialogRejectionController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.formRejectSubmit = function($event, $isolateScope, $formData) {
            $scope.Variables.serviceUnLockSASActivity.invoke();

            $scope.$parent.$parent.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 6);
            $scope.$parent.$parent.Variables.serviceUpdateSAS.setInput("RejectID", $scope.Widgets.formReject.formWidgets.selectRejectReason.datavalue);
            $scope.$parent.$parent.Variables.serviceUpdateSAS.setInput("BidID", null);
            $scope.$parent.$parent.Variables.serviceUpdateSAS.invoke(); //Updates GetActivitiesPendingApproval

            $scope.$parent.$parent.Variables.serviceCreateSASNote.setInput("Note", $scope.Widgets.formReject.formWidgets.textareaSASNoteReject.datavalue);
            $scope.$parent.$parent.Variables.serviceCreateSASNote.invoke();
        };


        $scope.buttonDialogRejectionSaveClick = function($event, $isolateScope) {
            $scope.Variables.timerLabelFlasher.cancel();
            $scope.Variables.timerLabelFlasher2.cancel();
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
            $scope.$parent.$parent.Variables.serviceUpdateSAS.setInput("ActivityStatusID", 5);
            $scope.$parent.$parent.Variables.serviceUpdateSAS.setInput("BidID", '');
            $scope.$parent.$parent.Variables.serviceUpdateSAS.invoke(); //Updates GetActivitiesPendingApproval

            $scope.Variables.timerLabelFlasher2.cancel();
            if ($scope.Variables.Job1111SettingsData.getData().data.find(x => x.label === 'LooseHoursRoundupCivil').value2 == 1) { //Run only if Global setting is 1
                $scope.Variables.serviceCreateLooseHoursActivities.invoke();
            }
        };


        $scope.dialogAssignTestingQuantitiesOpened = function($event, $isolateScope) {
            $scope.Variables.staticBrightLabel = false;
            $scope.Variables.timerLabelFlasher2.invoke();
        };


        $scope.dialogAssignTestingQuantitiesClose = function($event, $isolateScope) {
            $scope.Variables.serviceUnLockSASActivity.invoke();
            $scope.Variables.timerLabelFlasher2.cancel();
        };

    }
]);