Application.$controller("PartPSRPipePageController", ["$scope", "$rootScope", "DialogService", function($scope, $rootScope, DialogService) {
    "use strict";

    /* perform any action on widgets/variables within this block */
    $scope.onPageReady = function() {

    };


    $rootScope.gridApprovalReviewSelectPipe = function() {
        //Set Filter Switch to Spool1
        $scope.Widgets.switchSpool1Spool2.datavalue = 'Spool1';

        //Set Manual Search Switch to off
        $scope.Widgets.toggleManualSearch.datavalue = '0';

        //Run serviceGetMatches as needed per ActivityType
        switch ($scope.pageParams.ActivityTypeID) {
            case 11:
                if ($scope.pageParams.BidID) {
                    $scope.Variables.staticBidSelectItem.setValue('dataValue', true);
                    $scope.Variables.serviceGetMatches.invoke({
                        "inputFields": {
                            "BidID": $scope.pageParams.BidID
                        }
                    });
                } else {
                    $scope.Variables.staticBidSelectItem.setValue('dataValue', false);
                    $scope.Variables.serviceGetMatches.invoke();
                }
                $scope.Variables.staticATST.setValue('activityType', 'E');
                $scope.Variables.staticATST.setValue('activitySubType', 'PE');
                break;

            case 21:
                if ($scope.pageParams.BidID) {
                    $scope.Variables.staticBidSelectItem.setValue('dataValue', true);
                    $scope.Variables.serviceGetMatches.invoke({
                        "inputFields": {
                            "BidID": $scope.pageParams.BidID
                        }
                    });
                } else {
                    $scope.Variables.staticBidSelectItem.setValue('dataValue', false);
                    $scope.Variables.serviceGetMatches.invoke();
                }
                $scope.Variables.staticATST.setValue('activityType', 'C');
                $scope.Variables.staticATST.setValue('activitySubType', 'BU');
                break;

            case 22:
                $scope.Variables.staticBidSelectItem.setValue('dataValue', false);
                $scope.Variables.serviceGetMatches.invoke();
                $scope.Variables.staticATST.setValue('activityType', 'C');
                $scope.Variables.staticATST.setValue('activitySubType', 'W');
                break;
            case 91:
                $scope.Variables.staticBidSelectItem.setValue('dataValue', false);
                $scope.Variables.serviceGetMatches.invoke();
                $scope.Variables.staticATST.setValue('activityType', 'MISC');
                $scope.Variables.staticATST.setValue('activitySubType', '0');
                break;

            case 41:
            case 42:
            case 43:
                $scope.Variables.staticBidSelectItem.setValue('dataValue', true);
                $scope.Variables.serviceGetMatchesByTestPackage.invoke({
                    "inputFields": {
                        "TestPackage": $scope.pageParams.TestPackage
                    }
                });
                break;

            case 23:
            case 24:
            case 25:
            case 31:
            case 32:
            case 33:
            case 38:
            case 39:
            case 51:
            case 52:
            case 53:
            case 90:
                $scope.Variables.staticBidSelectItem.setValue('dataValue', true);
                $scope.Variables.serviceGetMatches.invoke({
                    "inputFields": {
                        "BidID": $scope.pageParams.BidID
                    }
                });
                break;
        }
    };


    $rootScope.gridApprovalReviewDeselectPipe = function() {
        $scope.Widgets.switchSpool1Spool2.datavalue = 'Spool1';

        $scope.Variables.serviceGetMatches.invoke({
            "inputFields": {
                "BidID": null,
                "LineNumber": null,
                "DrawingNumber": null,
                "SheetNumber": null,
                "ActivityType": null,
                "ActivitySubType": null,
            }
        });
        $scope.Variables.serviceGetMatchesByTestPackage.invoke({
            "inputFields": {
                "TestPackage": 'XNAX'
            }
        });
    };


    $scope.serviceGetMatchesonBeforeUpdate = function(variable, inputData) {
        if (inputData.BidID) {
            return;
        } else {
            if ($scope.Widgets.toggleManualSearch.datavalue == 1) { //Manual Search ON
                if ($scope.Widgets.textLineNumberSearch.datavalue) {
                    inputData.LineNumber = "%" + $scope.Widgets.textLineNumberSearch.datavalue + "%";
                } else {
                    inputData.LineNumber = "%";
                }
                if ($scope.Widgets.textDrawingNumberSearch.datavalue) {
                    inputData.DrawingNumber = "%" + $scope.Widgets.textDrawingNumberSearch.datavalue + "%";
                } else {
                    inputData.DrawingNumber = "%";
                }
                if ($scope.Widgets.textSheetNumberSearch.datavalue) {
                    inputData.SheetNumber = $scope.Widgets.textSheetNumberSearch.datavalue;
                } else {
                    inputData.SheetNumber = "%";
                }
            } else { //Manual Search OFF
                if ($scope.Widgets.toggleFilterLine.datavalue == '1') { //Filter Line ON
                    if ($scope.Widgets.switchSpool1Spool2.datavalue == 'Spool1') {
                        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.Line1) {
                            inputData.LineNumber = "%" + $scope.$parent.Widgets.gridApprovalReview.selecteditem.Line1 + "%";
                        } else {
                            inputData.LineNumber = "%";
                        }
                    } else { //Filter Line OFF
                        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.Line2) {
                            inputData.LineNumber = "%" + $scope.$parent.Widgets.gridApprovalReview.selecteditem.Line2 + "%";
                        } else {
                            inputData.LineNumber = "%";
                        }
                    }
                } else {
                    inputData.LineNumber = "%";
                }

                if ($scope.Widgets.toggleFilterDrawing.datavalue == '1') { //Filter Drawing ON
                    if ($scope.Widgets.switchSpool1Spool2.datavalue == 'Spool1') {
                        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.Drawing1) {
                            inputData.DrawingNumber = "%" + $scope.$parent.Widgets.gridApprovalReview.selecteditem.Drawing1 + "%";
                        } else {
                            inputData.DrawingNumber = "%";
                        }
                    } else {
                        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.Drawing2) { //Filter Drawing OFF
                            inputData.DrawingNumber = "%" + $scope.$parent.Widgets.gridApprovalReview.selecteditem.Drawing2 + "%";
                        } else {
                            inputData.DrawingNumber = "%";
                        }
                    }
                } else {
                    inputData.DrawingNumber = "%";
                }

                if ($scope.Widgets.toggleFilterSheet.datavalue == '1') { //Filter Sheet ON
                    if ($scope.Widgets.switchSpool1Spool2.datavalue == 'Spool1') {
                        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.Sheet1) {
                            inputData.SheetNumber = $scope.$parent.Widgets.gridApprovalReview.selecteditem.Sheet1;
                        } else {
                            inputData.SheetNumber = "%";
                        }
                    } else {
                        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.Sheet2) { //Filter Sheet OFF
                            inputData.SheetNumber = $scope.$parent.Widgets.gridApprovalReview.selecteditem.Sheet2;
                        } else {
                            inputData.SheetNumber = "%";
                        }
                    }
                } else {
                    inputData.SheetNumber = "%";
                }

                // Set ActivityType and ActivitySubType dependent on ActivityTypeID AND Filter Toggle position
                switch ($scope.pageParams.ActivityTypeID) {
                    case 11:
                        if ($scope.Widgets.toggleFilterActivityType.datavalue == '1') {
                            inputData.ActivityType = 'E';
                        } else {
                            inputData.ActivityType = '%';
                        }

                        if ($scope.Widgets.toggleFilterActivitySubType.datavalue == '1') {
                            inputData.ActivitySubType = 'PE';
                        } else {
                            inputData.ActivitySubType = '%';
                        }
                        break;
                    case 21:
                        if ($scope.Widgets.toggleFilterActivityType.datavalue == '1') {
                            inputData.ActivityType = 'C';
                        } else {
                            inputData.ActivityType = '%';
                        }

                        if ($scope.Widgets.toggleFilterActivitySubType.datavalue == '1') {
                            inputData.ActivitySubType = 'BU';
                        } else {
                            inputData.ActivitySubType = '%';
                        }
                        break;
                    case 22:
                        if ($scope.Widgets.toggleFilterActivityType.datavalue == '1') {
                            inputData.ActivityType = 'C';
                        } else {
                            inputData.ActivityType = '%';
                        }

                        if ($scope.Widgets.toggleFilterActivitySubType.datavalue == '1') {
                            inputData.ActivitySubType = 'W';
                        } else {
                            inputData.ActivitySubType = '%';
                        }
                        break;
                    case 91:
                        if ($scope.Widgets.toggleFilterActivityType.datavalue == '1') {
                            inputData.ActivityType = 'MISC';
                        } else {
                            inputData.ActivityType = '%';
                        }

                        if ($scope.Widgets.toggleFilterActivitySubType.datavalue == '1') {
                            inputData.ActivitySubType = '0';
                        } else {
                            inputData.ActivitySubType = '%';
                        }
                        break;
                }
            }
        }
    };


    $scope.buttonDetail1Click = function($event, $isolateScope) {
        $scope.Variables.liveGetActivityDetails.listRecords({
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
        switch ($scope.pageParams.ActivityTypeID) {
            case 41:
            case 42:
            case 43:
                $scope.$parent.Variables.navigationToClassicPipe.setData({
                    'PageLoadTestPackage': $scope.pageParams.TestPackage,
                    'PageLoadFiltered': true
                });
                $scope.$parent.Variables.navigationToClassicPipe.invoke();
                break;
            default:
                if ($scope.Variables.staticBidSelectItem.dataValue) {
                    $scope.$parent.Variables.navigationToClassicPipe.setData({
                        'PageLoadBidID': $scope.pageParams.BidID,
                        'PageLoadFiltered': true
                    });
                    $scope.$parent.Variables.navigationToClassicPipe.invoke();
                } else if ($scope.Widgets.switchSpool1Spool2.datavalue == 'Spool2') {
                    $scope.$parent.Variables.navigationToClassicPipe.setData({
                        'PageLoadDrawing': $scope.$parent.Widgets.gridApprovalReview.selecteditem.Drawing2,
                        'PageLoadSheet': $scope.$parent.Widgets.gridApprovalReview.selecteditem.Sheet2,
                        'PageLoadFiltered': true
                    });
                    $scope.$parent.Variables.navigationToClassicPipe.invoke();
                } else {
                    $scope.$parent.Variables.navigationToClassicPipe.setData({
                        'PageLoadDrawing': $scope.$parent.Widgets.gridApprovalReview.selecteditem.Drawing1,
                        'PageLoadSheet': $scope.$parent.Widgets.gridApprovalReview.selecteditem.Sheet1,
                        'PageLoadFiltered': true
                    });
                    $scope.$parent.Variables.navigationToClassicPipe.invoke();
                }
                break;
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


    $scope.toggleManualSearchChange = function($event, $isolateScope, newVal, oldVal) {
        if (newVal === 0) {
            $scope.gridApprovalReviewSelectPipe();
        }
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


    $scope.timerLabelFlasher2onTimerFire = function(variable, data) { //Fired from Assign Testing Dialog On Open
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 41) {
            if ($scope.Widgets.textReadyForTestHrsEarned.datavalue > $scope.Widgets.labelRFTHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelRFTHoursRemaining.fontsize = '';
                    $scope.Widgets.labelRFTHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelRFTHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelRFTHoursRemaining.padding = '';
                    $scope.Widgets.labelRFTHoursRemaining.color = '';
                    $scope.Widgets.labelRFTHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelRFTHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelRFTHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelRFTHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelRFTHoursRemaining.padding = "1%";
                    $scope.Widgets.labelRFTHoursRemaining.color = 'black';
                    $scope.Widgets.labelRFTHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 42) {
            if ($scope.Widgets.textHydroHrsEarned.datavalue > $scope.Widgets.labelHydroHoursRemaining.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelHydroHoursRemaining.fontsize = '';
                    $scope.Widgets.labelHydroHoursRemaining.borderstyle = '';
                    $scope.Widgets.labelHydroHoursRemaining.bordercolor = '';
                    $scope.Widgets.labelHydroHoursRemaining.padding = '';
                    $scope.Widgets.labelHydroHoursRemaining.color = '';
                    $scope.Widgets.labelHydroHoursRemaining.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelHydroHoursRemaining.fontsize = "16";
                    $scope.Widgets.labelHydroHoursRemaining.borderstyle = "solid";
                    $scope.Widgets.labelHydroHoursRemaining.bordercolor = "#fffd00";
                    $scope.Widgets.labelHydroHoursRemaining.padding = "1%";
                    $scope.Widgets.labelHydroHoursRemaining.color = 'black';
                    $scope.Widgets.labelHydroHoursRemaining.backgroundcolor = 'red';
                    $scope.Variables.staticBrightLabel = false; //Set false for next timer fire
                }
            }
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 43) {
            if ($scope.Widgets.textClientTurnoverHrsEarned.datavalue > $scope.Widgets.labelClientTurnoverHoursRemainin.caption) {
                if ($scope.Variables.staticBrightLabel === false) {
                    //console.log("Normal" + $scope.Widgets.textHrsEarned.datavalue);
                    $scope.Widgets.labelClientTurnoverHoursRemainin.fontsize = '';
                    $scope.Widgets.labelClientTurnoverHoursRemainin.borderstyle = '';
                    $scope.Widgets.labelClientTurnoverHoursRemainin.bordercolor = '';
                    $scope.Widgets.labelClientTurnoverHoursRemainin.padding = '';
                    $scope.Widgets.labelClientTurnoverHoursRemainin.color = '';
                    $scope.Widgets.labelClientTurnoverHoursRemainin.backgroundcolor = '';
                    $scope.Variables.staticBrightLabel = true; //Set true for next timer fire
                } else {
                    //console.log("Bright");
                    $scope.Widgets.labelClientTurnoverHoursRemainin.fontsize = "16";
                    $scope.Widgets.labelClientTurnoverHoursRemainin.borderstyle = "solid";
                    $scope.Widgets.labelClientTurnoverHoursRemainin.bordercolor = "#fffd00";
                    $scope.Widgets.labelClientTurnoverHoursRemainin.padding = "1%";
                    $scope.Widgets.labelClientTurnoverHoursRemainin.color = 'black';
                    $scope.Widgets.labelClientTurnoverHoursRemainin.backgroundcolor = 'red';
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
            $scope.Variables.timerLabelFlasher2.cancel();
        };

    }
]);


Application.$controller("dialogFieldActivityDetailsController", ["$scope",
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
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.ActivityStatus = '5';
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.BidID = '';
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.invoke();
            $scope.Variables.timerLabelFlasher2.cancel();
            if ($scope.$parent.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 41 && $scope.$parent.$parent.Widgets.gridApprovalReview.selecteditem.Sheet1 != '1') {
                //NOTE: I'm using Sheet1 variable to pass in TestingRework Value of 0 or 1  this is handled within the Job1111.GetActivitiesPendingApproval query
                $scope.Variables.serviceCreateLooseHoursActivities.invoke();
            }
        };


        $scope.dialogAssignTestingQuantitiesOpened = function($event, $isolateScope) {
            $scope.Variables.staticBrightLabel = false;
            $scope.Variables.timerLabelFlasher2.invoke();
        };


        $scope.buttonDialogAssignTestCancelClick = function($event, $isolateScope) {
            $scope.Variables.timerLabelFlasher2.cancel();
        };

    }
]);

Application.$controller("Table1Controller", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;
    }
]);