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
        //Set Manual Search Switch to off
        $scope.Widgets.toggleManualSearch.datavalue = '0';
        //Get Matches
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 72) {
            $scope.Variables.serviceGetBidActivityMatchesByTestPackage.invoke();
        } else {
            $scope.Variables.serviceGetMatches.invoke();
        }

    };


    $rootScope.gridApprovalReviewDeselectCivil = function() {
        $scope.Variables.serviceGetMatches.setInput('BidID', "");
        $scope.Variables.serviceGetMatches.setInput('Foundation', "");
        $scope.Variables.serviceGetMatches.setInput('DrawingNumber', "");
        $scope.Variables.serviceGetMatches.setInput('DetailDrawingNumber', "");
        $scope.Variables.serviceGetMatches.invoke();
    };


    $scope.toggleManualSearchChange = function($event, $isolateScope, newVal, oldVal) {
        if (newVal === 0) {
            $scope.Variables.serviceGetMatches.invoke();
        }
    };


    $scope.serviceGetMatchesonBeforeUpdate = function(variable, data) {
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 70 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 71) {
            data.BidID = $scope.$parent.Widgets.gridApprovalReview.selecteditem.Spool2;
            data.Foundation = "";
            data.DrawingNumber = "";
            data.DetailDrawingNumber = "";
        } else if ($scope.Widgets.toggleManualSearch.datavalue == 1) {
            if ($scope.Widgets.textFoundationSearch.datavalue) {
                data.Foundation = "%" + $scope.Widgets.textFoundationSearch.datavalue + "%";
            } else {
                data.Foundation = "%";
            }

            if ($scope.Widgets.textDrawingNumberSearch.datavalue) {
                data.DrawingNumber = "%" + $scope.Widgets.textDrawingNumberSearch.datavalue + "%";
            } else {
                data.DrawingNumber = "%";
            }

            if ($scope.Widgets.textDetailDrawingNumberSearch.datavalue) {
                data.DetailDrawingNumber = "%" + $scope.Widgets.textDetailDrawingNumberSearch.datavalue + "%";
            } else {
                data.DetailDrawingNumber = "%";
            }

            if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 77) { //Option 77 not in use yet...  12-29-16
                data.Foundation = "%";
                if ($scope.Widgets.textDrawingNumberSearch.datavalue) {
                    data.DrawingNumber = "%" + $scope.Widgets.textDrawingNumberSearch.datavalue + "%";
                } else {
                    data.DrawingNumber = "%";
                }

                if ($scope.Widgets.textDetailDrawingNumberSearch.datavalue) {
                    data.DetailDrawingNumber = "%" + $scope.Widgets.textDetailDrawingNumberSearch.datavalue + "%";
                } else {
                    data.DetailDrawingNumber = "%";
                }
                data.BidActivityType = "D";

            }
        } else {
            if ($scope.Widgets.toggleFilterFoundation.datavalue == '1') {
                data.Foundation = "%" + $scope.$parent.Widgets.gridApprovalReview.selecteditem.Spool1 + "%";
            } else {
                data.Foundation = "%";
            }

            if ($scope.Widgets.toggleFilterDrawingNumber.datavalue == '1') {
                data.DrawingNumber = "%" + $scope.$parent.Widgets.gridApprovalReview.selecteditem.Line1 + "%";
            } else {
                data.DrawingNumber = "%";
            }

            if ($scope.Widgets.toggleFilterDrawingDetailNumber.datavalue == '1') {
                data.DetailDrawingNumber = "%" + $scope.$parent.Widgets.gridApprovalReview.selecteditem.Drawing1 + "%";
            } else {
                data.DetailDrawingNumber = "%";
            }
        }
    };


    $scope.serviceLockSSActivityonBeforeUpdate = function(variable, inputData) {
        //Invoke here because "update on change" in gui doesn't work if NEXT bid match selected is the SAME BidID as current
        $scope.Variables.serviceGetBidActivityQuantities.invoke();
    };



    $scope.serviceLockSSActivityonResult = function(variable, data) {
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType != 72 && data[0].ReturnStatus) {
            DialogService.open('dialogAssignQuantities', $scope);
        } else if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 72 && data[0].ReturnStatus) {
            DialogService.open('dialogAssignTestingQuantities', $scope);
        } else {
            //console.log("Field Activity is Locked by other user.");
            DialogService.open('alertRecordLocked', $scope.$parent);
        }
    };


    $scope.buttonDetail1Click = function($event, $isolateScope) {
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 70 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 71) {
            $scope.Variables.liveCivilFA.listRecords();
        }
    };


    $scope.buttonResearchClick = function($event, $isolateScope) {
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 70 || $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 71) {
            $scope.$parent.Variables.navigationToClassicCivil.setData({
                'PageLoadBidID': parseInt($scope.$parent.Widgets.gridApprovalReview.selecteditem.Spool2),
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.$parent.Variables.navigationToClassicCivil.invoke();
        }
        if ($scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityType == 97) {
            $scope.$parent.Variables.navigationToClassicCivil.setData({
                'PageLoadBidID': '',
                'PageLoadFiltered': true
            });
            //Fire Nav Call
            $scope.$parent.Variables.navigationToClassicCivil.invoke();
        }
    };


    $scope.serviceGetBidActivityMatchesByTestPackageonBeforeUpdate = function(variable, inputData) {
        inputData.TestPackage = $scope.$parent.Widgets.gridApprovalReview.selecteditem.Line1;
    };


    $scope.buttonReviewNotes1Click = function($event, $isolateScope) {
        $scope.$parent.Variables.serviceGetNotesByFieldActivityID.dataBinding.ActivityID = $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID;
        $scope.$parent.Variables.serviceGetNotesByFieldActivityID.invoke();
        DialogService.open('dialogNotes', $scope.$parent);
    };


    $scope.buttonReviewNotes2Click = function($event, $isolateScope) {
        $scope.$parent.Variables.serviceGetNotesByFieldActivityID.dataBinding.ActivityID = $scope.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID;
        $scope.$parent.Variables.serviceGetNotesByFieldActivityID.invoke();
        DialogService.open('dialogNotes', $scope.$parent);
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

}]);


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


Application.$controller("dialogAssignQuantitiesController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.buttonQuantitiesUpdateClick = function($event, $isolateScope) {
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.ActivityStatus = '5';
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.ActivityID = $scope.$parent.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID;
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.BidID = $scope.Widgets.livelistBidActivities.selecteditem.BidID;
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.invoke();
            $scope.Variables.timerLabelFlasher.cancel();
        };



        $scope.dialogAssignQuantitiesOpened = function($event, $isolateScope) {
            $scope.Variables.staticBrightLabel = false;
            $scope.Variables.timerLabelFlasher.invoke();
        };


        $scope.buttonDialogAssignCancelClick = function($event, $isolateScope) {
            $scope.Variables.timerLabelFlasher.cancel();
        };
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
            $scope.Variables.serviceCreateLooseHoursActivities.invoke();
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


Application.$controller("dialogRejectionController", ["$scope",
    function($scope) {
        "use strict";
        $scope.ctrlScope = $scope;

        $scope.formRejectSubmit = function($event, $isolateScope, $formData) {
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.ActivityStatus = '6';
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.ActivityID = $scope.$parent.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID;
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.dataBinding.BidID = $scope.Widgets.livelistBidActivities.selecteditem.BidID;
            $scope.$parent.$parent.Variables.serviceUpdateSSApproval.invoke(); //Updates GetActivitiesPendingApproval

            $scope.$parent.$parent.Variables.serviceCreateSSNote.dataBinding.ActivityID = $scope.$parent.$parent.Widgets.gridApprovalReview.selecteditem.ActivityID;
            $scope.$parent.$parent.Variables.serviceCreateSSNote.dataBinding.CreatedBy = $scope.Variables.loggedInUser.dataSet.id;
            $scope.$parent.$parent.Variables.serviceCreateSSNote.dataBinding.Note = $scope.Widgets.textareaSSNoteReject.datavalue;
            $scope.$parent.$parent.Variables.serviceCreateSSNote.invoke(); //Updates GetNotesByFieldActivityID
        };


        $scope.textareaSSNoteRejectKeyup = function($event, $isolateScope) {
            if ((Date.now() - $scope.Variables.staticVariableMachineStateTimer.dataValue) > 300) {
                $scope.Variables.staticVariableMachineStateTimer.dataValue = Date.now();
                $scope.Widgets.labelRejectTextCount.caption = 252 - $scope.Widgets.textareaSSNoteReject.datavalue.length;
            }
        };


        $scope.buttonDialogRejectionSaveClick = function($event, $isolateScope) {
            $scope.Variables.timerLabelFlasher.cancel();
        };

    }
]);